/**
 * 1.isString()  是否是字符串
 * 2.length() : 字符串长度
 * 3.charAt() : 返回指定位置的字符，参数是从0开始编号的位置。如果参数为负数，或大于等于字符串的长度，charAt返回空字符串
 * 4.concat() : 连接两个字符串，返回一个新字符串，不改变原字符串。
 * 5.slice() : 用于从原字符串取出子字符串并返回，不改变原字符串。它的第一个参数是子字符串的开始位置，第二个参数是子字符串的结束位置（不含该位置）.
 * 			如果参数是负值，表示从结尾开始倒数计算的位置，即该负值加上字符串长度。
 * 			如果第一个参数大于第二个参数，slice方法返回一个空字符串。
 * 6.substr() : 从原字符串取出子字符串并返回，不改变原字符串.第一个参数是子字符串的开始位置，第二个参数是子字符串的长度
 * 			如果省略第二个参数，则表示子字符串一直到原字符串的结束。
 * 			如果第一个参数是负数，表示倒数计算的字符位置。如果第二个参数是负数，将被自动转为0，因此会返回空字符串。
 * 7.indexOf()，lastIndexOf() : 这两个方法用于确定一个字符串在另一个字符串中的位置，都返回一个整数，表示匹配开始的位置。
 * 							    如果返回-1，就表示不匹配。两者的区别在于，indexOf从字符串头部开始匹配，lastIndexOf从尾部开始匹配。
 * 							  第二个参数，对于indexOf方法，第二个参数表示从该位置开始向后匹配；对于lastIndexOf，第二个参数表示从该位置起向前匹配
 * 8.trim() : 去除字符串两端的空格，返回一个新字符串，不改变原字符串。
 * 9.toLowerCase() : 用于将一个字符串全部转为小写
 * 10.toUpperCase() : 用于将一个字符串全部转为大写
 * 11.match() : 用于确定原字符串是否匹配某个子字符串，返回一个数组，成员为匹配的第一个字符串。如果没有找到匹配，则返回null。
 * 12.search() : 用法等同于match，但是返回值为匹配的第一个位置。如果没有找到匹配，则返回-1。
 * 13.replace() : 用于替换匹配的子字符串，一般情况下只替换第一个匹配（除非使用带有g修饰符的正则表达式）。
 * 14.split() : 按照给定规则分割字符串，返回一个由分割出来的子字符串组成的数组。
 * 			  'a|b|c'.split('|') // ["a", "b", "c"]
 * 		1、 如果分割规则为空字符串，则返回数组的成员是原字符串的每一个字符。
 * 			'a|b|c'.split('') // ["a", "|", "b", "|", "c"]
 * 		2、 如果省略参数，则返回数组的唯一成员就是原字符串。
 * 			'a|b|c'.split() // ["a|b|c"]
 * 		3、如果满足分割规则的两个部分紧邻着（即中间没有其他字符），则返回数组之中会有一个空字符串。
 * 			'a||c'.split('|') // ['a', '', 'c']
 * 		4、如果满足分割规则的部分处于字符串的开头或结尾（即它的前面或后面没有其他字符），则返回数组的第一个或最后一个成员是一个空字符串。
 * 			'|b|c'.split('|') // ["", "b", "c"]
 * 			'a|b|'.split('|') // ["a", "b", ""]
 * 		5、split方法还可以接受第二个参数，限定返回数组的最大成员数。
 * 			'a|b|c'.split('|', 0) // []
 * 			'a|b|c'.split('|', 1) // ["a"]
 */
