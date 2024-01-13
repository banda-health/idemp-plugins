package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RoleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WorkflowDataLoader;
import org.compiere.model.X_AD_Role;
import org.compiere.model.X_AD_Workflow;
import org.compiere.model.X_AD_Workflow_Access;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Workflow_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Workflow_AccessResolver extends POResolver<X_AD_Workflow_Access> implements GraphQLResolver<X_AD_Workflow_Access> {



	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	public CompletableFuture<X_AD_Role> AD_Role(X_AD_Workflow_Access entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Role_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Role> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RoleDataLoader.DATALOADER_AD_Role_BY_ID);
		return dataLoader.load(entity.getAD_Role_ID());
	}


	/**
	 * Get Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	public CompletableFuture<X_AD_Workflow> AD_Workflow(X_AD_Workflow_Access entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Workflow_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Workflow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WorkflowDataLoader.DATALOADER_AD_Workflow_BY_ID);
		return dataLoader.load(entity.getAD_Workflow_ID());
	}

	public Boolean IsReadWrite(X_AD_Workflow_Access entity, DataFetchingEnvironment environment) {
		return entity.isReadWrite();
	}

}
