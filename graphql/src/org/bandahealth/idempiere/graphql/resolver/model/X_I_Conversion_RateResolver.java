package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ConversionTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_Conversion_RateDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.compiere.model.MConversionRate;
import org.compiere.model.MConversionType;
import org.compiere.model.X_I_Conversion_Rate;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for I_Conversion_Rate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_I_Conversion_RateResolver extends POResolver<X_I_Conversion_Rate> implements GraphQLResolver<X_I_Conversion_Rate> {



	/**
	 * Get Conversion Rate.
	 *
	 * @return Rate used for converting currencies
	 */
	public CompletableFuture<MConversionRate> C_Conversion_Rate(X_I_Conversion_Rate entity, DataFetchingEnvironment environment) {
		if (entity.getC_Conversion_Rate_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MConversionRate> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_Conversion_RateDataLoader.DATALOADER_C_Conversion_Rate_BY_ID);
		return dataLoader.load(entity.getC_Conversion_Rate_ID());
	}


	/**
	 * Get Currency Type.
	 *
	 * @return Currency Conversion Rate Type
	 */
	public CompletableFuture<MConversionType> C_ConversionType(X_I_Conversion_Rate entity, DataFetchingEnvironment environment) {
		if (entity.getC_ConversionType_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MConversionType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ConversionTypeDataLoader.DATALOADER_C_ConversionType_BY_ID);
		return dataLoader.load(entity.getC_ConversionType_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(X_I_Conversion_Rate entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get Currency To.
	 *
	 * @return Target currency
	 */
	public CompletableFuture<MCurrency_BH> C_Currency_To(X_I_Conversion_Rate entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID_To() < 1) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID_To());
	}

	public Boolean CreateReciprocalRate(X_I_Conversion_Rate entity, DataFetchingEnvironment environment) {
		return entity.isCreateReciprocalRate();
	}

	public Boolean I_IsImported(X_I_Conversion_Rate entity, DataFetchingEnvironment environment) {
		return entity.isI_IsImported();
	}

	public Boolean Processed(X_I_Conversion_Rate entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(X_I_Conversion_Rate entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
