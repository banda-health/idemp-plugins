package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_WS_WebServiceTypeAccessInput;
import org.bandahealth.idempiere.graphql.model.input.X_WS_WebServiceTypeAccessInput;
import org.compiere.model.X_WS_WebServiceTypeAccess;

import java.util.List;

/**
 * Generated Query Resolver for WS_WebServiceTypeAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_WS_WebServiceTypeAccessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_WS_WebServiceTypeAccessInput.Table_Name;
	}

	public X_WS_WebServiceTypeAccess WS_WebServiceTypeAccessSave(I_WS_WebServiceTypeAccessInput input, DataFetchingEnvironment environment) {
		return (X_WS_WebServiceTypeAccess) super.save((X_WS_WebServiceTypeAccessInput) input, environment);
	}

	public boolean WS_WebServiceTypeAccessDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
