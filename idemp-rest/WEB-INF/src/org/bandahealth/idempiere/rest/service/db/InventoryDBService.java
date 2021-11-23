package org.bandahealth.idempiere.rest.service.db;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.stream.Collectors;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.exceptions.DBException;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MInventory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.X_BH_Stocktake_v;
import org.bandahealth.idempiere.base.process.InitializeStock;
import org.bandahealth.idempiere.base.process.UpdateStock;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Inventory;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.FilterUtil;
import org.bandahealth.idempiere.rest.utils.SqlUtil;
import org.compiere.model.MDocType;
import org.compiere.model.MInventory;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.MWarehouse;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;

import static org.bandahealth.idempiere.rest.service.db.BaseDBService.*;

public class InventoryDBService {

	private final String DEFAULT_SEARCH_COLUMN = X_BH_Stocktake_v.COLUMNNAME_Product;
	private final String DEFAULT_SEARCH_CLAUSE = "LOWER(" + DEFAULT_SEARCH_COLUMN + ") " + LIKE_COMPARATOR + " ? ";
	protected CLogger log = CLogger.getCLogger(InventoryDBService.class);

	public BaseListResponse<Inventory> getInventory(Paging pagingInfo, String sortColumn, String sortOrder,
			String filterJson) throws DBException {
		return this.getInventory(pagingInfo, null, null, sortColumn, sortOrder, filterJson);
	}

	public BaseListResponse<Inventory> searchInventory(Paging pagingInfo, String value, String sortColumn,
			String sortOrder, String filterJson) throws DBException {
		return this.getInventory(pagingInfo, value, null, sortColumn, sortOrder, filterJson);
	}

	/**
	 * Get the inventory of a particular product
	 *
	 * @param productId The ID of the product to get inventory for
	 * @return The product's inventory.
	 * @throws DBException
	 */
	public BigDecimal getProductInventoryCount(Integer productId) throws DBException {
		BaseListResponse<Inventory> inventoryList = this.getInventory(Paging.ALL.getInstance(), null, productId, null,
				null, null);

		return inventoryList.getResults().stream().reduce(BigDecimal.ZERO,
				(subtotal, item) -> subtotal.add(BigDecimal.valueOf(item.getQuantity())), BigDecimal::add);
	}

	public BaseListResponse<Inventory> getProductInventory(Paging pagingInfo, Integer productId) throws DBException {
		return this.getInventory(pagingInfo, null, productId, X_BH_Stocktake_v.COLUMNNAME_expirationdate,
				ASCENDING_ORDER, null);
	}

	private BaseListResponse<Inventory> getInventory(Paging pagingInfo, String searchValue, Integer productId,
			String sortColumn, String sortOrder, String filterJson) throws DBException {
		List<Inventory> results = new ArrayList<>();

		List<String> viewColumnsToUse = new ArrayList<>(
				Arrays.asList(X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_M_Product_ID,
						X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_M_Warehouse_ID,
						X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_Product,
						X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_expirationdate,
						X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_quantity,
						X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_ShelfLifeDays,
						X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_M_AttributeSetInstance_ID,
						X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_AD_Client_ID,
						X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_AD_Org_ID,
						X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_Created,
						X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_CreatedBy,
						X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_Description));

		StringBuilder sqlSelect = new StringBuilder().append("SELECT ").append(String.join(", ", viewColumnsToUse))
				.append(" FROM ").append(X_BH_Stocktake_v.Table_Name).append(" ");

		StringBuilder sqlJoin = new StringBuilder().append(" LEFT JOIN ").append(MWarehouse.Table_Name).append(" ON ")
				.append(MWarehouse.Table_Name + "." + MWarehouse.COLUMNNAME_M_Warehouse_ID).append(" = ")
				.append(X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_M_Warehouse_ID).append(" ");

		StringBuilder sqlWhere = new StringBuilder().append("WHERE ")
				.append(X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_AD_Client_ID).append(" =?")
				.append(AND_OPERATOR).append(X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_AD_Org_ID)
				.append(" =?");

		List<Object> parameters = new ArrayList<>();
		parameters.add(Env.getAD_Client_ID(Env.getCtx()));
		parameters.add(Env.getAD_Org_ID(Env.getCtx()));

		sqlWhere.append(AND_OPERATOR)
				.append(FilterUtil.getWhereClauseFromFilter(X_BH_Stocktake_v.Table_Name, filterJson, parameters, true));

		if (searchValue != null && !searchValue.isEmpty()) {
			sqlWhere.append(AND_OPERATOR).append("LOWER(")
					.append(X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_Product).append(") ")
					.append(LIKE_COMPARATOR).append(" ?");
			parameters.add("%" + searchValue.toLowerCase() + "%");
		}

		if (productId != null) {
			sqlWhere.append(AND_OPERATOR)
					.append(X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_M_Product_ID)
					.append(EQUAL_OPERATOR).append(" ?");
			parameters.add(productId);
		}

		StringBuilder sqlOrderBy = new StringBuilder().append(" order by ");
		if (sortColumn != null && !sortColumn.isEmpty() && sortOrder != null && !sortOrder.isEmpty() && viewColumnsToUse
				.stream().map(String::toLowerCase).collect(Collectors.toList()).contains(sortColumn)) {
			sqlOrderBy.append(sortColumn).append(" ").append(sortOrder).append(ORDERBY_NULLS_LAST);
		} else {
			sqlOrderBy.append(X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_Product).append(" ")
					.append(ASCENDING_ORDER).append(ORDERBY_NULLS_LAST);
		}

		String sqlToUse = sqlSelect.append(sqlJoin).append(sqlWhere.toString()).append(sqlOrderBy.toString())
				.toString();

		if (pagingInfo.getPageSize() > 0) {
			if (DB.getDatabase().isPagingSupported()) {
				sqlToUse = DB.getDatabase().addPagingSQL(sqlToUse,
						(pagingInfo.getPageSize() * pagingInfo.getPage()) + 1,
						pagingInfo.getPageSize() * (pagingInfo.getPage() + 1));
			}
		}

		pagingInfo.setTotalRecordCount(getTotalRecordCount(sqlJoin.toString() + sqlWhere.toString(), parameters));
		SqlUtil.executeQuery(sqlToUse, parameters, null, resultSet -> {
			try {
				Inventory inventory = new Inventory(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
						DateUtil.parseDateOnly(resultSet.getTimestamp(4)), resultSet.getInt(5), resultSet.getInt(6),
						resultSet.getInt(7), resultSet.getInt(8), resultSet.getInt(9),
						DateUtil.parse(resultSet.getTimestamp(10)), resultSet.getInt(11), resultSet.getString(12));
				results.add(inventory);
			} catch (Exception ex) {
				log.warning("Error processing inventory items: " + ex.getMessage());
			}
		});

		return new BaseListResponse<Inventory>(results, pagingInfo);
	}

