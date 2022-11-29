package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.AttributeSetInstance;
import org.bandahealth.idempiere.rest.model.Inventory;
import org.bandahealth.idempiere.rest.model.InventoryLine;
import org.bandahealth.idempiere.rest.model.Locator;
import org.bandahealth.idempiere.rest.model.Product;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MLocator;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class InventoryLineDBService extends BaseDBService<InventoryLine, MInventoryLine_BH> {
	@Autowired
	private ProductDBService productDBService;
	@Autowired
	private LocatorDBService locatorDBService;
	@Autowired
	private AttributeSetInstanceDBService attributeSetInstanceDBService;
	@Autowired
	private StorageOnHandDBService storageOnHandDBService;

	@Override
	public InventoryLine saveEntity(InventoryLine entity) {
		MInventoryLine_BH inventoryLine = getEntityByUuidFromDB(entity.getUuid());
		if (inventoryLine == null) {
			inventoryLine = getModelInstance();
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				inventoryLine.setM_InventoryLine_UU(entity.getUuid());
			}
		}

		// Set foreign keys
		if (entity.getProduct().getId() != null) {
			inventoryLine.setM_Product_ID(entity.getProduct().getId());
		} else if (!StringUtil.isNullOrEmpty(entity.getProduct().getUuid())) {
			inventoryLine.setM_Product_ID(
					productDBService.getEntityByUuidFromDB(entity.getProduct().getUuid()).getM_Product_ID());
		}
		if (entity.getLocator().getId() != null) {
			inventoryLine.setM_Locator_ID(entity.getLocator().getId());
		} else if (!StringUtil.isNullOrEmpty(entity.getLocator().getUuid())) {
			inventoryLine.setM_Locator_ID(
					locatorDBService.getEntityByUuidFromDB(entity.getLocator().getUuid()).getM_Locator_ID());
		}
		if (entity.getAttributeSetInstance().getId() != null) {
			inventoryLine.setM_AttributeSetInstance_ID(entity.getAttributeSetInstance().getId());
		} else if (!StringUtil.isNullOrEmpty(entity.getAttributeSetInstance().getUuid())) {
			inventoryLine.setM_AttributeSetInstance_ID(
					attributeSetInstanceDBService.getEntityByUuidFromDB(entity.getAttributeSetInstance().getUuid())
							.getM_AttributeSetInstance_ID());
		}

		inventoryLine.setLine(entity.getLine());
		inventoryLine.setQtyCount(entity.getQuantityCount());
		inventoryLine.setM_Inventory_ID(entity.getInventoryId());

		// Set the qty book based on the product, attribute set, and locator
		inventoryLine.setQtyBook(storageOnHandDBService.getQuantityOnHand(inventoryLine.getM_Product_ID(),
				inventoryLine.getM_AttributeSetInstance_ID(), inventoryLine.getM_Locator_ID()));

		inventoryLine.saveEx();

		return createInstanceWithAllFields(getEntityByIdFromDB(inventoryLine.get_ID()));
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected InventoryLine createInstanceWithDefaultFields(MInventoryLine_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected InventoryLine createInstanceWithAllFields(MInventoryLine_BH instance) {
		return new InventoryLine(instance);
	}

	@Override
	protected InventoryLine createInstanceWithSearchFields(MInventoryLine_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MInventoryLine_BH getModelInstance() {
		return new MInventoryLine_BH(Env.getCtx(), 0, null);
	}

	public void saveByInventory(Inventory entity) {
		// Get the entities from the DB
		List<MInventoryLine_BH> inventoryLinesForOrder =
				getGroupsByIds(MInventoryLine_BH::getM_Inventory_ID, MInventoryLine_BH.COLUMNNAME_M_Inventory_ID,
						Collections.singleton(entity.getId())).get(entity.getId());
		List<InventoryLine> inventoryLinesToSave =
				entity.getInventoryLines() == null ? new ArrayList<>() : entity.getInventoryLines();

		// If there's no data to save and none in the DB, we're done
		if (inventoryLinesForOrder.isEmpty() && inventoryLinesToSave.isEmpty()) {
			return;
		}

		// Get the related data for saving
		Set<String> productUuids =
				inventoryLinesToSave.stream().map(InventoryLine::getProduct).map(Product::getUuid).collect(Collectors.toSet());
		Set<String> locatorUuids =
				inventoryLinesToSave.stream().map(InventoryLine::getLocator).map(Locator::getUuid).collect(Collectors.toSet());
		Set<String> attributeSetInstanceUuids =
				inventoryLinesToSave.stream().map(InventoryLine::getAttributeSetInstance).map(AttributeSetInstance::getUuid)
						.collect(Collectors.toSet());

		// Get the inventory line batch models
		Map<String, MProduct_BH> productsByUuid =
				productUuids.isEmpty() ? new HashMap<>() : productDBService.getByUuids(productUuids);
		Map<String, MLocator> locatorsByUuid =
				locatorUuids.isEmpty() ? new HashMap<>() : locatorDBService.getByUuids(locatorUuids);
		Map<String, MAttributeSetInstance_BH> attributeSetInstancesByUuid =
				attributeSetInstanceUuids.isEmpty() ? new HashMap<>() :
						attributeSetInstanceDBService.getByUuids(attributeSetInstanceUuids);

		inventoryLinesToSave.forEach(inventoryLine -> {
			inventoryLine.setInventoryId(entity.getId());
			inventoryLine.getProduct().setId(productsByUuid.get(inventoryLine.getProduct().getUuid()).get_ID());
			inventoryLine.getLocator().setId(locatorsByUuid.get(inventoryLine.getLocator().getUuid()).get_ID());
			if (attributeSetInstancesByUuid.containsKey(inventoryLine.getAttributeSetInstance().getUuid())) {
				inventoryLine.getAttributeSetInstance()
						.setId(attributeSetInstancesByUuid.get(inventoryLine.getAttributeSetInstance().getUuid()).get_ID());
			} else {
				inventoryLine.getAttributeSetInstance().setId(0);
			}

			saveEntity(inventoryLine);
		});

		// Delete removed
		inventoryLinesForOrder.stream().filter(previouslySavedInventoryLine -> inventoryLinesToSave.stream().noneMatch(
						inventoryLineToSave -> inventoryLineToSave.getUuid()
								.equals(previouslySavedInventoryLine.getM_InventoryLine_UU())))
				.forEach(inventoryLineToDelete -> inventoryLineToDelete.deleteEx(true));
	}
}
