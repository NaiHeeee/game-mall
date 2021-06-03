/**
 * @公司版权 浙江仆汇科技有限公司
 * @创建人 罗顺锋
 * @创建时间 2019-09-25 0025
 * @描述  公共出入参
 */
package com.yuier.gamemall.pojo;
import java.io.Serializable;

public class CommonResult implements Serializable {

    private String code = "200";
    private String msg = "操作成功";
    private Object object;


    public CommonResult(){

    }

    public CommonResult(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public CommonResult(String code, String msg, Object object){
        this.code = code;
        this.msg = msg;
        this.object = object;
    }

    public CommonResult(Object object){
        this.object = object;
    }

    public static CommonResult RESULT200 = new CommonResult("200","操作成功");
    public static CommonResult RESULT403 = new CommonResult("403","身份验证失败");
    public static CommonResult RESULT404 = new CommonResult("404","请求路径错误");
    public static CommonResult RESULT500 = new CommonResult("500","服务器异常");

    public void Result600(String msg){
        this.code = "600";
        this.msg = msg;
    }

    public static CommonResult SERVER_BIND_ERROR = new CommonResult("101", "服务端绑定异常:%s");


    /**
     *
     * @param args
     * @return
     */
    public CommonResult fillArgs(Object ... args){
        String code=this.code;
        String message=String.format(msg,args);
        return new CommonResult(code,message);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
