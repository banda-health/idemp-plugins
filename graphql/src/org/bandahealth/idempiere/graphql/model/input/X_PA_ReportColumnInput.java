package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
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
import org.compiere.model.X_GL_Budget;
import org.compiere.model.X_PA_ReportColumn;
import org.compiere.model.X_PA_ReportColumnSet;

import java.sql.ResultSet;

/**
 * Generated Model for PA_ReportColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportColumnInput extends X_PA_ReportColumn implements I_PA_ReportColumnInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Activity;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_Campaign;
	private ForeignEntityInput mC_Currency;
	private ForeignEntityInput mC_ElementValue;
	private ForeignEntityInput mC_Location;
	private ForeignEntityInput mC_Project;
	private ForeignEntityInput mC_SalesRegion;
	private ForeignEntityInput mGL_Budget;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mOper_1;
	private ForeignEntityInput mOper_2;
	private ForeignEntityInput mPA_ReportColumnSet;
	private I_AD_Ref_ListInput mCalculationType;
	private I_AD_Ref_ListInput mColumnType;
	private I_AD_Ref_ListInput mCurrencyType;
	private I_AD_Ref_ListInput mElementType;
	private I_AD_Ref_ListInput mFactor;
	private I_AD_Ref_ListInput mPAAmountType;
	private I_AD_Ref_ListInput mPAPeriodType;
	private I_AD_Ref_ListInput mPostingType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_PA_ReportColumnInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_PA_ReportColumn(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
	 * Set Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	@JsonProperty("C_Activity")
	public void setC_ActivityInput(ForeignEntityInput C_Activity) {
		this.mC_Activity = C_Activity;
		MActivity foreignEntity;
		if (C_Activity != null &&
				(foreignEntity = new Query(getCtx(), "C_Activity", "C_Activity_UU=?", get_TrxName())
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
	public ForeignEntityInput C_Activity() {
		return mC_Activity;
	}

	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
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
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
	}

	/**
	 * Set Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	@JsonProperty("C_Campaign")
	public void setC_CampaignInput(ForeignEntityInput C_Campaign) {
		this.mC_Campaign = C_Campaign;
		MCampaign foreignEntity;
		if (C_Campaign != null &&
				(foreignEntity = new Query(getCtx(), "C_Campaign", "C_Campaign_UU=?", get_TrxName())
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
	public ForeignEntityInput C_Campaign() {
		return mC_Campaign;
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(ForeignEntityInput C_Currency) {
		this.mC_Currency = C_Currency;
		MCurrency_BH foreignEntity;
		if (C_Currency != null &&
				(foreignEntity = new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Currency_ID(foreignEntity.get_ID());
		} else {
			super.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public ForeignEntityInput C_Currency() {
		return mC_Currency;
	}

	/**
	 * Set Account Element.
	 *
	 * @param C_ElementValue Account Element
	 */
	@JsonProperty("C_ElementValue")
	public void setC_ElementValueInput(ForeignEntityInput C_ElementValue) {
		this.mC_ElementValue = C_ElementValue;
		MElementValue foreignEntity;
		if (C_ElementValue != null &&
				(foreignEntity = new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
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
	public ForeignEntityInput C_ElementValue() {
		return mC_ElementValue;
	}

	/**
	 * Set Address.
	 *
	 * @param C_Location Location or Address
	 */
	@JsonProperty("C_Location")
	public void setC_LocationInput(ForeignEntityInput C_Location) {
		this.mC_Location = C_Location;
		MLocation foreignEntity;
		if (C_Location != null &&
				(foreignEntity = new Query(getCtx(), "C_Location", "C_Location_UU=?", get_TrxName())
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
	public ForeignEntityInput C_Location() {
		return mC_Location;
	}

	/**
	 * Set Project.
	 *
	 * @param C_Project Financial Project
	 */
	@JsonProperty("C_Project")
	public void setC_ProjectInput(ForeignEntityInput C_Project) {
		this.mC_Project = C_Project;
		MProject foreignEntity;
		if (C_Project != null &&
				(foreignEntity = new Query(getCtx(), "C_Project", "C_Project_UU=?", get_TrxName())
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
	public ForeignEntityInput C_Project() {
		return mC_Project;
	}

	/**
	 * Set Sales Region.
	 *
	 * @param C_SalesRegion Sales coverage region
	 */
	@JsonProperty("C_SalesRegion")
	public void setC_SalesRegionInput(ForeignEntityInput C_SalesRegion) {
		this.mC_SalesRegion = C_SalesRegion;
		MSalesRegion foreignEntity;
		if (C_SalesRegion != null &&
				(foreignEntity = new Query(getCtx(), "C_SalesRegion", "C_SalesRegion_UU=?", get_TrxName())
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
	public ForeignEntityInput C_SalesRegion() {
		return mC_SalesRegion;
	}

	/**
	 * Set Calculation.
	 *
	 * @param CalculationType Calculation
	 */
	@JsonProperty("CalculationType")
	public void setCalculationTypeInput(I_AD_Ref_ListInput CalculationType) {
		this.mCalculationType = CalculationType;
		MRefList_BH foreignEntity;
		if (CalculationType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CalculationType.getID())
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
	@JsonProperty("CalculationType")
	public I_AD_Ref_ListInput CalculationType() {
		return mCalculationType;
	}

	/**
	 * Set Column Type.
	 *
	 * @param ColumnType Column Type
	 */
	@JsonProperty("ColumnType")
	public void setColumnTypeInput(I_AD_Ref_ListInput ColumnType) {
		this.mColumnType = ColumnType;
		MRefList_BH foreignEntity;
		if (ColumnType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ColumnType.getID())
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
	@JsonProperty("ColumnType")
	public I_AD_Ref_ListInput ColumnType() {
		return mColumnType;
	}

	/**
	 * Set Currency Type.
	 *
	 * @param CurrencyType Currency Type
	 */
	@JsonProperty("CurrencyType")
	public void setCurrencyTypeInput(I_AD_Ref_ListInput CurrencyType) {
		this.mCurrencyType = CurrencyType;
		MRefList_BH foreignEntity;
		if (CurrencyType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CurrencyType.getID())
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
	@JsonProperty("CurrencyType")
	public I_AD_Ref_ListInput CurrencyType() {
		return mCurrencyType;
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
	 * Set Factor.
	 *
	 * @param Factor Scaling factor.
	 */
	@JsonProperty("Factor")
	public void setFactorInput(I_AD_Ref_ListInput Factor) {
		this.mFactor = Factor;
		MRefList_BH foreignEntity;
		if (Factor != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(Factor.getID())
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
	@JsonProperty("Factor")
	public I_AD_Ref_ListInput Factor() {
		return mFactor;
	}

	/**
	 * Set Budget.
	 *
	 * @param GL_Budget General Ledger Budget
	 */
	@JsonProperty("GL_Budget")
	public void setGL_BudgetInput(ForeignEntityInput GL_Budget) {
		this.mGL_Budget = GL_Budget;
		X_GL_Budget foreignEntity;
		if (GL_Budget != null &&
				(foreignEntity = new Query(getCtx(), "GL_Budget", "GL_Budget_UU=?", get_TrxName())
						.setParameters(GL_Budget.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setGL_Budget_ID(foreignEntity.get_ID());
		} else {
			super.setGL_Budget_ID(0);
		}
	}

	/**
	 * Get Budget.
	 *
	 * @return General Ledger Budget
	 */
	@JsonProperty("GL_Budget")
	public ForeignEntityInput GL_Budget() {
		return mGL_Budget;
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		MProduct_BH foreignEntity;
		if (M_Product != null &&
				(foreignEntity = new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
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
	public ForeignEntityInput M_Product() {
		return mM_Product;
	}

	/**
	 * Set Operand 1.
	 *
	 * @param Oper_1 First operand for calculation
	 */
	@JsonProperty("Oper_1")
	public void setOper_1Input(ForeignEntityInput Oper_1) {
		this.mOper_1 = Oper_1;
		X_PA_ReportColumn foreignEntity;
		if (Oper_1 != null &&
				(foreignEntity = new Query(getCtx(), "PA_ReportColumn", "PA_ReportColumn_UU=?", get_TrxName())
						.setParameters(Oper_1.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setOper_1_ID(foreignEntity.get_ID());
		} else {
			super.setOper_1_ID(0);
		}
	}

	/**
	 * Get Operand 1.
	 *
	 * @return First operand for calculation
	 */
	@JsonProperty("Oper_1")
	public ForeignEntityInput Oper_1() {
		return mOper_1;
	}

	/**
	 * Set Operand 2.
	 *
	 * @param Oper_2 Second operand for calculation
	 */
	@JsonProperty("Oper_2")
	public void setOper_2Input(ForeignEntityInput Oper_2) {
		this.mOper_2 = Oper_2;
		X_PA_ReportColumn foreignEntity;
		if (Oper_2 != null &&
				(foreignEntity = new Query(getCtx(), "PA_ReportColumn", "PA_ReportColumn_UU=?", get_TrxName())
						.setParameters(Oper_2.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setOper_2_ID(foreignEntity.get_ID());
		} else {
			super.setOper_2_ID(0);
		}
	}

	/**
	 * Get Operand 2.
	 *
	 * @return Second operand for calculation
	 */
	@JsonProperty("Oper_2")
	public ForeignEntityInput Oper_2() {
		return mOper_2;
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
	@JsonProperty("PA_ReportColumnSet")
	public void setPA_ReportColumnSetInput(ForeignEntityInput PA_ReportColumnSet) {
		this.mPA_ReportColumnSet = PA_ReportColumnSet;
		X_PA_ReportColumnSet foreignEntity;
		if (get_ID() == 0 && PA_ReportColumnSet != null &&
				(foreignEntity = new Query(getCtx(), "PA_ReportColumnSet", "PA_ReportColumnSet_UU=?", get_TrxName())
						.setParameters(PA_ReportColumnSet.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPA_ReportColumnSet_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Report Column Set.
	 *
	 * @return Collection of Columns for Report
	 */
	@JsonProperty("PA_ReportColumnSet")
	public ForeignEntityInput PA_ReportColumnSet() {
		return mPA_ReportColumnSet;
	}

	/**
	 * Set Amount Type.
	 *
	 * @param PAAmountType PA Amount Type for reporting
	 */
	@JsonProperty("PAAmountType")
	public void setPAAmountTypeInput(I_AD_Ref_ListInput PAAmountType) {
		this.mPAAmountType = PAAmountType;
		MRefList_BH foreignEntity;
		if (PAAmountType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PAAmountType.getID())
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
	@JsonProperty("PAAmountType")
	public I_AD_Ref_ListInput PAAmountType() {
		return mPAAmountType;
	}

	/**
	 * Set Period Type.
	 *
	 * @param PAPeriodType PA Period Type
	 */
	@JsonProperty("PAPeriodType")
	public void setPAPeriodTypeInput(I_AD_Ref_ListInput PAPeriodType) {
		this.mPAPeriodType = PAPeriodType;
		MRefList_BH foreignEntity;
		if (PAPeriodType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PAPeriodType.getID())
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
	@JsonProperty("PAPeriodType")
	public I_AD_Ref_ListInput PAPeriodType() {
		return mPAPeriodType;
	}

	/**
	 * Set PostingType.
	 *
	 * @param PostingType The type of posted amount for the transaction
	 */
	@JsonProperty("PostingType")
	public void setPostingTypeInput(I_AD_Ref_ListInput PostingType) {
		this.mPostingType = PostingType;
		MRefList_BH foreignEntity;
		if (PostingType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PostingType.getID())
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
	@JsonProperty("PostingType")
	public I_AD_Ref_ListInput PostingType() {
		return mPostingType;
	}
}
