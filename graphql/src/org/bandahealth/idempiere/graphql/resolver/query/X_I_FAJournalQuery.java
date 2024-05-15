package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MXIFAJournal;

/**
 * Generated Query Resolver for I_FAJournal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_I_FAJournalQuery extends POQuery<MXIFAJournal> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MXIFAJournal.Table_Name;
	}

	public Connection<MXIFAJournal> I_FAJournalGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
