package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_InfoRelated;

/**
 * Generated Query Resolver for AD_InfoRelated - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_InfoRelatedQuery extends POQuery<X_AD_InfoRelated> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_InfoRelated.Table_Name;
	}

	public Connection<X_AD_InfoRelated> AD_InfoRelatedGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
