package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.rest.model.Locator;
import org.bandahealth.idempiere.rest.model.Warehouse;
import org.compiere.model.MLocator;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class LocatorDBService extends BaseDBService<Locator, MLocator> {
	private final WarehouseDBService warehouseDBService = new WarehouseDBService();

	@Override
	public Locator saveEntity(Locator entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected Locator createInstanceWithDefaultFields(MLocator instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Locator createInstanceWithAllFields(MLocator instance) {
		return new Locator(instance);
	}

	@Override
	protected Locator createInstanceWithSearchFields(MLocator instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MLocator getModelInstance() {
		return new MLocator(Env.getCtx(), 0, null);
	}

	@Override
	public List<Locator> transformData(List<MLocator> dbModels) {
		if (dbModels == null || dbModels.isEmpty()) {
			return new ArrayList<>();
		}

		// Batch the warehouse calls
		Set<Integer> warehouseIds =
				dbModels.stream().map(MLocator::getM_Warehouse_ID).filter(warehouseId -> warehouseId > 0)
						.collect(Collectors.toSet());
		Map<Integer, Warehouse> warehousesById = warehouseIds.isEmpty() ? new HashMap<>() :
				warehouseDBService.getByIds(warehouseIds).entrySet().stream()
						.collect(Collectors.toMap(Map.Entry::getKey, warehouseById -> new Warehouse(warehouseById.getValue())));

		return dbModels.stream().map(dbLocator -> {
			Locator locator = new Locator(dbLocator);
			if (locator.getWarehouseId() > 0) {
				locator.setWarehouse(warehousesById.get(locator.getWarehouseId()));
			}
			return locator;
		}).collect(Collectors.toList());
	}
}
