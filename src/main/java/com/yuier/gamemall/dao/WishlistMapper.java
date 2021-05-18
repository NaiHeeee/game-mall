package com.yuier.gamemall.dao;

import com.yuier.gamemall.pojo.Wishlist;
import com.yuier.gamemall.pojo.WishlistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WishlistMapper {
    long countByExample(WishlistExample example);

    int deleteByExample(WishlistExample example);

    int deleteByPrimaryKey(String id);

    int insert(Wishlist record);

    int insertSelective(Wishlist record);

    List<Wishlist> selectByExample(WishlistExample example);

    Wishlist selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Wishlist record, @Param("example") WishlistExample example);

    int updateByExample(@Param("record") Wishlist record, @Param("example") WishlistExample example);

    int updateByPrimaryKeySelective(Wishlist record);

    int updateByPrimaryKey(Wishlist record);
}