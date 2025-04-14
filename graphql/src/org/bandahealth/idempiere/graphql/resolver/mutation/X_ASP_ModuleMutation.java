package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_ASP_ModuleInput;
import org.bandahealth.idempiere.graphql.model.input.X_ASP_ModuleInput;
import org.compiere.model.X_ASP_Module;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for ASP_Module - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_ASP_ModuleMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_ASP_ModuleInput.Table_Name;
	}

	public X_ASP_Module ASP_ModuleSave(I_ASP_ModuleInput Entity, DataFetchingEnvironment environment) {
		return (X_ASP_Module) super.save((X_ASP_ModuleInput) Entity, environment);
	}

	public List<X_ASP_Module> ASP_ModuleSaveMany(List<I_ASP_ModuleInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_ASP_ModuleInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_ASP_Module) entity).collect(Collectors.toList());
	}

	public boolean ASP_ModuleDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
