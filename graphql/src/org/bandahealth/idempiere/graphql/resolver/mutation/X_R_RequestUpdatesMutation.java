package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_RequestUpdatesInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_RequestUpdatesInput;
import org.compiere.model.X_R_RequestUpdates;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for R_RequestUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_R_RequestUpdatesMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_RequestUpdatesInput.Table_Name;
	}

	public X_R_RequestUpdates R_RequestUpdatesSave(I_R_RequestUpdatesInput Entity, DataFetchingEnvironment environment) {
		return (X_R_RequestUpdates) super.save((X_R_RequestUpdatesInput) Entity, environment);
	}

	public List<X_R_RequestUpdates> R_RequestUpdatesSaveMany(List<I_R_RequestUpdatesInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_R_RequestUpdatesInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_R_RequestUpdates) entity).collect(Collectors.toList());
	}

	public boolean R_RequestUpdatesDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
