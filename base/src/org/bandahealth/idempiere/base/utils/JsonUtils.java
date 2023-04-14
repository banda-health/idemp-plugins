package org.bandahealth.idempiere.base.utils;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	// Convert json to a list of T type
	public static <T> List<T> convertFromJsonToList(String json, TypeReference<List<T>> valueTypeRef)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		return mapper.readValue(json, valueTypeRef);
	}

	// Convert JSON into Object
	public static <T> T covertFromJsonToObject(String json, Class<T> valueTypeRef) throws IOException {
		ObjectMapper mapper = new ObjectMapper();

		return mapper.readValue(json, valueTypeRef);
	}

	// convert Object into JSON
	public static String covertFromObjectToJson(Object object) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();

		return mapper.writeValueAsString(object);
	}

	public static String getValue(JsonNode node) {
		if (node == null) {
			return "";
		}
		
		return node.asText();
	}

	public static int getIntValue(JsonNode node) {
		if (node == null) {
			return 0;
		}
		
		return node.asInt();
	}

	public static boolean getBoolValue(JsonNode node) {
		if (node == null) {
			return false;
		}
		
		return node.asBoolean();
	}
}
