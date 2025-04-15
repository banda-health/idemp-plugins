package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_HierarchyInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_HierarchyInput;
import org.compiere.model.MHierarchy;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PA_Hierarchy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PA_HierarchyMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_HierarchyInput.Table_Name;
	}

	public MHierarchy PA_HierarchySave(I_PA_HierarchyInput Entity, DataFetchingEnvironment environment) {
		return (MHierarchy) super.save((X_PA_HierarchyInput) Entity, environment);
	}

	public List<MHierarchy> PA_HierarchySaveMany(List<I_PA_HierarchyInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_PA_HierarchyInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MHierarchy) entity).collect(Collectors.toList());
	}

	public boolean PA_HierarchyDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
