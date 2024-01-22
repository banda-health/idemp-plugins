package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_FreightInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_FreightInput;
import org.compiere.model.X_M_Freight;

import java.util.List;

/**
 * Generated Query Resolver for M_Freight - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_FreightMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_FreightInput.Table_Name;
	}

	public X_M_Freight M_FreightSave(I_M_FreightInput input, DataFetchingEnvironment environment) {
		return (X_M_Freight) super.save((X_M_FreightInput) input, environment);
	}

	public boolean M_FreightDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
