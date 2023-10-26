package com.example.Prueba.impl_service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Prueba.entity.Julian;
import com.example.Prueba.repo.JulianRepo;
import com.example.Prueba.service.JulianService;

@Service
public class JulianServiceImpl implements JulianService{

	private static final Logger logger = LogManager.getLogger(JulianServiceImpl.class);
	
	@Autowired
	private JulianRepo repo;
	
	@Override
	public int registrar(Julian j) throws Exception {
		logger.info("registrar julian prueba: " + j.getEmail());
		int res = repo.queryRegistrar(j.getId(), j.getEmail(), j.getClave());
		return res;
		
	}
	
	@Override
	public Julian consultarByID(int id) throws Exception{
		logger.info("Se va a consultar el usurio con id:" + id);
		Julian j = repo.consultarByid(id);
		return j;
	}

}
