package org.bandahealth.idempiere.graphql.utils;

import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.compiere.util.CLogger;
import org.compiere.util.Env;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class MProductUtil {
	private static final CLogger log = CLogger.getCLogger(MProductUtil.class);

	/**
	 * Gets the IDs of products that haven't had any finished POs
	 *
	 * @param idempiereContext The context since Env.getCtx() isn't thread-safe
	 * @return A list of product ids that have no POs
	 */
	public static List<Integer> getProductIdsWithNoFinishedPurchaseOrders(Properties idempiereContext,
			Set<Integer> productIdsToFilterBy) {
		List<Integer> productIds = new ArrayList<>();
		List<Object> parameters = new ArrayList<>();
		String whereClause = QueryUtil.getWhereClauseAndSetParametersForSet(productIdsToFilterBy, parameters);
		if (!StringUtil.isNullOrEmpty(whereClause)) {
			whereClause = "m_product_id IN (" + whereClause + ") AND";
		}
		String sql = """
				SELECT
					m_product_id
				FROM
					m_product
				WHERE
					""" + whereClause + """
					m_product_id NOT IN (
						SELECT
							m_product_id
						FROM
							c_orderline
						WHERE
							c_order_id IN
							(
								SELECT c_order_id FROM c_order WHERE issotrx = ? AND docstatus IN (?,?) AND ad_client_id = ?
							)
							AND m_product_id IS NOT NULL
							AND ad_client_id = ?
					)
					AND ad_client_id = ?
				""";
		parameters.add(false);
		parameters.add(MOrder_BH.DOCSTATUS_Completed);
		parameters.add(MOrder_BH.DOCSTATUS_Closed);
		parameters.add(Env.getAD_Client_ID(idempiereContext));
		parameters.add(Env.getAD_Client_ID(idempiereContext));
		parameters.add(Env.getAD_Client_ID(idempiereContext));
		SqlUtil.executeQuery(sql, parameters, null, data -> {
			try {
				productIds.add((data.getInt(1)));
			} catch (Exception e) {
				log.severe(e.getMessage());
			}
		});
		return productIds;
	}
}
