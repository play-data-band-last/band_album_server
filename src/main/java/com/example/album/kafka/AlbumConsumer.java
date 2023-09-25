package com.example.album.kafka;

import com.example.album.domain.request.AlbumRequest;
import com.example.album.domain.request.LikeCountUpdateRequest;
import com.example.album.domain.request.UserUpdateRequest;
import com.example.album.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumConsumer {
    private final AlbumService albumService;

    @KafkaListener(topics = TopicConfig.album)
    public void listen(LikeCountUpdateRequest likeCountUpdateRequest) {
        albumService.likeCountUpdate(likeCountUpdateRequest);
    }

    @KafkaListener(topics = TopicConfig.albumUpdate)
    public void updateMember(UserUpdateRequest userUpdateRequest) {
        albumService.memberUpdateInAlbum(userUpdateRequest);
    }

}
