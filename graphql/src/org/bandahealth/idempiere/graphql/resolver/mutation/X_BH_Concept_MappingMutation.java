package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHConceptMapping;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Concept_MappingInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Concept_MappingInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Concept_Mapping - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Concept_MappingMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Concept_MappingInput.Table_Name;
	}

	public MBHConceptMapping BH_Concept_MappingSave(I_BH_Concept_MappingInput Entity, DataFetchingEnvironment environment) {
		return (MBHConceptMapping) super.save((X_BH_Concept_MappingInput) Entity, environment);
	}

	public List<MBHConceptMapping> BH_Concept_MappingSaveMany(List<I_BH_Concept_MappingInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Concept_MappingInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHConceptMapping) entity).collect(Collectors.toList());
	}

	public boolean BH_Concept_MappingDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
