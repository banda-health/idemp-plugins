package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_RequestTypeUpdatesInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_RequestTypeUpdatesInput;
import org.compiere.model.X_R_RequestTypeUpdates;

import java.util.List;

/**
 * Generated Query Resolver for R_RequestTypeUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_RequestTypeUpdatesMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_RequestTypeUpdatesInput.Table_Name;
	}

	public X_R_RequestTypeUpdates R_RequestTypeUpdatesSave(I_R_RequestTypeUpdatesInput input, DataFetchingEnvironment environment) {
		return (X_R_RequestTypeUpdates) super.save((X_R_RequestTypeUpdatesInput) input, environment);
	}

	public boolean R_RequestTypeUpdatesDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
