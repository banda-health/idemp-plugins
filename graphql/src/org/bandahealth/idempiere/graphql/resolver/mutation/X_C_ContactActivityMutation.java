package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ContactActivityInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ContactActivityInput;
import org.compiere.model.X_C_ContactActivity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_ContactActivity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ContactActivityMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ContactActivityInput.Table_Name;
	}

	public X_C_ContactActivity C_ContactActivitySave(I_C_ContactActivityInput entity, DataFetchingEnvironment environment) {
		return (X_C_ContactActivity) super.save((X_C_ContactActivityInput) entity, environment);
	}

	public List<X_C_ContactActivity> C_ContactActivitySaveMany(List<I_C_ContactActivityInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_ContactActivityInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_ContactActivity) entity).collect(Collectors.toList());
	}

	public boolean C_ContactActivityDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
