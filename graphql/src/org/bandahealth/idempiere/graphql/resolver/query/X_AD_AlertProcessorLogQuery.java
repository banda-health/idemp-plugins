package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAlertProcessorLog;

/**
 * Generated Query Resolver for AD_AlertProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AlertProcessorLogQuery extends POQuery<MAlertProcessorLog> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAlertProcessorLog.Table_Name;
	}

	public Connection<MAlertProcessorLog> AD_AlertProcessorLogGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
