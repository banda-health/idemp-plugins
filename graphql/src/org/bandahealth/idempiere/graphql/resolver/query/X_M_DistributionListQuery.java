package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDistributionList;

/**
 * Generated Query Resolver for M_DistributionList - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_DistributionListQuery extends POQuery<MDistributionList> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDistributionList.Table_Name;
	}

	public Connection<MDistributionList> M_DistributionListGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
