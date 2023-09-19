package com.example.album.domain.request;

import com.example.album.domain.entity.Album;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlbumRequest {
    private Long communityId;
    private Long memberId;
    private String memberName;
    private String memberImgPath;
    private Integer likeCount;
    private String imgPath;

    public Album toEntity(Long communityId){
        return new Album(null,communityId,this.memberId,this.memberName,this.memberImgPath,this.imgPath,0);
    }
}
