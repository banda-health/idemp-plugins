package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_GroupUpdatesInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_GroupUpdatesInput;
import org.compiere.model.X_R_GroupUpdates;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for R_GroupUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_R_GroupUpdatesMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_GroupUpdatesInput.Table_Name;
	}

	public X_R_GroupUpdates R_GroupUpdatesSave(I_R_GroupUpdatesInput Entity, DataFetchingEnvironment environment) {
		return (X_R_GroupUpdates) super.save((X_R_GroupUpdatesInput) Entity, environment);
	}

	public List<X_R_GroupUpdates> R_GroupUpdatesSaveMany(List<I_R_GroupUpdatesInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_R_GroupUpdatesInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_R_GroupUpdates) entity).collect(Collectors.toList());
	}

	public boolean R_GroupUpdatesDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
