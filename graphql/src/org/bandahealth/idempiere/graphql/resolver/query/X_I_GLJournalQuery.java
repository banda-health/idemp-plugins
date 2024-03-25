package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_I_GLJournal;

/**
 * Generated Query Resolver for I_GLJournal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_I_GLJournalQuery extends POQuery<X_I_GLJournal> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_I_GLJournal.Table_Name;
	}

	public Connection<X_I_GLJournal> I_GLJournalGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
