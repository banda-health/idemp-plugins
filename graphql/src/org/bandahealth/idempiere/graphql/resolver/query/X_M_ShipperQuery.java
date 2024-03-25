package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MShipper;

/**
 * Generated Query Resolver for M_Shipper - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ShipperQuery extends POQuery<MShipper> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MShipper.Table_Name;
	}

	public Connection<MShipper> M_ShipperGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
