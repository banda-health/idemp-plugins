package org.bandahealth.idempiere.rest.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.bandahealth.idempiere.rest.mixin.LanguageMixIn;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.compiere.model.MLanguage;

import javax.ws.rs.ext.ContextResolver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {
	private final ObjectMapper mapper;

	public ObjectMapperContextResolver() {
		this.mapper = createObjectMapper();
	}

	@Override
	public ObjectMapper getContext(Class<?> type) {
		return mapper;
	}

	private ObjectMapper createObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();

		mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
		mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		mapper.addMixIn(MLanguage.class, LanguageMixIn.class);

		// Ensure dates make it through correctly in UTC
		DateFormat dateFormat = new SimpleDateFormat(DateUtil.JACKSON_MAPPING_FORMAT);
		dateFormat.setTimeZone(TimeZone.getDefault());
		mapper.setDateFormat(dateFormat);

		return mapper;
	}
}
