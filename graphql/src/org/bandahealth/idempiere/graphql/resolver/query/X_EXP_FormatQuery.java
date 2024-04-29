package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MEXPFormat;

/**
 * Generated Query Resolver for EXP_Format - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_EXP_FormatQuery extends POQuery<MEXPFormat> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MEXPFormat.Table_Name;
	}

	public Connection<MEXPFormat> EXP_FormatGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
