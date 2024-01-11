package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MFieldGroup_BH;
import org.bandahealth.idempiere.graphql.model.input.I_AD_FieldGroupInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_FieldGroupInput;

import java.util.List;

/**
 * Generated Query Resolver for AD_FieldGroup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_FieldGroupMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_FieldGroupInput.Table_Name;
	}

	public MFieldGroup_BH AD_FieldGroupSave(I_AD_FieldGroupInput input, DataFetchingEnvironment environment) {
		return (MFieldGroup_BH) super.save((X_AD_FieldGroupInput) input, environment);
	}

	public boolean AD_FieldGroupDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
