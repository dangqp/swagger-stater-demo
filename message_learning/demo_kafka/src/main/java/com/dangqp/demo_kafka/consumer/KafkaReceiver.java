package com.dangqp.demo_kafka.consumer;

import com.dangqp.demo_kafka.domain.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.logging.log4j.message.ObjectMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Title:com.dangqp.demo_kafka.consumer
 * Description:
 * Copyright: Copyright (c) 2018
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/06/07  15:39
 */
@Component
public class KafkaReceiver {

    private static final Logger log = LoggerFactory.getLogger(KafkaReceiver.class);

    private Gson gson = new GsonBuilder().create();

    @KafkaListener(topics = {"dangqp"})
    public void listen(ConsumerRecord<?, ?> record) {

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            Message obj = gson.fromJson(message.toString(),Message.class);
            log.info("----------------- record =" + record);
            log.info("------------------ message =" + message);
            log.info("------------------ message =" + obj.toString());
            log.info("------------------ message =" + obj.getMsgName());
        }

    }
}
