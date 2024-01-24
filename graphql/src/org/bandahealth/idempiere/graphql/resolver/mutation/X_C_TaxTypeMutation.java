package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_TaxTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_TaxTypeInput;
import org.eevolution.model.X_C_TaxType;

import java.util.List;

/**
 * Generated Query Resolver for C_TaxType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_TaxTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_TaxTypeInput.Table_Name;
	}

	public X_C_TaxType C_TaxTypeSave(I_C_TaxTypeInput input, DataFetchingEnvironment environment) {
		return (X_C_TaxType) super.save((X_C_TaxTypeInput) input, environment);
	}

	public boolean C_TaxTypeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
