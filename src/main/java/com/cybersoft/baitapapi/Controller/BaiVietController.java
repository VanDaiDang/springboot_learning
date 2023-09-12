package com.cybersoft.baitapapi.Controller;

import com.cybersoft.baitapapi.Entity.BaiVietEntity;
import com.cybersoft.baitapapi.Repository.BaiVietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/baiviet")

public class BaiVietController {
    private List<BaiVietEntity> listBaiViet = new ArrayList<>();
    @Autowired
    BaiVietRepository baiVietRepository;

    @GetMapping("")
    public ResponseEntity<?> getBaiViet() {
        List<BaiVietEntity> listBaiViet = baiVietRepository.findAll();
        return new ResponseEntity<>(listBaiViet, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addBaiViet(@RequestBody BaiVietEntity baiViet){
        baiVietRepository.save(baiViet);
        return new ResponseEntity<>(baiViet, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBaiViet(@PathVariable int id){
        try {
            BaiVietEntity baiViet = baiVietRepository.findById(id).get();
            baiVietRepository.deleteById(id);
            return new ResponseEntity<>(baiViet, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBaiViet(@PathVariable int id,@RequestBody BaiVietEntity baiViet) {
        try {
            BaiVietEntity updatedBaiViet = baiVietRepository.findById(id).get();
            updatedBaiViet.setTieude(baiViet.getTieude());
            updatedBaiViet.setNoidung(baiViet.getNoidung());
            updatedBaiViet.setId_tacgia(baiViet.getId_tacgia());
            updatedBaiViet.setNgayviet(baiViet.getNgayviet());
            baiVietRepository.save(updatedBaiViet);
            return new ResponseEntity<>(updatedBaiViet, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}