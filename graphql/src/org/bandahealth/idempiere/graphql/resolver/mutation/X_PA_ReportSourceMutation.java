package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_ReportSourceInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_ReportSourceInput;
import org.compiere.report.MReportSource;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PA_ReportSource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_ReportSourceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_ReportSourceInput.Table_Name;
	}

	public MReportSource PA_ReportSourceSave(I_PA_ReportSourceInput entity, DataFetchingEnvironment environment) {
		return (MReportSource) super.save((X_PA_ReportSourceInput) entity, environment);
	}

	public List<MReportSource> PA_ReportSourceSaveMany(List<I_PA_ReportSourceInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_PA_ReportSourceInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MReportSource) entity).collect(Collectors.toList());
	}

	public boolean PA_ReportSourceDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
