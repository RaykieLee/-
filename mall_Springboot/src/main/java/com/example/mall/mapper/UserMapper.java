package com.example.mall.mapper;

import com.example.mall.entity.User;
import org.apache.ibatis.annotations.Insert;
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
    @Insert("INSERT INTO user (name, sex, tel, address, state, registration_date, account, password, headsculpture) VALUES ( #{id},#{id},#{id},#{id},#{id},#{id},#{id},#{id},#{id},#{id},#{id});")
    public int insertUser(User user);
//
//    public int delete(int id);
//
//    public int Update(User user);

}