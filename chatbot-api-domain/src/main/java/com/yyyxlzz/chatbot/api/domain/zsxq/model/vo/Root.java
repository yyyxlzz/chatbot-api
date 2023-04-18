package com.yyyxlzz.chatbot.api.domain.zsxq.model.vo;

public class Root
{//
    private int code;

    private int subcode;

    private String message;

    // default
    private int deft;

    private Data data;

    public void setCode(int code){
        this.code = code;
    }
    public int getCode(){
        return this.code;
    }
    public void setSubcode(int subcode){
        this.subcode = subcode;
    }
    public int getSubcode(){
        return this.subcode;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
    public void setDefault(int deft){
        this.deft = deft;
    }
    public int getDefault(){
        return this.deft;
    }
    public void setData(Data data){
        this.data = data;
    }
    public Data getData(){
        return this.data;
    }

}