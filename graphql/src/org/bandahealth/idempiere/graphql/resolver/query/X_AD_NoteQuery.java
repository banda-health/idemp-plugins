package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MNote;

/**
 * Generated Query Resolver for AD_Note - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_NoteQuery extends POQuery<MNote> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MNote.Table_Name;
	}

	public Connection<MNote> AD_NoteGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
