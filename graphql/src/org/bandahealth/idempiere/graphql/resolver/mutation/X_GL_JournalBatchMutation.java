package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_GL_JournalBatchInput;
import org.bandahealth.idempiere.graphql.model.input.X_GL_JournalBatchInput;
import org.compiere.model.MJournalBatch;

import java.util.List;

/**
 * Generated Query Resolver for GL_JournalBatch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_JournalBatchMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_GL_JournalBatchInput.Table_Name;
	}

	public MJournalBatch GL_JournalBatchSave(I_GL_JournalBatchInput input, DataFetchingEnvironment environment) {
		return (MJournalBatch) super.save((X_GL_JournalBatchInput) input, environment);
	}

	public boolean GL_JournalBatchDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
