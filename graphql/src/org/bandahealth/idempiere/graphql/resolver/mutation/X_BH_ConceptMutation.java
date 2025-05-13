package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.graphql.model.input.I_BH_ConceptInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_ConceptInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Concept - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_ConceptMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_ConceptInput.Table_Name;
	}

	public MBHConcept BH_ConceptSave(I_BH_ConceptInput Entity, DataFetchingEnvironment environment) {
		return (MBHConcept) super.save((X_BH_ConceptInput) Entity, environment);
	}

	public List<MBHConcept> BH_ConceptSaveMany(List<I_BH_ConceptInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_ConceptInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHConcept) entity).collect(Collectors.toList());
	}

	public boolean BH_ConceptDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
