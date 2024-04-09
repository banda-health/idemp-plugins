package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPInstancePara;

/**
 * Generated Query Resolver for AD_PInstance_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_PInstance_ParaQuery extends POQuery<MPInstancePara> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPInstancePara.Table_Name;
	}

	public Connection<MPInstancePara> AD_PInstance_ParaGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
