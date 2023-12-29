package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_POSInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_POSInput;
import org.compiere.model.MPOS;

import java.util.List;

/**
 * Generated Query Resolver for C_POS - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_POSMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_POSInput.Table_Name;
	}

	public MPOS C_POSSave(I_C_POSInput input, DataFetchingEnvironment environment) {
		return (MPOS) super.save((X_C_POSInput) input, environment);
	}

	public boolean C_POSDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
