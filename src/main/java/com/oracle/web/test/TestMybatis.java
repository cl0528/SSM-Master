package com.oracle.web.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.pagehelper.PageHelper;
import com.oracle.web.bean.Monster;
import com.oracle.web.bean.MonsterExample;
import com.oracle.web.bean.MonsterExample.Criteria;
import com.oracle.web.mapper.MonsterMapper;



public class TestMybatis {

	private SqlSession session;

	private MonsterMapper monsterMapper;

	
	
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void init() throws IOException {

		// 1.加载主配置文件

		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

		// 2.创建SqlSessionFactory

		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 3.开启会话SqlSession

		session = sqlSessionFactory.openSession();

		// 4.获得一个Mapper接口的对象

		monsterMapper = session.getMapper(MonsterMapper.class);

		
	}

	@Test
	public void testMapper(){
		
		MonsterExample example=new MonsterExample();
		
		//排序
		example.setOrderByClause("monster_Id");
		
		//去除重复
		example.setDistinct(true);
		
		//复杂查
		Criteria criteria=example.createCriteria();
		
		//criteria.andMonsterIdIn(Arrays.asList(5,6,9));
		//模糊查询
		//criteria.andMnameLike("%大%");
		
		//分页
		PageHelper.startPage(1,2);
		
		List<Monster> list=monsterMapper.selectByExample(example);
		
		for (Monster monster : list) {
			
			System.out.println(monster);
			
		}
	}
	@After
	public void destory() {

		// 6.提交事物

		session.commit();

		// 7.关闭会话

		session.close();
	}

}
