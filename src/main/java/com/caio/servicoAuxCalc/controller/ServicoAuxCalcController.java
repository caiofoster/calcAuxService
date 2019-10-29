package com.caio.servicoAuxCalc.controller;

import java.net.URI;
import java.util.Optional;

import javax.naming.ServiceUnavailableException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.caio.servicoAuxCalc.pojo.Retorno;

@RestController
public class ServicoAuxCalcController { 
	
	@Autowired
    private DiscoveryClient discoveryClient;

    private final RestTemplate restTemplate = new RestTemplate();

	
	@GetMapping("/multiplica")
	public Retorno multiplica (String a, String b, String c) { 
		
		RestTemplate restTemplate = new RestTemplate();  
		HttpEntity<Retorno> requestEntity = new HttpEntity<>(null, null);
		ResponseEntity<Retorno> result = restTemplate.exchange("http://localhost:8080/api/calc/multiplica?a="+a+"&b="+b, HttpMethod.GET, requestEntity, Retorno.class);
		
		Retorno saida = new Retorno(result.getBody().getRetorno() * Integer.parseInt(c), result.getBody().getServidor());
		//Retorno saida = new Retorno(5 * Integer.parseInt(c)); 
		
		return saida;
	}
	
	@GetMapping("/multiplica2")
	public Retorno multiplica2 (String a, String b, String c) {
		System.out.print("==================");
		return this.restTemplate.getForObject("http://CALC/soma/" + a + "/" + b+  "", Retorno.class);
		
	}
	
	@LoadBalanced
	@Bean
	public RestTemplate loadbalancedRestTemplate() {
	     return new RestTemplate();
	}

}