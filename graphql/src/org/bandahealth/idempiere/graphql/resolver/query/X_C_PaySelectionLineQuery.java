package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPaySelectionLine;

/**
 * Generated Query Resolver for C_PaySelectionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_PaySelectionLineQuery extends POQuery<MPaySelectionLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPaySelectionLine.Table_Name;
	}

	public Connection<MPaySelectionLine> C_PaySelectionLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
