package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_TaxDefinitionInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_TaxDefinitionInput;
import org.eevolution.model.X_C_TaxDefinition;

import java.util.List;

/**
 * Generated Query Resolver for C_TaxDefinition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_TaxDefinitionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_TaxDefinitionInput.Table_Name;
	}

	public X_C_TaxDefinition C_TaxDefinitionSave(I_C_TaxDefinitionInput input, DataFetchingEnvironment environment) {
		return (X_C_TaxDefinition) super.save((X_C_TaxDefinitionInput) input, environment);
	}

	public boolean C_TaxDefinitionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
