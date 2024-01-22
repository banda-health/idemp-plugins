package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_SystemInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_SystemInput;
import org.compiere.model.MSystem;

import java.util.List;

/**
 * Generated Query Resolver for AD_System - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_SystemMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_SystemInput.Table_Name;
	}

	public MSystem AD_SystemSave(I_AD_SystemInput input, DataFetchingEnvironment environment) {
		return (MSystem) super.save((X_AD_SystemInput) input, environment);
	}

	public boolean AD_SystemDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
