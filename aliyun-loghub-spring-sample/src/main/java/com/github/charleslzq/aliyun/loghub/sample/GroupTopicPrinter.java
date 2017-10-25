package com.github.charleslzq.aliyun.loghub.sample;

import com.aliyun.openservices.log.common.LogGroupData;
import com.github.charleslzq.aliyun.loghub.listener.filter.LogGroupFilter;
import org.springframework.stereotype.Component;

@Component
public class GroupTopicPrinter implements LogGroupFilter {
    @Override
    public boolean accept(LogGroupData logGroupData) {
        System.out.println(logGroupData.GetLogGroup().getTopic());
        return true;
    }
}
