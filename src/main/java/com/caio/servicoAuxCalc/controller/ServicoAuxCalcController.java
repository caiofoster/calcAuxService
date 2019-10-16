package com.caio.servicoAuxCalc.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.caio.servicoAuxCalc.pojo.Retorno;

@RestController
public class ServicoAuxCalcController { 
	

	
	@GetMapping("/multiplica")
	public Retorno multiplica (String a, String b, String c) {
		
		RestTemplate restTemplate = new RestTemplate();  
		HttpEntity<Retorno> requestEntity = new HttpEntity<>(null, null);
		ResponseEntity<Retorno> result = restTemplate.exchange("http://localhost:8080/multiplica?a="+a+"&b="+b, HttpMethod.GET, requestEntity, Retorno.class);
		
		Retorno saida = new Retorno(result.getBody().getRetorno() * Integer.parseInt(c));
		//Retorno saida = new Retorno(5 * Integer.parseInt(c)); 
		
		return saida;
	}

}
