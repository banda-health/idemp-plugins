package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MIMPProcessor;

/**
 * Generated Query Resolver for IMP_Processor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_IMP_ProcessorQuery extends POQuery<MIMPProcessor> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MIMPProcessor.Table_Name;
	}

	public Connection<MIMPProcessor> IMP_ProcessorGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
