package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_Conversion_RateInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_Conversion_RateInput;
import org.compiere.model.MConversionRate;

import java.util.List;

/**
 * Generated Query Resolver for C_Conversion_Rate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_Conversion_RateMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_Conversion_RateInput.Table_Name;
	}

	public MConversionRate C_Conversion_RateSave(I_C_Conversion_RateInput input, DataFetchingEnvironment environment) {
		return (MConversionRate) super.save((X_C_Conversion_RateInput) input, environment);
	}

	public boolean C_Conversion_RateDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
