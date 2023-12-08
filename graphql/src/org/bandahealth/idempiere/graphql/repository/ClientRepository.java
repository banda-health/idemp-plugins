package org.bandahealth.idempiere.graphql.repository;

import org.bandahealth.idempiere.base.model.MClient_BH;
import org.compiere.model.MClient;

import java.util.Properties;

public class ClientRepository extends BaseRepository<MClient_BH, MClient_BH> {

	@Override
	protected MClient_BH createModelInstance(Properties idempiereContext) {
		return new MClient_BH(idempiereContext, 0, null);
	}

	@Override
	public MClient_BH mapInputModelToModel(MClient_BH entity, Properties idempiereContext) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected boolean shouldUseContextClientId() {
		return false;
	}
}
