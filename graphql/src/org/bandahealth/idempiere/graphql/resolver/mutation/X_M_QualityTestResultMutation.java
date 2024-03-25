package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_QualityTestResultInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_QualityTestResultInput;
import org.compiere.model.MQualityTestResult;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_QualityTestResult - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_QualityTestResultMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_QualityTestResultInput.Table_Name;
	}

	public MQualityTestResult M_QualityTestResultSave(I_M_QualityTestResultInput entity, DataFetchingEnvironment environment) {
		return (MQualityTestResult) super.save((X_M_QualityTestResultInput) entity, environment);
	}

	public List<MQualityTestResult> M_QualityTestResultSaveMany(List<I_M_QualityTestResultInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_QualityTestResultInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MQualityTestResult) entity).collect(Collectors.toList());
	}

	public boolean M_QualityTestResultDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
