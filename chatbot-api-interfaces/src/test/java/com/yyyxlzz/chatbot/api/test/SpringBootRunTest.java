package com.yyyxlzz.chatbot.api.test;

import com.yyyxlzz.chatbot.api.domain.zsxq.IZsxqApi;
import com.yyyxlzz.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsTopicId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;
import java.io.IOException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRunTest {
//
    private Logger logger = LoggerFactory.getLogger(SpringBootRunTest.class);

    @Value("${chatbot-api.reqHttp}")
    private String reqHttp;
    @Value("${chatbot-api.reqCookie}")
    private String reqCookie;
    @Value("${chatbot-api.respHttp}")
    private String respHttp;
    @Value("${chatbot-api.respCookie}")
    private String respCookie;

    @Resource
    private IZsxqApi zsxqApi;


    @Test
    public void test_zsxqApi() throws IOException {
        UnAnsweredQuestionsTopicId unAnsweredQuestionsTopicId = zsxqApi.queryUnAnsweredQuestionsTopicId(reqHttp, reqCookie);
        logger.info("未回答问题的id：{}",unAnsweredQuestionsTopicId.getId());
        logger.info("未回答问题msg：{}",unAnsweredQuestionsTopicId.getMsg());
        String id = unAnsweredQuestionsTopicId.getId();
        String msg = unAnsweredQuestionsTopicId.getMsg();
        // 根据id对未回答的留言进行回复
        Boolean answer = zsxqApi.answer(respHttp, respCookie, id,msg,"springboot运行测试16.22");
        logger.info("根据id对未回答的留言进行回复---{}",answer);
    }
}
