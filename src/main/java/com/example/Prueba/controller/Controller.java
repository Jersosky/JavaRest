package com.example.Prueba.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Prueba.entity.Julian;
import com.example.Prueba.service.JulianService;

@RestController
@RequestMapping("/api")
public class Controller {
	
	private static final Logger logger = LogManager.getLogger(Controller.class);
	
	@Autowired
	private JulianService service;
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody Julian j) throws Exception{
		try {
			logger.info("Se va a registrar a Julian");
			int key = j.getId();
			if(service.consultarByID(key) != null) {
				logger.warn("Julian ya existe");
				return new ResponseEntity<>(HttpStatus.OK);
			}
			service.registrar(j);
			logger.info("Se registró a Julián");
			return new ResponseEntity<>("Fin",HttpStatus.OK);
		}catch(Exception e) {
			logger.error("Se presentó un error al registrar a Julian ", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@GetMapping("/consultar/{id}")
	public ResponseEntity<Julian> consultar(@PathVariable("id") int id) throws Exception{
		try {
			logger.info("Se va a consultar al Julian: " + id);
			Julian j = service.consultarByID(id);
			return new ResponseEntity<Julian>(j, HttpStatus.OK);
		}catch(Exception e) {
			logger.error("Se presentó un error al consultar a Julian ", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
