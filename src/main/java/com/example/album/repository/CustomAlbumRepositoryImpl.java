package com.example.album.repository;

import com.example.album.domain.entity.QAlbum;
import com.example.album.domain.request.UserUpdateRequest;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class CustomAlbumRepositoryImpl implements CustomAlbumRepository{

    private final JPAQueryFactory queryFactory;
    private QAlbum qAlbum = QAlbum.album;

    @Override
    public void updateMemberInAlbum(UserUpdateRequest UserUpdateRequest, Long memberID) {
        JPAUpdateClause updateClause = queryFactory.update(qAlbum);
        if(UserUpdateRequest.getMemberImage() != null){
            updateClause.set(qAlbum.memberImgPath, UserUpdateRequest.getMemberImage());
        }

        if(UserUpdateRequest.getMemberName() != null){
            updateClause.set(qAlbum.memberName, UserUpdateRequest.getMemberName());
        }

        BooleanExpression whereCondition = qAlbum.memberId.eq(memberID);
        updateClause.where(whereCondition);
        updateClause.execute();
    }
}
