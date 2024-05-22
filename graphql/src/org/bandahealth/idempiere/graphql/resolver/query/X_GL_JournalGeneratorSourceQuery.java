package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MJournalGeneratorSource;

/**
 * Generated Query Resolver for GL_JournalGeneratorSource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_GL_JournalGeneratorSourceQuery extends POQuery<MJournalGeneratorSource> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MJournalGeneratorSource.Table_Name;
	}

	public Connection<MJournalGeneratorSource> GL_JournalGeneratorSourceGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
