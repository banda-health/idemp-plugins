package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_ReportInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_ReportInput;
import org.compiere.report.MReport;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PA_Report - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_ReportMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_ReportInput.Table_Name;
	}

	public MReport PA_ReportSave(I_PA_ReportInput Entity, DataFetchingEnvironment environment) {
		return (MReport) super.save((X_PA_ReportInput) Entity, environment);
	}

	public List<MReport> PA_ReportSaveMany(List<I_PA_ReportInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_PA_ReportInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MReport) entity).collect(Collectors.toList());
	}

	public boolean PA_ReportDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
