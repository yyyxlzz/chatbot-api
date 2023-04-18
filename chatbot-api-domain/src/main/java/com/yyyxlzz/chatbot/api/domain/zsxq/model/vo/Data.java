package com.yyyxlzz.chatbot.api.domain.zsxq.model.vo;

import java.util.ArrayList;
import java.util.List;
public class Data
{//
    private int total;

    private int auditNum;

    private boolean auditON;

    private AuthorInfo authorInfo;

    private List<CommentList> commentList;

    public void setTotal(int total){
        this.total = total;
    }
    public int getTotal(){
        return this.total;
    }
    public void setAuditNum(int auditNum){
        this.auditNum = auditNum;
    }
    public int getAuditNum(){
        return this.auditNum;
    }
    public void setAuditON(boolean auditON){
        this.auditON = auditON;
    }
    public boolean getAuditON(){
        return this.auditON;
    }
    public void setAuthorInfo(AuthorInfo authorInfo){
        this.authorInfo = authorInfo;
    }
    public AuthorInfo getAuthorInfo(){
        return this.authorInfo;
    }
    public void setCommentList(List<CommentList> commentList){
        this.commentList = commentList;
    }
    public List<CommentList> getCommentList(){
        return this.commentList;
    }

}