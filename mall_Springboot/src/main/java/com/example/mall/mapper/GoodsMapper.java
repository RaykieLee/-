package com.example.mall.mapper;

import com.example.mall.entity.Goods;
import com.example.mall.entity.GoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface GoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Tue Jan 21 13:36:59 CST 2020
     */
    @SelectProvider(type=GoodsSqlProvider.class, method="countByExample")
    long countByExample(GoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Tue Jan 21 13:36:59 CST 2020
     */
    @Update({
            "update goods",
            "set salesvolume=salesvolume+#{num,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int addsalesvolume(Long id, Integer num);
    @DeleteProvider(type=GoodsSqlProvider.class, method="deleteByExample")
    int deleteByExample(GoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Tue Jan 21 13:36:59 CST 2020
     */
    @Delete({
        "delete from goods",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Tue Jan 21 13:36:59 CST 2020
     */
    @Insert({
        "insert into goods (id, name, ",
        "attribute, price, ",
        "details, Imageid, ",
        "salesvolume, store, ",
        "storeid, date)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{attribute,jdbcType=VARCHAR}, #{price,jdbcType=INTEGER}, ",
        "#{details,jdbcType=VARCHAR}, #{imageid,jdbcType=VARCHAR}, ",
        "#{salesvolume,jdbcType=INTEGER}, #{store,jdbcType=VARCHAR}, ",
        "#{storeid,jdbcType=INTEGER}, #{date,jdbcType=TIMESTAMP})"
    })
    int insert(Goods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Tue Jan 21 13:36:59 CST 2020
     */
    @InsertProvider(type=GoodsSqlProvider.class, method="insertSelective")
    int insertSelective(Goods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Tue Jan 21 13:36:59 CST 2020
     */
    @SelectProvider(type=GoodsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="attribute", property="attribute", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.INTEGER),
        @Result(column="details", property="details", jdbcType=JdbcType.VARCHAR),
        @Result(column="Imageid", property="imageid", jdbcType=JdbcType.VARCHAR),
        @Result(column="salesvolume", property="salesvolume", jdbcType=JdbcType.INTEGER),
        @Result(column="store", property="store", jdbcType=JdbcType.VARCHAR),
        @Result(column="storeid", property="storeid", jdbcType=JdbcType.INTEGER),
        @Result(column="date", property="date", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Goods> selectByExample(GoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Tue Jan 21 13:36:59 CST 2020
     */
    @Select({
        "select",
        "id, name, attribute, price, details, Imageid, salesvolume, store, storeid, date",
        "from goods",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="attribute", property="attribute", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.INTEGER),
        @Result(column="details", property="details", jdbcType=JdbcType.VARCHAR),
        @Result(column="Imageid", property="imageid", jdbcType=JdbcType.VARCHAR),
        @Result(column="salesvolume", property="salesvolume", jdbcType=JdbcType.INTEGER),
        @Result(column="store", property="store", jdbcType=JdbcType.VARCHAR),
        @Result(column="storeid", property="storeid", jdbcType=JdbcType.INTEGER),
        @Result(column="date", property="date", jdbcType=JdbcType.TIMESTAMP)
    })
    Goods selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Tue Jan 21 13:36:59 CST 2020
     */
    @UpdateProvider(type=GoodsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Tue Jan 21 13:36:59 CST 2020
     */
    @UpdateProvider(type=GoodsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Tue Jan 21 13:36:59 CST 2020
     */
    @UpdateProvider(type=GoodsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Goods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Tue Jan 21 13:36:59 CST 2020
     */
    @Update({
        "update goods",
        "set name = #{name,jdbcType=VARCHAR},",
          "attribute = #{attribute,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=INTEGER},",
          "details = #{details,jdbcType=VARCHAR},",
          "Imageid = #{imageid,jdbcType=VARCHAR},",
          "salesvolume = #{salesvolume,jdbcType=INTEGER},",
          "store = #{store,jdbcType=VARCHAR},",
          "storeid = #{storeid,jdbcType=INTEGER},",
          "date = #{date,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Goods record);
}