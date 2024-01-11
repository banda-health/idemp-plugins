package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ToolBarButtonRestrictInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ToolBarButtonRestrictInput;
import org.compiere.model.MToolBarButtonRestrict;

import java.util.List;

/**
 * Generated Query Resolver for AD_ToolBarButtonRestrict - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ToolBarButtonRestrictMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ToolBarButtonRestrictInput.Table_Name;
	}

	public MToolBarButtonRestrict AD_ToolBarButtonRestrictSave(I_AD_ToolBarButtonRestrictInput input, DataFetchingEnvironment environment) {
		return (MToolBarButtonRestrict) super.save((X_AD_ToolBarButtonRestrictInput) input, environment);
	}

	public boolean AD_ToolBarButtonRestrictDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
