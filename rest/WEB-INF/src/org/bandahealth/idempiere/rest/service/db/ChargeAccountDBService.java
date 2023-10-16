package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.BaseMetadata;
import org.compiere.model.X_C_Charge_Acct;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class ChargeAccountDBService extends BaseDBService<BaseMetadata, X_C_Charge_Acct> {
	@Override
	public BaseMetadata saveEntity(BaseMetadata entity) {
		throw new NotImplementedException();
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected BaseMetadata createInstanceWithDefaultFields(X_C_Charge_Acct instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected BaseMetadata createInstanceWithAllFields(X_C_Charge_Acct instance) {
		return new BaseMetadata(instance);
	}

	@Override
	protected X_C_Charge_Acct getModelInstance() {
		return new X_C_Charge_Acct(Env.getCtx(), 0, null);
	}
}
