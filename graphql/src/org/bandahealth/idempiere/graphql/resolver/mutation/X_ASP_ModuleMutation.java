package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_ASP_ModuleInput;
import org.bandahealth.idempiere.graphql.model.input.X_ASP_ModuleInput;
import org.compiere.model.X_ASP_Module;

import java.util.List;

/**
 * Generated Query Resolver for ASP_Module - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_ASP_ModuleMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_ASP_ModuleInput.Table_Name;
	}

	public X_ASP_Module ASP_ModuleSave(I_ASP_ModuleInput input, DataFetchingEnvironment environment) {
		return (X_ASP_Module) super.save((X_ASP_ModuleInput) input, environment);
	}

	public boolean ASP_ModuleDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
