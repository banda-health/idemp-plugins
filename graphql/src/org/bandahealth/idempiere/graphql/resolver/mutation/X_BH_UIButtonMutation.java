package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUIButton;
import org.bandahealth.idempiere.graphql.model.input.I_BH_UIButtonInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_UIButtonInput;

import java.util.List;

/**
 * Generated Query Resolver for BH_UIButton - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_UIButtonMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_UIButtonInput.Table_Name;
	}

	public MUIButton BH_UIButtonSave(I_BH_UIButtonInput input, DataFetchingEnvironment environment) {
		return (MUIButton) super.save((X_BH_UIButtonInput) input, environment);
	}

	public boolean BH_UIButtonDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
