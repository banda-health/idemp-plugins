package org.bandahealth.idempiere.graphql.model.input;

import java.sql.Timestamp;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
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
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_A_Asset;
import org.compiere.util.Env;

/**
 * Generated Model for A_Asset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_AssetInput extends X_A_Asset implements I_A_AssetInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput A_Asset_Action_RL;
	 private I_AD_Ref_ListInput A_Asset_Status_RL;
	 private I_AD_UserInput AD_User;
	 private I_A_AssetInput A_Parent_Asset;
	 private I_A_Asset_ClassInput A_Asset_Class;
	 private I_A_Asset_GroupInput A_Asset_Group;
	 private I_A_Asset_TypeInput A_Asset_Type;
	 private I_C_ActivityInput C_Activity;
	 private I_C_BPartnerInput C_BPartner;
	 private I_C_BPartnerInput C_BPartnerSR;
	 private I_C_BPartnerInput Lease_BPartner;
	 private I_C_BPartner_LocationInput C_BPartner_Location;
	 private I_C_LocationInput C_Location;
	 private I_C_ProjectInput C_Project;
	 private I_M_AttributeSetInstanceInput M_AttributeSetInstance;
	 private I_M_InOutLineInput M_InOutLine;
	 private I_M_LocatorInput M_Locator;
	 private I_M_ProductInput M_Product;

	/**
	 * Standard constructor
	 */
	public X_A_AssetInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Asset Action.
	 *
	 * @param A_Asset_Action_RL Asset Action
	 */
	public void setA_Asset_Action_RL(I_AD_Ref_ListInput A_Asset_Action_RL) {
		this.A_Asset_Action_RL = A_Asset_Action_RL;
		MRefList foreignEntity;
		if (A_Asset_Action_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Action_RL.getID())
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
	public I_AD_Ref_ListInput getA_Asset_Action_RL() {
		return A_Asset_Action_RL;
	}

	/**
	 * Set Asset class.
	 *
	 * @param A_Asset_Class Asset class
	 */
	public void setA_Asset_Class(I_A_Asset_ClassInput A_Asset_Class) {
		this.A_Asset_Class = A_Asset_Class;
		MAssetClass foreignEntity;
		if (A_Asset_Class != null &&
				(foreignEntity = new Query(getCtx(), MAssetClass.Table_Name, MAssetClass.COLUMNNAME_A_Asset_Class_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Class.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_Class_ID(foreignEntity.get_ID());
		} else {
			this.setA_Asset_Class_ID(0);
		}
	}

	/**
	 * Get Asset class.
	 *
	 * @return Asset class
	 */
	public I_A_Asset_ClassInput getA_Asset_Class() {
		return A_Asset_Class;
	}
	/**
	 * Set Asset class.
	 *
	 * @param A_Asset_Class_ID Asset class
	 */

	public void setA_Asset_Class_ID(int A_Asset_Class_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_Class_ID(A_Asset_Class_ID);
		}
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
	public void setA_Asset_Group(I_A_Asset_GroupInput A_Asset_Group) {
		this.A_Asset_Group = A_Asset_Group;
		MAssetGroup foreignEntity;
		if (A_Asset_Group != null &&
				(foreignEntity = new Query(getCtx(), MAssetGroup.Table_Name, MAssetGroup.COLUMNNAME_A_Asset_Group_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Group.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_Group_ID(foreignEntity.get_ID());
		} else {
			this.setA_Asset_Group_ID(0);
		}
	}

	/**
	 * Get Asset Group.
	 *
	 * @return Group of Assets
	 */
	public I_A_Asset_GroupInput getA_Asset_Group() {
		return A_Asset_Group;
	}
	/**
	 * Set Asset Group.
	 *
	 * @param A_Asset_Group_ID Group of Assets
	 */

	public void setA_Asset_Group_ID(int A_Asset_Group_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_Group_ID(A_Asset_Group_ID);
		}
	}
	/**
	 * Set Asset.
	 *
	 * @param A_Asset_ID Asset used internally or by customers
	 */

	public void setA_Asset_ID(int A_Asset_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_ID(A_Asset_ID);
		}
	}

	/**
	 * Set Asset Status.
	 *
	 * @param A_Asset_Status_RL Asset Status
	 */
	public void setA_Asset_Status_RL(I_AD_Ref_ListInput A_Asset_Status_RL) {
		this.A_Asset_Status_RL = A_Asset_Status_RL;
		MRefList foreignEntity;
		if (A_Asset_Status_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Status_RL.getID())
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
	public I_AD_Ref_ListInput getA_Asset_Status_RL() {
		return A_Asset_Status_RL;
	}

	/**
	 * Set Asset Type.
	 *
	 * @param A_Asset_Type Asset Type
	 */
	public void setA_Asset_Type(I_A_Asset_TypeInput A_Asset_Type) {
		this.A_Asset_Type = A_Asset_Type;
		MAssetType foreignEntity;
		if (A_Asset_Type != null &&
				(foreignEntity = new Query(getCtx(), MAssetType.Table_Name, MAssetType.COLUMNNAME_A_Asset_Type_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Type.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_Type_ID(foreignEntity.get_ID());
		} else {
			this.setA_Asset_Type_ID(0);
		}
	}

	/**
	 * Get Asset Type.
	 *
	 * @return Asset Type
	 */
	public I_A_Asset_TypeInput getA_Asset_Type() {
		return A_Asset_Type;
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
	public void setA_Parent_Asset(I_A_AssetInput A_Parent_Asset) {
		this.A_Parent_Asset = A_Parent_Asset;
		MAsset foreignEntity;
		if (A_Parent_Asset != null &&
				(foreignEntity = new Query(getCtx(), MAsset.Table_Name, MAsset.COLUMNNAME_A_Asset_UU + "=?", get_TrxName())
						.setParameters(A_Parent_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Parent_Asset_ID(foreignEntity.get_ID());
		} else {
			this.setA_Parent_Asset_ID(0);
		}
	}

	/**
	 * Get Parent Asset.
	 *
	 * @return Parent Asset
	 */
	public I_A_AssetInput getA_Parent_Asset() {
		return A_Parent_Asset;
	}
	/**
	 * Set Parent Asset.
	 *
	 * @param A_Parent_Asset_ID Parent Asset
	 */

	public void setA_Parent_Asset_ID(int A_Parent_Asset_ID) {
		if (get_ID() == 0) {
			super.setA_Parent_Asset_ID(A_Parent_Asset_ID);
		}
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	public void setAD_User(I_AD_UserInput AD_User) {
		this.AD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_User_ID(foreignEntity.get_ID());
		} else {
			this.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public I_AD_UserInput getAD_User() {
		return AD_User;
	}

	/**
	 * Set Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	public void setC_Activity(I_C_ActivityInput C_Activity) {
		this.C_Activity = C_Activity;
		MActivity foreignEntity;
		if (C_Activity != null &&
				(foreignEntity = new Query(getCtx(), MActivity.Table_Name, MActivity.COLUMNNAME_C_Activity_UU + "=?", get_TrxName())
						.setParameters(C_Activity.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Activity_ID(foreignEntity.get_ID());
		} else {
			this.setC_Activity_ID(0);
		}
	}

	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public I_C_ActivityInput getC_Activity() {
		return C_Activity;
	}

	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	public void setC_BPartner(I_C_BPartnerInput C_BPartner) {
		this.C_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BPartner_ID(foreignEntity.get_ID());
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public I_C_BPartnerInput getC_BPartner() {
		return C_BPartner;
	}

	/**
	 * Set Partner Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	public void setC_BPartner_Location(I_C_BPartner_LocationInput C_BPartner_Location) {
		this.C_BPartner_Location = C_BPartner_Location;
		MBPartnerLocation foreignEntity;
		if (C_BPartner_Location != null &&
				(foreignEntity = new Query(getCtx(), MBPartnerLocation.Table_Name, MBPartnerLocation.COLUMNNAME_C_BPartner_Location_UU + "=?", get_TrxName())
						.setParameters(C_BPartner_Location.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BPartner_Location_ID(foreignEntity.get_ID());
		} else {
			this.setC_BPartner_Location_ID(0);
		}
	}

	/**
	 * Get Partner Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	public I_C_BPartner_LocationInput getC_BPartner_Location() {
		return C_BPartner_Location;
	}

	/**
	 * Set BPartner (Agent).
	 *
	 * @param C_BPartnerSR Business Partner (Agent or Sales Rep)
	 */
	public void setC_BPartnerSR(I_C_BPartnerInput C_BPartnerSR) {
		this.C_BPartnerSR = C_BPartnerSR;
		MBPartner_BH foreignEntity;
		if (C_BPartnerSR != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartnerSR.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BPartnerSR_ID(foreignEntity.get_ID());
		} else {
			this.setC_BPartnerSR_ID(0);
		}
	}

	/**
	 * Get BPartner (Agent).
	 *
	 * @return Business Partner (Agent or Sales Rep)
	 */
	public I_C_BPartnerInput getC_BPartnerSR() {
		return C_BPartnerSR;
	}
	/**
	 * Set BPartner (Agent).
	 *
	 * @param C_BPartnerSR_ID Business Partner (Agent or Sales Rep)
	 */

	public void setC_BPartnerSR_ID(int C_BPartnerSR_ID) {
		if (get_ID() == 0) {
			super.setC_BPartnerSR_ID(C_BPartnerSR_ID);
		}
	}

	/**
	 * Set Address.
	 *
	 * @param C_Location Location or Address
	 */
	public void setC_Location(I_C_LocationInput C_Location) {
		this.C_Location = C_Location;
		MLocation foreignEntity;
		if (C_Location != null &&
				(foreignEntity = new Query(getCtx(), MLocation.Table_Name, MLocation.COLUMNNAME_C_Location_UU + "=?", get_TrxName())
						.setParameters(C_Location.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Location_ID(foreignEntity.get_ID());
		} else {
			this.setC_Location_ID(0);
		}
	}

	/**
	 * Get Address.
	 *
	 * @return Location or Address
	 */
	public I_C_LocationInput getC_Location() {
		return C_Location;
	}

	/**
	 * Set Project.
	 *
	 * @param C_Project Financial Project
	 */
	public void setC_Project(I_C_ProjectInput C_Project) {
		this.C_Project = C_Project;
		MProject foreignEntity;
		if (C_Project != null &&
				(foreignEntity = new Query(getCtx(), MProject.Table_Name, MProject.COLUMNNAME_C_Project_UU + "=?", get_TrxName())
						.setParameters(C_Project.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Project_ID(foreignEntity.get_ID());
		} else {
			this.setC_Project_ID(0);
		}
	}

	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public I_C_ProjectInput getC_Project() {
		return C_Project;
	}
	/**
	 * Set Project.
	 *
	 * @param C_Project_ID Financial Project
	 */

	public void setC_Project_ID(int C_Project_ID) {
		if (get_ID() == 0) {
			super.setC_Project_ID(C_Project_ID);
		}
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
	public void setLease_BPartner(I_C_BPartnerInput Lease_BPartner) {
		this.Lease_BPartner = Lease_BPartner;
		MBPartner_BH foreignEntity;
		if (Lease_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(Lease_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setLease_BPartner_ID(foreignEntity.get_ID());
		} else {
			this.setLease_BPartner_ID(0);
		}
	}

	/**
	 * Get Lessor.
	 *
	 * @return The Business Partner who rents or leases
	 */
	public I_C_BPartnerInput getLease_BPartner() {
		return Lease_BPartner;
	}
	/**
	 * Set Lessor.
	 *
	 * @param Lease_BPartner_ID The Business Partner who rents or leases
	 */

	public void setLease_BPartner_ID(int Lease_BPartner_ID) {
		if (get_ID() == 0) {
			super.setLease_BPartner_ID(Lease_BPartner_ID);
		}
	}

	/**
	 * Set Attribute Set Instance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	public void setM_AttributeSetInstance(I_M_AttributeSetInstanceInput M_AttributeSetInstance) {
		this.M_AttributeSetInstance = M_AttributeSetInstance;
		MAttributeSetInstance_BH foreignEntity;
		if (get_ID() == 0 &&M_AttributeSetInstance != null &&
				(foreignEntity = new Query(getCtx(), MAttributeSetInstance_BH.Table_Name, MAttributeSetInstance_BH.COLUMNNAME_M_AttributeSetInstance_UU + "=?", get_TrxName())
						.setParameters(M_AttributeSetInstance.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public I_M_AttributeSetInstanceInput getM_AttributeSetInstance() {
		return M_AttributeSetInstance;
	}
	/**
	 * Set Attribute Set Instance.
	 *
	 * @param M_AttributeSetInstance_ID Product Attribute Set Instance
	 */

	public void setM_AttributeSetInstance_ID(int M_AttributeSetInstance_ID) {
		if (get_ID() == 0) {
			super.setM_AttributeSetInstance_ID(M_AttributeSetInstance_ID);
		}
	}

	/**
	 * Set Shipment/Receipt Line.
	 *
	 * @param M_InOutLine Line on Shipment or Receipt document
	 */
	public void setM_InOutLine(I_M_InOutLineInput M_InOutLine) {
		this.M_InOutLine = M_InOutLine;
		MInOutLine foreignEntity;
		if (M_InOutLine != null &&
				(foreignEntity = new Query(getCtx(), MInOutLine.Table_Name, MInOutLine.COLUMNNAME_M_InOutLine_UU + "=?", get_TrxName())
						.setParameters(M_InOutLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_InOutLine_ID(foreignEntity.get_ID());
		} else {
			this.setM_InOutLine_ID(0);
		}
	}

	/**
	 * Get Shipment/Receipt Line.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	public I_M_InOutLineInput getM_InOutLine() {
		return M_InOutLine;
	}

	/**
	 * Set Locator.
	 *
	 * @param M_Locator Warehouse Locator
	 */
	public void setM_Locator(I_M_LocatorInput M_Locator) {
		this.M_Locator = M_Locator;
		MLocator foreignEntity;
		if (M_Locator != null &&
				(foreignEntity = new Query(getCtx(), MLocator.Table_Name, MLocator.COLUMNNAME_M_Locator_UU + "=?", get_TrxName())
						.setParameters(M_Locator.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Locator_ID(foreignEntity.get_ID());
		} else {
			this.setM_Locator_ID(0);
		}
	}

	/**
	 * Get Locator.
	 *
	 * @return Warehouse Locator
	 */
	public I_M_LocatorInput getM_Locator() {
		return M_Locator;
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	public void setM_Product(I_M_ProductInput M_Product) {
		this.M_Product = M_Product;
		MProduct_BH foreignEntity;
		if (M_Product != null &&
				(foreignEntity = new Query(getCtx(), MProduct_BH.Table_Name, MProduct_BH.COLUMNNAME_M_Product_UU + "=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Product_ID(foreignEntity.get_ID());
		} else {
			this.setM_Product_ID(0);
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public I_M_ProductInput getM_Product() {
		return M_Product;
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
