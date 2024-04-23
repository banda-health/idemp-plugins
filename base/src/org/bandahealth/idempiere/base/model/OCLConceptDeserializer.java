package org.bandahealth.idempiere.base.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class OCLConceptDeserializer extends StdDeserializer<OCLConcept> {

	private static final long serialVersionUID = 1L;

	public OCLConceptDeserializer() {
		this(null);
	}

	protected OCLConceptDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public OCLConcept deserialize(JsonParser parser, DeserializationContext context)
			throws IOException, JsonProcessingException {

		JsonNode node = parser.getCodec().readTree(parser);
		if (node != null) {
			return new OCLConcept(node);
		}

		return null;
	}

}
