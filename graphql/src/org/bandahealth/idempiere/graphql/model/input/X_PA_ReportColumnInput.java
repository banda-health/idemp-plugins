package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MCampaign;
import org.compiere.model.MCurrency;
import org.compiere.model.MElementValue;
import org.compiere.model.MLocation;
import org.compiere.model.MOrg;
import org.compiere.model.MProject;
import org.compiere.model.MRefList;
import org.compiere.model.MSalesRegion;
import org.compiere.model.Query;
import org.compiere.model.X_GL_Budget;
import org.compiere.model.X_PA_ReportColumn;
import org.compiere.model.X_PA_ReportColumnSet;
import org.compiere.util.Env;

/**
 * Generated Model for PA_ReportColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportColumnInput extends X_PA_ReportColumn implements I_PA_ReportColumnInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput CalculationType_RL;
	 private I_AD_Ref_ListInput ColumnType_RL;
	 private I_AD_Ref_ListInput CurrencyType_RL;
	 private I_AD_Ref_ListInput ElementType_RL;
	 private I_AD_Ref_ListInput Factor_RL;
	 private I_AD_Ref_ListInput PAAmountType_RL;
	 private I_AD_Ref_ListInput PAPeriodType_RL;
	 private I_AD_Ref_ListInput PostingType_RL;
	 private I_C_ActivityInput C_Activity;
	 private I_C_BPartnerInput C_BPartner;
	 private I_C_CampaignInput C_Campaign;
	 private I_C_CurrencyInput C_Currency;
	 private I_C_ElementValueInput C_ElementValue;
	 private I_C_LocationInput C_Location;
	 private I_C_ProjectInput C_Project;
	 private I_C_SalesRegionInput C_SalesRegion;
	 private I_GL_BudgetInput GL_Budget;
	 private I_M_ProductInput M_Product;
	 private I_PA_ReportColumnInput Oper_1;
	 private I_PA_ReportColumnInput Oper_2;
	 private I_PA_ReportColumnSetInput PA_ReportColumnSet;

	/**
	 * Standard constructor
	 */
	public X_PA_ReportColumnInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
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
	 * Set Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	public void setC_Campaign(I_C_CampaignInput C_Campaign) {
		this.C_Campaign = C_Campaign;
		MCampaign foreignEntity;
		if (C_Campaign != null &&
				(foreignEntity = new Query(getCtx(), MCampaign.Table_Name, MCampaign.COLUMNNAME_C_Campaign_UU + "=?", get_TrxName())
						.setParameters(C_Campaign.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Campaign_ID(foreignEntity.get_ID());
		} else {
			this.setC_Campaign_ID(0);
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
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	public void setC_Currency(I_C_CurrencyInput C_Currency) {
		this.C_Currency = C_Currency;
		MCurrency foreignEntity;
		if (C_Currency != null &&
				(foreignEntity = new Query(getCtx(), MCurrency.Table_Name, MCurrency.COLUMNNAME_C_Currency_UU + "=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Currency_ID(foreignEntity.get_ID());
		} else {
			this.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public I_C_CurrencyInput getC_Currency() {
		return C_Currency;
	}

	/**
	 * Set Account Element.
	 *
	 * @param C_ElementValue Account Element
	 */
	public void setC_ElementValue(I_C_ElementValueInput C_ElementValue) {
		this.C_ElementValue = C_ElementValue;
		MElementValue foreignEntity;
		if (C_ElementValue != null &&
				(foreignEntity = new Query(getCtx(), MElementValue.Table_Name, MElementValue.COLUMNNAME_C_ElementValue_UU + "=?", get_TrxName())
						.setParameters(C_ElementValue.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_ElementValue_ID(foreignEntity.get_ID());
		} else {
			this.setC_ElementValue_ID(0);
		}
	}

	/**
	 * Get Account Element.
	 *
	 * @return Account Element
	 */
	public I_C_ElementValueInput getC_ElementValue() {
		return C_ElementValue;
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
	 * Set Sales Region.
	 *
	 * @param C_SalesRegion Sales coverage region
	 */
	public void setC_SalesRegion(I_C_SalesRegionInput C_SalesRegion) {
		this.C_SalesRegion = C_SalesRegion;
		MSalesRegion foreignEntity;
		if (C_SalesRegion != null &&
				(foreignEntity = new Query(getCtx(), MSalesRegion.Table_Name, MSalesRegion.COLUMNNAME_C_SalesRegion_UU + "=?", get_TrxName())
						.setParameters(C_SalesRegion.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_SalesRegion_ID(foreignEntity.get_ID());
		} else {
			this.setC_SalesRegion_ID(0);
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
	 * Set Calculation.
	 *
	 * @param CalculationType_RL Calculation
	 */
	public void setCalculationType_RL(I_AD_Ref_ListInput CalculationType_RL) {
		this.CalculationType_RL = CalculationType_RL;
		MRefList foreignEntity;
		if (CalculationType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CalculationType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setCalculationType(foreignEntity.getValue());
		} else {
			this.setCalculationType(null);
		}
	}

	/**
	 * Get Calculation.
	 *
	 * @return Calculation
	 */
	public I_AD_Ref_ListInput getCalculationType_RL() {
		return CalculationType_RL;
	}

	/**
	 * Set Column Type.
	 *
	 * @param ColumnType_RL Column Type
	 */
	public void setColumnType_RL(I_AD_Ref_ListInput ColumnType_RL) {
		this.ColumnType_RL = ColumnType_RL;
		MRefList foreignEntity;
		if (ColumnType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ColumnType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setColumnType(foreignEntity.getValue());
		} else {
			this.setColumnType(null);
		}
	}

	/**
	 * Get Column Type.
	 *
	 * @return Column Type
	 */
	public I_AD_Ref_ListInput getColumnType_RL() {
		return ColumnType_RL;
	}

	/**
	 * Set Currency Type.
	 *
	 * @param CurrencyType_RL Currency Type
	 */
	public void setCurrencyType_RL(I_AD_Ref_ListInput CurrencyType_RL) {
		this.CurrencyType_RL = CurrencyType_RL;
		MRefList foreignEntity;
		if (CurrencyType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CurrencyType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setCurrencyType(foreignEntity.getValue());
		} else {
			this.setCurrencyType(null);
		}
	}

	/**
	 * Get Currency Type.
	 *
	 * @return Currency Type
	 */
	public I_AD_Ref_ListInput getCurrencyType_RL() {
		return CurrencyType_RL;
	}

	/**
	 * Set Type.
	 *
	 * @param ElementType_RL Element Type (account or user defined)
	 */
	public void setElementType_RL(I_AD_Ref_ListInput ElementType_RL) {
		this.ElementType_RL = ElementType_RL;
		MRefList foreignEntity;
		if (ElementType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ElementType_RL.getID())
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
	public I_AD_Ref_ListInput getElementType_RL() {
		return ElementType_RL;
	}

	/**
	 * Set Factor.
	 *
	 * @param Factor_RL Scaling factor.
	 */
	public void setFactor_RL(I_AD_Ref_ListInput Factor_RL) {
		this.Factor_RL = Factor_RL;
		MRefList foreignEntity;
		if (Factor_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(Factor_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setFactor(foreignEntity.getValue());
		} else {
			this.setFactor(null);
		}
	}

	/**
	 * Get Factor.
	 *
	 * @return Scaling factor.
	 */
	public I_AD_Ref_ListInput getFactor_RL() {
		return Factor_RL;
	}

	/**
	 * Set Budget.
	 *
	 * @param GL_Budget General Ledger Budget
	 */
	public void setGL_Budget(I_GL_BudgetInput GL_Budget) {
		this.GL_Budget = GL_Budget;
		X_GL_Budget foreignEntity;
		if (GL_Budget != null &&
				(foreignEntity = new Query(getCtx(), X_GL_Budget.Table_Name, X_GL_Budget.COLUMNNAME_GL_Budget_UU + "=?", get_TrxName())
						.setParameters(GL_Budget.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setGL_Budget_ID(foreignEntity.get_ID());
		} else {
			this.setGL_Budget_ID(0);
		}
	}

	/**
	 * Get Budget.
	 *
	 * @return General Ledger Budget
	 */
	public I_GL_BudgetInput getGL_Budget() {
		return GL_Budget;
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
	 * Set Operand 1.
	 *
	 * @param Oper_1 First operand for calculation
	 */
	public void setOper_1(I_PA_ReportColumnInput Oper_1) {
		this.Oper_1 = Oper_1;
		X_PA_ReportColumn foreignEntity;
		if (Oper_1 != null &&
				(foreignEntity = new Query(getCtx(), X_PA_ReportColumn.Table_Name, X_PA_ReportColumn.COLUMNNAME_PA_ReportColumn_UU + "=?", get_TrxName())
						.setParameters(Oper_1.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setOper_1_ID(foreignEntity.get_ID());
		} else {
			this.setOper_1_ID(0);
		}
	}

	/**
	 * Get Operand 1.
	 *
	 * @return First operand for calculation
	 */
	public I_PA_ReportColumnInput getOper_1() {
		return Oper_1;
	}
	/**
	 * Set Operand 1.
	 *
	 * @param Oper_1_ID First operand for calculation
	 */

	public void setOper_1_ID(int Oper_1_ID) {
		if (get_ID() == 0) {
			super.setOper_1_ID(Oper_1_ID);
		}
	}

	/**
	 * Set Operand 2.
	 *
	 * @param Oper_2 Second operand for calculation
	 */
	public void setOper_2(I_PA_ReportColumnInput Oper_2) {
		this.Oper_2 = Oper_2;
		X_PA_ReportColumn foreignEntity;
		if (Oper_2 != null &&
				(foreignEntity = new Query(getCtx(), X_PA_ReportColumn.Table_Name, X_PA_ReportColumn.COLUMNNAME_PA_ReportColumn_UU + "=?", get_TrxName())
						.setParameters(Oper_2.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setOper_2_ID(foreignEntity.get_ID());
		} else {
			this.setOper_2_ID(0);
		}
	}

	/**
	 * Get Operand 2.
	 *
	 * @return Second operand for calculation
	 */
	public I_PA_ReportColumnInput getOper_2() {
		return Oper_2;
	}
	/**
	 * Set Operand 2.
	 *
	 * @param Oper_2_ID Second operand for calculation
	 */

	public void setOper_2_ID(int Oper_2_ID) {
		if (get_ID() == 0) {
			super.setOper_2_ID(Oper_2_ID);
		}
	}
	/**
	 * Set Report Column.
	 *
	 * @param PA_ReportColumn_ID Column in Report
	 */

	public void setPA_ReportColumn_ID(int PA_ReportColumn_ID) {
		if (get_ID() == 0) {
			super.setPA_ReportColumn_ID(PA_ReportColumn_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPA_ReportColumn_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPA_ReportColumn_UU();
	}

	/**
	 * Set Report Column Set.
	 *
	 * @param PA_ReportColumnSet Collection of Columns for Report
	 */
	public void setPA_ReportColumnSet(I_PA_ReportColumnSetInput PA_ReportColumnSet) {
		this.PA_ReportColumnSet = PA_ReportColumnSet;
		X_PA_ReportColumnSet foreignEntity;
		if (get_ID() == 0 &&PA_ReportColumnSet != null &&
				(foreignEntity = new Query(getCtx(), X_PA_ReportColumnSet.Table_Name, X_PA_ReportColumnSet.COLUMNNAME_PA_ReportColumnSet_UU + "=?", get_TrxName())
						.setParameters(PA_ReportColumnSet.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPA_ReportColumnSet_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Report Column Set.
	 *
	 * @return Collection of Columns for Report
	 */
	public I_PA_ReportColumnSetInput getPA_ReportColumnSet() {
		return PA_ReportColumnSet;
	}
	/**
	 * Set Report Column Set.
	 *
	 * @param PA_ReportColumnSet_ID Collection of Columns for Report
	 */

	public void setPA_ReportColumnSet_ID(int PA_ReportColumnSet_ID) {
		if (get_ID() == 0) {
			super.setPA_ReportColumnSet_ID(PA_ReportColumnSet_ID);
		}
	}

	/**
	 * Set Amount Type.
	 *
	 * @param PAAmountType_RL PA Amount Type for reporting
	 */
	public void setPAAmountType_RL(I_AD_Ref_ListInput PAAmountType_RL) {
		this.PAAmountType_RL = PAAmountType_RL;
		MRefList foreignEntity;
		if (PAAmountType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PAAmountType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPAAmountType(foreignEntity.getValue());
		} else {
			this.setPAAmountType(null);
		}
	}

	/**
	 * Get Amount Type.
	 *
	 * @return PA Amount Type for reporting
	 */
	public I_AD_Ref_ListInput getPAAmountType_RL() {
		return PAAmountType_RL;
	}

	/**
	 * Set Period Type.
	 *
	 * @param PAPeriodType_RL PA Period Type
	 */
	public void setPAPeriodType_RL(I_AD_Ref_ListInput PAPeriodType_RL) {
		this.PAPeriodType_RL = PAPeriodType_RL;
		MRefList foreignEntity;
		if (PAPeriodType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PAPeriodType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPAPeriodType(foreignEntity.getValue());
		} else {
			this.setPAPeriodType(null);
		}
	}

	/**
	 * Get Period Type.
	 *
	 * @return PA Period Type
	 */
	public I_AD_Ref_ListInput getPAPeriodType_RL() {
		return PAPeriodType_RL;
	}

	/**
	 * Set PostingType.
	 *
	 * @param PostingType_RL The type of posted amount for the transaction
	 */
	public void setPostingType_RL(I_AD_Ref_ListInput PostingType_RL) {
		this.PostingType_RL = PostingType_RL;
		MRefList foreignEntity;
		if (PostingType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PostingType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPostingType(foreignEntity.getValue());
		} else {
			this.setPostingType(null);
		}
	}

	/**
	 * Get PostingType.
	 *
	 * @return The type of posted amount for the transaction
	 */
	public I_AD_Ref_ListInput getPostingType_RL() {
		return PostingType_RL;
	}
}
