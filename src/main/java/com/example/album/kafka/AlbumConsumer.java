package com.example.album.kafka;

import com.example.album.domain.request.AlbumRequest;
import com.example.album.domain.request.LikeCountUpdateRequest;
import com.example.album.domain.request.UserUpdateRequest;
import com.example.album.kafka.dto.ListenerDto;
import com.example.album.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.listener.CommonErrorHandler;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.stereotype.Service;
import org.springframework.util.backoff.FixedBackOff;

@Service
@RequiredArgsConstructor
public class AlbumConsumer {
    private final AlbumService albumService;
    @RetryableTopic
    @KafkaListener(topics = TopicConfig.album)
    public void listen(ListenerDto listenerDto) {
        albumService.likeCountUpdate(listenerDto);
    }

    @RetryableTopic
    @KafkaListener(topics = TopicConfig.memberUpdate)
    public void updateMember(ListenerDto listenerDto) {
        albumService.memberUpdateInAlbum(listenerDto);
    }

    @RetryableTopic
    @KafkaListener(topics = TopicConfig.memberDelete)
    public void memberDeleteListener(ListenerDto listenerDto) {
        albumService.memberDeleteHandler(listenerDto.getUserId());
    }


    @DltHandler
    public void processDltMessage(String dltMessage) {
        // DLT 토픽에서 메시지를 처리합니다. (예: 로깅 또는 추가 조사)
        System.out.println("DLT에서 메시지 수신: " + dltMessage);
    }


}
