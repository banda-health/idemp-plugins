package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_RatioInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_RatioInput;
import org.compiere.model.X_PA_Ratio;

import java.util.List;

/**
 * Generated Query Resolver for PA_Ratio - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_RatioMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_RatioInput.Table_Name;
	}

	public X_PA_Ratio PA_RatioSave(I_PA_RatioInput input, DataFetchingEnvironment environment) {
		return (X_PA_Ratio) super.save((X_PA_RatioInput) input, environment);
	}

	public boolean PA_RatioDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
