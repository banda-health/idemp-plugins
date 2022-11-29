package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHChargeInfoValueSuggestion;
import org.bandahealth.idempiere.rest.model.ChargeInformationValueSuggestion;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class ChargeInformationValueSuggestionDBService
		extends BaseDBService<ChargeInformationValueSuggestion, MBHChargeInfoValueSuggestion> {
	@Override
	public ChargeInformationValueSuggestion saveEntity(ChargeInformationValueSuggestion entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected ChargeInformationValueSuggestion createInstanceWithDefaultFields(MBHChargeInfoValueSuggestion instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected ChargeInformationValueSuggestion createInstanceWithAllFields(MBHChargeInfoValueSuggestion instance) {
		return new ChargeInformationValueSuggestion(instance);
	}

	@Override
	protected ChargeInformationValueSuggestion createInstanceWithSearchFields(MBHChargeInfoValueSuggestion instance) {
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
