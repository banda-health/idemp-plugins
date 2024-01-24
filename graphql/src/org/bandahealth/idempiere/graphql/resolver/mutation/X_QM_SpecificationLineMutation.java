package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_QM_SpecificationLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_QM_SpecificationLineInput;
import org.eevolution.model.X_QM_SpecificationLine;

import java.util.List;

/**
 * Generated Query Resolver for QM_SpecificationLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_QM_SpecificationLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_QM_SpecificationLineInput.Table_Name;
	}

	public X_QM_SpecificationLine QM_SpecificationLineSave(I_QM_SpecificationLineInput input, DataFetchingEnvironment environment) {
		return (X_QM_SpecificationLine) super.save((X_QM_SpecificationLineInput) input, environment);
	}

	public boolean QM_SpecificationLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
