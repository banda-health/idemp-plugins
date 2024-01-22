package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MTree_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCalendar;
import org.compiere.model.MClientInfo;
import org.compiere.model.MImage;
import org.compiere.model.MOrg;
import org.compiere.model.MStorageProvider;
import org.compiere.model.MUOM;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for AD_ClientInfo - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ClientInfoInput extends MClientInfo implements I_AD_ClientInfoInput {

	private ForeignEntityInput mAD_Image;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_StorageProvider;
	private ForeignEntityInput mAD_Tree_Activity;
	private ForeignEntityInput mAD_Tree_BPartner;
	private ForeignEntityInput mAD_Tree_Campaign;
	private ForeignEntityInput mAD_Tree_Menu;
	private ForeignEntityInput mAD_Tree_Org;
	private ForeignEntityInput mAD_Tree_Product;
	private ForeignEntityInput mAD_Tree_Project;
	private ForeignEntityInput mAD_Tree_SalesRegion;
	private ForeignEntityInput mC_AcctSchema1;
	private ForeignEntityInput mC_BPartnerCashTrx;
	private ForeignEntityInput mC_Calendar;
	private ForeignEntityInput mC_ChargeFreight;
	private ForeignEntityInput mC_UOM_Length;
	private ForeignEntityInput mC_UOM_Time;
	private ForeignEntityInput mC_UOM_Volume;
	private ForeignEntityInput mC_UOM_Weight;
	private ForeignEntityInput mM_ProductFreight;
	private ForeignEntityInput mStorageArchive;
	private ForeignEntityInput mStorageImage;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_ClientInfoInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MClientInfo(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_ClientInfo_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_ClientInfo_UU();
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Storage Provider.
	 *
	 * @param AD_StorageProvider Storage Provider
	 */
	@JsonProperty("AD_StorageProvider")
	public void setAD_StorageProviderInput(ForeignEntityInput AD_StorageProvider) {
		this.mAD_StorageProvider = AD_StorageProvider;
		MStorageProvider foreignEntity;
		if (AD_StorageProvider != null &&
				(foreignEntity = new Query(getCtx(), "AD_StorageProvider", "AD_StorageProvider_UU=?", get_TrxName())
						.setParameters(AD_StorageProvider.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_StorageProvider_ID(foreignEntity.get_ID());
		} else {
			super.setAD_StorageProvider_ID(0);
		}
	}

	/**
	 * Get Storage Provider.
	 *
	 * @return Storage Provider
	 */
	@JsonProperty("AD_StorageProvider")
	public ForeignEntityInput AD_StorageProvider() {
		return mAD_StorageProvider;
	}

	/**
	 * Set Activity Tree.
	 *
	 * @param AD_Tree_Activity Trees are used for (financial) reporting
	 */
	@JsonProperty("AD_Tree_Activity")
	public void setAD_Tree_ActivityInput(ForeignEntityInput AD_Tree_Activity) {
		this.mAD_Tree_Activity = AD_Tree_Activity;
		MTree_BH foreignEntity;
		if (get_ID() == 0 && AD_Tree_Activity != null &&
				(foreignEntity = new Query(getCtx(), "AD_Tree", "AD_Tree_UU=?", get_TrxName())
						.setParameters(AD_Tree_Activity.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Tree_Activity_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Activity Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	@JsonProperty("AD_Tree_Activity")
	public ForeignEntityInput AD_Tree_Activity() {
		return mAD_Tree_Activity;
	}

	/**
	 * Set BPartner Tree.
	 *
	 * @param AD_Tree_BPartner Trees are used for (financial) reporting
	 */
	@JsonProperty("AD_Tree_BPartner")
	public void setAD_Tree_BPartnerInput(ForeignEntityInput AD_Tree_BPartner) {
		this.mAD_Tree_BPartner = AD_Tree_BPartner;
		MTree_BH foreignEntity;
		if (get_ID() == 0 && AD_Tree_BPartner != null &&
				(foreignEntity = new Query(getCtx(), "AD_Tree", "AD_Tree_UU=?", get_TrxName())
						.setParameters(AD_Tree_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Tree_BPartner_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get BPartner Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	@JsonProperty("AD_Tree_BPartner")
	public ForeignEntityInput AD_Tree_BPartner() {
		return mAD_Tree_BPartner;
	}

	/**
	 * Set Campaign Tree.
	 *
	 * @param AD_Tree_Campaign Trees are used for (financial) reporting
	 */
	@JsonProperty("AD_Tree_Campaign")
	public void setAD_Tree_CampaignInput(ForeignEntityInput AD_Tree_Campaign) {
		this.mAD_Tree_Campaign = AD_Tree_Campaign;
		MTree_BH foreignEntity;
		if (get_ID() == 0 && AD_Tree_Campaign != null &&
				(foreignEntity = new Query(getCtx(), "AD_Tree", "AD_Tree_UU=?", get_TrxName())
						.setParameters(AD_Tree_Campaign.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Tree_Campaign_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Campaign Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	@JsonProperty("AD_Tree_Campaign")
	public ForeignEntityInput AD_Tree_Campaign() {
		return mAD_Tree_Campaign;
	}

	/**
	 * Set Menu Tree.
	 *
	 * @param AD_Tree_Menu Tree of the menu
	 */
	@JsonProperty("AD_Tree_Menu")
	public void setAD_Tree_MenuInput(ForeignEntityInput AD_Tree_Menu) {
		this.mAD_Tree_Menu = AD_Tree_Menu;
		MTree_BH foreignEntity;
		if (get_ID() == 0 && AD_Tree_Menu != null &&
				(foreignEntity = new Query(getCtx(), "AD_Tree", "AD_Tree_UU=?", get_TrxName())
						.setParameters(AD_Tree_Menu.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Tree_Menu_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Menu Tree.
	 *
	 * @return Tree of the menu
	 */
	@JsonProperty("AD_Tree_Menu")
	public ForeignEntityInput AD_Tree_Menu() {
		return mAD_Tree_Menu;
	}

	/**
	 * Set Organization Tree.
	 *
	 * @param AD_Tree_Org Trees are used for (financial) reporting and security access (via role)
	 */
	@JsonProperty("AD_Tree_Org")
	public void setAD_Tree_OrgInput(ForeignEntityInput AD_Tree_Org) {
		this.mAD_Tree_Org = AD_Tree_Org;
		MTree_BH foreignEntity;
		if (get_ID() == 0 && AD_Tree_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Tree", "AD_Tree_UU=?", get_TrxName())
						.setParameters(AD_Tree_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Tree_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization Tree.
	 *
	 * @return Trees are used for (financial) reporting and security access (via role)
	 */
	@JsonProperty("AD_Tree_Org")
	public ForeignEntityInput AD_Tree_Org() {
		return mAD_Tree_Org;
	}

	/**
	 * Set Product Tree.
	 *
	 * @param AD_Tree_Product Trees are used for (financial) reporting
	 */
	@JsonProperty("AD_Tree_Product")
	public void setAD_Tree_ProductInput(ForeignEntityInput AD_Tree_Product) {
		this.mAD_Tree_Product = AD_Tree_Product;
		MTree_BH foreignEntity;
		if (get_ID() == 0 && AD_Tree_Product != null &&
				(foreignEntity = new Query(getCtx(), "AD_Tree", "AD_Tree_UU=?", get_TrxName())
						.setParameters(AD_Tree_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Tree_Product_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Product Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	@JsonProperty("AD_Tree_Product")
	public ForeignEntityInput AD_Tree_Product() {
		return mAD_Tree_Product;
	}

	/**
	 * Set Project Tree.
	 *
	 * @param AD_Tree_Project Trees are used for (financial) reporting
	 */
	@JsonProperty("AD_Tree_Project")
	public void setAD_Tree_ProjectInput(ForeignEntityInput AD_Tree_Project) {
		this.mAD_Tree_Project = AD_Tree_Project;
		MTree_BH foreignEntity;
		if (get_ID() == 0 && AD_Tree_Project != null &&
				(foreignEntity = new Query(getCtx(), "AD_Tree", "AD_Tree_UU=?", get_TrxName())
						.setParameters(AD_Tree_Project.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Tree_Project_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Project Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	@JsonProperty("AD_Tree_Project")
	public ForeignEntityInput AD_Tree_Project() {
		return mAD_Tree_Project;
	}

	/**
	 * Set Sales Region Tree.
	 *
	 * @param AD_Tree_SalesRegion Trees are used for (financial) reporting
	 */
	@JsonProperty("AD_Tree_SalesRegion")
	public void setAD_Tree_SalesRegionInput(ForeignEntityInput AD_Tree_SalesRegion) {
		this.mAD_Tree_SalesRegion = AD_Tree_SalesRegion;
		MTree_BH foreignEntity;
		if (get_ID() == 0 && AD_Tree_SalesRegion != null &&
				(foreignEntity = new Query(getCtx(), "AD_Tree", "AD_Tree_UU=?", get_TrxName())
						.setParameters(AD_Tree_SalesRegion.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Tree_SalesRegion_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Sales Region Tree.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	@JsonProperty("AD_Tree_SalesRegion")
	public ForeignEntityInput AD_Tree_SalesRegion() {
		return mAD_Tree_SalesRegion;
	}

	/**
	 * Set Primary Accounting Schema.
	 *
	 * @param C_AcctSchema1 Primary rules for accounting
	 */
	@JsonProperty("C_AcctSchema1")
	public void setC_AcctSchema1Input(ForeignEntityInput C_AcctSchema1) {
		this.mC_AcctSchema1 = C_AcctSchema1;
		MAcctSchema foreignEntity;
		if (get_ID() == 0 && C_AcctSchema1 != null &&
				(foreignEntity = new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
						.setParameters(C_AcctSchema1.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_AcctSchema1_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Primary Accounting Schema.
	 *
	 * @return Primary rules for accounting
	 */
	@JsonProperty("C_AcctSchema1")
	public ForeignEntityInput C_AcctSchema1() {
		return mC_AcctSchema1;
	}

	/**
	 * Set Template B.Partner.
	 *
	 * @param C_BPartnerCashTrx Business Partner used for creating new Business Partners on the fly
	 */
	@JsonProperty("C_BPartnerCashTrx")
	public void setC_BPartnerCashTrxInput(ForeignEntityInput C_BPartnerCashTrx) {
		this.mC_BPartnerCashTrx = C_BPartnerCashTrx;
		MBPartner_BH foreignEntity;
		if (C_BPartnerCashTrx != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
						.setParameters(C_BPartnerCashTrx.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartnerCashTrx_ID(foreignEntity.get_ID());
		} else {
			super.setC_BPartnerCashTrx_ID(0);
		}
	}

	/**
	 * Get Template B.Partner.
	 *
	 * @return Business Partner used for creating new Business Partners on the fly
	 */
	@JsonProperty("C_BPartnerCashTrx")
	public ForeignEntityInput C_BPartnerCashTrx() {
		return mC_BPartnerCashTrx;
	}

	/**
	 * Set Calendar.
	 *
	 * @param C_Calendar Accounting Calendar Name
	 */
	@JsonProperty("C_Calendar")
	public void setC_CalendarInput(ForeignEntityInput C_Calendar) {
		this.mC_Calendar = C_Calendar;
		MCalendar foreignEntity;
		if (C_Calendar != null &&
				(foreignEntity = new Query(getCtx(), "C_Calendar", "C_Calendar_UU=?", get_TrxName())
						.setParameters(C_Calendar.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Calendar_ID(foreignEntity.get_ID());
		} else {
			super.setC_Calendar_ID(0);
		}
	}

	/**
	 * Get Calendar.
	 *
	 * @return Accounting Calendar Name
	 */
	@JsonProperty("C_Calendar")
	public ForeignEntityInput C_Calendar() {
		return mC_Calendar;
	}

	/**
	 * Set Charge for Freight.
	 *
	 * @param C_ChargeFreight Charge for Freight
	 */
	@JsonProperty("C_ChargeFreight")
	public void setC_ChargeFreightInput(ForeignEntityInput C_ChargeFreight) {
		this.mC_ChargeFreight = C_ChargeFreight;
		MCharge_BH foreignEntity;
		if (C_ChargeFreight != null &&
				(foreignEntity = new Query(getCtx(), "C_Charge", "C_Charge_UU=?", get_TrxName())
						.setParameters(C_ChargeFreight.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ChargeFreight_ID(foreignEntity.get_ID());
		} else {
			super.setC_ChargeFreight_ID(0);
		}
	}

	/**
	 * Get Charge for Freight.
	 *
	 * @return Charge for Freight
	 */
	@JsonProperty("C_ChargeFreight")
	public ForeignEntityInput C_ChargeFreight() {
		return mC_ChargeFreight;
	}

	/**
	 * Set UOM for Length.
	 *
	 * @param C_UOM_Length Standard Unit of Measure for Length
	 */
	@JsonProperty("C_UOM_Length")
	public void setC_UOM_LengthInput(ForeignEntityInput C_UOM_Length) {
		this.mC_UOM_Length = C_UOM_Length;
		MUOM foreignEntity;
		if (C_UOM_Length != null &&
				(foreignEntity = new Query(getCtx(), "C_UOM", "C_UOM_UU=?", get_TrxName())
						.setParameters(C_UOM_Length.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_UOM_Length_ID(foreignEntity.get_ID());
		} else {
			super.setC_UOM_Length_ID(0);
		}
	}

	/**
	 * Get UOM for Length.
	 *
	 * @return Standard Unit of Measure for Length
	 */
	@JsonProperty("C_UOM_Length")
	public ForeignEntityInput C_UOM_Length() {
		return mC_UOM_Length;
	}

	/**
	 * Set UOM for Time.
	 *
	 * @param C_UOM_Time Standard Unit of Measure for Time
	 */
	@JsonProperty("C_UOM_Time")
	public void setC_UOM_TimeInput(ForeignEntityInput C_UOM_Time) {
		this.mC_UOM_Time = C_UOM_Time;
		MUOM foreignEntity;
		if (C_UOM_Time != null &&
				(foreignEntity = new Query(getCtx(), "C_UOM", "C_UOM_UU=?", get_TrxName())
						.setParameters(C_UOM_Time.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_UOM_Time_ID(foreignEntity.get_ID());
		} else {
			super.setC_UOM_Time_ID(0);
		}
	}

	/**
	 * Get UOM for Time.
	 *
	 * @return Standard Unit of Measure for Time
	 */
	@JsonProperty("C_UOM_Time")
	public ForeignEntityInput C_UOM_Time() {
		return mC_UOM_Time;
	}

	/**
	 * Set UOM for Volume.
	 *
	 * @param C_UOM_Volume Standard Unit of Measure for Volume
	 */
	@JsonProperty("C_UOM_Volume")
	public void setC_UOM_VolumeInput(ForeignEntityInput C_UOM_Volume) {
		this.mC_UOM_Volume = C_UOM_Volume;
		MUOM foreignEntity;
		if (C_UOM_Volume != null &&
				(foreignEntity = new Query(getCtx(), "C_UOM", "C_UOM_UU=?", get_TrxName())
						.setParameters(C_UOM_Volume.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_UOM_Volume_ID(foreignEntity.get_ID());
		} else {
			super.setC_UOM_Volume_ID(0);
		}
	}

	/**
	 * Get UOM for Volume.
	 *
	 * @return Standard Unit of Measure for Volume
	 */
	@JsonProperty("C_UOM_Volume")
	public ForeignEntityInput C_UOM_Volume() {
		return mC_UOM_Volume;
	}

	/**
	 * Set UOM for Weight.
	 *
	 * @param C_UOM_Weight Standard Unit of Measure for Weight
	 */
	@JsonProperty("C_UOM_Weight")
	public void setC_UOM_WeightInput(ForeignEntityInput C_UOM_Weight) {
		this.mC_UOM_Weight = C_UOM_Weight;
		MUOM foreignEntity;
		if (C_UOM_Weight != null &&
				(foreignEntity = new Query(getCtx(), "C_UOM", "C_UOM_UU=?", get_TrxName())
						.setParameters(C_UOM_Weight.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_UOM_Weight_ID(foreignEntity.get_ID());
		} else {
			super.setC_UOM_Weight_ID(0);
		}
	}

	/**
	 * Get UOM for Weight.
	 *
	 * @return Standard Unit of Measure for Weight
	 */
	@JsonProperty("C_UOM_Weight")
	public ForeignEntityInput C_UOM_Weight() {
		return mC_UOM_Weight;
	}

	/**
	 * Set Logo.
	 *
	 * @param AD_Image Logo
	 */
	@JsonProperty("AD_Image")
	public void setAD_ImageInput(ForeignEntityInput AD_Image) {
		this.mAD_Image = AD_Image;
		MImage foreignEntity;
		if (AD_Image != null &&
				(foreignEntity = new Query(getCtx(), "AD_Image", "AD_Image_UU=?", get_TrxName())
						.setParameters(AD_Image.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setLogo_ID(foreignEntity.get_ID());
		} else {
			super.setLogo_ID(0);
		}
	}

	/**
	 * Get Logo.
	 *
	 * @return Logo
	 */
	@JsonProperty("AD_Image")
	public ForeignEntityInput AD_Image() {
		return mAD_Image;
	}

	/**
	 * Set Product for Freight.
	 *
	 * @param M_ProductFreight Product for Freight
	 */
	@JsonProperty("M_ProductFreight")
	public void setM_ProductFreightInput(ForeignEntityInput M_ProductFreight) {
		this.mM_ProductFreight = M_ProductFreight;
		MProduct_BH foreignEntity;
		if (M_ProductFreight != null &&
				(foreignEntity = new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
						.setParameters(M_ProductFreight.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ProductFreight_ID(foreignEntity.get_ID());
		} else {
			super.setM_ProductFreight_ID(0);
		}
	}

	/**
	 * Get Product for Freight.
	 *
	 * @return Product for Freight
	 */
	@JsonProperty("M_ProductFreight")
	public ForeignEntityInput M_ProductFreight() {
		return mM_ProductFreight;
	}

	/**
	 * Set Archive Store.
	 *
	 * @param StorageArchive Archive Store
	 */
	@JsonProperty("StorageArchive")
	public void setStorageArchiveInput(ForeignEntityInput StorageArchive) {
		this.mStorageArchive = StorageArchive;
		MStorageProvider foreignEntity;
		if (StorageArchive != null &&
				(foreignEntity = new Query(getCtx(), "AD_StorageProvider", "AD_StorageProvider_UU=?", get_TrxName())
						.setParameters(StorageArchive.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setStorageArchive_ID(foreignEntity.get_ID());
		} else {
			super.setStorageArchive_ID(0);
		}
	}

	/**
	 * Get Archive Store.
	 *
	 * @return Archive Store
	 */
	@JsonProperty("StorageArchive")
	public ForeignEntityInput StorageArchive() {
		return mStorageArchive;
	}

	/**
	 * Set Image Store.
	 *
	 * @param StorageImage Storage provider for Image
	 */
	@JsonProperty("StorageImage")
	public void setStorageImageInput(ForeignEntityInput StorageImage) {
		this.mStorageImage = StorageImage;
		MStorageProvider foreignEntity;
		if (StorageImage != null &&
				(foreignEntity = new Query(getCtx(), "AD_StorageProvider", "AD_StorageProvider_UU=?", get_TrxName())
						.setParameters(StorageImage.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setStorageImage_ID(foreignEntity.get_ID());
		} else {
			super.setStorageImage_ID(0);
		}
	}

	/**
	 * Get Image Store.
	 *
	 * @return Storage provider for Image
	 */
	@JsonProperty("StorageImage")
	public ForeignEntityInput StorageImage() {
		return mStorageImage;
	}
}
