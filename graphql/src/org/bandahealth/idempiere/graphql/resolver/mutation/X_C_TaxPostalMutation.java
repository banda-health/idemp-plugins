package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_TaxPostalInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_TaxPostalInput;
import org.compiere.model.MTaxPostal;

import java.util.List;

/**
 * Generated Query Resolver for C_TaxPostal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxPostalMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_TaxPostalInput.Table_Name;
	}

	public MTaxPostal C_TaxPostalSave(I_C_TaxPostalInput input, DataFetchingEnvironment environment) {
		return (MTaxPostal) super.save((X_C_TaxPostalInput) input, environment);
	}

	public boolean C_TaxPostalDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
