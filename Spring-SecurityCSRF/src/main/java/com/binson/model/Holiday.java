package com.binson.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Holiday {
	
	private final String day;
	private final String reason;
	private final types type;
	
	public static enum types {
		FESTIVAL, FEDERAL
	}
	
}
