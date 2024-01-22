package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MShipperLabels;

/**
 * Generated Query Resolver for M_ShipperLabels - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_ShipperLabelsQuery extends POQuery<MShipperLabels> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MShipperLabels.Table_Name;
	}

	public Connection<MShipperLabels> M_ShipperLabelsGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
