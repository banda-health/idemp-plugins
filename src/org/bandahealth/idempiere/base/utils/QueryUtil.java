package org.bandahealth.idempiere.base.utils;

import java.util.Properties;

import org.compiere.model.PO;
import org.compiere.model.Query;

public class QueryUtil {

	/**
	 * Retrieve the first row of a given table by organization and client.
	 * @param clientId
	 * @param orgId
	 * @param ctx
	 * @param tableName
	 * @param whereClause
	 * @param trxName
	 * @return
	 */
	public static <T extends PO> T queryTableByOrgAndClient(int clientId, int orgId, Properties ctx, String tableName,
			String whereClause, String trxName) {

		return getQueryByOrgAndClient(clientId, orgId, ctx, tableName, whereClause, trxName).first();
	}

	/**
	 * Gets the query object to allow for further modification by a user if desired
	 * @param clientId
	 * @param orgId
	 * @param ctx
	 * @param tableName
	 * @param whereClause
	 * @param trxName
	 * @return
	 */
	public static Query getQueryByOrgAndClient(int clientId, int orgId, Properties ctx, String tableName,
			String whereClause, String trxName) {

		String specificClientSpecificOrgWhereClause = " and ad_client_id = " + clientId + " and ad_org_id = " + orgId;
		String specificClientBaseOrgWhereClause = " and ad_client_id = " + clientId + " and ad_org_id = 0";
		String baseClientBaseOrgWhereClause = " and ad_client_id = 0 and ad_org_id = 0";

		if (orgId == 0) {
			specificClientSpecificOrgWhereClause = " and ad_client_id = " + clientId + " and ad_org_id <> " + orgId;
		}

		Query query = new Query(ctx, tableName, whereClause + specificClientSpecificOrgWhereClause, trxName);
		if (query.count() > 0) {
			return query;
		}

		query = new Query(ctx, tableName, whereClause + specificClientBaseOrgWhereClause, trxName);
		if (query.count() > 0) {
			return query;
		}

		return new Query(ctx, tableName, whereClause + baseClientBaseOrgWhereClause, trxName);
	}
}
