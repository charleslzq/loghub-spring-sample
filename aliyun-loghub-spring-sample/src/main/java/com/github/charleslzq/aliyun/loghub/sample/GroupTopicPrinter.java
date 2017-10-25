package com.github.charleslzq.aliyun.loghub.sample;

import com.aliyun.openservices.log.common.LogGroupData;
import com.github.charleslzq.aliyun.loghub.listener.filter.LogGroupFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GroupTopicPrinter implements LogGroupFilter {
    @Override
    public boolean accept(LogGroupData logGroupData) {
        log.info("Received data from topic {}", logGroupData.GetLogGroup().getTopic());
        return true;
    }
}
