package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RoleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TaskDataLoader;
import org.compiere.model.MTask;
import org.compiere.model.MTaskAccess;
import org.compiere.model.X_AD_Role;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Task_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Task_AccessResolver extends POResolver<MTaskAccess> implements GraphQLResolver<MTaskAccess> {



	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	public CompletableFuture<X_AD_Role> AD_Role(MTaskAccess entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Role_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Role> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RoleDataLoader.DATALOADER_AD_Role_BY_ID);
		return dataLoader.load(entity.getAD_Role_ID());
	}


	/**
	 * Get OS Task.
	 *
	 * @return Operation System Task
	 */
	public CompletableFuture<MTask> AD_Task(MTaskAccess entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Task_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTask> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TaskDataLoader.DATALOADER_AD_Task_BY_ID);
		return dataLoader.load(entity.getAD_Task_ID());
	}

	public Boolean IsReadWrite(MTaskAccess entity, DataFetchingEnvironment environment) {
		return entity.isReadWrite();
	}

}
