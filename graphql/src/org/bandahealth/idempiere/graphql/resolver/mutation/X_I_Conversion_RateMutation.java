package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_I_Conversion_RateInput;
import org.bandahealth.idempiere.graphql.model.input.X_I_Conversion_RateInput;
import org.compiere.model.X_I_Conversion_Rate;

import java.util.List;

/**
 * Generated Query Resolver for I_Conversion_Rate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_I_Conversion_RateMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_I_Conversion_RateInput.Table_Name;
	}

	public X_I_Conversion_Rate I_Conversion_RateSave(I_I_Conversion_RateInput input, DataFetchingEnvironment environment) {
		return (X_I_Conversion_Rate) super.save((X_I_Conversion_RateInput) input, environment);
	}

	public boolean I_Conversion_RateDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
