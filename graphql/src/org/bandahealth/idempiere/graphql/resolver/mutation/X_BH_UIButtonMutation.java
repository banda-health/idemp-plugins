package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUIButton;
import org.bandahealth.idempiere.graphql.model.input.I_BH_UIButtonInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_UIButtonInput;

import java.util.List;
import java.util.stream.Collectors;

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

	public MUIButton BH_UIButtonSave(I_BH_UIButtonInput entity, DataFetchingEnvironment environment) {
		return (MUIButton) super.save((X_BH_UIButtonInput) entity, environment);
	}

	public List<MUIButton> BH_UIButtonSaveMany(List<I_BH_UIButtonInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_BH_UIButtonInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MUIButton) entity).collect(Collectors.toList());
	}

	public boolean BH_UIButtonDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
