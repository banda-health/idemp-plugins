package org.bandahealth.idempiere.base.process;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;

import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.compiere.model.MInventory;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.MWarehouse;
import org.compiere.model.Query;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;

public class InitializeStockProcess extends SvrProcess {

	@Override
	protected void prepare() {
	}

	@Override
	protected String doIt() throws Exception {
		long start = System.currentTimeMillis();
		log.log(Level.INFO, "START InitializeStockProcess");

		int count = 0;
		String whereClause = MProduct_BH.Table_Name + "." + MProduct_BH.COLUMNNAME_M_Product_ID + " NOT IN (SELECT "
				+ MStorageOnHand.Table_Name + "." + MStorageOnHand.COLUMNNAME_M_Product_ID + " FROM "
				+ MStorageOnHand.Table_Name + ")";
		List<MProduct_BH> products = new Query(Env.getCtx(), MProduct_BH.Table_Name, whereClause, get_TrxName())
				.setClient_ID().list();
		for (MProduct_BH product : products) {
			MInventory inventory = new MInventory(product.getCtx(), 0, get_TrxName());
			inventory.setAD_Org_ID(Env.getAD_Org_ID(getCtx()));

			MWarehouse[] warehouses = MWarehouse.getForOrg(getCtx(), Env.getAD_Org_ID(getCtx()));
			MWarehouse warehouse = null;
			if (warehouses != null && warehouses.length > 0) {
				warehouse = warehouses[0];
				inventory.setM_Warehouse_ID(warehouse.get_ID());
			}

			inventory.setC_DocType_ID(10);
			inventory.save(get_TrxName());

			MInventoryLine_BH inventoryLine = new MInventoryLine_BH(getCtx(), 0, get_TrxName());
			inventoryLine.setM_Product_ID(product.get_ID());
			inventoryLine.setM_Inventory_ID(inventory.get_ID());
			inventoryLine.setQtyCount(BigDecimal.ONE);
			inventoryLine.setM_Locator_ID(warehouse.getDefaultLocator().get_ID());

			inventoryLine.save(get_TrxName());

			inventory.completeIt();
			count++;
		}

		String msg = "STOP InitializeStockProcess. Took " + (System.currentTimeMillis() - start) / 1000 / 60
				+ " mins. Processed " + count + " product(s).";
		log.log(Level.INFO, msg);

		return msg;
	}

}
