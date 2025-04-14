package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ReportViewInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ReportViewInput;
import org.compiere.model.MReportView;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_ReportView - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ReportViewMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ReportViewInput.Table_Name;
	}

	public MReportView AD_ReportViewSave(I_AD_ReportViewInput Entity, DataFetchingEnvironment environment) {
		return (MReportView) super.save((X_AD_ReportViewInput) Entity, environment);
	}

	public List<MReportView> AD_ReportViewSaveMany(List<I_AD_ReportViewInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_ReportViewInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MReportView) entity).collect(Collectors.toList());
	}

	public boolean AD_ReportViewDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
