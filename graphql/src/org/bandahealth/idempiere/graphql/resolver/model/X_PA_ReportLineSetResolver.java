package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.compiere.report.MReportLineSet;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for PA_ReportLineSet - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PA_ReportLineSetResolver extends POResolver<MReportLineSet> implements GraphQLResolver<MReportLineSet> {


	public Boolean Processing(MReportLineSet entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
