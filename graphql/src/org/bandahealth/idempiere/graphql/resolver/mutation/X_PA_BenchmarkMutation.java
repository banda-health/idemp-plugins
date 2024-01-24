package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_BenchmarkInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_BenchmarkInput;
import org.compiere.model.X_PA_Benchmark;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PA_Benchmark - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PA_BenchmarkMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_BenchmarkInput.Table_Name;
	}

	public X_PA_Benchmark PA_BenchmarkSave(I_PA_BenchmarkInput entity, DataFetchingEnvironment environment) {
		return (X_PA_Benchmark) super.save((X_PA_BenchmarkInput) entity, environment);
	}

	public List<X_PA_Benchmark> PA_BenchmarkSaveMany(List<I_PA_BenchmarkInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_PA_BenchmarkInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_PA_Benchmark) entity).collect(Collectors.toList());
	}

	public boolean PA_BenchmarkDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
