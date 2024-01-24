package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_FindInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_FindInput;
import org.compiere.model.X_AD_Find;

import java.util.List;

/**
 * Generated Query Resolver for AD_Find - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_FindMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_FindInput.Table_Name;
	}

	public X_AD_Find AD_FindSave(I_AD_FindInput input, DataFetchingEnvironment environment) {
		return (X_AD_Find) super.save((X_AD_FindInput) input, environment);
	}

	public boolean AD_FindDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
