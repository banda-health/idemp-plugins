package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_ASP_ClientExceptionInput;
import org.bandahealth.idempiere.graphql.model.input.X_ASP_ClientExceptionInput;
import org.compiere.model.X_ASP_ClientException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for ASP_ClientException - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_ASP_ClientExceptionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_ASP_ClientExceptionInput.Table_Name;
	}

	public X_ASP_ClientException ASP_ClientExceptionSave(I_ASP_ClientExceptionInput entity, DataFetchingEnvironment environment) {
		return (X_ASP_ClientException) super.save((X_ASP_ClientExceptionInput) entity, environment);
	}

	public List<X_ASP_ClientException> ASP_ClientExceptionSaveMany(List<I_ASP_ClientExceptionInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_ASP_ClientExceptionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_ASP_ClientException) entity).collect(Collectors.toList());
	}

	public boolean ASP_ClientExceptionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
