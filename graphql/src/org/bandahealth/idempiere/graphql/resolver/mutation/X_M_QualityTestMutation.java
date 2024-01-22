package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_QualityTestInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_QualityTestInput;
import org.compiere.model.MQualityTest;

import java.util.List;

/**
 * Generated Query Resolver for M_QualityTest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_QualityTestMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_QualityTestInput.Table_Name;
	}

	public MQualityTest M_QualityTestSave(I_M_QualityTestInput input, DataFetchingEnvironment environment) {
		return (MQualityTest) super.save((X_M_QualityTestInput) input, environment);
	}

	public boolean M_QualityTestDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
