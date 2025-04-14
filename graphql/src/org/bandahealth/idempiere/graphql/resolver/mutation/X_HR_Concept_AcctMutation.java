package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_HR_Concept_AcctInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_Concept_AcctInput;
import org.eevolution.model.X_HR_Concept_Acct;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for HR_Concept_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_HR_Concept_AcctMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_HR_Concept_AcctInput.Table_Name;
	}

	public X_HR_Concept_Acct HR_Concept_AcctSave(I_HR_Concept_AcctInput Entity, DataFetchingEnvironment environment) {
		return (X_HR_Concept_Acct) super.save((X_HR_Concept_AcctInput) Entity, environment);
	}

	public List<X_HR_Concept_Acct> HR_Concept_AcctSaveMany(List<I_HR_Concept_AcctInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_HR_Concept_AcctInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_HR_Concept_Acct) entity).collect(Collectors.toList());
	}

	public boolean HR_Concept_AcctDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
