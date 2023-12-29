package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PhaseDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MProject;
import org.compiere.model.MProjectPhase;
import org.compiere.model.MProjectTypePhase;
import org.compiere.model.MRefList;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_ProjectPhase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ProjectPhaseResolver extends POResolver<MProjectPhase> implements GraphQLResolver<MProjectPhase> {



	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	public CompletableFuture<MOrder_BH> C_Order(MProjectPhase entity, DataFetchingEnvironment environment) {
		if (entity.getC_Order_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MOrder_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderDataLoader.C_Order_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Order_ID());
	}


	/**
	 * Get Standard Phase.
	 *
	 * @return Standard Phase of the Project Type
	 */
	public CompletableFuture<MProjectTypePhase> C_Phase(MProjectPhase entity, DataFetchingEnvironment environment) {
		if (entity.getC_Phase_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProjectTypePhase> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PhaseDataLoader.C_Phase_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Phase_ID());
	}


	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public CompletableFuture<MProject> C_Project(MProjectPhase entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProject> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectDataLoader.C_Project_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Project_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MProjectPhase entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.M_Product_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Product_ID());
	}

	static Map<String, String> PROJINVOICERULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("-", "b2c13436-dfd4-4b95-a0fe-a0429485d425");
			put("C", "4311a616-dbf6-4e2a-bc9b-a7726e4f075c");
			put("c", "e9bbae09-f9ce-4dfd-a9d6-487109574052");
			put("T", "f724e224-f0fb-4575-94ae-b4aa8e6c8c54");
			put("P", "c6d2fa2b-6f89-41b1-9e53-db77217d3ff1");
		}
	};
	public CompletableFuture<MRefList> ProjInvoiceRule_RL(MProjectPhase entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getProjInvoiceRule())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(PROJINVOICERULE_UUIDS_BY_VALUE.get(entity.getProjInvoiceRule()));
	}

}
