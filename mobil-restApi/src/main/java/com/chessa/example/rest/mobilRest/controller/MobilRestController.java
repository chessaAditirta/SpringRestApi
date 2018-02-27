package com.chessa.example.rest.mobilRest.controller;


import com.chessa.example.rest.mobilRest.model.MobilRest;
import com.chessa.example.rest.mobilRest.repository.MobilRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MobilRestController {
    @Autowired
    MobilRestRepository mobilRestRepository;
    //get all
    @GetMapping("/tbl_mobil")
    public List<MobilRest> getAllMobilRests(){
        return mobilRestRepository.findAll();
    }
    //get one by id
    @GetMapping("/tbl_mobil/{id}")
    public ResponseEntity<MobilRest> getMobilRestById(@PathVariable(value = "id")Long idMobilRest){
        MobilRest mobilRest = mobilRestRepository.findOne(idMobilRest);
        if (mobilRest==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(mobilRest);
    }
    //create new one
    @PostMapping("/tbl_mobil")
    public MobilRest createMobilRest(@Valid @RequestBody MobilRest mobilRest){
        return mobilRestRepository.save(mobilRest);
    }
    //edit one of them
    @PutMapping("/tbl_mobil/{id}")
    public ResponseEntity<MobilRest> updateMobilRest(
            @PathVariable(value = "id")Long mobilRestId, @Valid @RequestBody MobilRest mobilRestDetail){
        MobilRest mobilRest=mobilRestRepository.findOne(mobilRestId);
        if (mobilRest==null){
            return ResponseEntity.notFound().build();
        }
        mobilRest.setNo_plat(mobilRestDetail.getNo_plat());
        mobilRest.setMerk(mobilRestDetail.getMerk());
        mobilRest.setWarna(mobilRestDetail.getWarna());
        MobilRest updateMobilRest=mobilRestRepository.save(mobilRest);
        return ResponseEntity.ok(updateMobilRest);
    }
    //delete one of them by id
    @DeleteMapping("/tbl_mobil/{id}")
    public ResponseEntity<MobilRest> deleteMobilRest(@PathVariable(value = "id")Long mobilRestId){
        MobilRest mobilRest=mobilRestRepository.findOne(mobilRestId);
        if (mobilRest==null){
            return ResponseEntity.notFound().build();
        }
        mobilRestRepository.delete(mobilRest);
        return ResponseEntity.ok().build();
    }

}
