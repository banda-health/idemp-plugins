package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_ASP_TabInput;
import org.bandahealth.idempiere.graphql.model.input.X_ASP_TabInput;
import org.compiere.model.X_ASP_Tab;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for ASP_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_ASP_TabMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_ASP_TabInput.Table_Name;
	}

	public X_ASP_Tab ASP_TabSave(I_ASP_TabInput entity, DataFetchingEnvironment environment) {
		return (X_ASP_Tab) super.save((X_ASP_TabInput) entity, environment);
	}

	public List<X_ASP_Tab> ASP_TabSaveMany(List<I_ASP_TabInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_ASP_TabInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_ASP_Tab) entity).collect(Collectors.toList());
	}

	public boolean ASP_TabDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
