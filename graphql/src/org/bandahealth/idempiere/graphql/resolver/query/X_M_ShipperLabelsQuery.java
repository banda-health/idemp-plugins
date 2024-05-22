package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MShipperLabels;

/**
 * Generated Query Resolver for M_ShipperLabels - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ShipperLabelsQuery extends POQuery<MShipperLabels> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MShipperLabels.Table_Name;
	}

	public Connection<MShipperLabels> M_ShipperLabelsGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
