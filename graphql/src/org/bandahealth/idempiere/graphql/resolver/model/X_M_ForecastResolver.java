package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CalendarDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_YearDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PriceListDataLoader;
import org.compiere.model.MCalendar;
import org.compiere.model.MForecast;
import org.compiere.model.MPriceList;
import org.compiere.model.MYear;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_Forecast - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ForecastResolver extends POResolver<MForecast> implements GraphQLResolver<MForecast> {



	/**
	 * Get Calendar.
	 *
	 * @return Accounting Calendar Name
	 */
	public CompletableFuture<MCalendar> C_Calendar(MForecast entity, DataFetchingEnvironment environment) {
		if (entity.getC_Calendar_ID() < 1) {
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
	public CompletableFuture<MYear> C_Year(MForecast entity, DataFetchingEnvironment environment) {
		if (entity.getC_Year_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MYear> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_YearDataLoader.DATALOADER_C_Year_BY_ID);
		return dataLoader.load(entity.getC_Year_ID());
	}

	public Boolean IsDefault(MForecast entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}


	/**
	 * Get Price List.
	 *
	 * @return Unique identifier of a Price List
	 */
	public CompletableFuture<MPriceList> M_PriceList(MForecast entity, DataFetchingEnvironment environment) {
		if (entity.getM_PriceList_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPriceList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PriceListDataLoader.DATALOADER_M_PriceList_BY_ID);
		return dataLoader.load(entity.getM_PriceList_ID());
	}

	public Boolean Processing(MForecast entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
