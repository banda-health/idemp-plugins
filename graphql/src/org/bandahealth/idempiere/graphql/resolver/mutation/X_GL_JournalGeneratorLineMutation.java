package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_GL_JournalGeneratorLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_GL_JournalGeneratorLineInput;
import org.compiere.model.MJournalGeneratorLine;

import java.util.List;

/**
 * Generated Query Resolver for GL_JournalGeneratorLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_GL_JournalGeneratorLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_GL_JournalGeneratorLineInput.Table_Name;
	}

	public MJournalGeneratorLine GL_JournalGeneratorLineSave(I_GL_JournalGeneratorLineInput input, DataFetchingEnvironment environment) {
		return (MJournalGeneratorLine) super.save((X_GL_JournalGeneratorLineInput) input, environment);
	}

	public boolean GL_JournalGeneratorLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
