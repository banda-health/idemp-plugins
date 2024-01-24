package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_PromotionInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_PromotionInput;
import org.compiere.model.X_M_Promotion;

import java.util.List;

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

	public X_M_Promotion M_PromotionSave(I_M_PromotionInput input, DataFetchingEnvironment environment) {
		return (X_M_Promotion) super.save((X_M_PromotionInput) input, environment);
	}

	public boolean M_PromotionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
