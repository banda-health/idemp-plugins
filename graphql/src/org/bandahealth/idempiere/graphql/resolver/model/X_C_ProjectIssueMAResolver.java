package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectIssueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetInstanceDataLoader;
import org.compiere.model.MProjectIssue;
import org.compiere.model.X_C_ProjectIssueMA;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_ProjectIssueMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ProjectIssueMAResolver extends POResolver<X_C_ProjectIssueMA> implements GraphQLResolver<X_C_ProjectIssueMA> {



	/**
	 * Get Project Issue.
	 *
	 * @return Project Issues (Material, Labor)
	 */
	public CompletableFuture<MProjectIssue> C_ProjectIssue(X_C_ProjectIssueMA entity, DataFetchingEnvironment environment) {
		if (entity.getC_ProjectIssue_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MProjectIssue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectIssueDataLoader.DATALOADER_C_ProjectIssue_BY_ID);
		return dataLoader.load(entity.getC_ProjectIssue_ID());
	}


	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public CompletableFuture<MAttributeSetInstance_BH> M_AttributeSetInstance(X_C_ProjectIssueMA entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSetInstance_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSetInstance_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetInstanceDataLoader.DATALOADER_M_AttributeSetInstance_BY_ID);
		return dataLoader.load(entity.getM_AttributeSetInstance_ID());
	}

}
