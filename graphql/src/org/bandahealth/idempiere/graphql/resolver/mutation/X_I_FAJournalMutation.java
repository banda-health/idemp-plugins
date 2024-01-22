package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_I_FAJournalInput;
import org.bandahealth.idempiere.graphql.model.input.X_I_FAJournalInput;
import org.compiere.model.MXIFAJournal;

import java.util.List;

/**
 * Generated Query Resolver for I_FAJournal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_I_FAJournalMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_I_FAJournalInput.Table_Name;
	}

	public MXIFAJournal I_FAJournalSave(I_I_FAJournalInput input, DataFetchingEnvironment environment) {
		return (MXIFAJournal) super.save((X_I_FAJournalInput) input, environment);
	}

	public boolean I_FAJournalDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
