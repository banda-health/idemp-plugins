package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ActivityDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CampaignDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementValueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_SalesRegionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_DistributionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.compiere.model.MActivity;
import org.compiere.model.MCampaign;
import org.compiere.model.MDistribution;
import org.compiere.model.MDistributionLine;
import org.compiere.model.MElementValue;
import org.compiere.model.MLocation;
import org.compiere.model.MProject;
import org.compiere.model.MSalesRegion;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for GL_DistributionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_GL_DistributionLineResolver extends POResolver<MDistributionLine> implements GraphQLResolver<MDistributionLine> {



	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public CompletableFuture<MActivity> C_Activity(MDistributionLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_Activity_ID() < 0) {
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
	public CompletableFuture<MBPartner_BH> C_BPartner(MDistributionLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 0) {
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
	public CompletableFuture<MCampaign> C_Campaign(MDistributionLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_Campaign_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MCampaign> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CampaignDataLoader.DATALOADER_C_Campaign_BY_ID);
		return dataLoader.load(entity.getC_Campaign_ID());
	}


	/**
	 * Get Location From.
	 *
	 * @return Location that inventory was moved from
	 */
	public CompletableFuture<MLocation> C_LocFrom(MDistributionLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_LocFrom_ID() < 0) {
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
	public CompletableFuture<MLocation> C_LocTo(MDistributionLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_LocTo_ID() < 0) {
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
	public CompletableFuture<MProject> C_Project(MDistributionLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() < 0) {
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
	public CompletableFuture<MSalesRegion> C_SalesRegion(MDistributionLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_SalesRegion_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MSalesRegion> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_SalesRegionDataLoader.DATALOADER_C_SalesRegion_BY_ID);
		return dataLoader.load(entity.getC_SalesRegion_ID());
	}


	/**
	 * Get GL Distribution.
	 *
	 * @return General Ledger Distribution
	 */
	public CompletableFuture<MDistribution> GL_Distribution(MDistributionLine entity, DataFetchingEnvironment environment) {
		if (entity.getGL_Distribution_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MDistribution> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_GL_DistributionDataLoader.DATALOADER_GL_Distribution_BY_ID);
		return dataLoader.load(entity.getGL_Distribution_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MDistributionLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}

	public Boolean OverwriteAcct(MDistributionLine entity, DataFetchingEnvironment environment) {
		return entity.isOverwriteAcct();
	}

	public Boolean OverwriteActivity(MDistributionLine entity, DataFetchingEnvironment environment) {
		return entity.isOverwriteActivity();
	}

	public Boolean OverwriteBPartner(MDistributionLine entity, DataFetchingEnvironment environment) {
		return entity.isOverwriteBPartner();
	}

	public Boolean OverwriteCampaign(MDistributionLine entity, DataFetchingEnvironment environment) {
		return entity.isOverwriteCampaign();
	}

	public Boolean OverwriteLocFrom(MDistributionLine entity, DataFetchingEnvironment environment) {
		return entity.isOverwriteLocFrom();
	}

	public Boolean OverwriteLocTo(MDistributionLine entity, DataFetchingEnvironment environment) {
		return entity.isOverwriteLocTo();
	}

	public Boolean OverwriteOrg(MDistributionLine entity, DataFetchingEnvironment environment) {
		return entity.isOverwriteOrg();
	}

	public Boolean OverwriteOrgTrx(MDistributionLine entity, DataFetchingEnvironment environment) {
		return entity.isOverwriteOrgTrx();
	}

	public Boolean OverwriteProduct(MDistributionLine entity, DataFetchingEnvironment environment) {
		return entity.isOverwriteProduct();
	}

	public Boolean OverwriteProject(MDistributionLine entity, DataFetchingEnvironment environment) {
		return entity.isOverwriteProject();
	}

	public Boolean OverwriteSalesRegion(MDistributionLine entity, DataFetchingEnvironment environment) {
		return entity.isOverwriteSalesRegion();
	}

	public Boolean OverwriteUser1(MDistributionLine entity, DataFetchingEnvironment environment) {
		return entity.isOverwriteUser1();
	}

	public Boolean OverwriteUser2(MDistributionLine entity, DataFetchingEnvironment environment) {
		return entity.isOverwriteUser2();
	}


	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	public CompletableFuture<MElementValue> User1(MDistributionLine entity, DataFetchingEnvironment environment) {
		if (entity.getUser1_ID() < 0) {
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
	public CompletableFuture<MElementValue> User2(MDistributionLine entity, DataFetchingEnvironment environment) {
		if (entity.getUser2_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getUser2_ID());
	}

}
