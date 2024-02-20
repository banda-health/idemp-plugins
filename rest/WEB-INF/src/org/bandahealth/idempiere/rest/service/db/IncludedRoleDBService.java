package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.rest.model.BaseMetadata;
import org.compiere.model.MRoleIncluded;
import org.compiere.util.Env;

public class IncludedRoleDBService extends BaseDBService<BaseMetadata, MRoleIncluded> {
	@Override
	public BaseMetadata saveEntity(BaseMetadata entity) {
		return null;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		return null;
	}

	@Override
	protected BaseMetadata createInstanceWithDefaultFields(MRoleIncluded instance) {
		return null;
	}

	@Override
	protected BaseMetadata createInstanceWithAllFields(MRoleIncluded instance) {
		return null;
	}

	@Override
	protected MRoleIncluded getModelInstance() {
		return new MRoleIncluded(Env.getCtx(), 0, null);
	}
}
