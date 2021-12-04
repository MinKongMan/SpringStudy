package com.example.naverapi.place.Service;


import com.example.naverapi.naver.NaverClient;
import com.example.naverapi.naver.dto.SearchImageReq;
import com.example.naverapi.naver.dto.SearchLocalReq;
import com.example.naverapi.place.Dto.placeEntityDto;
import com.example.naverapi.place.Entity.placeEntity;
import com.example.naverapi.place.repository.placeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final NaverClient naverClient;
    private final placeRepository placeRepository;
    
    public placeEntityDto search(String query){
        //지역 검색
        var searchReq = new SearchLocalReq();
        searchReq.setQuery(query);

        var searchRes = naverClient.localSearch(searchReq);

        if(searchRes.getTotal()>0){
            var localItem = searchRes.getItems().stream().findFirst().get();


            //이미지 검색
            var imageQuery = localItem.getTitle().replaceAll("<[^>]*>",""); // 잡다한 문자 제거
            var searchImg = new SearchImageReq();
            searchImg.setQuery(imageQuery);

            var searchImgRes = naverClient.imageSearch(searchImg);

            //이미지가 있을 때
            if(searchImgRes.getTotal()>0){
                var imageItem = searchImgRes.getItems().stream().findFirst().get();

                var result = new placeEntityDto();

                result.setTitle(localItem.getTitle());
                result.setCategory(localItem.getCategory());
                result.setAddress(localItem.getAddress());
                result.setRoadAddress(localItem.getRoadAddress());
                result.setHompageLink(localItem.getLink());
                result.setImageLink(imageItem.getLink());
                return result;
            }
            else{

            }


        }

        //검색 결과가 없을 때


        return new placeEntityDto();

    }

    public placeEntityDto add(placeEntityDto res) {
        var entity = dtoToEntity(res);
        //
        var saveEntity = placeRepository.save(entity);
        return entityToDto(saveEntity);

    }

    private placeEntity dtoToEntity(placeEntityDto dto){
        var result = new placeEntity();

        result.setTitle(dto.getTitle());
        result.setCategory(dto.getCategory());
        result.setIndex(dto.getIndex());
        result.setAddress(dto.getAddress());
        result.setRoadAddress(dto.getRoadAddress());
        result.setHompageLink(dto.getHompageLink());
        result.setImageLink(dto.getImageLink());
        result.setVisit(dto.isVisit());
        result.setVisitCount(dto.getVisitCount());
        result.setLastVisitDate(dto.getLastVisitDate());
        return result;
    }

    private placeEntityDto entityToDto(placeEntity entity){
        var result = new placeEntityDto();

        result.setTitle(entity.getTitle());
        result.setCategory(entity.getCategory());
        result.setIndex(entity.getIndex());
        result.setAddress(entity.getAddress());
        result.setRoadAddress(entity.getRoadAddress());
        result.setHompageLink(entity.getHompageLink());
        result.setImageLink(entity.getImageLink());
        result.setVisit(entity.isVisit());
        result.setVisitCount(entity.getVisitCount());
        result.setLastVisitDate(entity.getLastVisitDate());
        return result;
    }

    public List<placeEntityDto> findAll() {
        return placeRepository.listAll()
                .stream()
                .map(it->entityToDto(it))
                .collect(Collectors.toList());
    }

    public void delete(Integer index) {
        System.out.println(index);
        placeRepository.deleteById(index);
    }

    public void addVisit(int index){
        var placeItem = placeRepository.findById(index);

        if(placeItem.isPresent()){
            var Item = placeItem.get();

            Item.setVisit(true);
            Item.setVisitCount(Item.getVisitCount()+1);
        }

    }
}
