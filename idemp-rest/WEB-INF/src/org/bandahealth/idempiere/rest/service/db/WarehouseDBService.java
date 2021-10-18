package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.rest.model.Warehouse;
import org.compiere.util.Env;

public class WarehouseDBService extends BaseDBService<Warehouse, MWarehouse_BH> {
	@Override
	public Warehouse saveEntity(Warehouse entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected Warehouse createInstanceWithDefaultFields(MWarehouse_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Warehouse createInstanceWithAllFields(MWarehouse_BH instance) {
		return new Warehouse(instance);
	}

	@Override
	protected Warehouse createInstanceWithSearchFields(MWarehouse_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MWarehouse_BH getModelInstance() {
		return new MWarehouse_BH(Env.getCtx(), 0, null);
	}
}
