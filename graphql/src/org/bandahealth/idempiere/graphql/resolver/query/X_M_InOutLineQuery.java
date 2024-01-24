package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MInOutLine;

/**
 * Generated Query Resolver for M_InOutLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_InOutLineQuery extends POQuery<MInOutLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInOutLine.Table_Name;
	}

	public Connection<MInOutLine> M_InOutLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
