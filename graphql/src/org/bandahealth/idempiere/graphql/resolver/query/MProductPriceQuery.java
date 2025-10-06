package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProductPrice_BH;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.bandahealth.idempiere.graphql.model.PagingInfo;
import org.bandahealth.idempiere.graphql.repository.Repository;

import java.util.List;
import java.util.TreeMap;

public class MProductPriceQuery extends X_M_ProductPriceQuery {

	@Override
	public Connection<MProductPrice_BH> M_ProductPriceGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return Repository.get(getTableName(), null, new PagingInfo(Page, PageSize), Sort, Filter,
				Repository.parseApiWhereClauseAndParameters(Where, Parameters), Parameters,
				new TreeMap<>(String.CASE_INSENSITIVE_ORDER) {{
					put("m_product", "LEFT JOIN m_product ON m_product.m_Product_ID=m_productprice.m_Product_ID");
				}}, environment);
	}
}
