package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_MigrationScriptInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_MigrationScriptInput;
import org.compiere.model.X_AD_MigrationScript;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_MigrationScript - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_MigrationScriptMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_MigrationScriptInput.Table_Name;
	}

	public X_AD_MigrationScript AD_MigrationScriptSave(I_AD_MigrationScriptInput entity, DataFetchingEnvironment environment) {
		return (X_AD_MigrationScript) super.save((X_AD_MigrationScriptInput) entity, environment);
	}

	public List<X_AD_MigrationScript> AD_MigrationScriptSaveMany(List<I_AD_MigrationScriptInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_MigrationScriptInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_MigrationScript) entity).collect(Collectors.toList());
	}

	public boolean AD_MigrationScriptDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
