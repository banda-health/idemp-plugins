package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_PrintHeaderFooter;

/**
 * Generated Query Resolver for AD_PrintHeaderFooter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_PrintHeaderFooterQuery extends POQuery<X_AD_PrintHeaderFooter> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_PrintHeaderFooter.Table_Name;
	}

	public Connection<X_AD_PrintHeaderFooter> AD_PrintHeaderFooterGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
