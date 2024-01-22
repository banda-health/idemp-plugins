package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_POSTenderTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_POSTenderTypeInput;
import org.compiere.model.X_C_POSTenderType;

import java.util.List;

/**
 * Generated Query Resolver for C_POSTenderType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_POSTenderTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_POSTenderTypeInput.Table_Name;
	}

	public X_C_POSTenderType C_POSTenderTypeSave(I_C_POSTenderTypeInput input, DataFetchingEnvironment environment) {
		return (X_C_POSTenderType) super.save((X_C_POSTenderTypeInput) input, environment);
	}

	public boolean C_POSTenderTypeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
