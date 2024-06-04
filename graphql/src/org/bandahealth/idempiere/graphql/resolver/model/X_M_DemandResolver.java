package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CalendarDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_YearDataLoader;
import org.compiere.model.MCalendar;
import org.compiere.model.MYear;
import org.compiere.model.X_M_Demand;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_Demand - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_DemandResolver extends POResolver<X_M_Demand> implements GraphQLResolver<X_M_Demand> {



	/**
	 * Get Calendar.
	 *
	 * @return Accounting Calendar Name
	 */
	public CompletableFuture<MCalendar> C_Calendar(X_M_Demand entity, DataFetchingEnvironment environment) {
		if (entity.getC_Calendar_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MCalendar> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CalendarDataLoader.DATALOADER_C_Calendar_BY_ID);
		return dataLoader.load(entity.getC_Calendar_ID());
	}


	/**
	 * Get Year.
	 *
	 * @return Calendar Year
	 */
	public CompletableFuture<MYear> C_Year(X_M_Demand entity, DataFetchingEnvironment environment) {
		if (entity.getC_Year_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MYear> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_YearDataLoader.DATALOADER_C_Year_BY_ID);
		return dataLoader.load(entity.getC_Year_ID());
	}

	public Boolean IsDefault(X_M_Demand entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}

	public Boolean Processing(X_M_Demand entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
