package com.dangqp.demo_kafka.kafka;

import com.dangqp.demo_kafka.domain.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Random;
import java.util.UUID;

/**
 * Title:com.dangqp.demo_kafka.kafka
 * Description: 卡夫卡生产者
 * Copyright: Copyright (c) 2018
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/06/07  15:31
 */
@Component
@EnableScheduling
public class KafaProduce {
    @Autowired
    private KafkaTemplate kafkaTemplate;
    private Gson gson = new GsonBuilder().create();
    static  int i = 0;
    /**
     * 定时任务
     */
    @Scheduled(cron = "00/1 * * * * ?")
    public void send(){
        String message = UUID.randomUUID().toString();

        Message message1 = Message.builder().build();
        message1.setId(message);
        message1.setMsgName("name"+i++);
        message1.setMsg(message);
        ListenableFuture future = kafkaTemplate.send("dangqp", gson.toJson(message1));
        future.addCallback(o -> System.out.println("send-消息发送成功：" + message1), throwable -> System.out.println("消息发送失败：" + message1));
    }
}
