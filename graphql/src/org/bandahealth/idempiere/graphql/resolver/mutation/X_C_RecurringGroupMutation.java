package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_RecurringGroupInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_RecurringGroupInput;
import org.compiere.model.X_C_RecurringGroup;

import java.util.List;

/**
 * Generated Query Resolver for C_RecurringGroup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RecurringGroupMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_RecurringGroupInput.Table_Name;
	}

	public X_C_RecurringGroup C_RecurringGroupSave(I_C_RecurringGroupInput input, DataFetchingEnvironment environment) {
		return (X_C_RecurringGroup) super.save((X_C_RecurringGroupInput) input, environment);
	}

	public boolean C_RecurringGroupDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
