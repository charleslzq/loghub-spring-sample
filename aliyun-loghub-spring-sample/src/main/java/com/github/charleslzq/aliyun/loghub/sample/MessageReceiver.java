package com.github.charleslzq.aliyun.loghub.sample;

import com.aliyun.openservices.log.common.Logs;
import com.github.charleslzq.aliyun.loghub.annotation.LogHubListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@Slf4j
public class MessageReceiver {

    @LogHubListener(configName = "consumerConfig", groupFilterBeanNames = "groupTopicPrinter")
    public void handle(Logs.Log message) {
        log.info("Received message {}", message.getContentsList().stream()
                .collect(Collectors.toMap(
                        Logs.Log.Content::getKey,
                        Logs.Log.Content::getValue
                )));
    }
}
