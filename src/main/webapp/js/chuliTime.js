var timeShengyu = 60;
//处理验证码发送间隔
function chuliTime() {
	//更改验证码按钮的文本
	$("#yanzheng").html("重新发送(" + timeShengyu + "s)");
	//秒数递减
	timeShengyu--;
	//判断是否继续计秒
	if (timeShengyu > 0) {
		//时间函数, 每秒执行一次
		setTimeout(function() {//1秒刷新倒计时
			chuliTime();
		}, 1000);
	} else {
		//这里验证码倒计时已经结束
		//可以发送验证码, 隐藏按钮的秒数
		$("#timeShenyu").hide();
		//更改验证码按钮文本
		$("#yanzheng").html("重新发送");
		//还原计秒数
		timeShengyu = 60;
		return;
	}
}