(function(window) {
	var StringUtil = {
		length : function(str) {
			return this.isString(str) ? str.length : "不是字符串";
		},
		/**
		 * 返回指定位置的字符，参数是从0开始编号的位置。如果参数为负数，或大于等于字符串的长度，charAt返回空字符串
		 * @param {Object} str  字符串
		 * @param {Object} i	字符位置
		 */
		charAt : function(str, i) {
			return this.isString(str) ? str.charAt(i) : "未获取到字符";
		},
		/**
		 * 连接两个字符串，返回一个新字符串，不改变原字符串。
		 * @param {Object} str1    字符串1
		 * @param {Object} str2    字符串2
		 */
		concat : function(str1, str2) {
			return str1.concat(str2);
		},
		/**
		 * 用于从原字符串取出子字符串并返回
		 * @param {Object} str   要提取的字符串
		 * @param {Object} index1	子字符串的开始位置
		 * @param {Object} index2	子字符串的结束位置（不含该位置）
		 */
		slice : function(str, index1, index2) {
			return str.slice(index1, index2 ? index2 : this.length(str));
		},
		/**
		 * 从原字符串取出子字符串并返回，不改变原字符串.
		 * @param {Object} str	原字符串
		 * @param {Object} index1	子字符串的开始位置
		 * @param {Object} index2	子字符串的长度
		 */
		substr : function(str, index1, index2) {
			return str.substr(index1, index2 ? index2 : this.length(str));
		},
		/**
		 * 确定一个字符串在另一个字符串中的位置，返回一个整数
		 * @param {Object} str1		源字符串
		 * @param {Object} str2		要匹配的字符串
		 * @param {Object} index	从该位置开始向后匹配
		 */
		indexOf : function(str1, str2, index) {
			return str1.indexOf(str2, index ? index : 0);
		},
		/**
		 * 确定一个字符串在另一个字符串中的位置，返回一个整数
		 * @param {Object} str1		源字符串
		 * @param {Object} str2		要匹配的字符串
		 * @param {Object} index	从该位置开始向前匹配
		 */
		lastIndexOf : function(str, index) {
			return str1.lastIndexOf(str2, index ? index : 0);
		},
		/**
		 * 去除字符串两端的空格，返回一个新字符串，不改变原字符串。
		 * @param {Object} str  源字符串
		 */
		trim : function(str) {
			return str.trim();
		},
		/**
		 * 用于将一个字符串全部转为小写
		 * @param {Object} str	源字符串
		 */
		toLowerCase : function(str) {
			return str.toLowerCase();
		},
		/**
		 * 用于将一个字符串全部转为大写
		 * @param {Object} str	源字符串
		 */
		toUpperCase : function(str) {
			return str.toUpperCase();
		},
		/**
		 * 用于确定原字符串是否匹配某个子字符串，返回一个数组，成员为匹配的第一个字符串。如果没有找到匹配，则返回null。
		 * @param {Object} str1		源字符串
		 * @param {Object} str2		要匹配的字符串
		 */
		match : function(str1, str2) {
			return str1.match(str2);
		},
		/**
		 * 法等同于match，但是返回值为匹配的第一个位置。如果没有找到匹配，则返回-1。
		 * @param {Object} str		源字符串
		 * @param {Object} str2		要匹配的字符串
		 */
		search : function(str1, str2) {
			return str.search(str2);
		},
		/**
		 * 用于替换匹配的子字符串，一般情况下只替换第一个匹配（除非使用带有g修饰符的正则表达式）。
		 * @param {Object} str  	源字符串
		 * @param {Object} repStr	需要替换的字符串
		 * @param {Object} reg		替换后的字符
		 */
		replace : function(str, repStr, reg) {
			return str.replace(repStr, reg);
		},
		/**
		 * 按照给定规则分割字符串，返回一个由分割出来的子字符串组成的数组。
		 * @param {Object} str1		源字符串
		 * @param {Object} reg		需要分割的原则
		 * @param {Object} index	分割成固定的长度
		 */
		split : function(str1, reg, index) {
			return str.split(str1, reg, index ? index : this.length(str1));
		},
		charAtCall : function(str, i) {
			return this.isString(str) ? String.prototype.chatAt.call(str, i) : "未获取到字符";
		},
		concatCall : function(str1, str2) {
			return String.prototype.concat.call(str1, str2);
		},
		sliceCall : function(str, index1, index2) {
			return String.prototype.slice.call(str, index1, index2 ? index2 : this.length(str));
		},
		substrCall : function(str, index1, index2) {
			return String.prototype.substr.call(str, index1, index2 ? index2 : this.length(str));
		},
		indexOfCall : function(str1, str2, index) {
			return String.prototype.indexOf.call(str1, str2, index ? index : 0);
		},
		lastIndexOfCall : function(str1, str2, index) {
			return String.prototype.lastIndexOf.call(str1, str2, index ? index : 0);
		},
		trimCall : function(str) {
			return String.prototype.trim.call(str);
		},
		toLowerCaseCall : function(str) {
			return String.prototype.toLowerCase.call(str);
		},
		toUpperCaseCall : function(str) {
			return String.prototype.toUpperCase.call(str);
		},
		matchCall : function(str1, str2) {
			return String.prototype.match.call(str1, str2);
		},
		searchCall : function(str1, str2) {
			return String.prototype.match.call(str1, str2);
		},
		replaceCall : function(str1, str2, reg) {
			return String.prototype.replace.call(str1, str2, reg);
		},
		splitCall : function(str1, str2, index) {
			return String.prototype.split.call(str1, str2, index ? index : this.length(str1));
		},
		isString : function(str) {
			return ( typeof (str) == ("string" || "String")) ? true : false;
		}
	};
	window.S = StringUtil;
})(window)
//	StringUtil.length("dsds");