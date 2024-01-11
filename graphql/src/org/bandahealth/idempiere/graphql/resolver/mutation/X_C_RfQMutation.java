package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_RfQInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_RfQInput;
import org.compiere.model.MRfQ;

import java.util.List;

/**
 * Generated Query Resolver for C_RfQ - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RfQMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_RfQInput.Table_Name;
	}

	public MRfQ C_RfQSave(I_C_RfQInput input, DataFetchingEnvironment environment) {
		return (MRfQ) super.save((X_C_RfQInput) input, environment);
	}

	public boolean C_RfQDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
