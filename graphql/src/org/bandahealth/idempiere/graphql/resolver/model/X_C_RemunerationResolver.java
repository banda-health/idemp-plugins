package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.X_C_Remuneration;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_Remuneration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_RemunerationResolver extends POResolver<X_C_Remuneration> implements GraphQLResolver<X_C_Remuneration> {


	static Map<String, String> REMUNERATIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("H", "1139bda4-f14c-4d1b-87c5-1cb4cef5f6e4");
			put("D", "fd1f9619-86c5-4d04-8a80-ef62eb9aebcd");
			put("W", "2e421542-efc4-4ba7-94f7-ee5ebe49595a");
			put("M", "97b4703b-6f99-4997-91b6-22c0b1232e76");
			put("T", "15fe26a9-8e28-406b-8119-2762319fb6df");
			put("B", "627268a0-9f97-42ca-8a47-7791d89ef5fa");
		}
	};
	public CompletableFuture<MRefList_BH> RemunerationType(X_C_Remuneration entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getRemunerationType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(REMUNERATIONTYPE_UUIDS_BY_VALUE.get(entity.getRemunerationType()));
	}

}
