package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_PromotionGroupLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_PromotionGroupLineInput;
import org.compiere.model.X_M_PromotionGroupLine;

import java.util.List;

/**
 * Generated Query Resolver for M_PromotionGroupLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_PromotionGroupLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_PromotionGroupLineInput.Table_Name;
	}

	public X_M_PromotionGroupLine M_PromotionGroupLineSave(I_M_PromotionGroupLineInput input, DataFetchingEnvironment environment) {
		return (X_M_PromotionGroupLine) super.save((X_M_PromotionGroupLineInput) input, environment);
	}

	public boolean M_PromotionGroupLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
