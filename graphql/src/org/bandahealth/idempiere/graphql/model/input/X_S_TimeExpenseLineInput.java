package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MInvoiceLine_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MCampaign;
import org.compiere.model.MOrg;
import org.compiere.model.MProject;
import org.compiere.model.MProjectPhase;
import org.compiere.model.MProjectTask;
import org.compiere.model.MResourceAssignment;
import org.compiere.model.MTimeExpense;
import org.compiere.model.MTimeExpenseLine;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.model.X_S_TimeType;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for S_TimeExpenseLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_S_TimeExpenseLineInput extends MTimeExpenseLine implements I_S_TimeExpenseLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Activity;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_Campaign;
	private ForeignEntityInput mC_Currency;
	private ForeignEntityInput mC_InvoiceLine;
	private ForeignEntityInput mC_OrderLine;
	private ForeignEntityInput mC_Project;
	private ForeignEntityInput mC_ProjectPhase;
	private ForeignEntityInput mC_ProjectTask;
	private ForeignEntityInput mC_UOM;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mS_ResourceAssignment;
	private ForeignEntityInput mS_TimeExpense;
	private ForeignEntityInput mS_TimeType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The S_TimeExpenseLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_S_TimeExpenseLineInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MTimeExpenseLine(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
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
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
		if (C_Activity != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Activity", "C_Activity_UU=?", get_TrxName())
							.setParameters(C_Activity.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Activity_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Activity with UUID " + C_Activity.getUUID());
			}
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
		if (C_BPartner != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + C_BPartner.getUUID());
			}
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
		if (C_Campaign != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Campaign", "C_Campaign_UU=?", get_TrxName())
							.setParameters(C_Campaign.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Campaign_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Campaign with UUID " + C_Campaign.getUUID());
			}
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
		if (C_Currency != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
							.setParameters(C_Currency.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Currency_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UUID " + C_Currency.getUUID());
			}
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
	 * Set Invoice Line.
	 *
	 * @param C_InvoiceLine Invoice Detail Line
	 */
	@JsonProperty("C_InvoiceLine")
	public void setC_InvoiceLineInput(ForeignEntityInput C_InvoiceLine) {
		this.mC_InvoiceLine = C_InvoiceLine;
		MInvoiceLine_BH foreignEntity;
		if (get_ID() == 0 && C_InvoiceLine != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_InvoiceLine", "C_InvoiceLine_UU=?", get_TrxName())
							.setParameters(C_InvoiceLine.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_InvoiceLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_InvoiceLine with UUID " + C_InvoiceLine.getUUID());
			}
		}
	}

	/**
	 * Get Invoice Line.
	 *
	 * @return Invoice Detail Line
	 */
	@JsonProperty("C_InvoiceLine")
	public ForeignEntityInput C_InvoiceLine() {
		return mC_InvoiceLine;
	}

	/**
	 * Set Sales Order Line.
	 *
	 * @param C_OrderLine Sales Order Line
	 */
	@JsonProperty("C_OrderLine")
	public void setC_OrderLineInput(ForeignEntityInput C_OrderLine) {
		this.mC_OrderLine = C_OrderLine;
		MOrderLine_BH foreignEntity;
		if (get_ID() == 0 && C_OrderLine != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_OrderLine", "C_OrderLine_UU=?", get_TrxName())
							.setParameters(C_OrderLine.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_OrderLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_OrderLine with UUID " + C_OrderLine.getUUID());
			}
		}
	}

	/**
	 * Get Sales Order Line.
	 *
	 * @return Sales Order Line
	 */
	@JsonProperty("C_OrderLine")
	public ForeignEntityInput C_OrderLine() {
		return mC_OrderLine;
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
		if (C_Project != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Project", "C_Project_UU=?", get_TrxName())
							.setParameters(C_Project.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Project_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Project with UUID " + C_Project.getUUID());
			}
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
	 * Set Project Phase.
	 *
	 * @param C_ProjectPhase Phase of a Project
	 */
	@JsonProperty("C_ProjectPhase")
	public void setC_ProjectPhaseInput(ForeignEntityInput C_ProjectPhase) {
		this.mC_ProjectPhase = C_ProjectPhase;
		MProjectPhase foreignEntity;
		if (C_ProjectPhase != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_ProjectPhase", "C_ProjectPhase_UU=?", get_TrxName())
							.setParameters(C_ProjectPhase.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_ProjectPhase_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ProjectPhase with UUID " + C_ProjectPhase.getUUID());
			}
		} else {
			super.setC_ProjectPhase_ID(0);
		}
	}

	/**
	 * Get Project Phase.
	 *
	 * @return Phase of a Project
	 */
	@JsonProperty("C_ProjectPhase")
	public ForeignEntityInput C_ProjectPhase() {
		return mC_ProjectPhase;
	}

	/**
	 * Set Project Task.
	 *
	 * @param C_ProjectTask Actual Project Task in a Phase
	 */
	@JsonProperty("C_ProjectTask")
	public void setC_ProjectTaskInput(ForeignEntityInput C_ProjectTask) {
		this.mC_ProjectTask = C_ProjectTask;
		MProjectTask foreignEntity;
		if (C_ProjectTask != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_ProjectTask", "C_ProjectTask_UU=?", get_TrxName())
							.setParameters(C_ProjectTask.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_ProjectTask_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ProjectTask with UUID " + C_ProjectTask.getUUID());
			}
		} else {
			super.setC_ProjectTask_ID(0);
		}
	}

	/**
	 * Get Project Task.
	 *
	 * @return Actual Project Task in a Phase
	 */
	@JsonProperty("C_ProjectTask")
	public ForeignEntityInput C_ProjectTask() {
		return mC_ProjectTask;
	}

	/**
	 * Set UOM.
	 *
	 * @param C_UOM Unit of Measure
	 */
	@JsonProperty("C_UOM")
	public void setC_UOMInput(ForeignEntityInput C_UOM) {
		this.mC_UOM = C_UOM;
		MUOM foreignEntity;
		if (C_UOM != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_UOM", "C_UOM_UU=?", get_TrxName())
							.setParameters(C_UOM.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_UOM_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_UOM with UUID " + C_UOM.getUUID());
			}
		} else {
			super.setC_UOM_ID(0);
		}
	}

	/**
	 * Get UOM.
	 *
	 * @return Unit of Measure
	 */
	@JsonProperty("C_UOM")
	public ForeignEntityInput C_UOM() {
		return mC_UOM;
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
		if (M_Product != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_Product.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UUID " + M_Product.getUUID());
			}
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
	 * Set Resource Assignment.
	 *
	 * @param S_ResourceAssignment Resource Assignment
	 */
	@JsonProperty("S_ResourceAssignment")
	public void setS_ResourceAssignmentInput(ForeignEntityInput S_ResourceAssignment) {
		this.mS_ResourceAssignment = S_ResourceAssignment;
		MResourceAssignment foreignEntity;
		if (S_ResourceAssignment != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "S_ResourceAssignment", "S_ResourceAssignment_UU=?", get_TrxName())
							.setParameters(S_ResourceAssignment.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setS_ResourceAssignment_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table S_ResourceAssignment with UUID " + S_ResourceAssignment.getUUID());
			}
		} else {
			super.setS_ResourceAssignment_ID(0);
		}
	}

	/**
	 * Get Resource Assignment.
	 *
	 * @return Resource Assignment
	 */
	@JsonProperty("S_ResourceAssignment")
	public ForeignEntityInput S_ResourceAssignment() {
		return mS_ResourceAssignment;
	}

	/**
	 * Set Expense Report.
	 *
	 * @param S_TimeExpense Time and Expense Report
	 */
	@JsonProperty("S_TimeExpense")
	public void setS_TimeExpenseInput(ForeignEntityInput S_TimeExpense) {
		this.mS_TimeExpense = S_TimeExpense;
		MTimeExpense foreignEntity;
		if (get_ID() == 0 && S_TimeExpense != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "S_TimeExpense", "S_TimeExpense_UU=?", get_TrxName())
							.setParameters(S_TimeExpense.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setS_TimeExpense_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table S_TimeExpense with UUID " + S_TimeExpense.getUUID());
			}
		}
	}

	/**
	 * Get Expense Report.
	 *
	 * @return Time and Expense Report
	 */
	@JsonProperty("S_TimeExpense")
	public ForeignEntityInput S_TimeExpense() {
		return mS_TimeExpense;
	}
	/**
	 * Set Expense Line.
	 *
	 * @param S_TimeExpenseLine_ID Time and Expense Report Line
	 */

	public void setS_TimeExpenseLine_ID(int S_TimeExpenseLine_ID) {
		if (get_ID() == 0) {
			super.setS_TimeExpenseLine_ID(S_TimeExpenseLine_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setS_TimeExpenseLine_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getS_TimeExpenseLine_UU();
	}

	/**
	 * Set Time Type.
	 *
	 * @param S_TimeType Type of time recorded
	 */
	@JsonProperty("S_TimeType")
	public void setS_TimeTypeInput(ForeignEntityInput S_TimeType) {
		this.mS_TimeType = S_TimeType;
		X_S_TimeType foreignEntity;
		if (S_TimeType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "S_TimeType", "S_TimeType_UU=?", get_TrxName())
							.setParameters(S_TimeType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setS_TimeType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table S_TimeType with UUID " + S_TimeType.getUUID());
			}
		} else {
			super.setS_TimeType_ID(0);
		}
	}

	/**
	 * Get Time Type.
	 *
	 * @return Type of time recorded
	 */
	@JsonProperty("S_TimeType")
	public ForeignEntityInput S_TimeType() {
		return mS_TimeType;
	}
}
