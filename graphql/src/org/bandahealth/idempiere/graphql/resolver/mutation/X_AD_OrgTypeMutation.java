package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_OrgTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_OrgTypeInput;
import org.compiere.model.X_AD_OrgType;

import java.util.List;

/**
 * Generated Query Resolver for AD_OrgType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_OrgTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_OrgTypeInput.Table_Name;
	}

	public X_AD_OrgType AD_OrgTypeSave(I_AD_OrgTypeInput input, DataFetchingEnvironment environment) {
		return (X_AD_OrgType) super.save((X_AD_OrgTypeInput) input, environment);
	}

	public boolean AD_OrgTypeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
