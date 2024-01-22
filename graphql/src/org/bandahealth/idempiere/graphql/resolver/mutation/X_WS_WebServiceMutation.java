package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_WS_WebServiceInput;
import org.bandahealth.idempiere.graphql.model.input.X_WS_WebServiceInput;
import org.compiere.model.X_WS_WebService;

import java.util.List;

/**
 * Generated Query Resolver for WS_WebService - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_WS_WebServiceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_WS_WebServiceInput.Table_Name;
	}

	public X_WS_WebService WS_WebServiceSave(I_WS_WebServiceInput input, DataFetchingEnvironment environment) {
		return (X_WS_WebService) super.save((X_WS_WebServiceInput) input, environment);
	}

	public boolean WS_WebServiceDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
