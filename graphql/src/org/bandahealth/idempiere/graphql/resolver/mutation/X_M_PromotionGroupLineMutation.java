package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_PromotionGroupLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_PromotionGroupLineInput;
import org.compiere.model.X_M_PromotionGroupLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_PromotionGroupLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_PromotionGroupLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_PromotionGroupLineInput.Table_Name;
	}

	public X_M_PromotionGroupLine M_PromotionGroupLineSave(I_M_PromotionGroupLineInput Entity, DataFetchingEnvironment environment) {
		return (X_M_PromotionGroupLine) super.save((X_M_PromotionGroupLineInput) Entity, environment);
	}

	public List<X_M_PromotionGroupLine> M_PromotionGroupLineSaveMany(List<I_M_PromotionGroupLineInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_PromotionGroupLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_M_PromotionGroupLine) entity).collect(Collectors.toList());
	}

	public boolean M_PromotionGroupLineDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
