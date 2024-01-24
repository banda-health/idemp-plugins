package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_DocTypeCounterInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_DocTypeCounterInput;
import org.compiere.model.MDocTypeCounter;

import java.util.List;

/**
 * Generated Query Resolver for C_DocTypeCounter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_DocTypeCounterMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_DocTypeCounterInput.Table_Name;
	}

	public MDocTypeCounter C_DocTypeCounterSave(I_C_DocTypeCounterInput input, DataFetchingEnvironment environment) {
		return (MDocTypeCounter) super.save((X_C_DocTypeCounterInput) input, environment);
	}

	public boolean C_DocTypeCounterDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
