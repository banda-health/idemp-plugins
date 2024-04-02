package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHPayerInfoFldValSug;
import org.bandahealth.idempiere.rest.model.PayerInformationFieldValueSuggestion;
import org.compiere.util.Env;

public class PayerInformationFieldValueSuggestionDBService
		extends BaseDBService<PayerInformationFieldValueSuggestion, MBHPayerInfoFldValSug> {
	@Override
	public PayerInformationFieldValueSuggestion saveEntity(PayerInformationFieldValueSuggestion entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected PayerInformationFieldValueSuggestion createInstanceWithDefaultFields(MBHPayerInfoFldValSug instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected PayerInformationFieldValueSuggestion createInstanceWithAllFields(MBHPayerInfoFldValSug instance) {
		return new PayerInformationFieldValueSuggestion(instance);
	}

	@Override
	protected MBHPayerInfoFldValSug getModelInstance() {
		return new MBHPayerInfoFldValSug(Env.getCtx(), 0, null);
	}

	@Override
	protected EntityConfiguration getDefaultEntityConfiguration() {
		return new EntityConfiguration() {{
			setShouldUseContextClientId(true);
			setShouldFetchFromSystemClient(true);
		}};
	}
}
