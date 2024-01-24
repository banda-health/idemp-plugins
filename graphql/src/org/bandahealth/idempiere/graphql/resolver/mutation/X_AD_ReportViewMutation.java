package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ReportViewInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ReportViewInput;
import org.compiere.model.MReportView;

import java.util.List;

/**
 * Generated Query Resolver for AD_ReportView - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ReportViewMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ReportViewInput.Table_Name;
	}

	public MReportView AD_ReportViewSave(I_AD_ReportViewInput input, DataFetchingEnvironment environment) {
		return (MReportView) super.save((X_AD_ReportViewInput) input, environment);
	}

	public boolean AD_ReportViewDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
