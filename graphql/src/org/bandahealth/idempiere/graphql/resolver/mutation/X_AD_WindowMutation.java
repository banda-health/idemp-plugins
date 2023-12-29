package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_WindowInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_WindowInput;
import org.compiere.model.MWindow;

import java.util.List;

/**
 * Generated Query Resolver for AD_Window - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WindowMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_WindowInput.Table_Name;
	}

	public MWindow AD_WindowSave(I_AD_WindowInput input, DataFetchingEnvironment environment) {
		return (MWindow) super.save((X_AD_WindowInput) input, environment);
	}

	public boolean AD_WindowDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
