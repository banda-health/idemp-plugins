package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_HR_ConceptInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_ConceptInput;
import org.eevolution.model.X_HR_Concept;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for HR_Concept - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_HR_ConceptMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_HR_ConceptInput.Table_Name;
	}

	public X_HR_Concept HR_ConceptSave(I_HR_ConceptInput entity, DataFetchingEnvironment environment) {
		return (X_HR_Concept) super.save((X_HR_ConceptInput) entity, environment);
	}

	public List<X_HR_Concept> HR_ConceptSaveMany(List<I_HR_ConceptInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_HR_ConceptInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_HR_Concept) entity).collect(Collectors.toList());
	}

	public boolean HR_ConceptDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
