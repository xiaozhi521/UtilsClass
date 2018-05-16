//校验登录名：只能输入5-20个以字母开头、可带数字、“_”、“.”的字串  
//^[a-zA-Z]{1} 表示第一个字符要求是字母。  
//([a-zA-Z0-9]|[._]){4,19} 表示从第二位开始（因为它紧跟在上个表达式后面）的一个长度为4到9位的字符串，  
//它要求是由大小写字母、数字或者特殊字符集[._]组成。  
var regLog = /^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$/;  
  
//校验普通电话、传真号码：可以“+”或数字开头，可含有“-” 和 “ ”  
var regTel = /^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;  
  
//校验纯中文字符  
var regChina = /^[\u4E00-\u9FA5]+$/;  
  
//正浮点数   
var regDou = /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/;  
  
//正整数和小数  
var regNum = /^\d{1,}|\d{1,}\.\d{1,5}$/;  
//邮箱      
//zhangshna.Mr@163.com    
//abc_Wang.dd@sian.com    
//abc_Wang.dd.cc@sian.com  
var regEmail0 = /^(\w+)(\.\w+)*@(\w)+((\.\w+)+)$/;  
  
/**
 * 校验4位验证码
 */
function checkCode(str) {
	var re = /^\d{4}$/;
	if (re.test(str)) {
		return true;
	} else {
		return false;
	}
}
/***** 判断是否为json对象 *******
 * @param obj: 对象（可以是jq取到对象）
 * @return isjson: 是否是json对象 true/false
 */
function isJson(obj) {
	var isjson = typeof (obj) == "object" && Object.prototype.toString.call(obj).toLowerCase() == "[object object]" && !obj.length;
	return isjson;
}
/**
 *生成防重发的随机字符串
 */
function getNoncestr() {
	var timer = new Date().getTime()+"";
	var b = new Base64();
	var c = b.encode(timer);
	return c.length > 32 ? c.substring(0, 32) : c;
}
/**
 *时间戳 构成的字符串 
 */
function getNoncestrNoBase64() {
	var timer = new Date().getTime()+"";
	return timer;
}
//身份证号  
// 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X    
var regIdCard = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;  
  
//密码--数字字母组合  
var regPwd = /^([0-9a-zA-Z]){6,32}$/;  
//秘法组合(二)  
var regPwd0 = /^([0-9a-zA-Z\.\!\$\^\*\+\=\|\.\?\\\/\{\}\~\`\#\%\,\<\>\&\:\;\'\"@]){6,32}$/;  
  
//验证码  
var regYZ = /^(\w){4}|(\w){6}$/;  
  
//银行卡   16位或19位  
var regBankCard = /^(\d{16})|(\d{19})$/;  
function checkBankCard(str) {
	var regBankCard = /^(\d{16})|(\d{19})$/;
	var re = new RegExp(regBankCard);
	if (re.test(str)) {
		return true;
	} else {
		return false;
	}
}
  
//手机电话  
//中国电信手机号码开头数字 133、1349、153、180、181、189  
//中国联通手机号码开头数字 130、131、132、145、155、156、185、186  
//中国移动手机号码开头数字 1340-1348、135、136、137、138、139、147、150、151、152、157、158、159、182、183、184、187、188　  
var regMobile = /^((13[\d])|(15[\d])|(18[0,5-9])|(14[5,7]))\d{8}$/;   
function checkMobile(str) {
	var regMobile = /^((17[\d])|(13[\d])|(15[\d])|(18[0-9])|(14[5,7]))\d{8}$/; 
	var re = new RegExp(regMobile);
	if (re.test(str)) {
		return true;
	} else {
		return false;
	}
}
  
//RegExp 对象  test方法返回true或false  
var regExpTel = new RegExp(regIdCard);  
regExpTel.test("13581978748")  
  
  
/**
 * 验证电话号码
 验证规则：区号+号码，区号以0开头，3位或4位
 号码由7位或8位数字组成
 区号与号码之间可以无连接符，也可以“-”连接
 如01088888888,010-88888888,0955-7777777
 */

function checkPhone(str) {
	var re = /^0\d{2,3}-?\d{7,8}$/;
	if (re.test(str)) {
		return true;
	} else {
		return false;
	}
}  
  
  
/** 
 *正则表达式的重复类 
 * {n}  匹配前一项n次 
 * {n,} 匹配前一项至少n次，至多不限 
 * {n,m}匹配前一项至少n次，至多m次 
 *  ？   匹配前一项0次或1次，相当于{0,1} 
 *  +   匹配前一项至少1次，相当于{1,} 
 *  *   匹配前一项0次或多次，相当于{0,} 
 *  
 * 选择符 | 
 * 定位符 
 * ^    匹配字符串的开头，如果在多行文本中搜索，则匹配第一行的开头 
 * $    匹配字符串的结尾，如果实在多行文本中搜索，则匹配一行 的结尾 
 * \b   匹配一个词的边界，也就是单词与空格间的位置。在英文中使用的比较多 
 * \B   与\b相反，匹配一个非单词的边界 
 * (?=p)正前向声明，要求接下来的字符与模式p匹配，但不包括匹配中的那些字符 
 * (?!p)反向前声明，要求接下来的字符都不与模式p匹配 
 *  
 * 标志 
 * i    匹配时不区分大小写 
 * g    匹配时执行全局匹配模式，即找出所有的匹配，而不是再找第一个匹配之后就停止匹配 
 * m    匹配时执行多行匹配模式，及使用^匹配一行的开头和字符串的开头，使用$匹配一行的结尾或字符串的结尾 
 *  
 * String对象中的正则表达式 
 * match():搜索字符串，返回匹配的子字符串所组成的数组 
 * replace(): 查找并替换字符串中的子字符 
 * search(): 搜索子字符串，返回匹配的子字符串中的位置 
 * split(): 将字符串分割成数组 
 *  
 * 正则表达式对象 
 * var regExpTel = new RegExp(pattern,attribute); 
 * pattern : 即要匹配的正则表达式，(不需要使用"/") 
 * attribute:  正则表达式的标志，也就是 i , g 或 m  
 * 方法： 
 * exec(): 执行正则表达式的匹配，该方法返回一个数组，如果匹配不成功，返回null 
 * test(): 测试正则表达式的匹配，该方法返回一个bool值，如果字符串中包含与正则表达式相配的文本，则返回true，否则返回false 
 * toSource(): 返回RegExp对象的源代码，该方法不是所有浏览器支持的方法。 
 * toString(): 将RegExp对象转换成字符串 
 * 属性： 
 * global: 用于表示正则表达式是否有g标志，该属性返回值为bool值 
 */ 