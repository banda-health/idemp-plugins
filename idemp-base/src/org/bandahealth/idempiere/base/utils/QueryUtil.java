package org.bandahealth.idempiere.base.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.stream.Collectors;

import org.adempiere.exceptions.DBException;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.compiere.model.MAttributeSet;
import org.compiere.model.MAttributeSetInstance;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class QueryUtil {

	private static CLogger logger = CLogger.getCLogger(QueryUtil.class);

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

	public static int createAttributeSetInstance(int attributeSetInstanceId, Timestamp expirationDate,
			String trxName, Properties ctx) {
		MAttributeSetInstance asi = null;

		if (attributeSetInstanceId > 0) {
			asi = new MAttributeSetInstance(ctx, attributeSetInstanceId, trxName);
		} else {
			String attributeSetName = expirationDate != null ? MAttributeSet_BH.DEFAULT_WITH_EXPIRY_NAME 
					: MAttributeSet_BH.DEFAULT_WITHOUT_EXPIRY_NAME;
			
			String whereClause = MAttributeSet.COLUMNNAME_Name + " =?";
			
			MAttributeSet attributeSet = new Query(ctx, MAttributeSet.Table_Name, whereClause, trxName)
					.setParameters(attributeSetName)
					.setOnlyActiveRecords(true)
					.setClient_ID(true)
					.first();

			if (attributeSet == null) {
				throw new RuntimeException("Attribute set '" + attributeSetName
						+ " not defined for client.");
			}

			List<Object> parameters = new ArrayList<>();
			// See if there is an attribute set instance for this product that already has
			// this date
			int attributeSetId = attributeSet.getM_AttributeSet_ID();
			parameters.add(attributeSetId);
			
			whereClause = MAttributeSetInstance.COLUMNNAME_M_AttributeSet_ID + "=?";
			if (expirationDate != null) {
				whereClause += " AND " + MAttributeSetInstance.COLUMNNAME_GuaranteeDate + "=?";
				parameters.add(expirationDate);
			}
			
			asi = new Query(ctx, MAttributeSetInstance.Table_Name, whereClause, trxName)
					.setParameters(parameters).first();
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

	public static Map<Timestamp, Integer> createExpirationDateAttributeInstances(Set<Timestamp> expirationDates,
			String trxName, Properties ctx) {
		String whereClause = MAttributeSet.COLUMNNAME_IsGuaranteeDate + "= 'Y' AND lower("
				+ MAttributeSet.COLUMNNAME_Name + ") = '"
				+ MAttributeSet_BH.DEFAULT_WITH_EXPIRY_NAME.toLowerCase() + "'";
		MAttributeSet attributeSet = new Query(ctx, MAttributeSet.Table_Name, whereClause, trxName)
				.setOnlyActiveRecords(true).setClient_ID(true).first();

		if (attributeSet == null) {
			throw new RuntimeException("Attribute set '" + MAttributeSet_BH.DEFAULT_WITH_EXPIRY_NAME
					+ " not defined for client.");
		}

		// See if there is an attribute set instance for this product that already has
		// this date
		List<Object> parameters = new ArrayList<>();
		String whereClauseParameters = QueryUtil.getWhereClauseAndSetParametersForSet(expirationDates, parameters);
		int attributeSetId = attributeSet.getM_AttributeSet_ID();
		whereClause = MAttributeSetInstance.COLUMNNAME_GuaranteeDate + " IN (" + whereClauseParameters + ") AND "
				+ MAttributeSetInstance.COLUMNNAME_M_AttributeSet_ID + "=?";
		parameters.add(attributeSetId);
		List<MAttributeSetInstance> attributeSetInstances =
				new Query(ctx, MAttributeSetInstance.Table_Name, whereClause, trxName).setParameters(parameters).list();

		// Get the expiration dates we have so we can check which need to be created
		Map<Timestamp, Integer> existingExpirationDatesByAttributeSetInstanceId = attributeSetInstances.stream()
				.collect(Collectors.toMap(MAttributeSetInstance::getGuaranteeDate, MAttributeSetInstance::get_ID,
						(attributeSetInstanceId, duplicateAttributeSetInstanceId) -> attributeSetInstanceId));

		// Cycle through the timestamps and add any that don't exist in the DB already
		for (Timestamp expirationDate : expirationDates) {
			// If it already exists in the DB, skip it
			if (existingExpirationDatesByAttributeSetInstanceId.containsKey(expirationDate)) {
				continue;
			}
			MAttributeSetInstance attributeSetInstance = new MAttributeSetInstance(ctx, 0, trxName);
			attributeSetInstance.setM_AttributeSet_ID(attributeSetId);
			attributeSetInstance.setGuaranteeDate(expirationDate);
			attributeSetInstance.saveEx();
			existingExpirationDatesByAttributeSetInstanceId.put(expirationDate, attributeSetInstance.get_ID());
		}

		return existingExpirationDatesByAttributeSetInstanceId;
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
		Integer initialClientPatientId = 100000;

		// First, try to see if we can fetch their current maximum numeric Banda patient id
		StringBuilder sqlQuery = new StringBuilder("SELECT MAX(CAST(").append(MBPartner_BH.COLUMNNAME_BH_PatientID)
				.append(" AS NUMERIC)) FROM ").append(MBPartner_BH.Table_Name).append(" WHERE ")
				.append(MBPartner_BH.COLUMNNAME_AD_Client_ID).append("=? AND isnumeric(")
				.append(MBPartner_BH.COLUMNNAME_BH_PatientID).append(") AND ").append(MBPartner_BH.COLUMNNAME_BH_IsPatient)
				.append("=? AND ").append(MBPartner_BH.COLUMNNAME_AD_Org_ID).append("=?");
		Integer clientsCurrentMaxPatientId = 0;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = DB.prepareStatement(sqlQuery.toString(), null);
			DB.setParameters(statement,
					Arrays.asList(Env.getAD_Client_ID(Env.getCtx()), "Y", Env.getAD_Org_ID(Env.getCtx())));

			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				clientsCurrentMaxPatientId = resultSet.getInt(1);
			}

		} catch (SQLException maxIdCheckException) {
			logger.info("Error checking for existing BH Patient Local ID max: " + maxIdCheckException.getMessage());
		} finally {
			DB.close(resultSet, statement);
			resultSet = null;
			statement = null;
		}

		// If the value was updated from 0, we found it!
		if (clientsCurrentMaxPatientId != 0) {
			return clientsCurrentMaxPatientId + 1;
		}

		// There was an error checking the maximum, so get the most recent patient
		// check the last created patient id
		MBPartner_BH lastCreatedPatient = new Query(Env.getCtx(), MBPartner_BH.Table_Name,
				MBPartner_BH.COLUMNNAME_BH_IsPatient + "=? AND " + MBPartner_BH.COLUMNNAME_AD_Org_ID + "=?",
				null)
				.setClient_ID().setOrderBy(MBPartner_BH.COLUMNNAME_Created + " DESC")
				.setParameters("Y", Env.getAD_Org_ID(Env.getCtx())).first();

		if (lastCreatedPatient != null && NumberUtils.isNumeric(lastCreatedPatient.getBH_PatientID())) {
			clientsCurrentMaxPatientId = Integer.parseInt(lastCreatedPatient.getBH_PatientID()) + 1;
		} else {
			clientsCurrentMaxPatientId = initialClientPatientId;
		}

		return clientsCurrentMaxPatientId;
	}

	/**
	 * This generates a parameter list based on a number of items (i.e. for items [1,2,3], this generates a where clause
	 * of "?,?,?" and adds the items to the parameters)
	 *
	 * @param items      The items to add to the parameter list
	 * @param parameters The parameter list
	 * @param <T>        The type of items to add
	 * @return A where clause with the number of question marks, comma-delimited, for the number of parameters
	 */
	public static <T> String getWhereClauseAndSetParametersForSet(Set<T> items, List<Object> parameters) {
		if (items == null || items.isEmpty()) {
			return "";
		}
		String parameterList = "?,".repeat(items.size());
		parameters.addAll(items);
		return parameterList.substring(0, parameterList.length() - 1);
	}
}
