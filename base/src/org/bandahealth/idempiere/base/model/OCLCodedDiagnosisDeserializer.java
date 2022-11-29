package org.bandahealth.idempiere.base.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class OCLCodedDiagnosisDeserializer extends StdDeserializer<OCLCodedDiagnosis> {

	private static final long serialVersionUID = 1L;

	public OCLCodedDiagnosisDeserializer() {
		this(null);
	}

	protected OCLCodedDiagnosisDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public OCLCodedDiagnosis deserialize(JsonParser parser, DeserializationContext context)
			throws IOException, JsonProcessingException {

		JsonNode node = parser.getCodec().readTree(parser);
		if (node != null) {
			return new OCLCodedDiagnosis(node);
		}

		return null;
	}

}
