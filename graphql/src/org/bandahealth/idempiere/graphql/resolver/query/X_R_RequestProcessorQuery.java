package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRequestProcessor;

/**
 * Generated Query Resolver for R_RequestProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_RequestProcessorQuery extends POQuery<MRequestProcessor> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRequestProcessor.Table_Name;
	}

	public Connection<MRequestProcessor> R_RequestProcessorGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
