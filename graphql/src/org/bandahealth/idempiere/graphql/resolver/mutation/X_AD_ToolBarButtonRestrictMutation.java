package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ToolBarButtonRestrictInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ToolBarButtonRestrictInput;
import org.compiere.model.MToolBarButtonRestrict;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_ToolBarButtonRestrict - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ToolBarButtonRestrictMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ToolBarButtonRestrictInput.Table_Name;
	}

	public MToolBarButtonRestrict AD_ToolBarButtonRestrictSave(I_AD_ToolBarButtonRestrictInput Entity, DataFetchingEnvironment environment) {
		return (MToolBarButtonRestrict) super.save((X_AD_ToolBarButtonRestrictInput) Entity, environment);
	}

	public List<MToolBarButtonRestrict> AD_ToolBarButtonRestrictSaveMany(List<I_AD_ToolBarButtonRestrictInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_ToolBarButtonRestrictInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MToolBarButtonRestrict) entity).collect(Collectors.toList());
	}

	public boolean AD_ToolBarButtonRestrictDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
