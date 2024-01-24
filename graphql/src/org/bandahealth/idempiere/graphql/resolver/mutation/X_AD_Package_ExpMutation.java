package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Package_ExpInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Package_ExpInput;
import org.compiere.model.MPackageExp;

import java.util.List;

/**
 * Generated Query Resolver for AD_Package_Exp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Package_ExpMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Package_ExpInput.Table_Name;
	}

	public MPackageExp AD_Package_ExpSave(I_AD_Package_ExpInput input, DataFetchingEnvironment environment) {
		return (MPackageExp) super.save((X_AD_Package_ExpInput) input, environment);
	}

	public boolean AD_Package_ExpDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
