package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MEXPFormatLine;

/**
 * Generated Query Resolver for EXP_FormatLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_EXP_FormatLineQuery extends POQuery<MEXPFormatLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MEXPFormatLine.Table_Name;
	}

	public Connection<MEXPFormatLine> EXP_FormatLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
