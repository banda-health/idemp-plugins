package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_RatioInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_RatioInput;
import org.compiere.model.X_PA_Ratio;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PA_Ratio - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PA_RatioMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_RatioInput.Table_Name;
	}

	public X_PA_Ratio PA_RatioSave(I_PA_RatioInput entity, DataFetchingEnvironment environment) {
		return (X_PA_Ratio) super.save((X_PA_RatioInput) entity, environment);
	}

	public List<X_PA_Ratio> PA_RatioSaveMany(List<I_PA_RatioInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_PA_RatioInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_PA_Ratio) entity).collect(Collectors.toList());
	}

	public boolean PA_RatioDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
