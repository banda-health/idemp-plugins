package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_PromotionDistributionInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_PromotionDistributionInput;
import org.compiere.model.X_M_PromotionDistribution;

import java.util.List;

/**
 * Generated Query Resolver for M_PromotionDistribution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PromotionDistributionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_PromotionDistributionInput.Table_Name;
	}

	public X_M_PromotionDistribution M_PromotionDistributionSave(I_M_PromotionDistributionInput input, DataFetchingEnvironment environment) {
		return (X_M_PromotionDistribution) super.save((X_M_PromotionDistributionInput) input, environment);
	}

	public boolean M_PromotionDistributionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
