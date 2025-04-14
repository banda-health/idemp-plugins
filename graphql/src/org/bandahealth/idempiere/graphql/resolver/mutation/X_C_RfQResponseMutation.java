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
 * @version Release 13 - $Id$
 */
public class X_C_RfQResponseMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_RfQResponseInput.Table_Name;
	}

	public MRfQResponse C_RfQResponseSave(I_C_RfQResponseInput Entity, DataFetchingEnvironment environment) {
		return (MRfQResponse) super.save((X_C_RfQResponseInput) Entity, environment);
	}

	public List<MRfQResponse> C_RfQResponseSaveMany(List<I_C_RfQResponseInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_RfQResponseInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRfQResponse) entity).collect(Collectors.toList());
	}

	public boolean C_RfQResponseDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
