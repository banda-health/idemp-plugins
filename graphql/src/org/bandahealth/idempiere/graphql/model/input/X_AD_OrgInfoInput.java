package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MOrgInfo_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_OrgInfoResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBank;
import org.compiere.model.MCalendar;
import org.compiere.model.MCashBook;
import org.compiere.model.MImage;
import org.compiere.model.MLocation;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_OrgType;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_OrgInfo - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_OrgInfoInput extends MOrgInfo_BH implements I_AD_OrgInfoInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_OrgType;
	private ForeignEntityInput mBH_Affiliation;
	private ForeignEntityInput mC_Calendar;
	private ForeignEntityInput mC_Location;
	private ForeignEntityInput mDropShip_Warehouse;
	private ForeignEntityInput mLogo;
	private ForeignEntityInput mM_Warehouse;
	private ForeignEntityInput mSupervisor;
	private ForeignEntityInput mTransferBank;
	private ForeignEntityInput mTransferCashBook;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_OrgInfo_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_OrgInfoInput(@JsonProperty("UU") String UU) {
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
		if (!is_new()) {
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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_OrgInfo_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_OrgInfo_UU();
	}

	/**
	 * Set Organization Type.
	 *
	 * @param AD_OrgType Organization Type
	 */
	@JsonProperty("AD_OrgType")
	public void setAD_OrgTypeInput(ForeignEntityInput AD_OrgType) {
		this.mAD_OrgType = AD_OrgType;
		if (AD_OrgType != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_OrgType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_OrgType", "AD_OrgType_UU=?", get_TrxName())
							.setParameters(AD_OrgType.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_OrgType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_OrgType with UU " + AD_OrgType.getUU());
			}
		} else {
			this.setAD_OrgType_ID(0);
		}
	}

	/**
	 * Get Organization Type.
	 *
	 * @return Organization Type
	 */
	@JsonProperty("AD_OrgType")
	public ForeignEntityInput AD_OrgType() {
		return mAD_OrgType;
	}

	/**
	 * Set Affiliation.
	 *
	 * @param BH_Affiliation Affiliation
	 */
	@JsonProperty("BH_Affiliation")
	public void setBH_AffiliationInput(ForeignEntityInput BH_Affiliation) {
		this.mBH_Affiliation = BH_Affiliation;
		if (BH_Affiliation != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_OrgInfoResolver.BH_AFFILIATION_UUIDS_BY_VALUE.containsValue(BH_Affiliation.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Affiliation.getUU() +
						" is not in the list defined for the BH_Affiliation column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Affiliation.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Affiliation(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Affiliation.getUU());
			}
		} else {
			this.setBH_Affiliation(null);
		}
	}

	/**
	 * Get Affiliation.
	 *
	 * @return Affiliation
	 */
	@JsonProperty("BH_Affiliation")
	public ForeignEntityInput BH_Affiliation() {
		return mBH_Affiliation;
	}

	/**
	 * Set Calendar.
	 *
	 * @param C_Calendar Accounting Calendar Name
	 */
	@JsonProperty("C_Calendar")
	public void setC_CalendarInput(ForeignEntityInput C_Calendar) {
		this.mC_Calendar = C_Calendar;
		if (C_Calendar != null) {
			// Since an entity was passed, make sure it's in the DB
			MCalendar foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Calendar", "C_Calendar_UU=?", get_TrxName())
							.setParameters(C_Calendar.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Calendar_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Calendar with UU " + C_Calendar.getUU());
			}
		} else {
			this.setC_Calendar_ID(0);
		}
	}

	/**
	 * Get Calendar.
	 *
	 * @return Accounting Calendar Name
	 */
	@JsonProperty("C_Calendar")
	public ForeignEntityInput C_Calendar() {
		return mC_Calendar;
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
							.setParameters(C_Location.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
	 * Set Drop Ship Warehouse.
	 *
	 * @param DropShip_Warehouse The (logical) warehouse to use for recording drop ship receipts and shipments.
	 */
	@JsonProperty("DropShip_Warehouse")
	public void setDropShip_WarehouseInput(ForeignEntityInput DropShip_Warehouse) {
		this.mDropShip_Warehouse = DropShip_Warehouse;
		if (DropShip_Warehouse != null) {
			// Since an entity was passed, make sure it's in the DB
			MWarehouse_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Warehouse", "M_Warehouse_UU=?", get_TrxName())
							.setParameters(DropShip_Warehouse.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setDropShip_Warehouse_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Warehouse with UU " + DropShip_Warehouse.getUU());
			}
		} else {
			this.setDropShip_Warehouse_ID(0);
		}
	}

	/**
	 * Get Drop Ship Warehouse.
	 *
	 * @return The (logical) warehouse to use for recording drop ship receipts and shipments.
	 */
	@JsonProperty("DropShip_Warehouse")
	public ForeignEntityInput DropShip_Warehouse() {
		return mDropShip_Warehouse;
	}

	/**
	 * Set Logo.
	 *
	 * @param Logo Logo
	 */
	@JsonProperty("Logo")
	public void setLogoInput(ForeignEntityInput Logo) {
		this.mLogo = Logo;
		if (Logo != null) {
			// Since an entity was passed, make sure it's in the DB
			MImage foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Image", "AD_Image_UU=?", get_TrxName())
							.setParameters(Logo.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setLogo_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Image with UU " + Logo.getUU());
			}
		} else {
			this.setLogo_ID(0);
		}
	}

	/**
	 * Get Logo.
	 *
	 * @return Logo
	 */
	@JsonProperty("Logo")
	public ForeignEntityInput Logo() {
		return mLogo;
	}

	/**
	 * Set Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	@JsonProperty("M_Warehouse")
	public void setM_WarehouseInput(ForeignEntityInput M_Warehouse) {
		this.mM_Warehouse = M_Warehouse;
		if (M_Warehouse != null) {
			// Since an entity was passed, make sure it's in the DB
			MWarehouse_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Warehouse", "M_Warehouse_UU=?", get_TrxName())
							.setParameters(M_Warehouse.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_Warehouse_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Warehouse with UU " + M_Warehouse.getUU());
			}
		} else {
			this.setM_Warehouse_ID(0);
		}
	}

	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	@JsonProperty("M_Warehouse")
	public ForeignEntityInput M_Warehouse() {
		return mM_Warehouse;
	}

	/**
	 * Set Supervisor.
	 *
	 * @param Supervisor Supervisor for this user/organization - used for escalation and approval
	 */
	@JsonProperty("Supervisor")
	public void setSupervisorInput(ForeignEntityInput Supervisor) {
		this.mSupervisor = Supervisor;
		if (Supervisor != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(Supervisor.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setSupervisor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + Supervisor.getUU());
			}
		} else {
			this.setSupervisor_ID(0);
		}
	}

	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	@JsonProperty("Supervisor")
	public ForeignEntityInput Supervisor() {
		return mSupervisor;
	}

	/**
	 * Set Bank for transfers.
	 *
	 * @param TransferBank Bank account depending on currency will be used from this bank for doing transfers
	 */
	@JsonProperty("TransferBank")
	public void setTransferBankInput(ForeignEntityInput TransferBank) {
		this.mTransferBank = TransferBank;
		if (TransferBank != null) {
			// Since an entity was passed, make sure it's in the DB
			MBank foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Bank", "C_Bank_UU=?", get_TrxName())
							.setParameters(TransferBank.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setTransferBank_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Bank with UU " + TransferBank.getUU());
			}
		} else {
			this.setTransferBank_ID(0);
		}
	}

	/**
	 * Get Bank for transfers.
	 *
	 * @return Bank account depending on currency will be used from this bank for doing transfers
	 */
	@JsonProperty("TransferBank")
	public ForeignEntityInput TransferBank() {
		return mTransferBank;
	}

	/**
	 * Set CashBook for transfers.
	 *
	 * @param TransferCashBook CashBook for transfers
	 */
	@JsonProperty("TransferCashBook")
	public void setTransferCashBookInput(ForeignEntityInput TransferCashBook) {
		this.mTransferCashBook = TransferCashBook;
		if (TransferCashBook != null) {
			// Since an entity was passed, make sure it's in the DB
			MCashBook foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_CashBook", "C_CashBook_UU=?", get_TrxName())
							.setParameters(TransferCashBook.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setTransferCashBook_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_CashBook with UU " + TransferCashBook.getUU());
			}
		} else {
			this.setTransferCashBook_ID(0);
		}
	}

	/**
	 * Get CashBook for transfers.
	 *
	 * @return CashBook for transfers
	 */
	@JsonProperty("TransferCashBook")
	public ForeignEntityInput TransferCashBook() {
		return mTransferCashBook;
	}
}
