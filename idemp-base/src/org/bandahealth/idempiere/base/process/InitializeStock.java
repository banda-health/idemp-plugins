package org.bandahealth.idempiere.base.process;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.stream.Collectors;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.MDocType;
import org.compiere.model.MInventory;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.MWarehouse;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;

/**
 * Creates an initial stock with the given quantity or with a default value of 1
 *
 * @author andrew
 */
public class InitializeStock {

	private static CLogger log = CLogger.getCLogger(InitializeStock.class);
	private static int INVENTORY_DOC_TYPE = MDocType.getDocType(MDocType.DOCBASETYPE_MaterialPhysicalInventory);

	public static int createInitialStock(Map<MProduct_BH, List<MStorageOnHand>> inventoryByProduct, Properties context,
			String transactionName) {
		if (inventoryByProduct == null || inventoryByProduct.keySet().isEmpty()) {
			log.severe("No products were passed to initialize stock.");
			throw new AdempiereException("No products were passed to initialize stock.");
		}
		int count = 0;
		List<Integer> productIdsWithStock =
				getProductIdsWithInventory(new ArrayList<>(inventoryByProduct.keySet()), transactionName);

		MWarehouse[] warehouses = MWarehouse.getForOrg(context, Env.getAD_Org_ID(context));
		MWarehouse warehouse = null;
		if (warehouses != null && warehouses.length > 0) {
			warehouse = warehouses[0];
		} else {
			log.severe("No warehouses defined for organization.");
			throw new AdempiereException("No warehouses defined for organization.");
		}

		// Get the list of products that actually have inventory
		Set<MProduct_BH> productsWithInitialInventory = inventoryByProduct.entrySet().stream().filter(
				(inventoryByProductEntry) -> inventoryByProductEntry.getValue().stream().anyMatch(
						storageOnHand -> storageOnHand.getQtyOnHand() != null &&
								storageOnHand.getQtyOnHand().compareTo(BigDecimal.ZERO) > 0)).map(Map.Entry::getKey)
				.collect(Collectors.toSet());

		int inventoryDocTypeId = MDocType.getDocType(MDocType.DOCBASETYPE_MaterialPhysicalInventory);
		for (MProduct_BH product : productsWithInitialInventory) {
			if (productIdsWithStock.contains(product.get_ID())) {
				log.log(Level.SEVERE, "There is an existing stock for product id = " + product.get_ID());
				continue;
			}

			MInventory inventory = new MInventory(product.getCtx(), 0, transactionName);
			inventory.setAD_Org_ID(Env.getAD_Org_ID(context));

			inventory.setM_Warehouse_ID(warehouse.get_ID());

			inventory.setC_DocType_ID(inventoryDocTypeId);
			inventory.save(transactionName);

			MWarehouse finalWarehouse = warehouse;
			inventoryByProduct.get(product).forEach((storageOnHand -> {
				MInventoryLine_BH inventoryLine = new MInventoryLine_BH(context, 0, transactionName);
				inventoryLine.setM_Product_ID(product.get_ID());
				inventoryLine.setM_Inventory_ID(inventory.get_ID());

				// Only set the attribute set instance ID (i.e. expiration date) if one was provided
				if (storageOnHand.getM_AttributeSetInstance_ID() > 0) {
					inventoryLine.setM_AttributeSetInstance_ID(storageOnHand.getM_AttributeSetInstance_ID());
				}
				inventoryLine.setQtyCount(storageOnHand.getQtyOnHand());
				inventoryLine.setM_Locator_ID(finalWarehouse.getDefaultLocator().get_ID());

				inventoryLine.save(product.get_TrxName());
			}));

			inventory.completeIt();
			count++;
		}

		return count;
	}

	public static int createInitialStock(List<MProduct_BH> products, BigDecimal quantity, Properties context,
			String transactionName) {
		if (products == null) {
			log.severe("No products were passed to initialize stock.");
			throw new AdempiereException("No products were passed to initialize stock.");
		}
		int count = 0;
		List<Integer> productIdsWithStock = getProductIdsWithInventory(products, transactionName);

		MWarehouse[] warehouses = MWarehouse.getForOrg(context, Env.getAD_Org_ID(context));
		MWarehouse warehouse = null;
		if (warehouses != null && warehouses.length > 0) {
			warehouse = warehouses[0];
		} else {
			log.severe("No warehouses defined for organization.");
			throw new AdempiereException("No warehouses defined for organization.");
		}

		for (MProduct_BH product : products) {
			if (productIdsWithStock.contains(product.get_ID())) {
				log.log(Level.SEVERE, "There is an existing stock for product id = " + product.get_ID());
				continue;
			}

			MInventory inventory = new MInventory(product.getCtx(), 0, transactionName);
			inventory.setAD_Org_ID(Env.getAD_Org_ID(context));

			inventory.setM_Warehouse_ID(warehouse.get_ID());

			inventory.setC_DocType_ID(INVENTORY_DOC_TYPE);
			inventory.save(transactionName);

			MInventoryLine_BH inventoryLine = new MInventoryLine_BH(context, 0, transactionName);
			inventoryLine.setM_Product_ID(product.get_ID());
			inventoryLine.setM_Inventory_ID(inventory.get_ID());
			inventoryLine.setQtyCount(
					quantity != null && quantity.compareTo(BigDecimal.ZERO) > 0 ? quantity : BigDecimal.ONE);
			inventoryLine.setM_Locator_ID(warehouse.getDefaultLocator().get_ID());

			inventoryLine.save(product.get_TrxName());

			inventory.completeIt();
			count++;
		}

		return count;
	}

	/**
	 * Need to verify that no mstorage record exists to avoid duplicates
	 *
	 * @param transactionName
	 * @return
	 */
	private static List<Integer> getProductIdsWithInventory(List<MProduct_BH> products, String transactionName) {
		Set<Integer> productIDs = products.stream().map(PO::get_ID).collect(Collectors.toSet());
		List<Object> parameters = new ArrayList<>();
		String whereCondition = QueryUtil.getWhereClauseAndSetParametersForSet(productIDs, parameters);
		String whereClause =
				MProduct_BH.Table_Name + "." + MProduct_BH.COLUMNNAME_M_Product_ID + " IN (" + whereCondition + ") AND "
						+ MProduct_BH.Table_Name + "." + MProduct_BH.COLUMNNAME_M_Product_ID + " IN (SELECT "
						+ MStorageOnHand.Table_Name + "." + MStorageOnHand.COLUMNNAME_M_Product_ID + " FROM "
						+ MStorageOnHand.Table_Name + ")";

		return new Query(Env.getCtx(), MProduct_BH.Table_Name, whereClause, transactionName)
				.setParameters(parameters)
				.setClient_ID().list().stream().map(PO::get_ID).collect(Collectors.toList());
	}
}
