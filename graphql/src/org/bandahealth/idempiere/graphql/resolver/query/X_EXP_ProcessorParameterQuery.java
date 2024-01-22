package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MEXPProcessorParameter;

/**
 * Generated Query Resolver for EXP_ProcessorParameter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_EXP_ProcessorParameterQuery extends POQuery<MEXPProcessorParameter> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MEXPProcessorParameter.Table_Name;
	}

	public Connection<MEXPProcessorParameter> EXP_ProcessorParameterGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
