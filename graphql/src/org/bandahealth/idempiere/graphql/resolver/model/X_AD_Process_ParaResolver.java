package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ElementDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ProcessDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReferenceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Val_RuleDataLoader;
import org.compiere.model.MEntityType;
import org.compiere.model.MProcessPara;
import org.compiere.model.MValRule;
import org.compiere.model.M_Element;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for AD_Process_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Process_ParaResolver extends POResolver<MProcessPara> implements GraphQLResolver<MProcessPara> {



	/**
	 * Get System Element.
	 *
	 * @return System Element enables the central maintenance of column description and help.
	 */
	public CompletableFuture<M_Element> AD_Element(MProcessPara entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Element_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, M_Element> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ElementDataLoader.AD_Element_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Element_ID());
	}


	/**
	 * Get Process.
	 *
	 * @return Process or Report
	 */
	public CompletableFuture<MProcess_BH> AD_Process(MProcessPara entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Process_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProcess_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ProcessDataLoader.AD_Process_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Process_ID());
	}


	/**
	 * Get Reference.
	 *
	 * @return System Reference and Validation
	 */
	public CompletableFuture<MReference_BH> AD_Reference(MProcessPara entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReference_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReferenceDataLoader.AD_Reference_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Reference_ID());
	}


	/**
	 * Get Reference Key.
	 *
	 * @return Required to specify, if data type is Table or List
	 */
	public CompletableFuture<MReference_BH> AD_Reference_Value(MProcessPara entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_Value_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReference_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReferenceDataLoader.AD_Reference_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Reference_Value_ID());
	}


	/**
	 * Get Dynamic Validation.
	 *
	 * @return Dynamic Validation Rule
	 */
	public CompletableFuture<MValRule> AD_Val_Rule(MProcessPara entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Val_Rule_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MValRule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Val_RuleDataLoader.AD_Val_Rule_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Val_Rule_ID());
	}


	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public CompletableFuture<MEntityType> AD_EntityType(MProcessPara entity, DataFetchingEnvironment environment) {
		if (entity.getEntityType() <= 0) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.AD_EntityType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getEntityType());
	}

}
