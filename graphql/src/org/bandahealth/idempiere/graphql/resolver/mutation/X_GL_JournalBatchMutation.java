package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_GL_JournalBatchInput;
import org.bandahealth.idempiere.graphql.model.input.X_GL_JournalBatchInput;
import org.compiere.model.MJournalBatch;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for GL_JournalBatch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_GL_JournalBatchMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_GL_JournalBatchInput.Table_Name;
	}

	public MJournalBatch GL_JournalBatchSave(I_GL_JournalBatchInput Entity, DataFetchingEnvironment environment) {
		return (MJournalBatch) super.save((X_GL_JournalBatchInput) Entity, environment);
	}

	public List<MJournalBatch> GL_JournalBatchSaveMany(List<I_GL_JournalBatchInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_GL_JournalBatchInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MJournalBatch) entity).collect(Collectors.toList());
	}

	public boolean GL_JournalBatchDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
