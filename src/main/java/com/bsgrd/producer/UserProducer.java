package com.bsgrd.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserProducer {
    private static final Logger logger = LoggerFactory.getLogger(UserProducer.class);

    @Bean
    public Function<Message<User>, Message<User>> sendUser() {
        return user -> {
            logger.info("Receiving user: {}", user.getPayload());
            return user;
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
