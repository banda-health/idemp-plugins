package org.bandahealth.idempiere.base.utils;

import java.sql.Timestamp;
import java.util.Properties;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
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
			String trxName, Properties ctx) {
		MAttributeSetInstance asi = null;

		if (attributeSetInstanceId > 0) {
			asi = new MAttributeSetInstance(ctx, attributeSetInstanceId, trxName);
		} else {
			String whereClause = MAttributeSet.COLUMNNAME_IsGuaranteeDate + "= 'Y' AND lower("
					+ MAttributeSet.COLUMNNAME_Name + ") = '"
					+ QueryConstants.BANDAHEALTH_PRODUCT_ATTRIBUTE_SET.toLowerCase() + "'";
			MAttributeSet attributeSet = new Query(ctx, MAttributeSet.Table_Name, whereClause, trxName)
					.setOnlyActiveRecords(true).setClient_ID(true).first();

			if (attributeSet == null) {
				throw new RuntimeException("Attribute set '" + QueryConstants.BANDAHEALTH_PRODUCT_ATTRIBUTE_SET
						+ " not defined for client.");
			}

			// See if there is an attribute set instance for this product that already has
			// this date
			int attributeSetId = attributeSet.getM_AttributeSet_ID();
			whereClause = MAttributeSetInstance.COLUMNNAME_GuaranteeDate + "=? AND "
					+ MAttributeSetInstance.COLUMNNAME_M_AttributeSet_ID + "=?";
			asi = new Query(ctx, MAttributeSetInstance.Table_Name, whereClause, trxName)
					.setParameters(expirationDate, attributeSetId).first();
			if (asi == null) {
				asi = new MAttributeSetInstance(ctx, 0, trxName);
				asi.setM_AttributeSet_ID(attributeSet.getM_AttributeSet_ID());
			}
		}

		if (asi.getM_AttributeSet_ID() > 0) {
			if (expirationDate != null) {
				asi.setGuaranteeDate(expirationDate);
			}
			asi.saveEx();

			attributeSetInstanceId = asi.getM_AttributeSetInstance_ID();
		}

		return attributeSetInstanceId;
	}

	public static boolean checkBHNewVisit(int bpartnerId) {
		StringBuilder whereClause = new StringBuilder(MOrder_BH.COLUMNNAME_BH_NEWVISIT);
		whereClause.append(" = 'Y' AND ");
		whereClause.append(MOrder_BH.COLUMNNAME_C_BPartner_ID);
		whereClause.append(" = ");
		whereClause.append(bpartnerId);

		int count = new Query(Env.getCtx(), MOrder_BH.Table_Name, whereClause.toString(), null).setClient_ID().count();
		if (count > 0) {
			return false;
		}

		return true;
	}

	/**
	 * Generates The Next Patient ID for a given client.
	 * 
	 * @return
	 */
	public static Object generateNextBHPatientId() {
		// default patient id
		Integer numericCreatedPatientId = 100000;

		// check the last created patient id
		MBPartner_BH lastCreatedPatient = new Query(Env.getCtx(), MBPartner_BH.Table_Name,
				MBPartner_BH.COLUMNNAME_BH_IsPatient + "=?", null).setClient_ID().setOrderBy(
						MBPartner_BH.COLUMNNAME_Created + " DESC, " + MBPartner_BH.COLUMNNAME_BH_PatientID + " DESC")
						.setParameters("Y").first();

		if (lastCreatedPatient != null && NumberUtils.isNumeric(lastCreatedPatient.getBH_PatientID())) {
			numericCreatedPatientId = Integer.valueOf(lastCreatedPatient.getBH_PatientID());
			numericCreatedPatientId++;
		}

		return numericCreatedPatientId;
	}
}
