package com.example.album.repository;

import com.example.album.domain.entity.Album;
import com.example.album.domain.response.AlbumResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface AlbumRepository extends JpaRepository<Album, UUID>, CustomAlbumRepository {

    @Query("select new com.example.album.domain.response.AlbumResponse(a.id, a.communityId, a.memberId, a.memberName,a.memberImgPath,a.imgPath ,a.likeCount) " +
            "from Album a " +
            "where a.communityId = :communityId")
    Page<AlbumResponse> getByCommunityId(Long communityId, PageRequest pageRequest);



}
