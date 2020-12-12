package org.bandahealth.idempiere.rest.repository;

import org.compiere.model.MOrg;
import org.compiere.util.Env;

public class OrganizationRepository extends BaseRepository<MOrg> {

	@Override
	protected MOrg createModelInstance() {
		return new MOrg(Env.getCtx(), 0, null);
	}

	@Override
	public MOrg mapInputModelToModel(MOrg entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected boolean shouldUseContextClientId() {
		return false;
	}
}
