package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_StatusCategoryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_StatusDataLoader;
import org.compiere.model.MStatus;
import org.compiere.model.MStatusCategory;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for R_Status - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_StatusResolver extends POResolver<MStatus> implements GraphQLResolver<MStatus> {


	public Boolean IsClosed(MStatus entity, DataFetchingEnvironment environment) {
		return entity.isClosed();
	}

	public Boolean IsDefault(MStatus entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}

	public Boolean IsFinalClose(MStatus entity, DataFetchingEnvironment environment) {
		return entity.isFinalClose();
	}

	public Boolean IsOpen(MStatus entity, DataFetchingEnvironment environment) {
		return entity.isOpen();
	}

	public Boolean IsWebCanUpdate(MStatus entity, DataFetchingEnvironment environment) {
		return entity.isWebCanUpdate();
	}


	/**
	 * Get Next Status.
	 *
	 * @return Move to next status automatically after timeout
	 */
	public CompletableFuture<MStatus> Next_Status(MStatus entity, DataFetchingEnvironment environment) {
		if (entity.getNext_Status_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MStatus> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_StatusDataLoader.DATALOADER_R_Status_BY_ID);
		return dataLoader.load(entity.getNext_Status_ID());
	}


	/**
	 * Get Status Category.
	 *
	 * @return Request Status Category
	 */
	public CompletableFuture<MStatusCategory> R_StatusCategory(MStatus entity, DataFetchingEnvironment environment) {
		if (entity.getR_StatusCategory_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MStatusCategory> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_StatusCategoryDataLoader.DATALOADER_R_StatusCategory_BY_ID);
		return dataLoader.load(entity.getR_StatusCategory_ID());
	}


	/**
	 * Get Update Status.
	 *
	 * @return Automatically change the status after entry from web
	 */
	public CompletableFuture<MStatus> Update_Status(MStatus entity, DataFetchingEnvironment environment) {
		if (entity.getUpdate_Status_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MStatus> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_StatusDataLoader.DATALOADER_R_Status_BY_ID);
		return dataLoader.load(entity.getUpdate_Status_ID());
	}

}
