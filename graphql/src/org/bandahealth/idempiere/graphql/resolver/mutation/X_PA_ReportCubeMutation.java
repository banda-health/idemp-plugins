package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_ReportCubeInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_ReportCubeInput;
import org.compiere.model.MReportCube;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PA_ReportCube - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_ReportCubeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_ReportCubeInput.Table_Name;
	}

	public MReportCube PA_ReportCubeSave(I_PA_ReportCubeInput entity, DataFetchingEnvironment environment) {
		return (MReportCube) super.save((X_PA_ReportCubeInput) entity, environment);
	}

	public List<MReportCube> PA_ReportCubeSaveMany(List<I_PA_ReportCubeInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_PA_ReportCubeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MReportCube) entity).collect(Collectors.toList());
	}

	public boolean PA_ReportCubeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
