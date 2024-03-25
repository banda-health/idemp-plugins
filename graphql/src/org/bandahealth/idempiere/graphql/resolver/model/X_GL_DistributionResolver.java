package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ActivityDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CampaignDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DocTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementValueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_SalesRegionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MActivity;
import org.compiere.model.MCampaign;
import org.compiere.model.MDistribution;
import org.compiere.model.MElementValue;
import org.compiere.model.MLocation;
import org.compiere.model.MProject;
import org.compiere.model.MSalesRegion;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for GL_Distribution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_GL_DistributionResolver extends POResolver<MDistribution> implements GraphQLResolver<MDistribution> {



	/**
	 * Get Account.
	 *
	 * @return Account used
	 */
	public CompletableFuture<MElementValue> Account(MDistribution entity, DataFetchingEnvironment environment) {
		if (entity.getAccount_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getAccount_ID());
	}

	public Boolean AnyAcct(MDistribution entity, DataFetchingEnvironment environment) {
		return entity.isAnyAcct();
	}

	public Boolean AnyActivity(MDistribution entity, DataFetchingEnvironment environment) {
		return entity.isAnyActivity();
	}

	public Boolean AnyBPartner(MDistribution entity, DataFetchingEnvironment environment) {
		return entity.isAnyBPartner();
	}

	public Boolean AnyCampaign(MDistribution entity, DataFetchingEnvironment environment) {
		return entity.isAnyCampaign();
	}

	public Boolean AnyLocFrom(MDistribution entity, DataFetchingEnvironment environment) {
		return entity.isAnyLocFrom();
	}

	public Boolean AnyLocTo(MDistribution entity, DataFetchingEnvironment environment) {
		return entity.isAnyLocTo();
	}

	public Boolean AnyOrg(MDistribution entity, DataFetchingEnvironment environment) {
		return entity.isAnyOrg();
	}

	public Boolean AnyOrgTrx(MDistribution entity, DataFetchingEnvironment environment) {
		return entity.isAnyOrgTrx();
	}

	public Boolean AnyProduct(MDistribution entity, DataFetchingEnvironment environment) {
		return entity.isAnyProduct();
	}

	public Boolean AnyProject(MDistribution entity, DataFetchingEnvironment environment) {
		return entity.isAnyProject();
	}

	public Boolean AnySalesRegion(MDistribution entity, DataFetchingEnvironment environment) {
		return entity.isAnySalesRegion();
	}

	public Boolean AnyUser1(MDistribution entity, DataFetchingEnvironment environment) {
		return entity.isAnyUser1();
	}

	public Boolean AnyUser2(MDistribution entity, DataFetchingEnvironment environment) {
		return entity.isAnyUser2();
	}


	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(MDistribution entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.DATALOADER_C_AcctSchema_BY_ID);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}


	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public CompletableFuture<MActivity> C_Activity(MDistribution entity, DataFetchingEnvironment environment) {
		if (entity.getC_Activity_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MActivity> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ActivityDataLoader.DATALOADER_C_Activity_BY_ID);
		return dataLoader.load(entity.getC_Activity_ID());
	}


	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MDistribution entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	public CompletableFuture<MCampaign> C_Campaign(MDistribution entity, DataFetchingEnvironment environment) {
		if (entity.getC_Campaign_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCampaign> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CampaignDataLoader.DATALOADER_C_Campaign_BY_ID);
		return dataLoader.load(entity.getC_Campaign_ID());
	}


	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	public CompletableFuture<MDocType_BH> C_DocType(MDistribution entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.DATALOADER_C_DocType_BY_ID);
		return dataLoader.load(entity.getC_DocType_ID());
	}


	/**
	 * Get Location From.
	 *
	 * @return Location that inventory was moved from
	 */
	public CompletableFuture<MLocation> C_LocFrom(MDistribution entity, DataFetchingEnvironment environment) {
		if (entity.getC_LocFrom_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_LocationDataLoader.DATALOADER_C_Location_BY_ID);
		return dataLoader.load(entity.getC_LocFrom_ID());
	}


	/**
	 * Get Location To.
	 *
	 * @return Location that inventory was moved to
	 */
	public CompletableFuture<MLocation> C_LocTo(MDistribution entity, DataFetchingEnvironment environment) {
		if (entity.getC_LocTo_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_LocationDataLoader.DATALOADER_C_Location_BY_ID);
		return dataLoader.load(entity.getC_LocTo_ID());
	}


	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public CompletableFuture<MProject> C_Project(MDistribution entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProject> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectDataLoader.DATALOADER_C_Project_BY_ID);
		return dataLoader.load(entity.getC_Project_ID());
	}


	/**
	 * Get Sales Region.
	 *
	 * @return Sales coverage region
	 */
	public CompletableFuture<MSalesRegion> C_SalesRegion(MDistribution entity, DataFetchingEnvironment environment) {
		if (entity.getC_SalesRegion_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MSalesRegion> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_SalesRegionDataLoader.DATALOADER_C_SalesRegion_BY_ID);
		return dataLoader.load(entity.getC_SalesRegion_ID());
	}

	public Boolean IsCreateReversal(MDistribution entity, DataFetchingEnvironment environment) {
		return entity.isCreateReversal();
	}

	public Boolean IsValid(MDistribution entity, DataFetchingEnvironment environment) {
		return entity.isValid();
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MDistribution entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}

	static Map<String, String> POSTINGTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "3c9d051c-7b7b-459d-90c5-0925e26c1bcc");
			put("B", "07bbb012-66f2-4860-bd6d-dc511618bf4e");
			put("E", "c40ae7b1-be06-4291-ac88-59974f74a46d");
			put("S", "6011c5d4-edcc-48f6-ba32-8d820d42dbfb");
			put("R", "c1e61fc6-ba26-400c-9ae4-716b3c67e1d5");
		}
	};
	public CompletableFuture<MRefList_BH> PostingType(MDistribution entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPostingType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(POSTINGTYPE_UUIDS_BY_VALUE.get(entity.getPostingType()));
	}

	public Boolean Processing(MDistribution entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}


	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	public CompletableFuture<MElementValue> User1(MDistribution entity, DataFetchingEnvironment environment) {
		if (entity.getUser1_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getUser1_ID());
	}


	/**
	 * Get User Element List 2.
	 *
	 * @return User defined list element #2
	 */
	public CompletableFuture<MElementValue> User2(MDistribution entity, DataFetchingEnvironment environment) {
		if (entity.getUser2_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getUser2_ID());
	}

}
