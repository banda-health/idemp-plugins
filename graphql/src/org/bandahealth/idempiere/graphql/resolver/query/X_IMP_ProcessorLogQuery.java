package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MIMPProcessorLog;

/**
 * Generated Query Resolver for IMP_ProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_IMP_ProcessorLogQuery extends POQuery<MIMPProcessorLog> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MIMPProcessorLog.Table_Name;
	}

	public Connection<MIMPProcessorLog> IMP_ProcessorLogGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
