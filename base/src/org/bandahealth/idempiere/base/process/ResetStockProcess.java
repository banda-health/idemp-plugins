package org.bandahealth.idempiere.base.process;

import org.bandahealth.idempiere.base.model.MInventory_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.MDocType;
import org.compiere.model.MInventory;
import org.compiere.model.MInventoryLine;
import org.compiere.model.MLocator;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.Query;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.stream.Collectors;

/**
 * This process resets negative stocks to zero for a given client
 *
 * @author andrew
 */
public class ResetStockProcess extends SvrProcess {
	private final String PROCESS_NAME = this.getClass().getName();

	@Override
	protected void prepare() {
	}

	@Override
	protected String doIt() throws Exception {
		log.log(Level.INFO, "START " + PROCESS_NAME);

		List<MStorageOnHand> storageOnHand =
				new Query(Env.getCtx(), MStorageOnHand.Table_Name, MStorageOnHand.COLUMNNAME_QtyOnHand + "!=?",
						get_TrxName()).setParameters(0).setClient_ID().list();

		// Batch the locators and warehouses
		Set<Integer> locatorIds =
				storageOnHand.stream().map(MStorageOnHand::getM_Locator_ID).collect(Collectors.toSet());
		Map<Integer, MLocator> locatorsById =
				QueryUtil.getEntitiesByIds(getCtx(), MLocator.Table_Name, locatorIds, get_TrxName());
		Set<Integer> warehouseIds =
				locatorsById.values().stream().map(MLocator::getM_Warehouse_ID).collect(Collectors.toSet());
		Map<Integer, MWarehouse_BH> warehousesById =
				QueryUtil.getEntitiesByIds(getCtx(), MWarehouse_BH.Table_Name, warehouseIds, get_TrxName());

		int inventoryDocTypeId = MDocType.getDocType(MDocType.DOCBASETYPE_MaterialPhysicalInventory);

		// An inventory is specific to a warehouse, so cycle through and do one for each warehouse as needed
		for (MWarehouse_BH warehouse : warehousesById.values()) {
			MInventory inventory = new MInventory(getCtx(), 0, get_TrxName());
			inventory.setAD_Org_ID(warehouse.getAD_Org_ID());
			inventory.setM_Warehouse_ID(warehouse.get_ID());
			inventory.setC_DocType_ID(inventoryDocTypeId);
			inventory.saveEx();

			Map<Integer, MLocator> locatorsForThisWarehouse =
					locatorsById.values().stream().filter(locator -> locator.getM_Warehouse_ID() == warehouse.get_ID())
							.collect(Collectors.toMap(MLocator::get_ID, locator -> locator));
			Map<Integer, Map<Integer, Map<Integer, List<MStorageOnHand>>>>
					storageOnHandForThisWarehouse = storageOnHand.stream()
					.filter(storageOnHandRecord -> locatorsForThisWarehouse.containsKey(storageOnHandRecord.getM_Locator_ID()))
					.collect(Collectors.groupingBy(MStorageOnHand::getM_Locator_ID,
							Collectors.groupingBy(MStorageOnHand::getM_Product_ID,
									Collectors.groupingBy(MStorageOnHand::getM_AttributeSetInstance_ID))));
			//
			// Now with all the groupings, we'll loop through them and sum for the existing quantity
			storageOnHandForThisWarehouse.values().forEach(
					storageOnHandByLocatorId -> storageOnHandByLocatorId.values()
							.forEach(
									storageOnHandByLocatorIdThenByProductId -> storageOnHandByLocatorIdThenByProductId.values()
											.stream().filter(storageOnHandByLocatorIdTheByProductIdTheByAttributeSetInstanceId ->
													storageOnHandByLocatorIdTheByProductIdTheByAttributeSetInstanceId.stream()
															.map(MStorageOnHand::getQtyOnHand).reduce(BigDecimal.ZERO, BigDecimal::add)
															.compareTo(BigDecimal.ZERO) != 0)
											.forEach(storageOnHandByLocatorIdTheByProductIdTheByAttributeSetInstanceId -> {
												MInventoryLine inventoryLine = new MInventoryLine(getCtx(), 0, get_TrxName());
												inventoryLine.setM_Inventory_ID(inventory.get_ID());
												inventoryLine.setAD_Org_ID(inventory.getAD_Org_ID());

												// Since all the items in this list have the same locator, product, and ASI, we just need the
												// first
												MStorageOnHand storageOnHandByLocatorProductAttributeSetInstance =
														storageOnHandByLocatorIdTheByProductIdTheByAttributeSetInstanceId.get(0);
												inventoryLine.setM_Locator_ID(
														storageOnHandByLocatorProductAttributeSetInstance.getM_Locator_ID());
												inventoryLine.setM_Product_ID(
														storageOnHandByLocatorProductAttributeSetInstance.getM_Product_ID());
												inventoryLine.setM_AttributeSetInstance_ID(
														storageOnHandByLocatorProductAttributeSetInstance.getM_AttributeSetInstance_ID());

												// We're setting these to zero, but we also need to sum up everything for the quantity in the
												// book
												inventoryLine.setQtyCount(BigDecimal.ZERO);
												inventoryLine.setQtyBook(
														storageOnHandByLocatorIdTheByProductIdTheByAttributeSetInstanceId.stream()
																.map(MStorageOnHand::getQtyOnHand).reduce(BigDecimal.ZERO, BigDecimal::add));

												inventoryLine.saveEx();
											})));

			inventory.setDocAction(MInventory_BH.ACTION_Complete);
			inventory.processIt(MInventory_BH.ACTION_Complete);
			inventory.saveEx();
		}

		return "Successfully reset stock";
	}
}
