/**
 * 1.length : 数组的长度
 * 2.isArray() ： Array.isArray()判断一个值是否为数组。它可以弥补typeof运算符的不足。
 * 3.valueOf() : 返回数组本身。
 * 4.toString() : 返回数组的字符串形式。数组内包含Object类型的数据会返回[Object,Object]
 * 5.push() : 在数组的末端添加一个或多个元素，并返回添加新元素后的数组长度。---------------注意，该方法会改变原数组。
 * 			等同于  arr1.push.call(arr1,arr2) == arr1.push(arr2);
 * 			Array.prototype.push.apply(arr1,arr2)  若使用apply  arr1 和 arr2 两个参数只能是数组对象
 * 6.pop() : 用于删除数组的最后一个元素，并返回该元素。---------------注意，该方法会改变原数组。
 * 7.join() :以参数作为分隔符，将所有数组成员组成一个字符串返回。如果不提供参数，默认用逗号分隔。
 * 8.concat() : 用于多个数组的合并。它将新数组的成员，添加到原数组的尾部，然后返回一个新数组，原数组不变。
 * 9.shift() : 用于删除数组的第一个元素，并返回该元素。注意，该方法会改变原数组。
 * 10.unshift() : 用于在数组的第一个位置添加元素，并返回添加新元素后的数组长度。---------------注意，该方法会改变原数组。
 * 11.reverse() : 用于颠倒数组中元素的顺序，返回改变后的数组。---------------注意，该方法会改变原数组。
 * 12.slice() : 用于提取原数组的一部分，返回一个新数组，原数组不变。
 * 13.splice() : 方法用于删除原数组的一部分成员，并可以在被删除的位置添加入新的数组成员，返回值是被删除的元素。注意，该方法会改变原数组。
 * 				splice的第一个参数是删除的起始位置，第二个参数是被删除的元素个数。如果后面还有更多的参数，则表示这些就是要被插入数组的新元素。
 * 				起始位置如果是负数，就表示从倒数位置开始删除。
 * 					var a = ['a', 'b', 'c', 'd', 'e', 'f'];
 * 					a.splice(-4, 2) // ["c", "d"]
 * 				如果只是单纯地插入元素，splice方法的第二个参数可以设为0。
 * 					var a = [1, 1, 1];
 * 					a.splice(1, 0, 2) // []
 * 					a // [1, 2, 1, 1]
 * 				如果只提供第一个参数，等同于将原数组在指定位置拆分成两个数组。
 * 					var a = [1, 2, 3, 4];
 * 					a.splice(2) // [3, 4]
 * 					a // [1, 2]	
 * 14.sort() : 方法对数组成员进行排序，默认是按照字典顺序排序。排序后，原数组将被改变。
 * 15.map() : 方法对数组的所有成员依次调用一个函数，根据函数结果返回一个新数组。
 * 16.forEach() : 方法与map方法很相似，也是遍历数组的所有成员，执行某种操作，但是forEach方法一般不返回值，只用来操作数据。如果需要有返回值，一般使用map方法。
 * 				  forEach方法的参数与map方法一致，也是一个函数，数组的所有成员会依次执行该函数。它接受三个参数，分别是当前位置的值、当前位置的编号和整个数组。
 */
