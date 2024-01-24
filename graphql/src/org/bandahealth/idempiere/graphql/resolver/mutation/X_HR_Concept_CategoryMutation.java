package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_HR_Concept_CategoryInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_Concept_CategoryInput;
import org.eevolution.model.X_HR_Concept_Category;

import java.util.List;

/**
 * Generated Query Resolver for HR_Concept_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_HR_Concept_CategoryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_HR_Concept_CategoryInput.Table_Name;
	}

	public X_HR_Concept_Category HR_Concept_CategorySave(I_HR_Concept_CategoryInput input, DataFetchingEnvironment environment) {
		return (X_HR_Concept_Category) super.save((X_HR_Concept_CategoryInput) input, environment);
	}

	public boolean HR_Concept_CategoryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
