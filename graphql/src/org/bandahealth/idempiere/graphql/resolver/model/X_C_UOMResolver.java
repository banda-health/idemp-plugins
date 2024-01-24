package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_UOM_TrlDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MUOM;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_UOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_UOMResolver extends POResolver<MUOM> implements GraphQLResolver<MUOM> {


	/**
	 * Get Description.
	 *
	 * @return Optional short description of the record
	 */
	public CompletableFuture<String> Description(MUOM entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDescription);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_UOM_TrlDataLoader.DATALOADER_C_UOM_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MUOM.COLUMNNAME_Description));
	}

	public Boolean IsDefault(MUOM entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(MUOM entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_UOM_TrlDataLoader.DATALOADER_C_UOM_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MUOM.COLUMNNAME_Name));
	}

	/**
	 * Get Symbol.
	 *
	 * @return Symbol for a Unit of Measure
	 */
	public CompletableFuture<String> UOMSymbol(MUOM entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getUOMSymbol);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_UOM_TrlDataLoader.DATALOADER_C_UOM_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MUOM.COLUMNNAME_UOMSymbol));
	}

	static Map<String, String> UOMTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("AN", "b1ff658e-fce9-4252-90ae-f0f6ffea004a");
			put("AR", "32c39792-e142-4284-b00a-443fb483c7f7");
			put("DS", "8234c15c-6d60-47af-8bf4-ae6651e419ba");
			put("DE", "deb98ce0-81ee-4fee-8cc8-8a915eaa0516");
			put("EN", "0a6b0dee-b828-4860-85ff-68d4f1f81331");
			put("FO", "0d43a385-5e4b-4100-9753-189450bc6ee8");
			put("KI", "48da2d62-4d66-4b94-b491-81783a6ac7b5");
			put("LE", "9b13d2b5-a9ab-4c2d-b33a-ce57ee77721c");
			put("PO", "7d361f82-face-4877-beef-c153a1d0f7b9");
			put("PR", "7151e7e7-216e-471b-8e45-3b9220faf393");
			put("TE", "f0ea32ba-8bcc-4d8a-88db-06432e3aa5cd");
			put("TM", "4c96d2b0-5037-4962-a6a8-5897109f9ad9");
			put("TO", "b19ddc60-500c-4498-b529-ed1744c694c3");
			put("VE", "84048aa4-198e-47bd-94df-ffad40d4552f");
			put("VL", "024098a3-b812-441c-ba78-2360076636af");
			put("VD", "6cda5b17-8311-4564-a10d-f0d332b30694");
			put("WE", "03a9be71-49b1-4df9-afd3-7025e6c0b5d2");
			put("CU", "98b9fe93-6dad-4ce9-b8fb-20ad7e510207");
			put("DV", "55a9fca1-5bd3-4a1e-bb35-5b78b27cfc05");
			put("FR", "251febd5-6f0f-447c-b914-ebdbbc1a6372");
			put("OT", "68837114-a565-4c86-b37a-7c4d95346434");
		}
	};
	public CompletableFuture<MRefList_BH> UOMType(MUOM entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getUOMType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(UOMTYPE_UUIDS_BY_VALUE.get(entity.getUOMType()));
	}

}
