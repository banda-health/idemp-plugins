package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_CategoryUpdatesInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_CategoryUpdatesInput;
import org.compiere.model.X_R_CategoryUpdates;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for R_CategoryUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_R_CategoryUpdatesMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_CategoryUpdatesInput.Table_Name;
	}

	public X_R_CategoryUpdates R_CategoryUpdatesSave(I_R_CategoryUpdatesInput Entity, DataFetchingEnvironment environment) {
		return (X_R_CategoryUpdates) super.save((X_R_CategoryUpdatesInput) Entity, environment);
	}

	public List<X_R_CategoryUpdates> R_CategoryUpdatesSaveMany(List<I_R_CategoryUpdatesInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_R_CategoryUpdatesInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_R_CategoryUpdates) entity).collect(Collectors.toList());
	}

	public boolean R_CategoryUpdatesDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
