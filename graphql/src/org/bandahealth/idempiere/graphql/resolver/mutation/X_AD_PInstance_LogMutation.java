package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_PInstance_LogInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_PInstance_LogInput;
import org.compiere.model.X_AD_PInstance_Log;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_PInstance_Log - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PInstance_LogMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_PInstance_LogInput.Table_Name;
	}

	public X_AD_PInstance_Log AD_PInstance_LogSave(I_AD_PInstance_LogInput entity, DataFetchingEnvironment environment) {
		return (X_AD_PInstance_Log) super.save((X_AD_PInstance_LogInput) entity, environment);
	}

	public List<X_AD_PInstance_Log> AD_PInstance_LogSaveMany(List<I_AD_PInstance_LogInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_PInstance_LogInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_PInstance_Log) entity).collect(Collectors.toList());
	}

	public boolean AD_PInstance_LogDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
