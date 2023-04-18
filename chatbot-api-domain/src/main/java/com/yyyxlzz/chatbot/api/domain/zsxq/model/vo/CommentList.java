package com.yyyxlzz.chatbot.api.domain.zsxq.model.vo;

import java.util.ArrayList;
import java.util.List;
public class CommentList
{
    private String id;

    private int secret;

    private String pasterid;

    private String bmp;

    private String pubtime;

    private int modifytime;

    private int effect;

    private int type;

    private int uin;

    private String nickname;

    private int capacity;

    private String htmlContent;

    private String ubbContent;

    private String signature;

    private List<ReplyList> replyList;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setSecret(int secret){
        this.secret = secret;
    }
    public int getSecret(){
        return this.secret;
    }
    public void setPasterid(String pasterid){
        this.pasterid = pasterid;
    }
    public String getPasterid(){
        return this.pasterid;
    }
    public void setBmp(String bmp){
        this.bmp = bmp;
    }
    public String getBmp(){
        return this.bmp;
    }
    public void setPubtime(String pubtime){
        this.pubtime = pubtime;
    }
    public String getPubtime(){
        return this.pubtime;
    }
    public void setModifytime(int modifytime){
        this.modifytime = modifytime;
    }
    public int getModifytime(){
        return this.modifytime;
    }
    public void setEffect(int effect){
        this.effect = effect;
    }
    public int getEffect(){
        return this.effect;
    }
    public void setType(int type){
        this.type = type;
    }
    public int getType(){
        return this.type;
    }
    public void setUin(int uin){
        this.uin = uin;
    }
    public int getUin(){
        return this.uin;
    }
    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    public String getNickname(){
        return this.nickname;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    public int getCapacity(){
        return this.capacity;
    }
    public void setHtmlContent(String htmlContent){
        this.htmlContent = htmlContent;
    }
    public String getHtmlContent(){
        return this.htmlContent;
    }
    public void setUbbContent(String ubbContent){
        this.ubbContent = ubbContent;
    }
    public String getUbbContent(){
        return this.ubbContent;
    }
    public void setSignature(String signature){
        this.signature = signature;
    }
    public String getSignature(){
        return this.signature;
    }
    public void setReplyList(List<ReplyList> replyList){
        this.replyList = replyList;
    }
    public List<ReplyList> getReplyList(){
        return this.replyList;
    }

}
