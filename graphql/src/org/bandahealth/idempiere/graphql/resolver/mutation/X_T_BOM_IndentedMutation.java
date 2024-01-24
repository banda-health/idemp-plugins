package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_T_BOM_IndentedInput;
import org.bandahealth.idempiere.graphql.model.input.X_T_BOM_IndentedInput;
import org.compiere.model.X_T_BOM_Indented;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for T_BOM_Indented - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_BOM_IndentedMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_T_BOM_IndentedInput.Table_Name;
	}

	public X_T_BOM_Indented T_BOM_IndentedSave(I_T_BOM_IndentedInput entity, DataFetchingEnvironment environment) {
		return (X_T_BOM_Indented) super.save((X_T_BOM_IndentedInput) entity, environment);
	}

	public List<X_T_BOM_Indented> T_BOM_IndentedSaveMany(List<I_T_BOM_IndentedInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_T_BOM_IndentedInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_T_BOM_Indented) entity).collect(Collectors.toList());
	}

	public boolean T_BOM_IndentedDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
