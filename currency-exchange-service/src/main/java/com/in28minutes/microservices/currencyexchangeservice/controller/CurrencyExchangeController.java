package com.in28minutes.microservices.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.currencyexchangeservice.bean.ExchangeValue;
import com.in28minutes.microservices.currencyexchangeservice.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository exchangeValueRepository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue =  exchangeValueRepository.findByFromAndTo(from, to);
		if(exchangeValue == null) {
			throw new RuntimeException("no se encuentra datos");
		}
		exchangeValue.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
		return exchangeValue;
	}
}
