package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_GL_CategoryInput;
import org.bandahealth.idempiere.graphql.model.input.X_GL_CategoryInput;
import org.compiere.model.MGLCategory;

import java.util.List;

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

	public MGLCategory GL_CategorySave(I_GL_CategoryInput input, DataFetchingEnvironment environment) {
		return (MGLCategory) super.save((X_GL_CategoryInput) input, environment);
	}

	public boolean GL_CategoryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
