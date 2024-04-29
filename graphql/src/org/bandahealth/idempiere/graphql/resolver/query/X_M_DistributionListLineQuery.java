package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDistributionListLine;

/**
 * Generated Query Resolver for M_DistributionListLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_DistributionListLineQuery extends POQuery<MDistributionListLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDistributionListLine.Table_Name;
	}

	public Connection<MDistributionListLine> M_DistributionListLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
