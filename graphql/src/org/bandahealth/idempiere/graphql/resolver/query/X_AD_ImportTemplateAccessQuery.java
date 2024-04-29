package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_ImportTemplateAccess;

/**
 * Generated Query Resolver for AD_ImportTemplateAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ImportTemplateAccessQuery extends POQuery<X_AD_ImportTemplateAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_ImportTemplateAccess.Table_Name;
	}

	public Connection<X_AD_ImportTemplateAccess> AD_ImportTemplateAccessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
