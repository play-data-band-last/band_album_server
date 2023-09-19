package com.example.album.controller;

import com.example.album.domain.request.AlbumRequest;
import com.example.album.domain.request.UserUpdateRequest;
import com.example.album.domain.response.AlbumResponse;
import com.example.album.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/album")
@RequiredArgsConstructor
public class AlbumController {
    private final AlbumService albumService;

    @PostMapping("/communityid/{communityid}")
    public void saveAlbum(
            @PathVariable("communityid") Long communityId,
            @RequestBody AlbumRequest albumRequest){
        albumService.saveAlbum(communityId,albumRequest);
    }

    @GetMapping("/communityid/{communityid}")
    public Page<AlbumResponse> getByCommunityId(
            @PathVariable("communityid") Long communityId,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size
            ){
        return albumService.getByCommunityId(communityId, PageRequest.of(page,size));
    }

    @PutMapping("/{albumid}")
    public void albumUpdate(
            @PathVariable("albumid") UUID albumid,
            @RequestBody AlbumRequest albumRequest
    ){
        albumService.albumUpdate(albumid,albumRequest);
    }

    @PutMapping("/memberid/{memberid}")
    public void memberUpdateInAlbum(
            @PathVariable("memberid") Long memberId,
            @RequestBody UserUpdateRequest UserUpdateRequest
            ){
        albumService.memberUpdateInAlbum(memberId,UserUpdateRequest);
    }

  /*  @PutMapping("/updatemember/{memberId}")
    public void updateMemberBoard(@PathVariable("memberId")Long memberId,
                                  @RequestBody MemberUpdateRequest memberUpdateRequest) throws Exception {
        albumService.updateBoardMember(memberUpdateRequest, memberId);
    }
*/
    @PutMapping("/likeCountUpdate/{albumId}")
    public void updateLikeCount(@PathVariable("albumId") UUID albumId,
                                @RequestBody Integer count) {
        albumService.likeCountUpdate(albumId, count);
    }

    //어떻게 구현할지 좀 생각
    @DeleteMapping("/{albumid}")
    public void albumDelete(@PathVariable("albumid") UUID albumid){

    }

}