	/**
	 * Get Total Count
	 *
	 * @param searchValue
	 * @return
	 */
	private int getTotalRecordCount(String sqlWhere, List<Object> parameters) {
		return SqlUtil.getCount(X_BH_Stocktake_v.Table_Name, sqlWhere, parameters);
	}

	public void initializeStock(Map<MProduct_BH, List<MStorageOnHand>> inventoryByProduct) {
		InitializeStock.createInitialStock(inventoryByProduct, Env.getCtx(), null);
	}

	public Integer updateStockItem(Inventory entity) {
		String whereClause = MProduct_BH.Table_Name + "." + MProduct_BH.COLUMNNAME_M_Product_ID + " IN ("
				+ entity.getProductId() + ")";
		MProduct_BH productToUpdate = new Query(Env.getCtx(), MProduct_BH.Table_Name, whereClause, null)
				.setClient_ID().first();
		MStorageOnHand updateStorangeOnHand = new MStorageOnHand(Env.getCtx(), 0, null);
		updateStorangeOnHand.setM_AttributeSetInstance_ID(entity.getAttributeSetInstanceId());
		updateStorangeOnHand.setQtyOnHand(BigDecimal.valueOf(entity.getQuantity()));
		Map<MProduct_BH, List<MStorageOnHand>> updateEntry = new HashMap<>();
		updateEntry.put(productToUpdate, Collections.singletonList(updateStorangeOnHand));
		
		if (updateEntry == null || updateEntry.keySet().isEmpty()) {
			log.severe("No products were passed to initialize stock.");
			throw new AdempiereException("No products were passed to initialize stock.");
		}
		int count = 0;
		
		Integer warehouseId = entity.getWarehouseId();
		MWarehouse warehouse = null;
		if (warehouseId == 0) {
			MWarehouse[] warehouses = MWarehouse.getForOrg(Env.getCtx(), Env.getAD_Org_ID(Env.getCtx()));
			if (warehouses != null && warehouses.length > 0) {
				warehouse = warehouses[0];
			} else {
				log.severe("No warehouses defined for organization.");
				throw new AdempiereException("No warehouses defined for organization.");
			}
		} else {
			warehouse = MWarehouse.get(Env.getCtx(), warehouseId);
		}

		// Get the list of products that actually have inventory
		Set<MProduct_BH> productsWithInitialInventory = updateEntry.entrySet().stream().filter(
						(inventoryByProductEntry) -> inventoryByProductEntry.getValue().stream().anyMatch(
								storageOnHand ->  storageOnHand.getQtyOnHand() != null &&
										storageOnHand.getQtyOnHand().compareTo(BigDecimal.ZERO) > 0)).map(Map.Entry::getKey)
				.collect(Collectors.toSet());

		Map<MProduct_BH, List<MStorageOnHand>> existingInventoryByProduct =
				InitializeStock.getProductsAndInventory(new ArrayList<>(updateEntry.keySet()), Env.getCtx(), null);

		int inventoryDocTypeId = MDocType.getDocType(MDocType.DOCBASETYPE_MaterialPhysicalInventory);

		MInventory_BH inventory = new MInventory_BH(Env.getCtx(), 0, null);
		inventory.setAD_Org_ID(warehouse.getAD_Org_ID());

		inventory.setM_Warehouse_ID(warehouse.get_ID());

		inventory.setC_DocType_ID(inventoryDocTypeId);
		inventory.setUpdateReasonId(entity.getUpdateReason());
		inventory.save(null);

			MWarehouse finalWarehouse = warehouse;
			for (MProduct_BH product : productsWithInitialInventory) {
				
				updateEntry.get(product).forEach((storageOnHand -> {
					BigDecimal desiredQuantityOnHand = storageOnHand.getQtyOnHand();
					List<MStorageOnHand> existingInventoryList = existingInventoryByProduct.get(product);

					// If we should merge, we have to subtract out what's existing
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

					MInventoryLine_BH inventoryLine = new MInventoryLine_BH(Env.getCtx(), 0, null);
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
						
}