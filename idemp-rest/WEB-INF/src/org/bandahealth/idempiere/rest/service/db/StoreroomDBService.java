package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.rest.model.Storeroom;
import org.compiere.model.MWarehouse;
import org.compiere.util.Env;

public class StoreroomDBService extends BaseDBService<Storeroom, MWarehouse> {
	@Override
	public Storeroom saveEntity(Storeroom entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected Storeroom createInstanceWithDefaultFields(MWarehouse instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Storeroom createInstanceWithAllFields(MWarehouse instance) {
		return new Storeroom(instance);
	}

	@Override
	protected Storeroom createInstanceWithSearchFields(MWarehouse instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MWarehouse getModelInstance() {
		return new MWarehouse(Env.getCtx(), 0, null);
	}
}
