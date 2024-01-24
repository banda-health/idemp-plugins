package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_RecurringGroupInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_RecurringGroupInput;
import org.compiere.model.X_C_RecurringGroup;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_RecurringGroup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_RecurringGroupMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_RecurringGroupInput.Table_Name;
	}

	public X_C_RecurringGroup C_RecurringGroupSave(I_C_RecurringGroupInput entity, DataFetchingEnvironment environment) {
		return (X_C_RecurringGroup) super.save((X_C_RecurringGroupInput) entity, environment);
	}

	public List<X_C_RecurringGroup> C_RecurringGroupSaveMany(List<I_C_RecurringGroupInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_RecurringGroupInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_RecurringGroup) entity).collect(Collectors.toList());
	}

	public boolean C_RecurringGroupDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
