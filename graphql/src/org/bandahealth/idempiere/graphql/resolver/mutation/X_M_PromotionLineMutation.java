package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_PromotionLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_PromotionLineInput;
import org.compiere.model.X_M_PromotionLine;

import java.util.List;

/**
 * Generated Query Resolver for M_PromotionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_PromotionLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_PromotionLineInput.Table_Name;
	}

	public X_M_PromotionLine M_PromotionLineSave(I_M_PromotionLineInput input, DataFetchingEnvironment environment) {
		return (X_M_PromotionLine) super.save((X_M_PromotionLineInput) input, environment);
	}

	public boolean M_PromotionLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
