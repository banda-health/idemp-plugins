package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAlertProcessor;

/**
 * Generated Query Resolver for AD_AlertProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AlertProcessorQuery extends POQuery<MAlertProcessor> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAlertProcessor.Table_Name;
	}

	public Connection<MAlertProcessor> AD_AlertProcessorGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
