package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProjectPhase;

/**
 * Generated Query Resolver for C_ProjectPhase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ProjectPhaseQuery extends POQuery<MProjectPhase> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProjectPhase.Table_Name;
	}

	public Connection<MProjectPhase> C_ProjectPhaseGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
