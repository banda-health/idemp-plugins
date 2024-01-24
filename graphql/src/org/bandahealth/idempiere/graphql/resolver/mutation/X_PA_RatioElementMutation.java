package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_RatioElementInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_RatioElementInput;
import org.compiere.model.X_PA_RatioElement;

import java.util.List;

/**
 * Generated Query Resolver for PA_RatioElement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PA_RatioElementMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_RatioElementInput.Table_Name;
	}

	public X_PA_RatioElement PA_RatioElementSave(I_PA_RatioElementInput input, DataFetchingEnvironment environment) {
		return (X_PA_RatioElement) super.save((X_PA_RatioElementInput) input, environment);
	}

	public boolean PA_RatioElementDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
