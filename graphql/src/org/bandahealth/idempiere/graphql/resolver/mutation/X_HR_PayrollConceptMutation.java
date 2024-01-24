package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_HR_PayrollConceptInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_PayrollConceptInput;
import org.eevolution.model.X_HR_PayrollConcept;

import java.util.List;

/**
 * Generated Query Resolver for HR_PayrollConcept - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_HR_PayrollConceptMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_HR_PayrollConceptInput.Table_Name;
	}

	public X_HR_PayrollConcept HR_PayrollConceptSave(I_HR_PayrollConceptInput input, DataFetchingEnvironment environment) {
		return (X_HR_PayrollConcept) super.save((X_HR_PayrollConceptInput) input, environment);
	}

	public boolean HR_PayrollConceptDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
