package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_GL_JournalLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_GL_JournalLineInput;
import org.compiere.model.MJournalLine;

import java.util.List;

/**
 * Generated Query Resolver for GL_JournalLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_GL_JournalLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_GL_JournalLineInput.Table_Name;
	}

	public MJournalLine GL_JournalLineSave(I_GL_JournalLineInput input, DataFetchingEnvironment environment) {
		return (MJournalLine) super.save((X_GL_JournalLineInput) input, environment);
	}

	public boolean GL_JournalLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
