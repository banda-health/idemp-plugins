package org.bandahealth.idempiere.rest.service.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

import org.adempiere.exceptions.DBException;
import org.bandahealth.idempiere.base.model.X_BH_Stocktake_v;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Inventory;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.compiere.model.MUser;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;

import static org.bandahealth.idempiere.rest.service.db.BaseDBService.*;

public class InventoryDBService {

	protected CLogger log = CLogger.getCLogger(InventoryDBService.class);

	private final String DEFAULT_SEARCH_COLUMN = X_BH_Stocktake_v.COLUMNNAME_Product;
	private final String DEFAULT_SEARCH_CLAUSE = "LOWER(" + DEFAULT_SEARCH_COLUMN + ") " + LIKE_COMPARATOR + " ? ";

	public BaseListResponse<Inventory> getInventory(Paging pagingInfo, String sortColumn, String sortOrder)
			throws DBException {
		return this.getInventory(pagingInfo, null, sortColumn, sortOrder);
	}

	public BaseListResponse<Inventory> searchInventory(Paging pagingInfo, String value, String sortColumn,
			String sortOrder) throws DBException {
		return this.getInventory(pagingInfo, value, sortColumn, sortOrder);
	}

	private BaseListResponse<Inventory> getInventory(Paging pagingInfo, String searchValue, String sortColumn,
			String sortOrder) throws DBException {
		List<Inventory> results = new ArrayList<>();

		List<String> viewColumnsToUse = new ArrayList<>(
				Arrays.asList(X_BH_Stocktake_v.COLUMNNAME_M_Product_ID, X_BH_Stocktake_v.COLUMNNAME_M_Warehouse_ID,
						X_BH_Stocktake_v.COLUMNNAME_Product, X_BH_Stocktake_v.COLUMNNAME_expirationdate,
						X_BH_Stocktake_v.COLUMNNAME_quantity, X_BH_Stocktake_v.COLUMNNAME_ShelfLifeDays,
						X_BH_Stocktake_v.COLUMNNAME_M_AttributeSetInstance_ID, X_BH_Stocktake_v.COLUMNNAME_AD_Client_ID,
						X_BH_Stocktake_v.COLUMNNAME_AD_Org_ID, X_BH_Stocktake_v.COLUMNNAME_Created,
						X_BH_Stocktake_v.COLUMNNAME_CreatedBy, X_BH_Stocktake_v.COLUMNNAME_Description));

		StringBuilder sqlSelect = new StringBuilder().append("SELECT ").append(String.join(", ", viewColumnsToUse))
				.append(" FROM ").append(X_BH_Stocktake_v.Table_Name).append(" ");
		StringBuilder sqlWhere = new StringBuilder().append("WHERE ").append(X_BH_Stocktake_v.COLUMNNAME_AD_Client_ID)
				.append(" =?").append(AND_OPERATOR).append(X_BH_Stocktake_v.COLUMNNAME_AD_Org_ID).append(" =?");

		List<Object> parameters = new ArrayList<>();
		parameters.add(Env.getAD_Client_ID(Env.getCtx()));
		parameters.add(Env.getAD_Org_ID(Env.getCtx()));

		if (searchValue != null && !searchValue.isEmpty()) {
			sqlWhere
					.append(AND_OPERATOR).append("LOWER(").append(X_BH_Stocktake_v.COLUMNNAME_Product)
					.append(") ").append(LIKE_COMPARATOR).append(" ?");
			parameters.add("%" + searchValue.toLowerCase() + "%");
		}

		StringBuilder sqlOrderBy = new StringBuilder().append(" order by ");
		if (sortColumn != null && !sortColumn.isEmpty() && sortOrder != null && !sortOrder.isEmpty()
				&& viewColumnsToUse.stream().map(String::toLowerCase).collect(Collectors.toList()).contains(sortColumn)) {
			sqlOrderBy.append(sortColumn).append(" ").append(sortOrder).append(ORDERBY_NULLS_LAST);
		} else {
			sqlOrderBy
					.append(X_BH_Stocktake_v.COLUMNNAME_Product)
					.append(" ")
					.append(ASCENDING_ORDER)
					.append(ORDERBY_NULLS_LAST);
		}

		String sqlToUse = sqlSelect.append(sqlWhere.toString()).append(sqlOrderBy.toString()).toString();

		if (pagingInfo.getPageSize() > 0) {
			if (DB.getDatabase().isPagingSupported()) {
				sqlToUse = DB.getDatabase().addPagingSQL(sqlToUse,
						(pagingInfo.getPageSize() * pagingInfo.getPage()) + 1,
						pagingInfo.getPageSize() * (pagingInfo.getPage() + 1));
			}
		}

		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = DB.prepareStatement(sqlToUse, null);
			DB.setParameters(statement, parameters);

			// get total count without pagination parameters
			pagingInfo.setTotalRecordCount(getTotalRecordCount(sqlWhere.toString(), parameters));

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Inventory inventory = new Inventory(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
						DateUtil.parseDateOnly(resultSet.getTimestamp(4)), resultSet.getInt(5), resultSet.getInt(6),
						resultSet.getInt(7), resultSet.getInt(8), resultSet.getInt(9),
						DateUtil.parse(resultSet.getTimestamp(10)), resultSet.getInt(11), resultSet.getString(12));
				results.add(inventory);
			}
		} catch (SQLException e) {
			log.log(Level.SEVERE, sqlToUse, e);
			throw new DBException(e, sqlToUse);
		} finally {
			DB.close(resultSet, statement);
			resultSet = null;
			statement = null;
		}

		return new BaseListResponse<Inventory>(results, pagingInfo);
	}

	/**
	 * Get Total Count
	 * 
	 * @param searchValue
	 * @return
	 */
	private int getTotalRecordCount(String sqlWhere, List<Object> parameters) {
		int totalRecordCount = 0;

		StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM ");
		sql.append(X_BH_Stocktake_v.Table_Name).append(" ").append(sqlWhere);

		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sqlTotalCount = sql.toString();
		try {
			statement = DB.prepareStatement(sqlTotalCount, null);
			DB.setParameters(statement, parameters);

			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				totalRecordCount = resultSet.getInt(1);
			}

		} catch (SQLException e) {
			log.log(Level.SEVERE, sqlTotalCount, e);
			throw new DBException(e, sqlTotalCount);
		} finally {
			DB.close(resultSet, statement);
			resultSet = null;
			statement = null;
		}

		return totalRecordCount;

	}

}