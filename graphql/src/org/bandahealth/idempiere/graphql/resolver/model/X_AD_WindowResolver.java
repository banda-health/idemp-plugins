package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ColorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ImageDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Window_TrlDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MColor;
import org.compiere.model.MEntityType;
import org.compiere.model.MImage;
import org.compiere.model.MWindow;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Window - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_WindowResolver extends POResolver<MWindow> implements GraphQLResolver<MWindow> {



	/**
	 * Get System Color.
	 *
	 * @return Color for backgrounds or indicators
	 */
	public CompletableFuture<MColor> AD_Color(MWindow entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Color_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MColor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ColorDataLoader.DATALOADER_AD_Color_BY_ID);
		return dataLoader.load(entity.getAD_Color_ID());
	}


	/**
	 * Get Image.
	 *
	 * @return Image or Icon
	 */
	public CompletableFuture<MImage> AD_Image(MWindow entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Image_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MImage> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ImageDataLoader.DATALOADER_AD_Image_BY_ID);
		return dataLoader.load(entity.getAD_Image_ID());
	}

	/**
	 * Get Description.
	 *
	 * @return Optional short description of the record
	 */
	public CompletableFuture<String> Description(MWindow entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDescription);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Window_TrlDataLoader.DATALOADER_AD_Window_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MWindow.COLUMNNAME_Description));
	}

	static Map<String, Integer> ENTITYTYPE_IDS_BY_ENTITY_TYPE = new HashMap<>() {
		{
			put("D", 10);
			put("C", 20);
			put("U", 100);
			put("CUST", 110);
			put("A", 200);
			put("EXT", 210);
			put("XX", 220);
			put("EE01", 50000);
			put("EE04", 50001);
			put("EE05", 50003);
			put("EE02", 50005);
			put("WSTORE", 200015);
		}
	};

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public CompletableFuture<MEntityType> AD_EntityType(MWindow entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getEntityType())) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.DATALOADER_AD_EntityType_BY_ID);
		return dataLoader.load(ENTITYTYPE_IDS_BY_ENTITY_TYPE.get(entity.getEntityType()));
	}

	/**
	 * Get Comment/Help.
	 *
	 * @return Comment or Hint
	 */
	public CompletableFuture<String> Help(MWindow entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getHelp);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Window_TrlDataLoader.DATALOADER_AD_Window_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MWindow.COLUMNNAME_Help));
	}

	public Boolean IsBetaFunctionality(MWindow entity, DataFetchingEnvironment environment) {
		return entity.isBetaFunctionality();
	}

	public Boolean IsDefault(MWindow entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}

	public Boolean IsSOTrx(MWindow entity, DataFetchingEnvironment environment) {
		return entity.isSOTrx();
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(MWindow entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Window_TrlDataLoader.DATALOADER_AD_Window_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MWindow.COLUMNNAME_Name));
	}

	public Boolean Processing(MWindow entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

	static Map<String, String> WINDOWTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("S", "240e7f4f-f266-419b-872f-2dd99a1efbc4");
			put("M", "156c6465-fda8-47fb-95b1-f3adb3f59a30");
			put("T", "3ab9298c-b0f2-4163-8c13-f0d81111c350");
			put("Q", "3d0b1e25-fa17-4730-b347-3500ec2de112");
		}
	};
	public CompletableFuture<MRefList_BH> WindowType(MWindow entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getWindowType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(WINDOWTYPE_UUIDS_BY_VALUE.get(entity.getWindowType()));
	}

}
