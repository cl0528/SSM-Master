package com.oracle.web.mapper;

import com.oracle.web.bean.Monster;
import com.oracle.web.bean.MonsterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MonsterMapper {
    long countByExample(MonsterExample example);

    int deleteByExample(MonsterExample example);

    int deleteByPrimaryKey(Integer monsterId);

    int insert(Monster record);

    int insertSelective(Monster record);

    List<Monster> selectByExample(MonsterExample example);

    Monster selectByPrimaryKey(Integer monsterId);

    int updateByExampleSelective(@Param("record") Monster record, @Param("example") MonsterExample example);

    int updateByExample(@Param("record") Monster record, @Param("example") MonsterExample example);

    int updateByPrimaryKeySelective(Monster record);

    int updateByPrimaryKey(Monster record);
}