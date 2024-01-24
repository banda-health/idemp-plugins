package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_HR_ListInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_ListInput;
import org.eevolution.model.X_HR_List;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for HR_List - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_ListMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_HR_ListInput.Table_Name;
	}

	public X_HR_List HR_ListSave(I_HR_ListInput entity, DataFetchingEnvironment environment) {
		return (X_HR_List) super.save((X_HR_ListInput) entity, environment);
	}

	public List<X_HR_List> HR_ListSaveMany(List<I_HR_ListInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_HR_ListInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_HR_List) entity).collect(Collectors.toList());
	}

	public boolean HR_ListDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
