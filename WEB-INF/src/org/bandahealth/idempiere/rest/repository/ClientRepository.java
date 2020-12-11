package org.bandahealth.idempiere.rest.repository;

import org.compiere.model.MClient;
import org.compiere.util.Env;

import java.util.Properties;

public class ClientRepository extends BaseRepository<MClient> {

	@Override
	protected MClient createModelInstance() {
		return new MClient(Env.getCtx(), 0, null);
	}

	@Override
	public MClient mapInputModelToModel(MClient entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected boolean shouldUseContextClientId() {
		return false;
	}
}
