package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MArchive;

/**
 * Generated Query Resolver for AD_Archive - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ArchiveQuery extends POQuery<MArchive> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MArchive.Table_Name;
	}

	public Connection<MArchive> AD_ArchiveGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
