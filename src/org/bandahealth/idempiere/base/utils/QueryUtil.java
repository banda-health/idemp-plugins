package org.bandahealth.idempiere.base.utils;

import java.util.Properties;

import org.compiere.model.PO;
import org.compiere.model.Query;

public class QueryUtil {

	/**
	 * Retrieve the first row of a given table by organization and client.
	 * @param clientId
	 * @param organizationId
	 * @param ctx
	 * @param tableName
	 * @param whereClause
	 * @param trxName
	 * @return
	 */
	public static <T extends PO> T queryTableByOrgAndClient(int clientId, int organizationId, Properties ctx, String tableName,
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

		String clientAndOrg = String.format(" and %1$s = ? and %2$s = ?", QueryConstants.CLIENT_ID_COLUMN_NAME,
				QueryConstants.ORGANIZATION_ID_COLUMN_NAME);
		String clientAndNotBaseOrg = String.format(" and %1$s = ? and %2$s <> ?", QueryConstants.CLIENT_ID_COLUMN_NAME,
				QueryConstants.ORGANIZATION_ID_COLUMN_NAME);

		Query query;
		if (organizationId == QueryConstants.BASE_ORGANIZATION_ID) {
			query = new Query(ctx, tableName, whereClause + clientAndNotBaseOrg, trxName);
		} else {
			query = new Query(ctx, tableName, whereClause + clientAndOrg, trxName);
		}
		query.setParameters(clientId, organizationId);
		if (query.count() > 0) {
			return query;
		}

		query = new Query(ctx, tableName, whereClause + clientAndOrg, trxName);
		query.setParameters(clientId, QueryConstants.BASE_ORGANIZATION_ID);
		if (query.count() > 0) {
			return query;
		}

		return (new Query(ctx, tableName, whereClause + clientAndOrg, trxName))
				.setParameters(QueryConstants.BASE_CLIENT_ID, QueryConstants.BASE_ORGANIZATION_ID);
	}
}
