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
 * @version Release 13 - $Id$
 */
public class X_AD_InfoWindowMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_InfoWindowInput.Table_Name;
	}

	public MInfoWindow AD_InfoWindowSave(I_AD_InfoWindowInput Entity, DataFetchingEnvironment environment) {
		return (MInfoWindow) super.save((X_AD_InfoWindowInput) Entity, environment);
	}

	public List<MInfoWindow> AD_InfoWindowSaveMany(List<I_AD_InfoWindowInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_InfoWindowInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MInfoWindow) entity).collect(Collectors.toList());
	}

	public boolean AD_InfoWindowDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
