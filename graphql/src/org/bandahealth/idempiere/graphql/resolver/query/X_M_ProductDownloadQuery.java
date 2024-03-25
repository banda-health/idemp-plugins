package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProductDownload;

/**
 * Generated Query Resolver for M_ProductDownload - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ProductDownloadQuery extends POQuery<MProductDownload> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProductDownload.Table_Name;
	}

	public Connection<MProductDownload> M_ProductDownloadGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
