package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_ReportLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_ReportLineInput;
import org.compiere.report.MReportLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PA_ReportLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_ReportLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_ReportLineInput.Table_Name;
	}

	public MReportLine PA_ReportLineSave(I_PA_ReportLineInput entity, DataFetchingEnvironment environment) {
		return (MReportLine) super.save((X_PA_ReportLineInput) entity, environment);
	}

	public List<MReportLine> PA_ReportLineSaveMany(List<I_PA_ReportLineInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_PA_ReportLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MReportLine) entity).collect(Collectors.toList());
	}

	public boolean PA_ReportLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
