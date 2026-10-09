package cn.edu.utils;
public enum ResponseEnum {
SUCCESS(0, "成功"), ERROR(-1, "服务器内部错误"), NULLPOINT(-2,"对象不能为空"),
//-2xx 参数校验
BORROW_AMOUNT_NULL_ERROR(-201, "借款额度不能为空"), MOBILE_NULL_ERROR(-202, "手机号码不能为空"), MOBILE_ERROR(-203, "手机号码不正确"), PASSWORD_NULL_ERROR(204, "密码不能为空"), LOGIN_MOBILE_ERROR(208, "用户不存在"), LOGIN_PASSWORD_ERROR(209, "密码错误")
;
ResponseEnum(Integer code, String message) {
this.code = code;
this.message = message;
}
private Integer code;//状态码
private String message;//消息
public Integer getCode() {
return code;
}
public void setCode(Integer code) {
this.code = code;
}
public String getMessage() {
return message;
}
public void setMessage(String message) {
this.message = message;
}
}