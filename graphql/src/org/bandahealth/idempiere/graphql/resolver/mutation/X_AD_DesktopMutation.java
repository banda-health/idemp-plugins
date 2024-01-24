package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_DesktopInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_DesktopInput;
import org.compiere.model.X_AD_Desktop;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Desktop - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_DesktopMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_DesktopInput.Table_Name;
	}

	public X_AD_Desktop AD_DesktopSave(I_AD_DesktopInput entity, DataFetchingEnvironment environment) {
		return (X_AD_Desktop) super.save((X_AD_DesktopInput) entity, environment);
	}

	public List<X_AD_Desktop> AD_DesktopSaveMany(List<I_AD_DesktopInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_DesktopInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_Desktop) entity).collect(Collectors.toList());
	}

	public boolean AD_DesktopDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
