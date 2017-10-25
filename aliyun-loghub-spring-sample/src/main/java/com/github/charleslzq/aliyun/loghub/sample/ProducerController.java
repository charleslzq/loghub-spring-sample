package com.github.charleslzq.aliyun.loghub.sample;

import com.github.charleslzq.aliyun.loghub.annotation.LogHubProject;
import com.github.charleslzq.aliyun.loghub.annotation.LogHubStore;
import com.github.charleslzq.aliyun.loghub.annotation.LogHubTopic;
import com.github.charleslzq.aliyun.loghub.producer.LogHubProducerTemplate;
import com.github.charleslzq.aliyun.loghub.producer.LogHubProjectTemplate;
import com.github.charleslzq.aliyun.loghub.producer.LogHubStoreTemplate;
import com.github.charleslzq.aliyun.loghub.producer.LogHubTopicTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ProducerController {

    @Autowired
    private LogHubProducerTemplate logHubProducerTemplate;

    private LogHubProjectTemplate logHubProjectTemplate;

    private LogHubStoreTemplate logHubStoreTemplate;

    private LogHubTopicTemplate logHubTopicTemplate;

    @Autowired
    @LogHubProject(project = "charleslzqsample")
    public void setLogHubProjectTemplate(LogHubProjectTemplate logHubProjectTemplate) {
        this.logHubProjectTemplate = logHubProjectTemplate;
    }

    @Autowired
    public ProducerController(
            @LogHubStore(project = "charleslzqsample", store = "testloghub") LogHubStoreTemplate logHubStoreTemplate,
            @LogHubTopic(project = "charleslzqsample", store = "testloghub", topic = "topic") LogHubTopicTemplate logHubTopicTemplate
    ) {
        this.logHubStoreTemplate = logHubStoreTemplate;
        this.logHubTopicTemplate = logHubTopicTemplate;
    }

    @RequestMapping(value = "/send", method = POST)
    public void sendMessage(@RequestParam String message) {
        logHubProducerTemplate.send("charleslzqsample", "testloghub", "default", Arrays.asList(message));
        logHubProjectTemplate.send("testloghub", "project", Arrays.asList(message));
        logHubStoreTemplate.send("store", Arrays.asList(message));
        logHubTopicTemplate.send(Arrays.asList(message));
    }
}
