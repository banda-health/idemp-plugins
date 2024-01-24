package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_WS_WebServiceFieldOutputInput;
import org.bandahealth.idempiere.graphql.model.input.X_WS_WebServiceFieldOutputInput;
import org.compiere.model.X_WS_WebServiceFieldOutput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for WS_WebServiceFieldOutput - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_WS_WebServiceFieldOutputMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_WS_WebServiceFieldOutputInput.Table_Name;
	}

	public X_WS_WebServiceFieldOutput WS_WebServiceFieldOutputSave(I_WS_WebServiceFieldOutputInput entity, DataFetchingEnvironment environment) {
		return (X_WS_WebServiceFieldOutput) super.save((X_WS_WebServiceFieldOutputInput) entity, environment);
	}

	public List<X_WS_WebServiceFieldOutput> WS_WebServiceFieldOutputSaveMany(List<I_WS_WebServiceFieldOutputInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_WS_WebServiceFieldOutputInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_WS_WebServiceFieldOutput) entity).collect(Collectors.toList());
	}

	public boolean WS_WebServiceFieldOutputDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
