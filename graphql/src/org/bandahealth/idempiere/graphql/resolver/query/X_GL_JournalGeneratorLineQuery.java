package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MJournalGeneratorLine;

/**
 * Generated Query Resolver for GL_JournalGeneratorLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_GL_JournalGeneratorLineQuery extends POQuery<MJournalGeneratorLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MJournalGeneratorLine.Table_Name;
	}

	public Connection<MJournalGeneratorLine> GL_JournalGeneratorLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
