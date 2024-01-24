package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MOrgInfo_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBank;
import org.compiere.model.MCalendar;
import org.compiere.model.MCashBook;
import org.compiere.model.MImage;
import org.compiere.model.MLocation;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_OrgType;

import java.sql.ResultSet;

/**
 * Generated Model for AD_OrgInfo - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_OrgInfoInput extends MOrgInfo_BH implements I_AD_OrgInfoInput {

	private ForeignEntityInput mAD_Image;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_OrgType;
	private ForeignEntityInput mC_Calendar;
	private ForeignEntityInput mC_Location;
	private ForeignEntityInput mDropShip_Warehouse;
	private ForeignEntityInput mM_Warehouse;
	private ForeignEntityInput mSupervisor;
	private ForeignEntityInput mTransferBank;
	private ForeignEntityInput mTransferCashBook;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_OrgInfoInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MOrgInfo_BH(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_OrgInfo_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		X_AD_OrgType foreignEntity;
		if (AD_OrgType != null &&
				(foreignEntity = new Query(getCtx(), "AD_OrgType", "AD_OrgType_UU=?", get_TrxName())
						.setParameters(AD_OrgType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_OrgType_ID(foreignEntity.get_ID());
		} else {
			super.setAD_OrgType_ID(0);
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
	 * Set Calendar.
	 *
	 * @param C_Calendar Accounting Calendar Name
	 */
	@JsonProperty("C_Calendar")
	public void setC_CalendarInput(ForeignEntityInput C_Calendar) {
		this.mC_Calendar = C_Calendar;
		MCalendar foreignEntity;
		if (C_Calendar != null &&
				(foreignEntity = new Query(getCtx(), "C_Calendar", "C_Calendar_UU=?", get_TrxName())
						.setParameters(C_Calendar.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Calendar_ID(foreignEntity.get_ID());
		} else {
			super.setC_Calendar_ID(0);
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
	 * Set Drop Ship Warehouse.
	 *
	 * @param DropShip_Warehouse The (logical) warehouse to use for recording drop ship receipts and shipments.
	 */
	@JsonProperty("DropShip_Warehouse")
	public void setDropShip_WarehouseInput(ForeignEntityInput DropShip_Warehouse) {
		this.mDropShip_Warehouse = DropShip_Warehouse;
		MWarehouse_BH foreignEntity;
		if (DropShip_Warehouse != null &&
				(foreignEntity = new Query(getCtx(), "M_Warehouse", "M_Warehouse_UU=?", get_TrxName())
						.setParameters(DropShip_Warehouse.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setDropShip_Warehouse_ID(foreignEntity.get_ID());
		} else {
			super.setDropShip_Warehouse_ID(0);
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
	 * @param AD_Image Logo
	 */
	@JsonProperty("AD_Image")
	public void setAD_ImageInput(ForeignEntityInput AD_Image) {
		this.mAD_Image = AD_Image;
		MImage foreignEntity;
		if (AD_Image != null &&
				(foreignEntity = new Query(getCtx(), "AD_Image", "AD_Image_UU=?", get_TrxName())
						.setParameters(AD_Image.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setLogo_ID(foreignEntity.get_ID());
		} else {
			super.setLogo_ID(0);
		}
	}

	/**
	 * Get Logo.
	 *
	 * @return Logo
	 */
	@JsonProperty("AD_Image")
	public ForeignEntityInput AD_Image() {
		return mAD_Image;
	}

	/**
	 * Set Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	@JsonProperty("M_Warehouse")
	public void setM_WarehouseInput(ForeignEntityInput M_Warehouse) {
		this.mM_Warehouse = M_Warehouse;
		MWarehouse_BH foreignEntity;
		if (M_Warehouse != null &&
				(foreignEntity = new Query(getCtx(), "M_Warehouse", "M_Warehouse_UU=?", get_TrxName())
						.setParameters(M_Warehouse.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Warehouse_ID(foreignEntity.get_ID());
		} else {
			super.setM_Warehouse_ID(0);
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
		MUser_BH foreignEntity;
		if (Supervisor != null &&
				(foreignEntity = new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
						.setParameters(Supervisor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setSupervisor_ID(foreignEntity.get_ID());
		} else {
			super.setSupervisor_ID(0);
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
		MBank foreignEntity;
		if (TransferBank != null &&
				(foreignEntity = new Query(getCtx(), "C_Bank", "C_Bank_UU=?", get_TrxName())
						.setParameters(TransferBank.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setTransferBank_ID(foreignEntity.get_ID());
		} else {
			super.setTransferBank_ID(0);
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
		MCashBook foreignEntity;
		if (TransferCashBook != null &&
				(foreignEntity = new Query(getCtx(), "C_CashBook", "C_CashBook_UU=?", get_TrxName())
						.setParameters(TransferCashBook.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setTransferCashBook_ID(foreignEntity.get_ID());
		} else {
			super.setTransferCashBook_ID(0);
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
