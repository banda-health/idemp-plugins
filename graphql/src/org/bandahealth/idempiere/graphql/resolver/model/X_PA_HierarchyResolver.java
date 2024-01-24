package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MTree_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TreeDataLoader;
import org.compiere.model.MHierarchy;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PA_Hierarchy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PA_HierarchyResolver extends POResolver<MHierarchy> implements GraphQLResolver<MHierarchy> {



	/**
	 * Get Account Tree.
	 *
	 * @return Tree for Natural Account Tree
	 */
	public CompletableFuture<MTree_BH> AD_Tree_Account(MHierarchy entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tree_Account_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTree_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TreeDataLoader.DATALOADER_AD_Tree_BY_ID);
		return dataLoader.load(entity.getAD_Tree_Account_ID());
	}


	/**
	 * Get Activity Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	public CompletableFuture<MTree_BH> AD_Tree_Activity(MHierarchy entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tree_Activity_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTree_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TreeDataLoader.DATALOADER_AD_Tree_BY_ID);
		return dataLoader.load(entity.getAD_Tree_Activity_ID());
	}


	/**
	 * Get BPartner Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	public CompletableFuture<MTree_BH> AD_Tree_BPartner(MHierarchy entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tree_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTree_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TreeDataLoader.DATALOADER_AD_Tree_BY_ID);
		return dataLoader.load(entity.getAD_Tree_BPartner_ID());
	}


	/**
	 * Get Campaign Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	public CompletableFuture<MTree_BH> AD_Tree_Campaign(MHierarchy entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tree_Campaign_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTree_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TreeDataLoader.DATALOADER_AD_Tree_BY_ID);
		return dataLoader.load(entity.getAD_Tree_Campaign_ID());
	}


	/**
	 * Get Organization Tree.
	 *
	 * @return Trees are used for (financial) reporting and security access (via role)
	 */
	public CompletableFuture<MTree_BH> AD_Tree_Org(MHierarchy entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tree_Org_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTree_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TreeDataLoader.DATALOADER_AD_Tree_BY_ID);
		return dataLoader.load(entity.getAD_Tree_Org_ID());
	}


	/**
	 * Get Product Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	public CompletableFuture<MTree_BH> AD_Tree_Product(MHierarchy entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tree_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTree_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TreeDataLoader.DATALOADER_AD_Tree_BY_ID);
		return dataLoader.load(entity.getAD_Tree_Product_ID());
	}


	/**
	 * Get Project Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	public CompletableFuture<MTree_BH> AD_Tree_Project(MHierarchy entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tree_Project_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTree_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TreeDataLoader.DATALOADER_AD_Tree_BY_ID);
		return dataLoader.load(entity.getAD_Tree_Project_ID());
	}


	/**
	 * Get Sales Region Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	public CompletableFuture<MTree_BH> AD_Tree_SalesRegion(MHierarchy entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tree_SalesRegion_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTree_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TreeDataLoader.DATALOADER_AD_Tree_BY_ID);
		return dataLoader.load(entity.getAD_Tree_SalesRegion_ID());
	}

}
