package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_RequestInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_RequestInput;
import org.compiere.model.MRequest;

import java.util.List;

/**
 * Generated Query Resolver for R_Request - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_RequestMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_RequestInput.Table_Name;
	}

	public MRequest R_RequestSave(I_R_RequestInput input, DataFetchingEnvironment environment) {
		return (MRequest) super.save((X_R_RequestInput) input, environment);
	}

	public boolean R_RequestDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
