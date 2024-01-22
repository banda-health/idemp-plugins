package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_QM_SpecificationInput;
import org.bandahealth.idempiere.graphql.model.input.X_QM_SpecificationInput;
import org.eevolution.model.X_QM_Specification;

import java.util.List;

/**
 * Generated Query Resolver for QM_Specification - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_QM_SpecificationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_QM_SpecificationInput.Table_Name;
	}

	public X_QM_Specification QM_SpecificationSave(I_QM_SpecificationInput input, DataFetchingEnvironment environment) {
		return (X_QM_Specification) super.save((X_QM_SpecificationInput) input, environment);
	}

	public boolean QM_SpecificationDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
