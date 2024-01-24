package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_LocatorTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_LocatorTypeInput;
import org.compiere.model.MLocatorType;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_LocatorType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_LocatorTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_LocatorTypeInput.Table_Name;
	}

	public MLocatorType M_LocatorTypeSave(I_M_LocatorTypeInput entity, DataFetchingEnvironment environment) {
		return (MLocatorType) super.save((X_M_LocatorTypeInput) entity, environment);
	}

	public List<MLocatorType> M_LocatorTypeSaveMany(List<I_M_LocatorTypeInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_LocatorTypeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MLocatorType) entity).collect(Collectors.toList());
	}

	public boolean M_LocatorTypeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
