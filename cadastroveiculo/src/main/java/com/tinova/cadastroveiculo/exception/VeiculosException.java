package com.tinova.cadastroveiculo.exception;

import org.springframework.web.client.RestClientException;

public class VeiculosException extends RestClientException {
	
	private static final long serialVersionUID = 1L;

	public VeiculosException(String msg) {
		super(msg);
	}

	
}
