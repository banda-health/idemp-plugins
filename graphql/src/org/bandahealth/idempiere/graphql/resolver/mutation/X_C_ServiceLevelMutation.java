package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ServiceLevelInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ServiceLevelInput;
import org.compiere.model.X_C_ServiceLevel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_ServiceLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ServiceLevelMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ServiceLevelInput.Table_Name;
	}

	public X_C_ServiceLevel C_ServiceLevelSave(I_C_ServiceLevelInput entity, DataFetchingEnvironment environment) {
		return (X_C_ServiceLevel) super.save((X_C_ServiceLevelInput) entity, environment);
	}

	public List<X_C_ServiceLevel> C_ServiceLevelSaveMany(List<I_C_ServiceLevelInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_ServiceLevelInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_ServiceLevel) entity).collect(Collectors.toList());
	}

	public boolean C_ServiceLevelDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
