package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_ReportColumnInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_ReportColumnInput;
import org.compiere.report.MReportColumn;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PA_ReportColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_ReportColumnMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_ReportColumnInput.Table_Name;
	}

	public MReportColumn PA_ReportColumnSave(I_PA_ReportColumnInput Entity, DataFetchingEnvironment environment) {
		return (MReportColumn) super.save((X_PA_ReportColumnInput) Entity, environment);
	}

	public List<MReportColumn> PA_ReportColumnSaveMany(List<I_PA_ReportColumnInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_PA_ReportColumnInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MReportColumn) entity).collect(Collectors.toList());
	}

	public boolean PA_ReportColumnDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
