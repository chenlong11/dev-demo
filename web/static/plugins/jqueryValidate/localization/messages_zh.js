(function( factory ) {
	if ( typeof define === "function" && define.amd ) {
		define( ["jquery", "../jquery.validate"], factory );
	} else if (typeof module === "object" && module.exports) {
		module.exports = factory( require( "jquery" ) );
	} else {
		factory( jQuery );
	}
}(function( $ ) {

/*
 * Translated default messages for the jQuery validation plugin.
 * Locale: ZH (Chinese, 中文 (Zhōngwén), 汉语, 漢語)
 */
$.extend( $.validator.messages, {
	required: "这是必填字段",
	remote: "请修正此字段",
	email: "请输入有效的电子邮件地址",
	url: "请输入有效的网址",
	date: "请输入有效的日期",
	dateISO: "请输入有效的日期 (YYYY-MM-DD)",
	number: "请输入有效的数字",
	digits: "只能输入正整数",
    integer: "只能输入整数",
	creditcard: "请输入有效的信用卡号码",
	equalTo: "你的输入不相同",
	extension: "请输入有效的后缀",
	maxlength: $.validator.format( "最多可以输入 {0} 个字符" ),
	minlength: $.validator.format( "最少要输入 {0} 个字符" ),
	rangelength: $.validator.format( "请输入长度在 {0} 到 {1} 之间的字符串" ),
	range: $.validator.format( "请输入范围在 {0} 到 {1} 之间的数值" ),
	max: $.validator.format( "请输入不大于 {0} 的数值" ),
	min: $.validator.format( "请输入不小于 {0} 的数值" ),
    ipv4: "请输入有效的ipv4地址",
    ipv6: "请输入有效的ipv6地址",
    url: "请输入有效的网址",
    phoneZH: "请输入正确的的手机号码",
    telZH: "请输入正确的的电话号码",
    isPhone: "请输入正确的的联系方式",
    isStringAndNum: "只能输入英文字母和数字",
    chcharacter: "请输入汉字",
    isZipCode: "请填写正确的邮政编码",
    isAmount: "请输入正确的金额",
    isAccount: "请输入正确的帐号(5-16位非中文字符)",
    isIdCard:"请输入正确的身份证号码",
    isZSXM:"请输入正确的姓名",
    isAge:"请输入正确的年龄",
    isFloat:"整数位不能超过8位，小数位不能超过2位！"
} );
return $;
}));