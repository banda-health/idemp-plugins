package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MLotCtlExclude;

/**
 * Generated Query Resolver for M_LotCtlExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_LotCtlExcludeQuery extends POQuery<MLotCtlExclude> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MLotCtlExclude.Table_Name;
	}

	public Connection<MLotCtlExclude> M_LotCtlExcludeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
