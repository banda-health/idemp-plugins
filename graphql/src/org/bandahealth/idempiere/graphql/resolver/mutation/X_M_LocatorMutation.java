package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_LocatorInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_LocatorInput;
import org.compiere.model.MLocator;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_Locator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_LocatorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_LocatorInput.Table_Name;
	}

	public MLocator M_LocatorSave(I_M_LocatorInput entity, DataFetchingEnvironment environment) {
		return (MLocator) super.save((X_M_LocatorInput) entity, environment);
	}

	public List<MLocator> M_LocatorSaveMany(List<I_M_LocatorInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_LocatorInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MLocator) entity).collect(Collectors.toList());
	}

	public boolean M_LocatorDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
