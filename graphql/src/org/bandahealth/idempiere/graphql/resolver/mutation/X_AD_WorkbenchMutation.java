package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_WorkbenchInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_WorkbenchInput;
import org.compiere.model.X_AD_Workbench;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Workbench - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WorkbenchMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_WorkbenchInput.Table_Name;
	}

	public X_AD_Workbench AD_WorkbenchSave(I_AD_WorkbenchInput entity, DataFetchingEnvironment environment) {
		return (X_AD_Workbench) super.save((X_AD_WorkbenchInput) entity, environment);
	}

	public List<X_AD_Workbench> AD_WorkbenchSaveMany(List<I_AD_WorkbenchInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_WorkbenchInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_Workbench) entity).collect(Collectors.toList());
	}

	public boolean AD_WorkbenchDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
