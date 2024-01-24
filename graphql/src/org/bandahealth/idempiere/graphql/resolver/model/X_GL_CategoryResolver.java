package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_Category_TrlDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MGLCategory;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for GL_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_GL_CategoryResolver extends POResolver<MGLCategory> implements GraphQLResolver<MGLCategory> {


	static Map<String, String> CATEGORYTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("M", "e1853645-b246-4427-8ee8-0e52ff261d7c");
			put("I", "5bf27e3d-dda9-469b-8b34-11cf416d98ab");
			put("D", "9ec68463-45cd-4b45-ac89-7f5d6bb79b71");
			put("S", "5714a6aa-33e6-4280-9145-752da180d821");
		}
	};
	public CompletableFuture<MRefList_BH> CategoryType(MGLCategory entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCategoryType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(CATEGORYTYPE_UUIDS_BY_VALUE.get(entity.getCategoryType()));
	}

	public Boolean IsDefault(MGLCategory entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(MGLCategory entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_GL_Category_TrlDataLoader.DATALOADER_GL_Category_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MGLCategory.COLUMNNAME_Name));
	}

}
