package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPaySelection;

/**
 * Generated Query Resolver for C_PaySelection - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_PaySelectionQuery extends POQuery<MPaySelection> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPaySelection.Table_Name;
	}

	public Connection<MPaySelection> C_PaySelectionGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
