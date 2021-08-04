package com.bsgrd.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class UserProducer {
    private static final Logger logger = LoggerFactory.getLogger(UserProducer.class);
    private final StreamBridge streamBridge;

    public UserProducer(final StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @Bean
    public Consumer<String> receiveUser() {
        return user -> {
            logger.info("Receiving user: {}", user);
            this.streamBridge.send("users", user);
        };
    }

    public static class User {
        private final Long id;
        private final String name;
        private final String address;

        public User(final Long id, final String name, final String address) {
            this.id = id;
            this.name = name;
            this.address = address;
        }

        public Long getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public String getAddress() {
            return this.address;
        }
    }


}
