package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_DesktopWorkbenchInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_DesktopWorkbenchInput;
import org.compiere.model.X_AD_DesktopWorkbench;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_DesktopWorkbench - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_DesktopWorkbenchMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_DesktopWorkbenchInput.Table_Name;
	}

	public X_AD_DesktopWorkbench AD_DesktopWorkbenchSave(I_AD_DesktopWorkbenchInput entity, DataFetchingEnvironment environment) {
		return (X_AD_DesktopWorkbench) super.save((X_AD_DesktopWorkbenchInput) entity, environment);
	}

	public List<X_AD_DesktopWorkbench> AD_DesktopWorkbenchSaveMany(List<I_AD_DesktopWorkbenchInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_DesktopWorkbenchInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_DesktopWorkbench) entity).collect(Collectors.toList());
	}

	public boolean AD_DesktopWorkbenchDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
