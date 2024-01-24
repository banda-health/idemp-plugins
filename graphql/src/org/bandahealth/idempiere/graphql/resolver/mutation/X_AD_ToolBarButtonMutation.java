package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ToolBarButtonInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ToolBarButtonInput;
import org.compiere.model.MToolBarButton;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_ToolBarButton - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ToolBarButtonMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ToolBarButtonInput.Table_Name;
	}

	public MToolBarButton AD_ToolBarButtonSave(I_AD_ToolBarButtonInput entity, DataFetchingEnvironment environment) {
		return (MToolBarButton) super.save((X_AD_ToolBarButtonInput) entity, environment);
	}

	public List<MToolBarButton> AD_ToolBarButtonSaveMany(List<I_AD_ToolBarButtonInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_ToolBarButtonInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MToolBarButton) entity).collect(Collectors.toList());
	}

	public boolean AD_ToolBarButtonDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
