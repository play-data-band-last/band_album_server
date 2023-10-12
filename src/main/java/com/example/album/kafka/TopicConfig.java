package com.example.album.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Component
public class TopicConfig {
    public final static String album = "album";
    public final static String memberUpdate = "memberUpdate";
    public static final String memberUpdateDLT = "memberUpdate.DLT";

    public final static String memberDelete = "memberDelete";




    @Bean
    public NewTopic memberUpdateDLT() {
        return TopicBuilder.name(memberUpdateDLT)
                .partitions(1)
                .replicas(1)
                .build();
    }




}
