package com.yyyxlzz.chatbot.api.domain.zsxq.model.vo;

public class ReplyList
{
    private String content;

    private int uin;

    private int time;

    private String nick;

    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }
    public void setUin(int uin){
        this.uin = uin;
    }
    public int getUin(){
        return this.uin;
    }
    public void setTime(int time){
        this.time = time;
    }
    public int getTime(){
        return this.time;
    }
    public void setNick(String nick){
        this.nick = nick;
    }
    public String getNick(){
        return this.nick;
    }

}
