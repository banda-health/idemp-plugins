package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MStorageProvider;

/**
 * Generated Query Resolver for AD_StorageProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_StorageProviderQuery extends POQuery<MStorageProvider> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MStorageProvider.Table_Name;
	}

	public Connection<MStorageProvider> AD_StorageProviderGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
