package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CalendarDataLoader;
import org.compiere.model.MCalendar;
import org.compiere.model.MReportCube;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for PA_ReportCube - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportCubeResolver extends POResolver<MReportCube> implements GraphQLResolver<MReportCube> {



	/**
	 * Get Calendar.
	 *
	 * @return Accounting Calendar Name
	 */
	public CompletableFuture<MCalendar> C_Calendar(MReportCube entity, DataFetchingEnvironment environment) {
		if (entity.getC_Calendar_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCalendar> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CalendarDataLoader.C_Calendar_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Calendar_ID());
	}

}
