package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_PInstanceInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_PInstanceInput;
import org.compiere.model.MPInstance;

import java.util.List;

/**
 * Generated Query Resolver for AD_PInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_PInstanceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_PInstanceInput.Table_Name;
	}

	public MPInstance AD_PInstanceSave(I_AD_PInstanceInput input, DataFetchingEnvironment environment) {
		return (MPInstance) super.save((X_AD_PInstanceInput) input, environment);
	}

	public boolean AD_PInstanceDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
