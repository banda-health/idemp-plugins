package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_PromotionDistributionInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_PromotionDistributionInput;
import org.compiere.model.X_M_PromotionDistribution;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_PromotionDistribution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_PromotionDistributionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_PromotionDistributionInput.Table_Name;
	}

	public X_M_PromotionDistribution M_PromotionDistributionSave(I_M_PromotionDistributionInput Entity, DataFetchingEnvironment environment) {
		return (X_M_PromotionDistribution) super.save((X_M_PromotionDistributionInput) Entity, environment);
	}

	public List<X_M_PromotionDistribution> M_PromotionDistributionSaveMany(List<I_M_PromotionDistributionInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_PromotionDistributionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_M_PromotionDistribution) entity).collect(Collectors.toList());
	}

	public boolean M_PromotionDistributionDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
