package com.github.charleslzq.aliyun.loghub.sample;

import com.github.charleslzq.aliyun.loghub.annotation.EnableLogHubConsumer;
import com.github.charleslzq.aliyun.loghub.annotation.EnableLogHubProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableLogHubProducer
@EnableLogHubConsumer
public class ProducerSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerSampleApplication.class, args);
    }
}
