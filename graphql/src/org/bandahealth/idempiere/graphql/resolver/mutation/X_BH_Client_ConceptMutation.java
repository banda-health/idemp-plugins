package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHClientConcept;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Client_ConceptInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Client_ConceptInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Client_Concept - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Client_ConceptMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Client_ConceptInput.Table_Name;
	}

	public MBHClientConcept BH_Client_ConceptSave(I_BH_Client_ConceptInput Entity, DataFetchingEnvironment environment) {
		return (MBHClientConcept) super.save((X_BH_Client_ConceptInput) Entity, environment);
	}

	public List<MBHClientConcept> BH_Client_ConceptSaveMany(List<I_BH_Client_ConceptInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Client_ConceptInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHClientConcept) entity).collect(Collectors.toList());
	}

	public boolean BH_Client_ConceptDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
