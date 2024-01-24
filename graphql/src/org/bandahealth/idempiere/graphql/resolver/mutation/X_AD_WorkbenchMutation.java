package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_WorkbenchInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_WorkbenchInput;
import org.compiere.model.X_AD_Workbench;

import java.util.List;

/**
 * Generated Query Resolver for AD_Workbench - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_WorkbenchMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_WorkbenchInput.Table_Name;
	}

	public X_AD_Workbench AD_WorkbenchSave(I_AD_WorkbenchInput input, DataFetchingEnvironment environment) {
		return (X_AD_Workbench) super.save((X_AD_WorkbenchInput) input, environment);
	}

	public boolean AD_WorkbenchDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
