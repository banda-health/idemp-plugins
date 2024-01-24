package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_HR_Concept_AcctInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_Concept_AcctInput;
import org.eevolution.model.X_HR_Concept_Acct;

import java.util.List;

/**
 * Generated Query Resolver for HR_Concept_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_HR_Concept_AcctMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_HR_Concept_AcctInput.Table_Name;
	}

	public X_HR_Concept_Acct HR_Concept_AcctSave(I_HR_Concept_AcctInput input, DataFetchingEnvironment environment) {
		return (X_HR_Concept_Acct) super.save((X_HR_Concept_AcctInput) input, environment);
	}

	public boolean HR_Concept_AcctDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
