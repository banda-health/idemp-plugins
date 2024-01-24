package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_YearDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_PayrollDataLoader;
import org.compiere.model.MYear;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_Payroll;
import org.eevolution.model.X_HR_Year;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for HR_Year - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_YearResolver extends POResolver<X_HR_Year> implements GraphQLResolver<X_HR_Year> {



	/**
	 * Get Year.
	 *
	 * @return Calendar Year
	 */
	public CompletableFuture<MYear> C_Year(X_HR_Year entity, DataFetchingEnvironment environment) {
		if (entity.getC_Year_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MYear> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_YearDataLoader.DATALOADER_C_Year_BY_ID);
		return dataLoader.load(entity.getC_Year_ID());
	}


	/**
	 * Get Payroll.
	 *
	 * @return Payroll
	 */
	public CompletableFuture<X_HR_Payroll> HR_Payroll(X_HR_Year entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Payroll_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_HR_Payroll> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_PayrollDataLoader.DATALOADER_HR_Payroll_BY_ID);
		return dataLoader.load(entity.getHR_Payroll_ID());
	}

	public Boolean Processed(X_HR_Year entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(X_HR_Year entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
