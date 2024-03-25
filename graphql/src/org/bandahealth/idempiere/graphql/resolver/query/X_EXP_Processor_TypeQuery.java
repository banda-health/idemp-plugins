package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MEXPProcessorType;

/**
 * Generated Query Resolver for EXP_Processor_Type - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_EXP_Processor_TypeQuery extends POQuery<MEXPProcessorType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MEXPProcessorType.Table_Name;
	}

	public Connection<MEXPProcessorType> EXP_Processor_TypeGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
