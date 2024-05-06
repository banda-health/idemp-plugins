package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_CategoryInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_CategoryInput;
import org.compiere.model.MRequestCategory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for R_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_CategoryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_CategoryInput.Table_Name;
	}

	public MRequestCategory R_CategorySave(I_R_CategoryInput Entity, DataFetchingEnvironment environment) {
		return (MRequestCategory) super.save((X_R_CategoryInput) Entity, environment);
	}

	public List<MRequestCategory> R_CategorySaveMany(List<I_R_CategoryInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_R_CategoryInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRequestCategory) entity).collect(Collectors.toList());
	}

	public boolean R_CategoryDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
