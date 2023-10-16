package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.BaseMetadata;
import org.compiere.model.MBPartnerLocation;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class BusinessPartnerLocationDBService extends BaseDBService<BaseMetadata, MBPartnerLocation> {
	@Override
	public BaseMetadata saveEntity(BaseMetadata entity) {
		throw new NotImplementedException();
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected BaseMetadata createInstanceWithDefaultFields(MBPartnerLocation instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected BaseMetadata createInstanceWithAllFields(MBPartnerLocation instance) {
		return new BaseMetadata(instance);
	}

	@Override
	protected MBPartnerLocation getModelInstance() {
		return new MBPartnerLocation(Env.getCtx(), 0, null);
	}
}
