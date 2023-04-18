package com.yyyxlzz.chatbot.api.domain.zsxq.model.vo;

public class AuthorInfo
{
    private String msg;

    private String htmlMsg;

    private String sign;

    public void setMsg(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return this.msg;
    }
    public void setHtmlMsg(String htmlMsg){
        this.htmlMsg = htmlMsg;
    }
    public String getHtmlMsg(){
        return this.htmlMsg;
    }
    public void setSign(String sign){
        this.sign = sign;
    }
    public String getSign(){
        return this.sign;
    }

}