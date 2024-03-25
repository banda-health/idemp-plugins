package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_BenchmarkDataInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_BenchmarkDataInput;
import org.compiere.model.X_PA_BenchmarkData;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PA_BenchmarkData - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_BenchmarkDataMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_BenchmarkDataInput.Table_Name;
	}

	public X_PA_BenchmarkData PA_BenchmarkDataSave(I_PA_BenchmarkDataInput entity, DataFetchingEnvironment environment) {
		return (X_PA_BenchmarkData) super.save((X_PA_BenchmarkDataInput) entity, environment);
	}

	public List<X_PA_BenchmarkData> PA_BenchmarkDataSaveMany(List<I_PA_BenchmarkDataInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_PA_BenchmarkDataInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_PA_BenchmarkData) entity).collect(Collectors.toList());
	}

	public boolean PA_BenchmarkDataDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
