package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MJournalGenerator;

/**
 * Generated Query Resolver for GL_JournalGenerator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_JournalGeneratorQuery extends POQuery<MJournalGenerator> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MJournalGenerator.Table_Name;
	}

	public Connection<MJournalGenerator> GL_JournalGeneratorGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
