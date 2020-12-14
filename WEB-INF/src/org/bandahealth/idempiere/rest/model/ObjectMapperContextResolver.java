package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.rest.mixin.ClientMixIn;
import org.bandahealth.idempiere.rest.mixin.OrderMixIn;
import org.bandahealth.idempiere.rest.mixin.OrganizationMixIn;
import org.bandahealth.idempiere.rest.mixin.ReferenceListMixIn;
import org.compiere.model.MClient;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;

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

		//mapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);

		mapper.addMixIn(MOrder_BH.class, OrderMixIn.class);
		mapper.addMixIn(MClient.class, ClientMixIn.class);
		mapper.addMixIn(MOrg.class, OrganizationMixIn.class);
		mapper.addMixIn(MRefList.class, ReferenceListMixIn.class);

		// Ensure dates make it through correctly in UTC
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
		dateFormat.setTimeZone(TimeZone.getDefault());
		mapper.setDateFormat(dateFormat);

		return mapper;
	}
}
