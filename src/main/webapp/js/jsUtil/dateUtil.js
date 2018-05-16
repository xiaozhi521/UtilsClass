// 对Date的扩展，将 Date 转化为指定格式的String
Date.prototype.Format = function(fmt) {//author: meizz
	var o = {
		"M+" : this.getMonth() + 1, //月份
		"d+" : this.getDate(), //日
		"h+" : this.getHours(), //小时
		"m+" : this.getMinutes(), //分
		"s+" : this.getSeconds(), //秒
		"q+" : Math.floor((this.getMonth() + 3) / 3), //季度
		"S" : this.getMilliseconds() //毫秒
	};
	if (/(y+)/.test(fmt))
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	for (var k in o)
	if (new RegExp("(" + k + ")").test(fmt))
		fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
}
/**
 *根据长整形转为日期
 * @param {Object} date
 */
function formatDateByLong(date) {
	var date = new Date(date);
	var dateStr = date.Format("yyyy-MM-dd hh:mm:ss")
	return dateStr;
}

/**
 *获取当前时间
 */
function currentTime() {
	var date = new Date();
	var year = date.getFullYear() + "";
	var month = date.getMonth() + 1 + "";
	var day = date.getDate() + "";
	var hour = date.getHours() + "";
	var minute = date.getMinutes() + "";
	var second = date.getSeconds() + "";
	return year + "-" + (month.length == 1 ? "0" + month : month) + "-" + (day.length == 1 ? "0" + day : day) + " " + (hour.length == 1 ? "0" + hour : hour) + ":" + (minute.length == 1 ? "0" + minute : minute) + ":" + (second.length == 1 ? "0" + second : second);
}

/**
 *返回 12月12日 月和日
 */
function getMonthDay(date) {
	var month = date.getMonth() + 1 + "";
	var day = date.getDate() + "";
	return ((month.length == 1 ? "0" + month : month) + "月" + (day.length == 1 ? "0" + day : day) + "日");
}

/**
 *获取当前给定日期几天后的date
 */
function getNextDay(date,n) {
	var d = new Date(date.getTime());
	d.setDate(d.getDate() + n);
	return d;
}

/**
 *获取当前给定日期几天前的date
 */
function getBeforeDay(date,n){
	var d = new Date(date.getTime());
	d.setDate(d.getDate() - n);
	return d;
}

/**
 *获取当前日期是星期几
 */
function getWeekDay(date) {
	var s = "";
	switch(date.getDay()) {
		case 0:
			s = "周日";
			break;
		case 1:
			s = "周一";
			break;
		case 2:
			s = "周二";
			break;
		case 3:
			s = "周三";
			break;
		case 4:
			s = "周四";
			break;
		case 5:
			s = "周五";
			break;
		case 6:
			s = "周六";
			break;
	}
	return s;
}

/**
 * js比较两个日期的大小
 * 0 相等
 * 1 第一个日期大于第二个
 * -1 第一个日期小于第二个
 */

function compareDate(d1, d2) {
	var timer1 = Date.parse(d1);
	var timer2 = Date.parse(d2);
	if (timer1 == timer2) {
		return 0;
	} else if (timer1 > timer2) {
		return 1;
	} else if (timer1 < timer2) {
		return -1;
	}
}

/**
 *判断两个日期的年月日是否相同 
 */
function compartDay(d1,d2){
	return d1.getFullYear() == d2.getFullYear() && d1.getMonth() ==  d2.getMonth() && d1.getDate() == d2.getDate();
}