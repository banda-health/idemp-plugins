package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_InfoWindowInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_InfoWindowInput;
import org.compiere.model.MInfoWindow;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_InfoWindow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_InfoWindowMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_InfoWindowInput.Table_Name;
	}

	public MInfoWindow AD_InfoWindowSave(I_AD_InfoWindowInput entity, DataFetchingEnvironment environment) {
		return (MInfoWindow) super.save((X_AD_InfoWindowInput) entity, environment);
	}

	public List<MInfoWindow> AD_InfoWindowSaveMany(List<I_AD_InfoWindowInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_InfoWindowInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MInfoWindow) entity).collect(Collectors.toList());
	}

	public boolean AD_InfoWindowDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
