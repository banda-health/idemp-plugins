package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_POSKeyLayoutInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_POSKeyLayoutInput;
import org.compiere.model.MPOSKeyLayout;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_POSKeyLayout - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_POSKeyLayoutMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_POSKeyLayoutInput.Table_Name;
	}

	public MPOSKeyLayout C_POSKeyLayoutSave(I_C_POSKeyLayoutInput Entity, DataFetchingEnvironment environment) {
		return (MPOSKeyLayout) super.save((X_C_POSKeyLayoutInput) Entity, environment);
	}

	public List<MPOSKeyLayout> C_POSKeyLayoutSaveMany(List<I_C_POSKeyLayoutInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_POSKeyLayoutInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPOSKeyLayout) entity).collect(Collectors.toList());
	}

	public boolean C_POSKeyLayoutDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
