package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_S_TrainingInput;
import org.bandahealth.idempiere.graphql.model.input.X_S_TrainingInput;
import org.compiere.model.X_S_Training;

import java.util.List;

/**
 * Generated Query Resolver for S_Training - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_S_TrainingMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_S_TrainingInput.Table_Name;
	}

	public X_S_Training S_TrainingSave(I_S_TrainingInput input, DataFetchingEnvironment environment) {
		return (X_S_Training) super.save((X_S_TrainingInput) input, environment);
	}

	public boolean S_TrainingDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
