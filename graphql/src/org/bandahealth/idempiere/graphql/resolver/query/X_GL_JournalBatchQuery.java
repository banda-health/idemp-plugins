package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MJournalBatch;

/**
 * Generated Query Resolver for GL_JournalBatch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_GL_JournalBatchQuery extends POQuery<MJournalBatch> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MJournalBatch.Table_Name;
	}

	public Connection<MJournalBatch> GL_JournalBatchGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
