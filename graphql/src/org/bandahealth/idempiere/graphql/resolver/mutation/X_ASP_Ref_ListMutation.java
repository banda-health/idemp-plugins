package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_ASP_Ref_ListInput;
import org.bandahealth.idempiere.graphql.model.input.X_ASP_Ref_ListInput;
import org.compiere.model.X_ASP_Ref_List;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for ASP_Ref_List - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_ASP_Ref_ListMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_ASP_Ref_ListInput.Table_Name;
	}

	public X_ASP_Ref_List ASP_Ref_ListSave(I_ASP_Ref_ListInput entity, DataFetchingEnvironment environment) {
		return (X_ASP_Ref_List) super.save((X_ASP_Ref_ListInput) entity, environment);
	}

	public List<X_ASP_Ref_List> ASP_Ref_ListSaveMany(List<I_ASP_Ref_ListInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_ASP_Ref_ListInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_ASP_Ref_List) entity).collect(Collectors.toList());
	}

	public boolean ASP_Ref_ListDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
