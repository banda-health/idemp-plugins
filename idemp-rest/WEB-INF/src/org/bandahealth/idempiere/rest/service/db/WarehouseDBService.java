package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.rest.model.Warehouse;
import org.compiere.model.MWarehouse;
import org.compiere.util.Env;

public class WarehouseDBService extends BaseDBService<Warehouse, MWarehouse> {
	@Override
	public Warehouse saveEntity(Warehouse entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}
	

	@Override
	protected Warehouse createInstanceWithDefaultFields(MWarehouse instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Warehouse createInstanceWithAllFields(MWarehouse instance) {
		return new Warehouse(instance);
	}

	@Override
	protected Warehouse createInstanceWithSearchFields(MWarehouse instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MWarehouse getModelInstance() {
		return new MWarehouse(Env.getCtx(), 0, null);
	}
}
