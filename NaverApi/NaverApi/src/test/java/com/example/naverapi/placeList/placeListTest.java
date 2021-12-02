package com.example.naverapi.placeList;


import com.example.naverapi.place.Entity.placeEntity;
import com.example.naverapi.place.repository.placeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class placeListTest {
    @Autowired
    private placeRepository placeRepository;


    private placeEntity create(){
        var placeEntity = new placeEntity();
        placeEntity.setTitle("title");
        placeEntity.setCategory("category");
        placeEntity.setAddress("Address");
        placeEntity.setReadAddress("readAddress");
        placeEntity.setHompageLink("hompageLink");
        placeEntity.setImageLink("Image");
        placeEntity.setVisitCount(0);
        placeEntity.setVisit(false);
        placeEntity.setLastVisitDate(null);

        return placeEntity;
    }

    @Test
    public void saveTest(){
        var place = create();
        var expected = placeRepository.save(place);

        Assertions.assertNotNull(expected); // expected가 null이면 안되고
        Assertions.assertEquals(1,expected.getIndex()); // 첫 번째 인덱스가 1이면 통과
    }

    @Test
    public void updateTest(){
        var place = create();
        placeRepository.save(place);

        place.setTitle("Hi");

        placeRepository.save(place);

        int count = placeRepository.listAll().size();

        Assertions.assertEquals(1,count);
        System.out.println(placeRepository.findById(1).get().getTitle());

    }

    @Test
    public void findById(){
        var place = create();
        placeRepository.save(place);
        System.out.println();
        var expected = placeRepository.findById(1);

        Assertions.assertEquals(true, expected.isPresent());
        Assertions.assertEquals(1,expected.get().getIndex());


    }
    @Test
    public void deleteTest(){
        var place = create();
        placeRepository.save(place);

        placeRepository.deleteById(1);

        int count = placeRepository.listAll().size();

        Assertions.assertEquals(0,count);


    }

    @Test
    public void listAllTest(){
        var place1 = create();
        placeRepository.save(place1);

        var place2 = create();
        placeRepository.save(place2);

        int count = placeRepository.listAll().size();
        Assertions.assertEquals(2,count);

    }

}
