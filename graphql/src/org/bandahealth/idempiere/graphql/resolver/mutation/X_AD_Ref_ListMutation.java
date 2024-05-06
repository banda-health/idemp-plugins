package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Ref_ListInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Ref_ListInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Ref_List - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Ref_ListMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Ref_ListInput.Table_Name;
	}

	public MRefList_BH AD_Ref_ListSave(I_AD_Ref_ListInput Entity, DataFetchingEnvironment environment) {
		return (MRefList_BH) super.save((X_AD_Ref_ListInput) Entity, environment);
	}

	public List<MRefList_BH> AD_Ref_ListSaveMany(List<I_AD_Ref_ListInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_Ref_ListInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRefList_BH) entity).collect(Collectors.toList());
	}

	public boolean AD_Ref_ListDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
