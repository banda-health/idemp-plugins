package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.bandahealth.idempiere.graphql.model.PagingInfo;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.util.Env;

import java.util.TreeMap;

public class MProductQuery extends X_M_ProductQuery {
	@Override
	public Connection<MProduct_BH> M_ProductGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return Repository.get(getTableName(), null, new PagingInfo(Page, PageSize), Sort, Filter, null, null,
				new TreeMap<>(String.CASE_INSENSITIVE_ORDER) {{
					put("product_costs",
							"LEFT JOIN (SELECT m_product_id, m_attributesetinstance_id, purchase_price, purchase_date, row_number" +
									"() OVER (PARTITION BY m_product_id ORDER BY purchase_date DESC) as row_num FROM get_product_costs" +
									"(" + Env.getAD_Client_ID(BandaGraphQLContext.getCtx(environment)) + ")) product_costs " +
									"ON product_costs." + MProduct_BH.COLUMNNAME_M_Product_ID + "=" + MProduct_BH.Table_Name + "." +
									MProduct_BH.COLUMNNAME_M_Product_ID + " AND product_costs.row_num = 1");
				}}, environment);
	}
}
