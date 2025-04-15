package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_OrgTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BP_GroupDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxBaseDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxCategoryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxGroupDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_Product_CategoryDataLoader;
import org.compiere.model.MTax;
import org.compiere.model.MTaxCategory;
import org.compiere.model.X_AD_OrgType;
import org.dataloader.DataLoader;
import org.eevolution.model.X_C_TaxBase;
import org.eevolution.model.X_C_TaxDefinition;
import org.eevolution.model.X_C_TaxGroup;
import org.eevolution.model.X_C_TaxType;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_TaxDefinition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_TaxDefinitionResolver extends POResolver<X_C_TaxDefinition> implements GraphQLResolver<X_C_TaxDefinition> {



	/**
	 * Get Organization Type.
	 *
	 * @return Organization Type
	 */
	public CompletableFuture<X_AD_OrgType> AD_OrgType(X_C_TaxDefinition entity, DataFetchingEnvironment environment) {
		if (entity.getAD_OrgType_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_OrgType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_OrgTypeDataLoader.DATALOADER_AD_OrgType_BY_ID);
		return dataLoader.load(entity.getAD_OrgType_ID());
	}


	/**
	 * Get Business Partner Group.
	 *
	 * @return Business Partner Group
	 */
	public CompletableFuture<MBPGroup_BH> C_BP_Group(X_C_TaxDefinition entity, DataFetchingEnvironment environment) {
		if (entity.getC_BP_Group_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPGroup_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BP_GroupDataLoader.DATALOADER_C_BP_Group_BY_ID);
		return dataLoader.load(entity.getC_BP_Group_ID());
	}


	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(X_C_TaxDefinition entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Tax.
	 *
	 * @return Tax identifier
	 */
	public CompletableFuture<MTax> C_Tax(X_C_TaxDefinition entity, DataFetchingEnvironment environment) {
		if (entity.getC_Tax_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTax> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxDataLoader.DATALOADER_C_Tax_BY_ID);
		return dataLoader.load(entity.getC_Tax_ID());
	}


	/**
	 * Get Tax Base.
	 *
	 * @return Tax Base
	 */
	public CompletableFuture<X_C_TaxBase> C_TaxBase(X_C_TaxDefinition entity, DataFetchingEnvironment environment) {
		if (entity.getC_TaxBase_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_C_TaxBase> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxBaseDataLoader.DATALOADER_C_TaxBase_BY_ID);
		return dataLoader.load(entity.getC_TaxBase_ID());
	}


	/**
	 * Get Tax Category.
	 *
	 * @return Tax Category
	 */
	public CompletableFuture<MTaxCategory> C_TaxCategory(X_C_TaxDefinition entity, DataFetchingEnvironment environment) {
		if (entity.getC_TaxCategory_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTaxCategory> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxCategoryDataLoader.DATALOADER_C_TaxCategory_BY_ID);
		return dataLoader.load(entity.getC_TaxCategory_ID());
	}


	/**
	 * Get Tax Group.
	 *
	 * @return Tax Group
	 */
	public CompletableFuture<X_C_TaxGroup> C_TaxGroup(X_C_TaxDefinition entity, DataFetchingEnvironment environment) {
		if (entity.getC_TaxGroup_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_C_TaxGroup> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxGroupDataLoader.DATALOADER_C_TaxGroup_BY_ID);
		return dataLoader.load(entity.getC_TaxGroup_ID());
	}


	/**
	 * Get Tax Type.
	 *
	 * @return Tax Type
	 */
	public CompletableFuture<X_C_TaxType> C_TaxType(X_C_TaxDefinition entity, DataFetchingEnvironment environment) {
		if (entity.getC_TaxType_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_C_TaxType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxTypeDataLoader.DATALOADER_C_TaxType_BY_ID);
		return dataLoader.load(entity.getC_TaxType_ID());
	}

	public Boolean IsInvoiced(X_C_TaxDefinition entity, DataFetchingEnvironment environment) {
		return entity.isInvoiced();
	}


	/**
	 * Get Product Category.
	 *
	 * @return Category of a Product
	 */
	public CompletableFuture<MProductCategory_BH> M_Product_Category(X_C_TaxDefinition entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_Category_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProductCategory_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_Product_CategoryDataLoader.DATALOADER_M_Product_Category_BY_ID);
		return dataLoader.load(entity.getM_Product_Category_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(X_C_TaxDefinition entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}

}
