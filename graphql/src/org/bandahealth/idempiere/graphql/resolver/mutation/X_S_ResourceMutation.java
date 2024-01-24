package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_S_ResourceInput;
import org.bandahealth.idempiere.graphql.model.input.X_S_ResourceInput;
import org.compiere.model.MResource;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for S_Resource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_S_ResourceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_S_ResourceInput.Table_Name;
	}

	public MResource S_ResourceSave(I_S_ResourceInput entity, DataFetchingEnvironment environment) {
		return (MResource) super.save((X_S_ResourceInput) entity, environment);
	}

	public List<MResource> S_ResourceSaveMany(List<I_S_ResourceInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_S_ResourceInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MResource) entity).collect(Collectors.toList());
	}

	public boolean S_ResourceDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
