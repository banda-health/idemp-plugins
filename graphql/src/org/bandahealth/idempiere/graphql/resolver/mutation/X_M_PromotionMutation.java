package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_PromotionInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_PromotionInput;
import org.compiere.model.X_M_Promotion;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_Promotion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_PromotionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_PromotionInput.Table_Name;
	}

	public X_M_Promotion M_PromotionSave(I_M_PromotionInput entity, DataFetchingEnvironment environment) {
		return (X_M_Promotion) super.save((X_M_PromotionInput) entity, environment);
	}

	public List<X_M_Promotion> M_PromotionSaveMany(List<I_M_PromotionInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_PromotionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_M_Promotion) entity).collect(Collectors.toList());
	}

	public boolean M_PromotionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
