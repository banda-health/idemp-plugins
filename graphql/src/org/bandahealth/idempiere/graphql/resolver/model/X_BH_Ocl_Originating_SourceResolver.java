package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHOclOriginatingSource;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_ConceptDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Ocl_Originating_Source - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Ocl_Originating_SourceResolver extends POResolver<MBHOclOriginatingSource> implements GraphQLResolver<MBHOclOriginatingSource> {



	/**
	 * Get Concept.
	 *
	 * @return Concept
	 */
	public CompletableFuture<MBHConcept> BH_Concept(MBHOclOriginatingSource entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Concept_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MBHConcept> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_ConceptDataLoader.DATALOADER_BH_Concept_BY_ID);
		return dataLoader.load(entity.getBH_Concept_ID());
	}

	public static Map<String, String> BH_OCL_SOURCE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("BHGO", "e5517bb6-f4b5-40cf-b98f-0e32213413cf"); // BHGO - Coded diagnoses
			put("BHLabs", "0ec64177-8a96-41a4-add6-e411046377c9"); // BHLabs - Lab tests
		}
	};
	public CompletableFuture<MRefList_BH> BH_Ocl_Source(MBHOclOriginatingSource entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Ocl_Source())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_OCL_SOURCE_UUIDS_BY_VALUE.get(entity.getBH_Ocl_Source()));
	}

}