(function(window){
	var ArrayUtil = {
		/**
		 * 获取数组的长度
		 * @param {Object} array	数组
		 */
		length : function(array){
			return this.isArray(array) ? array.length : "不是数组";
		},
		/**
		 * 一个值是否为数组
		 * @param {Object} array	数组
		 */
		isArray : function(array){
			return Array.isArray(array) ? true : false;
		},
		/**
		 * 返回数组本身
		 * @param {Object} array	数组
		 */
		valueOf : function(array){
			return this.isArray(array) ? array.valueOf() : "不是数组";
		},
		/**
		 * 返回数组的字符串形式。数组内包含Object类型的数据会返回[Object,Object]
		 * @param {Object} array	数组
		 */
		toString : function(array){
			return this.isArray(array) ? array.toString() : "不是数组";
		},
		/**
		 * 在数组的末端添加一个或多个元素，并返回添加新元素后的数组长度。注意，该方法会改变原数组。
		 * @param {Object} arr1	数组1
		 * @param {Object} arr2	数组或者是字符
		 */
		push : function(arr1,arr2){
			return arr1.push(arr2) ? true : false;
		},
		pushCall : function(arr1,arr2){
			return Array.prototype.push.call(arr1,arr2) ? true : false;
		},
		/**
		 * 用于删除数组的最后一个元素，并返回该元素。注意，该方法会改变原数组。
		 * @param {Object} array	数组
		 */
		pop : function(array){
			return array.pop() ? true : false;
		},
		popCall : function(array){
			return Array.prototype.pop.call(array) ? true : false;
		},
		popApply : function(array){
			return Array.prototype.pop.apply(array) ? true : false;
		},
		/**
		 * 以参数作为分隔符，将所有数组成员组成一个字符串返回。如果不提供参数，默认用逗号分隔。
		 * @param {Object} array	数组
		 * @param {Object} param	分割的原则
		 */
		join : function(array,param){
			return param ? array.join(param) : array.join();
		},
		joinCall : function(array,param){
			return param ? Array.prototype.join.call(array,param) : Array.prototype.join.call(array);
		},
		/**
		 * 用于多个数组的合并。它将新数组的成员，添加到原数组的尾部，然后返回一个新数组，原数组不变。
		 * @param {Object} arr1	数组
		 * @param {Object} arr2	要添加的数组格式[ [1],[2],[3],[4] ]
		 */
		concat : function(arr1,arr2){
			return arr1.concat(arr2);
		},
		concatCall : function(arr1,arr2){
			$.each(arr2, function(i, m) {
				arr1 = Array.prototype.concat.call(arr1,m);
			});
			return arr1;
		},
		concatApply : function(arr1,arr2){
			$.each(arr2, function(i, m) {
				arr1 = Array.prototype.concat.call(arr1,m);
			});
			return arr1;
		},
		/**
		 * 用于删除数组的第一个元素，并返回该元素。注意，该方法会改变原数组。
		 * @param {Object} array	数组
		 */
		shift : function(array){
			return array.shift();
		},
		shiftCall : function(array){
			return Array.prototype.shift.call(array);
		},
		shiftApply : function(array){
			return Array.prototype.shift.apply(array);
		},
		/**
		 * 用于在数组的第一个位置添加元素，并返回添加新元素后的数组长度。注意，该方法会改变原数组
		 * @param {Object} arr1	数组
		 * @param {Object} arr2	
		 * unshift，unshiftCall  方法会将字符串添加的arr1中   如果arr2传递的是[]格式，会将[]传递到arr1中
		 * unshiftApply  只接受数组参数，如果不是数组会报错，传递的数组会转化为String添加到arr1数组的头部
		 */
		unshift : function(arr1,str){
			return arr1.unshift(str);
		},
		unshiftCall : function(arr1,str){
			Array.prototype.unshift.call(array,str);
		},
		unshiftApply : function(arr1,arr2){
			Array.prototype.unshift.apply(array,arr2);
		},
		/**
		 * 用于颠倒数组中元素的顺序，返回改变后的数组。---------------注意，该方法会改变原数组。
		 * @param {Object} array	数组
		 * @return 返回反转后的数组
		 */
		reverse : function(array){
			return array.reverse();
		},
		reverseCall : function(array){
			return Array.prototype.reverse.call(array);
		},
		reverseApply : function(array){
			return Array.prototype.reverse.apply(array);
		},
		/**
		 * 用于提取原数组的一部分，返回一个新数组，原数组不变。
		 * @param {Object} array	数组
		 * @param {Object} startIndex	开始截取的位置
		 * @param {Object} uptpIndex	结束截取的位置
		 * @return 返回一个新数组
		 */
		slice : function(array,startIndex,uptpIndex){
			return uptpIndex ? array.slice(startIndex, uptpIndex) : array.slice(startIndex);
		},
		slice : function(array,startIndex,uptpIndex){
			return uptpIndex ? Array.prototype.slice.call(array,startIndex,uptpIndex) : Array.prototype.slice.call(array,startIndex);
		},
		/**
		 * 用于删除原数组的一部分成员，并可以在被删除的位置添加入新的数组成员，返回值是被删除的元素。注意，该方法会改变原数组。
		 * @param {Object} array	数组
		 * @param {Object} index	开始删除的位置
		 * @param {Object} count	删除的长度
		 * @param {Object} addEle	需要添加的数组成员
		 * @return 返回一个新数组
		 */
		splice : function(array,index,count,addEle){
			if(addEle){
				return array.splice(index,count,addEle);
			}else{
				if(count){
					return array.splice(index,count);
				}else{
					return array.splice(index);
				}
			}
		},
		//error
		spliceCall : function(array,index,count,addEle){
			return addEle ? Array.prototype.splice.call(array,index,count,addEle) : count ? Array.prototype.splice.call(array,index,count) : Array.prototype.splice.call(array,index);
//			if(addEle){
//				return Array.prototype.splice.call(array,index,count,addEle);
//			}else{
//				if(count){
//					return Array.prototype.splice.call(array,index,count);
//				}else{
//					return Array.prototype.splice.call(array,index);
//				}
//			}
		},
		/**
		 * 对数组成员进行排序，默认是按照字典顺序排序。排序后，原数组将被改变。
		 * @param {Object} array	数组
		 * @return 返回一个新数组
		 */
		sort : function(array){
			return array.sort();
		},
		sortCall : function(array){
			return Array.prototype.sort.call(array);
		},
		sortApply : function(array){
			return Array.prototype.sort.apply(array);
		},
		map : function(){
			
		},
		forEach : function(array){
//			array.forEach(function(arr,index,array){
//				console.log("["+index+"] = "+arr);
//			});
		}
	};
}(window));