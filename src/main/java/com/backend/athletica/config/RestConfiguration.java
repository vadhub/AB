package com.backend.athletica.config;

import com.backend.athletica.entity.Spot;
import com.backend.athletica.entity.User;
import com.backend.athletica.entity.chat.ChatMessage;
import com.backend.athletica.entity.chat.ChatRoom;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Component
public class RestConfiguration implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(User.class, ChatMessage.class, ChatRoom.class, Spot.class);
    }
}