package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MAsset;
import org.compiere.model.MCampaign;
import org.compiere.model.MChangeNotice;
import org.compiere.model.MChangeRequest;
import org.compiere.model.MGroup;
import org.compiere.model.MMailText;
import org.compiere.model.MOrg;
import org.compiere.model.MProject;
import org.compiere.model.MRMA;
import org.compiere.model.MRequest;
import org.compiere.model.MRequestCategory;
import org.compiere.model.MRequestType;
import org.compiere.model.MResolution;
import org.compiere.model.MStatus;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Role;
import org.compiere.model.X_R_StandardResponse;
import org.compiere.util.Env;

import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for R_Request - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_RequestInput extends MRequest implements I_R_RequestInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Role;
	private ForeignEntityInput mAD_Table;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mA_Asset;
	private ForeignEntityInput mC_Activity;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_Campaign;
	private ForeignEntityInput mC_Invoice;
	private ForeignEntityInput mC_InvoiceRequest;
	private ForeignEntityInput mC_Order;
	private ForeignEntityInput mC_Payment;
	private ForeignEntityInput mC_Project;
	private ForeignEntityInput mM_ChangeRequest;
	private ForeignEntityInput mM_FixChangeNotice;
	private ForeignEntityInput mM_InOut;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_ProductSpent;
	private ForeignEntityInput mM_RMA;
	private ForeignEntityInput mR_Category;
	private ForeignEntityInput mR_Group;
	private ForeignEntityInput mR_MailText;
	private ForeignEntityInput mR_RequestRelated;
	private ForeignEntityInput mR_RequestType;
	private ForeignEntityInput mR_Resolution;
	private ForeignEntityInput mR_StandardResponse;
	private ForeignEntityInput mR_Status;
	private ForeignEntityInput mSalesRep;
	private I_AD_Ref_ListInput mConfidentialType;
	private I_AD_Ref_ListInput mConfidentialTypeEntry;
	private I_AD_Ref_ListInput mDueType;
	private I_AD_Ref_ListInput mNextAction;
	private I_AD_Ref_ListInput mPriority;
	private I_AD_Ref_ListInput mPriorityUser;
	private I_AD_Ref_ListInput mTaskStatus;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The R_Request_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_R_RequestInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MRequest(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public void setA_AssetInput(ForeignEntityInput A_Asset) {
		this.mA_Asset = A_Asset;
		MAsset foreignEntity;
		if (A_Asset != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
							.setParameters(A_Asset.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Asset_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset with UUID " + A_Asset.getUUID());
			}
		} else {
			super.setA_Asset_ID(0);
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
	 * Set Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public void setAD_RoleInput(ForeignEntityInput AD_Role) {
		this.mAD_Role = AD_Role;
		X_AD_Role foreignEntity;
		if (AD_Role != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Role", "AD_Role_UU=?", get_TrxName())
							.setParameters(AD_Role.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Role_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Role with UUID " + AD_Role.getUUID());
			}
		} else {
			super.setAD_Role_ID(0);
		}
	}

	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public ForeignEntityInput AD_Role() {
		return mAD_Role;
	}

	/**
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(ForeignEntityInput AD_Table) {
		this.mAD_Table = AD_Table;
		MTable foreignEntity;
		if (get_ID() == 0 && AD_Table != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
							.setParameters(AD_Table.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Table_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Table with UUID " + AD_Table.getUUID());
			}
		}
	}

	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	@JsonProperty("AD_Table")
	public ForeignEntityInput AD_Table() {
		return mAD_Table;
	}

	/**
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + AD_User.getUUID());
			}
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
	public ForeignEntityInput AD_User() {
		return mAD_User;
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
	 * Set Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	@JsonProperty("C_Invoice")
	public void setC_InvoiceInput(ForeignEntityInput C_Invoice) {
		this.mC_Invoice = C_Invoice;
		MInvoice_BH foreignEntity;
		if (C_Invoice != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Invoice", "C_Invoice_UU=?", get_TrxName())
							.setParameters(C_Invoice.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Invoice_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Invoice with UUID " + C_Invoice.getUUID());
			}
		} else {
			super.setC_Invoice_ID(0);
		}
	}

	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	@JsonProperty("C_Invoice")
	public ForeignEntityInput C_Invoice() {
		return mC_Invoice;
	}

	/**
	 * Set Request Invoice.
	 *
	 * @param C_InvoiceRequest The generated invoice for this request
	 */
	@JsonProperty("C_InvoiceRequest")
	public void setC_InvoiceRequestInput(ForeignEntityInput C_InvoiceRequest) {
		this.mC_InvoiceRequest = C_InvoiceRequest;
		MInvoice_BH foreignEntity;
		if (get_ID() == 0 && C_InvoiceRequest != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Invoice", "C_Invoice_UU=?", get_TrxName())
							.setParameters(C_InvoiceRequest.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_InvoiceRequest_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Invoice with UUID " + C_InvoiceRequest.getUUID());
			}
		}
	}

	/**
	 * Get Request Invoice.
	 *
	 * @return The generated invoice for this request
	 */
	@JsonProperty("C_InvoiceRequest")
	public ForeignEntityInput C_InvoiceRequest() {
		return mC_InvoiceRequest;
	}

	/**
	 * Set Order.
	 *
	 * @param C_Order Order
	 */
	@JsonProperty("C_Order")
	public void setC_OrderInput(ForeignEntityInput C_Order) {
		this.mC_Order = C_Order;
		MOrder_BH foreignEntity;
		if (C_Order != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Order", "C_Order_UU=?", get_TrxName())
							.setParameters(C_Order.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Order_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Order with UUID " + C_Order.getUUID());
			}
		} else {
			super.setC_Order_ID(0);
		}
	}

	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	@JsonProperty("C_Order")
	public ForeignEntityInput C_Order() {
		return mC_Order;
	}

	/**
	 * Set Payment.
	 *
	 * @param C_Payment Payment identifier
	 */
	@JsonProperty("C_Payment")
	public void setC_PaymentInput(ForeignEntityInput C_Payment) {
		this.mC_Payment = C_Payment;
		MPayment_BH foreignEntity;
		if (C_Payment != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Payment", "C_Payment_UU=?", get_TrxName())
							.setParameters(C_Payment.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Payment_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Payment with UUID " + C_Payment.getUUID());
			}
		} else {
			super.setC_Payment_ID(0);
		}
	}

	/**
	 * Get Payment.
	 *
	 * @return Payment identifier
	 */
	@JsonProperty("C_Payment")
	public ForeignEntityInput C_Payment() {
		return mC_Payment;
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
	 * Set Confidentiality.
	 *
	 * @param ConfidentialType Type of Confidentiality
	 */
	@JsonProperty("ConfidentialType")
	public void setConfidentialTypeInput(I_AD_Ref_ListInput ConfidentialType) {
		this.mConfidentialType = ConfidentialType;
		MRefList_BH foreignEntity;
		if (ConfidentialType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ConfidentialType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setConfidentialType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + ConfidentialType.getUUID());
			}
		} else {
			this.setConfidentialType(null);
		}
	}

	/**
	 * Get Confidentiality.
	 *
	 * @return Type of Confidentiality
	 */
	@JsonProperty("ConfidentialType")
	public I_AD_Ref_ListInput ConfidentialType() {
		return mConfidentialType;
	}

	/**
	 * Set Entry Confidentiality.
	 *
	 * @param ConfidentialTypeEntry Confidentiality of the individual entry
	 */
	@JsonProperty("ConfidentialTypeEntry")
	public void setConfidentialTypeEntryInput(I_AD_Ref_ListInput ConfidentialTypeEntry) {
		this.mConfidentialTypeEntry = ConfidentialTypeEntry;
		MRefList_BH foreignEntity;
		if (ConfidentialTypeEntry != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ConfidentialTypeEntry.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setConfidentialTypeEntry(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + ConfidentialTypeEntry.getUUID());
			}
		} else {
			this.setConfidentialTypeEntry(null);
		}
	}

	/**
	 * Get Entry Confidentiality.
	 *
	 * @return Confidentiality of the individual entry
	 */
	@JsonProperty("ConfidentialTypeEntry")
	public I_AD_Ref_ListInput ConfidentialTypeEntry() {
		return mConfidentialTypeEntry;
	}
	/**
	 * Set Date last action.
	 *
	 * @param DateLastAction Date this request was last acted on
	 */

	public void setDateLastAction(Timestamp DateLastAction) {
		if (get_ID() == 0) {
			super.setDateLastAction(DateLastAction);
		}
	}

	/**
	 * Set Due type.
	 *
	 * @param DueType Status of the next action for this Request
	 */
	@JsonProperty("DueType")
	public void setDueTypeInput(I_AD_Ref_ListInput DueType) {
		this.mDueType = DueType;
		MRefList_BH foreignEntity;
		if (DueType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DueType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDueType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + DueType.getUUID());
			}
		} else {
			this.setDueType(null);
		}
	}

	/**
	 * Get Due type.
	 *
	 * @return Status of the next action for this Request
	 */
	@JsonProperty("DueType")
	public I_AD_Ref_ListInput DueType() {
		return mDueType;
	}
	/**
	 * Set Self-Service.
	 *
	 * @param IsSelfService This is a Self-Service entry or this entry can be changed via Self-Service
	 */

	public void setIsSelfService(boolean IsSelfService) {
		if (get_ID() == 0) {
			super.setIsSelfService(IsSelfService);
		}
	}

	/**
	 * Set Change Request.
	 *
	 * @param M_ChangeRequest BOM (Engineering) Change Request
	 */
	@JsonProperty("M_ChangeRequest")
	public void setM_ChangeRequestInput(ForeignEntityInput M_ChangeRequest) {
		this.mM_ChangeRequest = M_ChangeRequest;
		MChangeRequest foreignEntity;
		if (M_ChangeRequest != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_ChangeRequest", "M_ChangeRequest_UU=?", get_TrxName())
							.setParameters(M_ChangeRequest.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_ChangeRequest_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ChangeRequest with UUID " + M_ChangeRequest.getUUID());
			}
		} else {
			super.setM_ChangeRequest_ID(0);
		}
	}

	/**
	 * Get Change Request.
	 *
	 * @return BOM (Engineering) Change Request
	 */
	@JsonProperty("M_ChangeRequest")
	public ForeignEntityInput M_ChangeRequest() {
		return mM_ChangeRequest;
	}

	/**
	 * Set Fixed in.
	 *
	 * @param M_FixChangeNotice Fixed in Change Notice
	 */
	@JsonProperty("M_FixChangeNotice")
	public void setM_FixChangeNoticeInput(ForeignEntityInput M_FixChangeNotice) {
		this.mM_FixChangeNotice = M_FixChangeNotice;
		MChangeNotice foreignEntity;
		if (M_FixChangeNotice != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_ChangeNotice", "M_ChangeNotice_UU=?", get_TrxName())
							.setParameters(M_FixChangeNotice.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_FixChangeNotice_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ChangeNotice with UUID " + M_FixChangeNotice.getUUID());
			}
		} else {
			super.setM_FixChangeNotice_ID(0);
		}
	}

	/**
	 * Get Fixed in.
	 *
	 * @return Fixed in Change Notice
	 */
	@JsonProperty("M_FixChangeNotice")
	public ForeignEntityInput M_FixChangeNotice() {
		return mM_FixChangeNotice;
	}

	/**
	 * Set Shipment/Receipt.
	 *
	 * @param M_InOut Material Shipment Document
	 */
	@JsonProperty("M_InOut")
	public void setM_InOutInput(ForeignEntityInput M_InOut) {
		this.mM_InOut = M_InOut;
		MInOut_BH foreignEntity;
		if (M_InOut != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_InOut", "M_InOut_UU=?", get_TrxName())
							.setParameters(M_InOut.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_InOut_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_InOut with UUID " + M_InOut.getUUID());
			}
		} else {
			super.setM_InOut_ID(0);
		}
	}

	/**
	 * Get Shipment/Receipt.
	 *
	 * @return Material Shipment Document
	 */
	@JsonProperty("M_InOut")
	public ForeignEntityInput M_InOut() {
		return mM_InOut;
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
	 * Set Product Used.
	 *
	 * @param M_ProductSpent Product/Resource/Service used in Request
	 */
	@JsonProperty("M_ProductSpent")
	public void setM_ProductSpentInput(ForeignEntityInput M_ProductSpent) {
		this.mM_ProductSpent = M_ProductSpent;
		MProduct_BH foreignEntity;
		if (M_ProductSpent != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_ProductSpent.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_ProductSpent_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UUID " + M_ProductSpent.getUUID());
			}
		} else {
			super.setM_ProductSpent_ID(0);
		}
	}

	/**
	 * Get Product Used.
	 *
	 * @return Product/Resource/Service used in Request
	 */
	@JsonProperty("M_ProductSpent")
	public ForeignEntityInput M_ProductSpent() {
		return mM_ProductSpent;
	}

	/**
	 * Set RMA.
	 *
	 * @param M_RMA Return Material Authorization
	 */
	@JsonProperty("M_RMA")
	public void setM_RMAInput(ForeignEntityInput M_RMA) {
		this.mM_RMA = M_RMA;
		MRMA foreignEntity;
		if (M_RMA != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_RMA", "M_RMA_UU=?", get_TrxName())
							.setParameters(M_RMA.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_RMA_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_RMA with UUID " + M_RMA.getUUID());
			}
		} else {
			super.setM_RMA_ID(0);
		}
	}

	/**
	 * Get RMA.
	 *
	 * @return Return Material Authorization
	 */
	@JsonProperty("M_RMA")
	public ForeignEntityInput M_RMA() {
		return mM_RMA;
	}

	/**
	 * Set Next action.
	 *
	 * @param NextAction Next Action to be taken
	 */
	@JsonProperty("NextAction")
	public void setNextActionInput(I_AD_Ref_ListInput NextAction) {
		this.mNextAction = NextAction;
		MRefList_BH foreignEntity;
		if (NextAction != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(NextAction.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setNextAction(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + NextAction.getUUID());
			}
		} else {
			this.setNextAction(null);
		}
	}

	/**
	 * Get Next action.
	 *
	 * @return Next Action to be taken
	 */
	@JsonProperty("NextAction")
	public I_AD_Ref_ListInput NextAction() {
		return mNextAction;
	}

	/**
	 * Set Priority.
	 *
	 * @param Priority Indicates if this request is of a high, medium or low priority.
	 */
	@JsonProperty("Priority")
	public void setPriorityInput(I_AD_Ref_ListInput Priority) {
		this.mPriority = Priority;
		MRefList_BH foreignEntity;
		if (Priority != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Priority.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPriority(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + Priority.getUUID());
			}
		} else {
			this.setPriority(null);
		}
	}

	/**
	 * Get Priority.
	 *
	 * @return Indicates if this request is of a high, medium or low priority.
	 */
	@JsonProperty("Priority")
	public I_AD_Ref_ListInput Priority() {
		return mPriority;
	}

	/**
	 * Set User Importance.
	 *
	 * @param PriorityUser Priority of the issue for the User
	 */
	@JsonProperty("PriorityUser")
	public void setPriorityUserInput(I_AD_Ref_ListInput PriorityUser) {
		this.mPriorityUser = PriorityUser;
		MRefList_BH foreignEntity;
		if (PriorityUser != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PriorityUser.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPriorityUser(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + PriorityUser.getUUID());
			}
		} else {
			this.setPriorityUser(null);
		}
	}

	/**
	 * Get User Importance.
	 *
	 * @return Priority of the issue for the User
	 */
	@JsonProperty("PriorityUser")
	public I_AD_Ref_ListInput PriorityUser() {
		return mPriorityUser;
	}

	/**
	 * Set Category.
	 *
	 * @param R_Category Request Category
	 */
	@JsonProperty("R_Category")
	public void setR_CategoryInput(ForeignEntityInput R_Category) {
		this.mR_Category = R_Category;
		MRequestCategory foreignEntity;
		if (R_Category != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "R_Category", "R_Category_UU=?", get_TrxName())
							.setParameters(R_Category.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_Category_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_Category with UUID " + R_Category.getUUID());
			}
		} else {
			super.setR_Category_ID(0);
		}
	}

	/**
	 * Get Category.
	 *
	 * @return Request Category
	 */
	@JsonProperty("R_Category")
	public ForeignEntityInput R_Category() {
		return mR_Category;
	}

	/**
	 * Set Group.
	 *
	 * @param R_Group Request Group
	 */
	@JsonProperty("R_Group")
	public void setR_GroupInput(ForeignEntityInput R_Group) {
		this.mR_Group = R_Group;
		MGroup foreignEntity;
		if (R_Group != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "R_Group", "R_Group_UU=?", get_TrxName())
							.setParameters(R_Group.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_Group_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_Group with UUID " + R_Group.getUUID());
			}
		} else {
			super.setR_Group_ID(0);
		}
	}

	/**
	 * Get Group.
	 *
	 * @return Request Group
	 */
	@JsonProperty("R_Group")
	public ForeignEntityInput R_Group() {
		return mR_Group;
	}

	/**
	 * Set Mail Template.
	 *
	 * @param R_MailText Text templates for mailings
	 */
	@JsonProperty("R_MailText")
	public void setR_MailTextInput(ForeignEntityInput R_MailText) {
		this.mR_MailText = R_MailText;
		MMailText foreignEntity;
		if (R_MailText != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "R_MailText", "R_MailText_UU=?", get_TrxName())
							.setParameters(R_MailText.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_MailText_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_MailText with UUID " + R_MailText.getUUID());
			}
		} else {
			super.setR_MailText_ID(0);
		}
	}

	/**
	 * Get Mail Template.
	 *
	 * @return Text templates for mailings
	 */
	@JsonProperty("R_MailText")
	public ForeignEntityInput R_MailText() {
		return mR_MailText;
	}
	/**
	 * Set Request.
	 *
	 * @param R_Request_ID Request from a Business Partner or Prospect
	 */

	public void setR_Request_ID(int R_Request_ID) {
		if (get_ID() == 0) {
			super.setR_Request_ID(R_Request_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setR_Request_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getR_Request_UU();
	}

	/**
	 * Set Related Request.
	 *
	 * @param R_RequestRelated Related Request (Master Issue, ..)
	 */
	@JsonProperty("R_RequestRelated")
	public void setR_RequestRelatedInput(ForeignEntityInput R_RequestRelated) {
		this.mR_RequestRelated = R_RequestRelated;
		MRequest foreignEntity;
		if (R_RequestRelated != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "R_Request", "R_Request_UU=?", get_TrxName())
							.setParameters(R_RequestRelated.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_RequestRelated_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_Request with UUID " + R_RequestRelated.getUUID());
			}
		} else {
			super.setR_RequestRelated_ID(0);
		}
	}

	/**
	 * Get Related Request.
	 *
	 * @return Related Request (Master Issue, ..)
	 */
	@JsonProperty("R_RequestRelated")
	public ForeignEntityInput R_RequestRelated() {
		return mR_RequestRelated;
	}

	/**
	 * Set Request Type.
	 *
	 * @param R_RequestType Type of request (e.g. Inquiry, Complaint, ..)
	 */
	@JsonProperty("R_RequestType")
	public void setR_RequestTypeInput(ForeignEntityInput R_RequestType) {
		this.mR_RequestType = R_RequestType;
		MRequestType foreignEntity;
		if (R_RequestType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "R_RequestType", "R_RequestType_UU=?", get_TrxName())
							.setParameters(R_RequestType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_RequestType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_RequestType with UUID " + R_RequestType.getUUID());
			}
		} else {
			super.setR_RequestType_ID(0);
		}
	}

	/**
	 * Get Request Type.
	 *
	 * @return Type of request (e.g. Inquiry, Complaint, ..)
	 */
	@JsonProperty("R_RequestType")
	public ForeignEntityInput R_RequestType() {
		return mR_RequestType;
	}

	/**
	 * Set Resolution.
	 *
	 * @param R_Resolution Request Resolution
	 */
	@JsonProperty("R_Resolution")
	public void setR_ResolutionInput(ForeignEntityInput R_Resolution) {
		this.mR_Resolution = R_Resolution;
		MResolution foreignEntity;
		if (R_Resolution != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "R_Resolution", "R_Resolution_UU=?", get_TrxName())
							.setParameters(R_Resolution.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_Resolution_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_Resolution with UUID " + R_Resolution.getUUID());
			}
		} else {
			super.setR_Resolution_ID(0);
		}
	}

	/**
	 * Get Resolution.
	 *
	 * @return Request Resolution
	 */
	@JsonProperty("R_Resolution")
	public ForeignEntityInput R_Resolution() {
		return mR_Resolution;
	}

	/**
	 * Set Standard Response.
	 *
	 * @param R_StandardResponse Request Standard Response 
	 */
	@JsonProperty("R_StandardResponse")
	public void setR_StandardResponseInput(ForeignEntityInput R_StandardResponse) {
		this.mR_StandardResponse = R_StandardResponse;
		X_R_StandardResponse foreignEntity;
		if (R_StandardResponse != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "R_StandardResponse", "R_StandardResponse_UU=?", get_TrxName())
							.setParameters(R_StandardResponse.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_StandardResponse_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_StandardResponse with UUID " + R_StandardResponse.getUUID());
			}
		} else {
			super.setR_StandardResponse_ID(0);
		}
	}

	/**
	 * Get Standard Response.
	 *
	 * @return Request Standard Response 
	 */
	@JsonProperty("R_StandardResponse")
	public ForeignEntityInput R_StandardResponse() {
		return mR_StandardResponse;
	}

	/**
	 * Set Status.
	 *
	 * @param R_Status Request Status
	 */
	@JsonProperty("R_Status")
	public void setR_StatusInput(ForeignEntityInput R_Status) {
		this.mR_Status = R_Status;
		MStatus foreignEntity;
		if (R_Status != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "R_Status", "R_Status_UU=?", get_TrxName())
							.setParameters(R_Status.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_Status_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_Status with UUID " + R_Status.getUUID());
			}
		} else {
			super.setR_Status_ID(0);
		}
	}

	/**
	 * Get Status.
	 *
	 * @return Request Status
	 */
	@JsonProperty("R_Status")
	public ForeignEntityInput R_Status() {
		return mR_Status;
	}
	/**
	 * Set Record ID.
	 *
	 * @param Record_ID Direct internal record ID
	 */

	public void setRecord_ID(int Record_ID) {
		if (get_ID() == 0) {
			super.setRecord_ID(Record_ID);
		}
	}

	/**
	 * Set Sales Representative.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	@JsonProperty("SalesRep")
	public void setSalesRepInput(ForeignEntityInput SalesRep) {
		this.mSalesRep = SalesRep;
		MUser_BH foreignEntity;
		if (SalesRep != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(SalesRep.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setSalesRep_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + SalesRep.getUUID());
			}
		} else {
			super.setSalesRep_ID(0);
		}
	}

	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	@JsonProperty("SalesRep")
	public ForeignEntityInput SalesRep() {
		return mSalesRep;
	}

	/**
	 * Set Task Status.
	 *
	 * @param TaskStatus Status of the Task
	 */
	@JsonProperty("TaskStatus")
	public void setTaskStatusInput(I_AD_Ref_ListInput TaskStatus) {
		this.mTaskStatus = TaskStatus;
		MRefList_BH foreignEntity;
		if (TaskStatus != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(TaskStatus.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setTaskStatus(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + TaskStatus.getUUID());
			}
		} else {
			this.setTaskStatus(null);
		}
	}

	/**
	 * Get Task Status.
	 *
	 * @return Status of the Task
	 */
	@JsonProperty("TaskStatus")
	public I_AD_Ref_ListInput TaskStatus() {
		return mTaskStatus;
	}
}
