package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_PromotionGroupInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_PromotionGroupInput;
import org.compiere.model.X_M_PromotionGroup;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_PromotionGroup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PromotionGroupMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_PromotionGroupInput.Table_Name;
	}

	public X_M_PromotionGroup M_PromotionGroupSave(I_M_PromotionGroupInput entity, DataFetchingEnvironment environment) {
		return (X_M_PromotionGroup) super.save((X_M_PromotionGroupInput) entity, environment);
	}

	public List<X_M_PromotionGroup> M_PromotionGroupSaveMany(List<I_M_PromotionGroupInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_PromotionGroupInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_M_PromotionGroup) entity).collect(Collectors.toList());
	}

	public boolean M_PromotionGroupDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
