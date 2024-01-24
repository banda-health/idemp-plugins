package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_GL_CategoryInput;
import org.bandahealth.idempiere.graphql.model.input.X_GL_CategoryInput;
import org.compiere.model.MGLCategory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for GL_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_CategoryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_GL_CategoryInput.Table_Name;
	}

	public MGLCategory GL_CategorySave(I_GL_CategoryInput entity, DataFetchingEnvironment environment) {
		return (MGLCategory) super.save((X_GL_CategoryInput) entity, environment);
	}

	public List<MGLCategory> GL_CategorySaveMany(List<I_GL_CategoryInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_GL_CategoryInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MGLCategory) entity).collect(Collectors.toList());
	}

	public boolean GL_CategoryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
