package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_SearchDefinitionInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_SearchDefinitionInput;
import org.compiere.model.MSearchDefinition;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_SearchDefinition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_SearchDefinitionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_SearchDefinitionInput.Table_Name;
	}

	public MSearchDefinition AD_SearchDefinitionSave(I_AD_SearchDefinitionInput Entity, DataFetchingEnvironment environment) {
		return (MSearchDefinition) super.save((X_AD_SearchDefinitionInput) Entity, environment);
	}

	public List<MSearchDefinition> AD_SearchDefinitionSaveMany(List<I_AD_SearchDefinitionInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_SearchDefinitionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MSearchDefinition) entity).collect(Collectors.toList());
	}

	public boolean AD_SearchDefinitionDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
