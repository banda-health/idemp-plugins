package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ChangeRequestInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ChangeRequestInput;
import org.compiere.model.MChangeRequest;

import java.util.List;

/**
 * Generated Query Resolver for M_ChangeRequest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_ChangeRequestMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ChangeRequestInput.Table_Name;
	}

	public MChangeRequest M_ChangeRequestSave(I_M_ChangeRequestInput input, DataFetchingEnvironment environment) {
		return (MChangeRequest) super.save((X_M_ChangeRequestInput) input, environment);
	}

	public boolean M_ChangeRequestDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
