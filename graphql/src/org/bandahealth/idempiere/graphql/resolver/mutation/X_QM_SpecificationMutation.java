package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_QM_SpecificationInput;
import org.bandahealth.idempiere.graphql.model.input.X_QM_SpecificationInput;
import org.eevolution.model.X_QM_Specification;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for QM_Specification - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_QM_SpecificationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_QM_SpecificationInput.Table_Name;
	}

	public X_QM_Specification QM_SpecificationSave(I_QM_SpecificationInput Entity, DataFetchingEnvironment environment) {
		return (X_QM_Specification) super.save((X_QM_SpecificationInput) Entity, environment);
	}

	public List<X_QM_Specification> QM_SpecificationSaveMany(List<I_QM_SpecificationInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_QM_SpecificationInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_QM_Specification) entity).collect(Collectors.toList());
	}

	public boolean QM_SpecificationDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
