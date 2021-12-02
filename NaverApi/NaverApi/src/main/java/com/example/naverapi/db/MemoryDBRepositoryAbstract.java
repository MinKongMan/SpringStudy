package com.example.naverapi.db;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

abstract public class MemoryDBRepositoryAbstract<T extends MemoryDbEntity> implements MemoryDbRepositoryIfs<T>{

    private final List<T> db = new ArrayList<T>();
    private int index = 0;

    @Override
    public Optional<T> findById(int index) {
        return db.stream().filter(it -> it.getIndex() == index).findFirst();
        //stream을 통해서 필트럴 통해 찾음 getIndex의 값이 index의 값과 동일하면 리턴(젤 첫번째 꺼)
        //getIndex는MemoryDbEntity에 정의된 index를 의미

    }

    @Override
    public T save(T entity) {

        var optionalEntity = db.stream().filter(it -> it.getIndex() == entity.getIndex()).findFirst();
        //db에 데이터가 없는 경우
        if(optionalEntity.isEmpty()){
            index++;
            entity.setIndex(index);
            db.add(entity);
            return entity;
        }

        //db에 데이터가 있는 경우
        else{
            var preIndex = optionalEntity.get().getIndex(); // 이전의 인덱스
            entity.setIndex(preIndex);

            deleteById(preIndex); // 이전 꺼 삭제
            db.add(entity); // 새로운 거 추가
            return entity;
        }
    }

    @Override
    public void deleteById(int index) {
        var optionalEntity = db.stream().filter(it -> it.getIndex()==index).findFirst();
        if(optionalEntity.isPresent()){
            //데이터가 이미 있는 경우
            db.remove(optionalEntity.get());
        }
    }

    @Override
    public List<T> listAll() {
        return db;
    }
}
