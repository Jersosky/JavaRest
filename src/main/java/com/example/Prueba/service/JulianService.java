package com.example.Prueba.service;

import com.example.Prueba.entity.Julian;

public interface JulianService {
	
	int registrar(Julian j) throws Exception;

	Julian consultarByID(int id) throws Exception;
}
