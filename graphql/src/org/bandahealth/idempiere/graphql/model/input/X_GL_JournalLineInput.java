package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MActivity;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetGroup;
import org.compiere.model.MCampaign;
import org.compiere.model.MConversionType;
import org.compiere.model.MElementValue;
import org.compiere.model.MJournal;
import org.compiere.model.MJournalLine;
import org.compiere.model.MLocation;
import org.compiere.model.MOrg;
import org.compiere.model.MProject;
import org.compiere.model.MSalesRegion;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.model.X_C_SubAcct;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for GL_JournalLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_JournalLineInput extends MJournalLine implements I_GL_JournalLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Asset;
	private ForeignEntityInput mA_Asset_Group;
	private ForeignEntityInput mAccount;
	private ForeignEntityInput mAlias_ValidCombination;
	private ForeignEntityInput mC_Activity;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_Campaign;
	private ForeignEntityInput mC_ConversionType;
	private ForeignEntityInput mC_Currency;
	private ForeignEntityInput mC_LocFrom;
	private ForeignEntityInput mC_LocTo;
	private ForeignEntityInput mC_Project;
	private ForeignEntityInput mC_SalesRegion;
	private ForeignEntityInput mC_SubAcct;
	private ForeignEntityInput mC_UOM;
	private ForeignEntityInput mC_ValidCombination;
	private ForeignEntityInput mGL_Journal;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mUser1;
	private ForeignEntityInput mUser2;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The GL_JournalLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_GL_JournalLineInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Asset Group.
	 *
	 * @param A_Asset_Group Group of Assets
	 */
	@JsonProperty("A_Asset_Group")
	public void setA_Asset_GroupInput(ForeignEntityInput A_Asset_Group) {
		this.mA_Asset_Group = A_Asset_Group;
		if (A_Asset_Group != null) {
			// Since an entity was passed, make sure it's in the DB
			MAssetGroup foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset_Group", "A_Asset_Group_UU=?", get_TrxName())
							.setParameters(A_Asset_Group.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Asset_Group_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset_Group with UUID " + A_Asset_Group.getUUID());
			}
		} else {
			this.setA_Asset_Group_ID(0);
		}
	}

	/**
	 * Get Asset Group.
	 *
	 * @return Group of Assets
	 */
	@JsonProperty("A_Asset_Group")
	public ForeignEntityInput A_Asset_Group() {
		return mA_Asset_Group;
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public void setA_AssetInput(ForeignEntityInput A_Asset) {
		this.mA_Asset = A_Asset;
		if (A_Asset != null) {
			// Since an entity was passed, make sure it's in the DB
			MAsset foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
							.setParameters(A_Asset.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Asset_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset with UUID " + A_Asset.getUUID());
			}
		} else {
			this.setA_Asset_ID(0);
		}
	}

	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public ForeignEntityInput A_Asset() {
		return mA_Asset;
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
	 * Set Alias List.
	 *
	 * @param Alias_ValidCombination Valid Account Alias List
	 */
	@JsonProperty("Alias_ValidCombination")
	public void setAlias_ValidCombinationInput(ForeignEntityInput Alias_ValidCombination) {
		this.mAlias_ValidCombination = Alias_ValidCombination;
		if (Alias_ValidCombination != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(Alias_ValidCombination.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAlias_ValidCombination_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + Alias_ValidCombination.getUUID());
			}
		} else {
			this.setAlias_ValidCombination_ID(0);
		}
	}

	/**
	 * Get Alias List.
	 *
	 * @return Valid Account Alias List
	 */
	@JsonProperty("Alias_ValidCombination")
	public ForeignEntityInput Alias_ValidCombination() {
		return mAlias_ValidCombination;
	}
	/**
	 * Set Accounted Credit.
	 *
	 * @param AmtAcctCr Accounted Credit Amount
	 */

	public void setAmtAcctCr(BigDecimal AmtAcctCr) {
		if (get_ID() == 0) {
			super.setAmtAcctCr(AmtAcctCr);
		}
	}
	/**
	 * Set Accounted Debit.
	 *
	 * @param AmtAcctDr Accounted Debit Amount
	 */

	public void setAmtAcctDr(BigDecimal AmtAcctDr) {
		if (get_ID() == 0) {
			super.setAmtAcctDr(AmtAcctDr);
		}
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
	 * Set Currency Type.
	 *
	 * @param C_ConversionType Currency Conversion Rate Type
	 */
	@JsonProperty("C_ConversionType")
	public void setC_ConversionTypeInput(ForeignEntityInput C_ConversionType) {
		this.mC_ConversionType = C_ConversionType;
		if (C_ConversionType != null) {
			// Since an entity was passed, make sure it's in the DB
			MConversionType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ConversionType", "C_ConversionType_UU=?", get_TrxName())
							.setParameters(C_ConversionType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_ConversionType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ConversionType with UUID " + C_ConversionType.getUUID());
			}
		} else {
			this.setC_ConversionType_ID(0);
		}
	}

	/**
	 * Get Currency Type.
	 *
	 * @return Currency Conversion Rate Type
	 */
	@JsonProperty("C_ConversionType")
	public ForeignEntityInput C_ConversionType() {
		return mC_ConversionType;
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
							.setParameters(C_Currency.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Currency_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UUID " + C_Currency.getUUID());
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
	 * Set UOM.
	 *
	 * @param C_UOM Unit of Measure
	 */
	@JsonProperty("C_UOM")
	public void setC_UOMInput(ForeignEntityInput C_UOM) {
		this.mC_UOM = C_UOM;
		if (C_UOM != null) {
			// Since an entity was passed, make sure it's in the DB
			MUOM foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_UOM", "C_UOM_UU=?", get_TrxName())
							.setParameters(C_UOM.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_UOM_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_UOM with UUID " + C_UOM.getUUID());
			}
		} else {
			this.setC_UOM_ID(0);
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
	 * Set Combination.
	 *
	 * @param C_ValidCombination Valid Account Combination
	 */
	@JsonProperty("C_ValidCombination")
	public void setC_ValidCombinationInput(ForeignEntityInput C_ValidCombination) {
		this.mC_ValidCombination = C_ValidCombination;
		if (C_ValidCombination != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(C_ValidCombination.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_ValidCombination_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + C_ValidCombination.getUUID());
			}
		} else {
			this.setC_ValidCombination_ID(0);
		}
	}

	/**
	 * Get Combination.
	 *
	 * @return Valid Account Combination
	 */
	@JsonProperty("C_ValidCombination")
	public ForeignEntityInput C_ValidCombination() {
		return mC_ValidCombination;
	}
	/**
	 * Set Rate.
	 *
	 * @param CurrencyRate Currency Conversion Rate
	 */

	public void setCurrencyRate(BigDecimal CurrencyRate) {
		if (get_ID() == 0) {
			super.setCurrencyRate(CurrencyRate);
		}
	}

	/**
	 * Set Journal.
	 *
	 * @param GL_Journal General Ledger Journal
	 */
	@JsonProperty("GL_Journal")
	public void setGL_JournalInput(ForeignEntityInput GL_Journal) {
		this.mGL_Journal = GL_Journal;
		if (get_ID() != 0) {
			return;
		}
		if (GL_Journal != null) {
			// Since an entity was passed, make sure it's in the DB
			MJournal foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "GL_Journal", "GL_Journal_UU=?", get_TrxName())
							.setParameters(GL_Journal.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setGL_Journal_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table GL_Journal with UUID " + GL_Journal.getUUID());
			}
		} else {
			this.setGL_Journal_ID(0);
		}
	}

	/**
	 * Get Journal.
	 *
	 * @return General Ledger Journal
	 */
	@JsonProperty("GL_Journal")
	public ForeignEntityInput GL_Journal() {
		return mGL_Journal;
	}
	/**
	 * Set Journal Line.
	 *
	 * @param GL_JournalLine_ID General Ledger Journal Line
	 */

	public void setGL_JournalLine_ID(int GL_JournalLine_ID) {
		if (get_ID() == 0) {
			super.setGL_JournalLine_ID(GL_JournalLine_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setGL_JournalLine_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getGL_JournalLine_UU();
	}
	/**
	 * Set Generated.
	 *
	 * @param IsGenerated This Line is generated
	 */

	public void setIsGenerated(boolean IsGenerated) {
		if (get_ID() == 0) {
			super.setIsGenerated(IsGenerated);
		}
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
