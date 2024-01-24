package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_OrgInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_OrgInput;
import org.compiere.model.MOrg;

import java.util.List;

/**
 * Generated Query Resolver for AD_Org - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_OrgMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_OrgInput.Table_Name;
	}

	public MOrg AD_OrgSave(I_AD_OrgInput input, DataFetchingEnvironment environment) {
		return (MOrg) super.save((X_AD_OrgInput) input, environment);
	}

	public boolean AD_OrgDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
