package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_OperationResourceInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_OperationResourceInput;
import org.compiere.model.X_M_OperationResource;

import java.util.List;

/**
 * Generated Query Resolver for M_OperationResource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_OperationResourceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_OperationResourceInput.Table_Name;
	}

	public X_M_OperationResource M_OperationResourceSave(I_M_OperationResourceInput input, DataFetchingEnvironment environment) {
		return (X_M_OperationResource) super.save((X_M_OperationResourceInput) input, environment);
	}

	public boolean M_OperationResourceDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
