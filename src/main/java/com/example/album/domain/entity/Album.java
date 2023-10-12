package com.example.album.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Albums", indexes = {
        @Index(name = "communityId_index", columnList = "communityId"),
        @Index(name = "memberId_index", columnList = "memberId")
})
public class Album {
    @Id
    @GeneratedValue
    private UUID id;
    private Long communityId;
    private Long memberId;
    private String memberName;
    private String memberImgPath;
    private String imgPath;
    private Integer likeCount;
    private Boolean isValid = Boolean.TRUE;

}
