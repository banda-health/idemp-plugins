package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_FundingModeInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_FundingModeInput;
import org.compiere.model.X_A_FundingMode;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_FundingMode - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_FundingModeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_FundingModeInput.Table_Name;
	}

	public X_A_FundingMode A_FundingModeSave(I_A_FundingModeInput Entity, DataFetchingEnvironment environment) {
		return (X_A_FundingMode) super.save((X_A_FundingModeInput) Entity, environment);
	}

	public List<X_A_FundingMode> A_FundingModeSaveMany(List<I_A_FundingModeInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_A_FundingModeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_A_FundingMode) entity).collect(Collectors.toList());
	}

	public boolean A_FundingModeDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
