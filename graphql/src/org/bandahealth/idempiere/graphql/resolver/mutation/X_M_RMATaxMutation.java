package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_RMATaxInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_RMATaxInput;
import org.compiere.model.MRMATax;

import java.util.List;

/**
 * Generated Query Resolver for M_RMATax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_RMATaxMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_RMATaxInput.Table_Name;
	}

	public MRMATax M_RMATaxSave(I_M_RMATaxInput input, DataFetchingEnvironment environment) {
		return (MRMATax) super.save((X_M_RMATaxInput) input, environment);
	}

	public boolean M_RMATaxDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
