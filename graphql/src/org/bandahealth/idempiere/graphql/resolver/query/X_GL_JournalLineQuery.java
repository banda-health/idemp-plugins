package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MJournalLine;

/**
 * Generated Query Resolver for GL_JournalLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_GL_JournalLineQuery extends POQuery<MJournalLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MJournalLine.Table_Name;
	}

	public Connection<MJournalLine> GL_JournalLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
