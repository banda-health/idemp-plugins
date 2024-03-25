package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCashBook;

/**
 * Generated Query Resolver for C_CashBook - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CashBookQuery extends POQuery<MCashBook> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCashBook.Table_Name;
	}

	public Connection<MCashBook> C_CashBookGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
