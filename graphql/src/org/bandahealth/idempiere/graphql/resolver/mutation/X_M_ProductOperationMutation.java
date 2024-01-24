package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ProductOperationInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ProductOperationInput;
import org.compiere.model.X_M_ProductOperation;

import java.util.List;

/**
 * Generated Query Resolver for M_ProductOperation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ProductOperationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ProductOperationInput.Table_Name;
	}

	public X_M_ProductOperation M_ProductOperationSave(I_M_ProductOperationInput input, DataFetchingEnvironment environment) {
		return (X_M_ProductOperation) super.save((X_M_ProductOperationInput) input, environment);
	}

	public boolean M_ProductOperationDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
