package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_AddressValidationCfgInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_AddressValidationCfgInput;
import org.compiere.model.X_C_AddressValidationCfg;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_AddressValidationCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_AddressValidationCfgMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_AddressValidationCfgInput.Table_Name;
	}

	public X_C_AddressValidationCfg C_AddressValidationCfgSave(I_C_AddressValidationCfgInput entity, DataFetchingEnvironment environment) {
		return (X_C_AddressValidationCfg) super.save((X_C_AddressValidationCfgInput) entity, environment);
	}

	public List<X_C_AddressValidationCfg> C_AddressValidationCfgSaveMany(List<I_C_AddressValidationCfgInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_AddressValidationCfgInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_AddressValidationCfg) entity).collect(Collectors.toList());
	}

	public boolean C_AddressValidationCfgDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
