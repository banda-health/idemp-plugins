package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_AddressValidationCfgInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_AddressValidationCfgInput;
import org.compiere.model.X_C_AddressValidationCfg;

import java.util.List;

/**
 * Generated Query Resolver for C_AddressValidationCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AddressValidationCfgMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_AddressValidationCfgInput.Table_Name;
	}

	public X_C_AddressValidationCfg C_AddressValidationCfgSave(I_C_AddressValidationCfgInput input, DataFetchingEnvironment environment) {
		return (X_C_AddressValidationCfg) super.save((X_C_AddressValidationCfgInput) input, environment);
	}

	public boolean C_AddressValidationCfgDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
