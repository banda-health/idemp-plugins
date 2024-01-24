package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_GL_JournalGeneratorSourceInput;
import org.bandahealth.idempiere.graphql.model.input.X_GL_JournalGeneratorSourceInput;
import org.compiere.model.MJournalGeneratorSource;

import java.util.List;

/**
 * Generated Query Resolver for GL_JournalGeneratorSource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_GL_JournalGeneratorSourceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_GL_JournalGeneratorSourceInput.Table_Name;
	}

	public MJournalGeneratorSource GL_JournalGeneratorSourceSave(I_GL_JournalGeneratorSourceInput input, DataFetchingEnvironment environment) {
		return (MJournalGeneratorSource) super.save((X_GL_JournalGeneratorSourceInput) input, environment);
	}

	public boolean GL_JournalGeneratorSourceDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
