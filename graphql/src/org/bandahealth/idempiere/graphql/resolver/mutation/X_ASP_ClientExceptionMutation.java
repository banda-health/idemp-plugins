package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_ASP_ClientExceptionInput;
import org.bandahealth.idempiere.graphql.model.input.X_ASP_ClientExceptionInput;
import org.compiere.model.X_ASP_ClientException;

import java.util.List;

/**
 * Generated Query Resolver for ASP_ClientException - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_ASP_ClientExceptionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_ASP_ClientExceptionInput.Table_Name;
	}

	public X_ASP_ClientException ASP_ClientExceptionSave(I_ASP_ClientExceptionInput input, DataFetchingEnvironment environment) {
		return (X_ASP_ClientException) super.save((X_ASP_ClientExceptionInput) input, environment);
	}

	public boolean ASP_ClientExceptionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
