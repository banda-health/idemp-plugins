package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_SalesRegionInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_SalesRegionInput;
import org.compiere.model.MSalesRegion;

import java.util.List;

/**
 * Generated Query Resolver for C_SalesRegion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_SalesRegionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_SalesRegionInput.Table_Name;
	}

	public MSalesRegion C_SalesRegionSave(I_C_SalesRegionInput input, DataFetchingEnvironment environment) {
		return (MSalesRegion) super.save((X_C_SalesRegionInput) input, environment);
	}

	public boolean C_SalesRegionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
