package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ViewComponentInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ViewComponentInput;
import org.compiere.model.MViewComponent;

import java.util.List;

/**
 * Generated Query Resolver for AD_ViewComponent - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ViewComponentMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ViewComponentInput.Table_Name;
	}

	public MViewComponent AD_ViewComponentSave(I_AD_ViewComponentInput input, DataFetchingEnvironment environment) {
		return (MViewComponent) super.save((X_AD_ViewComponentInput) input, environment);
	}

	public boolean AD_ViewComponentDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
