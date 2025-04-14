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
 * @version Release 13 - $Id$
 */
public class X_M_LocatorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_LocatorInput.Table_Name;
	}

	public MLocator M_LocatorSave(I_M_LocatorInput Entity, DataFetchingEnvironment environment) {
		return (MLocator) super.save((X_M_LocatorInput) Entity, environment);
	}

	public List<MLocator> M_LocatorSaveMany(List<I_M_LocatorInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_LocatorInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MLocator) entity).collect(Collectors.toList());
	}

	public boolean M_LocatorDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
