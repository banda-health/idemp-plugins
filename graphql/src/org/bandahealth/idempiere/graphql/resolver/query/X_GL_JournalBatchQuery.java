package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MJournalBatch;

/**
 * Generated Query Resolver for GL_JournalBatch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_GL_JournalBatchQuery extends POQuery<MJournalBatch> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MJournalBatch.Table_Name;
	}

	public Connection<MJournalBatch> GL_JournalBatchGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
