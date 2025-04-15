package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_ReportColumnSetInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_ReportColumnSetInput;
import org.compiere.report.MReportColumnSet;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PA_ReportColumnSet - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PA_ReportColumnSetMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_ReportColumnSetInput.Table_Name;
	}

	public MReportColumnSet PA_ReportColumnSetSave(I_PA_ReportColumnSetInput Entity, DataFetchingEnvironment environment) {
		return (MReportColumnSet) super.save((X_PA_ReportColumnSetInput) Entity, environment);
	}

	public List<MReportColumnSet> PA_ReportColumnSetSaveMany(List<I_PA_ReportColumnSetInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_PA_ReportColumnSetInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MReportColumnSet) entity).collect(Collectors.toList());
	}

	public boolean PA_ReportColumnSetDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
