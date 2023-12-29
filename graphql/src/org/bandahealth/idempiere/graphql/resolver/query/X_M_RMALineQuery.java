package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRMALine;

/**
 * Generated Query Resolver for M_RMALine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_RMALineQuery extends POQuery<MRMALine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRMALine.Table_Name;
	}

	public Connection<MRMALine> M_RMALineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
