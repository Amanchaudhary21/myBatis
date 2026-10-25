package com.example.mybatis.controller;

import com.example.mybatis.entity.MybatisUser;
import com.example.mybatis.mapper.MyBatisUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyBatisUserController {

    @Autowired
   private MyBatisUserMapper myBatisUserMapper;

    public MyBatisUserController(MyBatisUserMapper myBatisUserMapper) {
        this.myBatisUserMapper = myBatisUserMapper;
    }

    @GetMapping("/user")
    public List<MybatisUser> findAllMyBatisUsers(){

        return myBatisUserMapper.findAll();
    }

    @GetMapping("/{id}")
    public MybatisUser findMyBatisUserById(@PathVariable Long id) {

        return myBatisUserMapper.findById(id);
    }


    //static enum
    @PostMapping
    public ResponseEntity<MybatisUser> createMyBatisUser(@RequestBody MybatisUser mybatisUser) {
        if (mybatisUser.getName() == null || mybatisUser.getName().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if (mybatisUser.getId() == null || mybatisUser.getId() == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        myBatisUserMapper.saveMyBatisUser(mybatisUser);

        return ResponseEntity.ok(mybatisUser);


    }

    @DeleteMapping("{id}")
    public ResponseEntity<MybatisUser> deleteMyBatisUserById(@PathVariable Long id) {

        int deleted = myBatisUserMapper.deleteMyBatisUserById(id);
        if (deleted == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();

    }





}
