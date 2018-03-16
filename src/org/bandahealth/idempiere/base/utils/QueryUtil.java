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

		String specificClientSpecificOrgWhereClause = String.format(" and %1$s",
				contstructClientAndOrganizationWhereClause(clientId, organizationId));
		String specificClientBaseOrgWhereClause = String.format(" and %1$s",
				contstructClientAndOrganizationWhereClause(clientId, QueryConstants.BASE_ORGANIZATION_ID));
		String baseClientBaseOrgWhereClause = String.format(" and %1$s",
				contstructClientAndOrganizationWhereClause(QueryConstants.BASE_CLIENT_ID,
						QueryConstants.BASE_ORGANIZATION_ID));
		
		if (organizationId == QueryConstants.BASE_ORGANIZATION_ID) {
			specificClientSpecificOrgWhereClause = String.format(" and %1$s = %2$s and %3$s <> %4$s",
					QueryConstants.CLIENT_ID_COLUMN_NAME, clientId, QueryConstants.ORGANIZATION_ID_COLUMN_NAME,
					organizationId);
		}
		
		Query query = new Query(ctx, tableName, whereClause + specificClientSpecificOrgWhereClause, trxName);
		if (query.count() > 0) {
			return query.first();
		}
		
		query = new Query(ctx, tableName, whereClause + specificClientBaseOrgWhereClause, trxName);
		if (query.count() > 0) {
			return query.first();
		}
		
		return (new Query(ctx, tableName, whereClause + baseClientBaseOrgWhereClause, trxName)).first();
	}

	public static String contstructClientAndOrganizationWhereClause(int clientId, int organizationId) {
		return String.format("%1$s = %2$s and %3$s = %4$s",
				QueryConstants.CLIENT_ID_COLUMN_NAME, clientId, QueryConstants.ORGANIZATION_ID_COLUMN_NAME, organizationId);
	}
}
