package org.bandahealth.idempiere.rest.service.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

import org.adempiere.exceptions.DBException;
import org.bandahealth.idempiere.base.model.MColumn_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Inventory;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class InventoryDBService {

	/** TableName=BH_Stocktake_v */
	public static final String BH_STOCKTAKE_V_Table_Name = "BH_Stocktake_v";

	public static final int BH_STOCKTAKE_V_Table_ID = MTable.getTable_ID(BH_STOCKTAKE_V_Table_Name);

	protected CLogger log = CLogger.getCLogger(InventoryDBService.class);

	public BaseListResponse<Inventory> getInventory(Paging pagingInfo, String sortColumn, String sortOrder)
			throws DBException {
		return searchInventory(pagingInfo, null, sortColumn, sortOrder);
	}

	public BaseListResponse<Inventory> searchInventory(Paging pagingInfo, String searchValue,
			String sortColumn, String sortOrder) throws DBException {
		List<Inventory> results = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT m_product_id, m_warehouse_id, product, expirationdate, quantity, shelflifedays, ")
				.append("m_attributesetinstance_id, ad_client_id, ad_org_id, created, createdBy, description ")
				.append(" FROM bh_stocktake_v WHERE ad_client_id = ? and ad_org_id = ? ");

		List<Object> parameters = new ArrayList<>();
		parameters.add(Env.getAD_Client_ID(Env.getCtx()));
		parameters.add(Env.getAD_Org_ID(Env.getCtx()));

		if (searchValue != null && !searchValue.isEmpty()) {
			List<MColumn_BH> searchableColumnsToUse = new Query(
					Env.getCtx(),
					MColumn_BH.Table_Name,
					MColumn_BH.COLUMNNAME_AD_Table_ID + "=? AND " + MColumn_BH.COLUMNNAME_BH_RestSearchable + "=?",
					null
			)
					.setOnlyActiveRecords(true)
					.setParameters(BH_STOCKTAKE_V_Table_ID, "Y")
					.list();

			if (searchableColumnsToUse != null && searchableColumnsToUse.size() > 0) {
				List<String> searchableColumns = searchableColumnsToUse.stream()
						.map(MColumn_BH::getColumnName)
						.collect(Collectors.toList());
				List<String> whereClausePieces = new ArrayList<String>();
				String finalSearchValue = "%" + searchValue.toLowerCase() + "%";
				searchableColumns.forEach(searchableColumn -> {
					whereClausePieces.add("LOWER(CAST(" + searchableColumn + " AS VARCHAR)) LIKE ?");
					parameters.add(finalSearchValue);
				});
				sql.append("(").append(String.join(" OR ", whereClausePieces)).append(")");
			}
		}

		sql.append("order by ");
		if (sortColumn != null && !sortColumn.isEmpty() && sortOrder != null && !sortOrder.isEmpty()) {
			sql.append(sortColumn).append(" ").append(sortOrder);
		} else {
			sql.append("product asc");
		}

		if (pagingInfo.getPageSize() > 0) {
			if (DB.getDatabase().isPagingSupported()) {
				sql.append(DB.getDatabase().addPagingSQL(sql.toString(),
						(pagingInfo.getPageSize() * pagingInfo.getPage()) + 1,
						pagingInfo.getPageSize() * (pagingInfo.getPage() + 1)));
			}
		}

		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = DB.prepareStatement(sql.toString(), null);
			DB.setParameters(statement, parameters);

			// get total count without pagination parameters
			pagingInfo.setTotalRecordCount(statement.getFetchSize());

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Inventory inventory = new Inventory(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
						DateUtil.parseDateOnly(resultSet.getTimestamp(4)), resultSet.getInt(5), resultSet.getInt(6),
						resultSet.getInt(7), resultSet.getInt(8), resultSet.getInt(9),
						DateUtil.parse(resultSet.getTimestamp(10)), resultSet.getInt(11), resultSet.getString(12));
				results.add(inventory);
			}
		} catch (SQLException e) {
			log.log(Level.SEVERE, sql.toString(), e);
			throw new DBException(e, sql.toString());
		} finally {
			DB.close(resultSet, statement);
			resultSet = null;
			statement = null;
		}

		return new BaseListResponse<Inventory>(results, pagingInfo);
	}
}