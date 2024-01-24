package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_I_FAJournalInput;
import org.bandahealth.idempiere.graphql.model.input.X_I_FAJournalInput;
import org.compiere.model.MXIFAJournal;

import java.util.List;
import java.util.stream.Collectors;

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

	public MXIFAJournal I_FAJournalSave(I_I_FAJournalInput entity, DataFetchingEnvironment environment) {
		return (MXIFAJournal) super.save((X_I_FAJournalInput) entity, environment);
	}

	public List<MXIFAJournal> I_FAJournalSaveMany(List<I_I_FAJournalInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_I_FAJournalInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MXIFAJournal) entity).collect(Collectors.toList());
	}

	public boolean I_FAJournalDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
