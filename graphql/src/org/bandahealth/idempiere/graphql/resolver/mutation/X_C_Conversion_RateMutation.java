package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_Conversion_RateInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_Conversion_RateInput;
import org.compiere.model.MConversionRate;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Conversion_Rate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_Conversion_RateMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_Conversion_RateInput.Table_Name;
	}

	public MConversionRate C_Conversion_RateSave(I_C_Conversion_RateInput Entity, DataFetchingEnvironment environment) {
		return (MConversionRate) super.save((X_C_Conversion_RateInput) Entity, environment);
	}

	public List<MConversionRate> C_Conversion_RateSaveMany(List<I_C_Conversion_RateInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_Conversion_RateInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MConversionRate) entity).collect(Collectors.toList());
	}

	public boolean C_Conversion_RateDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
