package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_RMATypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_RMATypeInput;
import org.compiere.model.X_M_RMAType;

import java.util.List;

/**
 * Generated Query Resolver for M_RMAType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_RMATypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_RMATypeInput.Table_Name;
	}

	public X_M_RMAType M_RMATypeSave(I_M_RMATypeInput input, DataFetchingEnvironment environment) {
		return (X_M_RMAType) super.save((X_M_RMATypeInput) input, environment);
	}

	public boolean M_RMATypeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
