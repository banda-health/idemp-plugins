/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package org.bandahealth.idempiere.base.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for BH_Visit_Family_Planning
 *  @author iDempiere (generated) 
 *  @version Release 12
 */
@SuppressWarnings("all")
public interface I_BH_Visit_Family_Planning 
{

    /** TableName=BH_Visit_Family_Planning */
    public static final String Table_Name = "BH_Visit_Family_Planning";

    /** AD_Table_ID=1000071 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Tenant.
	  * Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within tenant
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within tenant
	  */
	public int getAD_Org_ID();

    /** Column name BH_Cervical_Cancer_Screening */
    public static final String COLUMNNAME_BH_Cervical_Cancer_Screening = "BH_Cervical_Cancer_Screening";

	/** Set Cervical Cancer Screening	  */
	public void setBH_Cervical_Cancer_Screening (String BH_Cervical_Cancer_Screening);

	/** Get Cervical Cancer Screening	  */
	public String getBH_Cervical_Cancer_Screening();

    /** Column name BH_Cervical_Pap_Method */
    public static final String COLUMNNAME_BH_Cervical_Pap_Method = "BH_Cervical_Pap_Method";

	/** Set Cervical PAP Method	  */
	public void setBH_Cervical_Pap_Method (String BH_Cervical_Pap_Method);

	/** Get Cervical PAP Method	  */
	public String getBH_Cervical_Pap_Method();

    /** Column name BH_Cervical_Results */
    public static final String COLUMNNAME_BH_Cervical_Results = "BH_Cervical_Results";

	/** Set Cervical Results	  */
	public void setBH_Cervical_Results (String BH_Cervical_Results);

	/** Get Cervical Results	  */
	public String getBH_Cervical_Results();

    /** Column name BH_Contraceptive_Condoms */
    public static final String COLUMNNAME_BH_Contraceptive_Condoms = "BH_Contraceptive_Condoms";

	/** Set Condoms for FP	  */
	public void setBH_Contraceptive_Condoms (boolean BH_Contraceptive_Condoms);

	/** Get Condoms for FP	  */
	public boolean isBH_Contraceptive_Condoms();

    /** Column name BH_Contraceptive_Emergency */
    public static final String COLUMNNAME_BH_Contraceptive_Emergency = "BH_Contraceptive_Emergency";

	/** Set Emergency Contraception	  */
	public void setBH_Contraceptive_Emergency (boolean BH_Contraceptive_Emergency);

	/** Get Emergency Contraception	  */
	public boolean isBH_Contraceptive_Emergency();

    /** Column name BH_Contraceptive_Implants */
    public static final String COLUMNNAME_BH_Contraceptive_Implants = "BH_Contraceptive_Implants";

	/** Set Implants	  */
	public void setBH_Contraceptive_Implants (boolean BH_Contraceptive_Implants);

	/** Get Implants	  */
	public boolean isBH_Contraceptive_Implants();

    /** Column name BH_Contraceptive_Injectable */
    public static final String COLUMNNAME_BH_Contraceptive_Injectable = "BH_Contraceptive_Injectable";

	/** Set Injectable	  */
	public void setBH_Contraceptive_Injectable (boolean BH_Contraceptive_Injectable);

	/** Get Injectable	  */
	public boolean isBH_Contraceptive_Injectable();

    /** Column name BH_Contraceptive_Iucd */
    public static final String COLUMNNAME_BH_Contraceptive_Iucd = "BH_Contraceptive_Iucd";

	/** Set IUCD	  */
	public void setBH_Contraceptive_Iucd (boolean BH_Contraceptive_Iucd);

	/** Get IUCD	  */
	public boolean isBH_Contraceptive_Iucd();

    /** Column name BH_Contraceptive_Natural_Fp */
    public static final String COLUMNNAME_BH_Contraceptive_Natural_Fp = "BH_Contraceptive_Natural_Fp";

	/** Set Natural FP Methods	  */
	public void setBH_Contraceptive_Natural_Fp (boolean BH_Contraceptive_Natural_Fp);

	/** Get Natural FP Methods	  */
	public boolean isBH_Contraceptive_Natural_Fp();

    /** Column name BH_Contraceptive_Oral */
    public static final String COLUMNNAME_BH_Contraceptive_Oral = "BH_Contraceptive_Oral";

