package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_EntityTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_EntityTypeInput;
import org.compiere.model.MEntityType;

import java.util.List;

/**
 * Generated Query Resolver for AD_EntityType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_EntityTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_EntityTypeInput.Table_Name;
	}

	public MEntityType AD_EntityTypeSave(I_AD_EntityTypeInput input, DataFetchingEnvironment environment) {
		return (MEntityType) super.save((X_AD_EntityTypeInput) input, environment);
	}

	public boolean AD_EntityTypeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
