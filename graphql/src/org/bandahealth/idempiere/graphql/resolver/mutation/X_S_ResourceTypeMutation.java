package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_S_ResourceTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_S_ResourceTypeInput;
import org.compiere.model.MResourceType;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for S_ResourceType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_S_ResourceTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_S_ResourceTypeInput.Table_Name;
	}

	public MResourceType S_ResourceTypeSave(I_S_ResourceTypeInput Entity, DataFetchingEnvironment environment) {
		return (MResourceType) super.save((X_S_ResourceTypeInput) Entity, environment);
	}

	public List<MResourceType> S_ResourceTypeSaveMany(List<I_S_ResourceTypeInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_S_ResourceTypeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MResourceType) entity).collect(Collectors.toList());
	}

	public boolean S_ResourceTypeDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
