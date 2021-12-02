package com.example.naverapi.place.repository;

import com.example.naverapi.db.MemoryDBRepositoryAbstract;
import com.example.naverapi.place.Entity.placeEntity;
import org.springframework.stereotype.Repository;


@Repository // 데이터베이스를 저장하는 곳이다 라는 어노테이션
public class placeRepository extends MemoryDBRepositoryAbstract<placeEntity> {
}
