package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.compiere.report.MReportColumnSet;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for PA_ReportColumnSet - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PA_ReportColumnSetResolver extends POResolver<MReportColumnSet> implements GraphQLResolver<MReportColumnSet> {


	public Boolean Processing(MReportColumnSet entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
