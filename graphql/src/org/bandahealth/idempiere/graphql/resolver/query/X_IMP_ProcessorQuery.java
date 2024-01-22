package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_IMP_Processor;

/**
 * Generated Query Resolver for IMP_Processor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_IMP_ProcessorQuery extends POQuery<X_IMP_Processor> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_IMP_Processor.Table_Name;
	}

	public Connection<X_IMP_Processor> IMP_ProcessorGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
