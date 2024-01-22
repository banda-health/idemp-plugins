package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_PerpetualInvInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_PerpetualInvInput;
import org.compiere.model.X_M_PerpetualInv;

import java.util.List;

/**
 * Generated Query Resolver for M_PerpetualInv - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_PerpetualInvMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_PerpetualInvInput.Table_Name;
	}

	public X_M_PerpetualInv M_PerpetualInvSave(I_M_PerpetualInvInput input, DataFetchingEnvironment environment) {
		return (X_M_PerpetualInv) super.save((X_M_PerpetualInvInput) input, environment);
	}

	public boolean M_PerpetualInvDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
