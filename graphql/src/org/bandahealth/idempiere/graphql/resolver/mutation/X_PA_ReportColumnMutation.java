package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MReportColumn_BH;
import org.bandahealth.idempiere.graphql.model.input.I_PA_ReportColumnInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_ReportColumnInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PA_ReportColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PA_ReportColumnMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_ReportColumnInput.Table_Name;
	}

	public MReportColumn_BH PA_ReportColumnSave(I_PA_ReportColumnInput entity, DataFetchingEnvironment environment) {
		return (MReportColumn_BH) super.save((X_PA_ReportColumnInput) entity, environment);
	}

	public List<MReportColumn_BH> PA_ReportColumnSaveMany(List<I_PA_ReportColumnInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_PA_ReportColumnInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MReportColumn_BH) entity).collect(Collectors.toList());
	}

	public boolean PA_ReportColumnDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
