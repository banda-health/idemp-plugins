package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WorkflowDataLoader;
import org.compiere.model.X_AD_WF_Block;
import org.compiere.model.X_AD_Workflow;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for AD_WF_Block - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_BlockResolver extends POResolver<X_AD_WF_Block> implements GraphQLResolver<X_AD_WF_Block> {



	/**
	 * Get Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	public CompletableFuture<X_AD_Workflow> AD_Workflow(X_AD_WF_Block entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Workflow_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Workflow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WorkflowDataLoader.AD_Workflow_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Workflow_ID());
	}

}
