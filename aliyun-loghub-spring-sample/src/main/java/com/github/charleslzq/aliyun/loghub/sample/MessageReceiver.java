package com.github.charleslzq.aliyun.loghub.sample;

import com.aliyun.openservices.log.common.Logs;
import com.github.charleslzq.aliyun.loghub.annotation.LogHubListener;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MessageReceiver {

    @LogHubListener(configName = "consumerConfig", groupFilterBeanNames = "groupTopicPrinter")
    public void handle(Logs.Log log) {
        System.out.println(log.getContentsList().stream()
                .collect(Collectors.toMap(
                        Logs.Log.Content::getKey,
                        Logs.Log.Content::getValue
                )));
    }
}
