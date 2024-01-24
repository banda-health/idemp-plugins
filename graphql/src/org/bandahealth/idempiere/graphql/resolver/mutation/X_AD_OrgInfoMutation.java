package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MOrgInfo_BH;
import org.bandahealth.idempiere.graphql.model.input.I_AD_OrgInfoInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_OrgInfoInput;

import java.util.List;

/**
 * Generated Query Resolver for AD_OrgInfo - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_OrgInfoMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_OrgInfoInput.Table_Name;
	}

	public MOrgInfo_BH AD_OrgInfoSave(I_AD_OrgInfoInput input, DataFetchingEnvironment environment) {
		return (MOrgInfo_BH) super.save((X_AD_OrgInfoInput) input, environment);
	}

	public boolean AD_OrgInfoDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
