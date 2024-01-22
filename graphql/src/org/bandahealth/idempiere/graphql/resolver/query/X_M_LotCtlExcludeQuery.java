package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_LotCtlExclude;

/**
 * Generated Query Resolver for M_LotCtlExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_LotCtlExcludeQuery extends POQuery<X_M_LotCtlExclude> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_LotCtlExclude.Table_Name;
	}

	public Connection<X_M_LotCtlExclude> M_LotCtlExcludeGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
