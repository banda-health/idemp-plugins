package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_WS_WebServiceTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_WS_WebServiceTypeInput;
import org.compiere.model.X_WS_WebServiceType;

import java.util.List;

/**
 * Generated Query Resolver for WS_WebServiceType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_WS_WebServiceTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_WS_WebServiceTypeInput.Table_Name;
	}

	public X_WS_WebServiceType WS_WebServiceTypeSave(I_WS_WebServiceTypeInput input, DataFetchingEnvironment environment) {
		return (X_WS_WebServiceType) super.save((X_WS_WebServiceTypeInput) input, environment);
	}

	public boolean WS_WebServiceTypeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
