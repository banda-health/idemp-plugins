package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MSerNoCtlExclude;

/**
 * Generated Query Resolver for M_SerNoCtlExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_SerNoCtlExcludeQuery extends POQuery<MSerNoCtlExclude> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MSerNoCtlExclude.Table_Name;
	}

	public Connection<MSerNoCtlExclude> M_SerNoCtlExcludeGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
