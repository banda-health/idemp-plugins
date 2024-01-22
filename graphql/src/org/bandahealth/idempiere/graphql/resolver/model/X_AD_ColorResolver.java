package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Color_TrlDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ImageDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MColor;
import org.compiere.model.MImage;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Color - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ColorResolver extends POResolver<MColor> implements GraphQLResolver<MColor> {



	/**
	 * Get Image.
	 *
	 * @return Image or Icon
	 */
	public CompletableFuture<MImage> AD_Image(MColor entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Image_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MImage> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ImageDataLoader.DATALOADER_AD_Image_BY_ID);
		return dataLoader.load(entity.getAD_Image_ID());
	}

	static Map<String, String> COLORTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("F", "88532852-a8ee-4d5b-ba71-1d7d9cccba52");
			put("G", "4c7701f0-6634-42d0-b099-eceb09c71cc0");
			put("L", "a1f7e2d9-ca8d-4570-ae2b-389eb3da0fb6");
			put("T", "5fb3957b-a5bc-4b9d-93a1-a61da4d990e4");
		}
	};
	public CompletableFuture<MRefList_BH> ColorType(MColor entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getColorType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(COLORTYPE_UUIDS_BY_VALUE.get(entity.getColorType()));
	}

	public Boolean IsDefault(MColor entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(MColor entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Color_TrlDataLoader.DATALOADER_AD_Color_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MColor.COLUMNNAME_Name));
	}

	static Map<String, String> STARTPOINT_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("1", "5ffafd53-f087-438c-909e-e51b2183df07");
			put("2", "d738f8db-037f-4a83-898a-6d25fa8c3a58");
			put("3", "77df7a8c-39b7-4bd3-9b69-d21c05820b37");
			put("4", "c0ac335d-bc7e-4273-b70c-c98cdd97320b");
			put("5", "70492ef3-423f-49ae-882f-3a8b3a92ba7a");
			put("6", "8e961acb-4533-40a4-820a-e4e4ac5ea83a");
			put("7", "b08af11e-8671-49a9-93dd-048bb1ea3c49");
			put("8", "b37ca5ca-7313-4f43-9f00-12c2b8a77f2c");
		}
	};
	public CompletableFuture<MRefList_BH> StartPoint(MColor entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getStartPoint())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(STARTPOINT_UUIDS_BY_VALUE.get(entity.getStartPoint()));
	}

}
