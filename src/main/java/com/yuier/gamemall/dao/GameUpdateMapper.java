package com.yuier.gamemall.dao;

import com.yuier.gamemall.pojo.GameUpdate;
import com.yuier.gamemall.pojo.GameUpdateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameUpdateMapper {
    long countByExample(GameUpdateExample example);

    int deleteByExample(GameUpdateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GameUpdate record);

    int insertSelective(GameUpdate record);

    List<GameUpdate> selectByExample(GameUpdateExample example);

    GameUpdate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GameUpdate record, @Param("example") GameUpdateExample example);

    int updateByExample(@Param("record") GameUpdate record, @Param("example") GameUpdateExample example);

    int updateByPrimaryKeySelective(GameUpdate record);

    int updateByPrimaryKey(GameUpdate record);
}