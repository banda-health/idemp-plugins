package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_SearchDefinitionInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_SearchDefinitionInput;
import org.compiere.model.MSearchDefinition;

import java.util.List;

/**
 * Generated Query Resolver for AD_SearchDefinition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_SearchDefinitionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_SearchDefinitionInput.Table_Name;
	}

	public MSearchDefinition AD_SearchDefinitionSave(I_AD_SearchDefinitionInput input, DataFetchingEnvironment environment) {
		return (MSearchDefinition) super.save((X_AD_SearchDefinitionInput) input, environment);
	}

	public boolean AD_SearchDefinitionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