	/** Set Oral Contraceptive	  */
	public void setBH_Contraceptive_Oral (boolean BH_Contraceptive_Oral);

	/** Get Oral Contraceptive	  */
	public boolean isBH_Contraceptive_Oral();

    /** Column name BH_Contraceptive_Vsc */
    public static final String COLUMNNAME_BH_Contraceptive_Vsc = "BH_Contraceptive_Vsc";

	/** Set Voluntary Surgical Contraception	  */
	public void setBH_Contraceptive_Vsc (boolean BH_Contraceptive_Vsc);

	/** Get Voluntary Surgical Contraception	  */
	public boolean isBH_Contraceptive_Vsc();

    /** Column name BH_Cycle_Beads_Given */
    public static final String COLUMNNAME_BH_Cycle_Beads_Given = "BH_Cycle_Beads_Given";

	/** Set Cycle Beads Given	  */
	public void setBH_Cycle_Beads_Given (String BH_Cycle_Beads_Given);

	/** Get Cycle Beads Given	  */
	public String getBH_Cycle_Beads_Given();

    /** Column name BH_Emergency_Contraception_Given */
    public static final String COLUMNNAME_BH_Emergency_Contraception_Given = "BH_Emergency_Contraception_Given";

	/** Set Emergency Contraception Given	  */
	public void setBH_Emergency_Contraception_Given (String BH_Emergency_Contraception_Given);

	/** Get Emergency Contraception Given	  */
	public String getBH_Emergency_Contraception_Given();

    /** Column name BH_Emergency_Contraception_Notes */
    public static final String COLUMNNAME_BH_Emergency_Contraception_Notes = "BH_Emergency_Contraception_Notes";

	/** Set Emergency Contraception Notes	  */
	public void setBH_Emergency_Contraception_Notes (String BH_Emergency_Contraception_Notes);

	/** Get Emergency Contraception Notes	  */
	public String getBH_Emergency_Contraception_Notes();

    /** Column name BH_First_Ever_Contraceptive_User */
    public static final String COLUMNNAME_BH_First_Ever_Contraceptive_User = "BH_First_Ever_Contraceptive_User";

	/** Set First Ever Contraceptive User	  */
	public void setBH_First_Ever_Contraceptive_User (String BH_First_Ever_Contraceptive_User);

	/** Get First Ever Contraceptive User	  */
	public String getBH_First_Ever_Contraceptive_User();

    /** Column name BH_First_Visit_Fp_At_Clinic */
    public static final String COLUMNNAME_BH_First_Visit_Fp_At_Clinic = "BH_First_Visit_Fp_At_Clinic";

	/** Set First Visit FP at Clinic	  */
	public void setBH_First_Visit_Fp_At_Clinic (String BH_First_Visit_Fp_At_Clinic);

	/** Get First Visit FP at Clinic	  */
	public String getBH_First_Visit_Fp_At_Clinic();

    /** Column name BH_Hiv_Counseled_Tested */
    public static final String COLUMNNAME_BH_Hiv_Counseled_Tested = "BH_Hiv_Counseled_Tested";

	/** Set HIV Counseled/Tested	  */
	public void setBH_Hiv_Counseled_Tested (String BH_Hiv_Counseled_Tested);

	/** Get HIV Counseled/Tested	  */
	public String getBH_Hiv_Counseled_Tested();

    /** Column name BH_Hiv_Results */
    public static final String COLUMNNAME_BH_Hiv_Results = "BH_Hiv_Results";

	/** Set HIV Results	  */
	public void setBH_Hiv_Results (String BH_Hiv_Results);

	/** Get HIV Results	  */
	public String getBH_Hiv_Results();

    /** Column name BH_Implants_Type_Of_Visit */
    public static final String COLUMNNAME_BH_Implants_Type_Of_Visit = "BH_Implants_Type_Of_Visit";

	/** Set Implants Type of Visit	  */
	public void setBH_Implants_Type_Of_Visit (String BH_Implants_Type_Of_Visit);

	/** Get Implants Type of Visit	  */
	public String getBH_Implants_Type_Of_Visit();

    /** Column name BH_Injectable_Route */
    public static final String COLUMNNAME_BH_Injectable_Route = "BH_Injectable_Route";

