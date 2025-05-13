package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHAllergyReaction;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Allergy_ReactionInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Allergy_ReactionInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Allergy_Reaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Allergy_ReactionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Allergy_ReactionInput.Table_Name;
	}

	public MBHAllergyReaction BH_Allergy_ReactionSave(I_BH_Allergy_ReactionInput Entity, DataFetchingEnvironment environment) {
		return (MBHAllergyReaction) super.save((X_BH_Allergy_ReactionInput) Entity, environment);
	}

	public List<MBHAllergyReaction> BH_Allergy_ReactionSaveMany(List<I_BH_Allergy_ReactionInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Allergy_ReactionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHAllergyReaction) entity).collect(Collectors.toList());
	}

	public boolean BH_Allergy_ReactionDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
