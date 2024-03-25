package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_ASP_WindowInput;
import org.bandahealth.idempiere.graphql.model.input.X_ASP_WindowInput;
import org.compiere.model.X_ASP_Window;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for ASP_Window - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_ASP_WindowMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_ASP_WindowInput.Table_Name;
	}

	public X_ASP_Window ASP_WindowSave(I_ASP_WindowInput entity, DataFetchingEnvironment environment) {
		return (X_ASP_Window) super.save((X_ASP_WindowInput) entity, environment);
	}

	public List<X_ASP_Window> ASP_WindowSaveMany(List<I_ASP_WindowInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_ASP_WindowInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_ASP_Window) entity).collect(Collectors.toList());
	}

	public boolean ASP_WindowDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
