package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.BaseMetadata;
import org.compiere.model.MAccount;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class ValidCombinationDBService extends BaseDBService<BaseMetadata, MAccount> {
	@Override
	public BaseMetadata saveEntity(BaseMetadata entity) {
		throw new NotImplementedException();
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected BaseMetadata createInstanceWithDefaultFields(MAccount instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected BaseMetadata createInstanceWithAllFields(MAccount instance) {
		return new BaseMetadata(instance);
	}

	@Override
	protected MAccount getModelInstance() {
		return new MAccount(Env.getCtx(), 0, null);
	}
}
