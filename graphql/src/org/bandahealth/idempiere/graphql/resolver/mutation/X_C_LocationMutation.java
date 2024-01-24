package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_LocationInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_LocationInput;
import org.compiere.model.MLocation;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Location - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_LocationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_LocationInput.Table_Name;
	}

	public MLocation C_LocationSave(I_C_LocationInput entity, DataFetchingEnvironment environment) {
		return (MLocation) super.save((X_C_LocationInput) entity, environment);
	}

	public List<MLocation> C_LocationSaveMany(List<I_C_LocationInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_LocationInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MLocation) entity).collect(Collectors.toList());
	}

	public boolean C_LocationDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
