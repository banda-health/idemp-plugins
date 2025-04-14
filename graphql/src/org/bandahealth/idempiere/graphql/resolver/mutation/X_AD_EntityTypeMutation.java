package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_EntityTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_EntityTypeInput;
import org.compiere.model.MEntityType;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_EntityType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_EntityTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_EntityTypeInput.Table_Name;
	}

	public MEntityType AD_EntityTypeSave(I_AD_EntityTypeInput Entity, DataFetchingEnvironment environment) {
		return (MEntityType) super.save((X_AD_EntityTypeInput) Entity, environment);
	}

	public List<MEntityType> AD_EntityTypeSaveMany(List<I_AD_EntityTypeInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_EntityTypeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MEntityType) entity).collect(Collectors.toList());
	}

	public boolean AD_EntityTypeDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
