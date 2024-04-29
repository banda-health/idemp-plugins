package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_RatioElementInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_RatioElementInput;
import org.compiere.model.X_PA_RatioElement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PA_RatioElement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_RatioElementMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_RatioElementInput.Table_Name;
	}

	public X_PA_RatioElement PA_RatioElementSave(I_PA_RatioElementInput Entity, DataFetchingEnvironment environment) {
		return (X_PA_RatioElement) super.save((X_PA_RatioElementInput) Entity, environment);
	}

	public List<X_PA_RatioElement> PA_RatioElementSaveMany(List<I_PA_RatioElementInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_PA_RatioElementInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_PA_RatioElement) entity).collect(Collectors.toList());
	}

	public boolean PA_RatioElementDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
