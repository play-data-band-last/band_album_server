package com.example.album.repository;

import com.example.album.domain.request.UserUpdateRequest;

public interface CustomAlbumRepository {
    void updateMemberInAlbum(UserUpdateRequest UserUpdateRequest, Long memberID);
}