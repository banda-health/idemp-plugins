package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_FindInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_FindInput;
import org.compiere.model.X_AD_Find;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Find - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_FindMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_FindInput.Table_Name;
	}

	public X_AD_Find AD_FindSave(I_AD_FindInput entity, DataFetchingEnvironment environment) {
		return (X_AD_Find) super.save((X_AD_FindInput) entity, environment);
	}

	public List<X_AD_Find> AD_FindSaveMany(List<I_AD_FindInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_FindInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_Find) entity).collect(Collectors.toList());
	}

	public boolean AD_FindDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
