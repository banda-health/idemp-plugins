package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRecordAccess;

/**
 * Generated Query Resolver for AD_Record_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Record_AccessQuery extends POQuery<MRecordAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRecordAccess.Table_Name;
	}

	public Connection<MRecordAccess> AD_Record_AccessGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
