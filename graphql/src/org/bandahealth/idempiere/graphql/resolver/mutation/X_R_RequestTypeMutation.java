package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_RequestTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_RequestTypeInput;
import org.compiere.model.MRequestType;

import java.util.List;

/**
 * Generated Query Resolver for R_RequestType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_RequestTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_RequestTypeInput.Table_Name;
	}

	public MRequestType R_RequestTypeSave(I_R_RequestTypeInput input, DataFetchingEnvironment environment) {
		return (MRequestType) super.save((X_R_RequestTypeInput) input, environment);
	}

	public boolean R_RequestTypeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
