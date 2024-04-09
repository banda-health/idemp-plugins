package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProjectTypePhase;

/**
 * Generated Query Resolver for C_Phase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_PhaseQuery extends POQuery<MProjectTypePhase> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProjectTypePhase.Table_Name;
	}

	public Connection<MProjectTypePhase> C_PhaseGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
