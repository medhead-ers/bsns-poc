package com.medhead.ers.bsns_pms.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext
public class RestMessagingControllerTest {
    @Autowired
    public MockMvc mockMvc;

    static {
        GenericContainer<?> redis =
                new GenericContainer<>(DockerImageName.parse("redis"))
                        .withExposedPorts(6379).withPrivilegedMode(true);
        redis.start();
        System.setProperty("spring.redis.host", redis.getHost());
        System.setProperty("spring.redis.port", redis.getMappedPort(6379).toString());
    }

    @Test
    public void test_SayHelloMessageIsProperlyPublished() throws Exception {
        // Given
        String userName = "John Doe";
        // When
        this.mockMvc.perform(post("/rest-messaging/say-hello")
                        .param("userName",userName)
                        .contentType(MediaType.MULTIPART_FORM_DATA))
                // Then
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Your message has been sent")));
    }
}
