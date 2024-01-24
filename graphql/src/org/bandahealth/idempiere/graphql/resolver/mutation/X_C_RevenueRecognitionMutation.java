package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_RevenueRecognitionInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_RevenueRecognitionInput;
import org.compiere.model.MRevenueRecognition;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_RevenueRecognition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RevenueRecognitionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_RevenueRecognitionInput.Table_Name;
	}

	public MRevenueRecognition C_RevenueRecognitionSave(I_C_RevenueRecognitionInput entity, DataFetchingEnvironment environment) {
		return (MRevenueRecognition) super.save((X_C_RevenueRecognitionInput) entity, environment);
	}

	public List<MRevenueRecognition> C_RevenueRecognitionSaveMany(List<I_C_RevenueRecognitionInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_RevenueRecognitionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRevenueRecognition) entity).collect(Collectors.toList());
	}

	public boolean C_RevenueRecognitionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
