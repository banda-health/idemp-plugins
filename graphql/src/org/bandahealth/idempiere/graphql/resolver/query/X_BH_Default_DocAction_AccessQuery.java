package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHDefaultDocActionAccess;
import org.bandahealth.idempiere.graphql.model.Connection;

/**
 * Generated Query Resolver for BH_Default_DocAction_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Default_DocAction_AccessQuery extends POQuery<MBHDefaultDocActionAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHDefaultDocActionAccess.Table_Name;
	}

	public Connection<MBHDefaultDocActionAccess> BH_Default_DocAction_AccessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
