package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_TaxProviderCfgInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_TaxProviderCfgInput;
import org.compiere.model.X_C_TaxProviderCfg;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_TaxProviderCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_TaxProviderCfgMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_TaxProviderCfgInput.Table_Name;
	}

	public X_C_TaxProviderCfg C_TaxProviderCfgSave(I_C_TaxProviderCfgInput entity, DataFetchingEnvironment environment) {
		return (X_C_TaxProviderCfg) super.save((X_C_TaxProviderCfgInput) entity, environment);
	}

	public List<X_C_TaxProviderCfg> C_TaxProviderCfgSaveMany(List<I_C_TaxProviderCfgInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_TaxProviderCfgInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_TaxProviderCfg) entity).collect(Collectors.toList());
	}

	public boolean C_TaxProviderCfgDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
