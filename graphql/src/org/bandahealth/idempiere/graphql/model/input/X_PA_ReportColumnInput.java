package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_PA_ReportColumnResolver;
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
import org.compiere.report.MReportColumn;
import org.compiere.report.MReportColumnSet;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for PA_ReportColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_ReportColumnInput extends MReportColumn implements I_PA_ReportColumnInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Activity;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_Campaign;
	private ForeignEntityInput mC_Currency;
	private ForeignEntityInput mC_ElementValue;
	private ForeignEntityInput mC_Location;
	private ForeignEntityInput mC_Project;
	private ForeignEntityInput mC_SalesRegion;
	private ForeignEntityInput mCalculationType;
	private ForeignEntityInput mColumnType;
	private ForeignEntityInput mCurrencyType;
	private ForeignEntityInput mElementType;
	private ForeignEntityInput mFactor;
	private ForeignEntityInput mGL_Budget;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mOper_1;
	private ForeignEntityInput mOper_2;
	private ForeignEntityInput mPAAmountType;
	private ForeignEntityInput mPAPeriodType;
	private ForeignEntityInput mPA_ReportColumnSet;
	private ForeignEntityInput mPostingType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The PA_ReportColumn_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_PA_ReportColumnInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
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
		if (C_Activity != null) {
			// Since an entity was passed, make sure it's in the DB
			MActivity foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Activity", "C_Activity_UU=?", get_TrxName())
							.setParameters(C_Activity.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Activity_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Activity with UU " + C_Activity.getUU());
			}
		} else {
			this.setC_Activity_ID(0);
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
	 * Set Business Partner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		if (C_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UU " + C_BPartner.getUU());
			}
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner.
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
		if (C_Campaign != null) {
			// Since an entity was passed, make sure it's in the DB
			MCampaign foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Campaign", "C_Campaign_UU=?", get_TrxName())
							.setParameters(C_Campaign.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Campaign_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Campaign with UU " + C_Campaign.getUU());
			}
		} else {
			this.setC_Campaign_ID(0);
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
		if (C_Currency != null) {
			// Since an entity was passed, make sure it's in the DB
			MCurrency_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
							.setParameters(C_Currency.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Currency_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UU " + C_Currency.getUU());
			}
		} else {
			this.setC_Currency_ID(0);
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
		if (C_ElementValue != null) {
			// Since an entity was passed, make sure it's in the DB
			MElementValue foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
							.setParameters(C_ElementValue.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_ElementValue_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ElementValue with UU " + C_ElementValue.getUU());
			}
		} else {
			this.setC_ElementValue_ID(0);
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
		if (C_Location != null) {
			// Since an entity was passed, make sure it's in the DB
			MLocation foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Location", "C_Location_UU=?", get_TrxName())
							.setParameters(C_Location.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Location_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Location with UU " + C_Location.getUU());
			}
		} else {
			this.setC_Location_ID(0);
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
		if (C_Project != null) {
			// Since an entity was passed, make sure it's in the DB
			MProject foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Project", "C_Project_UU=?", get_TrxName())
							.setParameters(C_Project.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Project_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Project with UU " + C_Project.getUU());
			}
		} else {
			this.setC_Project_ID(0);
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
		if (C_SalesRegion != null) {
			// Since an entity was passed, make sure it's in the DB
			MSalesRegion foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_SalesRegion", "C_SalesRegion_UU=?", get_TrxName())
							.setParameters(C_SalesRegion.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_SalesRegion_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_SalesRegion with UU " + C_SalesRegion.getUU());
			}
		} else {
			this.setC_SalesRegion_ID(0);
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
	public void setCalculationTypeInput(ForeignEntityInput CalculationType) {
		this.mCalculationType = CalculationType;
		if (CalculationType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_PA_ReportColumnResolver.CALCULATIONTYPE_UUIDS_BY_VALUE.containsValue(CalculationType.getUU())) {
				throw new AdempiereException("The reference list UU of " + CalculationType.getUU() +
						" is not in the list defined for the CalculationType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(CalculationType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCalculationType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + CalculationType.getUU());
			}
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
	public ForeignEntityInput CalculationType() {
		return mCalculationType;
	}

	/**
	 * Set Column Type.
	 *
	 * @param ColumnType Column Type
	 */
	@JsonProperty("ColumnType")
	public void setColumnTypeInput(ForeignEntityInput ColumnType) {
		this.mColumnType = ColumnType;
		if (ColumnType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_PA_ReportColumnResolver.COLUMNTYPE_UUIDS_BY_VALUE.containsValue(ColumnType.getUU())) {
				throw new AdempiereException("The reference list UU of " + ColumnType.getUU() +
						" is not in the list defined for the ColumnType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ColumnType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setColumnType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + ColumnType.getUU());
			}
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
	public ForeignEntityInput ColumnType() {
		return mColumnType;
	}

	/**
	 * Set Currency Type.
	 *
	 * @param CurrencyType Currency Type
	 */
	@JsonProperty("CurrencyType")
	public void setCurrencyTypeInput(ForeignEntityInput CurrencyType) {
		this.mCurrencyType = CurrencyType;
		if (CurrencyType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_PA_ReportColumnResolver.CURRENCYTYPE_UUIDS_BY_VALUE.containsValue(CurrencyType.getUU())) {
				throw new AdempiereException("The reference list UU of " + CurrencyType.getUU() +
						" is not in the list defined for the CurrencyType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(CurrencyType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCurrencyType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + CurrencyType.getUU());
			}
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
	public ForeignEntityInput CurrencyType() {
		return mCurrencyType;
	}

	/**
	 * Set Type.
	 *
	 * @param ElementType Element Type (account or user defined)
	 */
	@JsonProperty("ElementType")
	public void setElementTypeInput(ForeignEntityInput ElementType) {
		this.mElementType = ElementType;
		if (ElementType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_PA_ReportColumnResolver.ELEMENTTYPE_UUIDS_BY_VALUE.containsValue(ElementType.getUU())) {
				throw new AdempiereException("The reference list UU of " + ElementType.getUU() +
						" is not in the list defined for the ElementType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ElementType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setElementType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + ElementType.getUU());
			}
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
	public ForeignEntityInput ElementType() {
		return mElementType;
	}

	/**
	 * Set Factor.
	 *
	 * @param Factor Scaling factor.
	 */
	@JsonProperty("Factor")
	public void setFactorInput(ForeignEntityInput Factor) {
		this.mFactor = Factor;
		if (Factor != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_PA_ReportColumnResolver.FACTOR_UUIDS_BY_VALUE.containsValue(Factor.getUU())) {
				throw new AdempiereException("The reference list UU of " + Factor.getUU() +
						" is not in the list defined for the Factor column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Factor.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setFactor(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + Factor.getUU());
			}
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
	public ForeignEntityInput Factor() {
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
		if (GL_Budget != null) {
			// Since an entity was passed, make sure it's in the DB
			X_GL_Budget foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "GL_Budget", "GL_Budget_UU=?", get_TrxName())
							.setParameters(GL_Budget.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setGL_Budget_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table GL_Budget with UU " + GL_Budget.getUU());
			}
		} else {
			this.setGL_Budget_ID(0);
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
		if (M_Product != null) {
			// Since an entity was passed, make sure it's in the DB
			MProduct_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_Product.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UU " + M_Product.getUU());
			}
		} else {
			this.setM_Product_ID(0);
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
		if (Oper_1 != null) {
			// Since an entity was passed, make sure it's in the DB
			MReportColumn foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_ReportColumn", "PA_ReportColumn_UU=?", get_TrxName())
							.setParameters(Oper_1.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setOper_1_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_ReportColumn with UU " + Oper_1.getUU());
			}
		} else {
			this.setOper_1_ID(0);
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
		if (Oper_2 != null) {
			// Since an entity was passed, make sure it's in the DB
			MReportColumn foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_ReportColumn", "PA_ReportColumn_UU=?", get_TrxName())
							.setParameters(Oper_2.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setOper_2_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_ReportColumn with UU " + Oper_2.getUU());
			}
		} else {
			this.setOper_2_ID(0);
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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setPA_ReportColumn_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (get_ID() != 0) {
			return;
		}
		if (PA_ReportColumnSet != null) {
			// Since an entity was passed, make sure it's in the DB
			MReportColumnSet foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_ReportColumnSet", "PA_ReportColumnSet_UU=?", get_TrxName())
							.setParameters(PA_ReportColumnSet.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPA_ReportColumnSet_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_ReportColumnSet with UU " + PA_ReportColumnSet.getUU());
			}
		} else {
			this.setPA_ReportColumnSet_ID(0);
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
	public void setPAAmountTypeInput(ForeignEntityInput PAAmountType) {
		this.mPAAmountType = PAAmountType;
		if (PAAmountType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_PA_ReportColumnResolver.PAAMOUNTTYPE_UUIDS_BY_VALUE.containsValue(PAAmountType.getUU())) {
				throw new AdempiereException("The reference list UU of " + PAAmountType.getUU() +
						" is not in the list defined for the PAAmountType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PAAmountType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPAAmountType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + PAAmountType.getUU());
			}
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
	public ForeignEntityInput PAAmountType() {
		return mPAAmountType;
	}

	/**
	 * Set Period Type.
	 *
	 * @param PAPeriodType PA Period Type
	 */
	@JsonProperty("PAPeriodType")
	public void setPAPeriodTypeInput(ForeignEntityInput PAPeriodType) {
		this.mPAPeriodType = PAPeriodType;
		if (PAPeriodType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_PA_ReportColumnResolver.PAPERIODTYPE_UUIDS_BY_VALUE.containsValue(PAPeriodType.getUU())) {
				throw new AdempiereException("The reference list UU of " + PAPeriodType.getUU() +
						" is not in the list defined for the PAPeriodType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PAPeriodType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPAPeriodType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + PAPeriodType.getUU());
			}
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
	public ForeignEntityInput PAPeriodType() {
		return mPAPeriodType;
	}

	/**
	 * Set Posting Type.
	 *
	 * @param PostingType The type of posted amount for the transaction
	 */
	@JsonProperty("PostingType")
	public void setPostingTypeInput(ForeignEntityInput PostingType) {
		this.mPostingType = PostingType;
		if (PostingType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_PA_ReportColumnResolver.POSTINGTYPE_UUIDS_BY_VALUE.containsValue(PostingType.getUU())) {
				throw new AdempiereException("The reference list UU of " + PostingType.getUU() +
						" is not in the list defined for the PostingType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PostingType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPostingType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + PostingType.getUU());
			}
		} else {
			this.setPostingType(null);
		}
	}

	/**
	 * Get Posting Type.
	 *
	 * @return The type of posted amount for the transaction
	 */
	@JsonProperty("PostingType")
	public ForeignEntityInput PostingType() {
		return mPostingType;
	}
}
