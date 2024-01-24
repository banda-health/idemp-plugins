package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_WS_WebServiceFieldInputInput;
import org.bandahealth.idempiere.graphql.model.input.X_WS_WebServiceFieldInputInput;
import org.compiere.model.X_WS_WebServiceFieldInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for WS_WebServiceFieldInput - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_WS_WebServiceFieldInputMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_WS_WebServiceFieldInputInput.Table_Name;
	}

	public X_WS_WebServiceFieldInput WS_WebServiceFieldInputSave(I_WS_WebServiceFieldInputInput entity, DataFetchingEnvironment environment) {
		return (X_WS_WebServiceFieldInput) super.save((X_WS_WebServiceFieldInputInput) entity, environment);
	}

	public List<X_WS_WebServiceFieldInput> WS_WebServiceFieldInputSaveMany(List<I_WS_WebServiceFieldInputInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_WS_WebServiceFieldInputInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_WS_WebServiceFieldInput) entity).collect(Collectors.toList());
	}

	public boolean WS_WebServiceFieldInputDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
