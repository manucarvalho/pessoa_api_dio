package com.dio.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TelefoneTipo {
	
	CASA("Casa"),
    CELULAR("Celular"),
    COMERCIAL("Comercial");

    private final String description;
}
