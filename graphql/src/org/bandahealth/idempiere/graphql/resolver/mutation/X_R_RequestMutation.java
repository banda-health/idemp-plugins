package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_RequestInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_RequestInput;
import org.compiere.model.MRequest;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for R_Request - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_RequestMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_RequestInput.Table_Name;
	}

	public MRequest R_RequestSave(I_R_RequestInput entity, DataFetchingEnvironment environment) {
		return (MRequest) super.save((X_R_RequestInput) entity, environment);
	}

	public List<MRequest> R_RequestSaveMany(List<I_R_RequestInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_R_RequestInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRequest) entity).collect(Collectors.toList());
	}

	public boolean R_RequestDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
