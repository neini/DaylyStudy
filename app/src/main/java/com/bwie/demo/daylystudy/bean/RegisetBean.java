package com.bwie.demo.daylystudy.bean;

/**
 * Created by ${薛亚南}
 * on 2017/2/4 19：53.
 */

public class RegisetBean {


    /**
     * status : 200
     * msg : 短信发送成功
     * account : 13363087932
     * sign : 7aa3bc7bccfe53dc1365d07be3dbbb12
     */

    private int status;
    private String msg;
    private String account;
    private String sign;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
