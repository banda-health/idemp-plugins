package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_LocationInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_LocationInput;
import org.compiere.model.MLocation;

import java.util.List;

/**
 * Generated Query Resolver for C_Location - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_LocationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_LocationInput.Table_Name;
	}

	public MLocation C_LocationSave(I_C_LocationInput input, DataFetchingEnvironment environment) {
		return (MLocation) super.save((X_C_LocationInput) input, environment);
	}

	public boolean C_LocationDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
