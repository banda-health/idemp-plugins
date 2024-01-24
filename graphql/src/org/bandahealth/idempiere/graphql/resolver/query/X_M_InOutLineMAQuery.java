package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MInOutLineMA;

/**
 * Generated Query Resolver for M_InOutLineMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_InOutLineMAQuery extends POQuery<MInOutLineMA> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInOutLineMA.Table_Name;
	}

	public Connection<MInOutLineMA> M_InOutLineMAGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
