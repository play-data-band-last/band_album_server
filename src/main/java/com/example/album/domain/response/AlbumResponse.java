package com.example.album.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlbumResponse {
    private UUID id;
    private Long communityId;
    private Long memberId;
    private String memberName;
    private String memberImgPath;
    private String imgPath;
    private Integer likeCount;

}
