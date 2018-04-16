package org.bandahealth.idempiere.base.utils;

import java.sql.Timestamp;
import java.util.Properties;

import org.compiere.model.MAttributeSet;
import org.compiere.model.MAttributeSetInstance;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.Env;

public class QueryUtil {

	/**
	 * Retrieve the first row of a given table by organization and client.
	 * 
	 * @param clientId
	 * @param organizationId
	 * @param ctx
	 * @param tableName
	 * @param whereClause
	 * @param trxName
	 * @return
	 */
	public static <T extends PO> T queryTableByOrgAndClient(int clientId, int organizationId, Properties ctx,
			String tableName, String whereClause, String trxName) {

		return getQueryByOrgAndClient(clientId, organizationId, ctx, tableName, whereClause, trxName).first();
	}

	/**
	 * Gets the query object to allow for further modification by a user if desired
	 * 
	 * @param clientId
	 * @param organizationId
	 * @param ctx
	 * @param tableName
	 * @param whereClause
	 * @param trxName
	 * @return
	 */
	public static Query getQueryByOrgAndClient(int clientId, int organizationId, Properties ctx, String tableName,
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

	public static int createExpirationDateAttributeInstance(int attributeSetInstanceId, Timestamp expirationDate,
			String trxName) {
		MAttributeSetInstance asi = null;

		if (attributeSetInstanceId > 0) {
			asi = new MAttributeSetInstance(Env.getCtx(), attributeSetInstanceId, trxName);
		} else {
			String whereClause = MAttributeSet.COLUMNNAME_IsGuaranteeDate + "= 'Y' AND " + MAttributeSet.COLUMNNAME_Name
					+ " = '" + QueryConstants.BANDAHEALTH_PRODUCT_ATTRIBUTE_SET + "'";
			MAttributeSet attributeSet = new Query(Env.getCtx(), MAttributeSet.Table_Name, whereClause, trxName)
					.setOnlyActiveRecords(true).first();
			if (attributeSet != null) {
				asi = new MAttributeSetInstance(Env.getCtx(), 0, trxName);
				asi.setM_AttributeSet_ID(attributeSet.getM_AttributeSet_ID());
			} else {
				return attributeSetInstanceId;
			}
		}

		if (asi.getM_AttributeSet_ID() > 0) {
			asi.setGuaranteeDate(expirationDate);
			asi.saveEx();

			attributeSetInstanceId = asi.getM_AttributeSetInstance_ID();
		}

		return attributeSetInstanceId;
	}
}
