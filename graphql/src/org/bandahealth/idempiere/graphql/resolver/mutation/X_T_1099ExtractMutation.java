package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_T_1099ExtractInput;
import org.bandahealth.idempiere.graphql.model.input.X_T_1099ExtractInput;
import org.compiere.model.X_T_1099Extract;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for T_1099Extract - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_T_1099ExtractMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_T_1099ExtractInput.Table_Name;
	}

	public X_T_1099Extract T_1099ExtractSave(I_T_1099ExtractInput entity, DataFetchingEnvironment environment) {
		return (X_T_1099Extract) super.save((X_T_1099ExtractInput) entity, environment);
	}

	public List<X_T_1099Extract> T_1099ExtractSaveMany(List<I_T_1099ExtractInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_T_1099ExtractInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_T_1099Extract) entity).collect(Collectors.toList());
	}

	public boolean T_1099ExtractDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
