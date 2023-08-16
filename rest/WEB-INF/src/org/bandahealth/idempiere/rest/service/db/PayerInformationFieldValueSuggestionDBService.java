package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHPayerInfoFieldValueSuggestion;
import org.bandahealth.idempiere.rest.model.PayerInformationFieldValueSuggestion;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class PayerInformationFieldValueSuggestionDBService
		extends BaseDBService<PayerInformationFieldValueSuggestion, MBHPayerInfoFieldValueSuggestion> {
	@Override
	public PayerInformationFieldValueSuggestion saveEntity(PayerInformationFieldValueSuggestion entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected PayerInformationFieldValueSuggestion createInstanceWithDefaultFields(MBHPayerInfoFieldValueSuggestion instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected PayerInformationFieldValueSuggestion createInstanceWithAllFields(MBHPayerInfoFieldValueSuggestion instance) {
		return new PayerInformationFieldValueSuggestion(instance);
	}

	@Override
	protected MBHPayerInfoFieldValueSuggestion getModelInstance() {
		return new MBHPayerInfoFieldValueSuggestion(Env.getCtx(), 0, null);
	}

	@Override
	protected EntityConfiguration getDefaultEntityConfiguration() {
        return new EntityConfiguration() {{
            setShouldUseContextClientId(true);
            setShouldFetchFromSystemClient(true);
        }};
    }
}
