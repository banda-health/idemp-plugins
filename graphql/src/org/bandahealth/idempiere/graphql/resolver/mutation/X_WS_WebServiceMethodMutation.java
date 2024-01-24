package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_WS_WebServiceMethodInput;
import org.bandahealth.idempiere.graphql.model.input.X_WS_WebServiceMethodInput;
import org.compiere.model.X_WS_WebServiceMethod;

import java.util.List;

/**
 * Generated Query Resolver for WS_WebServiceMethod - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_WS_WebServiceMethodMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_WS_WebServiceMethodInput.Table_Name;
	}

	public X_WS_WebServiceMethod WS_WebServiceMethodSave(I_WS_WebServiceMethodInput input, DataFetchingEnvironment environment) {
		return (X_WS_WebServiceMethod) super.save((X_WS_WebServiceMethodInput) input, environment);
	}

	public boolean WS_WebServiceMethodDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
