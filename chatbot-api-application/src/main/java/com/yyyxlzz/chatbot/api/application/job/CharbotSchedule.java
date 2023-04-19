package com.yyyxlzz.chatbot.api.application.job;


import com.yyyxlzz.chatbot.api.domain.zsxq.IZsxqApi;
import com.yyyxlzz.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsTopicId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @description 问题任务
 */
@EnableScheduling
@Configuration
public class CharbotSchedule {

    String nowId = "null";

    private Logger logger = LoggerFactory.getLogger(CharbotSchedule.class);

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

    // 定时任务，轮询操作
    // 1分钟执行
    @Scheduled(cron = "0 0/1 * * * ?")
    public void run(){

        // 当前新问题id
        logger.info("新一轮入口");
        try{

            // 晚上不回复
            GregorianCalendar calendar = new GregorianCalendar();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            if (hour > 22 || hour < 7) {
                logger.info("{} 打烊时间不工作，AI 下班了！");
                return;
            }


            // 检索是否有新问题
            UnAnsweredQuestionsTopicId unAnsweredQuestionsTopicId = zsxqApi.queryUnAnsweredQuestionsTopicId(reqHttp, reqCookie);
            logger.info("检索到的问题的id：{}",unAnsweredQuestionsTopicId.getId());
            logger.info("检索到的问题msg：{}",unAnsweredQuestionsTopicId.getMsg());

            String id = unAnsweredQuestionsTopicId.getId();

            if(nowId.equals(id) && (id != null||id.isEmpty()) ){
                // 不是新问题,不做回答
                logger.info("本次检索未未查询到要回答的信息");
                return;
            }else{
                // 新问题
                logger.info("本次检索到的新问题id为：{}",unAnsweredQuestionsTopicId.getId());
                logger.info("本次检索到的新问题msg为：{}",unAnsweredQuestionsTopicId.getMsg());
                nowId = id;
                String msg = unAnsweredQuestionsTopicId.getMsg();
                // 根据id对未回答的留言进行回复
                Boolean answer = zsxqApi.answer(respHttp, respCookie, id,msg,"你说的对,现在时间为："+ new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
                logger.info("根据id对未回答的留言进行回复---{}",answer);
            }


        }catch (Exception e){
            logger.info("自动回答问题异常",e);
        }

    }

}
