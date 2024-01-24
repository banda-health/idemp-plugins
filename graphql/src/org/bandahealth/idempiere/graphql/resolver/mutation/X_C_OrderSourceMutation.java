package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_OrderSourceInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_OrderSourceInput;
import org.compiere.model.X_C_OrderSource;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_OrderSource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_OrderSourceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_OrderSourceInput.Table_Name;
	}

	public X_C_OrderSource C_OrderSourceSave(I_C_OrderSourceInput entity, DataFetchingEnvironment environment) {
		return (X_C_OrderSource) super.save((X_C_OrderSourceInput) entity, environment);
	}

	public List<X_C_OrderSource> C_OrderSourceSaveMany(List<I_C_OrderSourceInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_OrderSourceInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_OrderSource) entity).collect(Collectors.toList());
	}

	public boolean C_OrderSourceDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
