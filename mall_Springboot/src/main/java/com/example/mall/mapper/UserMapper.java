package com.example.mall.mapper;

import com.example.mall.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where name = #{id}")
    List<User> findUserByName(String name);
//
//    public List<User> ListUser();
//
//    public int insertUser(User user);
//
//    public int delete(int id);
//
//    public int Update(User user);

}