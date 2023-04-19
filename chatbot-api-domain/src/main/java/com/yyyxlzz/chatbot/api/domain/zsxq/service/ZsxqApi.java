package com.yyyxlzz.chatbot.api.domain.zsxq.service;

import com.yyyxlzz.chatbot.api.domain.zsxq.IZsxqApi;
import com.yyyxlzz.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsTopicId;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;


@Service
public class ZsxqApi implements IZsxqApi {

    private Logger logger = LoggerFactory.getLogger(ZsxqApi.class);


    private UnAnsweredQuestionsTopicId unAnsweredQuestionsTopicId = new UnAnsweredQuestionsTopicId();

    /**
     * 问题请求
     * @param reqHttp 当前登录的账号
     * @param reqCookie 当前登录的Cookie
     * @return
     * @throws IOException
     */
    @Override
    public UnAnsweredQuestionsTopicId queryUnAnsweredQuestionsTopicId(String reqHttp, String reqCookie) throws IOException {
        // 每次登录的http和cookie不同1
        //https://user.qzone.qq.com/proxy/domain/m.qzone.qq.com/cgi-bin/new/get_msgb?uin=2865301533&hostUin=2865301533&start=0&s=0.9847448686276938&format=jsonp&num=10&inCharset=utf-8&outCharset=utf-8&g_tk=1066147756&g_tk=1066147756
        CloseableHttpClient httpClient  = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(reqHttp);
        get.addHeader("cookie",reqCookie);
        get.addHeader("Content—Type","application/x-javascript; charset=utf-8");

        CloseableHttpResponse response = httpClient.execute(get);


        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            // 获取要回复的评论的id
            String s = StringUtils.substringBetween(res, "id\":\"", "\",");
            String msg = StringUtils.substringBetween(res, "htmlContent\":\"", "\",");
            unAnsweredQuestionsTopicId.setId(s);
            unAnsweredQuestionsTopicId.setMsg(msg);
            logger.info("当前留言的问题的id：{}",s);
            logger.info("当前留言的问题是msg：{}",msg);
        } else {
            System.out.println("获取错误 ERROR："+response.getStatusLine().getStatusCode());
        }

        return unAnsweredQuestionsTopicId;
    }

    /**
     *
     * @param respHttp 当前登录的http
     * @param respCookie 当前登录用户的cookie
     * @param id 要回答的问题的id
     * @param text 要回答的信息
     * @throws IOException
     *///
    @Override
    public Boolean answer(String respHttp, String respCookie, String id,String msg, String text) throws IOException {
        logger.info("当前要回答的问题的id：{}",id);
        logger.info("当前要回答的问题msg：{}",msg);
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        // https://h5.qzone.qq.com/proxy/domain/m.qzone.qq.com/cgi-bin/new/add_reply?&g_tk=1066147756
        // 每次登录换http和cookie
        HttpPost post = new HttpPost(respHttp);
        post.addHeader("cookie", respCookie);

        post.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");

        // 对回复的信息编码
        String urlString = URLEncoder.encode(text, "utf-8");  //输出%E4%BD%A0%E5%A5%BD
        logger.info("将要回复的信息---{}",urlString);
//"content="+urlString +

        String paramJson = "hostUin=2865301533&" +
                "msgId="+id+"&" + // 当前评论的id
                "format=fs&" +
                "content="+urlString+"&" + // 要回复的信息
                "uin=2865301533&" +
                "iNotice=1&" +
                "inCharset=utf-8&" +
                "outCharset=utf-8&" +
                "ref=qzone&" +
                "json=1&" +
                "g_tk=1066147756&" + // 1
                "qzreferrer=https%3A%2F%2Fuser.qzone.qq.com%2Fproxy%2Fdomain%2Fqzs.qq.com%2Fqzone%2Fmsgboard%2Fmsgbcanvas.html%23page%3D1";



        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
            return true;
        } else {
            System.out.println(response);
            return false;
        }

    }
}
