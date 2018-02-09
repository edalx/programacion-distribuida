package com.eacuji.services;

import com.eacuji.dao.SingerDao;
import com.eacuji.dto.Singer;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("singerService")
@Transactional
public class SingerServiceImpl implements SingerService {

	@Autowired
	private SingerDao singerDao;

	@Override
	@Transactional(readOnly = true)
	public List<Singer> findAll() {
		return Lists.newArrayList(singerDao.findAll());
	}

	@Override
	@Transactional(readOnly = true)
	public List<Singer> findByFirstName(String firstName) {
		return singerDao.findByFirstName(firstName);
	}

	@Override
	@Transactional(readOnly = true)
	public Singer findById(Long id) {
		return singerDao.findById(id).get();
	}

	@Override
	public Singer save(Singer singer) {
		return singerDao.save(singer);
	}

	@Override
	public void delete(Singer singer) {
		singerDao.delete(singer);
	}
}
