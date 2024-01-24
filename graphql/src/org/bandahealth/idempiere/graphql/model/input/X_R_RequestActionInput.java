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
import org.compiere.model.MGroup;
import org.compiere.model.MOrg;
import org.compiere.model.MProject;
import org.compiere.model.MRMA;
import org.compiere.model.MRequest;
import org.compiere.model.MRequestAction;
import org.compiere.model.MRequestCategory;
import org.compiere.model.MRequestType;
import org.compiere.model.MResolution;
import org.compiere.model.MStatus;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Role;
import org.compiere.util.Env;

import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for R_RequestAction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_RequestActionInput extends MRequestAction implements I_R_RequestActionInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Role;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mA_Asset;
	private ForeignEntityInput mC_Activity;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_Invoice;
	private ForeignEntityInput mC_Order;
	private ForeignEntityInput mC_Payment;
	private ForeignEntityInput mC_Project;
	private ForeignEntityInput mM_InOut;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_ProductSpent;
	private ForeignEntityInput mM_RMA;
	private ForeignEntityInput mR_Category;
	private ForeignEntityInput mR_Group;
	private ForeignEntityInput mR_Request;
	private ForeignEntityInput mR_RequestType;
	private ForeignEntityInput mR_Resolution;
	private ForeignEntityInput mR_Status;
	private ForeignEntityInput mSalesRep;
	private I_AD_Ref_ListInput mConfidentialType;
	private I_AD_Ref_ListInput mIsEscalated;
	private I_AD_Ref_ListInput mIsSelfService;
	private I_AD_Ref_ListInput mPriority;
	private I_AD_Ref_ListInput mPriorityUser;
	private I_AD_Ref_ListInput mTaskStatus;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The R_RequestAction_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_R_RequestActionInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MRequestAction(null, (ResultSet) null, null),
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
		if (get_ID() == 0 && A_Asset != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
							.setParameters(A_Asset.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Asset_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset with UUID " + A_Asset.getUUID());
			}
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
		if (get_ID() == 0 && AD_Role != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Role", "AD_Role_UU=?", get_TrxName())
							.setParameters(AD_Role.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Role_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Role with UUID " + AD_Role.getUUID());
			}
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (get_ID() == 0 && AD_User != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + AD_User.getUUID());
			}
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
		if (get_ID() == 0 && C_Activity != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Activity", "C_Activity_UU=?", get_TrxName())
							.setParameters(C_Activity.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Activity_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Activity with UUID " + C_Activity.getUUID());
			}
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
		if (get_ID() == 0 && C_BPartner != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + C_BPartner.getUUID());
			}
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
	 * Set Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	@JsonProperty("C_Invoice")
	public void setC_InvoiceInput(ForeignEntityInput C_Invoice) {
		this.mC_Invoice = C_Invoice;
		MInvoice_BH foreignEntity;
		if (get_ID() == 0 && C_Invoice != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Invoice", "C_Invoice_UU=?", get_TrxName())
							.setParameters(C_Invoice.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Invoice_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Invoice with UUID " + C_Invoice.getUUID());
			}
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
	 * Set Order.
	 *
	 * @param C_Order Order
	 */
	@JsonProperty("C_Order")
	public void setC_OrderInput(ForeignEntityInput C_Order) {
		this.mC_Order = C_Order;
		MOrder_BH foreignEntity;
		if (get_ID() == 0 && C_Order != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Order", "C_Order_UU=?", get_TrxName())
							.setParameters(C_Order.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Order_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Order with UUID " + C_Order.getUUID());
			}
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
		if (get_ID() == 0 && C_Payment != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Payment", "C_Payment_UU=?", get_TrxName())
							.setParameters(C_Payment.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Payment_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Payment with UUID " + C_Payment.getUUID());
			}
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
		if (get_ID() == 0 && C_Project != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Project", "C_Project_UU=?", get_TrxName())
							.setParameters(C_Project.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Project_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Project with UUID " + C_Project.getUUID());
			}
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
		if (get_ID() == 0 &&ConfidentialType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ConfidentialType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setConfidentialType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + ConfidentialType.getUUID());
			}
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
	 * Set Date next action.
	 *
	 * @param DateNextAction Date that this request should be acted on
	 */

	public void setDateNextAction(Timestamp DateNextAction) {
		if (get_ID() == 0) {
			super.setDateNextAction(DateNextAction);
		}
	}

	/**
	 * Set Escalated.
	 *
	 * @param IsEscalated This request has been escalated
	 */
	@JsonProperty("IsEscalated")
	public void setIsEscalatedInput(I_AD_Ref_ListInput IsEscalated) {
		this.mIsEscalated = IsEscalated;
		MRefList_BH foreignEntity;
		if (get_ID() == 0 &&IsEscalated != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsEscalated.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setIsEscalated(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + IsEscalated.getUUID());
			}
		}
	}

	/**
	 * Get Escalated.
	 *
	 * @return This request has been escalated
	 */
	@JsonProperty("IsEscalated")
	public I_AD_Ref_ListInput IsEscalated() {
		return mIsEscalated;
	}
	/**
	 * Set Invoiced.
	 *
	 * @param IsInvoiced Is this invoiced?
	 */

	public void setIsInvoiced(boolean IsInvoiced) {
		if (get_ID() == 0) {
			super.setIsInvoiced(IsInvoiced);
		}
	}

	/**
	 * Set Self-Service.
	 *
	 * @param IsSelfService This is a Self-Service entry or this entry can be changed via Self-Service
	 */
	@JsonProperty("IsSelfService")
	public void setIsSelfServiceInput(I_AD_Ref_ListInput IsSelfService) {
		this.mIsSelfService = IsSelfService;
		MRefList_BH foreignEntity;
		if (get_ID() == 0 &&IsSelfService != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsSelfService.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setIsSelfService(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + IsSelfService.getUUID());
			}
		}
	}

	/**
	 * Get Self-Service.
	 *
	 * @return This is a Self-Service entry or this entry can be changed via Self-Service
	 */
	@JsonProperty("IsSelfService")
	public I_AD_Ref_ListInput IsSelfService() {
		return mIsSelfService;
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
		if (get_ID() == 0 && M_InOut != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_InOut", "M_InOut_UU=?", get_TrxName())
							.setParameters(M_InOut.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_InOut_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_InOut with UUID " + M_InOut.getUUID());
			}
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
		if (get_ID() == 0 && M_Product != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_Product.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UUID " + M_Product.getUUID());
			}
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
		if (get_ID() == 0 && M_RMA != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_RMA", "M_RMA_UU=?", get_TrxName())
							.setParameters(M_RMA.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_RMA_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_RMA with UUID " + M_RMA.getUUID());
			}
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
	 * Set Null Columns.
	 *
	 * @param NullColumns Columns with NULL value
	 */

	public void setNullColumns(String NullColumns) {
		if (get_ID() == 0) {
			super.setNullColumns(NullColumns);
		}
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
		if (get_ID() == 0 &&Priority != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Priority.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPriority(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + Priority.getUUID());
			}
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
		if (get_ID() == 0 &&PriorityUser != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PriorityUser.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPriorityUser(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + PriorityUser.getUUID());
			}
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
		if (get_ID() == 0 && R_Category != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "R_Category", "R_Category_UU=?", get_TrxName())
							.setParameters(R_Category.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_Category_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_Category with UUID " + R_Category.getUUID());
			}
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
		if (get_ID() == 0 && R_Group != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "R_Group", "R_Group_UU=?", get_TrxName())
							.setParameters(R_Group.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_Group_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_Group with UUID " + R_Group.getUUID());
			}
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
	 * Set Request.
	 *
	 * @param R_Request Request from a Business Partner or Prospect
	 */
	@JsonProperty("R_Request")
	public void setR_RequestInput(ForeignEntityInput R_Request) {
		this.mR_Request = R_Request;
		MRequest foreignEntity;
		if (get_ID() == 0 && R_Request != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "R_Request", "R_Request_UU=?", get_TrxName())
							.setParameters(R_Request.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_Request_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_Request with UUID " + R_Request.getUUID());
			}
		}
	}

	/**
	 * Get Request.
	 *
	 * @return Request from a Business Partner or Prospect
	 */
	@JsonProperty("R_Request")
	public ForeignEntityInput R_Request() {
		return mR_Request;
	}
	/**
	 * Set Request History.
	 *
	 * @param R_RequestAction_ID Request has been changed
	 */

	public void setR_RequestAction_ID(int R_RequestAction_ID) {
		if (get_ID() == 0) {
			super.setR_RequestAction_ID(R_RequestAction_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setR_RequestAction_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getR_RequestAction_UU();
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
		if (get_ID() == 0 && R_RequestType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "R_RequestType", "R_RequestType_UU=?", get_TrxName())
							.setParameters(R_RequestType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_RequestType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_RequestType with UUID " + R_RequestType.getUUID());
			}
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
		if (get_ID() == 0 && R_Resolution != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "R_Resolution", "R_Resolution_UU=?", get_TrxName())
							.setParameters(R_Resolution.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_Resolution_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_Resolution with UUID " + R_Resolution.getUUID());
			}
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
	 * Set Status.
	 *
	 * @param R_Status Request Status
	 */
	@JsonProperty("R_Status")
	public void setR_StatusInput(ForeignEntityInput R_Status) {
		this.mR_Status = R_Status;
		MStatus foreignEntity;
		if (get_ID() == 0 && R_Status != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "R_Status", "R_Status_UU=?", get_TrxName())
							.setParameters(R_Status.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_Status_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_Status with UUID " + R_Status.getUUID());
			}
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
	 * Set Sales Representative.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	@JsonProperty("SalesRep")
	public void setSalesRepInput(ForeignEntityInput SalesRep) {
		this.mSalesRep = SalesRep;
		MUser_BH foreignEntity;
		if (get_ID() == 0 && SalesRep != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(SalesRep.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setSalesRep_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + SalesRep.getUUID());
			}
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
	 * Set Summary.
	 *
	 * @param Summary Textual summary of this request
	 */

	public void setSummary(String Summary) {
		if (get_ID() == 0) {
			super.setSummary(Summary);
		}
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
