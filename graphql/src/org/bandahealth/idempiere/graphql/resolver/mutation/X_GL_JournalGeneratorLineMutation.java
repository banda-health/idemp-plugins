package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_GL_JournalGeneratorLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_GL_JournalGeneratorLineInput;
import org.compiere.model.MJournalGeneratorLine;

import java.util.List;
import java.util.stream.Collectors;

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

	public MJournalGeneratorLine GL_JournalGeneratorLineSave(I_GL_JournalGeneratorLineInput entity, DataFetchingEnvironment environment) {
		return (MJournalGeneratorLine) super.save((X_GL_JournalGeneratorLineInput) entity, environment);
	}

	public List<MJournalGeneratorLine> GL_JournalGeneratorLineSaveMany(List<I_GL_JournalGeneratorLineInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_GL_JournalGeneratorLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MJournalGeneratorLine) entity).collect(Collectors.toList());
	}

	public boolean GL_JournalGeneratorLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
