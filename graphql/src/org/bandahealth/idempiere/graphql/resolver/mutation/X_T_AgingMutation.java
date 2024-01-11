package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_T_AgingInput;
import org.bandahealth.idempiere.graphql.model.input.X_T_AgingInput;
import org.compiere.model.MAging;

import java.util.List;

/**
 * Generated Query Resolver for T_Aging - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_AgingMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_T_AgingInput.Table_Name;
	}

	public MAging T_AgingSave(I_T_AgingInput input, DataFetchingEnvironment environment) {
		return (MAging) super.save((X_T_AgingInput) input, environment);
	}

	public boolean T_AgingDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
