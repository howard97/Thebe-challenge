package com.example.webdeveloperchallenge.commons.exception;

public enum ErrorCode {

    ERR_0001(""),
    ERR_602("MISSING_REQUIRED_DATA");

    private final String text;

	ErrorCode(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}
}
