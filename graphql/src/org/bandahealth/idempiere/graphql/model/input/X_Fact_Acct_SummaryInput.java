package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MActivity;
import org.compiere.model.MCampaign;
import org.compiere.model.MElementValue;
import org.compiere.model.MLocation;
import org.compiere.model.MOrg;
import org.compiere.model.MPeriod;
import org.compiere.model.MProject;
import org.compiere.model.MProjectPhase;
import org.compiere.model.MProjectTask;
import org.compiere.model.MReportCube;
import org.compiere.model.MSalesRegion;
import org.compiere.model.Query;
import org.compiere.model.X_C_SubAcct;
import org.compiere.model.X_Fact_Acct_Summary;
import org.compiere.model.X_GL_Budget;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for Fact_Acct_Summary - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_Fact_Acct_SummaryInput extends X_Fact_Acct_Summary implements I_Fact_Acct_SummaryInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAccount;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mC_Activity;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_Campaign;
	private ForeignEntityInput mC_LocFrom;
	private ForeignEntityInput mC_LocTo;
	private ForeignEntityInput mC_Period;
	private ForeignEntityInput mC_Project;
	private ForeignEntityInput mC_ProjectPhase;
	private ForeignEntityInput mC_ProjectTask;
	private ForeignEntityInput mC_SalesRegion;
	private ForeignEntityInput mC_SubAcct;
	private ForeignEntityInput mGL_Budget;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mPA_ReportCube;
	private ForeignEntityInput mUser1;
	private ForeignEntityInput mUser2;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The Fact_Acct_Summary_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_Fact_Acct_SummaryInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_Fact_Acct_Summary(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Account.
	 *
	 * @param Account Account used
	 */
	@JsonProperty("Account")
	public void setAccountInput(ForeignEntityInput Account) {
		this.mAccount = Account;
		if (Account != null) {
			// Since an entity was passed, make sure it's in the DB
			MElementValue foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
							.setParameters(Account.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAccount_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ElementValue with UUID " + Account.getUUID());
			}
		} else {
			this.setAccount_ID(0);
		}
	}

	/**
	 * Get Account.
	 *
	 * @return Account used
	 */
	@JsonProperty("Account")
	public ForeignEntityInput Account() {
		return mAccount;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
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
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema) {
		this.mC_AcctSchema = C_AcctSchema;
		if (C_AcctSchema != null) {
			// Since an entity was passed, make sure it's in the DB
			MAcctSchema foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
							.setParameters(C_AcctSchema.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_AcctSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_AcctSchema with UUID " + C_AcctSchema.getUUID());
			}
		} else {
			this.setC_AcctSchema_ID(0);
		}
	}

	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public ForeignEntityInput C_AcctSchema() {
		return mC_AcctSchema;
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
							.setParameters(C_Activity.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Activity_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Activity with UUID " + C_Activity.getUUID());
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
	 * Set Business Partner .
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
							.setParameters(C_BPartner.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + C_BPartner.getUUID());
			}
		} else {
			this.setC_BPartner_ID(0);
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
		if (C_Campaign != null) {
			// Since an entity was passed, make sure it's in the DB
			MCampaign foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Campaign", "C_Campaign_UU=?", get_TrxName())
							.setParameters(C_Campaign.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Campaign_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Campaign with UUID " + C_Campaign.getUUID());
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
	 * Set Location From.
	 *
	 * @param C_LocFrom Location that inventory was moved from
	 */
	@JsonProperty("C_LocFrom")
	public void setC_LocFromInput(ForeignEntityInput C_LocFrom) {
		this.mC_LocFrom = C_LocFrom;
		if (C_LocFrom != null) {
			// Since an entity was passed, make sure it's in the DB
			MLocation foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Location", "C_Location_UU=?", get_TrxName())
							.setParameters(C_LocFrom.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_LocFrom_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Location with UUID " + C_LocFrom.getUUID());
			}
		} else {
			this.setC_LocFrom_ID(0);
		}
	}

	/**
	 * Get Location From.
	 *
	 * @return Location that inventory was moved from
	 */
	@JsonProperty("C_LocFrom")
	public ForeignEntityInput C_LocFrom() {
		return mC_LocFrom;
	}

	/**
	 * Set Location To.
	 *
	 * @param C_LocTo Location that inventory was moved to
	 */
	@JsonProperty("C_LocTo")
	public void setC_LocToInput(ForeignEntityInput C_LocTo) {
		this.mC_LocTo = C_LocTo;
		if (C_LocTo != null) {
			// Since an entity was passed, make sure it's in the DB
			MLocation foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Location", "C_Location_UU=?", get_TrxName())
							.setParameters(C_LocTo.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_LocTo_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Location with UUID " + C_LocTo.getUUID());
			}
		} else {
			this.setC_LocTo_ID(0);
		}
	}

	/**
	 * Get Location To.
	 *
	 * @return Location that inventory was moved to
	 */
	@JsonProperty("C_LocTo")
	public ForeignEntityInput C_LocTo() {
		return mC_LocTo;
	}

	/**
	 * Set Period.
	 *
	 * @param C_Period Period of the Calendar
	 */
	@JsonProperty("C_Period")
	public void setC_PeriodInput(ForeignEntityInput C_Period) {
		this.mC_Period = C_Period;
		if (C_Period != null) {
			// Since an entity was passed, make sure it's in the DB
			MPeriod foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Period", "C_Period_UU=?", get_TrxName())
							.setParameters(C_Period.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Period_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Period with UUID " + C_Period.getUUID());
			}
		} else {
			this.setC_Period_ID(0);
		}
	}

	/**
	 * Get Period.
	 *
	 * @return Period of the Calendar
	 */
	@JsonProperty("C_Period")
	public ForeignEntityInput C_Period() {
		return mC_Period;
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
							.setParameters(C_Project.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Project_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Project with UUID " + C_Project.getUUID());
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
	 * Set Project Phase.
	 *
	 * @param C_ProjectPhase Phase of a Project
	 */
	@JsonProperty("C_ProjectPhase")
	public void setC_ProjectPhaseInput(ForeignEntityInput C_ProjectPhase) {
		this.mC_ProjectPhase = C_ProjectPhase;
		if (C_ProjectPhase != null) {
			// Since an entity was passed, make sure it's in the DB
			MProjectPhase foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ProjectPhase", "C_ProjectPhase_UU=?", get_TrxName())
							.setParameters(C_ProjectPhase.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_ProjectPhase_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ProjectPhase with UUID " + C_ProjectPhase.getUUID());
			}
		} else {
			this.setC_ProjectPhase_ID(0);
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
		if (C_ProjectTask != null) {
			// Since an entity was passed, make sure it's in the DB
			MProjectTask foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ProjectTask", "C_ProjectTask_UU=?", get_TrxName())
							.setParameters(C_ProjectTask.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_ProjectTask_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ProjectTask with UUID " + C_ProjectTask.getUUID());
			}
		} else {
			this.setC_ProjectTask_ID(0);
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
							.setParameters(C_SalesRegion.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_SalesRegion_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_SalesRegion with UUID " + C_SalesRegion.getUUID());
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
	 * Set Sub Account.
	 *
	 * @param C_SubAcct Sub account for Element Value
	 */
	@JsonProperty("C_SubAcct")
	public void setC_SubAcctInput(ForeignEntityInput C_SubAcct) {
		this.mC_SubAcct = C_SubAcct;
		if (C_SubAcct != null) {
			// Since an entity was passed, make sure it's in the DB
			X_C_SubAcct foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_SubAcct", "C_SubAcct_UU=?", get_TrxName())
							.setParameters(C_SubAcct.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_SubAcct_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_SubAcct with UUID " + C_SubAcct.getUUID());
			}
		} else {
			this.setC_SubAcct_ID(0);
		}
	}

	/**
	 * Get Sub Account.
	 *
	 * @return Sub account for Element Value
	 */
	@JsonProperty("C_SubAcct")
	public ForeignEntityInput C_SubAcct() {
		return mC_SubAcct;
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setFact_Acct_Summary_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getFact_Acct_Summary_UU();
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
							.setParameters(GL_Budget.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setGL_Budget_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table GL_Budget with UUID " + GL_Budget.getUUID());
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
							.setParameters(M_Product.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UUID " + M_Product.getUUID());
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
	 * Set Report Cube.
	 *
	 * @param PA_ReportCube Define reporting cube for pre-calculation of summary accounting data.
	 */
	@JsonProperty("PA_ReportCube")
	public void setPA_ReportCubeInput(ForeignEntityInput PA_ReportCube) {
		this.mPA_ReportCube = PA_ReportCube;
		if (PA_ReportCube != null) {
			// Since an entity was passed, make sure it's in the DB
			MReportCube foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_ReportCube", "PA_ReportCube_UU=?", get_TrxName())
							.setParameters(PA_ReportCube.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPA_ReportCube_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_ReportCube with UUID " + PA_ReportCube.getUUID());
			}
		} else {
			this.setPA_ReportCube_ID(0);
		}
	}

	/**
	 * Get Report Cube.
	 *
	 * @return Define reporting cube for pre-calculation of summary accounting data.
	 */
	@JsonProperty("PA_ReportCube")
	public ForeignEntityInput PA_ReportCube() {
		return mPA_ReportCube;
	}

	/**
	 * Set User Element List 1.
	 *
	 * @param User1 User defined list element #1
	 */
	@JsonProperty("User1")
	public void setUser1Input(ForeignEntityInput User1) {
		this.mUser1 = User1;
		if (User1 != null) {
			// Since an entity was passed, make sure it's in the DB
			MElementValue foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
							.setParameters(User1.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setUser1_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ElementValue with UUID " + User1.getUUID());
			}
		} else {
			this.setUser1_ID(0);
		}
	}

	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	@JsonProperty("User1")
	public ForeignEntityInput User1() {
		return mUser1;
	}

	/**
	 * Set User Element List 2.
	 *
	 * @param User2 User defined list element #2
	 */
	@JsonProperty("User2")
	public void setUser2Input(ForeignEntityInput User2) {
		this.mUser2 = User2;
		if (User2 != null) {
			// Since an entity was passed, make sure it's in the DB
			MElementValue foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
							.setParameters(User2.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setUser2_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ElementValue with UUID " + User2.getUUID());
			}
		} else {
			this.setUser2_ID(0);
		}
	}

	/**
	 * Get User Element List 2.
	 *
	 * @return User defined list element #2
	 */
	@JsonProperty("User2")
	public ForeignEntityInput User2() {
		return mUser2;
	}
}
