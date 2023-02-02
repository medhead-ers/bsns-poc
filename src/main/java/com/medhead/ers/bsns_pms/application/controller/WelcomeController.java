package com.medhead.ers.bsns_pms.application.controller;

import com.medhead.ers.bsns_pms.application.messaging.exception.MessagePublicationFailException;
import com.medhead.ers.bsns_pms.application.messaging.message.factory.MessageFactory;
import org.springframework.boot.system.JavaVersion;
import org.springframework.core.SpringVersion;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WelcomeController {

    private final Environment environment;

    WelcomeController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/")
    public Map<String, String> home() {
        HashMap<String, String> map = new HashMap<>();
        map.put("appName", environment.getProperty("spring.application.name"));
        map.put("javaVersion", JavaVersion.getJavaVersion().toString());
        map.put("springVersion", SpringVersion.getVersion());
        return map;
    }
}
