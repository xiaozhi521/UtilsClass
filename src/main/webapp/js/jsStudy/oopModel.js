/**
 *模块是实现特定功能的一组属性和方法的封装。
 * 只要把不同的函数（以及记录状态的变量）简单地放在一起，就算是一个模块。
 * 缺点：”污染”了全局变量，无法保证不与其他模块发生变量名冲突，而且模块成员之间看不出直接关系。 
 * 解决办法 ： 可以把模块写成一个对象，所有的模块成员都放到这个对象里面
 * 模块对象的缺点：这样的写法会暴露所有模块成员，内部状态可以被外部改写。比如，外部代码可以直接改变内部计数器的值。
 */
/**
 * 3.1基本的实现方法
 * 模块是实现特定功能的一组属性和方法的封装。
 * 只要把不同的函数（以及记录状态的变量）简单地放在一起，就算是一个模块。
 */
function m1() {
  //...
}

function m2() {
  //...
}
/**
 *上面的函数m1()和m2()，组成一个模块。使用的时候，直接调用就行了。
 * 这种做法的缺点很明显：”污染”了全局变量，无法保证不与其他模块发生变量名冲突，而且模块成员之间看不出直接关系。
 * 为了解决上面的缺点，可以把模块写成一个对象，所有的模块成员都放到这个对象里面。
 */
var module1 = new Object({
	_count : 0,
	m1 : function(){},
	m2 : function(){}
});
/**
 * 上面的函数m1和m2，都封装在module1对象里。使用的时候，就是调用这个对象的属性。
 */
module1.m1();
/**
 * 但是，这样的写法会暴露所有模块成员，内部状态可以被外部改写。比如，外部代码可以直接改变内部计数器的值。
 */


module1._count = 5;
/**
 * 3.2封装私有变量：构造函数的写法
 * 我们可以利用构造函数，封装私有变量。
 */
function StringBuilder() {
  var buffer = [];

  this.add = function (str) {
     buffer.push(str);
  };

  this.toString = function () {
    return buffer.join('');
  };

}
/**
 * 这种方法将私有变量封装在构造函数中，违反了构造函数与实例对象相分离的原则。并且，非常耗费内存。
 */
function StringBuilder() {
  this._buffer = [];
}

StringBuilder.prototype = {
  constructor: StringBuilder,
  add: function (str) {
    this._buffer.push(str);
  },
  toString: function () {
    return this._buffer.join('');
  }
};
/**
 * 这种方法将私有变量放入实例对象中，好处是看上去更自然，但是它的私有变量可以从外部读写，不是很安全。
 */
/**
 *3.3 封装私有变量：立即执行函数的写法
 * 使用“立即执行函数”（Immediately-Invoked Function Expression，IIFE），将相关的属性和方法封装在一个函数作用域里面，可以达到不暴露私有成员的目的。
 */



var module2 = (function () {
	var _count = 0;
	var m1 = function(){
		//...
	};
	var m2 = function(){};
	return {
		m1 : m1,
		m2 : m2
	};
})();
/**
 * 使用上面的写法，外部代码无法读取内部的_count变量。
 */
console.info(module2._count); //undefined
/**
 * 上面的module1就是JavaScript模块的基本写法。下面，再对这种写法进行加工。
 */
/**
 * 3.4模块的放大模式
 * 如果一个模块很大，必须分成几个部分，或者一个模块需要继承另一个模块，这时就有必要采用“放大模式”（augmentation）。
 */



var module3 = (function (mod){
	mod.m3 = function(){};
	return mod;
})(module1);
/**
 * 上面的代码为module1模块添加了一个新方法m3()，然后返回新的module1模块。
 * 在浏览器环境中，模块的各个部分通常都是从网上获取的，有时无法知道哪个部分会先加载。
 * 如果采用上面的写法，第一个执行的部分有可能加载一个不存在空对象，这时就要采用”宽放大模式”（Loose augmentation）。
 */




var module1 = ( function (mod){
	return mod;
})(window.module1 || {});
/**
 * 与”放大模式”相比，“宽放大模式”就是“立即执行函数”的参数可以是空对象。
 */

/**
 * 3.5输入全局变量
 * 独立性是模块的重要特点，模块内部最好不与程序的其他部分直接交互。
 * 为了在模块内部调用全局变量，必须显式地将其他变量输入模块。
 */
var module1 = (function ($, YAHOO) {
})(jQuery, YAHOO);
/**
 * 上面的module1模块需要使用jQuery库和YUI库，就把这两个库（其实是两个模块）当作参数输入module1。这样做除了保证模块的独立性，还使得模块之间的依赖关系变得明显。
 * 立即执行函数还可以起到命名空间的作用。
 */
(function($, window, document) {

  function go(num) {}

  function handleEvents() {}

  function initialize() {}

  function dieCarouselDie() {}

  //attach to the global scope
  window.finalCarousel = {
    init : initialize,
    destroy : dieCouraselDie
  }
})(jQuery, window, document );
/**
 * 上面代码中，finalCarousel对象输出到全局，对外暴露init和destroy接口，内部方法go、handleEvents、initialize、dieCarouselDie都是外部无法调用的。
 */
