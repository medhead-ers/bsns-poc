package com.medhead.ers.bsns_pms.units;

import com.medhead.ers.bsns_pms.application.messaging.event.Event;
import com.medhead.ers.bsns_pms.application.messaging.job.Job;
import com.medhead.ers.bsns_pms.application.messaging.service.definition.JobMapper;
import com.medhead.ers.bsns_pms.application.messaging.service.implementation.JobMapperImpl;
import com.medhead.ers.bsns_pms.application.messaging.service.implementation.RedisMessageToEventConverter;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class JobMapperImplTest {
    JobMapper jobMapper = new JobMapperImpl();

    @Test
    void test_createJobFromMessage() throws Exception {
        // Given
        Event event = new RedisMessageToEventConverter().convertMessageToEvent("{\r\n  \"eventType\" : \"SayHello\",\r\n  \"metadata\" : {\r\n    \"userName\" : \"David\"\r\n  }\r\n}");
        // When
        Job job = jobMapper.createJobFromEvent(event);
        // Then
        Assert.isTrue(job != null, "Job should be instance of Job");
    }
}
