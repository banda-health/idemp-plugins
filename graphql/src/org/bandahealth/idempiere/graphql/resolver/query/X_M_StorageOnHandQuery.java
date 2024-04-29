package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MStorageOnHand;

/**
 * Generated Query Resolver for M_StorageOnHand - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_StorageOnHandQuery extends POQuery<MStorageOnHand> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MStorageOnHand.Table_Name;
	}

	public Connection<MStorageOnHand> M_StorageOnHandGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
