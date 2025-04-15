package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_RequestTypeUpdatesInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_RequestTypeUpdatesInput;
import org.compiere.model.X_R_RequestTypeUpdates;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for R_RequestTypeUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_R_RequestTypeUpdatesMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_RequestTypeUpdatesInput.Table_Name;
	}

	public X_R_RequestTypeUpdates R_RequestTypeUpdatesSave(I_R_RequestTypeUpdatesInput Entity, DataFetchingEnvironment environment) {
		return (X_R_RequestTypeUpdates) super.save((X_R_RequestTypeUpdatesInput) Entity, environment);
	}

	public List<X_R_RequestTypeUpdates> R_RequestTypeUpdatesSaveMany(List<I_R_RequestTypeUpdatesInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_R_RequestTypeUpdatesInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_R_RequestTypeUpdates) entity).collect(Collectors.toList());
	}

	public boolean R_RequestTypeUpdatesDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
