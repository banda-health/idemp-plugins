package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetClass;
import org.compiere.model.MAssetGroup;
import org.compiere.model.MAssetType;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MInOutLine;
import org.compiere.model.MLocation;
import org.compiere.model.MLocator;
import org.compiere.model.MOrg;
import org.compiere.model.MProject;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for A_Asset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_AssetInput extends MAsset implements I_A_AssetInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_AD_Ref_ListInput mA_Asset_Action;
	 private I_AD_Ref_ListInput mA_Asset_Status;
	 private I_AD_UserInput mAD_User;
	 private I_A_AssetInput mA_Parent_Asset;
	 private I_A_Asset_ClassInput mA_Asset_Class;
	 private I_A_Asset_GroupInput mA_Asset_Group;
	 private I_A_Asset_TypeInput mA_Asset_Type;
	 private I_C_ActivityInput mC_Activity;
	 private I_C_BPartnerInput mC_BPartner;
	 private I_C_BPartnerInput mC_BPartnerSR;
	 private I_C_BPartnerInput mLease_BPartner;
	 private I_C_BPartner_LocationInput mC_BPartner_Location;
	 private I_C_LocationInput mC_Location;
	 private I_C_ProjectInput mC_Project;
	 private I_M_AttributeSetInstanceInput mM_AttributeSetInstance;
	 private I_M_InOutLineInput mM_InOutLine;
	 private I_M_LocatorInput mM_Locator;
	 private I_M_ProductInput mM_Product;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_A_AssetInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Asset Action.
	 *
	 * @param A_Asset_Action Asset Action
	 */
	@JsonProperty("A_Asset_Action")
	public void setA_Asset_ActionInput(I_AD_Ref_ListInput A_Asset_Action) {
		this.mA_Asset_Action = A_Asset_Action;
		MRefList_BH foreignEntity;
		if (A_Asset_Action != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Action.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_Action(foreignEntity.getValue());
		} else {
			this.setA_Asset_Action(null);
		}
	}

	/**
	 * Get Asset Action.
	 *
	 * @return Asset Action
	 */
	@JsonProperty("A_Asset_Action")
	public I_AD_Ref_ListInput A_Asset_Action() {
		return mA_Asset_Action;
	}

	/**
	 * Set Asset class.
	 *
	 * @param A_Asset_Class Asset class
	 */
	@JsonProperty("A_Asset_Class")
	public void setA_Asset_ClassInput(I_A_Asset_ClassInput A_Asset_Class) {
		this.mA_Asset_Class = A_Asset_Class;
		MAssetClass foreignEntity;
		if (A_Asset_Class != null &&
				(foreignEntity = new Query(getCtx(), MAssetClass.Table_Name, MAssetClass.COLUMNNAME_A_Asset_Class_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Class.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_Class_ID(foreignEntity.get_ID());
		} else {
			super.setA_Asset_Class_ID(0);
		}
	}

	/**
	 * Get Asset class.
	 *
	 * @return Asset class
	 */
	@JsonProperty("A_Asset_Class")
	public I_A_Asset_ClassInput A_Asset_Class() {
		return mA_Asset_Class;
	}
	/**
	 * Set Create Date.
	 *
	 * @param A_Asset_CreateDate Create Date
	 */

	public void setA_Asset_CreateDate(Timestamp A_Asset_CreateDate) {
		if (get_ID() == 0) {
			super.setA_Asset_CreateDate(A_Asset_CreateDate);
		}
	}

	/**
	 * Set Asset Group.
	 *
	 * @param A_Asset_Group Group of Assets
	 */
	@JsonProperty("A_Asset_Group")
	public void setA_Asset_GroupInput(I_A_Asset_GroupInput A_Asset_Group) {
		this.mA_Asset_Group = A_Asset_Group;
		MAssetGroup foreignEntity;
		if (A_Asset_Group != null &&
				(foreignEntity = new Query(getCtx(), MAssetGroup.Table_Name, MAssetGroup.COLUMNNAME_A_Asset_Group_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Group.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_Group_ID(foreignEntity.get_ID());
		} else {
			super.setA_Asset_Group_ID(0);
		}
	}

	/**
	 * Get Asset Group.
	 *
	 * @return Group of Assets
	 */
	@JsonProperty("A_Asset_Group")
	public I_A_Asset_GroupInput A_Asset_Group() {
		return mA_Asset_Group;
	}

	/**
	 * Set Asset Status.
	 *
	 * @param A_Asset_Status Asset Status
	 */
	@JsonProperty("A_Asset_Status")
	public void setA_Asset_StatusInput(I_AD_Ref_ListInput A_Asset_Status) {
		this.mA_Asset_Status = A_Asset_Status;
		MRefList_BH foreignEntity;
		if (A_Asset_Status != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Status.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_Status(foreignEntity.getValue());
		} else {
			this.setA_Asset_Status(null);
		}
	}

	/**
	 * Get Asset Status.
	 *
	 * @return Asset Status
	 */
	@JsonProperty("A_Asset_Status")
	public I_AD_Ref_ListInput A_Asset_Status() {
		return mA_Asset_Status;
	}

	/**
	 * Set Asset Type.
	 *
	 * @param A_Asset_Type Asset Type
	 */
	@JsonProperty("A_Asset_Type")
	public void setA_Asset_TypeInput(I_A_Asset_TypeInput A_Asset_Type) {
		this.mA_Asset_Type = A_Asset_Type;
		MAssetType foreignEntity;
		if (A_Asset_Type != null &&
				(foreignEntity = new Query(getCtx(), MAssetType.Table_Name, MAssetType.COLUMNNAME_A_Asset_Type_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Type.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_Type_ID(foreignEntity.get_ID());
		} else {
			super.setA_Asset_Type_ID(0);
		}
	}

	/**
	 * Get Asset Type.
	 *
	 * @return Asset Type
	 */
	@JsonProperty("A_Asset_Type")
	public I_A_Asset_TypeInput A_Asset_Type() {
		return mA_Asset_Type;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setA_Asset_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getA_Asset_UU();
	}

	/**
	 * Set Parent Asset.
	 *
	 * @param A_Parent_Asset Parent Asset
	 */
	@JsonProperty("A_Parent_Asset")
	public void setA_Parent_AssetInput(I_A_AssetInput A_Parent_Asset) {
		this.mA_Parent_Asset = A_Parent_Asset;
		MAsset foreignEntity;
		if (A_Parent_Asset != null &&
				(foreignEntity = new Query(getCtx(), MAsset.Table_Name, MAsset.COLUMNNAME_A_Asset_UU + "=?", get_TrxName())
						.setParameters(A_Parent_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Parent_Asset_ID(foreignEntity.get_ID());
		} else {
			super.setA_Parent_Asset_ID(0);
		}
	}

	/**
	 * Get Parent Asset.
	 *
	 * @return Parent Asset
	 */
	@JsonProperty("A_Parent_Asset")
	public I_A_AssetInput A_Parent_Asset() {
		return mA_Parent_Asset;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
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
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(I_AD_UserInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_User_ID(foreignEntity.get_ID());
		} else {
			super.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public I_AD_UserInput AD_User() {
		return mAD_User;
	}

	/**
	 * Set Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	@JsonProperty("C_Activity")
	public void setC_ActivityInput(I_C_ActivityInput C_Activity) {
		this.mC_Activity = C_Activity;
		MActivity foreignEntity;
		if (C_Activity != null &&
				(foreignEntity = new Query(getCtx(), MActivity.Table_Name, MActivity.COLUMNNAME_C_Activity_UU + "=?", get_TrxName())
						.setParameters(C_Activity.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Activity_ID(foreignEntity.get_ID());
		} else {
			super.setC_Activity_ID(0);
		}
	}

	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	@JsonProperty("C_Activity")
	public I_C_ActivityInput C_Activity() {
		return mC_Activity;
	}

	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(I_C_BPartnerInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartner_ID(foreignEntity.get_ID());
		} else {
			super.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public I_C_BPartnerInput C_BPartner() {
		return mC_BPartner;
	}

	/**
	 * Set Partner Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	@JsonProperty("C_BPartner_Location")
	public void setC_BPartner_LocationInput(I_C_BPartner_LocationInput C_BPartner_Location) {
		this.mC_BPartner_Location = C_BPartner_Location;
		MBPartnerLocation foreignEntity;
		if (C_BPartner_Location != null &&
				(foreignEntity = new Query(getCtx(), MBPartnerLocation.Table_Name, MBPartnerLocation.COLUMNNAME_C_BPartner_Location_UU + "=?", get_TrxName())
						.setParameters(C_BPartner_Location.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartner_Location_ID(foreignEntity.get_ID());
		} else {
			super.setC_BPartner_Location_ID(0);
		}
	}

	/**
	 * Get Partner Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	@JsonProperty("C_BPartner_Location")
	public I_C_BPartner_LocationInput C_BPartner_Location() {
		return mC_BPartner_Location;
	}

	/**
	 * Set BPartner (Agent).
	 *
	 * @param C_BPartnerSR Business Partner (Agent or Sales Rep)
	 */
	@JsonProperty("C_BPartnerSR")
	public void setC_BPartnerSRInput(I_C_BPartnerInput C_BPartnerSR) {
		this.mC_BPartnerSR = C_BPartnerSR;
		MBPartner_BH foreignEntity;
		if (C_BPartnerSR != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartnerSR.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartnerSR_ID(foreignEntity.get_ID());
		} else {
			super.setC_BPartnerSR_ID(0);
		}
	}

	/**
	 * Get BPartner (Agent).
	 *
	 * @return Business Partner (Agent or Sales Rep)
	 */
	@JsonProperty("C_BPartnerSR")
	public I_C_BPartnerInput C_BPartnerSR() {
		return mC_BPartnerSR;
	}

	/**
	 * Set Address.
	 *
	 * @param C_Location Location or Address
	 */
	@JsonProperty("C_Location")
	public void setC_LocationInput(I_C_LocationInput C_Location) {
		this.mC_Location = C_Location;
		MLocation foreignEntity;
		if (C_Location != null &&
				(foreignEntity = new Query(getCtx(), MLocation.Table_Name, MLocation.COLUMNNAME_C_Location_UU + "=?", get_TrxName())
						.setParameters(C_Location.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Location_ID(foreignEntity.get_ID());
		} else {
			super.setC_Location_ID(0);
		}
	}

	/**
	 * Get Address.
	 *
	 * @return Location or Address
	 */
	@JsonProperty("C_Location")
	public I_C_LocationInput C_Location() {
		return mC_Location;
	}

	/**
	 * Set Project.
	 *
	 * @param C_Project Financial Project
	 */
	@JsonProperty("C_Project")
	public void setC_ProjectInput(I_C_ProjectInput C_Project) {
		this.mC_Project = C_Project;
		MProject foreignEntity;
		if (C_Project != null &&
				(foreignEntity = new Query(getCtx(), MProject.Table_Name, MProject.COLUMNNAME_C_Project_UU + "=?", get_TrxName())
						.setParameters(C_Project.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Project_ID(foreignEntity.get_ID());
		} else {
			super.setC_Project_ID(0);
		}
	}

	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	@JsonProperty("C_Project")
	public I_C_ProjectInput C_Project() {
		return mC_Project;
	}
	/**
	 * Set Fully depreciated.
	 *
	 * @param IsFullyDepreciated The asset is fully depreciated
	 */

	public void setIsFullyDepreciated(boolean IsFullyDepreciated) {
		if (get_ID() == 0) {
			super.setIsFullyDepreciated(IsFullyDepreciated);
		}
	}

	/**
	 * Set Lessor.
	 *
	 * @param Lease_BPartner The Business Partner who rents or leases
	 */
	@JsonProperty("Lease_BPartner")
	public void setLease_BPartnerInput(I_C_BPartnerInput Lease_BPartner) {
		this.mLease_BPartner = Lease_BPartner;
		MBPartner_BH foreignEntity;
		if (Lease_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(Lease_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setLease_BPartner_ID(foreignEntity.get_ID());
		} else {
			super.setLease_BPartner_ID(0);
		}
	}

	/**
	 * Get Lessor.
	 *
	 * @return The Business Partner who rents or leases
	 */
	@JsonProperty("Lease_BPartner")
	public I_C_BPartnerInput Lease_BPartner() {
		return mLease_BPartner;
	}

	/**
	 * Set Attribute Set Instance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstance")
	public void setM_AttributeSetInstanceInput(I_M_AttributeSetInstanceInput M_AttributeSetInstance) {
		this.mM_AttributeSetInstance = M_AttributeSetInstance;
		MAttributeSetInstance_BH foreignEntity;
		if (get_ID() == 0 &&M_AttributeSetInstance != null &&
				(foreignEntity = new Query(getCtx(), MAttributeSetInstance_BH.Table_Name, MAttributeSetInstance_BH.COLUMNNAME_M_AttributeSetInstance_UU + "=?", get_TrxName())
						.setParameters(M_AttributeSetInstance.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstance")
	public I_M_AttributeSetInstanceInput M_AttributeSetInstance() {
		return mM_AttributeSetInstance;
	}

	/**
	 * Set Shipment/Receipt Line.
	 *
	 * @param M_InOutLine Line on Shipment or Receipt document
	 */
	@JsonProperty("M_InOutLine")
	public void setM_InOutLineInput(I_M_InOutLineInput M_InOutLine) {
		this.mM_InOutLine = M_InOutLine;
		MInOutLine foreignEntity;
		if (M_InOutLine != null &&
				(foreignEntity = new Query(getCtx(), MInOutLine.Table_Name, MInOutLine.COLUMNNAME_M_InOutLine_UU + "=?", get_TrxName())
						.setParameters(M_InOutLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_InOutLine_ID(foreignEntity.get_ID());
		} else {
			super.setM_InOutLine_ID(0);
		}
	}

	/**
	 * Get Shipment/Receipt Line.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	@JsonProperty("M_InOutLine")
	public I_M_InOutLineInput M_InOutLine() {
		return mM_InOutLine;
	}

	/**
	 * Set Locator.
	 *
	 * @param M_Locator Warehouse Locator
	 */
	@JsonProperty("M_Locator")
	public void setM_LocatorInput(I_M_LocatorInput M_Locator) {
		this.mM_Locator = M_Locator;
		MLocator foreignEntity;
		if (M_Locator != null &&
				(foreignEntity = new Query(getCtx(), MLocator.Table_Name, MLocator.COLUMNNAME_M_Locator_UU + "=?", get_TrxName())
						.setParameters(M_Locator.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Locator_ID(foreignEntity.get_ID());
		} else {
			super.setM_Locator_ID(0);
		}
	}

	/**
	 * Get Locator.
	 *
	 * @return Warehouse Locator
	 */
	@JsonProperty("M_Locator")
	public I_M_LocatorInput M_Locator() {
		return mM_Locator;
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(I_M_ProductInput M_Product) {
		this.mM_Product = M_Product;
		MProduct_BH foreignEntity;
		if (M_Product != null &&
				(foreignEntity = new Query(getCtx(), MProduct_BH.Table_Name, MProduct_BH.COLUMNNAME_M_Product_UU + "=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Product_ID(foreignEntity.get_ID());
		} else {
			super.setM_Product_ID(0);
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public I_M_ProductInput M_Product() {
		return mM_Product;
	}
	/**
	 * Set Use units.
	 *
	 * @param UseUnits Currently used units of the assets
	 */

	public void setUseUnits(int UseUnits) {
		if (get_ID() == 0) {
			super.setUseUnits(UseUnits);
		}
	}
}
