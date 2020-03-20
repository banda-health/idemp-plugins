package org.bandahealth.idempiere.rest.service.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.adempiere.exceptions.DBException;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Inventory;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class InventoryDBService {

	protected CLogger log = CLogger.getCLogger(InventoryDBService.class);

	public BaseListResponse<Inventory> getInventory(Paging pagingInfo) throws DBException {
		List<Inventory> results = new ArrayList<>();
		String sql = "SELECT m_product_id, m_warehouse_id, product, expirationdate, quantity, shelflifedays, m_attributesetinstance_id,"
				+ " ad_client_id, ad_org_id, created, createdBy, description"
				+ " FROM bh_stocktake_v WHERE ad_client_id = ? and ad_org_id = ? order by product asc";
		if (pagingInfo.getPageSize() > 0) {
			if (DB.getDatabase().isPagingSupported()) {
				sql = DB.getDatabase().addPagingSQL(sql, (pagingInfo.getPageSize() * pagingInfo.getPage()) + 1,
						pagingInfo.getPageSize() * (pagingInfo.getPage() + 1));
			}
		}

		List<Object> parameters = new ArrayList<>();
		parameters.add(Env.getAD_Client_ID(Env.getCtx()));
		parameters.add(Env.getAD_Org_ID(Env.getCtx()));

		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = DB.prepareStatement(sql, null);
			DB.setParameters(statement, parameters);

			// get total count without pagination parameters
			pagingInfo.setTotalRecordCount(statement.getFetchSize());

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Inventory inventory = new Inventory(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
						DateUtil.parseExpiration(resultSet.getTimestamp(4)), resultSet.getInt(5), resultSet.getInt(6),
						resultSet.getInt(7), resultSet.getInt(8), resultSet.getInt(9),
						DateUtil.parse(resultSet.getTimestamp(10)), resultSet.getInt(11), resultSet.getString(12));
				results.add(inventory);
			}
		} catch (SQLException e) {
			log.log(Level.SEVERE, sql, e);
			throw new DBException(e, sql);
		} finally {
			DB.close(resultSet, statement);
			resultSet = null;
			statement = null;
		}

		return new BaseListResponse<Inventory>(results, pagingInfo);
	}
}