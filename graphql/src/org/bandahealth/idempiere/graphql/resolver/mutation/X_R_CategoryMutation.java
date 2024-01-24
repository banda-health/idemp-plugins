package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_CategoryInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_CategoryInput;
import org.compiere.model.MRequestCategory;

import java.util.List;

/**
 * Generated Query Resolver for R_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_CategoryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_CategoryInput.Table_Name;
	}

	public MRequestCategory R_CategorySave(I_R_CategoryInput input, DataFetchingEnvironment environment) {
		return (MRequestCategory) super.save((X_R_CategoryInput) input, environment);
	}

	public boolean R_CategoryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
