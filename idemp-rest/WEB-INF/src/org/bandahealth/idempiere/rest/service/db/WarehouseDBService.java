package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.rest.model.Locator;
import org.bandahealth.idempiere.rest.model.Warehouse;
import org.compiere.model.MLocator;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class WarehouseDBService extends BaseDBService<Warehouse, MWarehouse_BH> {
	private LocatorDBService locatorDBService;

	public LocatorDBService getLocatorDBService() {
		return locatorDBService;
	}

	@Autowired
	public void setLocatorDBService(LocatorDBService locatorDBService) {
		this.locatorDBService = locatorDBService;
	}

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

	@Override
	public List<Warehouse> transformData(List<MWarehouse_BH> dbModels) {
		dbModels = dbModels == null ? new ArrayList<>() : dbModels;
		if (dbModels.isEmpty()) {
			return new ArrayList<>();
		}

		// Get the locators to batch
		Map<Integer, List<MLocator>> locatorsByWarehouseId =
				getLocatorDBService().getGroupsByIds(MLocator::getM_Warehouse_ID, MLocator.COLUMNNAME_M_Warehouse_ID,
						dbModels.stream().map(MWarehouse_BH::get_ID).collect(Collectors.toSet()));
		return dbModels.stream().map(warehouseModel -> {
			Warehouse warehouse = new Warehouse(warehouseModel);
			warehouse.setLocators(
					locatorsByWarehouseId.getOrDefault(warehouse.getId(), new ArrayList<>()).stream().map(Locator::new)
							.collect(Collectors.toList()));
			return warehouse;
		}).collect(Collectors.toList());
	}
}
