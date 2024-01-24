package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_RevenueRecognition_RunInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_RevenueRecognition_RunInput;
import org.compiere.model.MRevenueRecognitionRun;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_RevenueRecognition_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_RevenueRecognition_RunMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_RevenueRecognition_RunInput.Table_Name;
	}

	public MRevenueRecognitionRun C_RevenueRecognition_RunSave(I_C_RevenueRecognition_RunInput entity, DataFetchingEnvironment environment) {
		return (MRevenueRecognitionRun) super.save((X_C_RevenueRecognition_RunInput) entity, environment);
	}

	public List<MRevenueRecognitionRun> C_RevenueRecognition_RunSaveMany(List<I_C_RevenueRecognition_RunInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_RevenueRecognition_RunInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRevenueRecognitionRun) entity).collect(Collectors.toList());
	}

	public boolean C_RevenueRecognition_RunDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
