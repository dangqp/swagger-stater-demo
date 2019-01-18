package com.example.rocketmqdemo1.domain;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.example.rocketmqdemo1.config.MQConsumerConfiguration;
import com.example.rocketmqdemo1.entity.User;
import com.example.rocketmqdemo1.listener.MQConsumeMsgListenerProcessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;


/**
 * Title:com.example.rocketmqdemo1.domain.ComsumerRunner
 * Description:
 * Copyright: Copyright (c) 2019
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2019/01/09  17:47
 */
@Component
public class ComsumerRunner implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(ComsumerRunner.class);

    @Autowired
    MQConsumerConfiguration mqConsumerConfiguration;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MQConsumeMsgListenerProcessor mqConsumeMsgListenerProcessor;
    public void afterPropertiesSet() throws Exception {
        log.info("主题监听中开始......");
        DefaultMQPushConsumer rocketMQConsumer = mqConsumerConfiguration.getRocketMQConsumer();
        //设置一个Listener，主要进行消息的逻辑处理
        rocketMQConsumer.registerMessageListener(mqConsumeMsgListenerProcessor);
//        rocketMQConsumer.registerMessageListener(new MessageListenerConcurrently() {
//
//            @Override
//            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
//                                                            ConsumeConcurrentlyContext context) {
//
//                for (MessageExt msg : msgs) {
//                    String s = new String(msg.getBody());
//                    try {
//                        User reader = objectMapper.readValue(s, User.class);
//                        System.out.println("msg---"+ reader.toString());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
////                System.out.println(Thread.currentThread().getName() + " Receive New Messages: " + msgs);
//
//                //返回消费状态
//                //CONSUME_SUCCESS 消费成功
//                //RECONSUME_LATER 消费失败，需要稍后重新消费
//                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//            }
//        });

//        rocketMQConsumer.start();
        System.out.println("Consumer Started.");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        afterPropertiesSet();
    }
}
