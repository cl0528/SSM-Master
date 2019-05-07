package com.oracle.web.service;

import java.util.List;
 

import com.oracle.web.bean.Monster;
import com.oracle.web.bean.SubMonster;

 
public interface MonsterService {

	List<SubMonster> list();

	int save(Monster monster);

	void delete(Monster monster);

	Monster queryOneMonster(Integer monsterId);

	void update(Monster monster);

	List<SubMonster> showPage(int pageNows);

	int count();

}
