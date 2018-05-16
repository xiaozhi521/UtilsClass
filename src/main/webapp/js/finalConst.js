/**
 *  获取常量的方法：
 *  	Const.getConstant("MILLISEC");
 */

var Const = (function() {
	var constants = {//定义常量
		MILLISEC : 500,
		COUNT_DOWN:60,
	}
	var Test = {};
	// 定义了一个静态方法
	Test.getConstant = function(name) {//获取常量的方法
		return constants[name];
	}
	return Test;
})();
