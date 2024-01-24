package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_RegionInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_RegionInput;
import org.compiere.model.MRegion;

import java.util.List;

/**
 * Generated Query Resolver for C_Region - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_RegionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_RegionInput.Table_Name;
	}

	public MRegion C_RegionSave(I_C_RegionInput input, DataFetchingEnvironment environment) {
		return (MRegion) super.save((X_C_RegionInput) input, environment);
	}

	public boolean C_RegionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
