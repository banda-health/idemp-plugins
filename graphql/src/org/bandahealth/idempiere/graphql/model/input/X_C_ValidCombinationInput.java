package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MActivity;
import org.compiere.model.MCampaign;
import org.compiere.model.MElementValue;
import org.compiere.model.MLocation;
import org.compiere.model.MOrg;
import org.compiere.model.MProject;
import org.compiere.model.MSalesRegion;
import org.compiere.model.Query;
import org.compiere.model.X_C_SubAcct;
import org.compiere.util.Env;

/**
 * Generated Model for C_ValidCombination - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ValidCombinationInput extends MAccount implements I_C_ValidCombinationInput {

	 private I_AD_OrgInput AD_Org;
	 private I_C_AcctSchemaInput C_AcctSchema;
	 private I_C_ActivityInput C_Activity;
	 private I_C_BPartnerInput C_BPartner;
	 private I_C_CampaignInput C_Campaign;
	 private I_C_ElementValueInput Account;
	 private I_C_ElementValueInput User1;
	 private I_C_ElementValueInput User2;
	 private I_C_LocationInput C_LocFrom;
	 private I_C_LocationInput C_LocTo;
	 private I_C_ProjectInput C_Project;
	 private I_C_SalesRegionInput C_SalesRegion;
	 private I_C_SubAcctInput C_SubAcct;
	 private I_M_ProductInput M_Product;

	/**
	 * Standard constructor
	 */
	public X_C_ValidCombinationInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Account.
	 *
	 * @param Account Account used
	 */
	public void setAccount(I_C_ElementValueInput Account) {
		this.Account = Account;
		MElementValue foreignEntity;
		if (get_ID() == 0 &&Account != null &&
				(foreignEntity = new Query(getCtx(), MElementValue.Table_Name, MElementValue.COLUMNNAME_C_ElementValue_UU + "=?", get_TrxName())
						.setParameters(Account.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAccount_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Account.
	 *
	 * @return Account used
	 */
	public I_C_ElementValueInput getAccount() {
		return Account;
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
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	public void setC_AcctSchema(I_C_AcctSchemaInput C_AcctSchema) {
		this.C_AcctSchema = C_AcctSchema;
		MAcctSchema foreignEntity;
		if (get_ID() == 0 &&C_AcctSchema != null &&
				(foreignEntity = new Query(getCtx(), MAcctSchema.Table_Name, MAcctSchema.COLUMNNAME_C_AcctSchema_UU + "=?", get_TrxName())
						.setParameters(C_AcctSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_AcctSchema_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public I_C_AcctSchemaInput getC_AcctSchema() {
		return C_AcctSchema;
	}

	/**
	 * Set Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	public void setC_Activity(I_C_ActivityInput C_Activity) {
		this.C_Activity = C_Activity;
		MActivity foreignEntity;
		if (get_ID() == 0 &&C_Activity != null &&
				(foreignEntity = new Query(getCtx(), MActivity.Table_Name, MActivity.COLUMNNAME_C_Activity_UU + "=?", get_TrxName())
						.setParameters(C_Activity.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Activity_ID(foreignEntity.get_ID());
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
		if (get_ID() == 0 &&C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BPartner_ID(foreignEntity.get_ID());
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
	 * Set Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	public void setC_Campaign(I_C_CampaignInput C_Campaign) {
		this.C_Campaign = C_Campaign;
		MCampaign foreignEntity;
		if (get_ID() == 0 &&C_Campaign != null &&
				(foreignEntity = new Query(getCtx(), MCampaign.Table_Name, MCampaign.COLUMNNAME_C_Campaign_UU + "=?", get_TrxName())
						.setParameters(C_Campaign.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Campaign_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	public I_C_CampaignInput getC_Campaign() {
		return C_Campaign;
	}

	/**
	 * Set Location From.
	 *
	 * @param C_LocFrom Location that inventory was moved from
	 */
	public void setC_LocFrom(I_C_LocationInput C_LocFrom) {
		this.C_LocFrom = C_LocFrom;
		MLocation foreignEntity;
		if (get_ID() == 0 &&C_LocFrom != null &&
				(foreignEntity = new Query(getCtx(), MLocation.Table_Name, MLocation.COLUMNNAME_C_Location_UU + "=?", get_TrxName())
						.setParameters(C_LocFrom.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_LocFrom_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Location From.
	 *
	 * @return Location that inventory was moved from
	 */
	public I_C_LocationInput getC_LocFrom() {
		return C_LocFrom;
	}

	/**
	 * Set Location To.
	 *
	 * @param C_LocTo Location that inventory was moved to
	 */
	public void setC_LocTo(I_C_LocationInput C_LocTo) {
		this.C_LocTo = C_LocTo;
		MLocation foreignEntity;
		if (get_ID() == 0 &&C_LocTo != null &&
				(foreignEntity = new Query(getCtx(), MLocation.Table_Name, MLocation.COLUMNNAME_C_Location_UU + "=?", get_TrxName())
						.setParameters(C_LocTo.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_LocTo_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Location To.
	 *
	 * @return Location that inventory was moved to
	 */
	public I_C_LocationInput getC_LocTo() {
		return C_LocTo;
	}

	/**
	 * Set Project.
	 *
	 * @param C_Project Financial Project
	 */
	public void setC_Project(I_C_ProjectInput C_Project) {
		this.C_Project = C_Project;
		MProject foreignEntity;
		if (get_ID() == 0 &&C_Project != null &&
				(foreignEntity = new Query(getCtx(), MProject.Table_Name, MProject.COLUMNNAME_C_Project_UU + "=?", get_TrxName())
						.setParameters(C_Project.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Project_ID(foreignEntity.get_ID());
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
	 * Set Sales Region.
	 *
	 * @param C_SalesRegion Sales coverage region
	 */
	public void setC_SalesRegion(I_C_SalesRegionInput C_SalesRegion) {
		this.C_SalesRegion = C_SalesRegion;
		MSalesRegion foreignEntity;
		if (get_ID() == 0 &&C_SalesRegion != null &&
				(foreignEntity = new Query(getCtx(), MSalesRegion.Table_Name, MSalesRegion.COLUMNNAME_C_SalesRegion_UU + "=?", get_TrxName())
						.setParameters(C_SalesRegion.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_SalesRegion_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Sales Region.
	 *
	 * @return Sales coverage region
	 */
	public I_C_SalesRegionInput getC_SalesRegion() {
		return C_SalesRegion;
	}

	/**
	 * Set Sub Account.
	 *
	 * @param C_SubAcct Sub account for Element Value
	 */
	public void setC_SubAcct(I_C_SubAcctInput C_SubAcct) {
		this.C_SubAcct = C_SubAcct;
		X_C_SubAcct foreignEntity;
		if (get_ID() == 0 &&C_SubAcct != null &&
				(foreignEntity = new Query(getCtx(), X_C_SubAcct.Table_Name, X_C_SubAcct.COLUMNNAME_C_SubAcct_UU + "=?", get_TrxName())
						.setParameters(C_SubAcct.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_SubAcct_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Sub Account.
	 *
	 * @return Sub account for Element Value
	 */
	public I_C_SubAcctInput getC_SubAcct() {
		return C_SubAcct;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_ValidCombination_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_ValidCombination_UU();
	}
	/**
	 * Set Combination.
	 *
	 * @param Combination Unique combination of account elements
	 */
	public void setCombination(String Combination) {
		if (get_ID() == 0) {
			super.setCombination(Combination);
		}
	}
	/**
	 * Set Description.
	 *
	 * @param Description Optional short description of the record
	 */
	public void setDescription(String Description) {
		if (get_ID() == 0) {
			super.setDescription(Description);
		}
	}
	/**
	 * Set Fully Qualified.
	 *
	 * @param IsFullyQualified This account is fully qualified
	 */
	public void setIsFullyQualified(boolean IsFullyQualified) {
		if (get_ID() == 0) {
			super.setIsFullyQualified(IsFullyQualified);
		}
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	public void setM_Product(I_M_ProductInput M_Product) {
		this.M_Product = M_Product;
		MProduct_BH foreignEntity;
		if (get_ID() == 0 &&M_Product != null &&
				(foreignEntity = new Query(getCtx(), MProduct_BH.Table_Name, MProduct_BH.COLUMNNAME_M_Product_UU + "=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Product_ID(foreignEntity.get_ID());
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
	 * Set User Element List 1.
	 *
	 * @param User1 User defined list element #1
	 */
	public void setUser1(I_C_ElementValueInput User1) {
		this.User1 = User1;
		MElementValue foreignEntity;
		if (get_ID() == 0 &&User1 != null &&
				(foreignEntity = new Query(getCtx(), MElementValue.Table_Name, MElementValue.COLUMNNAME_C_ElementValue_UU + "=?", get_TrxName())
						.setParameters(User1.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setUser1_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	public I_C_ElementValueInput getUser1() {
		return User1;
	}

	/**
	 * Set User Element List 2.
	 *
	 * @param User2 User defined list element #2
	 */
	public void setUser2(I_C_ElementValueInput User2) {
		this.User2 = User2;
		MElementValue foreignEntity;
		if (get_ID() == 0 &&User2 != null &&
				(foreignEntity = new Query(getCtx(), MElementValue.Table_Name, MElementValue.COLUMNNAME_C_ElementValue_UU + "=?", get_TrxName())
						.setParameters(User2.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setUser2_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get User Element List 2.
	 *
	 * @return User defined list element #2
	 */
	public I_C_ElementValueInput getUser2() {
		return User2;
	}
}
