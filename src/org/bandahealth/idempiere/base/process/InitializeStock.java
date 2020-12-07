package org.bandahealth.idempiere.base.process;

import java.math.BigDecimal;
import java.util.Properties;
import java.util.logging.Level;

import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.compiere.model.MDocType;
import org.compiere.model.MInventory;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.MWarehouse;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;

/**
 * Creates an initial stock with the given quantity or with a default value of 1
 * 
 * @author andrew
 *
 */
public class InitializeStock {

	private static CLogger log = CLogger.getCLogger (InitializeStock.class);
	private static int INVENTORY_DOC_TYPE = MDocType.getDocType(MDocType.DOCBASETYPE_MaterialPhysicalInventory);
	
	public static void createInitialStock(MProduct_BH product, BigDecimal quantity, Properties context, String transactionName) {
		if (checkInventoryExists(product, transactionName)) {
			log.log(Level.SEVERE, "There is an existing stock for product id = " + product.get_ID());
			return;
		}
		
		MInventory inventory = new MInventory(product.getCtx(), 0, transactionName);
		inventory.setAD_Org_ID(Env.getAD_Org_ID(context));

		MWarehouse[] warehouses = MWarehouse.getForOrg(context, Env.getAD_Org_ID(context));
		MWarehouse warehouse = null;
		if (warehouses != null && warehouses.length > 0) {
			warehouse = warehouses[0];
			inventory.setM_Warehouse_ID(warehouse.get_ID());
		}
		
		inventory.setC_DocType_ID(INVENTORY_DOC_TYPE);
		inventory.save(transactionName);
		
		MInventoryLine_BH inventoryLine = new MInventoryLine_BH(context, 0, transactionName);
		inventoryLine.setM_Product_ID(product.get_ID());
		inventoryLine.setM_Inventory_ID(inventory.get_ID());
		inventoryLine.setQtyCount(quantity != null && quantity.compareTo(BigDecimal.ZERO) > 0 ? quantity: BigDecimal.ONE);
		inventoryLine.setM_Locator_ID(warehouse.getDefaultLocator().get_ID());

		inventoryLine.save(product.get_TrxName());

		inventory.completeIt();
	}

	/**
	 * Need to verify that no mstorage record exists to avoid duplicates
	 * 
	 * @param transactionName
	 * @return
	 */
	private static boolean checkInventoryExists(MProduct_BH product, String transactionName) {
		String whereClause = MProduct_BH.Table_Name + "." + MProduct_BH.COLUMNNAME_M_Product_ID + " = ? AND "
				+ MProduct_BH.Table_Name + "." + MProduct_BH.COLUMNNAME_M_Product_ID + " IN (SELECT "
				+ MStorageOnHand.Table_Name + "." + MStorageOnHand.COLUMNNAME_M_Product_ID + " FROM "
				+ MStorageOnHand.Table_Name + ")";
		
		Query query = new Query(Env.getCtx(), MProduct_BH.Table_Name, whereClause, transactionName)
				.setParameters(product.get_ID())
				.setClient_ID();
		
		return query.match();

	}
}
