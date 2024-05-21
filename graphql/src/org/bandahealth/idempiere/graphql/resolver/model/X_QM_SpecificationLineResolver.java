package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_QM_SpecificationDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAttribute;
import org.dataloader.DataLoader;
import org.eevolution.model.X_QM_Specification;
import org.eevolution.model.X_QM_SpecificationLine;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for QM_SpecificationLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_QM_SpecificationLineResolver extends POResolver<X_QM_SpecificationLine> implements GraphQLResolver<X_QM_SpecificationLine> {


	static Map<String, String> ANDOR_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "2a20f5be-1d08-4be6-9b94-9835ef8800cb");
			put("O", "67af34aa-ef4f-4928-8536-427c8a6551e4");
		}
	};
	public CompletableFuture<MRefList_BH> AndOr(X_QM_SpecificationLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAndOr())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ANDOR_UUIDS_BY_VALUE.get(entity.getAndOr()));
	}


	/**
	 * Get Attribute.
	 *
	 * @return Product Attribute
	 */
	public CompletableFuture<MAttribute> M_Attribute(X_QM_SpecificationLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_Attribute_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAttribute> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeDataLoader.DATALOADER_M_Attribute_BY_ID);
		return dataLoader.load(entity.getM_Attribute_ID());
	}

	static Map<String, String> OPERATION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("==", "3fefc2d0-9c5a-483c-b34f-00ca51a42bd0");
			put(">=", "c03b77ec-a80e-4628-812d-8f64a493da07");
			put(">>", "9bb7c5a6-b291-4c2c-9524-fa7e974a1160");
			put("<<", "b4ee4ca1-39c6-4703-911b-e107aaca4af6");
			put("~~", "c3b65756-69b3-4f47-a1ba-9161a7dcfc73");
			put("<=", "d68ddcf5-efc3-4208-a583-3b4f40a01bee");
			put("AB", "990ca97f-1278-4171-aa70-0a16770124b5");
			put("SQ", "d07128bf-2e88-42d9-8234-4ee181d35a5b");
			put("!=", "0bb893cb-cdcb-48c7-9c20-c7bb0041a51a");
		}
	};
	public CompletableFuture<MRefList_BH> Operation(X_QM_SpecificationLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getOperation())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(OPERATION_UUIDS_BY_VALUE.get(entity.getOperation()));
	}


	/**
	 * Get Quality Specification.
	 *
	 * @return Quality Specification
	 */
	public CompletableFuture<X_QM_Specification> QM_Specification(X_QM_SpecificationLine entity, DataFetchingEnvironment environment) {
		if (entity.getQM_Specification_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_QM_Specification> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_QM_SpecificationDataLoader.DATALOADER_QM_Specification_BY_ID);
		return dataLoader.load(entity.getQM_Specification_ID());
	}

}
