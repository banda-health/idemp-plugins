package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ModelValidatorInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ModelValidatorInput;
import org.compiere.model.X_AD_ModelValidator;

import java.util.List;

/**
 * Generated Query Resolver for AD_ModelValidator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ModelValidatorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ModelValidatorInput.Table_Name;
	}

	public X_AD_ModelValidator AD_ModelValidatorSave(I_AD_ModelValidatorInput input, DataFetchingEnvironment environment) {
		return (X_AD_ModelValidator) super.save((X_AD_ModelValidatorInput) input, environment);
	}

	public boolean AD_ModelValidatorDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
