package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.rest.mixin.AccountMixIn;
import org.bandahealth.idempiere.rest.mixin.AttributeSetInstanceMixIn;
import org.bandahealth.idempiere.rest.mixin.BusinessPartnerMixIn;
import org.bandahealth.idempiere.rest.mixin.ChargeMixIn;
import org.bandahealth.idempiere.rest.mixin.ClientMixIn;
import org.bandahealth.idempiere.rest.mixin.LocationMixIn;
import org.bandahealth.idempiere.rest.mixin.OrderLineMixIn;
import org.bandahealth.idempiere.rest.mixin.OrderMixIn;
import org.bandahealth.idempiere.rest.mixin.OrganizationMixIn;
import org.bandahealth.idempiere.rest.mixin.PaymentMixIn;
import org.bandahealth.idempiere.rest.mixin.ProductMixIn;
import org.bandahealth.idempiere.rest.mixin.ReferenceListMixIn;
import org.bandahealth.idempiere.rest.mixin.StorageOnHandMixIn;
import org.bandahealth.idempiere.rest.mixin.UserMixIn;
import org.compiere.model.MAttributeSetInstance;
import org.compiere.model.MClient;
import org.compiere.model.MElementValue;
import org.compiere.model.MLocation;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.MUser;

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

		mapper.addMixIn(MAttributeSetInstance.class, AttributeSetInstanceMixIn.class);
		mapper.addMixIn(MBPartner_BH.class, BusinessPartnerMixIn.class);
		mapper.addMixIn(MCharge_BH.class, ChargeMixIn.class);
		mapper.addMixIn(MClient.class, ClientMixIn.class);
		mapper.addMixIn(MElementValue.class, AccountMixIn.class);
		mapper.addMixIn(MLocation.class, LocationMixIn.class);
		mapper.addMixIn(MOrg.class, OrganizationMixIn.class);
		mapper.addMixIn(MOrder_BH.class, OrderMixIn.class);
		mapper.addMixIn(MOrderLine_BH.class, OrderLineMixIn.class);
		mapper.addMixIn(MPayment_BH.class, PaymentMixIn.class);
		mapper.addMixIn(MProduct_BH.class, ProductMixIn.class);
		mapper.addMixIn(MRefList.class, ReferenceListMixIn.class);
		mapper.addMixIn(MStorageOnHand.class, StorageOnHandMixIn.class);
		mapper.addMixIn(MUser_BH.class, UserMixIn.class);
		// Not sure why the below line is needed, but it is
		mapper.addMixIn(MUser.class, UserMixIn.class);

		// Ensure dates make it through correctly in UTC
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
		dateFormat.setTimeZone(TimeZone.getDefault());
		mapper.setDateFormat(dateFormat);

		return mapper;
	}
}
