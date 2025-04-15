package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_GL_JournalLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_GL_JournalLineInput;
import org.compiere.model.MJournalLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for GL_JournalLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_GL_JournalLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_GL_JournalLineInput.Table_Name;
	}

	public MJournalLine GL_JournalLineSave(I_GL_JournalLineInput Entity, DataFetchingEnvironment environment) {
		return (MJournalLine) super.save((X_GL_JournalLineInput) Entity, environment);
	}

	public List<MJournalLine> GL_JournalLineSaveMany(List<I_GL_JournalLineInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_GL_JournalLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MJournalLine) entity).collect(Collectors.toList());
	}

	public boolean GL_JournalLineDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
