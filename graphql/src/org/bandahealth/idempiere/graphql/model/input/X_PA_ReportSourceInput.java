package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MCampaign;
import org.compiere.model.MElementValue;
import org.compiere.model.MLocation;
import org.compiere.model.MOrg;
import org.compiere.model.MProject;
import org.compiere.model.MSalesRegion;
import org.compiere.model.Query;
import org.compiere.model.X_PA_ReportLine;
import org.compiere.model.X_PA_ReportSource;
import org.compiere.util.Env;

/**
 * Generated Model for PA_ReportSource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportSourceInput extends X_PA_ReportSource implements I_PA_ReportSourceInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_AD_Ref_ListInput mElementType;
	 private I_C_ActivityInput mC_Activity;
	 private I_C_BPartnerInput mC_BPartner;
	 private I_C_CampaignInput mC_Campaign;
	 private I_C_ElementValueInput mC_ElementValue;
	 private I_C_LocationInput mC_Location;
	 private I_C_ProjectInput mC_Project;
	 private I_C_SalesRegionInput mC_SalesRegion;
	 private I_M_ProductInput mM_Product;
	 private I_PA_ReportLineInput mPA_ReportLine;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_PA_ReportSourceInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
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
	 * Set Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	@JsonProperty("C_Campaign")
	public void setC_CampaignInput(I_C_CampaignInput C_Campaign) {
		this.mC_Campaign = C_Campaign;
		MCampaign foreignEntity;
		if (C_Campaign != null &&
				(foreignEntity = new Query(getCtx(), MCampaign.Table_Name, MCampaign.COLUMNNAME_C_Campaign_UU + "=?", get_TrxName())
						.setParameters(C_Campaign.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Campaign_ID(foreignEntity.get_ID());
		} else {
			super.setC_Campaign_ID(0);
		}
	}

	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	@JsonProperty("C_Campaign")
	public I_C_CampaignInput C_Campaign() {
		return mC_Campaign;
	}

	/**
	 * Set Account Element.
	 *
	 * @param C_ElementValue Account Element
	 */
	@JsonProperty("C_ElementValue")
	public void setC_ElementValueInput(I_C_ElementValueInput C_ElementValue) {
		this.mC_ElementValue = C_ElementValue;
		MElementValue foreignEntity;
		if (C_ElementValue != null &&
				(foreignEntity = new Query(getCtx(), MElementValue.Table_Name, MElementValue.COLUMNNAME_C_ElementValue_UU + "=?", get_TrxName())
						.setParameters(C_ElementValue.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ElementValue_ID(foreignEntity.get_ID());
		} else {
			super.setC_ElementValue_ID(0);
		}
	}

	/**
	 * Get Account Element.
	 *
	 * @return Account Element
	 */
	@JsonProperty("C_ElementValue")
	public I_C_ElementValueInput C_ElementValue() {
		return mC_ElementValue;
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
	 * Set Sales Region.
	 *
	 * @param C_SalesRegion Sales coverage region
	 */
	@JsonProperty("C_SalesRegion")
	public void setC_SalesRegionInput(I_C_SalesRegionInput C_SalesRegion) {
		this.mC_SalesRegion = C_SalesRegion;
		MSalesRegion foreignEntity;
		if (C_SalesRegion != null &&
				(foreignEntity = new Query(getCtx(), MSalesRegion.Table_Name, MSalesRegion.COLUMNNAME_C_SalesRegion_UU + "=?", get_TrxName())
						.setParameters(C_SalesRegion.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_SalesRegion_ID(foreignEntity.get_ID());
		} else {
			super.setC_SalesRegion_ID(0);
		}
	}

	/**
	 * Get Sales Region.
	 *
	 * @return Sales coverage region
	 */
	@JsonProperty("C_SalesRegion")
	public I_C_SalesRegionInput C_SalesRegion() {
		return mC_SalesRegion;
	}

	/**
	 * Set Type.
	 *
	 * @param ElementType Element Type (account or user defined)
	 */
	@JsonProperty("ElementType")
	public void setElementTypeInput(I_AD_Ref_ListInput ElementType) {
		this.mElementType = ElementType;
		MRefList_BH foreignEntity;
		if (ElementType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ElementType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setElementType(foreignEntity.getValue());
		} else {
			this.setElementType(null);
		}
	}

	/**
	 * Get Type.
	 *
	 * @return Element Type (account or user defined)
	 */
	@JsonProperty("ElementType")
	public I_AD_Ref_ListInput ElementType() {
		return mElementType;
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
	 * Set Report Line.
	 *
	 * @param PA_ReportLine Report Line
	 */
	@JsonProperty("PA_ReportLine")
	public void setPA_ReportLineInput(I_PA_ReportLineInput PA_ReportLine) {
		this.mPA_ReportLine = PA_ReportLine;
		X_PA_ReportLine foreignEntity;
		if (get_ID() == 0 &&PA_ReportLine != null &&
				(foreignEntity = new Query(getCtx(), X_PA_ReportLine.Table_Name, X_PA_ReportLine.COLUMNNAME_PA_ReportLine_UU + "=?", get_TrxName())
						.setParameters(PA_ReportLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPA_ReportLine_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Report Line.
	 *
	 * @return Report Line
	 */
	@JsonProperty("PA_ReportLine")
	public I_PA_ReportLineInput PA_ReportLine() {
		return mPA_ReportLine;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPA_ReportSource_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPA_ReportSource_UU();
	}
}
