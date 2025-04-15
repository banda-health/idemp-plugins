package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_I_GLJournalInput;
import org.bandahealth.idempiere.graphql.model.input.X_I_GLJournalInput;
import org.compiere.model.X_I_GLJournal;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for I_GLJournal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_I_GLJournalMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_I_GLJournalInput.Table_Name;
	}

	public X_I_GLJournal I_GLJournalSave(I_I_GLJournalInput Entity, DataFetchingEnvironment environment) {
		return (X_I_GLJournal) super.save((X_I_GLJournalInput) Entity, environment);
	}

	public List<X_I_GLJournal> I_GLJournalSaveMany(List<I_I_GLJournalInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_I_GLJournalInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_I_GLJournal) entity).collect(Collectors.toList());
	}

	public boolean I_GLJournalDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
