package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementValueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_JournalGeneratorDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MElementValue;
import org.compiere.model.MJournalGenerator;
import org.compiere.model.MJournalGeneratorLine;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for GL_JournalGeneratorLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_GL_JournalGeneratorLineResolver extends POResolver<MJournalGeneratorLine> implements GraphQLResolver<MJournalGeneratorLine> {


	public static Map<String, String> BPDIMENSIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C", "20e2b476-b0fd-48ae-85ac-cf6d165a8012"); // Column
			put("F", "ae07960f-9620-4c40-bff7-3171d1f52a10"); // Fixed
			put("S", "f17a68c5-0488-4718-a249-dd1f96c0f77f"); // Same
		}
	};
	public CompletableFuture<MRefList_BH> BPDimensionType(MJournalGeneratorLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBPDimensionType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BPDIMENSIONTYPE_UUIDS_BY_VALUE.get(entity.getBPDimensionType()));
	}


	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MJournalGeneratorLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Account CR.
	 *
	 * @return Account CR
	 */
	public CompletableFuture<MElementValue> C_ElementValueCR(MJournalGeneratorLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_ElementValueCR_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getC_ElementValueCR_ID());
	}


	/**
	 * Get Account DR.
	 *
	 * @return Account DR
	 */
	public CompletableFuture<MElementValue> C_ElementValueDR(MJournalGeneratorLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_ElementValueDR_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getC_ElementValueDR_ID());
	}


	/**
	 * Get GL Journal Generator.
	 *
	 * @return GL Journal Generator
	 */
	public CompletableFuture<MJournalGenerator> GL_JournalGenerator(MJournalGeneratorLine entity, DataFetchingEnvironment environment) {
		if (entity.getGL_JournalGenerator_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MJournalGenerator> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_GL_JournalGeneratorDataLoader.DATALOADER_GL_JournalGenerator_BY_ID);
		return dataLoader.load(entity.getGL_JournalGenerator_ID());
	}

	public Boolean IsCopyAllDimensions(MJournalGeneratorLine entity, DataFetchingEnvironment environment) {
		return entity.isCopyAllDimensions();
	}

	public Boolean IsSameProduct(MJournalGeneratorLine entity, DataFetchingEnvironment environment) {
		return entity.isSameProduct();
	}

}
