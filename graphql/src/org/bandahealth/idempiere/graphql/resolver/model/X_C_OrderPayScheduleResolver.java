package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PayScheduleDataLoader;
import org.compiere.model.MOrderPaySchedule;
import org.compiere.model.MPaySchedule;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_OrderPaySchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_OrderPayScheduleResolver extends POResolver<MOrderPaySchedule> implements GraphQLResolver<MOrderPaySchedule> {



	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	public CompletableFuture<MOrder_BH> C_Order(MOrderPaySchedule entity, DataFetchingEnvironment environment) {
		if (entity.getC_Order_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MOrder_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderDataLoader.C_Order_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Order_ID());
	}


	/**
	 * Get Payment Schedule.
	 *
	 * @return Payment Schedule Template
	 */
	public CompletableFuture<MPaySchedule> C_PaySchedule(MOrderPaySchedule entity, DataFetchingEnvironment environment) {
		if (entity.getC_PaySchedule_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPaySchedule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PayScheduleDataLoader.C_PaySchedule_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_PaySchedule_ID());
	}

	public Boolean IsValid(MOrderPaySchedule entity, DataFetchingEnvironment environment) {
		return entity.isValid();
	}

	public Boolean Processed(MOrderPaySchedule entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MOrderPaySchedule entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
