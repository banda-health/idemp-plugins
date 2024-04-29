package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MEXPProcessor;

/**
 * Generated Query Resolver for EXP_Processor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_EXP_ProcessorQuery extends POQuery<MEXPProcessor> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MEXPProcessor.Table_Name;
	}

	public Connection<MEXPProcessor> EXP_ProcessorGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
