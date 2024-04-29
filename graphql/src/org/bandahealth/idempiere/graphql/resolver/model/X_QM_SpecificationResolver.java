package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WorkflowDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Product_BOMDataLoader;
import org.compiere.model.X_AD_Workflow;
import org.dataloader.DataLoader;
import org.eevolution.model.MPPProductBOM;
import org.eevolution.model.X_QM_Specification;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for QM_Specification - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_QM_SpecificationResolver extends POResolver<X_QM_Specification> implements GraphQLResolver<X_QM_Specification> {



	/**
	 * Get Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	public CompletableFuture<X_AD_Workflow> AD_Workflow(X_QM_Specification entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Workflow_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Workflow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WorkflowDataLoader.DATALOADER_AD_Workflow_BY_ID);
		return dataLoader.load(entity.getAD_Workflow_ID());
	}


	/**
	 * Get Attribute Set.
	 *
	 * @return Product Attribute Set
	 */
	public CompletableFuture<MAttributeSet_BH> M_AttributeSet(X_QM_Specification entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSet_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSet_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetDataLoader.DATALOADER_M_AttributeSet_BY_ID);
		return dataLoader.load(entity.getM_AttributeSet_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(X_QM_Specification entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}


	/**
	 * Get BOM & Formula.
	 *
	 * @return BOM & Formula
	 */
	public CompletableFuture<MPPProductBOM> PP_Product_BOM(X_QM_Specification entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Product_BOM_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPPProductBOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_Product_BOMDataLoader.DATALOADER_PP_Product_BOM_BY_ID);
		return dataLoader.load(entity.getPP_Product_BOM_ID());
	}

}
