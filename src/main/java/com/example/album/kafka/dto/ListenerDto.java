package com.example.album.kafka.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class ListenerDto {
    private UUID boardId;
    private Integer count;
    private String memberName;
    private String memberImage;
    private Long memberId;
    private Long userId;
}
