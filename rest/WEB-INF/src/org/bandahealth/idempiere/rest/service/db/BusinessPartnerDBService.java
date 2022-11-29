package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.rest.model.BusinessPartner;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class BusinessPartnerDBService extends BaseDBService<BusinessPartner, MBPartner_BH> {
	@Override
	public BusinessPartner saveEntity(BusinessPartner entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected BusinessPartner createInstanceWithDefaultFields(MBPartner_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected BusinessPartner createInstanceWithAllFields(MBPartner_BH instance) {
		return new BusinessPartner(instance);
	}

	@Override
	protected BusinessPartner createInstanceWithSearchFields(MBPartner_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MBPartner_BH getModelInstance() {
		return new MBPartner_BH(Env.getCtx(), 0, null);
	}
}
