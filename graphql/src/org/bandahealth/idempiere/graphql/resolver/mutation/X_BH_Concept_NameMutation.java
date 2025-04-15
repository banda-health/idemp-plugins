package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHConceptName;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Concept_NameInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Concept_NameInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Concept_Name - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_BH_Concept_NameMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Concept_NameInput.Table_Name;
	}

	public MBHConceptName BH_Concept_NameSave(I_BH_Concept_NameInput Entity, DataFetchingEnvironment environment) {
		return (MBHConceptName) super.save((X_BH_Concept_NameInput) Entity, environment);
	}

	public List<MBHConceptName> BH_Concept_NameSaveMany(List<I_BH_Concept_NameInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Concept_NameInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHConceptName) entity).collect(Collectors.toList());
	}

	public boolean BH_Concept_NameDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