	/** Set Injectable Route	  */
	public void setBH_Injectable_Route (String BH_Injectable_Route);

	/** Get Injectable Route	  */
	public String getBH_Injectable_Route();

    /** Column name BH_Injectable_Type_Of_Visit */
    public static final String COLUMNNAME_BH_Injectable_Type_Of_Visit = "BH_Injectable_Type_Of_Visit";

	/** Set Injectable Type of Visit	  */
	public void setBH_Injectable_Type_Of_Visit (String BH_Injectable_Type_Of_Visit);

	/** Get Injectable Type of Visit	  */
	public String getBH_Injectable_Type_Of_Visit();

    /** Column name BH_Ipv_Reproductive_Coercion */
    public static final String COLUMNNAME_BH_Ipv_Reproductive_Coercion = "BH_Ipv_Reproductive_Coercion";

	/** Set IPV/Reproductive Coercion	  */
	public void setBH_Ipv_Reproductive_Coercion (String BH_Ipv_Reproductive_Coercion);

	/** Get IPV/Reproductive Coercion	  */
	public String getBH_Ipv_Reproductive_Coercion();

    /** Column name BH_Iucd_Type_Of_Visit */
    public static final String COLUMNNAME_BH_Iucd_Type_Of_Visit = "BH_Iucd_Type_Of_Visit";

	/** Set IUCD Type of Visit	  */
	public void setBH_Iucd_Type_Of_Visit (String BH_Iucd_Type_Of_Visit);

	/** Get IUCD Type of Visit	  */
	public String getBH_Iucd_Type_Of_Visit();

    /** Column name BH_Natural_Fp_Counseled */
    public static final String COLUMNNAME_BH_Natural_Fp_Counseled = "BH_Natural_Fp_Counseled";

	/** Set Natural FP Counseled	  */
	public void setBH_Natural_Fp_Counseled (String BH_Natural_Fp_Counseled);

	/** Get Natural FP Counseled	  */
	public String getBH_Natural_Fp_Counseled();

    /** Column name BH_Oral_Type_Of_Visit */
    public static final String COLUMNNAME_BH_Oral_Type_Of_Visit = "BH_Oral_Type_Of_Visit";

	/** Set Oral Type of Visit	  */
	public void setBH_Oral_Type_Of_Visit (String BH_Oral_Type_Of_Visit);

	/** Get Oral Type of Visit	  */
	public String getBH_Oral_Type_Of_Visit();

    /** Column name BH_Postpartum_Fp */
    public static final String COLUMNNAME_BH_Postpartum_Fp = "BH_Postpartum_Fp";

	/** Set Postpartum FP	  */
	public void setBH_Postpartum_Fp (String BH_Postpartum_Fp);

	/** Get Postpartum FP	  */
	public String getBH_Postpartum_Fp();

    /** Column name BH_Referral_Community_From */
    public static final String COLUMNNAME_BH_Referral_Community_From = "BH_Referral_Community_From";

	/** Set Referral Community From	  */
	public void setBH_Referral_Community_From (String BH_Referral_Community_From);

	/** Get Referral Community From	  */
	public String getBH_Referral_Community_From();

    /** Column name BH_Referral_Community_To */
    public static final String COLUMNNAME_BH_Referral_Community_To = "BH_Referral_Community_To";

	/** Set Referral Community To	  */
	public void setBH_Referral_Community_To (String BH_Referral_Community_To);

	/** Get Referral Community To	  */
	public String getBH_Referral_Community_To();

    /** Column name BH_Referrals */
    public static final String COLUMNNAME_BH_Referrals = "BH_Referrals";

	/** Set Referrals	  */
	public void setBH_Referrals (String BH_Referrals);

	/** Get Referrals	  */
	public String getBH_Referrals();

    /** Column name BH_Referrals_Reason */
    public static final String COLUMNNAME_BH_Referrals_Reason = "BH_Referrals_Reason";

	/** Set Referrals Reason	  */
	public void setBH_Referrals_Reason (String BH_Referrals_Reason);

	/** Get Referrals Reason	  */
	public String getBH_Referrals_Reason();

    /** Column name BH_Remarks */
    public static final String COLUMNNAME_BH_Remarks = "BH_Remarks";

	/** Set Remarks	  */
	public void setBH_Remarks (String BH_Remarks);

