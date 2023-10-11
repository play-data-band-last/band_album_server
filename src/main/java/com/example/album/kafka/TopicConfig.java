package com.example.album.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Component
public class TopicConfig {
    public final static String album = "album";
    public static final String albumDlt = "albumDLT";


    public final static String memberUpdate = "memberUpdate";


    @Bean
    public NewTopic albumDltTopic() {
        return TopicBuilder.name(albumDlt)
                .partitions(1)
                .replicas(1)
                .build();
    }




}
