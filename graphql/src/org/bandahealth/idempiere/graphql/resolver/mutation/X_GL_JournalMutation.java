package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_GL_JournalInput;
import org.bandahealth.idempiere.graphql.model.input.X_GL_JournalInput;
import org.compiere.model.MJournal;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for GL_Journal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_GL_JournalMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_GL_JournalInput.Table_Name;
	}

	public MJournal GL_JournalSave(I_GL_JournalInput entity, DataFetchingEnvironment environment) {
		return (MJournal) super.save((X_GL_JournalInput) entity, environment);
	}

	public List<MJournal> GL_JournalSaveMany(List<I_GL_JournalInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_GL_JournalInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MJournal) entity).collect(Collectors.toList());
	}

	public boolean GL_JournalDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
