package com.ericazevedo.bookstoremanager.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Transforme {
	
	
	public static String objectToJSON(Object objeto) {
		ObjectMapper mapper = new ObjectMapper();
		String json = "";		
		
		try {
		  json = mapper.writeValueAsString(objeto);
		} catch (JsonProcessingException e) {
		   e.printStackTrace();
		}
		
		return json;
	}

}
