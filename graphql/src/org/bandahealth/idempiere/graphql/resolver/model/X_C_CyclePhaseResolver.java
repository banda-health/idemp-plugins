package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CycleStepDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PhaseDataLoader;
import org.compiere.model.MProjectTypePhase;
import org.compiere.model.X_C_CyclePhase;
import org.compiere.model.X_C_CycleStep;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_CyclePhase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_CyclePhaseResolver extends POResolver<X_C_CyclePhase> implements GraphQLResolver<X_C_CyclePhase> {



	/**
	 * Get Cycle Step.
	 *
	 * @return The step for this Cycle
	 */
	public CompletableFuture<X_C_CycleStep> C_CycleStep(X_C_CyclePhase entity, DataFetchingEnvironment environment) {
		if (entity.getC_CycleStep_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_C_CycleStep> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CycleStepDataLoader.DATALOADER_C_CycleStep_BY_ID);
		return dataLoader.load(entity.getC_CycleStep_ID());
	}


	/**
	 * Get Standard Phase.
	 *
	 * @return Standard Phase of the Project Type
	 */
	public CompletableFuture<MProjectTypePhase> C_Phase(X_C_CyclePhase entity, DataFetchingEnvironment environment) {
		if (entity.getC_Phase_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProjectTypePhase> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PhaseDataLoader.DATALOADER_C_Phase_BY_ID);
		return dataLoader.load(entity.getC_Phase_ID());
	}

}
