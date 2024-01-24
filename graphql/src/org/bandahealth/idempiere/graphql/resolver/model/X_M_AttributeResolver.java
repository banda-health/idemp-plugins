package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReferenceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Val_RuleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSearchDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAttribute;
import org.compiere.model.MValRule;
import org.compiere.model.X_M_AttributeSearch;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_Attribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_AttributeResolver extends POResolver<MAttribute> implements GraphQLResolver<MAttribute> {



	/**
	 * Get Reference.
	 *
	 * @return System Reference and Validation
	 */
	public CompletableFuture<MReference_BH> AD_Reference(MAttribute entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReference_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReferenceDataLoader.DATALOADER_AD_Reference_BY_ID);
		return dataLoader.load(entity.getAD_Reference_ID());
	}


	/**
	 * Get Reference Key.
	 *
	 * @return Required to specify, if data type is Table or List
	 */
	public CompletableFuture<MReference_BH> AD_Reference_Value(MAttribute entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_Value_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReference_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReferenceDataLoader.DATALOADER_AD_Reference_BY_ID);
		return dataLoader.load(entity.getAD_Reference_Value_ID());
	}


	/**
	 * Get Dynamic Validation.
	 *
	 * @return Dynamic Validation Rule
	 */
	public CompletableFuture<MValRule> AD_Val_Rule(MAttribute entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Val_Rule_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MValRule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Val_RuleDataLoader.DATALOADER_AD_Val_Rule_BY_ID);
		return dataLoader.load(entity.getAD_Val_Rule_ID());
	}

	static Map<String, String> ATTRIBUTEVALUETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("S", "156e3f9d-3408-4b24-b65e-66cd9c1b2ce2");
			put("N", "9af1763b-0bf6-4c9d-8426-c678999ea533");
			put("L", "ce8ac306-42ef-47f8-bb62-2b52a0b6468e");
			put("D", "34c7fbc0-6718-433e-a55c-6d203496e06a");
			put("R", "57503d9a-9bd2-4eb9-b2cf-1f43dc144dcc");
		}
	};
	public CompletableFuture<MRefList_BH> AttributeValueType(MAttribute entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAttributeValueType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(ATTRIBUTEVALUETYPE_UUIDS_BY_VALUE.get(entity.getAttributeValueType()));
	}

	public Boolean IsInstanceAttribute(MAttribute entity, DataFetchingEnvironment environment) {
		return entity.isInstanceAttribute();
	}

	public Boolean IsMandatory(MAttribute entity, DataFetchingEnvironment environment) {
		return entity.isMandatory();
	}


	/**
	 * Get Attribute Search.
	 *
	 * @return Common Search Attribute 
	 */
	public CompletableFuture<X_M_AttributeSearch> M_AttributeSearch(MAttribute entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSearch_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_M_AttributeSearch> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSearchDataLoader.DATALOADER_M_AttributeSearch_BY_ID);
		return dataLoader.load(entity.getM_AttributeSearch_ID());
	}

}
