package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Package_UUID_MapInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Package_UUID_MapInput;
import org.compiere.model.X_AD_Package_UUID_Map;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Package_UUID_Map - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_Package_UUID_MapMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Package_UUID_MapInput.Table_Name;
	}

	public X_AD_Package_UUID_Map AD_Package_UUID_MapSave(I_AD_Package_UUID_MapInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_Package_UUID_Map) super.save((X_AD_Package_UUID_MapInput) Entity, environment);
	}

	public List<X_AD_Package_UUID_Map> AD_Package_UUID_MapSaveMany(List<I_AD_Package_UUID_MapInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_Package_UUID_MapInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_Package_UUID_Map) entity).collect(Collectors.toList());
	}

	public boolean AD_Package_UUID_MapDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
