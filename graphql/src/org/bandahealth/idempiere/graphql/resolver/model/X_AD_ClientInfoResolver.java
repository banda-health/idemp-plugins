package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MTree_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ImageDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_StorageProviderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TreeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CalendarDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ChargeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_UOMDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCalendar;
import org.compiere.model.MClientInfo;
import org.compiere.model.MImage;
import org.compiere.model.MStorageProvider;
import org.compiere.model.MUOM;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_ClientInfo - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ClientInfoResolver extends POResolver<MClientInfo> implements GraphQLResolver<MClientInfo> {



	/**
	 * Get Storage Provider.
	 *
	 * @return Storage Provider
	 */
	public CompletableFuture<MStorageProvider> AD_StorageProvider(MClientInfo entity, DataFetchingEnvironment environment) {
		if (entity.getAD_StorageProvider_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MStorageProvider> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_StorageProviderDataLoader.DATALOADER_AD_StorageProvider_BY_ID);
		return dataLoader.load(entity.getAD_StorageProvider_ID());
	}


	/**
	 * Get Activity Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	public CompletableFuture<MTree_BH> AD_Tree_Activity(MClientInfo entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tree_Activity_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTree_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TreeDataLoader.DATALOADER_AD_Tree_BY_ID);
		return dataLoader.load(entity.getAD_Tree_Activity_ID());
	}


	/**
	 * Get BPartner Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	public CompletableFuture<MTree_BH> AD_Tree_BPartner(MClientInfo entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tree_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTree_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TreeDataLoader.DATALOADER_AD_Tree_BY_ID);
		return dataLoader.load(entity.getAD_Tree_BPartner_ID());
	}


	/**
	 * Get Campaign Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	public CompletableFuture<MTree_BH> AD_Tree_Campaign(MClientInfo entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tree_Campaign_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTree_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TreeDataLoader.DATALOADER_AD_Tree_BY_ID);
		return dataLoader.load(entity.getAD_Tree_Campaign_ID());
	}


	/**
	 * Get Menu Tree.
	 *
	 * @return Tree of the menu
	 */
	public CompletableFuture<MTree_BH> AD_Tree_Menu(MClientInfo entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tree_Menu_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTree_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TreeDataLoader.DATALOADER_AD_Tree_BY_ID);
		return dataLoader.load(entity.getAD_Tree_Menu_ID());
	}


	/**
	 * Get Organization Tree.
	 *
	 * @return Trees are used for (financial) reporting and security access (via role)
	 */
	public CompletableFuture<MTree_BH> AD_Tree_Org(MClientInfo entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tree_Org_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTree_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TreeDataLoader.DATALOADER_AD_Tree_BY_ID);
		return dataLoader.load(entity.getAD_Tree_Org_ID());
	}


	/**
	 * Get Product Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	public CompletableFuture<MTree_BH> AD_Tree_Product(MClientInfo entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tree_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTree_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TreeDataLoader.DATALOADER_AD_Tree_BY_ID);
		return dataLoader.load(entity.getAD_Tree_Product_ID());
	}


	/**
	 * Get Project Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	public CompletableFuture<MTree_BH> AD_Tree_Project(MClientInfo entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tree_Project_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTree_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TreeDataLoader.DATALOADER_AD_Tree_BY_ID);
		return dataLoader.load(entity.getAD_Tree_Project_ID());
	}


	/**
	 * Get Sales Region Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	public CompletableFuture<MTree_BH> AD_Tree_SalesRegion(MClientInfo entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tree_SalesRegion_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTree_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TreeDataLoader.DATALOADER_AD_Tree_BY_ID);
		return dataLoader.load(entity.getAD_Tree_SalesRegion_ID());
	}


	/**
	 * Get Primary Accounting Schema.
	 *
	 * @return Primary rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema1(MClientInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema1_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.DATALOADER_C_AcctSchema_BY_ID);
		return dataLoader.load(entity.getC_AcctSchema1_ID());
	}


	/**
	 * Get Template B.Partner.
	 *
	 * @return Business Partner used for creating new Business Partners on the fly
	 */
	public CompletableFuture<MBPartner_BH> C_BPartnerCashTrx(MClientInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartnerCashTrx_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartnerCashTrx_ID());
	}


	/**
	 * Get Calendar.
	 *
	 * @return Accounting Calendar Name
	 */
	public CompletableFuture<MCalendar> C_Calendar(MClientInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_Calendar_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCalendar> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CalendarDataLoader.DATALOADER_C_Calendar_BY_ID);
		return dataLoader.load(entity.getC_Calendar_ID());
	}


	/**
	 * Get Charge for Freight.
	 *
	 * @return Charge for Freight
	 */
	public CompletableFuture<MCharge_BH> C_ChargeFreight(MClientInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_ChargeFreight_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCharge_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ChargeDataLoader.DATALOADER_C_Charge_BY_ID);
		return dataLoader.load(entity.getC_ChargeFreight_ID());
	}


	/**
	 * Get UOM for Length.
	 *
	 * @return Standard Unit of Measure for Length
	 */
	public CompletableFuture<MUOM> C_UOM_Length(MClientInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_UOM_Length_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_UOMDataLoader.DATALOADER_C_UOM_BY_ID);
		return dataLoader.load(entity.getC_UOM_Length_ID());
	}


	/**
	 * Get UOM for Time.
	 *
	 * @return Standard Unit of Measure for Time
	 */
	public CompletableFuture<MUOM> C_UOM_Time(MClientInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_UOM_Time_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_UOMDataLoader.DATALOADER_C_UOM_BY_ID);
		return dataLoader.load(entity.getC_UOM_Time_ID());
	}


	/**
	 * Get UOM for Volume.
	 *
	 * @return Standard Unit of Measure for Volume
	 */
	public CompletableFuture<MUOM> C_UOM_Volume(MClientInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_UOM_Volume_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_UOMDataLoader.DATALOADER_C_UOM_BY_ID);
		return dataLoader.load(entity.getC_UOM_Volume_ID());
	}


	/**
	 * Get UOM for Weight.
	 *
	 * @return Standard Unit of Measure for Weight
	 */
	public CompletableFuture<MUOM> C_UOM_Weight(MClientInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_UOM_Weight_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_UOMDataLoader.DATALOADER_C_UOM_BY_ID);
		return dataLoader.load(entity.getC_UOM_Weight_ID());
	}

	public Boolean IsConfirmOnDocClose(MClientInfo entity, DataFetchingEnvironment environment) {
		return entity.isConfirmOnDocClose();
	}

	public Boolean IsConfirmOnDocVoid(MClientInfo entity, DataFetchingEnvironment environment) {
		return entity.isConfirmOnDocVoid();
	}

	public Boolean IsDiscountLineAmt(MClientInfo entity, DataFetchingEnvironment environment) {
		return entity.isDiscountLineAmt();
	}


	/**
	 * Get Logo.
	 *
	 * @return Logo
	 */
	public CompletableFuture<MImage> Logo(MClientInfo entity, DataFetchingEnvironment environment) {
		if (entity.getLogo_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MImage> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ImageDataLoader.DATALOADER_AD_Image_BY_ID);
		return dataLoader.load(entity.getLogo_ID());
	}


	/**
	 * Get Product for Freight.
	 *
	 * @return Product for Freight
	 */
	public CompletableFuture<MProduct_BH> M_ProductFreight(MClientInfo entity, DataFetchingEnvironment environment) {
		if (entity.getM_ProductFreight_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_ProductFreight_ID());
	}


	/**
	 * Get Archive Store.
	 *
	 * @return Archive Store
	 */
	public CompletableFuture<MStorageProvider> StorageArchive(MClientInfo entity, DataFetchingEnvironment environment) {
		if (entity.getStorageArchive_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MStorageProvider> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_StorageProviderDataLoader.DATALOADER_AD_StorageProvider_BY_ID);
		return dataLoader.load(entity.getStorageArchive_ID());
	}


	/**
	 * Get Image Store.
	 *
	 * @return Storage provider for Image
	 */
	public CompletableFuture<MStorageProvider> StorageImage(MClientInfo entity, DataFetchingEnvironment environment) {
		if (entity.getStorageImage_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MStorageProvider> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_StorageProviderDataLoader.DATALOADER_AD_StorageProvider_BY_ID);
		return dataLoader.load(entity.getStorageImage_ID());
	}

}
