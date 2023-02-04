package com.medhead.ers.bsns_poc.units;

import com.medhead.ers.bsns_poc.application.messaging.exception.CannotCreateEventFromJSONMessageException;
import com.medhead.ers.bsns_poc.application.messaging.exception.CannotProcessJobException;
import com.medhead.ers.bsns_poc.application.messaging.redis.config.MessageListener;
import com.medhead.ers.bsns_poc.application.messaging.service.implementation.JobMapperImpl;
import com.medhead.ers.bsns_poc.application.messaging.service.implementation.RedisMessageToEventConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static java.util.UUID.randomUUID;
@ExtendWith(OutputCaptureExtension.class)
public class MessageListenerTest {

    @Test
    void test_ProcessSayHelloJobFromValidMessage(CapturedOutput output) throws CannotProcessJobException, CannotCreateEventFromJSONMessageException {
        // Given
        MessageListener messageListener = new MessageListener(new JobMapperImpl(), new RedisMessageToEventConverter());

        // Test avec une valeur aléatoire pour éviter de capturer une sortie d'un autre test
        String userName = String.valueOf(randomUUID());
        String validMessage = "{\r\n  \"eventType\" : \"SayHello\",\r\n  \"metadata\" : {\r\n    \"userName\" : \""+userName+"\"\r\n  }\r\n}";
        // When
        messageListener.receiveMessage(validMessage);
        // Then
        Assertions.assertTrue(output.getAll().contains("Hello "+userName+""));
    }

    @Test
    void test_CannotProcessSayHelloJobFromBecauseInvalidJsonMessage(CapturedOutput output){
        // Given
        MessageListener messageListener = new MessageListener(new JobMapperImpl(), new RedisMessageToEventConverter());
        String userName = String.valueOf(randomUUID());
        String invalidMessage = "{\r\n  \"eventType\" : \"InvalidMessage\",\r\n  \"metadata\" : {\r\n    \"userName\" : \""+userName+"\"\r\n  }\r\n}";
        // Then
        Assertions.assertThrows(CannotCreateEventFromJSONMessageException.class, () -> {
            // When
            messageListener.receiveMessage(invalidMessage);
        });
    }

    @Test
    void test_CannotProcessSayHelloJobFromBecauseInvalidDataProvided(CapturedOutput output){
        // Given
        MessageListener messageListener = new MessageListener(new JobMapperImpl(), new RedisMessageToEventConverter());
        String invalidMessage = "{\r\n  \"eventType\" : \"SayHello\",\r\n  \"metadata\" : {}\r\n}";
        // Then
        Assertions.assertThrows(CannotProcessJobException.class, () -> {
            // When
            messageListener.receiveMessage(invalidMessage);
        });
    }
}
