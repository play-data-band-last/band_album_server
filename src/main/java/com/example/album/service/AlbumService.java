package com.example.album.service;

import com.example.album.domain.entity.Album;
import com.example.album.domain.request.AlbumRequest;
import com.example.album.domain.request.UserUpdateRequest;
import com.example.album.domain.response.AlbumResponse;
import com.example.album.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AlbumService {
    private final AlbumRepository albumRepository;

    public void saveAlbum(Long communityId,AlbumRequest albumRequest){
        albumRepository.save(albumRequest.toEntity(communityId));
    }

    public Page<AlbumResponse> getByCommunityId(Long communityId, PageRequest pageRequest
    ){
        return albumRepository.getByCommunityId(communityId, pageRequest);
    }

    @Transactional
    public void albumUpdate(
            UUID albumId, AlbumRequest albumRequest
    ){
        Album album = albumRepository.findById(albumId).get();
        album.setImgPath(albumRequest.getImgPath());
    }

    @Transactional
    public void memberUpdateInAlbum(
            Long memberId, UserUpdateRequest userUpdateRequest
    ){
        System.out.println(userUpdateRequest.getMemberName());
        System.out.println(userUpdateRequest.getMemberImage());
        albumRepository.updateMemberInAlbum(userUpdateRequest, memberId);
    }

    @Transactional
    public void likeCountUpdate(UUID boardId, Integer count) {
        Album album = albumRepository.findById(boardId).get();
        album.setLikeCount(album.getLikeCount() + count);
    }

    /*@Transactional
    public void updateBoardMember(MemberUpdateRequest memberUpdateRequest, Long memberId) throws Exception {
        if (memberUpdateRequest.getMemberImage() != null && memberUpdateRequest.getMemberName() !=null ){
            albumRepository.updateAlbumMemberImageAndMemberName(memberUpdateRequest.getMemberName(), memberUpdateRequest.getMemberImage(), memberId);
        } else if (memberUpdateRequest.getMemberImage()!=null && memberUpdateRequest.getMemberName() ==null) {
            albumRepository.updateAlbumMemberImage(memberUpdateRequest.getMemberImage(),memberId);
        } else if (memberUpdateRequest.getMemberImage()==null && memberUpdateRequest.getMemberName() != null) {
            albumRepository.updateAlbumMemberName(memberUpdateRequest.getMemberName(), memberId);
        } else {
            throw new Exception("NULL REQUEST");
        }
    }*/


    //어떻게 구현할지 좀 생각
    @Transactional
    public void albumDelete(UUID albumId){
        albumRepository.deleteById(albumId);
    }

}
