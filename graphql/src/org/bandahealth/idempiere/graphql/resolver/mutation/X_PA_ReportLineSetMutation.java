package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_ReportLineSetInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_ReportLineSetInput;
import org.compiere.report.MReportLineSet;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PA_ReportLineSet - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportLineSetMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_ReportLineSetInput.Table_Name;
	}

	public MReportLineSet PA_ReportLineSetSave(I_PA_ReportLineSetInput entity, DataFetchingEnvironment environment) {
		return (MReportLineSet) super.save((X_PA_ReportLineSetInput) entity, environment);
	}

	public List<MReportLineSet> PA_ReportLineSetSaveMany(List<I_PA_ReportLineSetInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_PA_ReportLineSetInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MReportLineSet) entity).collect(Collectors.toList());
	}

	public boolean PA_ReportLineSetDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
