package com.example.Prueba.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Prueba.entity.Julian;

public interface JulianRepo extends JpaRepository<Julian, Integer> {
	
	static String queryRegistrar = "INSERT INTO MICIELO.JULIAN VALUES (:id, :email, :clave);";
	
	@Modifying
	@Transactional
	@Query(value = queryRegistrar, nativeQuery = true)
	int queryRegistrar(@Param("id") int id, @Param("email") String email, @Param("clave") String clave);
	
	
	static String queryConsultarByID = "SELECT ID, EMAIL, CLAVE FROM MICIELO.JULIAN WHERE ID = :identificacion";
	
	@Query(value = queryConsultarByID, nativeQuery = true)
	Julian consultarByid(@Param("identificacion") int id);
	
	
}
