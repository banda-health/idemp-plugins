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
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class InventoryDBService {

	protected CLogger log = CLogger.getCLogger(InventoryDBService.class);

	public BaseListResponse<Inventory> getInventory(Paging pagingInfo) throws DBException {
		List<Inventory> results = new ArrayList<>();
		String sql = "SELECT * "
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

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = DB.prepareStatement(sql, null);
			DB.setParameters(pstmt, parameters);

			// get total count without pagination parameters
			pagingInfo.setTotalRecordCount(pstmt.getFetchSize());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				Inventory inventory = new Inventory(rs.getInt(1));
				results.add(inventory);
			}
		} catch (SQLException e) {
			log.log(Level.SEVERE, sql, e);
			throw new DBException(e, sql);
		} finally {
			DB.close(rs, pstmt);
			rs = null;
			pstmt = null;
		}
		
		return new BaseListResponse<Inventory>(results, pagingInfo);
	}

	public void updateInventory() {

	}

}