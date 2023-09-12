package com.cybersoft.baitapapi.Controller;

import com.cybersoft.baitapapi.Entity.BaiVietEntity;
import com.cybersoft.baitapapi.Entity.TacGiaEntity;
import com.cybersoft.baitapapi.Repository.TacGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tacgia")
public class TacGiaController {
    private List<TacGiaEntity> listTacGia = new ArrayList<>();

    @Autowired
    TacGiaRepository tacGiaRepository;

    @GetMapping("")
    public ResponseEntity<?> showTacGia() {
        listTacGia = tacGiaRepository.findAll();
        return new ResponseEntity<>(listTacGia, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addTacGia(@RequestBody TacGiaEntity tacGia) {
        tacGiaRepository.save(tacGia);
        return new ResponseEntity<>(tacGia, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTacGia(@PathVariable int id) {
        try {
            TacGiaEntity tacGia = tacGiaRepository.findById(id).get();
            tacGiaRepository.deleteById(id);
            return new ResponseEntity<>(tacGia, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTacGia(@PathVariable int id, @RequestBody TacGiaEntity tacGia) {
        try {
            TacGiaEntity updateTacGia = tacGiaRepository.findById(id).get();
            updateTacGia.setHoten(tacGia.getHoten());
            updateTacGia.setTentacgia(tacGia.getTentacgia());
            updateTacGia.setGioitinh(tacGia.getGioitinh());
            tacGiaRepository.save(updateTacGia);
            return new ResponseEntity<>(updateTacGia, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}