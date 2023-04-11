package org.bandahealth.idempiere.rest.service.db;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MInventory_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.rest.model.AttributeSetInstance;
import org.bandahealth.idempiere.rest.model.Inventory;
import org.bandahealth.idempiere.rest.model.InventoryLine;
import org.bandahealth.idempiere.rest.model.Locator;
import org.bandahealth.idempiere.rest.model.Product;
import org.bandahealth.idempiere.rest.model.ReferenceList;
import org.bandahealth.idempiere.rest.model.Warehouse;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MDocType;
import org.compiere.model.MLocator;
import org.compiere.model.MRefList;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class InventoryDBService extends DocumentDBService<Inventory, MInventory_BH> {
	private final String NO_PRODUCTS_ADDED = "No products were passed to initialize stock.";
	private final String NO_DEFAULT_WAREHOUSE = "No warehouses defined for organization";

	@Autowired
	private WarehouseDBService warehouseDBService;
	@Autowired
	private ReferenceListDBService referenceListDBService;
	@Autowired
	private ProductDBService productDBService;
	@Autowired
	private LocatorDBService locatorDBService;
	@Autowired
	private AttributeSetInstanceDBService attributeSetInstanceDBService;
	@Autowired
	private InventoryLineDBService inventoryLineDBService;

	@Override
	public Inventory saveEntity(Inventory entity) {
		// Ensure all lines have a product
		if (entity.getInventoryLines().isEmpty() || entity.getInventoryLines().stream()
				.anyMatch(inventoryLine -> StringUtil.isNullOrEmpty(inventoryLine.getProduct().getUuid()))) {
			log.severe(NO_PRODUCTS_ADDED);
			throw new AdempiereException(NO_PRODUCTS_ADDED);
		}

		// Ensure the warehouse was set
		if (StringUtil.isNullOrEmpty(entity.getWarehouse().getUuid())) {
			throw new AdempiereException("No warehouse selected");
		}

		MInventory_BH inventory = getEntityByUuidFromDB(entity.getUuid());
		if (inventory == null) {
			inventory = getModelInstance();
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				inventory.setM_Inventory_UU(entity.getUuid());
			}
		}

		inventory.setM_Warehouse_ID(
				warehouseDBService.getEntityByUuidFromDB(entity.getWarehouse().getUuid()).getM_Warehouse_ID());
		if (entity.getUpdateReason() != null && !StringUtil.isNullOrEmpty(entity.getUpdateReason().getUuid())) {
			inventory.setbh_update_reason(
					referenceListDBService.getEntityByUuidFromDB(entity.getUpdateReason().getUuid()).getValue());
		}
		inventory.setC_DocType_ID(MDocType.getDocType(MDocType.DOCBASETYPE_MaterialPhysicalInventory));

		inventory.saveEx();
		entity.setId(inventory.get_ID());

		// Save the inventory lines
		inventoryLineDBService.saveByInventory(entity);

		return transformData(Collections.singletonList(getEntityByIdFromDB(inventory.get_ID()))).get(0);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		return null;
	}

	@Override
	protected Inventory createInstanceWithDefaultFields(MInventory_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Inventory createInstanceWithAllFields(MInventory_BH instance) {
		return new Inventory(instance);
	}

	@Override
	protected Inventory createInstanceWithSearchFields(MInventory_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MInventory_BH getModelInstance() {
		return new MInventory_BH(Env.getCtx(), 0, null);
	}

	@Override
	public List<Inventory> transformData(List<MInventory_BH> dbModels) {
		// Get ids to batch
		Set<Integer> inventoryIds = dbModels.stream().map(MInventory_BH::get_ID).collect(Collectors.toSet());
		Set<Integer> warehouseIds = dbModels.stream().map(MInventory_BH::getM_Warehouse_ID).collect(Collectors.toSet());
		Set<String> updateReasonValues =
				dbModels.stream().map(MInventory_BH::getbh_update_reason).collect(Collectors.toSet());

		Map<Integer, MWarehouse_BH> warehousesByIds = warehouseDBService.getByIds(warehouseIds);
		Map<String, MRefList> updateReasonsByValues =
				referenceListDBService.getTypes(MReference_BH.STOCK_UPDATE_REASONS_AD_REFERENCE_UU, null).stream()
						.collect(Collectors.toMap(MRefList::getValue, updateReason -> updateReason));

		// Now batch child information
		Map<Integer, List<MInventoryLine_BH>> inventoryLinesByInventoryId =
				inventoryLineDBService.getGroupsByIds(MInventoryLine_BH::getM_Inventory_ID,
						MInventoryLine_BH.COLUMNNAME_M_Inventory_ID, inventoryIds);

		// Get the inventory line ids to batch
		Set<Integer> productIds = inventoryLinesByInventoryId.values().stream().flatMap(Collection::stream)
				.map(MInventoryLine_BH::getM_Product_ID).collect(Collectors.toSet());
		Set<Integer> locatorIds = inventoryLinesByInventoryId.values().stream().flatMap(Collection::stream)
				.map(MInventoryLine_BH::getM_Locator_ID).collect(Collectors.toSet());
		Set<Integer> attributeSetInstanceIds = inventoryLinesByInventoryId.values().stream().flatMap(Collection::stream)
				.map(MInventoryLine_BH::getM_AttributeSetInstance_ID).collect(Collectors.toSet());

		// Get the inventory line batch models
		Map<Integer, MProduct_BH> productsById =
				productIds.isEmpty() ? new HashMap<>() : productDBService.getByIds(productIds);
		Map<Integer, MLocator> locatorsById =
				locatorIds.isEmpty() ? new HashMap<>() : locatorDBService.getByIds(locatorIds);
		Map<Integer, MAttributeSetInstance_BH> attributeSetInstancesById =
				attributeSetInstanceIds.isEmpty() ? new HashMap<>() :
						attributeSetInstanceDBService.getByIds(attributeSetInstanceIds);

		return dbModels.stream().map(model -> {
			Inventory inventory = createInstanceWithAllFields(model);

			// Get batched data for inventory
			if (updateReasonsByValues.containsKey(model.getbh_update_reason())) {
				inventory.setUpdateReason(new ReferenceList(updateReasonsByValues.get(model.getbh_update_reason())));
			}
			if (warehousesByIds.containsKey(model.getM_Warehouse_ID())) {
				inventory.setWarehouse(new Warehouse(warehousesByIds.get(model.getM_Warehouse_ID())));
			}

			if (inventoryLinesByInventoryId.containsKey(model.getM_Inventory_ID())) {
				inventory.setInventoryLines(
						inventoryLinesByInventoryId.get(model.getM_Inventory_ID()).stream().map(inventoryLineModel -> {
							InventoryLine inventoryLine = new InventoryLine(inventoryLineModel);

							// Get fetched data for inventory lines
							if (productsById.containsKey(inventoryLineModel.getM_Product_ID())) {
								inventoryLine.setProduct(new Product(productsById.get(inventoryLineModel.getM_Product_ID())));
							}
							if (locatorsById.containsKey(inventoryLineModel.getM_Locator_ID())) {
								inventoryLine.setLocator(new Locator(locatorsById.get(inventoryLineModel.getM_Locator_ID())));
							}
							if (attributeSetInstancesById.containsKey(inventoryLineModel.getM_AttributeSetInstance_ID())) {
								inventoryLine.setAttributeSetInstance(new AttributeSetInstance(
										attributeSetInstancesById.get(inventoryLineModel.getM_AttributeSetInstance_ID())));
							}

							return inventoryLine;
						}).collect(Collectors.toList()));
			}

			return inventory;
		}).collect(Collectors.toList());
	}

	@Override
	protected String getDocumentTypeName() {
		return DOCUMENTNAME_PHYSICAL_INVENTORY;
	}

	@Override
	int getDocumentProcessId() {
		return MProcess_BH.PROCESSID_PROCESS_INVENTORY_COUNT;
	}
}
