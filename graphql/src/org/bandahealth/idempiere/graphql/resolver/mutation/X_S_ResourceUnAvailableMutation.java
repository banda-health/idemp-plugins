package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_S_ResourceUnAvailableInput;
import org.bandahealth.idempiere.graphql.model.input.X_S_ResourceUnAvailableInput;
import org.compiere.model.MResourceUnAvailable;

import java.util.List;

/**
 * Generated Query Resolver for S_ResourceUnAvailable - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_S_ResourceUnAvailableMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_S_ResourceUnAvailableInput.Table_Name;
	}

	public MResourceUnAvailable S_ResourceUnAvailableSave(I_S_ResourceUnAvailableInput input, DataFetchingEnvironment environment) {
		return (MResourceUnAvailable) super.save((X_S_ResourceUnAvailableInput) input, environment);
	}

	public boolean S_ResourceUnAvailableDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
