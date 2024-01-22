package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_GroupUpdatesInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_GroupUpdatesInput;
import org.compiere.model.X_R_GroupUpdates;

import java.util.List;

/**
 * Generated Query Resolver for R_GroupUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_GroupUpdatesMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_GroupUpdatesInput.Table_Name;
	}

	public X_R_GroupUpdates R_GroupUpdatesSave(I_R_GroupUpdatesInput input, DataFetchingEnvironment environment) {
		return (X_R_GroupUpdates) super.save((X_R_GroupUpdatesInput) input, environment);
	}

	public boolean R_GroupUpdatesDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
