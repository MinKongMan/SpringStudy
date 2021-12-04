package com.example.naverapi.controller;

import com.example.naverapi.place.Dto.placeEntityDto;
import com.example.naverapi.place.Service.PlaceService;
import com.example.naverapi.place.repository.placeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/place")
@RequiredArgsConstructor
@Slf4j
public class ApiController {

    private final PlaceService placeService;

    @GetMapping("/search")
    public placeEntityDto search(@RequestParam String query){
        return placeService.search(query);
    }

    @PostMapping("/add")
    public placeEntityDto add(@RequestBody placeEntityDto res){
        log.info("{}",res);

        return placeService.add(res);
    }


    @GetMapping("/all")
    public List<placeEntityDto> findAll(){
        return placeService.findAll();
    }

    @DeleteMapping("/{index}")
    public void delete(@PathVariable Integer index){
        System.out.println(index);
        placeService.delete(index);
    }


    @PostMapping("/{index}")
    public void addVisit(@PathVariable int index){
        placeService.addVisit(index);
        var temp = placeService.findAll();
        System.out.println(temp);
    }

}
