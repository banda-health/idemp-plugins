package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_GL_JournalGeneratorInput;
import org.bandahealth.idempiere.graphql.model.input.X_GL_JournalGeneratorInput;
import org.compiere.model.MJournalGenerator;

import java.util.List;

/**
 * Generated Query Resolver for GL_JournalGenerator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_GL_JournalGeneratorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_GL_JournalGeneratorInput.Table_Name;
	}

	public MJournalGenerator GL_JournalGeneratorSave(I_GL_JournalGeneratorInput input, DataFetchingEnvironment environment) {
		return (MJournalGenerator) super.save((X_GL_JournalGeneratorInput) input, environment);
	}

	public boolean GL_JournalGeneratorDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
