package com.example.rocketmqdemo1.listener;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.example.rocketmqdemo1.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.List;

/**
 * Title:com.example.rocketmqdemo1.listener.MQConsumeMsgListenerProcessor
 * Description:
 * Copyright: Copyright (c) 2019
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2019/01/09  13:47
 */
@Component
public class MQConsumeMsgListenerProcessor implements MessageListenerConcurrently {

    private static final Logger logger = LoggerFactory.getLogger(MQConsumeMsgListenerProcessor.class);

    @Autowired
    ObjectMapper objectMapper;

    /**
     * 默认msgs里只有一条消息，可以通过设置consumeMessageBatchMaxSize参数来批量接收消息<br/>
     * 不要抛异常，如果没有return CONSUME_SUCCESS ，consumer会重新消费该消息，直到return CONSUME_SUCCESS
     */
    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        if (CollectionUtils.isEmpty(msgs)) {
            logger.info("接受到的消息为空，不处理，直接返回成功");
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }

        for (MessageExt msg : msgs) {
            String s = new String(msg.getBody());
            try {
                /**
                 * 读取的消息必须是json格式的，不是会报错
                 * 通过fastjson或gson转换后的s
                 */
                User reader = objectMapper.readValue(s, User.class);
                System.out.println("msg---" + reader.toString());
                System.out.println("msg---getName" + reader.getName());
                System.out.println("msg---getAge" + reader.getAge());
                System.out.println("msg---" + reader.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        MessageExt messageExt = msgs.get(0);
        logger.info("接受到的消息为：" + messageExt.toString());
        if (messageExt.getTopic().equals("TopicTest")) {
            if (messageExt.getTags().equals("Tag")) {
                //TODO 判断该消息是否重复消费（RocketMQ不保证消息不重复，如果你的业务需要保证严格的不重复消息，需要你自己在业务端去重）
                //TODO 获取该消息重试次数
                int reconsume = messageExt.getReconsumeTimes();
                if (reconsume == 3) {//消息已经重试了3次，如果不需要再次消费，则返回成功
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
                //TODO 处理对应的业务逻辑
            }
        }
        // 如果没有return success ，consumer会重新消费该消息，直到return success
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
