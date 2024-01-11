package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_WS_WebServiceFieldOutputInput;
import org.bandahealth.idempiere.graphql.model.input.X_WS_WebServiceFieldOutputInput;
import org.compiere.model.X_WS_WebServiceFieldOutput;

import java.util.List;

/**
 * Generated Query Resolver for WS_WebServiceFieldOutput - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_WS_WebServiceFieldOutputMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_WS_WebServiceFieldOutputInput.Table_Name;
	}

	public X_WS_WebServiceFieldOutput WS_WebServiceFieldOutputSave(I_WS_WebServiceFieldOutputInput input, DataFetchingEnvironment environment) {
		return (X_WS_WebServiceFieldOutput) super.save((X_WS_WebServiceFieldOutputInput) input, environment);
	}

	public boolean WS_WebServiceFieldOutputDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
