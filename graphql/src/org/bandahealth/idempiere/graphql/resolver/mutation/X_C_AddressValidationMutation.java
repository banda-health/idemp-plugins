package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_AddressValidationInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_AddressValidationInput;
import org.compiere.model.MAddressValidation;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_AddressValidation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_AddressValidationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_AddressValidationInput.Table_Name;
	}

	public MAddressValidation C_AddressValidationSave(I_C_AddressValidationInput entity, DataFetchingEnvironment environment) {
		return (MAddressValidation) super.save((X_C_AddressValidationInput) entity, environment);
	}

	public List<MAddressValidation> C_AddressValidationSaveMany(List<I_C_AddressValidationInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_AddressValidationInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAddressValidation) entity).collect(Collectors.toList());
	}

	public boolean C_AddressValidationDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
