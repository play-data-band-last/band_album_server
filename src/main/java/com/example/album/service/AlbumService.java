package com.example.album.service;

import com.example.album.domain.entity.Album;
import com.example.album.domain.request.AlbumRequest;
import com.example.album.domain.request.LikeCountUpdateRequest;
import com.example.album.domain.request.UserUpdateRequest;
import com.example.album.domain.response.AlbumResponse;
import com.example.album.kafka.dto.ListenerDto;
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
    public void memberUpdateInAlbum(ListenerDto listenerDto){
        albumRepository.updateMemberInAlbum(new UserUpdateRequest(listenerDto.getMemberName(),
                listenerDto.getMemberImage(),
                listenerDto.getMemberId()),
                listenerDto.getMemberId());
    }

    @Transactional
    public void likeCountUpdate(ListenerDto listenerDto) {
        Album album = albumRepository.findById(listenerDto.getBoardId()).get();
        album.setLikeCount(album.getLikeCount() + listenerDto.getCount());
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



    @Transactional
    public void memberDeleteHandler(Long userId){
       albumRepository.memberDelete(userId);
    }

}
