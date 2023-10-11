package com.example.album.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Component
public class TopicConfig {
    public final static String album = "album";
    public static final String albumDlt = "album.DLT";
    public final static String memberUpdate = "memberUpdate";
    public static final String memberUpdateDLT = "memberUpdate.DLT";



    @Bean
    public NewTopic albumDltTopic() {
        return TopicBuilder.name(albumDlt)
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic memberUpdateDLT() {
        return TopicBuilder.name(memberUpdateDLT)
                .partitions(1)
                .replicas(1)
                .build();
    }




}
