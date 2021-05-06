package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHChargeInfoValueSuggestion;
import org.bandahealth.idempiere.rest.model.ChargeInfoValueSuggestion;
import org.compiere.util.Env;

public class ChargeInfoValueSuggestionDBService
		extends BaseDBService<ChargeInfoValueSuggestion, MBHChargeInfoValueSuggestion> {
	@Override
	public ChargeInfoValueSuggestion saveEntity(ChargeInfoValueSuggestion entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected ChargeInfoValueSuggestion createInstanceWithDefaultFields(MBHChargeInfoValueSuggestion instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected ChargeInfoValueSuggestion createInstanceWithAllFields(MBHChargeInfoValueSuggestion instance) {
		return new ChargeInfoValueSuggestion(instance);
	}

	@Override
	protected ChargeInfoValueSuggestion createInstanceWithSearchFields(MBHChargeInfoValueSuggestion instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MBHChargeInfoValueSuggestion getModelInstance() {
		return new MBHChargeInfoValueSuggestion(Env.getCtx(), 0, null);
	}

	@Override
	protected boolean isClientIdFromTheContextNeededByDefaultForThisEntity() {
		return false;
	}
}