	/** Get Remarks	  */
	public String getBH_Remarks();

    /** Column name BH_Screening_Cervical */
    public static final String COLUMNNAME_BH_Screening_Cervical = "BH_Screening_Cervical";

	/** Set Cervical Screening at Visit	  */
	public void setBH_Screening_Cervical (boolean BH_Screening_Cervical);

	/** Get Cervical Screening at Visit	  */
	public boolean isBH_Screening_Cervical();

    /** Column name BH_Screening_Hiv */
    public static final String COLUMNNAME_BH_Screening_Hiv = "BH_Screening_Hiv";

	/** Set HIV Screening at Visit	  */
	public void setBH_Screening_Hiv (boolean BH_Screening_Hiv);

	/** Get HIV Screening at Visit	  */
	public boolean isBH_Screening_Hiv();

    /** Column name BH_Screening_Ipv */
    public static final String COLUMNNAME_BH_Screening_Ipv = "BH_Screening_Ipv";

	/** Set IPV Screening at Visit	  */
	public void setBH_Screening_Ipv (boolean BH_Screening_Ipv);

	/** Get IPV Screening at Visit	  */
	public boolean isBH_Screening_Ipv();

    /** Column name BH_Screening_Tb */
    public static final String COLUMNNAME_BH_Screening_Tb = "BH_Screening_Tb";

	/** Set TB Screening at Visit	  */
	public void setBH_Screening_Tb (boolean BH_Screening_Tb);

	/** Get TB Screening at Visit	  */
	public boolean isBH_Screening_Tb();

    /** Column name BH_Tb_Screening */
    public static final String COLUMNNAME_BH_Tb_Screening = "BH_Tb_Screening";

	/** Set TB Screening	  */
	public void setBH_Tb_Screening (String BH_Tb_Screening);

	/** Get TB Screening	  */
	public String getBH_Tb_Screening();

    /** Column name BH_Visit_Family_Planning_ID */
    public static final String COLUMNNAME_BH_Visit_Family_Planning_ID = "BH_Visit_Family_Planning_ID";

	/** Set Visit Family Planning	  */
	public void setBH_Visit_Family_Planning_ID (int BH_Visit_Family_Planning_ID);

	/** Get Visit Family Planning	  */
	public int getBH_Visit_Family_Planning_ID();

    /** Column name BH_Visit_Family_Planning_UU */
    public static final String COLUMNNAME_BH_Visit_Family_Planning_UU = "BH_Visit_Family_Planning_UU";

	/** Set BH_Visit_Family_Planning_UU	  */
	public void setBH_Visit_Family_Planning_UU (String BH_Visit_Family_Planning_UU);

	/** Get BH_Visit_Family_Planning_UU	  */
	public String getBH_Visit_Family_Planning_UU();

    /** Column name BH_Visit_ID */
    public static final String COLUMNNAME_BH_Visit_ID = "BH_Visit_ID";

	/** Set Visit	  */
	public void setBH_Visit_ID (int BH_Visit_ID);

	/** Get Visit	  */
	public int getBH_Visit_ID();

	public I_BH_Visit getBH_Visit() throws RuntimeException;

    /** Column name BH_Vsc_Btl */
    public static final String COLUMNNAME_BH_Vsc_Btl = "BH_Vsc_Btl";

	/** Set VSC BTL	  */
	public void setBH_Vsc_Btl (boolean BH_Vsc_Btl);

	/** Get VSC BTL	  */
	public boolean isBH_Vsc_Btl();

    /** Column name BH_Vsc_Given */
    public static final String COLUMNNAME_BH_Vsc_Given = "BH_Vsc_Given";

	/** Set VSC Given	  */
	public void setBH_Vsc_Given (String BH_Vsc_Given);

	/** Get VSC Given	  */
	public String getBH_Vsc_Given();

    /** Column name BH_Vsc_Vasectomy */
    public static final String COLUMNNAME_BH_Vsc_Vasectomy = "BH_Vsc_Vasectomy";

	/** Set VSC Vasectomy	  */
	public void setBH_Vsc_Vasectomy (boolean BH_Vsc_Vasectomy);

	/** Get VSC Vasectomy	  */
	public boolean isBH_Vsc_Vasectomy();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();
}
