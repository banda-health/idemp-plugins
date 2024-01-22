package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_HierarchyInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_HierarchyInput;
import org.compiere.model.MHierarchy;

import java.util.List;

/**
 * Generated Query Resolver for PA_Hierarchy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PA_HierarchyMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_HierarchyInput.Table_Name;
	}

	public MHierarchy PA_HierarchySave(I_PA_HierarchyInput input, DataFetchingEnvironment environment) {
		return (MHierarchy) super.save((X_PA_HierarchyInput) input, environment);
	}

	public boolean PA_HierarchyDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
