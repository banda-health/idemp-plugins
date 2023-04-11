package org.bandahealth.idempiere.base.process;

import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.MAttributeSetInstance;
import org.compiere.model.MDocType;
import org.compiere.model.MInventory;
import org.compiere.model.MLocator;
import org.compiere.model.MPInstance;
import org.compiere.model.MProcess;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfo;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.ServerProcessCtl;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.stream.Collectors;

/**
 * This process resets expired stocks to zero for a given client
 *
 * @author clinton
 */

public class CleanExpiredStockProcess extends SvrProcess {

	private final String PROCESS_NAME = this.getClass().getName();
	public static final String PARAMETERNAME_C_DocType_ID = "C_DocType_ID";
	private static final String STORAGE_CLEANUP_PROCESS_STRING = "8e270648-1d54-46d9-9161-2d0300dd80ff";

	@Override
	protected void prepare() {
	}

	@Override
	protected String doIt() throws Exception {
		log.log(Level.INFO, "START " + PROCESS_NAME);

		List<MStorageOnHand> expiredStocks = new Query(Env.getCtx(), MStorageOnHand.Table_Name,
				MAttributeSetInstance.Table_Name + "." + MAttributeSetInstance.COLUMNNAME_GuaranteeDate + " < now() AND " +
						MStorageOnHand.Table_Name + "." + MStorageOnHand.COLUMNNAME_QtyOnHand + "!=0", get_TrxName()).addJoinClause(
				"JOIN " + MAttributeSetInstance.Table_Name + " ON " + MAttributeSetInstance.Table_Name + "." +
						MAttributeSetInstance.COLUMNNAME_M_AttributeSetInstance_ID + "=" + MStorageOnHand.Table_Name + "." +
						MStorageOnHand.COLUMNNAME_M_AttributeSetInstance_ID).setClient_ID().setOnlyActiveRecords(true).list();
		clearInventoryForExpiredStorage(expiredStocks);

		MProcess mprocess = new Query(Env.getCtx(), MProcess.Table_Name, MProcess.COLUMNNAME_AD_Process_UU + "=?",
				get_TrxName()).setOnlyActiveRecords(true).setParameters(STORAGE_CLEANUP_PROCESS_STRING).first();

		MPInstance mpInstance = new MPInstance(mprocess, 0);

		ProcessInfo processInfo = new ProcessInfo(mprocess.getName(), mprocess.getAD_Process_ID());
		processInfo.setAD_PInstance_ID(mpInstance.getAD_PInstance_ID());
		processInfo.setAD_Process_UU(mprocess.getAD_Process_UU());

		processInfo.setParameter(new ProcessInfoParameter[]{
				new ProcessInfoParameter(PARAMETERNAME_C_DocType_ID,
						MDocType.getDocType(MDocType.DOCBASETYPE_MaterialMovement),
						null, null, null)});

		ServerProcessCtl.process(processInfo, null);

		return processInfo.getSummary();
	}

	private void clearInventoryForExpiredStorage(List<MStorageOnHand> expiredStorageOnHand) {
		// Batch the locators and warehouses
		Set<Integer> locatorIds =
				expiredStorageOnHand.stream().map(MStorageOnHand::getM_Locator_ID).collect(Collectors.toSet());
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
			inventory.save();

			Map<Integer, MLocator> locatorsForThisWarehouse =
					locatorsById.values().stream().filter(locator -> locator.getM_Warehouse_ID() == warehouse.get_ID())
							.collect(Collectors.toMap(MLocator::get_ID, locator -> locator));
			Map<Integer, Map<Integer, Map<Integer, List<MStorageOnHand>>>>
					expiredStorageOnHandForThisWarehouseByLocatorIdThenProductIdThenAttributeSetInstanceId =
					expiredStorageOnHand.stream()
							.filter(storageOnHand -> locatorsForThisWarehouse.containsKey(storageOnHand.getM_Locator_ID()))
							.collect(Collectors.groupingBy(MStorageOnHand::getM_Locator_ID,
									Collectors.groupingBy(MStorageOnHand::getM_Product_ID,
											Collectors.groupingBy(MStorageOnHand::getM_AttributeSetInstance_ID))));
			// Now with all the groupings, we'll loop through them and sum for the existing quantity
			expiredStorageOnHandForThisWarehouseByLocatorIdThenProductIdThenAttributeSetInstanceId.values().forEach(
					expiredStorageOnHandByLocatorId -> expiredStorageOnHandByLocatorId.values()
							.forEach(
									expiredStorageOnHandByLocatorIdThenByProductId -> expiredStorageOnHandByLocatorIdThenByProductId.values()
											.forEach(expiredStorageOnHandByLocatorIdTheByProductIdTheByAttributeSetInstanceId -> {
												MInventoryLine_BH inventoryLine = new MInventoryLine_BH(getCtx(), 0, get_TrxName());
												inventoryLine.setM_Inventory_ID(inventory.get_ID());
												inventoryLine.setAD_Org_ID(inventory.getAD_Org_ID());

												// Since all the items in this list have the same locator, product, and ASI, we just need the
												// first
												MStorageOnHand storageOnHandByLocatorProductAttributeSetInstance =
														expiredStorageOnHandByLocatorIdTheByProductIdTheByAttributeSetInstanceId.get(0);
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
														expiredStorageOnHandByLocatorIdTheByProductIdTheByAttributeSetInstanceId.stream()
																.map(MStorageOnHand::getQtyOnHand).reduce(BigDecimal.ZERO, BigDecimal::add));

												inventoryLine.saveEx();
											})));

			inventory.completeIt();
			inventory.saveEx();
		}
	}
}
