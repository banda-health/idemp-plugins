package org.bandahealth.idempiere.base.process;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
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

	public static int createInitialStock(Map<MProduct_BH, List<MStorageOnHand>> inventoryByProduct, Properties context,
			String transactionName) {
		return createInitialStock(inventoryByProduct, context, transactionName, false, 0);
	}

	public static int createInitialStock(Map<MProduct_BH, List<MStorageOnHand>> inventoryByProduct, Properties context,
			String transactionName, boolean shouldMergeInventory, int warehouseId) {
		if (inventoryByProduct == null || inventoryByProduct.keySet().isEmpty()) {
			log.severe("No products were passed to initialize stock.");
			throw new AdempiereException("No products were passed to initialize stock.");
		}
		int count = 0;

		MWarehouse warehouse = null;
		if (warehouseId == 0) {
			MWarehouse[] warehouses = MWarehouse.getForOrg(context, Env.getAD_Org_ID(context));
			if (warehouses != null && warehouses.length > 0) {
				warehouse = warehouses[0];
			} else {
				log.severe("No warehouses defined for organization.");
				throw new AdempiereException("No warehouses defined for organization.");
			}
		} else {
			warehouse = MWarehouse.get(context, warehouseId);
		}

		// Get the list of products that actually have inventory
		Set<MProduct_BH> productsWithInitialInventory = inventoryByProduct.entrySet().stream().filter(
						(inventoryByProductEntry) -> inventoryByProductEntry.getValue().stream().anyMatch(
								storageOnHand -> storageOnHand.getQtyOnHand() != null &&
								//update this check for 0 qty updates
										storageOnHand.getQtyOnHand().compareTo(BigDecimal.ZERO) > 0)).map(Map.Entry::getKey)
				.collect(Collectors.toSet());

		Map<MProduct_BH, List<MStorageOnHand>> existingInventoryByProduct =
				getProductsAndInventory(new ArrayList<>(inventoryByProduct.keySet()), context, transactionName);
		List<Integer> productIdsWithStock =
				existingInventoryByProduct.keySet().stream().map(MProduct_BH::get_ID).collect(Collectors.toList());

		int inventoryDocTypeId = MDocType.getDocType(MDocType.DOCBASETYPE_MaterialPhysicalInventory);

		MInventory inventory = new MInventory(context, 0, transactionName);
		inventory.setAD_Org_ID(warehouse.getAD_Org_ID());

		inventory.setM_Warehouse_ID(warehouse.get_ID());

		inventory.setC_DocType_ID(inventoryDocTypeId);
		inventory.save(transactionName);

		MWarehouse finalWarehouse = warehouse;
		for (MProduct_BH product : productsWithInitialInventory) {
			if (!shouldMergeInventory && productIdsWithStock.contains(product.get_ID())) {
				log.log(Level.SEVERE, "There is an existing stock for product id = " + product.get_ID());
				continue;
			}

			inventoryByProduct.get(product).forEach((storageOnHand -> {
				BigDecimal desiredQuantityOnHand = storageOnHand.getQtyOnHand();
				List<MStorageOnHand> existingInventoryList = existingInventoryByProduct.get(product);

				// If we should merge, we have to subtract out what's existing
				if (shouldMergeInventory && existingInventoryList != null && !existingInventoryList.isEmpty()) {
					MStorageOnHand existingInventory = existingInventoryList.get(0);
					if (product.isBH_HasExpiration()) {
						existingInventory = existingInventoryList.stream().filter(
										existingStorageOnHand -> existingStorageOnHand.getM_AttributeSetInstance_ID() ==
												existingStorageOnHand.getM_AttributeSetInstance_ID()).findFirst()
								.orElse(existingInventoryList.get(0));
					}
					// If current quantity equals desired quantity, exit out
					if (existingInventory.getQtyOnHand().compareTo(desiredQuantityOnHand) == 0) {
						return;
					}
					desiredQuantityOnHand = desiredQuantityOnHand.subtract(existingInventory.getQtyOnHand());
				}

				MInventoryLine_BH inventoryLine = new MInventoryLine_BH(context, 0, transactionName);
				inventoryLine.setAD_Org_ID(inventory.getAD_Org_ID());
				inventoryLine.setM_Product_ID(product.get_ID());
				inventoryLine.setM_Inventory_ID(inventory.get_ID());

				// Only set the attribute set instance ID (i.e. expiration date) if one was provided
				if (storageOnHand.getM_AttributeSetInstance_ID() > 0) {
					inventoryLine.setM_AttributeSetInstance_ID(storageOnHand.getM_AttributeSetInstance_ID());
				}
				inventoryLine.setQtyCount(desiredQuantityOnHand);
				inventoryLine.setM_Locator_ID(finalWarehouse.getDefaultLocator().get_ID());

				inventoryLine.save(product.get_TrxName());
			}));
			count++;
		}

		inventory.completeIt();

		return count;
	}


	public static int createInitialStock(List<MProduct_BH> products, BigDecimal quantity, Properties context,
			String transactionName) {
		if (products == null) {
			log.severe("No products were passed to initialize stock.");
			throw new AdempiereException("No products were passed to initialize stock.");
		}
		return createInitialStock(products.stream().collect(Collectors.toMap(product -> product, product -> {
					MStorageOnHand storageOnHand = new MStorageOnHand(context, 0, transactionName);
					storageOnHand.setQtyOnHand(quantity);
					return Collections.singletonList(storageOnHand);
				}, (existingStorageOnHandForProduct, duplicateStorageOnHandForProduct) -> existingStorageOnHandForProduct)),
				context, transactionName);
	}

	/**
	 * Need to verify that no mstorage record exists to avoid duplicates
	 *
	 * @param transactionName
	 * @return
	 */
	public static Map<MProduct_BH, List<MStorageOnHand>> getProductsAndInventory(List<MProduct_BH> products,
			Properties context, String transactionName) {
		Map<Integer, MProduct_BH> productsById =
				products.stream().collect(Collectors.toMap(MProduct_BH::get_ID, product -> product));
		List<Object> parameters = new ArrayList<>();
		String whereCondition = QueryUtil.getWhereClauseAndSetParametersForSet(productsById.keySet(), parameters);
		String whereClause =
				MProduct_BH.Table_Name + "." + MProduct_BH.COLUMNNAME_M_Product_ID + " IN (" + whereCondition + ") AND "
						+ MProduct_BH.Table_Name + "." + MProduct_BH.COLUMNNAME_M_Product_ID + " IN (SELECT "
						+ MStorageOnHand.Table_Name + "." + MStorageOnHand.COLUMNNAME_M_Product_ID + " FROM "
						+ MStorageOnHand.Table_Name + ")";

		List<MStorageOnHand> storageOnHandList = new Query(context, MStorageOnHand.Table_Name,
				MStorageOnHand.COLUMNNAME_M_Product_ID + " IN (" + whereCondition + ")", transactionName).setParameters(
				parameters).list();

		return storageOnHandList.stream().collect(Collectors.groupingBy(MStorageOnHand::getM_Product_ID)).entrySet()
				.stream()
				.collect(Collectors.toMap(entrySet -> productsById.get(entrySet.getKey()), Map.Entry::getValue));
	}
}
