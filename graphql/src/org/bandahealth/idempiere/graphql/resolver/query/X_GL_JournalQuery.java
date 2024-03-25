package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MJournal;

/**
 * Generated Query Resolver for GL_Journal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_GL_JournalQuery extends POQuery<MJournal> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MJournal.Table_Name;
	}

	public Connection<MJournal> GL_JournalGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
