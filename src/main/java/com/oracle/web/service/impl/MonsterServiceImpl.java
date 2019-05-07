package com.oracle.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.mapper.MonsterMapper;
import com.oracle.web.bean.Monster;
import com.oracle.web.bean.SubMonster;
import com.oracle.web.bean.pageBean;
import com.oracle.web.service.MonsterService;

@Service
public class MonsterServiceImpl implements MonsterService {

	@Autowired
	private MonsterMapper monsterMapper;
	
	@Override
	@Transactional(readOnly=true)
	public List<SubMonster> list() {
		// TODO Auto-generated method stub
		return this.monsterMapper.selectAllWithOneSQL();
	}

	@Override
	@Transactional
	public int save(Monster monster) {
		// TODO Auto-generated method stub
		return this.monsterMapper.insert(monster);
	}

	@Override
	@Transactional
	public void delete(Monster monster) {
		// TODO Auto-generated method stub
		this.monsterMapper.deleteByPrimaryKey(monster.getMonsterId());
	}

	@Override
	@Transactional(readOnly=true)
	public Monster queryOneMonster(Integer monsterId) {
		// TODO Auto-generated method stub
		return this.monsterMapper.selectByPrimaryKey(monsterId);
	}

	@Override
	@Transactional
	public void update(Monster monster) {
		// TODO Auto-generated method stub
		this.monsterMapper.updateByPrimaryKey(monster);
	}

	@Override
	public List<SubMonster> showPage(int pageNows) {
		// TODO Auto-generated method stub
		return this.monsterMapper.selectFY(pageNows);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return this.monsterMapper.getCount();
	}

}
