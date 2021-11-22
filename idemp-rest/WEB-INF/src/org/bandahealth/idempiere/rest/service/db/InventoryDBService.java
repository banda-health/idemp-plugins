package org.bandahealth.idempiere.rest.service.db;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.stream.Collectors;

import org.adempiere.exceptions.DBException;
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

	public void updateStock(Inventory entity) {
		String whereClause = MProduct_BH.Table_Name + "." + MProduct_BH.COLUMNNAME_M_Product_ID + " IN ("
				+ entity.getProductId() + ")";
		List<MProduct_BH> products = new Query(Env.getCtx(), MProduct_BH.Table_Name, whereClause, null)
				.setClient_ID().list();
		InitializeStock.createInitialStock(products, BigDecimal.valueOf(entity.getQuantity()), Env.getCtx(), null);
	}
}