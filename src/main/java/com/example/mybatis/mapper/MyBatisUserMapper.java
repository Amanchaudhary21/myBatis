package com.example.mybatis.mapper;

import com.example.mybatis.entity.MybatisUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Mapper
public interface MyBatisUserMapper {
    List<MybatisUser> findAll();

     MybatisUser findById(long id);
     ResponseEntity<MybatisUser>saveMyBatisUser(MybatisUser mybatisUser);

    int deleteMyBatisUserById(Long id);
}
