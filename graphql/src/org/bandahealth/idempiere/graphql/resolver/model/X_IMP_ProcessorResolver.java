package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_IMP_Processor_TypeDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MIMPProcessor;
import org.compiere.model.X_IMP_Processor_Type;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for IMP_Processor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_IMP_ProcessorResolver extends POResolver<MIMPProcessor> implements GraphQLResolver<MIMPProcessor> {


	public static Map<String, String> FREQUENCYTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("M", "80320e2a-1a3c-462f-9af1-09c0af1aab5f"); // Minute
			put("H", "817d1ba9-4dbe-4105-8ca5-61cf554ac837"); // Hour
			put("D", "6360c9c7-dbf3-4b2f-bd8b-3465a7fde7a7"); // Day
		}
	};
	public CompletableFuture<MRefList_BH> FrequencyType(MIMPProcessor entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getFrequencyType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(FREQUENCYTYPE_UUIDS_BY_VALUE.get(entity.getFrequencyType()));
	}


	/**
	 * Get Import Processor Type.
	 *
	 * @return Import Processor Type
	 */
	public CompletableFuture<X_IMP_Processor_Type> IMP_Processor_Type(MIMPProcessor entity, DataFetchingEnvironment environment) {
		if (entity.getIMP_Processor_Type_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_IMP_Processor_Type> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_IMP_Processor_TypeDataLoader.DATALOADER_IMP_Processor_Type_BY_ID);
		return dataLoader.load(entity.getIMP_Processor_Type_ID());
	}

	public Boolean Processing(MIMPProcessor entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
