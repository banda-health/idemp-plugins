package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_WF_Block;

/**
 * Generated Query Resolver for AD_WF_Block - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_WF_BlockQuery extends POQuery<X_AD_WF_Block> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_WF_Block.Table_Name;
	}

	public Connection<X_AD_WF_Block> AD_WF_BlockGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
