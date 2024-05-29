package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_ConceptDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_MovementDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_ProcessDataLoader;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_Concept;
import org.eevolution.model.X_HR_Movement;
import org.eevolution.model.X_HR_Process;
import org.eevolution.model.X_I_HR_Movement;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for I_HR_Movement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_I_HR_MovementResolver extends POResolver<X_I_HR_Movement> implements GraphQLResolver<X_I_HR_Movement> {



	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(X_I_HR_Movement entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Payroll Concept.
	 *
	 * @return Payroll Concept
	 */
	public CompletableFuture<X_HR_Concept> HR_Concept(X_I_HR_Movement entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Concept_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_HR_Concept> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_ConceptDataLoader.DATALOADER_HR_Concept_BY_ID);
		return dataLoader.load(entity.getHR_Concept_ID());
	}


	/**
	 * Get Payroll Movement.
	 *
	 * @return Payroll Movement
	 */
	public CompletableFuture<X_HR_Movement> HR_Movement(X_I_HR_Movement entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Movement_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_HR_Movement> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_MovementDataLoader.DATALOADER_HR_Movement_BY_ID);
		return dataLoader.load(entity.getHR_Movement_ID());
	}


	/**
	 * Get Payroll Process.
	 *
	 * @return Payroll Process
	 */
	public CompletableFuture<X_HR_Process> HR_Process(X_I_HR_Movement entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Process_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_HR_Process> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_ProcessDataLoader.DATALOADER_HR_Process_BY_ID);
		return dataLoader.load(entity.getHR_Process_ID());
	}

	public Boolean Processed(X_I_HR_Movement entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(X_I_HR_Movement entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
