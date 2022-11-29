package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.rest.model.ChargeType;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class ChargeTypeDBService extends BaseDBService<ChargeType, MChargeType_BH> {
	@Override
	public ChargeType saveEntity(ChargeType entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected ChargeType createInstanceWithDefaultFields(MChargeType_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected ChargeType createInstanceWithAllFields(MChargeType_BH instance) {
		return new ChargeType(instance);
	}

	@Override
	protected ChargeType createInstanceWithSearchFields(MChargeType_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MChargeType_BH getModelInstance() {
		return new MChargeType_BH(Env.getCtx(), 0, null);
	}
}
