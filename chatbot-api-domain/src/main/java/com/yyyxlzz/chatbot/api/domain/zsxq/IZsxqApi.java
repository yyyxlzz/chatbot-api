package com.yyyxlzz.chatbot.api.domain.zsxq;

import com.yyyxlzz.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsTopicId;

import java.io.IOException;

/**
 * @description 知识星球API
 */
//
public interface IZsxqApi {
    UnAnsweredQuestionsTopicId queryUnAnsweredQuestionsTopicId(String http, String Cookie) throws IOException;
    Boolean answer(String http, String Cookie,String id,String msg, String text) throws IOException;
}
