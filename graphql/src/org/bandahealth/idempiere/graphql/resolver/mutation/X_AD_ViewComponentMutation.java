package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ViewComponentInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ViewComponentInput;
import org.compiere.model.MViewComponent;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_ViewComponent - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_ViewComponentMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ViewComponentInput.Table_Name;
	}

	public MViewComponent AD_ViewComponentSave(I_AD_ViewComponentInput Entity, DataFetchingEnvironment environment) {
		return (MViewComponent) super.save((X_AD_ViewComponentInput) Entity, environment);
	}

	public List<MViewComponent> AD_ViewComponentSaveMany(List<I_AD_ViewComponentInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_ViewComponentInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MViewComponent) entity).collect(Collectors.toList());
	}

	public boolean AD_ViewComponentDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
