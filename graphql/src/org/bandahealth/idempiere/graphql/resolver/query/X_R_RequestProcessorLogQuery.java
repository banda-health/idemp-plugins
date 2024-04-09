package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRequestProcessorLog;

/**
 * Generated Query Resolver for R_RequestProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_RequestProcessorLogQuery extends POQuery<MRequestProcessorLog> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRequestProcessorLog.Table_Name;
	}

	public Connection<MRequestProcessorLog> R_RequestProcessorLogGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
