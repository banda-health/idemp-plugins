package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHConceptDescription;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Concept_DescriptionInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Concept_DescriptionInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Concept_Description - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Concept_DescriptionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Concept_DescriptionInput.Table_Name;
	}

	public MBHConceptDescription BH_Concept_DescriptionSave(I_BH_Concept_DescriptionInput Entity, DataFetchingEnvironment environment) {
		return (MBHConceptDescription) super.save((X_BH_Concept_DescriptionInput) Entity, environment);
	}

	public List<MBHConceptDescription> BH_Concept_DescriptionSaveMany(List<I_BH_Concept_DescriptionInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Concept_DescriptionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHConceptDescription) entity).collect(Collectors.toList());
	}

	public boolean BH_Concept_DescriptionDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
