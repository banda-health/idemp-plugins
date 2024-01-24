package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTableIndex;

/**
 * Generated Query Resolver for AD_TableIndex - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_TableIndexQuery extends POQuery<MTableIndex> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTableIndex.Table_Name;
	}

	public Connection<MTableIndex> AD_TableIndexGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
