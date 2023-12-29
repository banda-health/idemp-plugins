package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRefList;

/**
 * Generated Query Resolver for AD_Ref_List - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Ref_ListQuery extends POQuery<MRefList> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRefList.Table_Name;
	}

	public Connection<MRefList> AD_Ref_ListGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
