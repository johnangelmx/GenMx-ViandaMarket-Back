package com.viandamarket.eshop.model;

public class Token {
	private final String accessToken;

	public Token(String accessToken) {
		this.accessToken = accessToken;
	}//Token
	
	public String getAccessToken() {
		return accessToken;
	}//getAccessToken
}//classToken
