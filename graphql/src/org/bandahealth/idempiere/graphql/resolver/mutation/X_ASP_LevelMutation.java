package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_ASP_LevelInput;
import org.bandahealth.idempiere.graphql.model.input.X_ASP_LevelInput;
import org.compiere.model.X_ASP_Level;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for ASP_Level - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_ASP_LevelMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_ASP_LevelInput.Table_Name;
	}

	public X_ASP_Level ASP_LevelSave(I_ASP_LevelInput Entity, DataFetchingEnvironment environment) {
		return (X_ASP_Level) super.save((X_ASP_LevelInput) Entity, environment);
	}

	public List<X_ASP_Level> ASP_LevelSaveMany(List<I_ASP_LevelInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_ASP_LevelInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_ASP_Level) entity).collect(Collectors.toList());
	}

	public boolean ASP_LevelDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
