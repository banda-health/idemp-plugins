package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_S_TimeTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_S_TimeTypeInput;
import org.compiere.model.X_S_TimeType;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for S_TimeType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_S_TimeTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_S_TimeTypeInput.Table_Name;
	}

	public X_S_TimeType S_TimeTypeSave(I_S_TimeTypeInput entity, DataFetchingEnvironment environment) {
		return (X_S_TimeType) super.save((X_S_TimeTypeInput) entity, environment);
	}

	public List<X_S_TimeType> S_TimeTypeSaveMany(List<I_S_TimeTypeInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_S_TimeTypeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_S_TimeType) entity).collect(Collectors.toList());
	}

	public boolean S_TimeTypeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
