package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RevenueRecog_ServiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RevenueRecognition_PlanDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_JournalDataLoader;
import org.compiere.model.MJournal;
import org.compiere.model.MRevenueRecogService;
import org.compiere.model.MRevenueRecognitionPlan;
import org.compiere.model.MRevenueRecognitionRun;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_RevenueRecognition_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RevenueRecognition_RunResolver extends POResolver<MRevenueRecognitionRun> implements GraphQLResolver<MRevenueRecognitionRun> {



	/**
	 * Get Revenue Recognition Service.
	 *
	 * @return Revenue Recognition Service
	 */
	public CompletableFuture<MRevenueRecogService> C_RevenueRecog_Service(MRevenueRecognitionRun entity, DataFetchingEnvironment environment) {
		if (entity.getC_RevenueRecog_Service_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRevenueRecogService> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RevenueRecog_ServiceDataLoader.C_RevenueRecog_Service_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_RevenueRecog_Service_ID());
	}


	/**
	 * Get Revenue Recognition Plan.
	 *
	 * @return Plan for recognizing or recording revenue
	 */
	public CompletableFuture<MRevenueRecognitionPlan> C_RevenueRecognition_Plan(MRevenueRecognitionRun entity, DataFetchingEnvironment environment) {
		if (entity.getC_RevenueRecognition_Plan_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRevenueRecognitionPlan> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RevenueRecognition_PlanDataLoader.C_RevenueRecognition_Plan_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_RevenueRecognition_Plan_ID());
	}


	/**
	 * Get Journal.
	 *
	 * @return General Ledger Journal
	 */
	public CompletableFuture<MJournal> GL_Journal(MRevenueRecognitionRun entity, DataFetchingEnvironment environment) {
		if (entity.getGL_Journal_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MJournal> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_GL_JournalDataLoader.GL_Journal_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getGL_Journal_ID());
	}

}
