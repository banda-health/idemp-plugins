package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_RfQResponseInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_RfQResponseInput;
import org.compiere.model.MRfQResponse;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_RfQResponse - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_RfQResponseMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_RfQResponseInput.Table_Name;
	}

	public MRfQResponse C_RfQResponseSave(I_C_RfQResponseInput entity, DataFetchingEnvironment environment) {
		return (MRfQResponse) super.save((X_C_RfQResponseInput) entity, environment);
	}

	public List<MRfQResponse> C_RfQResponseSaveMany(List<I_C_RfQResponseInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_RfQResponseInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRfQResponse) entity).collect(Collectors.toList());
	}

	public boolean C_RfQResponseDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
