package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAssetTransfer;

/**
 * Generated Query Resolver for A_Asset_Transfer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_TransferQuery extends POQuery<MAssetTransfer> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAssetTransfer.Table_Name;
	}

	public Connection<MAssetTransfer> A_Asset_TransferGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
