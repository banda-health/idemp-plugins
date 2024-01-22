package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_PaySelectionCheckInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_PaySelectionCheckInput;
import org.compiere.model.MPaySelectionCheck;

import java.util.List;

/**
 * Generated Query Resolver for C_PaySelectionCheck - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_PaySelectionCheckMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_PaySelectionCheckInput.Table_Name;
	}

	public MPaySelectionCheck C_PaySelectionCheckSave(I_C_PaySelectionCheckInput input, DataFetchingEnvironment environment) {
		return (MPaySelectionCheck) super.save((X_C_PaySelectionCheckInput) input, environment);
	}

	public boolean C_PaySelectionCheckDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
