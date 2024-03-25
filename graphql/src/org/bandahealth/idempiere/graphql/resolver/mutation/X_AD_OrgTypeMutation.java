package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_OrgTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_OrgTypeInput;
import org.compiere.model.X_AD_OrgType;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_OrgType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_OrgTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_OrgTypeInput.Table_Name;
	}

	public X_AD_OrgType AD_OrgTypeSave(I_AD_OrgTypeInput entity, DataFetchingEnvironment environment) {
		return (X_AD_OrgType) super.save((X_AD_OrgTypeInput) entity, environment);
	}

	public List<X_AD_OrgType> AD_OrgTypeSaveMany(List<I_AD_OrgTypeInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_OrgTypeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_OrgType) entity).collect(Collectors.toList());
	}

	public boolean AD_OrgTypeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
