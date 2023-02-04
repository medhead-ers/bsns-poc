package com.medhead.ers.bsns_poc.application.messaging.service.definition;

import com.medhead.ers.bsns_poc.application.messaging.event.Event;
import com.medhead.ers.bsns_poc.application.messaging.job.Job;

public interface JobMapper {
    Job createJobFromEvent(Event event) throws Exception;
}
