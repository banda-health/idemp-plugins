package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Ref_ListInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Ref_ListInput;
import org.compiere.model.MRefList;

import java.util.List;

/**
 * Generated Query Resolver for AD_Ref_List - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Ref_ListMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Ref_ListInput.Table_Name;
	}

	public MRefList AD_Ref_ListSave(I_AD_Ref_ListInput input, DataFetchingEnvironment environment) {
		return (MRefList) super.save((X_AD_Ref_ListInput) input, environment);
	}

	public boolean AD_Ref_ListDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
