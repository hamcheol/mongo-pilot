package com.slowhand.mongo.pilot.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class PrintUtils {
	public static String prettyPrint(Object obj) {
		try {
			ObjectMapper objectMapper = new ObjectMapper()
					.registerModule(new JavaTimeModule())
					.configure(com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
			return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			return e.getMessage();
		}		
	}
}
