-- iDempiere now only grants access to active things, so remove access that might currently be there
DELETE
FROM
	ad_window_access
WHERE
	ad_window_id IN (
		SELECT ad_window_id
		FROM ad_window
		WHERE isactive = 'N'
	);
DELETE
FROM
	ad_process_access
WHERE
	ad_process_id IN (
		SELECT ad_process_id
		FROM ad_process
		WHERE isactive = 'N'
	);
DELETE
FROM
	ad_form_access
WHERE
	ad_form_id IN (
		SELECT ad_form_id
		FROM ad_form
		WHERE isactive = 'N'
	);
DELETE
FROM
	ad_workflow_access
WHERE
	ad_workflow_id IN (
		SELECT ad_workflow_id
		FROM ad_workflow
		WHERE isactive = 'N'
	);
DELETE
FROM
	ad_document_action_access
WHERE
	c_doctype_id IN (
		SELECT c_doctype_id
		FROM c_doctype
		WHERE isactive = 'N'
	);
DELETE
FROM
	ad_infowindow_access
WHERE
	ad_infowindow_id IN (
		SELECT ad_infowindow_id
		FROM ad_infowindow
		WHERE isactive = 'N'
	);

-- Make sure the DBs are in sync schematically
DROP VIEW IF EXISTS bh_c_order_payment_v CASCADE;

DROP VIEW IF EXISTS bh_c_order_v CASCADE;

DROP VIEW IF EXISTS bh_calc_open_balance_v;

DROP VIEW IF EXISTS bh_changelog_v;

DROP VIEW IF EXISTS bh_daily_orders_v;

DROP VIEW IF EXISTS bhcorderv;

DROP VIEW IF EXISTS bh_incomestatement_v;

DROP VIEW IF EXISTS bh_patient_id_generator_v;

DROP VIEW IF EXISTS bh_patient_transactions_summary_v;

DROP VIEW IF EXISTS bh_patient_transactions_v CASCADE;

DROP VIEW IF EXISTS bh_recent_windows_v;

DROP VIEW IF EXISTS bh_stocktake_v;

DROP VIEW IF EXISTS bh_system_usage_v;

DROP VIEW IF EXISTS bh_user_activity_v;

DROP VIEW IF EXISTS bh_visit_rate_v;

DROP VIEW IF EXISTS bh_stock_reorder_levels_v;

DROP VIEW IF EXISTS bh_daily_sold_inventory_v;

DROP VIEW IF EXISTS bh_reorder_inventory_v;

DROP VIEW IF EXISTS bh_current_inventory_v;

ALTER TABLE c_bpartner
	ALTER COLUMN bh_patientid TYPE varchar(100) USING bh_patientid::varchar(100);

ALTER TABLE ad_window_access
	ALTER COLUMN bh_candeactivate SET NOT NULL;

DROP VIEW IF EXISTS c_order_linetax_v;
DROP VIEW IF EXISTS c_order_linetax_vt;
DROP VIEW IF EXISTS m_inout_candidate_v;
DROP VIEW IF EXISTS rv_orderdetail;
DROP VIEW IF EXISTS rv_commissionrundetail;
DROP VIEW IF EXISTS c_order_header_v;
DROP VIEW IF EXISTS c_order_header_vt;
ALTER TABLE c_order
	ALTER COLUMN description TYPE varchar(255) USING description::varchar(255);

ALTER TABLE bh_defaultincludedrole
	ALTER COLUMN bh_defaultincludedrole_uu SET DEFAULT NULL::character varying;

ALTER TABLE bh_defaultincludedrole
	ALTER COLUMN db_usertype SET DEFAULT NULL::bpchar;

ALTER TABLE bh_defaultincludedrole
	ALTER COLUMN description SET DEFAULT NULL::character varying;

ALTER TABLE bh_defaultincludedrole
	ALTER COLUMN name SET DEFAULT NULL::character varying;

ALTER TABLE bh_defaultincludedrole
	ALTER COLUMN included_role_id SET DEFAULT NULL::numeric;

ALTER TABLE bh_i_product_quantity
	ALTER COLUMN description DROP DEFAULT;

ALTER TABLE bh_i_product_quantity
	ALTER COLUMN i_errormsg DROP DEFAULT;

ALTER TABLE bh_i_product_quantity
	ALTER COLUMN i_isimported DROP DEFAULT;

ALTER TABLE bh_i_product_quantity
	ALTER COLUMN processed DROP DEFAULT;

ALTER TABLE bh_i_product_quantity
	ALTER COLUMN processing DROP DEFAULT;

ALTER TABLE bh_i_product_quantity
	ALTER COLUMN bh_i_product_quantity_uu DROP DEFAULT;

ALTER TABLE bh_i_product_quantity
	ALTER COLUMN bh_reorder_level DROP DEFAULT;

ALTER TABLE bh_i_product_quantity
	ALTER COLUMN m_product_id DROP DEFAULT;

ALTER TABLE bh_i_product_quantity
	ALTER COLUMN bh_haslot3 DROP DEFAULT;

ALTER TABLE bh_i_product_quantity
	ALTER COLUMN bh_haslot1 DROP DEFAULT;

ALTER TABLE bh_i_product_quantity
	ALTER COLUMN bh_haslot2 DROP DEFAULT;

UPDATE c_bpartner_location
SET
	ispreservecustomname = 'N'
WHERE
	ispreservecustomname IS NULL;
ALTER TABLE c_bpartner_location
	ALTER COLUMN ispreservecustomname SET NOT NULL;

ALTER TABLE c_bpartner_location
	ALTER COLUMN ispreservecustomname SET DEFAULT 'N'::bpchar;

ALTER TABLE bh_paymentref
	DROP CONSTRAINT IF EXISTS bh_paymentref_bh_paymentref_uu_key;

ALTER TABLE bh_paymentref_bankacct
	DROP CONSTRAINT IF EXISTS bh_paymentref_bankacct_bh_paymentref_bankacct_uu_key;

ALTER TABLE bh_paymentref_bankacct
	DROP CONSTRAINT IF EXISTS bh_paymentref_bankacct_c_bankaccount_id_fkey;

ALTER TABLE bh_paymentref_bankacct
	DROP CONSTRAINT IF EXISTS bh_paymentref_bankacct_bh_paymentref_id_fkey;

ALTER TABLE bh_paymentref_bankacct
	DROP CONSTRAINT IF EXISTS bh_paymentref_bankacct_ad_client_id_fkey;

ALTER TABLE bh_paymentref_bankacct
	DROP CONSTRAINT IF EXISTS bh_paymentref_bankacct_ad_org_id_fkey;

ALTER TABLE bh_paymentref
	DROP CONSTRAINT IF EXISTS bh_paymentref_uu_idx;
ALTER TABLE bh_paymentref
	ADD CONSTRAINT bh_paymentref_uu_idx
		UNIQUE (bh_paymentref_uu);

ALTER TABLE bh_paymentref
	DROP CONSTRAINT IF EXISTS adreference_bhpaymentref;
ALTER TABLE bh_paymentref
	ADD CONSTRAINT adreference_bhpaymentref
		FOREIGN KEY (ad_reference_id) REFERENCES ad_reference
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE bh_paymentref_bankacct
	DROP CONSTRAINT IF EXISTS bh_paymentref_bankacct_uu_idx;
ALTER TABLE bh_paymentref_bankacct
	ADD CONSTRAINT bh_paymentref_bankacct_uu_idx
		UNIQUE (bh_paymentref_bankacct_uu);

ALTER TABLE bh_paymentref_bankacct
	DROP CONSTRAINT IF EXISTS adorg_bhpaymentrefbankacct;
ALTER TABLE bh_paymentref_bankacct
	ADD CONSTRAINT adorg_bhpaymentrefbankacct
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE bh_paymentref_bankacct
	DROP CONSTRAINT IF EXISTS cbankaccount_bhpaymentrefbanka;
ALTER TABLE bh_paymentref_bankacct
	ADD CONSTRAINT cbankaccount_bhpaymentrefbanka
		FOREIGN KEY (c_bankaccount_id) REFERENCES c_bankaccount
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE bh_paymentref_bankacct
	DROP CONSTRAINT IF EXISTS adclient_bhpaymentrefbankacct;
ALTER TABLE bh_paymentref_bankacct
	ADD CONSTRAINT adclient_bhpaymentrefbankacct
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE bh_paymentref_bankacct
	DROP CONSTRAINT IF EXISTS bhpaymentref_bhpaymentrefbanka;
ALTER TABLE bh_paymentref_bankacct
	ADD CONSTRAINT bhpaymentref_bhpaymentrefbanka
		FOREIGN KEY (bh_paymentref_id) REFERENCES bh_paymentref
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

CREATE OR REPLACE VIEW c_order_linetax_vt
		(ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ad_language, c_order_id, c_orderline_id,
		 c_tax_id, taxindicator, c_bpartner_id, c_bpartner_location_id, bpname, c_location_id, line, m_product_id,
		 vendorproductno, qtyordered, qtyentered, uomsymbol, name, description, documentnote, upc, sku, productvalue,
		 resourcedescription, pricelist, priceenteredlist, discount, priceactual, priceentered, linenetamt,
		 productdescription, imageurl, c_campaign_id, c_project_id, c_activity_id, c_projectphase_id, c_projecttask_id,
		 c_orderline_ad_orgtrx_id, c_orderline_c_charge_id, c_orderline_c_currency_id, c_uom_id, datedelivered,
		 dateinvoiced, dateordered, c_orderline_datepromised, c_orderline_freightamt, isdescription, link_orderline_id,
		 m_promotion_id, c_orderline_m_shipper_id, c_orderline_m_warehouse_id, pricecost, pricelimit, c_orderline_processed,
		 qtydelivered, qtyinvoiced, qtylostsales, qtyreserved, ref_orderline_id, rramt, rrstartdate,
		 s_resourceassignment_id, c_orderline_user1_id, c_orderline_user2_id, c_uom_ad_org_id, costingprecision,
		 c_uom_description, c_uom_isactive, isdefault, c_uom_name, stdprecision, uomtype, x12de355, c_order_ad_org_id,
		 c_order_ad_orgtrx_id, ad_user_id, amountrefunded, amounttendered, bill_bpartner_id, bill_location_id, bill_user_id,
		 c_order_c_activity_id, c_order_c_bpartner_id, c_order_c_campaign_id, c_cashline_id, c_cashplanline_id,
		 c_order_c_charge_id, c_conversiontype_id, c_order_c_currency_id, c_doctype_id, c_doctypetarget_id, chargeamt,
		 copyfrom, c_payment_id, c_paymentterm_id, c_pos_id, c_order_c_project_id, c_order_created, c_order_createdby,
		 dateacct, dateprinted, c_order_datepromised, deliveryrule, deliveryviarule, c_order_description, docaction,
		 docstatus, documentno, dropship_bpartner_id, dropship_location_id, dropship_user_id, c_order_freightamt,
		 freightcostrule, grandtotal, invoicerule, c_order_isactive, isapproved, iscreditapproved, isdelivered,
		 c_order_isdiscountprinted, c_order_isdropship, isinvoiced, ispayschedulevalid, isprinted, isselected,
		 c_order_isselfservice, issotrx, istaxincluded, istransferred, link_order_id, c_order_m_freightcategory_id,
		 c_order_m_pricelist_id, c_order_m_shipper_id, c_order_m_warehouse_id, ordertype, pay_bpartner_id, pay_location_id,
		 c_order_paymentrule, poreference, posted, priorityrule, c_order_processed, processedon, promotioncode,
		 ref_order_id, salesrep_id, c_order_sendemail, totallines, c_order_updated, c_order_updatedby, c_order_user1_id,
		 c_order_user2_id, c_order_volume, c_order_weight, m_product_ad_org_id, classification, m_product_copyfrom,
		 m_product_created, m_product_createdby, c_revenuerecognition_id, c_subscriptiontype_id, c_taxcategory_id,
		 m_product_c_uom_id, descriptionurl, m_product_discontinued, m_product_discontinuedat, group1, group2,
		 guaranteedays, guaranteedaysmin, help, m_product_isactive, isbom, m_product_isdropship, isexcludeautodelivery,
		 isinvoiceprintdetails, ispicklistprintdetails, ispurchased, m_product_isselfservice, issold, isstocked,
		 m_product_issummary, isverified, iswebstorefeatured, lowlevel, m_attributeset_id, m_attributesetinstance_id,
		 m_product_m_freightcategory_id, m_locator_id, m_product_product_category_id, m_product_processing, producttype,
		 r_mailtext_id, m_product_salesrep_id, s_expensetype_id, shelfdepth, shelfheight, shelfwidth, s_resource_id,
		 unitsperpack, unitsperpallet, m_product_updated, m_product_updatedby, versionno, m_product_volume,
		 m_product_weight, m_product_po_ad_org_id, m_product_po_c_bpartner_id, m_product_po_c_currency_id, costperorder,
		 m_product_po_created, m_product_po_createdby, m_product_po_c_uom_id, deliverytime_actual, deliverytime_promised,
		 m_product_po_discontinued, m_product_po_discontinuedat, m_product_po_isactive, iscurrentvendor,
		 m_product_po_manufacturer, m_product_po_m_product_id, order_min, order_pack, priceeffective, pricelastinv,
		 pricelastpo, m_product_po_pricelist, pricepo, m_product_po_qualityrating, royaltyamt, m_product_po_upc,
		 m_product_po_updated, m_product_po_updatedby, m_product_po_vendorcategory, s_resourceassignment_ad_org_id,
		 assigndatefrom, assigndateto, s_resourceassignment_created, s_resourceassignment_createby,
		 s_resourceassignment_isactive, isconfirmed, s_resourceassignment_name, s_resourceassignment_qty,
		 s_resourceassignment_s_resour, s_resourceassignment_updated, s_resourceassignment_updatedby, c_charge_c_org_id,
		 c_charge_c_bpartner_id, c_chargetype_id, c_charge_chargeamt, c_charge_c_taxcategory_id, c_charge_description,
		 c_charge_isactive, issamecurrency, issametax, c_charge_istaxincluded, c_bpartner_product_ad_org_id,
		 c_bp_product_c_bpartner_id, c_bpartner_product_created, c_bpartner_product_createdby,
		 c_bpartner_product_descriptio, c_bpartner_product_isactive, ismanufacturer, c_bpartner_product_manufactur,
		 c_bpartner_product_qualityrat, shelflifemindays, c_bpartner_product_shelflifem, c_bpartner_product_updated,
		 c_bpartner_product_updatedby, c_bpartner_product_vendorcate, acqusitioncost, actuallifetimevalue,
		 c_bpartner_ad_language, ad_orgbp_id, c_bpartner_ad_org_id, bpartner_parent_id, c_bp_group_id, c_dunning_id,
		 c_greeting_id, c_invoiceschedule_id, c_bpartner_c_paymentterm_id, c_bpartner_created, c_bpartner_createdby,
		 c_bpartner_c_taxgroup_id, c_bpartner_deliveryrule, c_bpartner_deliveryviarule, c_bpartner_description,
		 c_bpartner_dunninggrace, duns, c_bpartner_firstsale, c_bpartner_flatdiscount, c_bpartner_freightcostrule,
		 c_bpartner_invoicerule, c_bpartner_isactive, iscustomer, c_bpartner_isdiscountprinted, c_bpartner_isemployee,
		 c_bpartner_ismanufacturer, isonetime, ispotaxexempt, isprospect, issalesrep, c_bpartner_issummary,
		 c_bpartner_istaxexempt, isvendor, logo_id, m_discountschema_id, c_bpartner_m_pricelist_id, naics, c_bpartner_name,
		 c_bpartner_name2, numberemployees, c_bpartner_paymentrule, paymentrulepo, po_discountschema_id, po_paymentterm_id,
		 po_pricelist_id, c_bpartner_poreference, potentiallifetimevalue, c_bpartner_rating, c_bpartner_referenceno,
		 c_bpartner_salesrep_id, salesvolume, c_bpartner_sendemail, shareofcustomer, c_bpartner_shelflifeminpct,
		 so_creditlimit, socreditstatus, so_creditused, so_description, c_bpartner_taxid, totalopenbalance,
		 c_bpartner_updated, c_bpartner_updatedby, c_bpartner_url, c_bpartner_value, c_bpartner_location_ad_org_id,
		 c_bpartner_location_c_bpartne, c_bpartner_location_created, c_bpartner_location_createdby, c_salesregion_id,
		 c_bpartner_location_fax, c_bpartner_location_isactive, isbillto, isdn, ispayfrom, isremitto, isshipto,
		 c_bpartner_location_name, c_bpartner_location_phone, c_bpartner_location_phone2, c_bpartner_location_updated,
		 c_bpartner_location_updatedby, c_tax_ad_org_id, ad_rule_id, c_country_id, c_region_id, c_tax_c_taxcategory_id,
		 c_tax_description, c_tax_isactive, c_tax_isdefault, isdocumentlevel, issalestax, c_tax_issummary,
		 c_tax_istaxexempt, c_tax_name, parent_tax_id, rate, requirestaxcertificate, sopotype, to_country_id,
		 c_tax_to_region_id, validfrom)
AS
SELECT
	ol.ad_client_id,
	ol.ad_org_id,
	ol.isactive,
	ol.created,
	ol.createdby,
	ol.updated,
	ol.updatedby,
	uomt.ad_language,
	ol.c_order_id,
	ol.c_orderline_id,
	ol.c_tax_id,
	tt.taxindicator,
	ol.c_bpartner_id,
	ol.c_bpartner_location_id,
	bp.name                                   AS bpname,
	bpl.c_location_id,
	ol.line,
	pt.m_product_id,
	po.vendorproductno,
	CASE
		WHEN ol.qtyordered <> 0::numeric OR ol.m_product_id IS NOT NULL THEN ol.qtyordered
		ELSE NULL::numeric
		END                                     AS qtyordered,
	CASE
		WHEN ol.qtyentered <> 0::numeric OR ol.m_product_id IS NOT NULL THEN ol.qtyentered
		ELSE NULL::numeric
		END                                     AS qtyentered,
	CASE
		WHEN ol.qtyentered <> 0::numeric OR ol.m_product_id IS NOT NULL THEN uomt.uomsymbol
		ELSE NULL::character varying
		END                                     AS uomsymbol,
	COALESCE(ct.name,
	         (COALESCE(pt.name, p.name)::text || productattribute(ol.m_attributesetinstance_id)::text)::character varying,
	         ol.description)                  AS name,
	CASE
		WHEN COALESCE(ct.name, pt.name, p.name) IS NOT NULL THEN ol.description
		ELSE NULL::character varying
		END                                     AS description,
	COALESCE(pt.documentnote, p.documentnote) AS documentnote,
	p.upc,
	p.sku,
	COALESCE(pp.vendorproductno, p.value)     AS productvalue,
	ra.description                            AS resourcedescription,
	CASE
		WHEN i.isdiscountprinted = 'Y'::bpchar AND ol.pricelist <> 0::numeric THEN ol.pricelist
		ELSE NULL::numeric
		END                                     AS pricelist,
	CASE
		WHEN i.isdiscountprinted = 'Y'::bpchar AND ol.pricelist <> 0::numeric AND ol.qtyentered <> 0::numeric
			THEN ol.pricelist * ol.qtyordered / ol.qtyentered
		ELSE NULL::numeric
		END                                     AS priceenteredlist,
	CASE
		WHEN i.isdiscountprinted = 'Y'::bpchar AND ol.pricelist > ol.priceactual AND ol.pricelist <> 0::numeric
			THEN (ol.pricelist - ol.priceactual) / ol.pricelist * 100::numeric
		ELSE NULL::numeric
		END                                     AS discount,
	CASE
		WHEN ol.priceactual <> 0::numeric OR ol.m_product_id IS NOT NULL THEN ol.priceactual
		ELSE NULL::numeric
		END                                     AS priceactual,
	CASE
		WHEN ol.priceentered <> 0::numeric OR ol.m_product_id IS NOT NULL THEN ol.priceentered
		ELSE NULL::numeric
		END                                     AS priceentered,
	CASE
		WHEN ol.linenetamt <> 0::numeric OR ol.m_product_id IS NOT NULL THEN ol.linenetamt
		ELSE NULL::numeric
		END                                     AS linenetamt,
	pt.description                            AS productdescription,
	p.imageurl,
	ol.c_campaign_id,
	ol.c_project_id,
	ol.c_activity_id,
	ol.c_projectphase_id,
	ol.c_projecttask_id,
	ol.ad_orgtrx_id                           AS c_orderline_ad_orgtrx_id,
	ol.c_charge_id                            AS c_orderline_c_charge_id,
	ol.c_currency_id                          AS c_orderline_c_currency_id,
	ol.c_uom_id,
	ol.datedelivered,
	ol.dateinvoiced,
	ol.dateordered,
	ol.datepromised                           AS c_orderline_datepromised,
	ol.freightamt                             AS c_orderline_freightamt,
	ol.isdescription,
	ol.link_orderline_id,
	ol.m_promotion_id,
	ol.m_shipper_id                           AS c_orderline_m_shipper_id,
	ol.m_warehouse_id                         AS c_orderline_m_warehouse_id,
	ol.pricecost,
	ol.pricelimit,
	ol.processed                              AS c_orderline_processed,
	ol.qtydelivered,
	ol.qtyinvoiced,
	ol.qtylostsales,
	ol.qtyreserved,
	ol.ref_orderline_id,
	ol.rramt,
	ol.rrstartdate,
	ol.s_resourceassignment_id,
	ol.user1_id                               AS c_orderline_user1_id,
	ol.user2_id                               AS c_orderline_user2_id,
	uomt.ad_org_id                            AS c_uom_ad_org_id,
	uom.costingprecision,
	uomt.description                          AS c_uom_description,
	uomt.isactive                             AS c_uom_isactive,
	uom.isdefault,
	uomt.name                                 AS c_uom_name,
	uom.stdprecision,
	uom.uomtype,
	uom.x12de355,
	i.ad_org_id                               AS c_order_ad_org_id,
	i.ad_orgtrx_id                            AS c_order_ad_orgtrx_id,
	i.ad_user_id,
	i.amountrefunded,
	i.amounttendered,
	i.bill_bpartner_id,
	i.bill_location_id,
	i.bill_user_id,
	i.c_activity_id                           AS c_order_c_activity_id,
	i.c_bpartner_id                           AS c_order_c_bpartner_id,
	i.c_campaign_id                           AS c_order_c_campaign_id,
	i.c_cashline_id,
	i.c_cashplanline_id,
	i.c_charge_id                             AS c_order_c_charge_id,
	i.c_conversiontype_id,
	i.c_currency_id                           AS c_order_c_currency_id,
	i.c_doctype_id,
	i.c_doctypetarget_id,
	i.chargeamt,
	i.copyfrom,
	i.c_payment_id,
	i.c_paymentterm_id,
	i.c_pos_id,
	i.c_project_id                            AS c_order_c_project_id,
	i.created                                 AS c_order_created,
	i.createdby                               AS c_order_createdby,
	i.dateacct,
	i.dateprinted,
	i.datepromised                            AS c_order_datepromised,
	i.deliveryrule,
	i.deliveryviarule,
	i.description                             AS c_order_description,
	i.docaction,
	i.docstatus,
	i.documentno,
	i.dropship_bpartner_id,
	i.dropship_location_id,
	i.dropship_user_id,
	i.freightamt                              AS c_order_freightamt,
	i.freightcostrule,
	i.grandtotal,
	i.invoicerule,
	i.isactive                                AS c_order_isactive,
	i.isapproved,
	i.iscreditapproved,
	i.isdelivered,
	i.isdiscountprinted                       AS c_order_isdiscountprinted,
	i.isdropship                              AS c_order_isdropship,
	i.isinvoiced,
	i.ispayschedulevalid,
	i.isprinted,
	i.isselected,
	i.isselfservice                           AS c_order_isselfservice,
	i.issotrx,
	i.istaxincluded,
	i.istransferred,
	i.link_order_id,
	i.m_freightcategory_id                    AS c_order_m_freightcategory_id,
	i.m_pricelist_id                          AS c_order_m_pricelist_id,
	i.m_shipper_id                            AS c_order_m_shipper_id,
	i.m_warehouse_id                          AS c_order_m_warehouse_id,
	i.ordertype,
	i.pay_bpartner_id,
	i.pay_location_id,
	i.paymentrule                             AS c_order_paymentrule,
	i.poreference,
	i.posted,
	i.priorityrule,
	i.processed                               AS c_order_processed,
	i.processedon,
	i.promotioncode,
	i.ref_order_id,
	i.salesrep_id,
	i.sendemail                               AS c_order_sendemail,
	i.totallines,
	i.updated                                 AS c_order_updated,
	i.updatedby                               AS c_order_updatedby,
	i.user1_id                                AS c_order_user1_id,
	i.user2_id                                AS c_order_user2_id,
	i.volume                                  AS c_order_volume,
	i.weight                                  AS c_order_weight,
	pt.ad_org_id                              AS m_product_ad_org_id,
	p.classification,
	p.copyfrom                                AS m_product_copyfrom,
	pt.created                                AS m_product_created,
	pt.createdby                              AS m_product_createdby,
	p.c_revenuerecognition_id,
	p.c_subscriptiontype_id,
	p.c_taxcategory_id,
	p.c_uom_id                                AS m_product_c_uom_id,
	p.descriptionurl,
	p.discontinued                            AS m_product_discontinued,
	p.discontinuedat                          AS m_product_discontinuedat,
	p.group1,
	p.group2,
	p.guaranteedays,
	p.guaranteedaysmin,
	p.help,
	pt.isactive                               AS m_product_isactive,
	p.isbom,
	p.isdropship                              AS m_product_isdropship,
	p.isexcludeautodelivery,
	p.isinvoiceprintdetails,
	p.ispicklistprintdetails,
	p.ispurchased,
	p.isselfservice                           AS m_product_isselfservice,
	p.issold,
	p.isstocked,
	p.issummary                               AS m_product_issummary,
	p.isverified,
	p.iswebstorefeatured,
	p.lowlevel,
	p.m_attributeset_id,
	p.m_attributesetinstance_id,
	p.m_freightcategory_id                    AS m_product_m_freightcategory_id,
	p.m_locator_id,
	p.m_product_category_id                   AS m_product_product_category_id,
	p.processing                              AS m_product_processing,
	p.producttype,
	p.r_mailtext_id,
	p.salesrep_id                             AS m_product_salesrep_id,
	p.s_expensetype_id,
	p.shelfdepth,
	p.shelfheight,
	p.shelfwidth,
	p.s_resource_id,
	p.unitsperpack,
	p.unitsperpallet,
	pt.updated                                AS m_product_updated,
	pt.updatedby                              AS m_product_updatedby,
	p.versionno,
	p.volume                                  AS m_product_volume,
	p.weight                                  AS m_product_weight,
	po.ad_org_id                              AS m_product_po_ad_org_id,
	po.c_bpartner_id                          AS m_product_po_c_bpartner_id,
	po.c_currency_id                          AS m_product_po_c_currency_id,
	po.costperorder,
	po.created                                AS m_product_po_created,
	po.createdby                              AS m_product_po_createdby,
	po.c_uom_id                               AS m_product_po_c_uom_id,
	po.deliverytime_actual,
	po.deliverytime_promised,
	po.discontinued                           AS m_product_po_discontinued,
	po.discontinuedat                         AS m_product_po_discontinuedat,
	po.isactive                               AS m_product_po_isactive,
	po.iscurrentvendor,
	po.manufacturer                           AS m_product_po_manufacturer,
	po.m_product_id                           AS m_product_po_m_product_id,
	po.order_min,
	po.order_pack,
	po.priceeffective,
	po.pricelastinv,
	po.pricelastpo,
	po.pricelist                              AS m_product_po_pricelist,
	po.pricepo,
	po.qualityrating                          AS m_product_po_qualityrating,
	po.royaltyamt,
	po.upc                                    AS m_product_po_upc,
	po.updated                                AS m_product_po_updated,
	po.updatedby                              AS m_product_po_updatedby,
	po.vendorcategory                         AS m_product_po_vendorcategory,
	ra.ad_org_id                              AS s_resourceassignment_ad_org_id,
	ra.assigndatefrom,
	ra.assigndateto,
	ra.created                                AS s_resourceassignment_created,
	ra.createdby                              AS s_resourceassignment_createby,
	ra.isactive                               AS s_resourceassignment_isactive,
	ra.isconfirmed,
	ra.name                                   AS s_resourceassignment_name,
	ra.qty                                    AS s_resourceassignment_qty,
	ra.s_resource_id                          AS s_resourceassignment_s_resour,
	ra.updated                                AS s_resourceassignment_updated,
	ra.updatedby                              AS s_resourceassignment_updatedby,
	ct.ad_org_id                              AS c_charge_c_org_id,
	c.c_bpartner_id                           AS c_charge_c_bpartner_id,
	c.c_chargetype_id,
	c.chargeamt                               AS c_charge_chargeamt,
	c.c_taxcategory_id                        AS c_charge_c_taxcategory_id,
	c.description                             AS c_charge_description,
	ct.isactive                               AS c_charge_isactive,
	c.issamecurrency,
	c.issametax,
	c.istaxincluded                           AS c_charge_istaxincluded,
	pp.ad_org_id                              AS c_bpartner_product_ad_org_id,
	pp.c_bpartner_id                          AS c_bp_product_c_bpartner_id,
	pp.created                                AS c_bpartner_product_created,
	pp.createdby                              AS c_bpartner_product_createdby,
	pp.description                            AS c_bpartner_product_descriptio,
	pp.isactive                               AS c_bpartner_product_isactive,
	pp.ismanufacturer,
	pp.manufacturer                           AS c_bpartner_product_manufactur,
	pp.qualityrating                          AS c_bpartner_product_qualityrat,
	pp.shelflifemindays,
	pp.shelflifeminpct                        AS c_bpartner_product_shelflifem,
	pp.updated                                AS c_bpartner_product_updated,
	pp.updatedby                              AS c_bpartner_product_updatedby,
	pp.vendorcategory                         AS c_bpartner_product_vendorcate,
	bp.acqusitioncost,
	bp.actuallifetimevalue,
	bp.ad_language                            AS c_bpartner_ad_language,
	bp.ad_orgbp_id,
	bp.ad_org_id                              AS c_bpartner_ad_org_id,
	bp.bpartner_parent_id,
	bp.c_bp_group_id,
	bp.c_dunning_id,
	bp.c_greeting_id,
	bp.c_invoiceschedule_id,
	bp.c_paymentterm_id                       AS c_bpartner_c_paymentterm_id,
	bp.created                                AS c_bpartner_created,
	bp.createdby                              AS c_bpartner_createdby,
	bp.c_taxgroup_id                          AS c_bpartner_c_taxgroup_id,
	bp.deliveryrule                           AS c_bpartner_deliveryrule,
	bp.deliveryviarule                        AS c_bpartner_deliveryviarule,
	bp.description                            AS c_bpartner_description,
	bp.dunninggrace                           AS c_bpartner_dunninggrace,
	bp.duns,
	bp.firstsale                              AS c_bpartner_firstsale,
	bp.flatdiscount                           AS c_bpartner_flatdiscount,
	bp.freightcostrule                        AS c_bpartner_freightcostrule,
	bp.invoicerule                            AS c_bpartner_invoicerule,
	bp.isactive                               AS c_bpartner_isactive,
	bp.iscustomer,
	bp.isdiscountprinted                      AS c_bpartner_isdiscountprinted,
	bp.isemployee                             AS c_bpartner_isemployee,
	bp.ismanufacturer                         AS c_bpartner_ismanufacturer,
	bp.isonetime,
	bp.ispotaxexempt,
	bp.isprospect,
	bp.issalesrep,
	bp.issummary                              AS c_bpartner_issummary,
	bp.istaxexempt                            AS c_bpartner_istaxexempt,
	bp.isvendor,
	bp.logo_id,
	bp.m_discountschema_id,
	bp.m_pricelist_id                         AS c_bpartner_m_pricelist_id,
	bp.naics,
	bp.name                                   AS c_bpartner_name,
	bp.name2                                  AS c_bpartner_name2,
	bp.numberemployees,
	bp.paymentrule                            AS c_bpartner_paymentrule,
	bp.paymentrulepo,
	bp.po_discountschema_id,
	bp.po_paymentterm_id,
	bp.po_pricelist_id,
	bp.poreference                            AS c_bpartner_poreference,
	bp.potentiallifetimevalue,
	bp.rating                                 AS c_bpartner_rating,
	bp.referenceno                            AS c_bpartner_referenceno,
	bp.salesrep_id                            AS c_bpartner_salesrep_id,
	bp.salesvolume,
	bp.sendemail                              AS c_bpartner_sendemail,
	bp.shareofcustomer,
	bp.shelflifeminpct                        AS c_bpartner_shelflifeminpct,
	bp.so_creditlimit,
	bp.socreditstatus,
	bp.so_creditused,
	bp.so_description,
	bp.taxid                                  AS c_bpartner_taxid,
	bp.totalopenbalance,
	bp.updated                                AS c_bpartner_updated,
	bp.updatedby                              AS c_bpartner_updatedby,
	bp.url                                    AS c_bpartner_url,
	bp.value                                  AS c_bpartner_value,
	bpl.ad_org_id                             AS c_bpartner_location_ad_org_id,
	bpl.c_bpartner_id                         AS c_bpartner_location_c_bpartne,
	bpl.created                               AS c_bpartner_location_created,
	bpl.createdby                             AS c_bpartner_location_createdby,
	bpl.c_salesregion_id,
	bpl.fax                                   AS c_bpartner_location_fax,
	bpl.isactive                              AS c_bpartner_location_isactive,
	bpl.isbillto,
	bpl.isdn,
	bpl.ispayfrom,
	bpl.isremitto,
	bpl.isshipto,
	bpl.name                                  AS c_bpartner_location_name,
	bpl.phone                                 AS c_bpartner_location_phone,
	bpl.phone2                                AS c_bpartner_location_phone2,
	bpl.updated                               AS c_bpartner_location_updated,
	bpl.updatedby                             AS c_bpartner_location_updatedby,
	tt.ad_org_id                              AS c_tax_ad_org_id,
	t.ad_rule_id,
	t.c_country_id,
	t.c_region_id,
	t.c_taxcategory_id                        AS c_tax_c_taxcategory_id,
	tt.description                            AS c_tax_description,
	tt.isactive                               AS c_tax_isactive,
	t.isdefault                               AS c_tax_isdefault,
	t.isdocumentlevel,
	t.issalestax,
	t.issummary                               AS c_tax_issummary,
	t.istaxexempt                             AS c_tax_istaxexempt,
	tt.name                                   AS c_tax_name,
	t.parent_tax_id,
	t.rate,
	t.requirestaxcertificate,
	t.sopotype,
	t.to_country_id,
	t.to_region_id                            AS c_tax_to_region_id,
	t.validfrom
FROM
	c_orderline ol
		JOIN c_uom uom
		ON ol.c_uom_id = uom.c_uom_id
		JOIN c_uom_trl uomt
		ON ol.c_uom_id = uomt.c_uom_id
		JOIN c_order i
		ON ol.c_order_id = i.c_order_id
		LEFT JOIN m_product p
		ON ol.m_product_id = p.m_product_id
		LEFT JOIN m_product_trl pt
		ON ol.m_product_id = pt.m_product_id AND uomt.ad_language::text = pt.ad_language::text
		LEFT JOIN m_product_po po
		ON p.m_product_id = po.m_product_id AND i.c_bpartner_id = po.c_bpartner_id
		LEFT JOIN s_resourceassignment ra
		ON ol.s_resourceassignment_id = ra.s_resourceassignment_id
		LEFT JOIN c_charge c
		ON ol.c_charge_id = c.c_charge_id
		LEFT JOIN c_charge_trl ct
		ON ol.c_charge_id = ct.c_charge_id AND uomt.ad_language::text = ct.ad_language::text
		LEFT JOIN c_bpartner_product pp
		ON ol.m_product_id = pp.m_product_id AND i.c_bpartner_id = pp.c_bpartner_id
		JOIN c_bpartner bp
		ON ol.c_bpartner_id = bp.c_bpartner_id
		JOIN c_bpartner_location bpl
		ON ol.c_bpartner_location_id = bpl.c_bpartner_location_id
		LEFT JOIN c_tax t
		ON ol.c_tax_id = t.c_tax_id
		LEFT JOIN c_tax_trl tt
		ON ol.c_tax_id = tt.c_tax_id AND uomt.ad_language::text = tt.ad_language::text
UNION
SELECT
	ol.ad_client_id,
	ol.ad_org_id,
	ol.isactive,
	ol.created,
	ol.createdby,
	ol.updated,
	ol.updatedby,
	uomt.ad_language,
	ol.c_order_id,
	ol.c_orderline_id,
	ol.c_tax_id,
	NULL::character varying           AS taxindicator,
	NULL::numeric                     AS c_bpartner_id,
	NULL::numeric                     AS c_bpartner_location_id,
	NULL::character varying           AS bpname,
	NULL::numeric                     AS c_location_id,
	ol.line + bl.line / 100::numeric  AS line,
	pt.m_product_id,
	po.vendorproductno,
	CASE
		WHEN bl.isqtypercentage = 'N'::bpchar THEN ol.qtyordered * bl.qtybom
		ELSE ol.qtyordered * (bl.qtybatch / 100::numeric)
		END                             AS qtyordered,
	CASE
		WHEN bl.isqtypercentage = 'N'::bpchar THEN ol.qtyentered * bl.qtybom
		ELSE ol.qtyentered * (bl.qtybatch / 100::numeric)
		END                             AS qtyentered,
	uomt.uomsymbol,
	pt.name,
	bl.description,
	pt.documentnote,
	p.upc,
	p.sku,
	p.value                           AS productvalue,
	NULL::character varying           AS resourcedescription,
	NULL::numeric                     AS pricelist,
	NULL::numeric                     AS priceenteredlist,
	NULL::numeric                     AS discount,
	NULL::numeric                     AS priceactual,
	NULL::numeric                     AS priceentered,
	NULL::numeric                     AS linenetamt,
	pt.description                    AS productdescription,
	p.imageurl,
	ol.c_campaign_id,
	ol.c_project_id,
	ol.c_activity_id,
	ol.c_projectphase_id,
	ol.c_projecttask_id,
	ol.ad_orgtrx_id                   AS c_orderline_ad_orgtrx_id,
	ol.c_charge_id                    AS c_orderline_c_charge_id,
	ol.c_currency_id                  AS c_orderline_c_currency_id,
	ol.c_uom_id,
	ol.datedelivered,
	ol.dateinvoiced,
	ol.dateordered,
	ol.datepromised                   AS c_orderline_datepromised,
	ol.freightamt                     AS c_orderline_freightamt,
	ol.isdescription,
	ol.link_orderline_id,
	ol.m_promotion_id,
	ol.m_shipper_id                   AS c_orderline_m_shipper_id,
	ol.m_warehouse_id                 AS c_orderline_m_warehouse_id,
	ol.pricecost,
	ol.pricelimit,
	ol.processed                      AS c_orderline_processed,
	ol.qtydelivered,
	ol.qtyinvoiced,
	ol.qtylostsales,
	ol.qtyreserved,
	ol.ref_orderline_id,
	ol.rramt,
	ol.rrstartdate,
	ol.s_resourceassignment_id,
	ol.user1_id                       AS c_orderline_user1_id,
	ol.user2_id                       AS c_orderline_user2_id,
	uomt.ad_org_id                    AS c_uom_ad_org_id,
	uom.costingprecision,
	uom.description                   AS c_uom_description,
	uomt.isactive                     AS c_uom_isactive,
	uom.isdefault,
	uomt.name                         AS c_uom_name,
	uom.stdprecision,
	uom.uomtype,
	uom.x12de355,
	i.ad_org_id                       AS c_order_ad_org_id,
	i.ad_orgtrx_id                    AS c_order_ad_orgtrx_id,
	i.ad_user_id,
	i.amountrefunded,
	i.amounttendered,
	i.bill_bpartner_id,
	i.bill_location_id,
	i.bill_user_id,
	i.c_activity_id                   AS c_order_c_activity_id,
	i.c_bpartner_id                   AS c_order_c_bpartner_id,
	i.c_campaign_id                   AS c_order_c_campaign_id,
	i.c_cashline_id,
	i.c_cashplanline_id,
	i.c_charge_id                     AS c_order_c_charge_id,
	i.c_conversiontype_id,
	i.c_currency_id                   AS c_order_c_currency_id,
	i.c_doctype_id,
	i.c_doctypetarget_id,
	i.chargeamt,
	i.copyfrom,
	i.c_payment_id,
	i.c_paymentterm_id,
	i.c_pos_id,
	i.c_project_id                    AS c_order_c_project_id,
	i.created                         AS c_order_created,
	i.createdby                       AS c_order_createdby,
	i.dateacct,
	i.dateprinted,
	i.datepromised                    AS c_order_datepromised,
	i.deliveryrule,
	i.deliveryviarule,
	i.description                     AS c_order_description,
	i.docaction,
	i.docstatus,
	i.documentno,
	i.dropship_bpartner_id,
	i.dropship_location_id,
	i.dropship_user_id,
	i.freightamt                      AS c_order_freightamt,
	i.freightcostrule,
	i.grandtotal,
	i.invoicerule,
	i.isactive                        AS c_order_isactive,
	i.isapproved,
	i.iscreditapproved,
	i.isdelivered,
	i.isdiscountprinted               AS c_order_isdiscountprinted,
	i.isdropship                      AS c_order_isdropship,
	i.isinvoiced,
	i.ispayschedulevalid,
	i.isprinted,
	i.isselected,
	i.isselfservice                   AS c_order_isselfservice,
	i.issotrx,
	i.istaxincluded,
	i.istransferred,
	i.link_order_id,
	i.m_freightcategory_id            AS c_order_m_freightcategory_id,
	i.m_pricelist_id                  AS c_order_m_pricelist_id,
	i.m_shipper_id                    AS c_order_m_shipper_id,
	i.m_warehouse_id                  AS c_order_m_warehouse_id,
	i.ordertype,
	i.pay_bpartner_id,
	i.pay_location_id,
	i.paymentrule                     AS c_order_paymentrule,
	i.poreference,
	i.posted,
	i.priorityrule,
	i.processed                       AS c_order_processed,
	i.processedon,
	i.promotioncode,
	i.ref_order_id,
	i.salesrep_id,
	i.sendemail                       AS c_order_sendemail,
	i.totallines,
	i.updated                         AS c_order_updated,
	i.updatedby                       AS c_order_updatedby,
	i.user1_id                        AS c_order_user1_id,
	i.user2_id                        AS c_order_user2_id,
	i.volume                          AS c_order_volume,
	i.weight                          AS c_order_weight,
	pt.ad_org_id                      AS m_product_ad_org_id,
	p.classification,
	p.copyfrom                        AS m_product_copyfrom,
	pt.created                        AS m_product_created,
	pt.createdby                      AS m_product_createdby,
	p.c_revenuerecognition_id,
	p.c_subscriptiontype_id,
	p.c_taxcategory_id,
	p.c_uom_id                        AS m_product_c_uom_id,
	p.descriptionurl,
	p.discontinued                    AS m_product_discontinued,
	p.discontinuedat                  AS m_product_discontinuedat,
	p.group1,
	p.group2,
	p.guaranteedays,
	p.guaranteedaysmin,
	p.help,
	pt.isactive                       AS m_product_isactive,
	p.isbom,
	p.isdropship                      AS m_product_isdropship,
	p.isexcludeautodelivery,
	p.isinvoiceprintdetails,
	p.ispicklistprintdetails,
	p.ispurchased,
	p.isselfservice                   AS m_product_isselfservice,
	p.issold,
	p.isstocked,
	p.issummary                       AS m_product_issummary,
	p.isverified,
	p.iswebstorefeatured,
	p.lowlevel,
	p.m_attributeset_id,
	p.m_attributesetinstance_id,
	p.m_freightcategory_id            AS m_product_m_freightcategory_id,
	p.m_locator_id,
	p.m_product_category_id           AS m_product_product_category_id,
	p.processing                      AS m_product_processing,
	p.producttype,
	p.r_mailtext_id,
	p.salesrep_id                     AS m_product_salesrep_id,
	p.s_expensetype_id,
	p.shelfdepth,
	p.shelfheight,
	p.shelfwidth,
	p.s_resource_id,
	p.unitsperpack,
	p.unitsperpallet,
	p.updated                         AS m_product_updated,
	p.updatedby                       AS m_product_updatedby,
	p.versionno,
	p.volume                          AS m_product_volume,
	p.weight                          AS m_product_weight,
	po.ad_org_id                      AS m_product_po_ad_org_id,
	po.c_bpartner_id                  AS m_product_po_c_bpartner_id,
	po.c_currency_id                  AS m_product_po_c_currency_id,
	po.costperorder,
	po.created                        AS m_product_po_created,
	po.createdby                      AS m_product_po_createdby,
	po.c_uom_id                       AS m_product_po_c_uom_id,
	po.deliverytime_actual,
	po.deliverytime_promised,
	po.discontinued                   AS m_product_po_discontinued,
	po.discontinuedat                 AS m_product_po_discontinuedat,
	po.isactive                       AS m_product_po_isactive,
	po.iscurrentvendor,
	po.manufacturer                   AS m_product_po_manufacturer,
	po.m_product_id                   AS m_product_po_m_product_id,
	po.order_min,
	po.order_pack,
	po.priceeffective,
	po.pricelastinv,
	po.pricelastpo,
	po.pricelist                      AS m_product_po_pricelist,
	po.pricepo,
	po.qualityrating                  AS m_product_po_qualityrating,
	po.royaltyamt,
	po.upc                            AS m_product_po_upc,
	po.updated                        AS m_product_po_updated,
	po.updatedby                      AS m_product_po_updatedby,
	po.vendorcategory                 AS m_product_po_vendorcategory,
	NULL::numeric                     AS s_resourceassignment_ad_org_id,
	NULL::timestamp WITHOUT TIME ZONE AS assigndatefrom,
	NULL::timestamp WITHOUT TIME ZONE AS assigndateto,
	NULL::timestamp WITHOUT TIME ZONE AS s_resourceassignment_created,
	NULL::numeric                     AS s_resourceassignment_createby,
	NULL::bpchar                      AS s_resourceassignment_isactive,
	NULL::bpchar                      AS isconfirmed,
	NULL::character varying           AS s_resourceassignment_name,
	NULL::numeric                     AS s_resourceassignment_qty,
	NULL::numeric                     AS s_resourceassignment_s_resour,
	NULL::timestamp WITHOUT TIME ZONE AS s_resourceassignment_updated,
	NULL::numeric                     AS s_resourceassignment_updatedby,
	NULL::numeric                     AS c_charge_c_org_id,
	NULL::numeric                     AS c_charge_c_bpartner_id,
	NULL::numeric                     AS c_chargetype_id,
	NULL::numeric                     AS c_charge_chargeamt,
	NULL::numeric                     AS c_charge_c_taxcategory_id,
	NULL::character varying           AS c_charge_description,
	NULL::bpchar                      AS c_charge_isactive,
	NULL::bpchar                      AS issamecurrency,
	NULL::bpchar                      AS issametax,
	NULL::bpchar                      AS c_charge_istaxincluded,
	NULL::numeric                     AS c_bpartner_product_ad_org_id,
	NULL::numeric                     AS c_bp_product_c_bpartner_id,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_product_created,
	NULL::numeric                     AS c_bpartner_product_createdby,
	NULL::character varying           AS c_bpartner_product_descriptio,
	NULL::bpchar                      AS c_bpartner_product_isactive,
	NULL::bpchar                      AS ismanufacturer,
	NULL::character varying           AS c_bpartner_product_manufactur,
	NULL::numeric                     AS c_bpartner_product_qualityrat,
	NULL::numeric                     AS shelflifemindays,
	NULL::numeric                     AS c_bpartner_product_shelflifem,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_product_updated,
	NULL::numeric                     AS c_bpartner_product_updatedby,
	NULL::character varying           AS c_bpartner_product_vendorcate,
	NULL::numeric                     AS acqusitioncost,
	NULL::numeric                     AS actuallifetimevalue,
	NULL::character varying           AS c_bpartner_ad_language,
	NULL::numeric                     AS ad_orgbp_id,
	NULL::numeric                     AS c_bpartner_ad_org_id,
	NULL::numeric                     AS bpartner_parent_id,
	NULL::numeric                     AS c_bp_group_id,
	NULL::numeric                     AS c_dunning_id,
	NULL::numeric                     AS c_greeting_id,
	NULL::numeric                     AS c_invoiceschedule_id,
	NULL::numeric                     AS c_bpartner_c_paymentterm_id,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_created,
	NULL::numeric                     AS c_bpartner_createdby,
	NULL::numeric                     AS c_bpartner_c_taxgroup_id,
	NULL::bpchar                      AS c_bpartner_deliveryrule,
	NULL::bpchar                      AS c_bpartner_deliveryviarule,
	NULL::character varying           AS c_bpartner_description,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_dunninggrace,
	NULL::character varying           AS duns,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_firstsale,
	NULL::numeric                     AS c_bpartner_flatdiscount,
	NULL::bpchar                      AS c_bpartner_freightcostrule,
	NULL::bpchar                      AS c_bpartner_invoicerule,
	NULL::bpchar                      AS c_bpartner_isactive,
	NULL::bpchar                      AS iscustomer,
	NULL::bpchar                      AS c_bpartner_isdiscountprinted,
	NULL::bpchar                      AS c_bpartner_isemployee,
	NULL::bpchar                      AS c_bpartner_ismanufacturer,
	NULL::bpchar                      AS isonetime,
	NULL::bpchar                      AS ispotaxexempt,
	NULL::bpchar                      AS isprospect,
	NULL::bpchar                      AS issalesrep,
	NULL::bpchar                      AS c_bpartner_issummary,
	NULL::bpchar                      AS c_bpartner_istaxexempt,
	NULL::bpchar                      AS isvendor,
	NULL::numeric                     AS logo_id,
	NULL::numeric                     AS m_discountschema_id,
	NULL::numeric                     AS c_bpartner_m_pricelist_id,
	NULL::character varying           AS naics,
	NULL::character varying           AS c_bpartner_name,
	NULL::character varying           AS c_bpartner_name2,
	NULL::numeric                     AS numberemployees,
	NULL::bpchar                      AS c_bpartner_paymentrule,
	NULL::bpchar                      AS paymentrulepo,
	NULL::numeric                     AS po_discountschema_id,
	NULL::numeric                     AS po_paymentterm_id,
	NULL::numeric                     AS po_pricelist_id,
	NULL::character varying           AS c_bpartner_poreference,
	NULL::numeric                     AS potentiallifetimevalue,
	NULL::bpchar                      AS c_bpartner_rating,
	NULL::character varying           AS c_bpartner_referenceno,
	NULL::numeric                     AS c_bpartner_salesrep_id,
	NULL::numeric                     AS salesvolume,
	NULL::bpchar                      AS c_bpartner_sendemail,
	NULL::numeric                     AS shareofcustomer,
	NULL::numeric                     AS c_bpartner_shelflifeminpct,
	NULL::numeric                     AS so_creditlimit,
	NULL::bpchar                      AS socreditstatus,
	NULL::numeric                     AS so_creditused,
	NULL::character varying           AS so_description,
	NULL::character varying           AS c_bpartner_taxid,
	NULL::numeric                     AS totalopenbalance,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_updated,
	NULL::numeric                     AS c_bpartner_updatedby,
	NULL::character varying           AS c_bpartner_url,
	NULL::character varying           AS c_bpartner_value,
	NULL::numeric                     AS c_bpartner_location_ad_org_id,
	NULL::numeric                     AS c_bpartner_location_c_bpartne,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_location_created,
	NULL::numeric                     AS c_bpartner_location_createdby,
	NULL::numeric                     AS c_salesregion_id,
	NULL::character varying           AS c_bpartner_location_fax,
	NULL::bpchar                      AS c_bpartner_location_isactive,
	NULL::bpchar                      AS isbillto,
	NULL::character varying           AS isdn,
	NULL::bpchar                      AS ispayfrom,
	NULL::bpchar                      AS isremitto,
	NULL::bpchar                      AS isshipto,
	NULL::character varying           AS c_bpartner_location_name,
	NULL::character varying           AS c_bpartner_location_phone,
	NULL::character varying           AS c_bpartner_location_phone2,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_location_updated,
	NULL::numeric                     AS c_bpartner_location_updatedby,
	NULL::numeric                     AS c_tax_ad_org_id,
	NULL::numeric                     AS ad_rule_id,
	NULL::numeric                     AS c_country_id,
	NULL::numeric                     AS c_region_id,
	NULL::numeric                     AS c_tax_c_taxcategory_id,
	NULL::character varying           AS c_tax_description,
	NULL::bpchar                      AS c_tax_isactive,
	NULL::bpchar                      AS c_tax_isdefault,
	NULL::bpchar                      AS isdocumentlevel,
	NULL::bpchar                      AS issalestax,
	NULL::bpchar                      AS c_tax_issummary,
	NULL::bpchar                      AS c_tax_istaxexempt,
	NULL::character varying           AS c_tax_name,
	NULL::numeric                     AS parent_tax_id,
	NULL::numeric                     AS rate,
	NULL::bpchar                      AS requirestaxcertificate,
	NULL::bpchar                      AS sopotype,
	NULL::numeric                     AS to_country_id,
	NULL::numeric                     AS c_tax_to_region_id,
	NULL::timestamp WITHOUT TIME ZONE AS validfrom
FROM
	pp_product_bom b
		JOIN c_orderline ol
		ON b.m_product_id = ol.m_product_id
		JOIN c_order i
		ON ol.c_order_id = i.c_order_id
		JOIN m_product bp
		ON bp.m_product_id = ol.m_product_id AND bp.isbom = 'Y'::bpchar AND bp.isverified = 'Y'::bpchar AND
		   bp.isinvoiceprintdetails = 'Y'::bpchar
		JOIN pp_product_bomline bl
		ON bl.pp_product_bom_id = b.pp_product_bom_id
		JOIN m_product p
		ON p.m_product_id = bl.m_product_id
		LEFT JOIN m_product_po po
		ON p.m_product_id = po.m_product_id AND i.c_bpartner_id = po.c_bpartner_id
		JOIN c_uom uom
		ON ol.c_uom_id = uom.c_uom_id
		JOIN c_uom_trl uomt
		ON p.c_uom_id = uomt.c_uom_id
		JOIN m_product_trl pt
		ON pt.m_product_id = bl.m_product_id AND uomt.ad_language::text = pt.ad_language::text
UNION
SELECT
	i.ad_client_id,
	i.ad_org_id,
	i.isactive,
	i.created,
	i.createdby,
	i.updated,
	i.updatedby,
	l.ad_language,
	i.c_order_id,
	NULL::numeric                     AS c_orderline_id,
	NULL::numeric                     AS c_tax_id,
	NULL::character varying           AS taxindicator,
	NULL::numeric                     AS c_bpartner_id,
	NULL::numeric                     AS c_bpartner_location_id,
	NULL::character varying           AS bpname,
	NULL::numeric                     AS c_location_id,
	999998                            AS line,
	NULL::numeric                     AS m_product_id,
	NULL::character varying           AS vendorproductno,
	NULL::numeric                     AS qtyordered,
	NULL::numeric                     AS qtyentered,
	NULL::character varying           AS uomsymbol,
	NULL::character varying           AS name,
	NULL::character varying           AS description,
	NULL::character varying           AS documentnote,
	NULL::character varying           AS upc,
	NULL::character varying           AS sku,
	NULL::character varying           AS productvalue,
	NULL::character varying           AS resourcedescription,
	NULL::numeric                     AS pricelist,
	NULL::numeric                     AS priceenteredlist,
	NULL::numeric                     AS discount,
	NULL::numeric                     AS priceactual,
	NULL::numeric                     AS priceentered,
	NULL::numeric                     AS linenetamt,
	NULL::character varying           AS productdescription,
	NULL::character varying           AS imageurl,
	NULL::numeric                     AS c_campaign_id,
	NULL::numeric                     AS c_project_id,
	NULL::numeric                     AS c_activity_id,
	NULL::numeric                     AS c_projectphase_id,
	NULL::numeric                     AS c_projecttask_id,
	NULL::numeric                     AS c_orderline_ad_orgtrx_id,
	NULL::numeric                     AS c_orderline_c_charge_id,
	NULL::numeric                     AS c_orderline_c_currency_id,
	NULL::numeric                     AS c_uom_id,
	NULL::timestamp WITHOUT TIME ZONE AS datedelivered,
	NULL::timestamp WITHOUT TIME ZONE AS dateinvoiced,
	NULL::timestamp WITHOUT TIME ZONE AS dateordered,
	NULL::timestamp WITHOUT TIME ZONE AS c_orderline_datepromised,
	NULL::numeric                     AS c_orderline_freightamt,
	NULL::bpchar                      AS isdescription,
	NULL::numeric                     AS link_orderline_id,
	NULL::numeric                     AS m_promotion_id,
	NULL::numeric                     AS c_orderline_m_shipper_id,
	NULL::numeric                     AS c_orderline_m_warehouse_id,
	NULL::numeric                     AS pricecost,
	NULL::numeric                     AS pricelimit,
	NULL::bpchar                      AS c_orderline_processed,
	NULL::numeric                     AS qtydelivered,
	NULL::numeric                     AS qtyinvoiced,
	NULL::numeric                     AS qtylostsales,
	NULL::numeric                     AS qtyreserved,
	NULL::numeric                     AS ref_orderline_id,
	NULL::numeric                     AS rramt,
	NULL::timestamp WITHOUT TIME ZONE AS rrstartdate,
	NULL::numeric                     AS s_resourceassignment_id,
	NULL::numeric                     AS c_orderline_user1_id,
	NULL::numeric                     AS c_orderline_user2_id,
	NULL::numeric                     AS c_uom_ad_org_id,
	NULL::numeric                     AS costingprecision,
	NULL::character varying           AS c_uom_description,
	NULL::bpchar                      AS c_uom_isactive,
	NULL::bpchar                      AS isdefault,
	NULL::character varying           AS c_uom_name,
	NULL::numeric                     AS stdprecision,
	NULL::character varying           AS uomtype,
	NULL::character varying           AS x12de355,
	NULL::numeric                     AS c_order_ad_org_id,
	NULL::numeric                     AS c_order_ad_orgtrx_id,
	NULL::numeric                     AS ad_user_id,
	NULL::numeric                     AS amountrefunded,
	NULL::numeric                     AS amounttendered,
	NULL::numeric                     AS bill_bpartner_id,
	NULL::numeric                     AS bill_location_id,
	NULL::numeric                     AS bill_user_id,
	NULL::numeric                     AS c_order_c_activity_id,
	NULL::numeric                     AS c_order_c_bpartner_id,
	NULL::numeric                     AS c_order_c_campaign_id,
	NULL::numeric                     AS c_cashline_id,
	NULL::numeric                     AS c_cashplanline_id,
	NULL::numeric                     AS c_order_c_charge_id,
	NULL::numeric                     AS c_conversiontype_id,
	NULL::numeric                     AS c_order_c_currency_id,
	NULL::numeric                     AS c_doctype_id,
	NULL::numeric                     AS c_doctypetarget_id,
	NULL::numeric                     AS chargeamt,
	NULL::bpchar                      AS copyfrom,
	NULL::numeric                     AS c_payment_id,
	NULL::numeric                     AS c_paymentterm_id,
	NULL::numeric                     AS c_pos_id,
	NULL::numeric                     AS c_order_c_project_id,
	NULL::timestamp WITHOUT TIME ZONE AS c_order_created,
	NULL::numeric                     AS c_order_createdby,
	NULL::timestamp WITHOUT TIME ZONE AS dateacct,
	NULL::timestamp WITHOUT TIME ZONE AS dateprinted,
	NULL::timestamp WITHOUT TIME ZONE AS c_order_datepromised,
	NULL::bpchar                      AS deliveryrule,
	NULL::bpchar                      AS deliveryviarule,
	NULL::character varying           AS c_order_description,
	NULL::bpchar                      AS docaction,
	NULL::bpchar                      AS docstatus,
	NULL::character varying           AS documentno,
	NULL::numeric                     AS dropship_bpartner_id,
	NULL::numeric                     AS dropship_location_id,
	NULL::numeric                     AS dropship_user_id,
	NULL::numeric                     AS c_order_freightamt,
	NULL::bpchar                      AS freightcostrule,
	NULL::numeric                     AS grandtotal,
	NULL::bpchar                      AS invoicerule,
	NULL::bpchar                      AS c_order_isactive,
	NULL::bpchar                      AS isapproved,
	NULL::bpchar                      AS iscreditapproved,
	NULL::bpchar                      AS isdelivered,
	NULL::bpchar                      AS c_order_isdiscountprinted,
	NULL::bpchar                      AS c_order_isdropship,
	NULL::bpchar                      AS isinvoiced,
	NULL::bpchar                      AS ispayschedulevalid,
	NULL::bpchar                      AS isprinted,
	NULL::bpchar                      AS isselected,
	NULL::bpchar                      AS c_order_isselfservice,
	NULL::bpchar                      AS issotrx,
	NULL::bpchar                      AS istaxincluded,
	NULL::bpchar                      AS istransferred,
	NULL::numeric                     AS link_order_id,
	NULL::numeric                     AS c_order_m_freightcategory_id,
	NULL::numeric                     AS c_order_m_pricelist_id,
	NULL::numeric                     AS c_order_m_shipper_id,
	NULL::numeric                     AS c_order_m_warehouse_id,
	NULL::character varying           AS ordertype,
	NULL::numeric                     AS pay_bpartner_id,
	NULL::numeric                     AS pay_location_id,
	NULL::bpchar                      AS c_order_paymentrule,
	NULL::character varying           AS poreference,
	NULL::bpchar                      AS posted,
	NULL::bpchar                      AS priorityrule,
	NULL::bpchar                      AS c_order_processed,
	NULL::numeric                     AS processedon,
	NULL::character varying           AS promotioncode,
	NULL::numeric                     AS ref_order_id,
	NULL::numeric                     AS salesrep_id,
	NULL::bpchar                      AS c_order_sendemail,
	NULL::numeric                     AS totallines,
	NULL::timestamp WITHOUT TIME ZONE AS c_order_updated,
	NULL::numeric                     AS c_order_updatedby,
	NULL::numeric                     AS c_order_user1_id,
	NULL::numeric                     AS c_order_user2_id,
	NULL::numeric                     AS c_order_volume,
	NULL::numeric                     AS c_order_weight,
	NULL::numeric                     AS m_product_ad_org_id,
	NULL::character varying           AS classification,
	NULL::bpchar                      AS m_product_copyfrom,
	NULL::timestamp WITHOUT TIME ZONE AS m_product_created,
	NULL::numeric                     AS m_product_createdby,
	NULL::numeric                     AS c_revenuerecognition_id,
	NULL::numeric                     AS c_subscriptiontype_id,
	NULL::numeric                     AS c_taxcategory_id,
	NULL::numeric                     AS m_product_c_uom_id,
	NULL::character varying           AS descriptionurl,
	NULL::bpchar                      AS m_product_discontinued,
	NULL::timestamp WITHOUT TIME ZONE AS m_product_discontinuedat,
	NULL::character varying           AS group1,
	NULL::character varying           AS group2,
	NULL::numeric                     AS guaranteedays,
	NULL::numeric                     AS guaranteedaysmin,
	NULL::character varying           AS help,
	NULL::bpchar                      AS m_product_isactive,
	NULL::bpchar                      AS isbom,
	NULL::bpchar                      AS m_product_isdropship,
	NULL::bpchar                      AS isexcludeautodelivery,
	NULL::bpchar                      AS isinvoiceprintdetails,
	NULL::bpchar                      AS ispicklistprintdetails,
	NULL::bpchar                      AS ispurchased,
	NULL::bpchar                      AS m_product_isselfservice,
	NULL::bpchar                      AS issold,
	NULL::bpchar                      AS isstocked,
	NULL::bpchar                      AS m_product_issummary,
	NULL::bpchar                      AS isverified,
	NULL::bpchar                      AS iswebstorefeatured,
	NULL::numeric                     AS lowlevel,
	NULL::numeric                     AS m_attributeset_id,
	NULL::numeric                     AS m_attributesetinstance_id,
	NULL::numeric                     AS m_product_m_freightcategory_id,
	NULL::numeric                     AS m_locator_id,
	NULL::numeric                     AS m_product_product_category_id,
	NULL::bpchar                      AS m_product_processing,
	NULL::bpchar                      AS producttype,
	NULL::numeric                     AS r_mailtext_id,
	NULL::numeric                     AS m_product_salesrep_id,
	NULL::numeric                     AS s_expensetype_id,
	NULL::numeric                     AS shelfdepth,
	NULL::numeric                     AS shelfheight,
	NULL::numeric                     AS shelfwidth,
	NULL::numeric                     AS s_resource_id,
	NULL::numeric                     AS unitsperpack,
	NULL::numeric                     AS unitsperpallet,
	NULL::timestamp WITHOUT TIME ZONE AS m_product_updated,
	NULL::numeric                     AS m_product_updatedby,
	NULL::character varying           AS versionno,
	NULL::numeric                     AS m_product_volume,
	NULL::numeric                     AS m_product_weight,
	NULL::numeric                     AS m_product_po_ad_org_id,
	NULL::numeric                     AS m_product_po_c_bpartner_id,
	NULL::numeric                     AS m_product_po_c_currency_id,
	NULL::numeric                     AS costperorder,
	NULL::timestamp WITHOUT TIME ZONE AS m_product_po_created,
	NULL::numeric                     AS m_product_po_createdby,
	NULL::numeric                     AS m_product_po_c_uom_id,
	NULL::numeric                     AS deliverytime_actual,
	NULL::numeric                     AS deliverytime_promised,
	NULL::bpchar                      AS m_product_po_discontinued,
	NULL::timestamp WITHOUT TIME ZONE AS m_product_po_discontinuedat,
	NULL::bpchar                      AS m_product_po_isactive,
	NULL::bpchar                      AS iscurrentvendor,
	NULL::character varying           AS m_product_po_manufacturer,
	NULL::numeric                     AS m_product_po_m_product_id,
	NULL::numeric                     AS order_min,
	NULL::numeric                     AS order_pack,
	NULL::timestamp WITHOUT TIME ZONE AS priceeffective,
	NULL::numeric                     AS pricelastinv,
	NULL::numeric                     AS pricelastpo,
	NULL::numeric                     AS m_product_po_pricelist,
	NULL::numeric                     AS pricepo,
	NULL::numeric                     AS m_product_po_qualityrating,
	NULL::numeric                     AS royaltyamt,
	NULL::character varying           AS m_product_po_upc,
	NULL::timestamp WITHOUT TIME ZONE AS m_product_po_updated,
	NULL::numeric                     AS m_product_po_updatedby,
	NULL::character varying           AS m_product_po_vendorcategory,
	NULL::numeric                     AS s_resourceassignment_ad_org_id,
	NULL::timestamp WITHOUT TIME ZONE AS assigndatefrom,
	NULL::timestamp WITHOUT TIME ZONE AS assigndateto,
	NULL::timestamp WITHOUT TIME ZONE AS s_resourceassignment_created,
	NULL::numeric                     AS s_resourceassignment_createby,
	NULL::bpchar                      AS s_resourceassignment_isactive,
	NULL::bpchar                      AS isconfirmed,
	NULL::character varying           AS s_resourceassignment_name,
	NULL::numeric                     AS s_resourceassignment_qty,
	NULL::numeric                     AS s_resourceassignment_s_resour,
	NULL::timestamp WITHOUT TIME ZONE AS s_resourceassignment_updated,
	NULL::numeric                     AS s_resourceassignment_updatedby,
	NULL::numeric                     AS c_charge_c_org_id,
	NULL::numeric                     AS c_charge_c_bpartner_id,
	NULL::numeric                     AS c_chargetype_id,
	NULL::numeric                     AS c_charge_chargeamt,
	NULL::numeric                     AS c_charge_c_taxcategory_id,
	NULL::character varying           AS c_charge_description,
	NULL::bpchar                      AS c_charge_isactive,
	NULL::bpchar                      AS issamecurrency,
	NULL::bpchar                      AS issametax,
	NULL::bpchar                      AS c_charge_istaxincluded,
	NULL::numeric                     AS c_bpartner_product_ad_org_id,
	NULL::numeric                     AS c_bp_product_c_bpartner_id,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_product_created,
	NULL::numeric                     AS c_bpartner_product_createdby,
	NULL::character varying           AS c_bpartner_product_descriptio,
	NULL::bpchar                      AS c_bpartner_product_isactive,
	NULL::bpchar                      AS ismanufacturer,
	NULL::character varying           AS c_bpartner_product_manufactur,
	NULL::numeric                     AS c_bpartner_product_qualityrat,
	NULL::numeric                     AS shelflifemindays,
	NULL::numeric                     AS c_bpartner_product_shelflifem,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_product_updated,
	NULL::numeric                     AS c_bpartner_product_updatedby,
	NULL::character varying           AS c_bpartner_product_vendorcate,
	NULL::numeric                     AS acqusitioncost,
	NULL::numeric                     AS actuallifetimevalue,
	NULL::character varying           AS c_bpartner_ad_language,
	NULL::numeric                     AS ad_orgbp_id,
	NULL::numeric                     AS c_bpartner_ad_org_id,
	NULL::numeric                     AS bpartner_parent_id,
	NULL::numeric                     AS c_bp_group_id,
	NULL::numeric                     AS c_dunning_id,
	NULL::numeric                     AS c_greeting_id,
	NULL::numeric                     AS c_invoiceschedule_id,
	NULL::numeric                     AS c_bpartner_c_paymentterm_id,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_created,
	NULL::numeric                     AS c_bpartner_createdby,
	NULL::numeric                     AS c_bpartner_c_taxgroup_id,
	NULL::bpchar                      AS c_bpartner_deliveryrule,
	NULL::bpchar                      AS c_bpartner_deliveryviarule,
	NULL::character varying           AS c_bpartner_description,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_dunninggrace,
	NULL::character varying           AS duns,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_firstsale,
	NULL::numeric                     AS c_bpartner_flatdiscount,
	NULL::bpchar                      AS c_bpartner_freightcostrule,
	NULL::bpchar                      AS c_bpartner_invoicerule,
	NULL::bpchar                      AS c_bpartner_isactive,
	NULL::bpchar                      AS iscustomer,
	NULL::bpchar                      AS c_bpartner_isdiscountprinted,
	NULL::bpchar                      AS c_bpartner_isemployee,
	NULL::bpchar                      AS c_bpartner_ismanufacturer,
	NULL::bpchar                      AS isonetime,
	NULL::bpchar                      AS ispotaxexempt,
	NULL::bpchar                      AS isprospect,
	NULL::bpchar                      AS issalesrep,
	NULL::bpchar                      AS c_bpartner_issummary,
	NULL::bpchar                      AS c_bpartner_istaxexempt,
	NULL::bpchar                      AS isvendor,
	NULL::numeric                     AS logo_id,
	NULL::numeric                     AS m_discountschema_id,
	NULL::numeric                     AS c_bpartner_m_pricelist_id,
	NULL::character varying           AS naics,
	NULL::character varying           AS c_bpartner_name,
	NULL::character varying           AS c_bpartner_name2,
	NULL::numeric                     AS numberemployees,
	NULL::bpchar                      AS c_bpartner_paymentrule,
	NULL::bpchar                      AS paymentrulepo,
	NULL::numeric                     AS po_discountschema_id,
	NULL::numeric                     AS po_paymentterm_id,
	NULL::numeric                     AS po_pricelist_id,
	NULL::character varying           AS c_bpartner_poreference,
	NULL::numeric                     AS potentiallifetimevalue,
	NULL::bpchar                      AS c_bpartner_rating,
	NULL::character varying           AS c_bpartner_referenceno,
	NULL::numeric                     AS c_bpartner_salesrep_id,
	NULL::numeric                     AS salesvolume,
	NULL::bpchar                      AS c_bpartner_sendemail,
	NULL::numeric                     AS shareofcustomer,
	NULL::numeric                     AS c_bpartner_shelflifeminpct,
	NULL::numeric                     AS so_creditlimit,
	NULL::bpchar                      AS socreditstatus,
	NULL::numeric                     AS so_creditused,
	NULL::character varying           AS so_description,
	NULL::character varying           AS c_bpartner_taxid,
	NULL::numeric                     AS totalopenbalance,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_updated,
	NULL::numeric                     AS c_bpartner_updatedby,
	NULL::character varying           AS c_bpartner_url,
	NULL::character varying           AS c_bpartner_value,
	NULL::numeric                     AS c_bpartner_location_ad_org_id,
	NULL::numeric                     AS c_bpartner_location_c_bpartne,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_location_created,
	NULL::numeric                     AS c_bpartner_location_createdby,
	NULL::numeric                     AS c_salesregion_id,
	NULL::character varying           AS c_bpartner_location_fax,
	NULL::bpchar                      AS c_bpartner_location_isactive,
	NULL::bpchar                      AS isbillto,
	NULL::character varying           AS isdn,
	NULL::bpchar                      AS ispayfrom,
	NULL::bpchar                      AS isremitto,
	NULL::bpchar                      AS isshipto,
	NULL::character varying           AS c_bpartner_location_name,
	NULL::character varying           AS c_bpartner_location_phone,
	NULL::character varying           AS c_bpartner_location_phone2,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_location_updated,
	NULL::numeric                     AS c_bpartner_location_updatedby,
	NULL::numeric                     AS c_tax_ad_org_id,
	NULL::numeric                     AS ad_rule_id,
	NULL::numeric                     AS c_country_id,
	NULL::numeric                     AS c_region_id,
	NULL::numeric                     AS c_tax_c_taxcategory_id,
	NULL::character varying           AS c_tax_description,
	NULL::bpchar                      AS c_tax_isactive,
	NULL::bpchar                      AS c_tax_isdefault,
	NULL::bpchar                      AS isdocumentlevel,
	NULL::bpchar                      AS issalestax,
	NULL::bpchar                      AS c_tax_issummary,
	NULL::bpchar                      AS c_tax_istaxexempt,
	NULL::character varying           AS c_tax_name,
	NULL::numeric                     AS parent_tax_id,
	NULL::numeric                     AS rate,
	NULL::bpchar                      AS requirestaxcertificate,
	NULL::bpchar                      AS sopotype,
	NULL::numeric                     AS to_country_id,
	NULL::numeric                     AS c_tax_to_region_id,
	NULL::timestamp WITHOUT TIME ZONE AS validfrom
FROM
	c_order i,
	ad_language l
WHERE
	l.isbaselanguage = 'N'::bpchar
	AND l.issystemlanguage = 'Y'::bpchar
UNION
SELECT
	ot.ad_client_id,
	ot.ad_org_id,
	ot.isactive,
	ot.created,
	ot.createdby,
	ot.updated,
	ot.updatedby,
	tt.ad_language,
	ot.c_order_id,
	NULL::numeric                     AS c_orderline_id,
	ot.c_tax_id,
	tt.taxindicator,
	NULL::numeric                     AS c_bpartner_id,
	NULL::numeric                     AS c_bpartner_location_id,
	NULL::character varying           AS bpname,
	NULL::numeric                     AS c_location_id,
	999999                            AS line,
	NULL::numeric                     AS m_product_id,
	NULL::character varying           AS vendorproductno,
	NULL::numeric                     AS qtyordered,
	NULL::numeric                     AS qtyentered,
	NULL::character varying           AS uomsymbol,
	tt.name,
	NULL::character varying           AS description,
	NULL::character varying           AS documentnote,
	NULL::character varying           AS upc,
	NULL::character varying           AS sku,
	NULL::character varying           AS productvalue,
	NULL::character varying           AS resourcedescription,
	NULL::numeric                     AS pricelist,
	NULL::numeric                     AS priceenteredlist,
	NULL::numeric                     AS discount,
	CASE
		WHEN ot.istaxincluded = 'Y'::bpchar THEN ot.taxamt
		ELSE ot.taxbaseamt
		END                             AS priceactual,
	CASE
		WHEN ot.istaxincluded = 'Y'::bpchar THEN ot.taxamt
		ELSE ot.taxbaseamt
		END                             AS priceentered,
	CASE
		WHEN ot.istaxincluded = 'Y'::bpchar THEN NULL::numeric
		ELSE ot.taxamt
		END                             AS linenetamt,
	NULL::character varying           AS productdescription,
	NULL::character varying           AS imageurl,
	NULL::numeric                     AS c_campaign_id,
	NULL::numeric                     AS c_project_id,
	NULL::numeric                     AS c_activity_id,
	NULL::numeric                     AS c_projectphase_id,
	NULL::numeric                     AS c_projecttask_id,
	NULL::numeric                     AS c_orderline_ad_orgtrx_id,
	NULL::numeric                     AS c_orderline_c_charge_id,
	NULL::numeric                     AS c_orderline_c_currency_id,
	NULL::numeric                     AS c_uom_id,
	NULL::timestamp WITHOUT TIME ZONE AS datedelivered,
	NULL::timestamp WITHOUT TIME ZONE AS dateinvoiced,
	NULL::timestamp WITHOUT TIME ZONE AS dateordered,
	NULL::timestamp WITHOUT TIME ZONE AS c_orderline_datepromised,
	NULL::numeric                     AS c_orderline_freightamt,
	NULL::bpchar                      AS isdescription,
	NULL::numeric                     AS link_orderline_id,
	NULL::numeric                     AS m_promotion_id,
	NULL::numeric                     AS c_orderline_m_shipper_id,
	NULL::numeric                     AS c_orderline_m_warehouse_id,
	NULL::numeric                     AS pricecost,
	NULL::numeric                     AS pricelimit,
	NULL::bpchar                      AS c_orderline_processed,
	NULL::numeric                     AS qtydelivered,
	NULL::numeric                     AS qtyinvoiced,
	NULL::numeric                     AS qtylostsales,
	NULL::numeric                     AS qtyreserved,
	NULL::numeric                     AS ref_orderline_id,
	NULL::numeric                     AS rramt,
	NULL::timestamp WITHOUT TIME ZONE AS rrstartdate,
	NULL::numeric                     AS s_resourceassignment_id,
	NULL::numeric                     AS c_orderline_user1_id,
	NULL::numeric                     AS c_orderline_user2_id,
	NULL::numeric                     AS c_uom_ad_org_id,
	NULL::numeric                     AS costingprecision,
	NULL::character varying           AS c_uom_description,
	NULL::bpchar                      AS c_uom_isactive,
	NULL::bpchar                      AS isdefault,
	NULL::character varying           AS c_uom_name,
	NULL::numeric                     AS stdprecision,
	NULL::character varying           AS uomtype,
	NULL::character varying           AS x12de355,
	NULL::numeric                     AS c_order_ad_org_id,
	NULL::numeric                     AS c_order_ad_orgtrx_id,
	NULL::numeric                     AS ad_user_id,
	NULL::numeric                     AS amountrefunded,
	NULL::numeric                     AS amounttendered,
	NULL::numeric                     AS bill_bpartner_id,
	NULL::numeric                     AS bill_location_id,
	NULL::numeric                     AS bill_user_id,
	NULL::numeric                     AS c_order_c_activity_id,
	NULL::numeric                     AS c_order_c_bpartner_id,
	NULL::numeric                     AS c_order_c_campaign_id,
	NULL::numeric                     AS c_cashline_id,
	NULL::numeric                     AS c_cashplanline_id,
	NULL::numeric                     AS c_order_c_charge_id,
	NULL::numeric                     AS c_conversiontype_id,
	NULL::numeric                     AS c_order_c_currency_id,
	NULL::numeric                     AS c_doctype_id,
	NULL::numeric                     AS c_doctypetarget_id,
	NULL::numeric                     AS chargeamt,
	NULL::bpchar                      AS copyfrom,
	NULL::numeric                     AS c_payment_id,
	NULL::numeric                     AS c_paymentterm_id,
	NULL::numeric                     AS c_pos_id,
	NULL::numeric                     AS c_order_c_project_id,
	NULL::timestamp WITHOUT TIME ZONE AS c_order_created,
	NULL::numeric                     AS c_order_createdby,
	NULL::timestamp WITHOUT TIME ZONE AS dateacct,
	NULL::timestamp WITHOUT TIME ZONE AS dateprinted,
	NULL::timestamp WITHOUT TIME ZONE AS c_order_datepromised,
	NULL::bpchar                      AS deliveryrule,
	NULL::bpchar                      AS deliveryviarule,
	NULL::character varying           AS c_order_description,
	NULL::bpchar                      AS docaction,
	NULL::bpchar                      AS docstatus,
	NULL::character varying           AS documentno,
	NULL::numeric                     AS dropship_bpartner_id,
	NULL::numeric                     AS dropship_location_id,
	NULL::numeric                     AS dropship_user_id,
	NULL::numeric                     AS c_order_freightamt,
	NULL::bpchar                      AS freightcostrule,
	NULL::numeric                     AS grandtotal,
	NULL::bpchar                      AS invoicerule,
	NULL::bpchar                      AS c_order_isactive,
	NULL::bpchar                      AS isapproved,
	NULL::bpchar                      AS iscreditapproved,
	NULL::bpchar                      AS isdelivered,
	NULL::bpchar                      AS c_order_isdiscountprinted,
	NULL::bpchar                      AS c_order_isdropship,
	NULL::bpchar                      AS isinvoiced,
	NULL::bpchar                      AS ispayschedulevalid,
	NULL::bpchar                      AS isprinted,
	NULL::bpchar                      AS isselected,
	NULL::bpchar                      AS c_order_isselfservice,
	NULL::bpchar                      AS issotrx,
	NULL::bpchar                      AS istaxincluded,
	NULL::bpchar                      AS istransferred,
	NULL::numeric                     AS link_order_id,
	NULL::numeric                     AS c_order_m_freightcategory_id,
	NULL::numeric                     AS c_order_m_pricelist_id,
	NULL::numeric                     AS c_order_m_shipper_id,
	NULL::numeric                     AS c_order_m_warehouse_id,
	NULL::character varying           AS ordertype,
	NULL::numeric                     AS pay_bpartner_id,
	NULL::numeric                     AS pay_location_id,
	NULL::bpchar                      AS c_order_paymentrule,
	NULL::character varying           AS poreference,
	NULL::bpchar                      AS posted,
	NULL::bpchar                      AS priorityrule,
	NULL::bpchar                      AS c_order_processed,
	NULL::numeric                     AS processedon,
	NULL::character varying           AS promotioncode,
	NULL::numeric                     AS ref_order_id,
	NULL::numeric                     AS salesrep_id,
	NULL::bpchar                      AS c_order_sendemail,
	NULL::numeric                     AS totallines,
	NULL::timestamp WITHOUT TIME ZONE AS c_order_updated,
	NULL::numeric                     AS c_order_updatedby,
	NULL::numeric                     AS c_order_user1_id,
	NULL::numeric                     AS c_order_user2_id,
	NULL::numeric                     AS c_order_volume,
	NULL::numeric                     AS c_order_weight,
	NULL::numeric                     AS m_product_ad_org_id,
	NULL::character varying           AS classification,
	NULL::bpchar                      AS m_product_copyfrom,
	NULL::timestamp WITHOUT TIME ZONE AS m_product_created,
	NULL::numeric                     AS m_product_createdby,
	NULL::numeric                     AS c_revenuerecognition_id,
	NULL::numeric                     AS c_subscriptiontype_id,
	NULL::numeric                     AS c_taxcategory_id,
	NULL::numeric                     AS m_product_c_uom_id,
	NULL::character varying           AS descriptionurl,
	NULL::bpchar                      AS m_product_discontinued,
	NULL::timestamp WITHOUT TIME ZONE AS m_product_discontinuedat,
	NULL::character varying           AS group1,
	NULL::character varying           AS group2,
	NULL::numeric                     AS guaranteedays,
	NULL::numeric                     AS guaranteedaysmin,
	NULL::character varying           AS help,
	NULL::bpchar                      AS m_product_isactive,
	NULL::bpchar                      AS isbom,
	NULL::bpchar                      AS m_product_isdropship,
	NULL::bpchar                      AS isexcludeautodelivery,
	NULL::bpchar                      AS isinvoiceprintdetails,
	NULL::bpchar                      AS ispicklistprintdetails,
	NULL::bpchar                      AS ispurchased,
	NULL::bpchar                      AS m_product_isselfservice,
	NULL::bpchar                      AS issold,
	NULL::bpchar                      AS isstocked,
	NULL::bpchar                      AS m_product_issummary,
	NULL::bpchar                      AS isverified,
	NULL::bpchar                      AS iswebstorefeatured,
	NULL::numeric                     AS lowlevel,
	NULL::numeric                     AS m_attributeset_id,
	NULL::numeric                     AS m_attributesetinstance_id,
	NULL::numeric                     AS m_product_m_freightcategory_id,
	NULL::numeric                     AS m_locator_id,
	NULL::numeric                     AS m_product_product_category_id,
	NULL::bpchar                      AS m_product_processing,
	NULL::bpchar                      AS producttype,
	NULL::numeric                     AS r_mailtext_id,
	NULL::numeric                     AS m_product_salesrep_id,
	NULL::numeric                     AS s_expensetype_id,
	NULL::numeric                     AS shelfdepth,
	NULL::numeric                     AS shelfheight,
	NULL::numeric                     AS shelfwidth,
	NULL::numeric                     AS s_resource_id,
	NULL::numeric                     AS unitsperpack,
	NULL::numeric                     AS unitsperpallet,
	NULL::timestamp WITHOUT TIME ZONE AS m_product_updated,
	NULL::numeric                     AS m_product_updatedby,
	NULL::character varying           AS versionno,
	NULL::numeric                     AS m_product_volume,
	NULL::numeric                     AS m_product_weight,
	NULL::numeric                     AS m_product_po_ad_org_id,
	NULL::numeric                     AS m_product_po_c_bpartner_id,
	NULL::numeric                     AS m_product_po_c_currency_id,
	NULL::numeric                     AS costperorder,
	NULL::timestamp WITHOUT TIME ZONE AS m_product_po_created,
	NULL::numeric                     AS m_product_po_createdby,
	NULL::numeric                     AS m_product_po_c_uom_id,
	NULL::numeric                     AS deliverytime_actual,
	NULL::numeric                     AS deliverytime_promised,
	NULL::bpchar                      AS m_product_po_discontinued,
	NULL::timestamp WITHOUT TIME ZONE AS m_product_po_discontinuedat,
	NULL::bpchar                      AS m_product_po_isactive,
	NULL::bpchar                      AS iscurrentvendor,
	NULL::character varying           AS m_product_po_manufacturer,
	NULL::numeric                     AS m_product_po_m_product_id,
	NULL::numeric                     AS order_min,
	NULL::numeric                     AS order_pack,
	NULL::timestamp WITHOUT TIME ZONE AS priceeffective,
	NULL::numeric                     AS pricelastinv,
	NULL::numeric                     AS pricelastpo,
	NULL::numeric                     AS m_product_po_pricelist,
	NULL::numeric                     AS pricepo,
	NULL::numeric                     AS m_product_po_qualityrating,
	NULL::numeric                     AS royaltyamt,
	NULL::character varying           AS m_product_po_upc,
	NULL::timestamp WITHOUT TIME ZONE AS m_product_po_updated,
	NULL::numeric                     AS m_product_po_updatedby,
	NULL::character varying           AS m_product_po_vendorcategory,
	NULL::numeric                     AS s_resourceassignment_ad_org_id,
	NULL::timestamp WITHOUT TIME ZONE AS assigndatefrom,
	NULL::timestamp WITHOUT TIME ZONE AS assigndateto,
	NULL::timestamp WITHOUT TIME ZONE AS s_resourceassignment_created,
	NULL::numeric                     AS s_resourceassignment_createby,
	NULL::bpchar                      AS s_resourceassignment_isactive,
	NULL::bpchar                      AS isconfirmed,
	NULL::character varying           AS s_resourceassignment_name,
	NULL::numeric                     AS s_resourceassignment_qty,
	NULL::numeric                     AS s_resourceassignment_s_resour,
	NULL::timestamp WITHOUT TIME ZONE AS s_resourceassignment_updated,
	NULL::numeric                     AS s_resourceassignment_updatedby,
	NULL::numeric                     AS c_charge_c_org_id,
	NULL::numeric                     AS c_charge_c_bpartner_id,
	NULL::numeric                     AS c_chargetype_id,
	NULL::numeric                     AS c_charge_chargeamt,
	NULL::numeric                     AS c_charge_c_taxcategory_id,
	NULL::character varying           AS c_charge_description,
	NULL::bpchar                      AS c_charge_isactive,
	NULL::bpchar                      AS issamecurrency,
	NULL::bpchar                      AS issametax,
	NULL::bpchar                      AS c_charge_istaxincluded,
	NULL::numeric                     AS c_bpartner_product_ad_org_id,
	NULL::numeric                     AS c_bp_product_c_bpartner_id,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_product_created,
	NULL::numeric                     AS c_bpartner_product_createdby,
	NULL::character varying           AS c_bpartner_product_descriptio,
	NULL::bpchar                      AS c_bpartner_product_isactive,
	NULL::bpchar                      AS ismanufacturer,
	NULL::character varying           AS c_bpartner_product_manufactur,
	NULL::numeric                     AS c_bpartner_product_qualityrat,
	NULL::numeric                     AS shelflifemindays,
	NULL::numeric                     AS c_bpartner_product_shelflifem,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_product_updated,
	NULL::numeric                     AS c_bpartner_product_updatedby,
	NULL::character varying           AS c_bpartner_product_vendorcate,
	NULL::numeric                     AS acqusitioncost,
	NULL::numeric                     AS actuallifetimevalue,
	NULL::character varying           AS c_bpartner_ad_language,
	NULL::numeric                     AS ad_orgbp_id,
	NULL::numeric                     AS c_bpartner_ad_org_id,
	NULL::numeric                     AS bpartner_parent_id,
	NULL::numeric                     AS c_bp_group_id,
	NULL::numeric                     AS c_dunning_id,
	NULL::numeric                     AS c_greeting_id,
	NULL::numeric                     AS c_invoiceschedule_id,
	NULL::numeric                     AS c_bpartner_c_paymentterm_id,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_created,
	NULL::numeric                     AS c_bpartner_createdby,
	NULL::numeric                     AS c_bpartner_c_taxgroup_id,
	NULL::bpchar                      AS c_bpartner_deliveryrule,
	NULL::bpchar                      AS c_bpartner_deliveryviarule,
	NULL::character varying           AS c_bpartner_description,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_dunninggrace,
	NULL::character varying           AS duns,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_firstsale,
	NULL::numeric                     AS c_bpartner_flatdiscount,
	NULL::bpchar                      AS c_bpartner_freightcostrule,
	NULL::bpchar                      AS c_bpartner_invoicerule,
	NULL::bpchar                      AS c_bpartner_isactive,
	NULL::bpchar                      AS iscustomer,
	NULL::bpchar                      AS c_bpartner_isdiscountprinted,
	NULL::bpchar                      AS c_bpartner_isemployee,
	NULL::bpchar                      AS c_bpartner_ismanufacturer,
	NULL::bpchar                      AS isonetime,
	NULL::bpchar                      AS ispotaxexempt,
	NULL::bpchar                      AS isprospect,
	NULL::bpchar                      AS issalesrep,
	NULL::bpchar                      AS c_bpartner_issummary,
	NULL::bpchar                      AS c_bpartner_istaxexempt,
	NULL::bpchar                      AS isvendor,
	NULL::numeric                     AS logo_id,
	NULL::numeric                     AS m_discountschema_id,
	NULL::numeric                     AS c_bpartner_m_pricelist_id,
	NULL::character varying           AS naics,
	NULL::character varying           AS c_bpartner_name,
	NULL::character varying           AS c_bpartner_name2,
	NULL::numeric                     AS numberemployees,
	NULL::bpchar                      AS c_bpartner_paymentrule,
	NULL::bpchar                      AS paymentrulepo,
	NULL::numeric                     AS po_discountschema_id,
	NULL::numeric                     AS po_paymentterm_id,
	NULL::numeric                     AS po_pricelist_id,
	NULL::character varying           AS c_bpartner_poreference,
	NULL::numeric                     AS potentiallifetimevalue,
	NULL::bpchar                      AS c_bpartner_rating,
	NULL::character varying           AS c_bpartner_referenceno,
	NULL::numeric                     AS c_bpartner_salesrep_id,
	NULL::numeric                     AS salesvolume,
	NULL::bpchar                      AS c_bpartner_sendemail,
	NULL::numeric                     AS shareofcustomer,
	NULL::numeric                     AS c_bpartner_shelflifeminpct,
	NULL::numeric                     AS so_creditlimit,
	NULL::bpchar                      AS socreditstatus,
	NULL::numeric                     AS so_creditused,
	NULL::character varying           AS so_description,
	NULL::character varying           AS c_bpartner_taxid,
	NULL::numeric                     AS totalopenbalance,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_updated,
	NULL::numeric                     AS c_bpartner_updatedby,
	NULL::character varying           AS c_bpartner_url,
	NULL::character varying           AS c_bpartner_value,
	NULL::numeric                     AS c_bpartner_location_ad_org_id,
	NULL::numeric                     AS c_bpartner_location_c_bpartne,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_location_created,
	NULL::numeric                     AS c_bpartner_location_createdby,
	NULL::numeric                     AS c_salesregion_id,
	NULL::character varying           AS c_bpartner_location_fax,
	NULL::bpchar                      AS c_bpartner_location_isactive,
	NULL::bpchar                      AS isbillto,
	NULL::character varying           AS isdn,
	NULL::bpchar                      AS ispayfrom,
	NULL::bpchar                      AS isremitto,
	NULL::bpchar                      AS isshipto,
	NULL::character varying           AS c_bpartner_location_name,
	NULL::character varying           AS c_bpartner_location_phone,
	NULL::character varying           AS c_bpartner_location_phone2,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_location_updated,
	NULL::numeric                     AS c_bpartner_location_updatedby,
	NULL::numeric                     AS c_tax_ad_org_id,
	NULL::numeric                     AS ad_rule_id,
	NULL::numeric                     AS c_country_id,
	NULL::numeric                     AS c_region_id,
	NULL::numeric                     AS c_tax_c_taxcategory_id,
	NULL::character varying           AS c_tax_description,
	NULL::bpchar                      AS c_tax_isactive,
	NULL::bpchar                      AS c_tax_isdefault,
	NULL::bpchar                      AS isdocumentlevel,
	NULL::bpchar                      AS issalestax,
	NULL::bpchar                      AS c_tax_issummary,
	NULL::bpchar                      AS c_tax_istaxexempt,
	NULL::character varying           AS c_tax_name,
	NULL::numeric                     AS parent_tax_id,
	NULL::numeric                     AS rate,
	NULL::bpchar                      AS requirestaxcertificate,
	NULL::bpchar                      AS sopotype,
	NULL::numeric                     AS to_country_id,
	NULL::numeric                     AS c_tax_to_region_id,
	NULL::timestamp WITHOUT TIME ZONE AS validfrom
FROM
	c_ordertax ot
		JOIN c_tax_trl tt
		ON ot.c_tax_id = tt.c_tax_id;

CREATE OR REPLACE VIEW c_order_linetax_v
		(ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ad_language, c_order_id, c_orderline_id,
		 c_tax_id, taxindicator, c_bpartner_id, c_bpartner_location_id, bpname, c_location_id, line, m_product_id,
		 vendorproductno, qtyordered, qtyentered, uomsymbol, name, description, documentnote, upc, sku, productvalue,
		 resourcedescription, pricelist, priceenteredlist, discount, priceactual, priceentered, linenetamt,
		 productdescription, imageurl, c_campaign_id, c_project_id, c_activity_id, c_projectphase_id, c_projecttask_id,
		 c_orderline_ad_orgtrx_id, c_orderline_c_charge_id, c_orderline_c_currency_id, c_uom_id, datedelivered,
		 dateinvoiced, dateordered, c_orderline_datepromised, c_orderline_freightamt, isdescription, link_orderline_id,
		 m_promotion_id, c_orderline_m_shipper_id, c_orderline_m_warehouse_id, pricecost, pricelimit, c_orderline_processed,
		 qtydelivered, qtyinvoiced, qtylostsales, qtyreserved, ref_orderline_id, rramt, rrstartdate,
		 s_resourceassignment_id, c_orderline_user1_id, c_orderline_user2_id, c_uom_ad_org_id, costingprecision,
		 c_uom_description, c_uom_isactive, isdefault, c_uom_name, stdprecision, uomtype, x12de355, c_order_ad_org_id,
		 c_order_ad_orgtrx_id, ad_user_id, amountrefunded, amounttendered, bill_bpartner_id, bill_location_id, bill_user_id,
		 c_order_c_activity_id, c_order_c_bpartner_id, c_order_c_campaign_id, c_cashline_id, c_cashplanline_id,
		 c_order_c_charge_id, c_conversiontype_id, c_order_c_currency_id, c_doctype_id, c_doctypetarget_id, chargeamt,
		 copyfrom, c_payment_id, c_paymentterm_id, c_pos_id, c_order_c_project_id, c_order_created, c_order_createdby,
		 dateacct, dateprinted, c_order_datepromised, deliveryrule, deliveryviarule, c_order_description, docaction,
		 docstatus, documentno, dropship_bpartner_id, dropship_location_id, dropship_user_id, c_order_freightamt,
		 freightcostrule, grandtotal, invoicerule, c_order_isactive, isapproved, iscreditapproved, isdelivered,
		 c_order_isdiscountprinted, c_order_isdropship, isinvoiced, ispayschedulevalid, isprinted, isselected,
		 c_order_isselfservice, issotrx, istaxincluded, istransferred, link_order_id, c_order_m_freightcategory_id,
		 c_order_m_pricelist_id, c_order_m_shipper_id, c_order_m_warehouse_id, ordertype, pay_bpartner_id, pay_location_id,
		 c_order_paymentrule, poreference, posted, priorityrule, c_order_processed, processedon, promotioncode,
		 ref_order_id, salesrep_id, c_order_sendemail, totallines, c_order_updated, c_order_updatedby, c_order_user1_id,
		 c_order_user2_id, c_order_volume, c_order_weight, m_product_ad_org_id, classification, m_product_copyfrom,
		 m_product_created, m_product_createdby, c_revenuerecognition_id, c_subscriptiontype_id, c_taxcategory_id,
		 m_product_c_uom_id, descriptionurl, m_product_discontinued, m_product_discontinuedat, group1, group2,
		 guaranteedays, guaranteedaysmin, help, m_product_isactive, isbom, m_product_isdropship, isexcludeautodelivery,
		 isinvoiceprintdetails, ispicklistprintdetails, ispurchased, m_product_isselfservice, issold, isstocked,
		 m_product_issummary, isverified, iswebstorefeatured, lowlevel, m_attributeset_id, m_attributesetinstance_id,
		 m_product_m_freightcategory_id, m_locator_id, m_product_product_category_id, m_product_processing, producttype,
		 r_mailtext_id, m_product_salesrep_id, s_expensetype_id, shelfdepth, shelfheight, shelfwidth, s_resource_id,
		 unitsperpack, unitsperpallet, m_product_updated, m_product_updatedby, versionno, m_product_volume,
		 m_product_weight, m_product_po_ad_org_id, m_product_po_c_bpartner_id, m_product_po_c_currency_id, costperorder,
		 m_product_po_created, m_product_po_createdby, m_product_po_c_uom_id, deliverytime_actual, deliverytime_promised,
		 m_product_po_discontinued, m_product_po_discontinuedat, m_product_po_isactive, iscurrentvendor,
		 m_product_po_manufacturer, m_product_po_m_product_id, order_min, order_pack, priceeffective, pricelastinv,
		 pricelastpo, m_product_po_pricelist, pricepo, m_product_po_qualityrating, royaltyamt, m_product_po_upc,
		 m_product_po_updated, m_product_po_updatedby, m_product_po_vendorcategory, s_resourceassignment_ad_org_id,
		 assigndatefrom, assigndateto, s_resourceassignment_created, s_resourceassignment_createby,
		 s_resourceassignment_isactive, isconfirmed, s_resourceassignment_name, s_resourceassignment_qty,
		 s_resourceassignment_s_resour, s_resourceassignment_updated, s_resourceassignment_updatedby, c_charge_c_org_id,
		 c_charge_c_bpartner_id, c_chargetype_id, c_charge_chargeamt, c_charge_c_taxcategory_id, c_charge_description,
		 c_charge_isactive, issamecurrency, issametax, c_charge_istaxincluded, c_bpartner_product_ad_org_id,
		 c_bp_product_c_bpartner_id, c_bpartner_product_created, c_bpartner_product_createdby,
		 c_bpartner_product_description, c_bpartner_product_isactive, ismanufacturer, c_bpartner_product_manufactur,
		 c_bpartner_product_qualityrat, shelflifemindays, c_bpartner_product_shelflifem, c_bpartner_product_updated,
		 c_bpartner_product_updatedby, c_bpartner_product_vendorcate, acqusitioncost, actuallifetimevalue,
		 c_bpartner_ad_language, ad_orgbp_id, c_bpartner_ad_org_id, bpartner_parent_id, c_bp_group_id, c_dunning_id,
		 c_greeting_id, c_invoiceschedule_id, c_bpartner_c_paymentterm_id, c_bpartner_created, c_bpartner_createdby,
		 c_bpartner_c_taxgroup_id, c_bpartner_deliveryrule, c_bpartner_deliveryviarule, c_bpartner_description,
		 c_bpartner_dunninggrace, duns, c_bpartner_firstsale, c_bpartner_flatdiscount, c_bpartner_freightcostrule,
		 c_bpartner_invoicerule, c_bpartner_isactive, iscustomer, c_bpartner_isdiscountprinted, c_bpartner_isemployee,
		 c_bpartner_ismanufacturer, isonetime, ispotaxexempt, isprospect, issalesrep, c_bpartner_issummary,
		 c_bpartner_istaxexempt, isvendor, logo_id, m_discountschema_id, c_bpartner_m_pricelist_id, naics, c_bpartner_name,
		 c_bpartner_name2, numberemployees, c_bpartner_paymentrule, paymentrulepo, po_discountschema_id, po_paymentterm_id,
		 po_pricelist_id, c_bpartner_poreference, potentiallifetimevalue, c_bpartner_rating, c_bpartner_referenceno,
		 c_bpartner_salesrep_id, salesvolume, c_bpartner_sendemail, shareofcustomer, c_bpartner_shelflifeminpct,
		 so_creditlimit, socreditstatus, so_creditused, so_description, c_bpartner_taxid, totalopenbalance,
		 c_bpartner_updated, c_bpartner_updatedby, c_bpartner_url, c_bpartner_value, c_bpartner_location_ad_org_id,
		 c_bpartner_location_c_bpartne, c_bpartner_location_created, c_bpartner_location_createdby, c_salesregion_id,
		 c_bpartner_location_fax, c_bpartner_location_isactive, isbillto, isdn, ispayfrom, isremitto, isshipto,
		 c_bpartner_location_name, c_bpartner_location_phone, c_bpartner_location_phone2, c_bpartner_location_updated,
		 c_bpartner_location_updatedby, c_tax_ad_org_id, ad_rule_id, c_country_id, c_region_id, c_tax_c_taxcategory_id,
		 c_tax_description, c_tax_isactive, c_tax_isdefault, isdocumentlevel, issalestax, c_tax_issummary,
		 c_tax_istaxexempt, c_tax_name, parent_tax_id, rate, requirestaxcertificate, sopotype, to_country_id,
		 c_tax_to_region_id, validfrom)
AS
SELECT
	ol.ad_client_id,
	ol.ad_org_id,
	ol.isactive,
	ol.created,
	ol.createdby,
	ol.updated,
	ol.updatedby,
	'en_US'::character varying(6)         AS ad_language,
	ol.c_order_id,
	ol.c_orderline_id,
	ol.c_tax_id,
	t.taxindicator,
	ol.c_bpartner_id,
	ol.c_bpartner_location_id,
	bp.name                               AS bpname,
	bpl.c_location_id,
	ol.line,
	p.m_product_id,
	po.vendorproductno,
	CASE
		WHEN ol.qtyordered <> 0::numeric OR ol.m_product_id IS NOT NULL THEN ol.qtyordered
		ELSE NULL::numeric
		END                                 AS qtyordered,
	CASE
		WHEN ol.qtyentered <> 0::numeric OR ol.m_product_id IS NOT NULL THEN ol.qtyentered
		ELSE NULL::numeric
		END                                 AS qtyentered,
	CASE
		WHEN ol.qtyentered <> 0::numeric OR ol.m_product_id IS NOT NULL THEN uom.uomsymbol
		ELSE NULL::character varying
		END                                 AS uomsymbol,
	COALESCE(c.name, (p.name::text || productattribute(ol.m_attributesetinstance_id)::text)::character varying,
	         ol.description)              AS name,
	CASE
		WHEN COALESCE(c.name, p.name) IS NOT NULL THEN ol.description
		ELSE NULL::character varying
		END                                 AS description,
	p.documentnote,
	p.upc,
	p.sku,
	COALESCE(pp.vendorproductno, p.value) AS productvalue,
	ra.description                        AS resourcedescription,
	CASE
		WHEN i.isdiscountprinted = 'Y'::bpchar AND ol.pricelist <> 0::numeric THEN ol.pricelist
		ELSE NULL::numeric
		END                                 AS pricelist,
	CASE
		WHEN i.isdiscountprinted = 'Y'::bpchar AND ol.pricelist <> 0::numeric AND ol.qtyentered <> 0::numeric
			THEN ol.pricelist * ol.qtyordered / ol.qtyentered
		ELSE NULL::numeric
		END                                 AS priceenteredlist,
	CASE
		WHEN i.isdiscountprinted = 'Y'::bpchar AND ol.pricelist > ol.priceactual AND ol.pricelist <> 0::numeric
			THEN (ol.pricelist - ol.priceactual) / ol.pricelist * 100::numeric
		ELSE NULL::numeric
		END                                 AS discount,
	CASE
		WHEN ol.priceactual <> 0::numeric OR ol.m_product_id IS NOT NULL THEN ol.priceactual
		ELSE NULL::numeric
		END                                 AS priceactual,
	CASE
		WHEN ol.priceentered <> 0::numeric OR ol.m_product_id IS NOT NULL THEN ol.priceentered
		ELSE NULL::numeric
		END                                 AS priceentered,
	CASE
		WHEN ol.linenetamt <> 0::numeric OR ol.m_product_id IS NOT NULL THEN ol.linenetamt
		ELSE NULL::numeric
		END                                 AS linenetamt,
	p.description                         AS productdescription,
	p.imageurl,
	ol.c_campaign_id,
	ol.c_project_id,
	ol.c_activity_id,
	ol.c_projectphase_id,
	ol.c_projecttask_id,
	ol.ad_orgtrx_id                       AS c_orderline_ad_orgtrx_id,
	ol.c_charge_id                        AS c_orderline_c_charge_id,
	ol.c_currency_id                      AS c_orderline_c_currency_id,
	ol.c_uom_id,
	ol.datedelivered,
	ol.dateinvoiced,
	ol.dateordered,
	ol.datepromised                       AS c_orderline_datepromised,
	ol.freightamt                         AS c_orderline_freightamt,
	ol.isdescription,
	ol.link_orderline_id,
	ol.m_promotion_id,
	ol.m_shipper_id                       AS c_orderline_m_shipper_id,
	ol.m_warehouse_id                     AS c_orderline_m_warehouse_id,
	ol.pricecost,
	ol.pricelimit,
	ol.processed                          AS c_orderline_processed,
	ol.qtydelivered,
	ol.qtyinvoiced,
	ol.qtylostsales,
	ol.qtyreserved,
	ol.ref_orderline_id,
	ol.rramt,
	ol.rrstartdate,
	ol.s_resourceassignment_id,
	ol.user1_id                           AS c_orderline_user1_id,
	ol.user2_id                           AS c_orderline_user2_id,
	uom.ad_org_id                         AS c_uom_ad_org_id,
	uom.costingprecision,
	uom.description                       AS c_uom_description,
	uom.isactive                          AS c_uom_isactive,
	uom.isdefault,
	uom.name                              AS c_uom_name,
	uom.stdprecision,
	uom.uomtype,
	uom.x12de355,
	i.ad_org_id                           AS c_order_ad_org_id,
	i.ad_orgtrx_id                        AS c_order_ad_orgtrx_id,
	i.ad_user_id,
	i.amountrefunded,
	i.amounttendered,
	i.bill_bpartner_id,
	i.bill_location_id,
	i.bill_user_id,
	i.c_activity_id                       AS c_order_c_activity_id,
	i.c_bpartner_id                       AS c_order_c_bpartner_id,
	i.c_campaign_id                       AS c_order_c_campaign_id,
	i.c_cashline_id,
	i.c_cashplanline_id,
	i.c_charge_id                         AS c_order_c_charge_id,
	i.c_conversiontype_id,
	i.c_currency_id                       AS c_order_c_currency_id,
	i.c_doctype_id,
	i.c_doctypetarget_id,
	i.chargeamt,
	i.copyfrom,
	i.c_payment_id,
	i.c_paymentterm_id,
	i.c_pos_id,
	i.c_project_id                        AS c_order_c_project_id,
	i.created                             AS c_order_created,
	i.createdby                           AS c_order_createdby,
	i.dateacct,
	i.dateprinted,
	i.datepromised                        AS c_order_datepromised,
	i.deliveryrule,
	i.deliveryviarule,
	i.description                         AS c_order_description,
	i.docaction,
	i.docstatus,
	i.documentno,
	i.dropship_bpartner_id,
	i.dropship_location_id,
	i.dropship_user_id,
	i.freightamt                          AS c_order_freightamt,
	i.freightcostrule,
	i.grandtotal,
	i.invoicerule,
	i.isactive                            AS c_order_isactive,
	i.isapproved,
	i.iscreditapproved,
	i.isdelivered,
	i.isdiscountprinted                   AS c_order_isdiscountprinted,
	i.isdropship                          AS c_order_isdropship,
	i.isinvoiced,
	i.ispayschedulevalid,
	i.isprinted,
	i.isselected,
	i.isselfservice                       AS c_order_isselfservice,
	i.issotrx,
	i.istaxincluded,
	i.istransferred,
	i.link_order_id,
	i.m_freightcategory_id                AS c_order_m_freightcategory_id,
	i.m_pricelist_id                      AS c_order_m_pricelist_id,
	i.m_shipper_id                        AS c_order_m_shipper_id,
	i.m_warehouse_id                      AS c_order_m_warehouse_id,
	i.ordertype,
	i.pay_bpartner_id,
	i.pay_location_id,
	i.paymentrule                         AS c_order_paymentrule,
	i.poreference,
	i.posted,
	i.priorityrule,
	i.processed                           AS c_order_processed,
	i.processedon,
	i.promotioncode,
	i.ref_order_id,
	i.salesrep_id,
	i.sendemail                           AS c_order_sendemail,
	i.totallines,
	i.updated                             AS c_order_updated,
	i.updatedby                           AS c_order_updatedby,
	i.user1_id                            AS c_order_user1_id,
	i.user2_id                            AS c_order_user2_id,
	i.volume                              AS c_order_volume,
	i.weight                              AS c_order_weight,
	p.ad_org_id                           AS m_product_ad_org_id,
	p.classification,
	p.copyfrom                            AS m_product_copyfrom,
	p.created                             AS m_product_created,
	p.createdby                           AS m_product_createdby,
	p.c_revenuerecognition_id,
	p.c_subscriptiontype_id,
	p.c_taxcategory_id,
	p.c_uom_id                            AS m_product_c_uom_id,
	p.descriptionurl,
	p.discontinued                        AS m_product_discontinued,
	p.discontinuedat                      AS m_product_discontinuedat,
	p.group1,
	p.group2,
	p.guaranteedays,
	p.guaranteedaysmin,
	p.help,
	p.isactive                            AS m_product_isactive,
	p.isbom,
	p.isdropship                          AS m_product_isdropship,
	p.isexcludeautodelivery,
	p.isinvoiceprintdetails,
	p.ispicklistprintdetails,
	p.ispurchased,
	p.isselfservice                       AS m_product_isselfservice,
	p.issold,
	p.isstocked,
	p.issummary                           AS m_product_issummary,
	p.isverified,
	p.iswebstorefeatured,
	p.lowlevel,
	p.m_attributeset_id,
	p.m_attributesetinstance_id,
	p.m_freightcategory_id                AS m_product_m_freightcategory_id,
	p.m_locator_id,
	p.m_product_category_id               AS m_product_product_category_id,
	p.processing                          AS m_product_processing,
	p.producttype,
	p.r_mailtext_id,
	p.salesrep_id                         AS m_product_salesrep_id,
	p.s_expensetype_id,
	p.shelfdepth,
	p.shelfheight,
	p.shelfwidth,
	p.s_resource_id,
	p.unitsperpack,
	p.unitsperpallet,
	p.updated                             AS m_product_updated,
	p.updatedby                           AS m_product_updatedby,
	p.versionno,
	p.volume                              AS m_product_volume,
	p.weight                              AS m_product_weight,
	po.ad_org_id                          AS m_product_po_ad_org_id,
	po.c_bpartner_id                      AS m_product_po_c_bpartner_id,
	po.c_currency_id                      AS m_product_po_c_currency_id,
	po.costperorder,
	po.created                            AS m_product_po_created,
	po.createdby                          AS m_product_po_createdby,
	po.c_uom_id                           AS m_product_po_c_uom_id,
	po.deliverytime_actual,
	po.deliverytime_promised,
	po.discontinued                       AS m_product_po_discontinued,
	po.discontinuedat                     AS m_product_po_discontinuedat,
	po.isactive                           AS m_product_po_isactive,
	po.iscurrentvendor,
	po.manufacturer                       AS m_product_po_manufacturer,
	po.m_product_id                       AS m_product_po_m_product_id,
	po.order_min,
	po.order_pack,
	po.priceeffective,
	po.pricelastinv,
	po.pricelastpo,
	po.pricelist                          AS m_product_po_pricelist,
	po.pricepo,
	po.qualityrating                      AS m_product_po_qualityrating,
	po.royaltyamt,
	po.upc                                AS m_product_po_upc,
	po.updated                            AS m_product_po_updated,
	po.updatedby                          AS m_product_po_updatedby,
	po.vendorcategory                     AS m_product_po_vendorcategory,
	ra.ad_org_id                          AS s_resourceassignment_ad_org_id,
	ra.assigndatefrom,
	ra.assigndateto,
	ra.created                            AS s_resourceassignment_created,
	ra.createdby                          AS s_resourceassignment_createby,
	ra.isactive                           AS s_resourceassignment_isactive,
	ra.isconfirmed,
	ra.name                               AS s_resourceassignment_name,
	ra.qty                                AS s_resourceassignment_qty,
	ra.s_resource_id                      AS s_resourceassignment_s_resour,
	ra.updated                            AS s_resourceassignment_updated,
	ra.updatedby                          AS s_resourceassignment_updatedby,
	c.ad_org_id                           AS c_charge_c_org_id,
	c.c_bpartner_id                       AS c_charge_c_bpartner_id,
	c.c_chargetype_id,
	c.chargeamt                           AS c_charge_chargeamt,
	c.c_taxcategory_id                    AS c_charge_c_taxcategory_id,
	c.description                         AS c_charge_description,
	c.isactive                            AS c_charge_isactive,
	c.issamecurrency,
	c.issametax,
	c.istaxincluded                       AS c_charge_istaxincluded,
	pp.ad_org_id                          AS c_bpartner_product_ad_org_id,
	pp.c_bpartner_id                      AS c_bp_product_c_bpartner_id,
	pp.created                            AS c_bpartner_product_created,
	pp.createdby                          AS c_bpartner_product_createdby,
	pp.description                        AS c_bpartner_product_description,
	pp.isactive                           AS c_bpartner_product_isactive,
	pp.ismanufacturer,
	pp.manufacturer                       AS c_bpartner_product_manufactur,
	pp.qualityrating                      AS c_bpartner_product_qualityrat,
	pp.shelflifemindays,
	pp.shelflifeminpct                    AS c_bpartner_product_shelflifem,
	pp.updated                            AS c_bpartner_product_updated,
	pp.updatedby                          AS c_bpartner_product_updatedby,
	pp.vendorcategory                     AS c_bpartner_product_vendorcate,
	bp.acqusitioncost,
	bp.actuallifetimevalue,
	bp.ad_language                        AS c_bpartner_ad_language,
	bp.ad_orgbp_id,
	bp.ad_org_id                          AS c_bpartner_ad_org_id,
	bp.bpartner_parent_id,
	bp.c_bp_group_id,
	bp.c_dunning_id,
	bp.c_greeting_id,
	bp.c_invoiceschedule_id,
	bp.c_paymentterm_id                   AS c_bpartner_c_paymentterm_id,
	bp.created                            AS c_bpartner_created,
	bp.createdby                          AS c_bpartner_createdby,
	bp.c_taxgroup_id                      AS c_bpartner_c_taxgroup_id,
	bp.deliveryrule                       AS c_bpartner_deliveryrule,
	bp.deliveryviarule                    AS c_bpartner_deliveryviarule,
	bp.description                        AS c_bpartner_description,
	bp.dunninggrace                       AS c_bpartner_dunninggrace,
	bp.duns,
	bp.firstsale                          AS c_bpartner_firstsale,
	bp.flatdiscount                       AS c_bpartner_flatdiscount,
	bp.freightcostrule                    AS c_bpartner_freightcostrule,
	bp.invoicerule                        AS c_bpartner_invoicerule,
	bp.isactive                           AS c_bpartner_isactive,
	bp.iscustomer,
	bp.isdiscountprinted                  AS c_bpartner_isdiscountprinted,
	bp.isemployee                         AS c_bpartner_isemployee,
	bp.ismanufacturer                     AS c_bpartner_ismanufacturer,
	bp.isonetime,
	bp.ispotaxexempt,
	bp.isprospect,
	bp.issalesrep,
	bp.issummary                          AS c_bpartner_issummary,
	bp.istaxexempt                        AS c_bpartner_istaxexempt,
	bp.isvendor,
	bp.logo_id,
	bp.m_discountschema_id,
	bp.m_pricelist_id                     AS c_bpartner_m_pricelist_id,
	bp.naics,
	bp.name                               AS c_bpartner_name,
	bp.name2                              AS c_bpartner_name2,
	bp.numberemployees,
	bp.paymentrule                        AS c_bpartner_paymentrule,
	bp.paymentrulepo,
	bp.po_discountschema_id,
	bp.po_paymentterm_id,
	bp.po_pricelist_id,
	bp.poreference                        AS c_bpartner_poreference,
	bp.potentiallifetimevalue,
	bp.rating                             AS c_bpartner_rating,
	bp.referenceno                        AS c_bpartner_referenceno,
	bp.salesrep_id                        AS c_bpartner_salesrep_id,
	bp.salesvolume,
	bp.sendemail                          AS c_bpartner_sendemail,
	bp.shareofcustomer,
	bp.shelflifeminpct                    AS c_bpartner_shelflifeminpct,
	bp.so_creditlimit,
	bp.socreditstatus,
	bp.so_creditused,
	bp.so_description,
	bp.taxid                              AS c_bpartner_taxid,
	bp.totalopenbalance,
	bp.updated                            AS c_bpartner_updated,
	bp.updatedby                          AS c_bpartner_updatedby,
	bp.url                                AS c_bpartner_url,
	bp.value                              AS c_bpartner_value,
	bpl.ad_org_id                         AS c_bpartner_location_ad_org_id,
	bpl.c_bpartner_id                     AS c_bpartner_location_c_bpartne,
	bpl.created                           AS c_bpartner_location_created,
	bpl.createdby                         AS c_bpartner_location_createdby,
	bpl.c_salesregion_id,
	bpl.fax                               AS c_bpartner_location_fax,
	bpl.isactive                          AS c_bpartner_location_isactive,
	bpl.isbillto,
	bpl.isdn,
	bpl.ispayfrom,
	bpl.isremitto,
	bpl.isshipto,
	bpl.name                              AS c_bpartner_location_name,
	bpl.phone                             AS c_bpartner_location_phone,
	bpl.phone2                            AS c_bpartner_location_phone2,
	bpl.updated                           AS c_bpartner_location_updated,
	bpl.updatedby                         AS c_bpartner_location_updatedby,
	t.ad_org_id                           AS c_tax_ad_org_id,
	t.ad_rule_id,
	t.c_country_id,
	t.c_region_id,
	t.c_taxcategory_id                    AS c_tax_c_taxcategory_id,
	t.description                         AS c_tax_description,
	t.isactive                            AS c_tax_isactive,
	t.isdefault                           AS c_tax_isdefault,
	t.isdocumentlevel,
	t.issalestax,
	t.issummary                           AS c_tax_issummary,
	t.istaxexempt                         AS c_tax_istaxexempt,
	t.name                                AS c_tax_name,
	t.parent_tax_id,
	t.rate,
	t.requirestaxcertificate,
	t.sopotype,
	t.to_country_id,
	t.to_region_id                        AS c_tax_to_region_id,
	t.validfrom
FROM
	c_orderline ol
		JOIN c_uom uom
		ON ol.c_uom_id = uom.c_uom_id
		JOIN c_order i
		ON ol.c_order_id = i.c_order_id
		LEFT JOIN m_product p
		ON ol.m_product_id = p.m_product_id
		LEFT JOIN m_product_po po
		ON p.m_product_id = po.m_product_id AND i.c_bpartner_id = po.c_bpartner_id
		LEFT JOIN s_resourceassignment ra
		ON ol.s_resourceassignment_id = ra.s_resourceassignment_id
		LEFT JOIN c_charge c
		ON ol.c_charge_id = c.c_charge_id
		LEFT JOIN c_bpartner_product pp
		ON ol.m_product_id = pp.m_product_id AND i.c_bpartner_id = pp.c_bpartner_id
		JOIN c_bpartner bp
		ON ol.c_bpartner_id = bp.c_bpartner_id
		JOIN c_bpartner_location bpl
		ON ol.c_bpartner_location_id = bpl.c_bpartner_location_id
		LEFT JOIN c_tax t
		ON ol.c_tax_id = t.c_tax_id
UNION
SELECT
	ol.ad_client_id,
	ol.ad_org_id,
	ol.isactive,
	ol.created,
	ol.createdby,
	ol.updated,
	ol.updatedby,
	'en_US'::character varying(6)     AS ad_language,
	ol.c_order_id,
	ol.c_orderline_id,
	ol.c_tax_id,
	NULL::character varying           AS taxindicator,
	NULL::numeric                     AS c_bpartner_id,
	NULL::numeric                     AS c_bpartner_location_id,
	NULL::character varying           AS bpname,
	NULL::numeric                     AS c_location_id,
	ol.line + bl.line / 100::numeric  AS line,
	p.m_product_id,
	po.vendorproductno,
	CASE
		WHEN bl.isqtypercentage = 'N'::bpchar THEN ol.qtyordered * bl.qtybom
		ELSE ol.qtyordered * (bl.qtybatch / 100::numeric)
		END                             AS qtyordered,
	CASE
		WHEN bl.isqtypercentage = 'N'::bpchar THEN ol.qtyentered * bl.qtybom
		ELSE ol.qtyentered * (bl.qtybatch / 100::numeric)
		END                             AS qtyentered,
	uom.uomsymbol,
	p.name,
	bl.description,
	p.documentnote,
	p.upc,
	p.sku,
	p.value                           AS productvalue,
	NULL::character varying           AS resourcedescription,
	NULL::numeric                     AS pricelist,
	NULL::numeric                     AS priceenteredlist,
	NULL::numeric                     AS discount,
	NULL::numeric                     AS priceactual,
	NULL::numeric                     AS priceentered,
	NULL::numeric                     AS linenetamt,
	p.description                     AS productdescription,
	p.imageurl,
	ol.c_campaign_id,
	ol.c_project_id,
	ol.c_activity_id,
	ol.c_projectphase_id,
	ol.c_projecttask_id,
	ol.ad_orgtrx_id                   AS c_orderline_ad_orgtrx_id,
	ol.c_charge_id                    AS c_orderline_c_charge_id,
	ol.c_currency_id                  AS c_orderline_c_currency_id,
	ol.c_uom_id,
	ol.datedelivered,
	ol.dateinvoiced,
	ol.dateordered,
	ol.datepromised                   AS c_orderline_datepromised,
	ol.freightamt                     AS c_orderline_freightamt,
	ol.isdescription,
	ol.link_orderline_id,
	ol.m_promotion_id,
	ol.m_shipper_id                   AS c_orderline_m_shipper_id,
	ol.m_warehouse_id                 AS c_orderline_m_warehouse_id,
	ol.pricecost,
	ol.pricelimit,
	ol.processed                      AS c_orderline_processed,
	ol.qtydelivered,
	ol.qtyinvoiced,
	ol.qtylostsales,
	ol.qtyreserved,
	ol.ref_orderline_id,
	ol.rramt,
	ol.rrstartdate,
	ol.s_resourceassignment_id,
	ol.user1_id                       AS c_orderline_user1_id,
	ol.user2_id                       AS c_orderline_user2_id,
	uom.ad_org_id                     AS c_uom_ad_org_id,
	uom.costingprecision,
	uom.description                   AS c_uom_description,
	uom.isactive                      AS c_uom_isactive,
	uom.isdefault,
	uom.name                          AS c_uom_name,
	uom.stdprecision,
	uom.uomtype,
	uom.x12de355,
	i.ad_org_id                       AS c_order_ad_org_id,
	i.ad_orgtrx_id                    AS c_order_ad_orgtrx_id,
	i.ad_user_id,
	i.amountrefunded,
	i.amounttendered,
	i.bill_bpartner_id,
	i.bill_location_id,
	i.bill_user_id,
	i.c_activity_id                   AS c_order_c_activity_id,
	i.c_bpartner_id                   AS c_order_c_bpartner_id,
	i.c_campaign_id                   AS c_order_c_campaign_id,
	i.c_cashline_id,
	i.c_cashplanline_id,
	i.c_charge_id                     AS c_order_c_charge_id,
	i.c_conversiontype_id,
	i.c_currency_id                   AS c_order_c_currency_id,
	i.c_doctype_id,
	i.c_doctypetarget_id,
	i.chargeamt,
	i.copyfrom,
	i.c_payment_id,
	i.c_paymentterm_id,
	i.c_pos_id,
	i.c_project_id                    AS c_order_c_project_id,
	i.created                         AS c_order_created,
	i.createdby                       AS c_order_createdby,
	i.dateacct,
	i.dateprinted,
	i.datepromised                    AS c_order_datepromised,
	i.deliveryrule,
	i.deliveryviarule,
	i.description                     AS c_order_description,
	i.docaction,
	i.docstatus,
	i.documentno,
	i.dropship_bpartner_id,
	i.dropship_location_id,
	i.dropship_user_id,
	i.freightamt                      AS c_order_freightamt,
	i.freightcostrule,
	i.grandtotal,
	i.invoicerule,
	i.isactive                        AS c_order_isactive,
	i.isapproved,
	i.iscreditapproved,
	i.isdelivered,
	i.isdiscountprinted               AS c_order_isdiscountprinted,
	i.isdropship                      AS c_order_isdropship,
	i.isinvoiced,
	i.ispayschedulevalid,
	i.isprinted,
	i.isselected,
	i.isselfservice                   AS c_order_isselfservice,
	i.issotrx,
	i.istaxincluded,
	i.istransferred,
	i.link_order_id,
	i.m_freightcategory_id            AS c_order_m_freightcategory_id,
	i.m_pricelist_id                  AS c_order_m_pricelist_id,
	i.m_shipper_id                    AS c_order_m_shipper_id,
	i.m_warehouse_id                  AS c_order_m_warehouse_id,
	i.ordertype,
	i.pay_bpartner_id,
	i.pay_location_id,
	i.paymentrule                     AS c_order_paymentrule,
	i.poreference,
	i.posted,
	i.priorityrule,
	i.processed                       AS c_order_processed,
	i.processedon,
	i.promotioncode,
	i.ref_order_id,
	i.salesrep_id,
	i.sendemail                       AS c_order_sendemail,
	i.totallines,
	i.updated                         AS c_order_updated,
	i.updatedby                       AS c_order_updatedby,
	i.user1_id                        AS c_order_user1_id,
	i.user2_id                        AS c_order_user2_id,
	i.volume                          AS c_order_volume,
	i.weight                          AS c_order_weight,
	p.ad_org_id                       AS m_product_ad_org_id,
	p.classification,
	p.copyfrom                        AS m_product_copyfrom,
	p.created                         AS m_product_created,
	p.createdby                       AS m_product_createdby,
	p.c_revenuerecognition_id,
	p.c_subscriptiontype_id,
	p.c_taxcategory_id,
	p.c_uom_id                        AS m_product_c_uom_id,
	p.descriptionurl,
	p.discontinued                    AS m_product_discontinued,
	p.discontinuedat                  AS m_product_discontinuedat,
	p.group1,
	p.group2,
	p.guaranteedays,
	p.guaranteedaysmin,
	p.help,
	p.isactive                        AS m_product_isactive,
	p.isbom,
	p.isdropship                      AS m_product_isdropship,
	p.isexcludeautodelivery,
	p.isinvoiceprintdetails,
	p.ispicklistprintdetails,
	p.ispurchased,
	p.isselfservice                   AS m_product_isselfservice,
	p.issold,
	p.isstocked,
	p.issummary                       AS m_product_issummary,
	p.isverified,
	p.iswebstorefeatured,
	p.lowlevel,
	p.m_attributeset_id,
	p.m_attributesetinstance_id,
	p.m_freightcategory_id            AS m_product_m_freightcategory_id,
	p.m_locator_id,
	p.m_product_category_id           AS m_product_product_category_id,
	p.processing                      AS m_product_processing,
	p.producttype,
	p.r_mailtext_id,
	p.salesrep_id                     AS m_product_salesrep_id,
	p.s_expensetype_id,
	p.shelfdepth,
	p.shelfheight,
	p.shelfwidth,
	p.s_resource_id,
	p.unitsperpack,
	p.unitsperpallet,
	p.updated                         AS m_product_updated,
	p.updatedby                       AS m_product_updatedby,
	p.versionno,
	p.volume                          AS m_product_volume,
	p.weight                          AS m_product_weight,
	po.ad_org_id                      AS m_product_po_ad_org_id,
	po.c_bpartner_id                  AS m_product_po_c_bpartner_id,
	po.c_currency_id                  AS m_product_po_c_currency_id,
	po.costperorder,
	po.created                        AS m_product_po_created,
	po.createdby                      AS m_product_po_createdby,
	po.c_uom_id                       AS m_product_po_c_uom_id,
	po.deliverytime_actual,
	po.deliverytime_promised,
	po.discontinued                   AS m_product_po_discontinued,
	po.discontinuedat                 AS m_product_po_discontinuedat,
	po.isactive                       AS m_product_po_isactive,
	po.iscurrentvendor,
	po.manufacturer                   AS m_product_po_manufacturer,
	po.m_product_id                   AS m_product_po_m_product_id,
	po.order_min,
	po.order_pack,
	po.priceeffective,
	po.pricelastinv,
	po.pricelastpo,
	po.pricelist                      AS m_product_po_pricelist,
	po.pricepo,
	po.qualityrating                  AS m_product_po_qualityrating,
	po.royaltyamt,
	po.upc                            AS m_product_po_upc,
	po.updated                        AS m_product_po_updated,
	po.updatedby                      AS m_product_po_updatedby,
	po.vendorcategory                 AS m_product_po_vendorcategory,
	NULL::numeric                     AS s_resourceassignment_ad_org_id,
	NULL::timestamp WITHOUT TIME ZONE AS assigndatefrom,
	NULL::timestamp WITHOUT TIME ZONE AS assigndateto,
	NULL::timestamp WITHOUT TIME ZONE AS s_resourceassignment_created,
	NULL::numeric                     AS s_resourceassignment_createby,
	NULL::bpchar                      AS s_resourceassignment_isactive,
	NULL::bpchar                      AS isconfirmed,
	NULL::character varying           AS s_resourceassignment_name,
	NULL::numeric                     AS s_resourceassignment_qty,
	NULL::numeric                     AS s_resourceassignment_s_resour,
	NULL::timestamp WITHOUT TIME ZONE AS s_resourceassignment_updated,
	NULL::numeric                     AS s_resourceassignment_updatedby,
	NULL::numeric                     AS c_charge_c_org_id,
	NULL::numeric                     AS c_charge_c_bpartner_id,
	NULL::numeric                     AS c_chargetype_id,
	NULL::numeric                     AS c_charge_chargeamt,
	NULL::numeric                     AS c_charge_c_taxcategory_id,
	NULL::character varying           AS c_charge_description,
	NULL::bpchar                      AS c_charge_isactive,
	NULL::bpchar                      AS issamecurrency,
	NULL::bpchar                      AS issametax,
	NULL::bpchar                      AS c_charge_istaxincluded,
	NULL::numeric                     AS c_bpartner_product_ad_org_id,
	NULL::numeric                     AS c_bp_product_c_bpartner_id,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_product_created,
	NULL::numeric                     AS c_bpartner_product_createdby,
	NULL::character varying           AS c_bpartner_product_description,
	NULL::bpchar                      AS c_bpartner_product_isactive,
	NULL::bpchar                      AS ismanufacturer,
	NULL::character varying           AS c_bpartner_product_manufactur,
	NULL::numeric                     AS c_bpartner_product_qualityrat,
	NULL::numeric                     AS shelflifemindays,
	NULL::numeric                     AS c_bpartner_product_shelflifem,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_product_updated,
	NULL::numeric                     AS c_bpartner_product_updatedby,
	NULL::character varying           AS c_bpartner_product_vendorcate,
	NULL::numeric                     AS acqusitioncost,
	NULL::numeric                     AS actuallifetimevalue,
	NULL::character varying           AS c_bpartner_ad_language,
	NULL::numeric                     AS ad_orgbp_id,
	NULL::numeric                     AS c_bpartner_ad_org_id,
	NULL::numeric                     AS bpartner_parent_id,
	NULL::numeric                     AS c_bp_group_id,
	NULL::numeric                     AS c_dunning_id,
	NULL::numeric                     AS c_greeting_id,
	NULL::numeric                     AS c_invoiceschedule_id,
	NULL::numeric                     AS c_bpartner_c_paymentterm_id,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_created,
	NULL::numeric                     AS c_bpartner_createdby,
	NULL::numeric                     AS c_bpartner_c_taxgroup_id,
	NULL::bpchar                      AS c_bpartner_deliveryrule,
	NULL::bpchar                      AS c_bpartner_deliveryviarule,
	NULL::character varying           AS c_bpartner_description,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_dunninggrace,
	NULL::character varying           AS duns,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_firstsale,
	NULL::numeric                     AS c_bpartner_flatdiscount,
	NULL::bpchar                      AS c_bpartner_freightcostrule,
	NULL::bpchar                      AS c_bpartner_invoicerule,
	NULL::bpchar                      AS c_bpartner_isactive,
	NULL::bpchar                      AS iscustomer,
	NULL::bpchar                      AS c_bpartner_isdiscountprinted,
	NULL::bpchar                      AS c_bpartner_isemployee,
	NULL::bpchar                      AS c_bpartner_ismanufacturer,
	NULL::bpchar                      AS isonetime,
	NULL::bpchar                      AS ispotaxexempt,
	NULL::bpchar                      AS isprospect,
	NULL::bpchar                      AS issalesrep,
	NULL::bpchar                      AS c_bpartner_issummary,
	NULL::bpchar                      AS c_bpartner_istaxexempt,
	NULL::bpchar                      AS isvendor,
	NULL::numeric                     AS logo_id,
	NULL::numeric                     AS m_discountschema_id,
	NULL::numeric                     AS c_bpartner_m_pricelist_id,
	NULL::character varying           AS naics,
	NULL::character varying           AS c_bpartner_name,
	NULL::character varying           AS c_bpartner_name2,
	NULL::numeric                     AS numberemployees,
	NULL::bpchar                      AS c_bpartner_paymentrule,
	NULL::bpchar                      AS paymentrulepo,
	NULL::numeric                     AS po_discountschema_id,
	NULL::numeric                     AS po_paymentterm_id,
	NULL::numeric                     AS po_pricelist_id,
	NULL::character varying           AS c_bpartner_poreference,
	NULL::numeric                     AS potentiallifetimevalue,
	NULL::bpchar                      AS c_bpartner_rating,
	NULL::character varying           AS c_bpartner_referenceno,
	NULL::numeric                     AS c_bpartner_salesrep_id,
	NULL::numeric                     AS salesvolume,
	NULL::bpchar                      AS c_bpartner_sendemail,
	NULL::numeric                     AS shareofcustomer,
	NULL::numeric                     AS c_bpartner_shelflifeminpct,
	NULL::numeric                     AS so_creditlimit,
	NULL::bpchar                      AS socreditstatus,
	NULL::numeric                     AS so_creditused,
	NULL::character varying           AS so_description,
	NULL::character varying           AS c_bpartner_taxid,
	NULL::numeric                     AS totalopenbalance,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_updated,
	NULL::numeric                     AS c_bpartner_updatedby,
	NULL::character varying           AS c_bpartner_url,
	NULL::character varying           AS c_bpartner_value,
	NULL::numeric                     AS c_bpartner_location_ad_org_id,
	NULL::numeric                     AS c_bpartner_location_c_bpartne,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_location_created,
	NULL::numeric                     AS c_bpartner_location_createdby,
	NULL::numeric                     AS c_salesregion_id,
	NULL::character varying           AS c_bpartner_location_fax,
	NULL::bpchar                      AS c_bpartner_location_isactive,
	NULL::bpchar                      AS isbillto,
	NULL::character varying           AS isdn,
	NULL::bpchar                      AS ispayfrom,
	NULL::bpchar                      AS isremitto,
	NULL::bpchar                      AS isshipto,
	NULL::character varying           AS c_bpartner_location_name,
	NULL::character varying           AS c_bpartner_location_phone,
	NULL::character varying           AS c_bpartner_location_phone2,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_location_updated,
	NULL::numeric                     AS c_bpartner_location_updatedby,
	NULL::numeric                     AS c_tax_ad_org_id,
	NULL::numeric                     AS ad_rule_id,
	NULL::numeric                     AS c_country_id,
	NULL::numeric                     AS c_region_id,
	NULL::numeric                     AS c_tax_c_taxcategory_id,
	NULL::character varying           AS c_tax_description,
	NULL::bpchar                      AS c_tax_isactive,
	NULL::bpchar                      AS c_tax_isdefault,
	NULL::bpchar                      AS isdocumentlevel,
	NULL::bpchar                      AS issalestax,
	NULL::bpchar                      AS c_tax_issummary,
	NULL::bpchar                      AS c_tax_istaxexempt,
	NULL::character varying           AS c_tax_name,
	NULL::numeric                     AS parent_tax_id,
	NULL::numeric                     AS rate,
	NULL::bpchar                      AS requirestaxcertificate,
	NULL::bpchar                      AS sopotype,
	NULL::numeric                     AS to_country_id,
	NULL::numeric                     AS c_tax_to_region_id,
	NULL::timestamp WITHOUT TIME ZONE AS validfrom
FROM
	pp_product_bom b
		JOIN c_orderline ol
		ON b.m_product_id = ol.m_product_id
		JOIN c_order i
		ON ol.c_order_id = i.c_order_id
		JOIN m_product bp
		ON bp.m_product_id = ol.m_product_id AND bp.isbom = 'Y'::bpchar AND bp.isverified = 'Y'::bpchar AND
		   bp.isinvoiceprintdetails = 'Y'::bpchar
		JOIN pp_product_bomline bl
		ON bl.pp_product_bom_id = b.pp_product_bom_id
		JOIN m_product p
		ON p.m_product_id = bl.m_product_id
		LEFT JOIN m_product_po po
		ON p.m_product_id = po.m_product_id AND i.c_bpartner_id = po.c_bpartner_id
		JOIN c_uom uom
		ON p.c_uom_id = uom.c_uom_id
UNION
SELECT
	i.ad_client_id,
	i.ad_org_id,
	i.isactive,
	i.created,
	i.createdby,
	i.updated,
	i.updatedby,
	'en_US'::character varying(6)     AS ad_language,
	i.c_order_id,
	NULL::numeric                     AS c_orderline_id,
	NULL::numeric                     AS c_tax_id,
	NULL::character varying           AS taxindicator,
	NULL::numeric                     AS c_bpartner_id,
	NULL::numeric                     AS c_bpartner_location_id,
	NULL::character varying           AS bpname,
	NULL::numeric                     AS c_location_id,
	999998                            AS line,
	NULL::numeric                     AS m_product_id,
	NULL::character varying           AS vendorproductno,
	NULL::numeric                     AS qtyordered,
	NULL::numeric                     AS qtyentered,
	NULL::character varying           AS uomsymbol,
	NULL::character varying           AS name,
	NULL::character varying           AS description,
	NULL::character varying           AS documentnote,
	NULL::character varying           AS upc,
	NULL::character varying           AS sku,
	NULL::character varying           AS productvalue,
	NULL::character varying           AS resourcedescription,
	NULL::numeric                     AS pricelist,
	NULL::numeric                     AS priceenteredlist,
	NULL::numeric                     AS discount,
	NULL::numeric                     AS priceactual,
	NULL::numeric                     AS priceentered,
	NULL::numeric                     AS linenetamt,
	NULL::character varying           AS productdescription,
	NULL::character varying           AS imageurl,
	NULL::numeric                     AS c_campaign_id,
	NULL::numeric                     AS c_project_id,
	NULL::numeric                     AS c_activity_id,
	NULL::numeric                     AS c_projectphase_id,
	NULL::numeric                     AS c_projecttask_id,
	NULL::numeric                     AS c_orderline_ad_orgtrx_id,
	NULL::numeric                     AS c_orderline_c_charge_id,
	NULL::numeric                     AS c_orderline_c_currency_id,
	NULL::numeric                     AS c_uom_id,
	NULL::timestamp WITHOUT TIME ZONE AS datedelivered,
	NULL::timestamp WITHOUT TIME ZONE AS dateinvoiced,
	NULL::timestamp WITHOUT TIME ZONE AS dateordered,
	NULL::timestamp WITHOUT TIME ZONE AS c_orderline_datepromised,
	NULL::numeric                     AS c_orderline_freightamt,
	NULL::bpchar                      AS isdescription,
	NULL::numeric                     AS link_orderline_id,
	NULL::numeric                     AS m_promotion_id,
	NULL::numeric                     AS c_orderline_m_shipper_id,
	NULL::numeric                     AS c_orderline_m_warehouse_id,
	NULL::numeric                     AS pricecost,
	NULL::numeric                     AS pricelimit,
	NULL::bpchar                      AS c_orderline_processed,
	NULL::numeric                     AS qtydelivered,
	NULL::numeric                     AS qtyinvoiced,
	NULL::numeric                     AS qtylostsales,
	NULL::numeric                     AS qtyreserved,
	NULL::numeric                     AS ref_orderline_id,
	NULL::numeric                     AS rramt,
	NULL::timestamp WITHOUT TIME ZONE AS rrstartdate,
	NULL::numeric                     AS s_resourceassignment_id,
	NULL::numeric                     AS c_orderline_user1_id,
	NULL::numeric                     AS c_orderline_user2_id,
	NULL::numeric                     AS c_uom_ad_org_id,
	NULL::numeric                     AS costingprecision,
	NULL::character varying           AS c_uom_description,
	NULL::bpchar                      AS c_uom_isactive,
	NULL::bpchar                      AS isdefault,
	NULL::character varying           AS c_uom_name,
	NULL::numeric                     AS stdprecision,
	NULL::character varying           AS uomtype,
	NULL::character varying           AS x12de355,
	NULL::numeric                     AS c_order_ad_org_id,
	NULL::numeric                     AS c_order_ad_orgtrx_id,
	NULL::numeric                     AS ad_user_id,
	NULL::numeric                     AS amountrefunded,
	NULL::numeric                     AS amounttendered,
	NULL::numeric                     AS bill_bpartner_id,
	NULL::numeric                     AS bill_location_id,
	NULL::numeric                     AS bill_user_id,
	NULL::numeric                     AS c_order_c_activity_id,
	NULL::numeric                     AS c_order_c_bpartner_id,
	NULL::numeric                     AS c_order_c_campaign_id,
	NULL::numeric                     AS c_cashline_id,
	NULL::numeric                     AS c_cashplanline_id,
	NULL::numeric                     AS c_order_c_charge_id,
	NULL::numeric                     AS c_conversiontype_id,
	NULL::numeric                     AS c_order_c_currency_id,
	NULL::numeric                     AS c_doctype_id,
	NULL::numeric                     AS c_doctypetarget_id,
	NULL::numeric                     AS chargeamt,
	NULL::bpchar                      AS copyfrom,
	NULL::numeric                     AS c_payment_id,
	NULL::numeric                     AS c_paymentterm_id,
	NULL::numeric                     AS c_pos_id,
	NULL::numeric                     AS c_order_c_project_id,
	NULL::timestamp WITHOUT TIME ZONE AS c_order_created,
	NULL::numeric                     AS c_order_createdby,
	NULL::timestamp WITHOUT TIME ZONE AS dateacct,
	NULL::timestamp WITHOUT TIME ZONE AS dateprinted,
	NULL::timestamp WITHOUT TIME ZONE AS c_order_datepromised,
	NULL::bpchar                      AS deliveryrule,
	NULL::bpchar                      AS deliveryviarule,
	NULL::character varying           AS c_order_description,
	NULL::bpchar                      AS docaction,
	NULL::bpchar                      AS docstatus,
	NULL::character varying           AS documentno,
	NULL::numeric                     AS dropship_bpartner_id,
	NULL::numeric                     AS dropship_location_id,
	NULL::numeric                     AS dropship_user_id,
	NULL::numeric                     AS c_order_freightamt,
	NULL::bpchar                      AS freightcostrule,
	NULL::numeric                     AS grandtotal,
	NULL::bpchar                      AS invoicerule,
	NULL::bpchar                      AS c_order_isactive,
	NULL::bpchar                      AS isapproved,
	NULL::bpchar                      AS iscreditapproved,
	NULL::bpchar                      AS isdelivered,
	NULL::bpchar                      AS c_order_isdiscountprinted,
	NULL::bpchar                      AS c_order_isdropship,
	NULL::bpchar                      AS isinvoiced,
	NULL::bpchar                      AS ispayschedulevalid,
	NULL::bpchar                      AS isprinted,
	NULL::bpchar                      AS isselected,
	NULL::bpchar                      AS c_order_isselfservice,
	NULL::bpchar                      AS issotrx,
	NULL::bpchar                      AS istaxincluded,
	NULL::bpchar                      AS istransferred,
	NULL::numeric                     AS link_order_id,
	NULL::numeric                     AS c_order_m_freightcategory_id,
	NULL::numeric                     AS c_order_m_pricelist_id,
	NULL::numeric                     AS c_order_m_shipper_id,
	NULL::numeric                     AS c_order_m_warehouse_id,
	NULL::character varying           AS ordertype,
	NULL::numeric                     AS pay_bpartner_id,
	NULL::numeric                     AS pay_location_id,
	NULL::bpchar                      AS c_order_paymentrule,
	NULL::character varying           AS poreference,
	NULL::bpchar                      AS posted,
	NULL::bpchar                      AS priorityrule,
	NULL::bpchar                      AS c_order_processed,
	NULL::numeric                     AS processedon,
	NULL::character varying           AS promotioncode,
	NULL::numeric                     AS ref_order_id,
	NULL::numeric                     AS salesrep_id,
	NULL::bpchar                      AS c_order_sendemail,
	NULL::numeric                     AS totallines,
	NULL::timestamp WITHOUT TIME ZONE AS c_order_updated,
	NULL::numeric                     AS c_order_updatedby,
	NULL::numeric                     AS c_order_user1_id,
	NULL::numeric                     AS c_order_user2_id,
	NULL::numeric                     AS c_order_volume,
	NULL::numeric                     AS c_order_weight,
	NULL::numeric                     AS m_product_ad_org_id,
	NULL::character varying           AS classification,
	NULL::bpchar                      AS m_product_copyfrom,
	NULL::timestamp WITHOUT TIME ZONE AS m_product_created,
	NULL::numeric                     AS m_product_createdby,
	NULL::numeric                     AS c_revenuerecognition_id,
	NULL::numeric                     AS c_subscriptiontype_id,
	NULL::numeric                     AS c_taxcategory_id,
	NULL::numeric                     AS m_product_c_uom_id,
	NULL::character varying           AS descriptionurl,
	NULL::bpchar                      AS m_product_discontinued,
	NULL::timestamp WITHOUT TIME ZONE AS m_product_discontinuedat,
	NULL::character varying           AS group1,
	NULL::character varying           AS group2,
	NULL::numeric                     AS guaranteedays,
	NULL::numeric                     AS guaranteedaysmin,
	NULL::character varying           AS help,
	NULL::bpchar                      AS m_product_isactive,
	NULL::bpchar                      AS isbom,
	NULL::bpchar                      AS m_product_isdropship,
	NULL::bpchar                      AS isexcludeautodelivery,
	NULL::bpchar                      AS isinvoiceprintdetails,
	NULL::bpchar                      AS ispicklistprintdetails,
	NULL::bpchar                      AS ispurchased,
	NULL::bpchar                      AS m_product_isselfservice,
	NULL::bpchar                      AS issold,
	NULL::bpchar                      AS isstocked,
	NULL::bpchar                      AS m_product_issummary,
	NULL::bpchar                      AS isverified,
	NULL::bpchar                      AS iswebstorefeatured,
	NULL::numeric                     AS lowlevel,
	NULL::numeric                     AS m_attributeset_id,
	NULL::numeric                     AS m_attributesetinstance_id,
	NULL::numeric                     AS m_product_m_freightcategory_id,
	NULL::numeric                     AS m_locator_id,
	NULL::numeric                     AS m_product_product_category_id,
	NULL::bpchar                      AS m_product_processing,
	NULL::bpchar                      AS producttype,
	NULL::numeric                     AS r_mailtext_id,
	NULL::numeric                     AS m_product_salesrep_id,
	NULL::numeric                     AS s_expensetype_id,
	NULL::numeric                     AS shelfdepth,
	NULL::numeric                     AS shelfheight,
	NULL::numeric                     AS shelfwidth,
	NULL::numeric                     AS s_resource_id,
	NULL::numeric                     AS unitsperpack,
	NULL::numeric                     AS unitsperpallet,
	NULL::timestamp WITHOUT TIME ZONE AS m_product_updated,
	NULL::numeric                     AS m_product_updatedby,
	NULL::character varying           AS versionno,
	NULL::numeric                     AS m_product_volume,
	NULL::numeric                     AS m_product_weight,
	NULL::numeric                     AS m_product_po_ad_org_id,
	NULL::numeric                     AS m_product_po_c_bpartner_id,
	NULL::numeric                     AS m_product_po_c_currency_id,
	NULL::numeric                     AS costperorder,
	NULL::timestamp WITHOUT TIME ZONE AS m_product_po_created,
	NULL::numeric                     AS m_product_po_createdby,
	NULL::numeric                     AS m_product_po_c_uom_id,
	NULL::numeric                     AS deliverytime_actual,
	NULL::numeric                     AS deliverytime_promised,
	NULL::bpchar                      AS m_product_po_discontinued,
	NULL::timestamp WITHOUT TIME ZONE AS m_product_po_discontinuedat,
	NULL::bpchar                      AS m_product_po_isactive,
	NULL::bpchar                      AS iscurrentvendor,
	NULL::character varying           AS m_product_po_manufacturer,
	NULL::numeric                     AS m_product_po_m_product_id,
	NULL::numeric                     AS order_min,
	NULL::numeric                     AS order_pack,
	NULL::timestamp WITHOUT TIME ZONE AS priceeffective,
	NULL::numeric                     AS pricelastinv,
	NULL::numeric                     AS pricelastpo,
	NULL::numeric                     AS m_product_po_pricelist,
	NULL::numeric                     AS pricepo,
	NULL::numeric                     AS m_product_po_qualityrating,
	NULL::numeric                     AS royaltyamt,
	NULL::character varying           AS m_product_po_upc,
	NULL::timestamp WITHOUT TIME ZONE AS m_product_po_updated,
	NULL::numeric                     AS m_product_po_updatedby,
	NULL::character varying           AS m_product_po_vendorcategory,
	NULL::numeric                     AS s_resourceassignment_ad_org_id,
	NULL::timestamp WITHOUT TIME ZONE AS assigndatefrom,
	NULL::timestamp WITHOUT TIME ZONE AS assigndateto,
	NULL::timestamp WITHOUT TIME ZONE AS s_resourceassignment_created,
	NULL::numeric                     AS s_resourceassignment_createby,
	NULL::bpchar                      AS s_resourceassignment_isactive,
	NULL::bpchar                      AS isconfirmed,
	NULL::character varying           AS s_resourceassignment_name,
	NULL::numeric                     AS s_resourceassignment_qty,
	NULL::numeric                     AS s_resourceassignment_s_resour,
	NULL::timestamp WITHOUT TIME ZONE AS s_resourceassignment_updated,
	NULL::numeric                     AS s_resourceassignment_updatedby,
	NULL::numeric                     AS c_charge_c_org_id,
	NULL::numeric                     AS c_charge_c_bpartner_id,
	NULL::numeric                     AS c_chargetype_id,
	NULL::numeric                     AS c_charge_chargeamt,
	NULL::numeric                     AS c_charge_c_taxcategory_id,
	NULL::character varying           AS c_charge_description,
	NULL::bpchar                      AS c_charge_isactive,
	NULL::bpchar                      AS issamecurrency,
	NULL::bpchar                      AS issametax,
	NULL::bpchar                      AS c_charge_istaxincluded,
	NULL::numeric                     AS c_bpartner_product_ad_org_id,
	NULL::numeric                     AS c_bp_product_c_bpartner_id,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_product_created,
	NULL::numeric                     AS c_bpartner_product_createdby,
	NULL::character varying           AS c_bpartner_product_description,
	NULL::bpchar                      AS c_bpartner_product_isactive,
	NULL::bpchar                      AS ismanufacturer,
	NULL::character varying           AS c_bpartner_product_manufactur,
	NULL::numeric                     AS c_bpartner_product_qualityrat,
	NULL::numeric                     AS shelflifemindays,
	NULL::numeric                     AS c_bpartner_product_shelflifem,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_product_updated,
	NULL::numeric                     AS c_bpartner_product_updatedby,
	NULL::character varying           AS c_bpartner_product_vendorcate,
	NULL::numeric                     AS acqusitioncost,
	NULL::numeric                     AS actuallifetimevalue,
	NULL::character varying           AS c_bpartner_ad_language,
	NULL::numeric                     AS ad_orgbp_id,
	NULL::numeric                     AS c_bpartner_ad_org_id,
	NULL::numeric                     AS bpartner_parent_id,
	NULL::numeric                     AS c_bp_group_id,
	NULL::numeric                     AS c_dunning_id,
	NULL::numeric                     AS c_greeting_id,
	NULL::numeric                     AS c_invoiceschedule_id,
	NULL::numeric                     AS c_bpartner_c_paymentterm_id,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_created,
	NULL::numeric                     AS c_bpartner_createdby,
	NULL::numeric                     AS c_bpartner_c_taxgroup_id,
	NULL::bpchar                      AS c_bpartner_deliveryrule,
	NULL::bpchar                      AS c_bpartner_deliveryviarule,
	NULL::character varying           AS c_bpartner_description,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_dunninggrace,
	NULL::character varying           AS duns,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_firstsale,
	NULL::numeric                     AS c_bpartner_flatdiscount,
	NULL::bpchar                      AS c_bpartner_freightcostrule,
	NULL::bpchar                      AS c_bpartner_invoicerule,
	NULL::bpchar                      AS c_bpartner_isactive,
	NULL::bpchar                      AS iscustomer,
	NULL::bpchar                      AS c_bpartner_isdiscountprinted,
	NULL::bpchar                      AS c_bpartner_isemployee,
	NULL::bpchar                      AS c_bpartner_ismanufacturer,
	NULL::bpchar                      AS isonetime,
	NULL::bpchar                      AS ispotaxexempt,
	NULL::bpchar                      AS isprospect,
	NULL::bpchar                      AS issalesrep,
	NULL::bpchar                      AS c_bpartner_issummary,
	NULL::bpchar                      AS c_bpartner_istaxexempt,
	NULL::bpchar                      AS isvendor,
	NULL::numeric                     AS logo_id,
	NULL::numeric                     AS m_discountschema_id,
	NULL::numeric                     AS c_bpartner_m_pricelist_id,
	NULL::character varying           AS naics,
	NULL::character varying           AS c_bpartner_name,
	NULL::character varying           AS c_bpartner_name2,
	NULL::numeric                     AS numberemployees,
	NULL::bpchar                      AS c_bpartner_paymentrule,
	NULL::bpchar                      AS paymentrulepo,
	NULL::numeric                     AS po_discountschema_id,
	NULL::numeric                     AS po_paymentterm_id,
	NULL::numeric                     AS po_pricelist_id,
	NULL::character varying           AS c_bpartner_poreference,
	NULL::numeric                     AS potentiallifetimevalue,
	NULL::bpchar                      AS c_bpartner_rating,
	NULL::character varying           AS c_bpartner_referenceno,
	NULL::numeric                     AS c_bpartner_salesrep_id,
	NULL::numeric                     AS salesvolume,
	NULL::bpchar                      AS c_bpartner_sendemail,
	NULL::numeric                     AS shareofcustomer,
	NULL::numeric                     AS c_bpartner_shelflifeminpct,
	NULL::numeric                     AS so_creditlimit,
	NULL::bpchar                      AS socreditstatus,
	NULL::numeric                     AS so_creditused,
	NULL::character varying           AS so_description,
	NULL::character varying           AS c_bpartner_taxid,
	NULL::numeric                     AS totalopenbalance,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_updated,
	NULL::numeric                     AS c_bpartner_updatedby,
	NULL::character varying           AS c_bpartner_url,
	NULL::character varying           AS c_bpartner_value,
	NULL::numeric                     AS c_bpartner_location_ad_org_id,
	NULL::numeric                     AS c_bpartner_location_c_bpartne,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_location_created,
	NULL::numeric                     AS c_bpartner_location_createdby,
	NULL::numeric                     AS c_salesregion_id,
	NULL::character varying           AS c_bpartner_location_fax,
	NULL::bpchar                      AS c_bpartner_location_isactive,
	NULL::bpchar                      AS isbillto,
	NULL::character varying           AS isdn,
	NULL::bpchar                      AS ispayfrom,
	NULL::bpchar                      AS isremitto,
	NULL::bpchar                      AS isshipto,
	NULL::character varying           AS c_bpartner_location_name,
	NULL::character varying           AS c_bpartner_location_phone,
	NULL::character varying           AS c_bpartner_location_phone2,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_location_updated,
	NULL::numeric                     AS c_bpartner_location_updatedby,
	NULL::numeric                     AS c_tax_ad_org_id,
	NULL::numeric                     AS ad_rule_id,
	NULL::numeric                     AS c_country_id,
	NULL::numeric                     AS c_region_id,
	NULL::numeric                     AS c_tax_c_taxcategory_id,
	NULL::character varying           AS c_tax_description,
	NULL::bpchar                      AS c_tax_isactive,
	NULL::bpchar                      AS c_tax_isdefault,
	NULL::bpchar                      AS isdocumentlevel,
	NULL::bpchar                      AS issalestax,
	NULL::bpchar                      AS c_tax_issummary,
	NULL::bpchar                      AS c_tax_istaxexempt,
	NULL::character varying           AS c_tax_name,
	NULL::numeric                     AS parent_tax_id,
	NULL::numeric                     AS rate,
	NULL::bpchar                      AS requirestaxcertificate,
	NULL::bpchar                      AS sopotype,
	NULL::numeric                     AS to_country_id,
	NULL::numeric                     AS c_tax_to_region_id,
	NULL::timestamp WITHOUT TIME ZONE AS validfrom
FROM
	c_order i
UNION
SELECT
	ot.ad_client_id,
	ot.ad_org_id,
	ot.isactive,
	ot.created,
	ot.createdby,
	ot.updated,
	ot.updatedby,
	'en_US'::character varying(6)     AS ad_language,
	ot.c_order_id,
	NULL::numeric                     AS c_orderline_id,
	ot.c_tax_id,
	t.taxindicator,
	NULL::numeric                     AS c_bpartner_id,
	NULL::numeric                     AS c_bpartner_location_id,
	NULL::character varying           AS bpname,
	NULL::numeric                     AS c_location_id,
	999999                            AS line,
	NULL::numeric                     AS m_product_id,
	NULL::character varying           AS vendorproductno,
	NULL::numeric                     AS qtyordered,
	NULL::numeric                     AS qtyentered,
	NULL::character varying           AS uomsymbol,
	t.name,
	NULL::character varying           AS description,
	NULL::character varying           AS documentnote,
	NULL::character varying           AS upc,
	NULL::character varying           AS sku,
	NULL::character varying           AS productvalue,
	NULL::character varying           AS resourcedescription,
	NULL::numeric                     AS pricelist,
	NULL::numeric                     AS priceenteredlist,
	NULL::numeric                     AS discount,
	CASE
		WHEN ot.istaxincluded = 'Y'::bpchar THEN ot.taxamt
		ELSE ot.taxbaseamt
		END                             AS priceactual,
	CASE
		WHEN ot.istaxincluded = 'Y'::bpchar THEN ot.taxamt
		ELSE ot.taxbaseamt
		END                             AS priceentered,
	CASE
		WHEN ot.istaxincluded = 'Y'::bpchar THEN NULL::numeric
		ELSE ot.taxamt
		END                             AS linenetamt,
	NULL::character varying           AS productdescription,
	NULL::character varying           AS imageurl,
	NULL::numeric                     AS c_campaign_id,
	NULL::numeric                     AS c_project_id,
	NULL::numeric                     AS c_activity_id,
	NULL::numeric                     AS c_projectphase_id,
	NULL::numeric                     AS c_projecttask_id,
	NULL::numeric                     AS c_orderline_ad_orgtrx_id,
	NULL::numeric                     AS c_orderline_c_charge_id,
	NULL::numeric                     AS c_orderline_c_currency_id,
	NULL::numeric                     AS c_uom_id,
	NULL::timestamp WITHOUT TIME ZONE AS datedelivered,
	NULL::timestamp WITHOUT TIME ZONE AS dateinvoiced,
	NULL::timestamp WITHOUT TIME ZONE AS dateordered,
	NULL::timestamp WITHOUT TIME ZONE AS c_orderline_datepromised,
	NULL::numeric                     AS c_orderline_freightamt,
	NULL::bpchar                      AS isdescription,
	NULL::numeric                     AS link_orderline_id,
	NULL::numeric                     AS m_promotion_id,
	NULL::numeric                     AS c_orderline_m_shipper_id,
	NULL::numeric                     AS c_orderline_m_warehouse_id,
	NULL::numeric                     AS pricecost,
	NULL::numeric                     AS pricelimit,
	NULL::bpchar                      AS c_orderline_processed,
	NULL::numeric                     AS qtydelivered,
	NULL::numeric                     AS qtyinvoiced,
	NULL::numeric                     AS qtylostsales,
	NULL::numeric                     AS qtyreserved,
	NULL::numeric                     AS ref_orderline_id,
	NULL::numeric                     AS rramt,
	NULL::timestamp WITHOUT TIME ZONE AS rrstartdate,
	NULL::numeric                     AS s_resourceassignment_id,
	NULL::numeric                     AS c_orderline_user1_id,
	NULL::numeric                     AS c_orderline_user2_id,
	NULL::numeric                     AS c_uom_ad_org_id,
	NULL::numeric                     AS costingprecision,
	NULL::character varying           AS c_uom_description,
	NULL::bpchar                      AS c_uom_isactive,
	NULL::bpchar                      AS isdefault,
	NULL::character varying           AS c_uom_name,
	NULL::numeric                     AS stdprecision,
	NULL::character varying           AS uomtype,
	NULL::character varying           AS x12de355,
	NULL::numeric                     AS c_order_ad_org_id,
	NULL::numeric                     AS c_order_ad_orgtrx_id,
	NULL::numeric                     AS ad_user_id,
	NULL::numeric                     AS amountrefunded,
	NULL::numeric                     AS amounttendered,
	NULL::numeric                     AS bill_bpartner_id,
	NULL::numeric                     AS bill_location_id,
	NULL::numeric                     AS bill_user_id,
	NULL::numeric                     AS c_order_c_activity_id,
	NULL::numeric                     AS c_order_c_bpartner_id,
	NULL::numeric                     AS c_order_c_campaign_id,
	NULL::numeric                     AS c_cashline_id,
	NULL::numeric                     AS c_cashplanline_id,
	NULL::numeric                     AS c_order_c_charge_id,
	NULL::numeric                     AS c_conversiontype_id,
	NULL::numeric                     AS c_order_c_currency_id,
	NULL::numeric                     AS c_doctype_id,
	NULL::numeric                     AS c_doctypetarget_id,
	NULL::numeric                     AS chargeamt,
	NULL::bpchar                      AS copyfrom,
	NULL::numeric                     AS c_payment_id,
	NULL::numeric                     AS c_paymentterm_id,
	NULL::numeric                     AS c_pos_id,
	NULL::numeric                     AS c_order_c_project_id,
	NULL::timestamp WITHOUT TIME ZONE AS c_order_created,
	NULL::numeric                     AS c_order_createdby,
	NULL::timestamp WITHOUT TIME ZONE AS dateacct,
	NULL::timestamp WITHOUT TIME ZONE AS dateprinted,
	NULL::timestamp WITHOUT TIME ZONE AS c_order_datepromised,
	NULL::bpchar                      AS deliveryrule,
	NULL::bpchar                      AS deliveryviarule,
	NULL::character varying           AS c_order_description,
	NULL::bpchar                      AS docaction,
	NULL::bpchar                      AS docstatus,
	NULL::character varying           AS documentno,
	NULL::numeric                     AS dropship_bpartner_id,
	NULL::numeric                     AS dropship_location_id,
	NULL::numeric                     AS dropship_user_id,
	NULL::numeric                     AS c_order_freightamt,
	NULL::bpchar                      AS freightcostrule,
	NULL::numeric                     AS grandtotal,
	NULL::bpchar                      AS invoicerule,
	NULL::bpchar                      AS c_order_isactive,
	NULL::bpchar                      AS isapproved,
	NULL::bpchar                      AS iscreditapproved,
	NULL::bpchar                      AS isdelivered,
	NULL::bpchar                      AS c_order_isdiscountprinted,
	NULL::bpchar                      AS c_order_isdropship,
	NULL::bpchar                      AS isinvoiced,
	NULL::bpchar                      AS ispayschedulevalid,
	NULL::bpchar                      AS isprinted,
	NULL::bpchar                      AS isselected,
	NULL::bpchar                      AS c_order_isselfservice,
	NULL::bpchar                      AS issotrx,
	NULL::bpchar                      AS istaxincluded,
	NULL::bpchar                      AS istransferred,
	NULL::numeric                     AS link_order_id,
	NULL::numeric                     AS c_order_m_freightcategory_id,
	NULL::numeric                     AS c_order_m_pricelist_id,
	NULL::numeric                     AS c_order_m_shipper_id,
	NULL::numeric                     AS c_order_m_warehouse_id,
	NULL::character varying           AS ordertype,
	NULL::numeric                     AS pay_bpartner_id,
	NULL::numeric                     AS pay_location_id,
	NULL::bpchar                      AS c_order_paymentrule,
	NULL::character varying           AS poreference,
	NULL::bpchar                      AS posted,
	NULL::bpchar                      AS priorityrule,
	NULL::bpchar                      AS c_order_processed,
	NULL::numeric                     AS processedon,
	NULL::character varying           AS promotioncode,
	NULL::numeric                     AS ref_order_id,
	NULL::numeric                     AS salesrep_id,
	NULL::bpchar                      AS c_order_sendemail,
	NULL::numeric                     AS totallines,
	NULL::timestamp WITHOUT TIME ZONE AS c_order_updated,
	NULL::numeric                     AS c_order_updatedby,
	NULL::numeric                     AS c_order_user1_id,
	NULL::numeric                     AS c_order_user2_id,
	NULL::numeric                     AS c_order_volume,
	NULL::numeric                     AS c_order_weight,
	NULL::numeric                     AS m_product_ad_org_id,
	NULL::character varying           AS classification,
	NULL::bpchar                      AS m_product_copyfrom,
	NULL::timestamp WITHOUT TIME ZONE AS m_product_created,
	NULL::numeric                     AS m_product_createdby,
	NULL::numeric                     AS c_revenuerecognition_id,
	NULL::numeric                     AS c_subscriptiontype_id,
	NULL::numeric                     AS c_taxcategory_id,
	NULL::numeric                     AS m_product_c_uom_id,
	NULL::character varying           AS descriptionurl,
	NULL::bpchar                      AS m_product_discontinued,
	NULL::timestamp WITHOUT TIME ZONE AS m_product_discontinuedat,
	NULL::character varying           AS group1,
	NULL::character varying           AS group2,
	NULL::numeric                     AS guaranteedays,
	NULL::numeric                     AS guaranteedaysmin,
	NULL::character varying           AS help,
	NULL::bpchar                      AS m_product_isactive,
	NULL::bpchar                      AS isbom,
	NULL::bpchar                      AS m_product_isdropship,
	NULL::bpchar                      AS isexcludeautodelivery,
	NULL::bpchar                      AS isinvoiceprintdetails,
	NULL::bpchar                      AS ispicklistprintdetails,
	NULL::bpchar                      AS ispurchased,
	NULL::bpchar                      AS m_product_isselfservice,
	NULL::bpchar                      AS issold,
	NULL::bpchar                      AS isstocked,
	NULL::bpchar                      AS m_product_issummary,
	NULL::bpchar                      AS isverified,
	NULL::bpchar                      AS iswebstorefeatured,
	NULL::numeric                     AS lowlevel,
	NULL::numeric                     AS m_attributeset_id,
	NULL::numeric                     AS m_attributesetinstance_id,
	NULL::numeric                     AS m_product_m_freightcategory_id,
	NULL::numeric                     AS m_locator_id,
	NULL::numeric                     AS m_product_product_category_id,
	NULL::bpchar                      AS m_product_processing,
	NULL::bpchar                      AS producttype,
	NULL::numeric                     AS r_mailtext_id,
	NULL::numeric                     AS m_product_salesrep_id,
	NULL::numeric                     AS s_expensetype_id,
	NULL::numeric                     AS shelfdepth,
	NULL::numeric                     AS shelfheight,
	NULL::numeric                     AS shelfwidth,
	NULL::numeric                     AS s_resource_id,
	NULL::numeric                     AS unitsperpack,
	NULL::numeric                     AS unitsperpallet,
	NULL::timestamp WITHOUT TIME ZONE AS m_product_updated,
	NULL::numeric                     AS m_product_updatedby,
	NULL::character varying           AS versionno,
	NULL::numeric                     AS m_product_volume,
	NULL::numeric                     AS m_product_weight,
	NULL::numeric                     AS m_product_po_ad_org_id,
	NULL::numeric                     AS m_product_po_c_bpartner_id,
	NULL::numeric                     AS m_product_po_c_currency_id,
	NULL::numeric                     AS costperorder,
	NULL::timestamp WITHOUT TIME ZONE AS m_product_po_created,
	NULL::numeric                     AS m_product_po_createdby,
	NULL::numeric                     AS m_product_po_c_uom_id,
	NULL::numeric                     AS deliverytime_actual,
	NULL::numeric                     AS deliverytime_promised,
	NULL::bpchar                      AS m_product_po_discontinued,
	NULL::timestamp WITHOUT TIME ZONE AS m_product_po_discontinuedat,
	NULL::bpchar                      AS m_product_po_isactive,
	NULL::bpchar                      AS iscurrentvendor,
	NULL::character varying           AS m_product_po_manufacturer,
	NULL::numeric                     AS m_product_po_m_product_id,
	NULL::numeric                     AS order_min,
	NULL::numeric                     AS order_pack,
	NULL::timestamp WITHOUT TIME ZONE AS priceeffective,
	NULL::numeric                     AS pricelastinv,
	NULL::numeric                     AS pricelastpo,
	NULL::numeric                     AS m_product_po_pricelist,
	NULL::numeric                     AS pricepo,
	NULL::numeric                     AS m_product_po_qualityrating,
	NULL::numeric                     AS royaltyamt,
	NULL::character varying           AS m_product_po_upc,
	NULL::timestamp WITHOUT TIME ZONE AS m_product_po_updated,
	NULL::numeric                     AS m_product_po_updatedby,
	NULL::character varying           AS m_product_po_vendorcategory,
	NULL::numeric                     AS s_resourceassignment_ad_org_id,
	NULL::timestamp WITHOUT TIME ZONE AS assigndatefrom,
	NULL::timestamp WITHOUT TIME ZONE AS assigndateto,
	NULL::timestamp WITHOUT TIME ZONE AS s_resourceassignment_created,
	NULL::numeric                     AS s_resourceassignment_createby,
	NULL::bpchar                      AS s_resourceassignment_isactive,
	NULL::bpchar                      AS isconfirmed,
	NULL::character varying           AS s_resourceassignment_name,
	NULL::numeric                     AS s_resourceassignment_qty,
	NULL::numeric                     AS s_resourceassignment_s_resour,
	NULL::timestamp WITHOUT TIME ZONE AS s_resourceassignment_updated,
	NULL::numeric                     AS s_resourceassignment_updatedby,
	NULL::numeric                     AS c_charge_c_org_id,
	NULL::numeric                     AS c_charge_c_bpartner_id,
	NULL::numeric                     AS c_chargetype_id,
	NULL::numeric                     AS c_charge_chargeamt,
	NULL::numeric                     AS c_charge_c_taxcategory_id,
	NULL::character varying           AS c_charge_description,
	NULL::bpchar                      AS c_charge_isactive,
	NULL::bpchar                      AS issamecurrency,
	NULL::bpchar                      AS issametax,
	NULL::bpchar                      AS c_charge_istaxincluded,
	NULL::numeric                     AS c_bpartner_product_ad_org_id,
	NULL::numeric                     AS c_bp_product_c_bpartner_id,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_product_created,
	NULL::numeric                     AS c_bpartner_product_createdby,
	NULL::character varying           AS c_bpartner_product_description,
	NULL::bpchar                      AS c_bpartner_product_isactive,
	NULL::bpchar                      AS ismanufacturer,
	NULL::character varying           AS c_bpartner_product_manufactur,
	NULL::numeric                     AS c_bpartner_product_qualityrat,
	NULL::numeric                     AS shelflifemindays,
	NULL::numeric                     AS c_bpartner_product_shelflifem,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_product_updated,
	NULL::numeric                     AS c_bpartner_product_updatedby,
	NULL::character varying           AS c_bpartner_product_vendorcate,
	NULL::numeric                     AS acqusitioncost,
	NULL::numeric                     AS actuallifetimevalue,
	NULL::character varying           AS c_bpartner_ad_language,
	NULL::numeric                     AS ad_orgbp_id,
	NULL::numeric                     AS c_bpartner_ad_org_id,
	NULL::numeric                     AS bpartner_parent_id,
	NULL::numeric                     AS c_bp_group_id,
	NULL::numeric                     AS c_dunning_id,
	NULL::numeric                     AS c_greeting_id,
	NULL::numeric                     AS c_invoiceschedule_id,
	NULL::numeric                     AS c_bpartner_c_paymentterm_id,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_created,
	NULL::numeric                     AS c_bpartner_createdby,
	NULL::numeric                     AS c_bpartner_c_taxgroup_id,
	NULL::bpchar                      AS c_bpartner_deliveryrule,
	NULL::bpchar                      AS c_bpartner_deliveryviarule,
	NULL::character varying           AS c_bpartner_description,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_dunninggrace,
	NULL::character varying           AS duns,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_firstsale,
	NULL::numeric                     AS c_bpartner_flatdiscount,
	NULL::bpchar                      AS c_bpartner_freightcostrule,
	NULL::bpchar                      AS c_bpartner_invoicerule,
	NULL::bpchar                      AS c_bpartner_isactive,
	NULL::bpchar                      AS iscustomer,
	NULL::bpchar                      AS c_bpartner_isdiscountprinted,
	NULL::bpchar                      AS c_bpartner_isemployee,
	NULL::bpchar                      AS c_bpartner_ismanufacturer,
	NULL::bpchar                      AS isonetime,
	NULL::bpchar                      AS ispotaxexempt,
	NULL::bpchar                      AS isprospect,
	NULL::bpchar                      AS issalesrep,
	NULL::bpchar                      AS c_bpartner_issummary,
	NULL::bpchar                      AS c_bpartner_istaxexempt,
	NULL::bpchar                      AS isvendor,
	NULL::numeric                     AS logo_id,
	NULL::numeric                     AS m_discountschema_id,
	NULL::numeric                     AS c_bpartner_m_pricelist_id,
	NULL::character varying           AS naics,
	NULL::character varying           AS c_bpartner_name,
	NULL::character varying           AS c_bpartner_name2,
	NULL::numeric                     AS numberemployees,
	NULL::bpchar                      AS c_bpartner_paymentrule,
	NULL::bpchar                      AS paymentrulepo,
	NULL::numeric                     AS po_discountschema_id,
	NULL::numeric                     AS po_paymentterm_id,
	NULL::numeric                     AS po_pricelist_id,
	NULL::character varying           AS c_bpartner_poreference,
	NULL::numeric                     AS potentiallifetimevalue,
	NULL::bpchar                      AS c_bpartner_rating,
	NULL::character varying           AS c_bpartner_referenceno,
	NULL::numeric                     AS c_bpartner_salesrep_id,
	NULL::numeric                     AS salesvolume,
	NULL::bpchar                      AS c_bpartner_sendemail,
	NULL::numeric                     AS shareofcustomer,
	NULL::numeric                     AS c_bpartner_shelflifeminpct,
	NULL::numeric                     AS so_creditlimit,
	NULL::bpchar                      AS socreditstatus,
	NULL::numeric                     AS so_creditused,
	NULL::character varying           AS so_description,
	NULL::character varying           AS c_bpartner_taxid,
	NULL::numeric                     AS totalopenbalance,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_updated,
	NULL::numeric                     AS c_bpartner_updatedby,
	NULL::character varying           AS c_bpartner_url,
	NULL::character varying           AS c_bpartner_value,
	NULL::numeric                     AS c_bpartner_location_ad_org_id,
	NULL::numeric                     AS c_bpartner_location_c_bpartne,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_location_created,
	NULL::numeric                     AS c_bpartner_location_createdby,
	NULL::numeric                     AS c_salesregion_id,
	NULL::character varying           AS c_bpartner_location_fax,
	NULL::bpchar                      AS c_bpartner_location_isactive,
	NULL::bpchar                      AS isbillto,
	NULL::character varying           AS isdn,
	NULL::bpchar                      AS ispayfrom,
	NULL::bpchar                      AS isremitto,
	NULL::bpchar                      AS isshipto,
	NULL::character varying           AS c_bpartner_location_name,
	NULL::character varying           AS c_bpartner_location_phone,
	NULL::character varying           AS c_bpartner_location_phone2,
	NULL::timestamp WITHOUT TIME ZONE AS c_bpartner_location_updated,
	NULL::numeric                     AS c_bpartner_location_updatedby,
	NULL::numeric                     AS c_tax_ad_org_id,
	NULL::numeric                     AS ad_rule_id,
	NULL::numeric                     AS c_country_id,
	NULL::numeric                     AS c_region_id,
	NULL::numeric                     AS c_tax_c_taxcategory_id,
	NULL::character varying           AS c_tax_description,
	NULL::bpchar                      AS c_tax_isactive,
	NULL::bpchar                      AS c_tax_isdefault,
	NULL::bpchar                      AS isdocumentlevel,
	NULL::bpchar                      AS issalestax,
	NULL::bpchar                      AS c_tax_issummary,
	NULL::bpchar                      AS c_tax_istaxexempt,
	NULL::character varying           AS c_tax_name,
	NULL::numeric                     AS parent_tax_id,
	NULL::numeric                     AS rate,
	NULL::bpchar                      AS requirestaxcertificate,
	NULL::bpchar                      AS sopotype,
	NULL::numeric                     AS to_country_id,
	NULL::numeric                     AS c_tax_to_region_id,
	NULL::timestamp WITHOUT TIME ZONE AS validfrom
FROM
	c_ordertax ot
		JOIN c_tax t
		ON ot.c_tax_id = t.c_tax_id;

CREATE OR REPLACE VIEW m_inout_candidate_v
		(ad_client_id, ad_org_id, created, updated, isactive, c_bpartner_id, c_order_id, documentno, dateordered,
		 c_doctype_id, poreference, description, salesrep_id, m_warehouse_id, m_inout_id, totallines, docsource,
		 m_inout_candidate_v_id, deliveryrule)
AS
SELECT
	o.ad_client_id,
	o.ad_org_id,
	o.created,
	o.updated,
	o.isactive,
	o.c_bpartner_id,
	o.c_order_id,
	o.documentno,
	o.dateordered,
	o.c_doctype_id,
	o.poreference,
	o.description,
	o.salesrep_id,
	l.m_warehouse_id,
	NULL::numeric                                        AS m_inout_id,
	SUM((l.qtyordered - l.qtydelivered) * l.priceactual) AS totallines,
	'O'::text                                            AS docsource,
	o.c_order_id                                         AS m_inout_candidate_v_id,
	o.deliveryrule
FROM
	c_order o
		JOIN c_orderline l
		ON o.c_order_id = l.c_order_id
WHERE
	o.docstatus = 'CO'::bpchar
	AND o.isdelivered = 'N'::bpchar
	AND (o.c_doctype_id IN (
		SELECT
			c_doctype.c_doctype_id
		FROM
			c_doctype
		WHERE
			c_doctype.docbasetype = 'SOO'::bpchar
			AND (c_doctype.docsubtypeso <> ALL (ARRAY ['ON'::bpchar, 'OB'::bpchar, 'WR'::bpchar]))
	))
	AND o.deliveryrule <> 'M'::bpchar
	AND (l.m_product_id IS NULL OR (EXISTS (
		SELECT
			1
		FROM
			m_product p
		WHERE
			l.m_product_id = p.m_product_id
			AND p.isexcludeautodelivery = 'N'::bpchar
	)))
	AND l.qtyordered <> l.qtydelivered
	AND (l.m_product_id IS NOT NULL OR l.c_charge_id IS NOT NULL)
	AND NOT (EXISTS (
		SELECT
			1
		FROM
			m_inoutline iol
				JOIN m_inout io
				ON iol.m_inout_id = io.m_inout_id
		WHERE
			iol.c_orderline_id = l.c_orderline_id
			AND (io.docstatus = ANY (ARRAY ['DR'::bpchar, 'IN'::bpchar, 'IP'::bpchar, 'WC'::bpchar]))
	))
GROUP BY
	o.ad_client_id, o.ad_org_id, o.c_bpartner_id, o.c_order_id, o.documentno, o.dateordered, o.c_doctype_id,
	o.poreference, o.description, o.salesrep_id, l.m_warehouse_id, o.created, o.updated, o.isactive, o.deliveryrule
UNION ALL
SELECT
	rma.ad_client_id,
	rma.ad_org_id,
	rma.created,
	rma.updated,
	rma.isactive,
	rma.c_bpartner_id,
	rma.c_order_id,
	rma.documentno,
	rma.created             AS dateordered,
	rma.c_doctype_id,
	NULL::character varying AS poreference,
	NULL::character varying AS description,
	NULL::numeric           AS salesrep_id,
	io.m_warehouse_id,
	rma.inout_id            AS m_inout_id,
	rma.amt                 AS totallines,
	'R'::text               AS docsource,
	rma.m_rma_id            AS m_inout_candidate_v_id,
	NULL::bpchar            AS deliveryrule
FROM
	m_rma rma
		JOIN ad_org org
		ON rma.ad_org_id = org.ad_org_id
		JOIN c_doctype dt
		ON rma.c_doctype_id = dt.c_doctype_id
		JOIN c_bpartner bp
		ON rma.c_bpartner_id = bp.c_bpartner_id
		JOIN m_inout io
		ON rma.inout_id = io.m_inout_id
WHERE
	rma.docstatus = 'CO'::bpchar
	AND dt.docbasetype = 'POO'::bpchar
	AND (EXISTS (
		SELECT
			1
		FROM
			m_rma r
				JOIN m_rmaline rl
				ON r.m_rma_id = rl.m_rma_id
		WHERE
			r.m_rma_id = rma.m_rma_id
			AND rl.isactive = 'Y'::bpchar
			AND rl.m_inoutline_id > 0::numeric
			AND rl.qtydelivered < rl.qty
	))
	AND NOT (EXISTS (
		SELECT
			1
		FROM
			m_inout oio
		WHERE
			oio.m_rma_id = rma.m_rma_id
			AND (oio.docstatus = ANY (ARRAY ['IP'::bpchar, 'CO'::bpchar, 'CL'::bpchar]))
	))
	AND NOT (EXISTS (
		SELECT
			1
		FROM
			m_inout oio
				JOIN m_inoutline il
				ON il.m_inout_id = oio.m_inout_id
				JOIN m_rmaline rl
				ON rl.m_rmaline_id = il.m_rmaline_id
		WHERE
			rl.m_rma_id = rma.m_rma_id
			AND (oio.docstatus = ANY (ARRAY ['IP'::bpchar, 'CO'::bpchar, 'CL'::bpchar]))
	));

CREATE OR REPLACE FUNCTION acctbalance(p_account_id numeric, p_amtdr numeric, p_amtcr numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_balance     NUMERIC;
	v_AccountType C_ElementValue.AccountType%TYPE;
	v_AccountSign C_ElementValue.AccountSign%TYPE;

BEGIN
	v_balance := p_AmtDr - p_AmtCr;
	--
	IF (p_Account_ID > 0) THEN
		SELECT
			AccountType,
			AccountSign
		INTO v_AccountType, v_AccountSign
		FROM
			C_ElementValue
		WHERE
			C_ElementValue_ID = p_Account_ID;
		--   DBMS_OUTPUT.PUT_LINE('Type=' || v_AccountType || ' - Sign=' || v_AccountSign);
		--  Natural Account Sign
		IF (v_AccountSign = 'N') THEN
			IF (v_AccountType IN ('A', 'E')) THEN
				v_AccountSign := 'D';
			ELSE
				v_AccountSign := 'C';
			END IF;
			--  DBMS_OUTPUT.PUT_LINE('Type=' || v_AccountType || ' - Sign=' || v_AccountSign);
		END IF;
		--  Debit Balance
		IF (v_AccountSign = 'C') THEN
			v_balance := p_AmtCr - p_AmtDr;
		END IF;
	END IF;
	--
	RETURN v_balance;
EXCEPTION
	WHEN OTHERS THEN
		-- In case Acct not found
		RETURN p_AmtDr - p_AmtCr;

END;

$$;

CREATE OR REPLACE FUNCTION currencyconvertinvoice(p_c_invoice_id numeric, p_currency_to_id numeric, p_amt numeric DEFAULT NULL::numeric, p_conversiondate timestamp with time zone DEFAULT NULL::timestamp with time zone) RETURNS numeric
	LANGUAGE plpgsql
AS
$$

DECLARE
	v_GrandTotal NUMERIC;
	v_ConversionType_ID NUMERIC;
	v_Client_ID NUMERIC;
	v_Org_ID NUMERIC;
	v_Currency_ID NUMERIC;
	v_CurrencyRate NUMERIC;
	v_DateAcct timestamp with time zone;
	v_BaseCurrency_ID NUMERIC;
	v_IsOverrideCurrencyRate character(1);
BEGIN
	SELECT AD_Client_ID, AD_Org_ID, DateAcct, C_Currency_ID, C_ConversionType_ID, CurrencyRate, GrandTotal, IsOverrideCurrencyRate
	INTO v_Client_ID, v_Org_ID, v_DateAcct, v_Currency_ID, v_ConversionType_ID, v_CurrencyRate, v_GrandTotal, v_IsOverrideCurrencyRate
	FROM C_Invoice
	WHERE C_Invoice_ID=p_C_Invoice_ID;

	SELECT sc.C_Currency_ID
	INTO v_BaseCurrency_ID
	FROM AD_ClientInfo ci
	JOIN C_AcctSchema sc ON ci.C_AcctSchema1_ID=sc.C_AcctSchema_ID
	WHERE ci.AD_Client_ID=v_Client_ID;

	IF v_BaseCurrency_ID=p_Currency_To_id AND Coalesce(v_CurrencyRate,0) > 0 AND v_Currency_ID != p_Currency_To_id AND v_IsOverrideCurrencyRate='Y' THEN
		RETURN currencyRound(Coalesce(p_Amt,v_GrandTotal)*v_CurrencyRate, p_Currency_To_id, null);
	END IF;

	RETURN currencyConvert(Coalesce(p_Amt,v_GrandTotal), v_Currency_ID, p_Currency_To_id, Coalesce(p_conversionDate,v_DateAcct), v_ConversionType_ID, v_Client_ID, v_Org_ID);
END;

$$;

CREATE OR REPLACE FUNCTION isnumeric(text) RETURNS boolean
	IMMUTABLE
	STRICT
	LANGUAGE plpgsql
AS
$$
DECLARE x NUMERIC;
BEGIN
    x = $1::NUMERIC;
    RETURN TRUE;
EXCEPTION WHEN others THEN
    RETURN FALSE;
END;
$$;

-- Remove some stuff from the seed DB
ALTER TABLE m_product
	DROP COLUMN IF EXISTS eve_bpartners;
ALTER TABLE m_product
	DROP COLUMN IF EXISTS bandahealth_bpartners;
ALTER TABLE m_product
	DROP COLUMN IF EXISTS bh_hasacceptedtermsofuse;

-- Add stuff to seed DB from PROD DB
ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS ad_user_bh_hasacceptedtermsofuse_check;
ALTER TABLE ad_user
	ADD CONSTRAINT ad_user_bh_hasacceptedtermsofuse_check
		CHECK (bh_hasacceptedtermsofuse = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar]));

ALTER TABLE bh_i_product_quantity
	DROP CONSTRAINT IF EXISTS bh_i_product_quantity_i_isimported_check;
ALTER TABLE bh_i_product_quantity
	ADD CONSTRAINT bh_i_product_quantity_i_isimported_check
		CHECK (i_isimported = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar]));

create or replace view c_order_header_v(ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ad_language, c_order_id, issotrx, documentno, docstatus, c_doctype_id, c_bpartner_id, bpvalue, bptaxid, naics, duns, org_location_id, taxid, m_warehouse_id, warehouse_location_id, documenttype, documenttypenote, salesrep_id, salesrep_name, dateordered, datepromised, bpgreeting, name, name2, bpcontactgreeting, title, phone, contactname, c_location_id, postal, referenceno, bill_bpartner_id, bill_location_id, bill_user_id, bill_bpvalue, bill_bptaxid, bill_name, bill_name2, bill_title, bill_phone, bill_contactname, bill_c_location_id, description, poreference, c_currency_id, paymentterm, paymenttermnote, c_charge_id, chargeamt, totallines, grandtotal, amtinwords, m_pricelist_id, istaxincluded, volume, weight, c_campaign_id, c_project_id, c_activity_id, m_shipper_id, deliveryrule, deliveryviarule, priorityrule, invoicerule, logo_id, ad_orgtrx_id, ad_user_id, amountrefunded, amounttendered, c_bpartner_location_id, c_cashline_id, c_cashplanline_id, c_conversiontype_id, c_doctypetarget_id, copyfrom, c_payment_id, c_paymentterm_id, c_pos_id, dateacct, dateprinted, docaction, dropship_bpartner_id, dropship_location_id, dropship_user_id, freightamt, freightcostrule, isapproved, iscreditapproved, isdelivered, isdiscountprinted, isdropship, isinvoiced, ispayschedulevalid, isprinted, isselected, isselfservice, istransferred, link_order_id, m_freightcategory_id, ordertype, pay_bpartner_id, pay_location_id, paymentrule, posted, processed, processedon, promotioncode, ref_order_id, sendemail, user1_id, user2_id, m_warehouse_ad_org_id, m_warehouse_description, m_warehouse_isactive, isdisallownegativeinv, isintransit, m_warehousesource_id, m_warehouse_name, replenishmentclass, separator, m_warehouse_value, c_paymentterm_ad_org_id, afterdelivery, c_paymentterm_description, discount, discount2, discountdays, discountdays2, fixmonthcutoff, fixmonthday, fixmonthoffset, gracedays, c_paymentterm_isactive, isdefault, isduefixed, isnextbusinessday, isvalid, netday, netdays, paymenttermusage, m_paymentterm_value, bp_acqusitioncost, bp_actuallifetimevalue, bp_ad_language, bp_ad_orgbp_id, bp_ad_org_id, bp_bpartner_parent_id, bp_c_bp_group_id, bp_c_dunning_id, bp_c_greeting_id, bp_c_invoiceschedule_id, bp_c_paymentterm_id, bp_created, bp_createdby, bp_c_taxgroup_id, bp_deliveryrule, bp_deliveryviarule, bp_description, bp_dunninggrace, bp_firstsale, bp_flatdiscount, bp_freightcostrule, bp_invoicerule, bp_isactive, bp_iscustomer, bp_isdiscountprinted, bp_isemployee, bp_ismanufacturer, bp_isonetime, bp_ispotaxexempt, bp_isprospect, bp_issalesrep, bp_issummary, bp_istaxexempt, bp_isvendor, bp_logo_id, bp_m_discountschema_id, bp_m_pricelist_id, bp_numberemployees, bp_paymentrule, bp_paymentrulepo, bp_po_discountschema_id, bp_po_paymentterm_id, bp_po_pricelist_id, bp_poreference, bp_potentiallifetimevalue, bp_rating, bp_salesrep_id, bp_salesvolume, bp_sendemail, bp_shareofcustomer, bp_shelflifeminpct, bp_so_creditlimit, bp_socreditstatus, bp_so_creditused, bp_so_description, bp_totalopenbalance, bp_updated, bp_updatedby, bp_url, c_greeting_ad_org_id, c_greeting_isactive, isfirstnameonly, c_greeting_name, bp_location_ad_org_id, bp_location_c_bpartner_id, bp_location_created, bp_location_createdby, bp_location_c_salesregion_id, bp_location_fax, bp_location_isactive, bp_location_isbillto, bp_location_isdn, bp_location_ispayfrom, bp_location_isremitto, bp_location_isshipto, bp_location_name, bp_location_phone, bp_location_phone2, bp_location_updated, bp_location_updatedby, address1, address2, address3, address4, c_location_ad_org_id, c_city_id, c_country_id, city, c_location_created, c_location_createdby, c_region_id, c_location_isactive, regionname, c_location_updated, c_location_updatedby, ad_user_ad_org_id, ad_user_ad_orgtrx_id, ad_user_ad_birthday, ad_user_c_bpartner_id, ad_user_c_bpartner_location_id, ad_user_c_greeting_id, ad_user_comments, ad_user_created, ad_user_createdby, ad_user_description, ad_user_email, ad_user_fax, ad_user_isactive, ad_user_lastcontact, ad_user_lastresult, ad_user_phone2, ad_user_supervisor_id, ad_user_updated, ad_user_updatedby, ad_user_value, c_user_greeting_ad_org_id, c_user_greeting_isactive, c_user_greeting_isfnameonly, c_user_greeting_name, ad_orginfo_ad_org_id, ad_orgtype_id, c_calendar_id, ad_orginfo_created, ad_orginfo_createdby, dropship_warehouse_id, ad_orginfo_duns, ad_orginfo_email, ad_orginfo_fax, ad_orginfo_isactive, ad_orginfo_m_warehouse_id, parent_org_id, ad_orginfo_phone, ad_orginfo_phone2, receiptfootermsg, supervisor_id, ad_orginfo_updated, ad_orginfo_updatedby, salesrep_ad_org_id, salesrep_ad_orgtrx_id, salesrep_ad_birthday, salesrep_c_bpartner_id, salesrep_c_bp_location_id, salesrep_c_greeting_id, salesrep_comments, salesrep_created, salesrep_createdby, salesrep_description, salesrep_email, salesrep_fax, salesrep_isactive, salesrep_lastcontact, salesrep_lastresult, salesrep_phone, salesrep_phone2, salesrep_supervisor_id, salesrep_title, salesrep_updated, salesrep_updatedby, salesrep_value, salesrep_bp_acqusitioncost, salesrep_bp_actuallifetimeval, salesrep_bp_ad_language, salesrep_bp_ad_orgbp_id, salesrep_bp_ad_org_id, salesrep_bp_bpartner_parent_id, salesrep_bp_c_bp_group_id, salesrep_bp_c_dunning_id, salesrep_bp_c_greeting_id, salesrep_bp_c_invoicesched_id, salesrep_bp_c_paymentterm_id, salesrep_bp_created, salesrep_bp_createdby, salesrep_bp_c_taxgroup_id, salesrep_bp_deliveryrule, salesrep_bp_deliveryviarule, salesrep_bp_description, salesrep_bp_dunninggrace, salesrep_bp_duns, salesrep_bp_firstsale, salesrep_bp_flatdiscount, salesrep_bp_freightcostrule, salesrep_bp_invoicerule, salesrep_bp_isactive, salesrep_bp_iscustomer, salesrep_bp_isdiscountprinted, salesrep_bp_isemployee, salesrep_bp_ismanufacturer, salesrep_bp_isonetime, salesrep_bp_ispotaxexempt, salesrep_bp_isprospect, salesrep_bp_issalesrep, salesrep_bp_issummary, salesrep_bp_istaxexempt, salesrep_bp_isvendor, salesrep_bp_logo_id, salesrep_bp_m_discountschm_id, salesrep_bp_m_pricelist_id, salesrep_bp_naics, salesrep_bp_name2, salesrep_bp_numberemployees, salesrep_bp_paymentrule, salesrep_bp_paymentrulepo, salesrep_bp_po_discountschm_id, salesrep_bp_po_paymentterm_id, salesrep_bp_po_pricelist_id, salesrep_bp_poreference, salesrep_bp_potentiallifetime, salesrep_bp_rating, salesrep_bp_referenceno, salesrep_bp_salesrep_id, salesrep_bp_salesvolume, salesrep_bp_sendemail, salesrep_bp_shareofcustomer, salesrep_bp_shelflifeminpct, salesrep_bp_so_creditlimit, salesrep_bp_socreditstatus, salesrep_bp_so_creditused, salesrep_bp_so_description, salesrep_bp_taxid, salesrep_bp_totalopenbalance, salesrep_bp_updated, salesrep_bp_updatedby, salesrep_bp_url, salesrep_bp_value, bill_bp_acqusitioncost, bill_bp_actuallifetimevalue, bill_bp_ad_language, bill_bp_ad_orgbp_id, bill_bp_ad_org_id, bill_bp_bpartner_parent_id, bill_bp_c_bp_group_id, bill_bp_c_dunning_id, bill_bp_c_greeting_id, bill_bp_c_invoiceschedule_id, bill_bp_c_paymentterm_id, bill_bp_created, bill_bp_createdby, bill_bp_c_taxgroup_id, bill_bp_deliveryrule, bill_bp_deliveryviarule, bill_bp_description, bill_bp_dunninggrace, bill_bp_duns, bill_bp_firstsale, bill_bp_flatdiscount, bill_bp_freightcostrule, bill_bp_invoicerule, bill_bp_isactive, bill_bp_iscustomer, bill_bp_isdiscountprinted, bill_bp_isemployee, bill_bp_ismanufacturer, bill_bp_isonetime, bill_bp_ispotaxexempt, bill_bp_isprospect, bill_bp_issalesrep, bill_bp_issummary, bill_bp_istaxexempt, bill_bp_isvendor, bill_bp_logo_id, bill_bp_m_discountschema_id, bill_bp_m_pricelist_id, bill_bp_naics, bill_bp_numberemployees, bill_bp_paymentrule, bill_bp_paymentrulepo, bill_bp_po_discountschema_id, bill_bp_po_paymentterm_id, bill_bp_po_pricelist_id, bill_bp_poreference, bill_bp_potentiallifetimevalue, bill_bp_rating, bill_bp_referenceno, bill_bp_salesrep_id, bill_bp_salesvolume, bill_bp_sendemail, bill_bp_shareofcustomer, bill_bp_shelflifeminpct, bill_bp_so_creditlimit, bill_bp_socreditstatus, bill_bp_so_creditused, bill_bp_so_description, bill_bp_totalopenbalance, bill_bp_updated, bill_bp_updatedby, bill_bp_url, bill_bp_location_ad_org_id, bill_bp_location_c_bpartner_id, bill_bp_location_created, bill_bp_location_createdby, bill_bp_location_c_salesreg_id, bill_bp_location_fax, bill_bp_location_isactive, bill_bp_location_isbillto, bill_bp_location_isdn, bill_bp_location_ispayfrom, bill_bp_location_isremitto, bill_bp_location_isshipto, bill_bp_location_name, bill_bp_location_phone, bill_bp_location_phone2, bill_bp_location_updated, bill_bp_location_updatedby, bill_user_ad_org_id, bill_user_ad_orgtrx_id, bill_user_ad_birthday, bill_user_c_bpartner_id, bill_user_c_bp_location_id, bill_user_c_greeting_id, bill_user_comments, bill_user_created, bill_user_createdby, bill_user_description, bill_user_email, bill_user_fax, bill_user_isactive, bill_user_lastcontact, bill_user_lastresult, bill_user_phone2, bill_user_supervisor_id, bill_user_updated, bill_user_updatedby, bill_user_value, cursymbol, cur_description) as
	SELECT
	o.ad_client_id,
	o.ad_org_id,
	o.isactive,
	o.created,
	o.createdby,
	o.updated,
	o.updatedby,
	'en_US'::character varying(6)                                                                          AS ad_language,
	o.c_order_id,
	o.issotrx,
	o.documentno,
	o.docstatus,
	o.c_doctype_id,
	o.c_bpartner_id,
	bp.value                                                                                               AS bpvalue,
	bp.taxid                                                                                               AS bptaxid,
	bp.naics,
	bp.duns,
	oi.c_location_id                                                                                       AS org_location_id,
	oi.taxid,
	o.m_warehouse_id,
	wh.c_location_id                                                                                       AS warehouse_location_id,
	dt.printname                                                                                           AS documenttype,
	dt.documentnote                                                                                        AS documenttypenote,
	o.salesrep_id,
	COALESCE(ubp.name, u.name)                                                                             AS salesrep_name,
	o.dateordered,
	o.datepromised,
	bpg.greeting                                                                                           AS bpgreeting,
	bp.name,
	bp.name2,
	bpcg.greeting                                                                                          AS bpcontactgreeting,
	bpc.title,
	bpc.phone,
	NULLIF(bpc.name::text, bp.name::text)                                                                  AS contactname,
	bpl.c_location_id,
	COALESCE(l.postal, ''::character varying)::text || COALESCE(l.postal_add, ''::character varying)::text AS postal,
	bp.referenceno,
	o.bill_bpartner_id,
	o.bill_location_id,
	o.bill_user_id,
	bbp.value                                                                                              AS bill_bpvalue,
	bbp.taxid                                                                                              AS bill_bptaxid,
	bbp.name                                                                                               AS bill_name,
	bbp.name2                                                                                              AS bill_name2,
	bbpc.title                                                                                             AS bill_title,
	bbpc.phone                                                                                             AS bill_phone,
	NULLIF(bbpc.name::text, bbp.name::text)                                                                AS bill_contactname,
	bbpl.c_location_id                                                                                     AS bill_c_location_id,
	o.description,
	o.poreference,
	o.c_currency_id,
	pt.name                                                                                                AS paymentterm,
	pt.documentnote                                                                                        AS paymenttermnote,
	o.c_charge_id,
	o.chargeamt,
	o.totallines,
	o.grandtotal,
	o.grandtotal                                                                                           AS amtinwords,
	o.m_pricelist_id,
	o.istaxincluded,
	o.volume,
	o.weight,
	o.c_campaign_id,
	o.c_project_id,
	o.c_activity_id,
	o.m_shipper_id,
	o.deliveryrule,
	o.deliveryviarule,
	o.priorityrule,
	o.invoicerule,
	COALESCE(oi.logo_id, ci.logo_id)                                                                       AS logo_id,
	o.ad_orgtrx_id,
	o.ad_user_id,
	o.amountrefunded,
	o.amounttendered,
	o.c_bpartner_location_id,
	o.c_cashline_id,
	o.c_cashplanline_id,
	o.c_conversiontype_id,
	o.c_doctypetarget_id,
	o.copyfrom,
	o.c_payment_id,
	o.c_paymentterm_id,
	o.c_pos_id,
	o.dateacct,
	o.dateprinted,
	o.docaction,
	o.dropship_bpartner_id,
	o.dropship_location_id,
	o.dropship_user_id,
	o.freightamt,
	o.freightcostrule,
	o.isapproved,
	o.iscreditapproved,
	o.isdelivered,
	o.isdiscountprinted,
	o.isdropship,
	o.isinvoiced,
	o.ispayschedulevalid,
	o.isprinted,
	o.isselected,
	o.isselfservice,
	o.istransferred,
	o.link_order_id,
	o.m_freightcategory_id,
	o.ordertype,
	o.pay_bpartner_id,
	o.pay_location_id,
	o.paymentrule,
	o.posted,
	o.processed,
	o.processedon,
	o.promotioncode,
	o.ref_order_id,
	o.sendemail,
	o.user1_id,
	o.user2_id,
	wh.ad_org_id                                                                                           AS m_warehouse_ad_org_id,
	wh.description                                                                                         AS m_warehouse_description,
	wh.isactive                                                                                            AS m_warehouse_isactive,
	wh.isdisallownegativeinv,
	wh.isintransit,
	wh.m_warehousesource_id,
	wh.name                                                                                                AS m_warehouse_name,
	wh.replenishmentclass,
	wh.separator,
	wh.value                                                                                               AS m_warehouse_value,
	pt.ad_org_id                                                                                           AS c_paymentterm_ad_org_id,
	pt.afterdelivery,
	pt.description                                                                                         AS c_paymentterm_description,
	pt.discount,
	pt.discount2,
	pt.discountdays,
	pt.discountdays2,
	pt.fixmonthcutoff,
	pt.fixmonthday,
	pt.fixmonthoffset,
	pt.gracedays,
	pt.isactive                                                                                            AS c_paymentterm_isactive,
	pt.isdefault,
	pt.isduefixed,
	pt.isnextbusinessday,
	pt.isvalid,
	pt.netday,
	pt.netdays,
	pt.paymenttermusage,
	pt.value                                                                                               AS m_paymentterm_value,
	bp.acqusitioncost                                                                                      AS bp_acqusitioncost,
	bp.actuallifetimevalue                                                                                 AS bp_actuallifetimevalue,
	bp.ad_language                                                                                         AS bp_ad_language,
	bp.ad_orgbp_id                                                                                         AS bp_ad_orgbp_id,
	bp.ad_org_id                                                                                           AS bp_ad_org_id,
	bp.bpartner_parent_id                                                                                  AS bp_bpartner_parent_id,
	bp.c_bp_group_id                                                                                       AS bp_c_bp_group_id,
	bp.c_dunning_id                                                                                        AS bp_c_dunning_id,
	bp.c_greeting_id                                                                                       AS bp_c_greeting_id,
	bp.c_invoiceschedule_id                                                                                AS bp_c_invoiceschedule_id,
	bp.c_paymentterm_id                                                                                    AS bp_c_paymentterm_id,
	bp.created                                                                                             AS bp_created,
	bp.createdby                                                                                           AS bp_createdby,
	bp.c_taxgroup_id                                                                                       AS bp_c_taxgroup_id,
	bp.deliveryrule                                                                                        AS bp_deliveryrule,
	bp.deliveryviarule                                                                                     AS bp_deliveryviarule,
	bp.description                                                                                         AS bp_description,
	bp.dunninggrace                                                                                        AS bp_dunninggrace,
	bp.firstsale                                                                                           AS bp_firstsale,
	bp.flatdiscount                                                                                        AS bp_flatdiscount,
	bp.freightcostrule                                                                                     AS bp_freightcostrule,
	bp.invoicerule                                                                                         AS bp_invoicerule,
	bp.isactive                                                                                            AS bp_isactive,
	bp.iscustomer                                                                                          AS bp_iscustomer,
	bp.isdiscountprinted                                                                                   AS bp_isdiscountprinted,
	bp.isemployee                                                                                          AS bp_isemployee,
	bp.ismanufacturer                                                                                      AS bp_ismanufacturer,
	bp.isonetime                                                                                           AS bp_isonetime,
	bp.ispotaxexempt                                                                                       AS bp_ispotaxexempt,
	bp.isprospect                                                                                          AS bp_isprospect,
	bp.issalesrep                                                                                          AS bp_issalesrep,
	bp.issummary                                                                                           AS bp_issummary,
	bp.istaxexempt                                                                                         AS bp_istaxexempt,
	bp.isvendor                                                                                            AS bp_isvendor,
	bp.logo_id                                                                                             AS bp_logo_id,
	bp.m_discountschema_id                                                                                 AS bp_m_discountschema_id,
	bp.m_pricelist_id                                                                                      AS bp_m_pricelist_id,
	bp.numberemployees                                                                                     AS bp_numberemployees,
	bp.paymentrule                                                                                         AS bp_paymentrule,
	bp.paymentrulepo                                                                                       AS bp_paymentrulepo,
	bp.po_discountschema_id                                                                                AS bp_po_discountschema_id,
	bp.po_paymentterm_id                                                                                   AS bp_po_paymentterm_id,
	bp.po_pricelist_id                                                                                     AS bp_po_pricelist_id,
	bp.poreference                                                                                         AS bp_poreference,
	bp.potentiallifetimevalue                                                                              AS bp_potentiallifetimevalue,
	bp.rating                                                                                              AS bp_rating,
	bp.salesrep_id                                                                                         AS bp_salesrep_id,
	bp.salesvolume                                                                                         AS bp_salesvolume,
	bp.sendemail                                                                                           AS bp_sendemail,
	bp.shareofcustomer                                                                                     AS bp_shareofcustomer,
	bp.shelflifeminpct                                                                                     AS bp_shelflifeminpct,
	bp.so_creditlimit                                                                                      AS bp_so_creditlimit,
	bp.socreditstatus                                                                                      AS bp_socreditstatus,
	bp.so_creditused                                                                                       AS bp_so_creditused,
	bp.so_description                                                                                      AS bp_so_description,
	bp.totalopenbalance                                                                                    AS bp_totalopenbalance,
	bp.updated                                                                                             AS bp_updated,
	bp.updatedby                                                                                           AS bp_updatedby,
	bp.url                                                                                                 AS bp_url,
	bpg.ad_org_id                                                                                          AS c_greeting_ad_org_id,
	bpg.isactive                                                                                           AS c_greeting_isactive,
	bpg.isfirstnameonly,
	bpg.name                                                                                               AS c_greeting_name,
	bpl.ad_org_id                                                                                          AS bp_location_ad_org_id,
	bpl.c_bpartner_id                                                                                      AS bp_location_c_bpartner_id,
	bpl.created                                                                                            AS bp_location_created,
	bpl.createdby                                                                                          AS bp_location_createdby,
	bpl.c_salesregion_id                                                                                   AS bp_location_c_salesregion_id,
	bpl.fax                                                                                                AS bp_location_fax,
	bpl.isactive                                                                                           AS bp_location_isactive,
	bpl.isbillto                                                                                           AS bp_location_isbillto,
	bpl.isdn                                                                                               AS bp_location_isdn,
	bpl.ispayfrom                                                                                          AS bp_location_ispayfrom,
	bpl.isremitto                                                                                          AS bp_location_isremitto,
	bpl.isshipto                                                                                           AS bp_location_isshipto,
	bpl.name                                                                                               AS bp_location_name,
	bpl.phone                                                                                              AS bp_location_phone,
	bpl.phone2                                                                                             AS bp_location_phone2,
	bpl.updated                                                                                            AS bp_location_updated,
	bpl.updatedby                                                                                          AS bp_location_updatedby,
	l.address1,
	l.address2,
	l.address3,
	l.address4,
	l.ad_org_id                                                                                            AS c_location_ad_org_id,
	l.c_city_id,
	l.c_country_id,
	l.city,
	l.created                                                                                              AS c_location_created,
	l.createdby                                                                                            AS c_location_createdby,
	l.c_region_id,
	l.isactive                                                                                             AS c_location_isactive,
	l.regionname,
	l.updated                                                                                              AS c_location_updated,
	l.updatedby                                                                                            AS c_location_updatedby,
	bpc.ad_org_id                                                                                          AS ad_user_ad_org_id,
	bpc.ad_orgtrx_id                                                                                       AS ad_user_ad_orgtrx_id,
	bpc.birthday                                                                                           AS ad_user_ad_birthday,
	bpc.c_bpartner_id                                                                                      AS ad_user_c_bpartner_id,
	bpc.c_bpartner_location_id                                                                             AS ad_user_c_bpartner_location_id,
	bpc.c_greeting_id                                                                                      AS ad_user_c_greeting_id,
	bpc.comments                                                                                           AS ad_user_comments,
	bpc.created                                                                                            AS ad_user_created,
	bpc.createdby                                                                                          AS ad_user_createdby,
	bpc.description                                                                                        AS ad_user_description,
	bpc.email                                                                                              AS ad_user_email,
	bpc.fax                                                                                                AS ad_user_fax,
	bpc.isactive                                                                                           AS ad_user_isactive,
	bpc.lastcontact                                                                                        AS ad_user_lastcontact,
	bpc.lastresult                                                                                         AS ad_user_lastresult,
	bpc.phone2                                                                                             AS ad_user_phone2,
	bpc.supervisor_id                                                                                      AS ad_user_supervisor_id,
	bpc.updated                                                                                            AS ad_user_updated,
	bpc.updatedby                                                                                          AS ad_user_updatedby,
	bpc.value                                                                                              AS ad_user_value,
	bpcg.ad_org_id                                                                                         AS c_user_greeting_ad_org_id,
	bpcg.isactive                                                                                          AS c_user_greeting_isactive,
	bpcg.isfirstnameonly                                                                                   AS c_user_greeting_isfnameonly,
	bpcg.name                                                                                              AS c_user_greeting_name,
	oi.ad_org_id                                                                                           AS ad_orginfo_ad_org_id,
	oi.ad_orgtype_id,
	oi.c_calendar_id,
	oi.created                                                                                             AS ad_orginfo_created,
	oi.createdby                                                                                           AS ad_orginfo_createdby,
	oi.dropship_warehouse_id,
	oi.duns                                                                                                AS ad_orginfo_duns,
	oi.email                                                                                               AS ad_orginfo_email,
	oi.fax                                                                                                 AS ad_orginfo_fax,
	oi.isactive                                                                                            AS ad_orginfo_isactive,
	oi.m_warehouse_id                                                                                      AS ad_orginfo_m_warehouse_id,
	oi.parent_org_id,
	oi.phone                                                                                               AS ad_orginfo_phone,
	oi.phone2                                                                                              AS ad_orginfo_phone2,
	oi.receiptfootermsg,
	oi.supervisor_id,
	oi.updated                                                                                             AS ad_orginfo_updated,
	oi.updatedby                                                                                           AS ad_orginfo_updatedby,
	u.ad_org_id                                                                                            AS salesrep_ad_org_id,
	u.ad_orgtrx_id                                                                                         AS salesrep_ad_orgtrx_id,
	u.birthday                                                                                             AS salesrep_ad_birthday,
	u.c_bpartner_id                                                                                        AS salesrep_c_bpartner_id,
	u.c_bpartner_location_id                                                                               AS salesrep_c_bp_location_id,
	u.c_greeting_id                                                                                        AS salesrep_c_greeting_id,
	u.comments                                                                                             AS salesrep_comments,
	u.created                                                                                              AS salesrep_created,
	u.createdby                                                                                            AS salesrep_createdby,
	u.description                                                                                          AS salesrep_description,
	u.email                                                                                                AS salesrep_email,
	u.fax                                                                                                  AS salesrep_fax,
	u.isactive                                                                                             AS salesrep_isactive,
	u.lastcontact                                                                                          AS salesrep_lastcontact,
	u.lastresult                                                                                           AS salesrep_lastresult,
	u.phone                                                                                                AS salesrep_phone,
	u.phone2                                                                                               AS salesrep_phone2,
	u.supervisor_id                                                                                        AS salesrep_supervisor_id,
	u.title                                                                                                AS salesrep_title,
	u.updated                                                                                              AS salesrep_updated,
	u.updatedby                                                                                            AS salesrep_updatedby,
	u.value                                                                                                AS salesrep_value,
	ubp.acqusitioncost                                                                                     AS salesrep_bp_acqusitioncost,
	ubp.actuallifetimevalue                                                                                AS salesrep_bp_actuallifetimeval,
	ubp.ad_language                                                                                        AS salesrep_bp_ad_language,
	ubp.ad_orgbp_id                                                                                        AS salesrep_bp_ad_orgbp_id,
	ubp.ad_org_id                                                                                          AS salesrep_bp_ad_org_id,
	ubp.bpartner_parent_id                                                                                 AS salesrep_bp_bpartner_parent_id,
	ubp.c_bp_group_id                                                                                      AS salesrep_bp_c_bp_group_id,
	ubp.c_dunning_id                                                                                       AS salesrep_bp_c_dunning_id,
	ubp.c_greeting_id                                                                                      AS salesrep_bp_c_greeting_id,
	ubp.c_invoiceschedule_id                                                                               AS salesrep_bp_c_invoicesched_id,
	ubp.c_paymentterm_id                                                                                   AS salesrep_bp_c_paymentterm_id,
	ubp.created                                                                                            AS salesrep_bp_created,
	ubp.createdby                                                                                          AS salesrep_bp_createdby,
	ubp.c_taxgroup_id                                                                                      AS salesrep_bp_c_taxgroup_id,
	ubp.deliveryrule                                                                                       AS salesrep_bp_deliveryrule,
	ubp.deliveryviarule                                                                                    AS salesrep_bp_deliveryviarule,
	ubp.description                                                                                        AS salesrep_bp_description,
	ubp.dunninggrace                                                                                       AS salesrep_bp_dunninggrace,
	ubp.duns                                                                                               AS salesrep_bp_duns,
	ubp.firstsale                                                                                          AS salesrep_bp_firstsale,
	ubp.flatdiscount                                                                                       AS salesrep_bp_flatdiscount,
	ubp.freightcostrule                                                                                    AS salesrep_bp_freightcostrule,
	ubp.invoicerule                                                                                        AS salesrep_bp_invoicerule,
	ubp.isactive                                                                                           AS salesrep_bp_isactive,
	ubp.iscustomer                                                                                         AS salesrep_bp_iscustomer,
	ubp.isdiscountprinted                                                                                  AS salesrep_bp_isdiscountprinted,
	ubp.isemployee                                                                                         AS salesrep_bp_isemployee,
	ubp.ismanufacturer                                                                                     AS salesrep_bp_ismanufacturer,
	ubp.isonetime                                                                                          AS salesrep_bp_isonetime,
	ubp.ispotaxexempt                                                                                      AS salesrep_bp_ispotaxexempt,
	ubp.isprospect                                                                                         AS salesrep_bp_isprospect,
	ubp.issalesrep                                                                                         AS salesrep_bp_issalesrep,
	ubp.issummary                                                                                          AS salesrep_bp_issummary,
	ubp.istaxexempt                                                                                        AS salesrep_bp_istaxexempt,
	ubp.isvendor                                                                                           AS salesrep_bp_isvendor,
	ubp.logo_id                                                                                            AS salesrep_bp_logo_id,
	ubp.m_discountschema_id                                                                                AS salesrep_bp_m_discountschm_id,
	ubp.m_pricelist_id                                                                                     AS salesrep_bp_m_pricelist_id,
	ubp.naics                                                                                              AS salesrep_bp_naics,
	ubp.name2                                                                                              AS salesrep_bp_name2,
	ubp.numberemployees                                                                                    AS salesrep_bp_numberemployees,
	ubp.paymentrule                                                                                        AS salesrep_bp_paymentrule,
	ubp.paymentrulepo                                                                                      AS salesrep_bp_paymentrulepo,
	ubp.po_discountschema_id                                                                               AS salesrep_bp_po_discountschm_id,
	ubp.po_paymentterm_id                                                                                  AS salesrep_bp_po_paymentterm_id,
	ubp.po_pricelist_id                                                                                    AS salesrep_bp_po_pricelist_id,
	ubp.poreference                                                                                        AS salesrep_bp_poreference,
	ubp.potentiallifetimevalue                                                                             AS salesrep_bp_potentiallifetime,
	ubp.rating                                                                                             AS salesrep_bp_rating,
	ubp.referenceno                                                                                        AS salesrep_bp_referenceno,
	ubp.salesrep_id                                                                                        AS salesrep_bp_salesrep_id,
	ubp.salesvolume                                                                                        AS salesrep_bp_salesvolume,
	ubp.sendemail                                                                                          AS salesrep_bp_sendemail,
	ubp.shareofcustomer                                                                                    AS salesrep_bp_shareofcustomer,
	ubp.shelflifeminpct                                                                                    AS salesrep_bp_shelflifeminpct,
	ubp.so_creditlimit                                                                                     AS salesrep_bp_so_creditlimit,
	ubp.socreditstatus                                                                                     AS salesrep_bp_socreditstatus,
	ubp.so_creditused                                                                                      AS salesrep_bp_so_creditused,
	ubp.so_description                                                                                     AS salesrep_bp_so_description,
	ubp.taxid                                                                                              AS salesrep_bp_taxid,
	ubp.totalopenbalance                                                                                   AS salesrep_bp_totalopenbalance,
	ubp.updated                                                                                            AS salesrep_bp_updated,
	ubp.updatedby                                                                                          AS salesrep_bp_updatedby,
	ubp.url                                                                                                AS salesrep_bp_url,
	ubp.value                                                                                              AS salesrep_bp_value,
	bbp.acqusitioncost                                                                                     AS bill_bp_acqusitioncost,
	bbp.actuallifetimevalue                                                                                AS bill_bp_actuallifetimevalue,
	bbp.ad_language                                                                                        AS bill_bp_ad_language,
	bbp.ad_orgbp_id                                                                                        AS bill_bp_ad_orgbp_id,
	bbp.ad_org_id                                                                                          AS bill_bp_ad_org_id,
	bbp.bpartner_parent_id                                                                                 AS bill_bp_bpartner_parent_id,
	bbp.c_bp_group_id                                                                                      AS bill_bp_c_bp_group_id,
	bbp.c_dunning_id                                                                                       AS bill_bp_c_dunning_id,
	bbp.c_greeting_id                                                                                      AS bill_bp_c_greeting_id,
	bbp.c_invoiceschedule_id                                                                               AS bill_bp_c_invoiceschedule_id,
	bbp.c_paymentterm_id                                                                                   AS bill_bp_c_paymentterm_id,
	bbp.created                                                                                            AS bill_bp_created,
	bbp.createdby                                                                                          AS bill_bp_createdby,
	bbp.c_taxgroup_id                                                                                      AS bill_bp_c_taxgroup_id,
	bbp.deliveryrule                                                                                       AS bill_bp_deliveryrule,
	bbp.deliveryviarule                                                                                    AS bill_bp_deliveryviarule,
	bbp.description                                                                                        AS bill_bp_description,
	bbp.dunninggrace                                                                                       AS bill_bp_dunninggrace,
	bbp.duns                                                                                               AS bill_bp_duns,
	bbp.firstsale                                                                                          AS bill_bp_firstsale,
	bbp.flatdiscount                                                                                       AS bill_bp_flatdiscount,
	bbp.freightcostrule                                                                                    AS bill_bp_freightcostrule,
	bbp.invoicerule                                                                                        AS bill_bp_invoicerule,
	bbp.isactive                                                                                           AS bill_bp_isactive,
	bbp.iscustomer                                                                                         AS bill_bp_iscustomer,
	bbp.isdiscountprinted                                                                                  AS bill_bp_isdiscountprinted,
	bbp.isemployee                                                                                         AS bill_bp_isemployee,
	bbp.ismanufacturer                                                                                     AS bill_bp_ismanufacturer,
	bbp.isonetime                                                                                          AS bill_bp_isonetime,
	bbp.ispotaxexempt                                                                                      AS bill_bp_ispotaxexempt,
	bbp.isprospect                                                                                         AS bill_bp_isprospect,
	bbp.issalesrep                                                                                         AS bill_bp_issalesrep,
	bbp.issummary                                                                                          AS bill_bp_issummary,
	bbp.istaxexempt                                                                                        AS bill_bp_istaxexempt,
	bbp.isvendor                                                                                           AS bill_bp_isvendor,
	bbp.logo_id                                                                                            AS bill_bp_logo_id,
	bbp.m_discountschema_id                                                                                AS bill_bp_m_discountschema_id,
	bbp.m_pricelist_id                                                                                     AS bill_bp_m_pricelist_id,
	bbp.naics                                                                                              AS bill_bp_naics,
	bbp.numberemployees                                                                                    AS bill_bp_numberemployees,
	bbp.paymentrule                                                                                        AS bill_bp_paymentrule,
	bbp.paymentrulepo                                                                                      AS bill_bp_paymentrulepo,
	bbp.po_discountschema_id                                                                               AS bill_bp_po_discountschema_id,
	bbp.po_paymentterm_id                                                                                  AS bill_bp_po_paymentterm_id,
	bbp.po_pricelist_id                                                                                    AS bill_bp_po_pricelist_id,
	bbp.poreference                                                                                        AS bill_bp_poreference,
	bbp.potentiallifetimevalue                                                                             AS bill_bp_potentiallifetimevalue,
	bbp.rating                                                                                             AS bill_bp_rating,
	bbp.referenceno                                                                                        AS bill_bp_referenceno,
	bbp.salesrep_id                                                                                        AS bill_bp_salesrep_id,
	bbp.salesvolume                                                                                        AS bill_bp_salesvolume,
	bbp.sendemail                                                                                          AS bill_bp_sendemail,
	bbp.shareofcustomer                                                                                    AS bill_bp_shareofcustomer,
	bbp.shelflifeminpct                                                                                    AS bill_bp_shelflifeminpct,
	bbp.so_creditlimit                                                                                     AS bill_bp_so_creditlimit,
	bbp.socreditstatus                                                                                     AS bill_bp_socreditstatus,
	bbp.so_creditused                                                                                      AS bill_bp_so_creditused,
	bbp.so_description                                                                                     AS bill_bp_so_description,
	bbp.totalopenbalance                                                                                   AS bill_bp_totalopenbalance,
	bbp.updated                                                                                            AS bill_bp_updated,
	bbp.updatedby                                                                                          AS bill_bp_updatedby,
	bbp.url                                                                                                AS bill_bp_url,
	bbpl.ad_org_id                                                                                         AS bill_bp_location_ad_org_id,
	bbpl.c_bpartner_id                                                                                     AS bill_bp_location_c_bpartner_id,
	bbpl.created                                                                                           AS bill_bp_location_created,
	bbpl.createdby                                                                                         AS bill_bp_location_createdby,
	bbpl.c_salesregion_id                                                                                  AS bill_bp_location_c_salesreg_id,
	bbpl.fax                                                                                               AS bill_bp_location_fax,
	bbpl.isactive                                                                                          AS bill_bp_location_isactive,
	bbpl.isbillto                                                                                          AS bill_bp_location_isbillto,
	bbpl.isdn                                                                                              AS bill_bp_location_isdn,
	bbpl.ispayfrom                                                                                         AS bill_bp_location_ispayfrom,
	bbpl.isremitto                                                                                         AS bill_bp_location_isremitto,
	bbpl.isshipto                                                                                          AS bill_bp_location_isshipto,
	bbpl.name                                                                                              AS bill_bp_location_name,
	bbpl.phone                                                                                             AS bill_bp_location_phone,
	bbpl.phone2                                                                                            AS bill_bp_location_phone2,
	bbpl.updated                                                                                           AS bill_bp_location_updated,
	bbpl.updatedby                                                                                         AS bill_bp_location_updatedby,
	bbpc.ad_org_id                                                                                         AS bill_user_ad_org_id,
	bbpc.ad_orgtrx_id                                                                                      AS bill_user_ad_orgtrx_id,
	bbpc.birthday                                                                                          AS bill_user_ad_birthday,
	bbpc.c_bpartner_id                                                                                     AS bill_user_c_bpartner_id,
	bbpc.c_bpartner_location_id                                                                            AS bill_user_c_bp_location_id,
	bbpc.c_greeting_id                                                                                     AS bill_user_c_greeting_id,
	bbpc.comments                                                                                          AS bill_user_comments,
	bbpc.created                                                                                           AS bill_user_created,
	bbpc.createdby                                                                                         AS bill_user_createdby,
	bbpc.description                                                                                       AS bill_user_description,
	bbpc.email                                                                                             AS bill_user_email,
	bbpc.fax                                                                                               AS bill_user_fax,
	bbpc.isactive                                                                                          AS bill_user_isactive,
	bbpc.lastcontact                                                                                       AS bill_user_lastcontact,
	bbpc.lastresult                                                                                        AS bill_user_lastresult,
	bbpc.phone2                                                                                            AS bill_user_phone2,
	bbpc.supervisor_id                                                                                     AS bill_user_supervisor_id,
	bbpc.updated                                                                                           AS bill_user_updated,
	bbpc.updatedby                                                                                         AS bill_user_updatedby,
	bbpc.value                                                                                             AS bill_user_value,
	cur.cursymbol,
	cur.description                                                                                        AS cur_description
FROM
	c_order o
		JOIN c_doctype dt
		ON o.c_doctype_id = dt.c_doctype_id
		JOIN m_warehouse wh
		ON o.m_warehouse_id = wh.m_warehouse_id
		JOIN c_paymentterm pt
		ON o.c_paymentterm_id = pt.c_paymentterm_id
		JOIN c_bpartner bp
		ON o.c_bpartner_id = bp.c_bpartner_id
		LEFT JOIN c_greeting bpg
		ON bp.c_greeting_id = bpg.c_greeting_id
		JOIN c_bpartner_location bpl
		ON o.c_bpartner_location_id = bpl.c_bpartner_location_id
		JOIN c_location l
		ON bpl.c_location_id = l.c_location_id
		LEFT JOIN ad_user bpc
		ON o.ad_user_id = bpc.ad_user_id
		LEFT JOIN c_greeting bpcg
		ON bpc.c_greeting_id = bpcg.c_greeting_id
		JOIN ad_orginfo oi
		ON o.ad_org_id = oi.ad_org_id
		JOIN ad_clientinfo ci
		ON o.ad_client_id = ci.ad_client_id
		LEFT JOIN ad_user u
		ON o.salesrep_id = u.ad_user_id
		LEFT JOIN c_bpartner ubp
		ON u.c_bpartner_id = ubp.c_bpartner_id
		JOIN c_bpartner bbp
		ON o.bill_bpartner_id = bbp.c_bpartner_id
		JOIN c_bpartner_location bbpl
		ON o.bill_location_id = bbpl.c_bpartner_location_id
		LEFT JOIN ad_user bbpc
		ON o.bill_user_id = bbpc.ad_user_id
		LEFT JOIN c_currency cur
		ON o.c_currency_id = cur.c_currency_id;

create or replace view c_order_header_vt(ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ad_language, c_order_id, issotrx, documentno, docstatus, c_doctype_id, c_bpartner_id, bpvalue, bptaxid, naics, duns, org_location_id, taxid, m_warehouse_id, warehouse_location_id, documenttype, documenttypenote, salesrep_id, salesrep_name, dateordered, datepromised, bpgreeting, name, name2, bpcontactgreeting, title, phone, contactname, c_location_id, postal, referenceno, bill_bpartner_id, bill_location_id, bill_user_id, bill_bpvalue, bill_bptaxid, bill_name, bill_name2, bill_title, bill_phone, bill_contactname, bill_c_location_id, description, poreference, c_currency_id, paymentterm, paymenttermnote, c_charge_id, chargeamt, totallines, grandtotal, amtinwords, m_pricelist_id, istaxincluded, volume, weight, c_campaign_id, c_project_id, c_activity_id, m_shipper_id, deliveryrule, deliveryviarule, priorityrule, invoicerule, logo_id, ad_orgtrx_id, ad_user_id, amountrefunded, amounttendered, c_bpartner_location_id, c_cashline_id, c_cashplanline_id, c_conversiontype_id, c_doctypetarget_id, copyfrom, c_payment_id, c_paymentterm_id, c_pos_id, dateacct, dateprinted, docaction, dropship_bpartner_id, dropship_location_id, dropship_user_id, freightamt, freightcostrule, isapproved, iscreditapproved, isdelivered, isdiscountprinted, isdropship, isinvoiced, ispayschedulevalid, isprinted, isselected, isselfservice, istransferred, link_order_id, m_freightcategory_id, ordertype, pay_bpartner_id, pay_location_id, paymentrule, posted, processed, processedon, promotioncode, ref_order_id, sendemail, user1_id, user2_id, m_warehouse_ad_org_id, m_warehouse_description, m_warehouse_isactive, isdisallownegativeinv, isintransit, m_warehousesource_id, m_warehouse_name, replenishmentclass, separator, m_warehouse_value, c_paymentterm_ad_org_id, afterdelivery, c_paymentterm_description, discount, discount2, discountdays, discountdays2, fixmonthcutoff, fixmonthday, fixmonthoffset, gracedays, c_paymentterm_isactive, isdefault, isduefixed, isnextbusinessday, isvalid, netday, netdays, paymenttermusage, m_paymentterm_value, bp_acqusitioncost, bp_actuallifetimevalue, bp_ad_language, bp_ad_orgbp_id, bp_ad_org_id, bp_bpartner_parent_id, bp_c_bp_group_id, bp_c_dunning_id, bp_c_greeting_id, bp_c_invoiceschedule_id, bp_c_paymentterm_id, bp_created, bp_createdby, bp_c_taxgroup_id, bp_deliveryrule, bp_deliveryviarule, bp_description, bp_dunninggrace, bp_firstsale, bp_flatdiscount, bp_freightcostrule, bp_invoicerule, bp_isactive, bp_iscustomer, bp_isdiscountprinted, bp_isemployee, bp_ismanufacturer, bp_isonetime, bp_ispotaxexempt, bp_isprospect, bp_issalesrep, bp_issummary, bp_istaxexempt, bp_isvendor, bp_logo_id, bp_m_discountschema_id, bp_m_pricelist_id, bp_numberemployees, bp_paymentrule, bp_paymentrulepo, bp_po_discountschema_id, bp_po_paymentterm_id, bp_po_pricelist_id, bp_poreference, bp_potentiallifetimevalue, bp_rating, bp_salesrep_id, bp_salesvolume, bp_sendemail, bp_shareofcustomer, bp_shelflifeminpct, bp_so_creditlimit, bp_socreditstatus, bp_so_creditused, bp_so_description, bp_totalopenbalance, bp_updated, bp_updatedby, bp_url, c_greeting_ad_org_id, c_greeting_isactive, isfirstnameonly, c_greeting_name, bp_location_ad_org_id, bp_location_c_bpartner_id, bp_location_created, bp_location_createdby, bp_location_c_salesregion_id, bp_location_fax, bp_location_isactive, bp_location_isbillto, bp_location_isdn, bp_location_ispayfrom, bp_location_isremitto, bp_location_isshipto, bp_location_name, bp_location_phone, bp_location_phone2, bp_location_updated, bp_location_updatedby, address1, address2, address3, address4, c_location_ad_org_id, c_city_id, c_country_id, city, c_location_created, c_location_createdby, c_region_id, c_location_isactive, regionname, c_location_updated, c_location_updatedby, ad_user_ad_org_id, ad_user_ad_orgtrx_id, ad_user_ad_birthday, ad_user_c_bpartner_id, ad_user_c_bpartner_location_id, ad_user_c_greeting_id, ad_user_comments, ad_user_created, ad_user_createdby, ad_user_description, ad_user_email, ad_user_fax, ad_user_isactive, ad_user_lastcontact, ad_user_lastresult, ad_user_phone2, ad_user_supervisor_id, ad_user_updated, ad_user_updatedby, ad_user_value, c_user_greeting_ad_org_id, c_user_greeting_isactive, c_user_greeting_isfnameonly, c_user_greeting_name, ad_orginfo_ad_org_id, ad_orgtype_id, c_calendar_id, ad_orginfo_created, ad_orginfo_createdby, dropship_warehouse_id, ad_orginfo_duns, ad_orginfo_email, ad_orginfo_fax, ad_orginfo_isactive, ad_orginfo_m_warehouse_id, parent_org_id, ad_orginfo_phone, ad_orginfo_phone2, receiptfootermsg, supervisor_id, ad_orginfo_updated, ad_orginfo_updatedby, salesrep_ad_org_id, salesrep_ad_orgtrx_id, salesrep_ad_birthday, salesrep_c_bpartner_id, salesrep_c_bp_location_id, salesrep_c_greeting_id, salesrep_comments, salesrep_created, salesrep_createdby, salesrep_description, salesrep_email, salesrep_fax, salesrep_isactive, salesrep_lastcontact, salesrep_lastresult, salesrep_phone, salesrep_phone2, salesrep_supervisor_id, salesrep_title, salesrep_updated, salesrep_updatedby, salesrep_value, salesrep_bp_acqusitioncost, salesrep_bp_actuallifetimeval, salesrep_bp_ad_language, salesrep_bp_ad_orgbp_id, salesrep_bp_ad_org_id, salesrep_bp_bpartner_parent_id, salesrep_bp_c_bp_group_id, salesrep_bp_c_dunning_id, salesrep_bp_c_greeting_id, salesrep_bp_c_invoicesched_id, salesrep_bp_c_paymentterm_id, salesrep_bp_created, salesrep_bp_createdby, salesrep_bp_c_taxgroup_id, salesrep_bp_deliveryrule, salesrep_bp_deliveryviarule, salesrep_bp_description, salesrep_bp_dunninggrace, salesrep_bp_duns, salesrep_bp_firstsale, salesrep_bp_flatdiscount, salesrep_bp_freightcostrule, salesrep_bp_invoicerule, salesrep_bp_isactive, salesrep_bp_iscustomer, salesrep_bp_isdiscountprinted, salesrep_bp_isemployee, salesrep_bp_ismanufacturer, salesrep_bp_isonetime, salesrep_bp_ispotaxexempt, salesrep_bp_isprospect, salesrep_bp_issalesrep, salesrep_bp_issummary, salesrep_bp_istaxexempt, salesrep_bp_isvendor, salesrep_bp_logo_id, salesrep_bp_m_discountschm_id, salesrep_bp_m_pricelist_id, salesrep_bp_naics, salesrep_bp_name2, salesrep_bp_numberemployees, salesrep_bp_paymentrule, salesrep_bp_paymentrulepo, salesrep_bp_po_discountschm_id, salesrep_bp_po_paymentterm_id, salesrep_bp_po_pricelist_id, salesrep_bp_poreference, salesrep_bp_potentiallifetime, salesrep_bp_rating, salesrep_bp_referenceno, salesrep_bp_salesrep_id, salesrep_bp_salesvolume, salesrep_bp_sendemail, salesrep_bp_shareofcustomer, salesrep_bp_shelflifeminpct, salesrep_bp_so_creditlimit, salesrep_bp_socreditstatus, salesrep_bp_so_creditused, salesrep_bp_so_description, salesrep_bp_taxid, salesrep_bp_totalopenbalance, salesrep_bp_updated, salesrep_bp_updatedby, salesrep_bp_url, salesrep_bp_value, bill_bp_acqusitioncost, bill_bp_actuallifetimevalue, bill_bp_ad_language, bill_bp_ad_orgbp_id, bill_bp_ad_org_id, bill_bp_bpartner_parent_id, bill_bp_c_bp_group_id, bill_bp_c_dunning_id, bill_bp_c_greeting_id, bill_bp_c_invoiceschedule_id, bill_bp_c_paymentterm_id, bill_bp_created, bill_bp_createdby, bill_bp_c_taxgroup_id, bill_bp_deliveryrule, bill_bp_deliveryviarule, bill_bp_description, bill_bp_dunninggrace, bill_bp_duns, bill_bp_firstsale, bill_bp_flatdiscount, bill_bp_freightcostrule, bill_bp_invoicerule, bill_bp_isactive, bill_bp_iscustomer, bill_bp_isdiscountprinted, bill_bp_isemployee, bill_bp_ismanufacturer, bill_bp_isonetime, bill_bp_ispotaxexempt, bill_bp_isprospect, bill_bp_issalesrep, bill_bp_issummary, bill_bp_istaxexempt, bill_bp_isvendor, bill_bp_logo_id, bill_bp_m_discountschema_id, bill_bp_m_pricelist_id, bill_bp_naics, bill_bp_numberemployees, bill_bp_paymentrule, bill_bp_paymentrulepo, bill_bp_po_discountschema_id, bill_bp_po_paymentterm_id, bill_bp_po_pricelist_id, bill_bp_poreference, bill_bp_potentiallifetimevalue, bill_bp_rating, bill_bp_referenceno, bill_bp_salesrep_id, bill_bp_salesvolume, bill_bp_sendemail, bill_bp_shareofcustomer, bill_bp_shelflifeminpct, bill_bp_so_creditlimit, bill_bp_socreditstatus, bill_bp_so_creditused, bill_bp_so_description, bill_bp_totalopenbalance, bill_bp_updated, bill_bp_updatedby, bill_bp_url, bill_bp_location_ad_org_id, bill_bp_location_c_bpartner_id, bill_bp_location_created, bill_bp_location_createdby, bill_bp_location_c_salesreg_id, bill_bp_location_fax, bill_bp_location_isactive, bill_bp_location_isbillto, bill_bp_location_isdn, bill_bp_location_ispayfrom, bill_bp_location_isremitto, bill_bp_location_isshipto, bill_bp_location_name, bill_bp_location_phone, bill_bp_location_phone2, bill_bp_location_updated, bill_bp_location_updatedby, bill_user_ad_org_id, bill_user_ad_orgtrx_id, bill_user_ad_birthday, bill_user_c_bpartner_id, bill_user_c_bp_location_id, bill_user_c_greeting_id, bill_user_comments, bill_user_created, bill_user_createdby, bill_user_description, bill_user_email, bill_user_fax, bill_user_isactive, bill_user_lastcontact, bill_user_lastresult, bill_user_phone2, bill_user_supervisor_id, bill_user_updated, bill_user_updatedby, bill_user_value, cursymbol, cur_description) as
	SELECT
	o.ad_client_id,
	o.ad_org_id,
	o.isactive,
	o.created,
	o.createdby,
	o.updated,
	o.updatedby,
	dt.ad_language,
	o.c_order_id,
	o.issotrx,
	o.documentno,
	o.docstatus,
	o.c_doctype_id,
	o.c_bpartner_id,
	bp.value                                                                                               AS bpvalue,
	bp.taxid                                                                                               AS bptaxid,
	bp.naics,
	bp.duns,
	oi.c_location_id                                                                                       AS org_location_id,
	oi.taxid,
	o.m_warehouse_id,
	wh.c_location_id                                                                                       AS warehouse_location_id,
	dt.printname                                                                                           AS documenttype,
	dt.documentnote                                                                                        AS documenttypenote,
	o.salesrep_id,
	COALESCE(ubp.name, u.name)                                                                             AS salesrep_name,
	o.dateordered,
	o.datepromised,
	bpgt.greeting                                                                                          AS bpgreeting,
	bp.name,
	bp.name2,
	bpcgt.greeting                                                                                         AS bpcontactgreeting,
	bpc.title,
	bpc.phone,
	NULLIF(bpc.name::text, bp.name::text)                                                                  AS contactname,
	bpl.c_location_id,
	COALESCE(l.postal, ''::character varying)::text || COALESCE(l.postal_add, ''::character varying)::text AS postal,
	bp.referenceno,
	o.bill_bpartner_id,
	o.bill_location_id,
	o.bill_user_id,
	bbp.value                                                                                              AS bill_bpvalue,
	bbp.taxid                                                                                              AS bill_bptaxid,
	bbp.name                                                                                               AS bill_name,
	bbp.name2                                                                                              AS bill_name2,
	bbpc.title                                                                                             AS bill_title,
	bbpc.phone                                                                                             AS bill_phone,
	NULLIF(bbpc.name::text, bbp.name::text)                                                                AS bill_contactname,
	bbpl.c_location_id                                                                                     AS bill_c_location_id,
	o.description,
	o.poreference,
	o.c_currency_id,
	ptt.name                                                                                               AS paymentterm,
	ptt.documentnote                                                                                       AS paymenttermnote,
	o.c_charge_id,
	o.chargeamt,
	o.totallines,
	o.grandtotal,
	o.grandtotal                                                                                           AS amtinwords,
	o.m_pricelist_id,
	o.istaxincluded,
	o.volume,
	o.weight,
	o.c_campaign_id,
	o.c_project_id,
	o.c_activity_id,
	o.m_shipper_id,
	o.deliveryrule,
	o.deliveryviarule,
	o.priorityrule,
	o.invoicerule,
	COALESCE(oi.logo_id, ci.logo_id)                                                                       AS logo_id,
	o.ad_orgtrx_id,
	o.ad_user_id,
	o.amountrefunded,
	o.amounttendered,
	o.c_bpartner_location_id,
	o.c_cashline_id,
	o.c_cashplanline_id,
	o.c_conversiontype_id,
	o.c_doctypetarget_id,
	o.copyfrom,
	o.c_payment_id,
	o.c_paymentterm_id,
	o.c_pos_id,
	o.dateacct,
	o.dateprinted,
	o.docaction,
	o.dropship_bpartner_id,
	o.dropship_location_id,
	o.dropship_user_id,
	o.freightamt,
	o.freightcostrule,
	o.isapproved,
	o.iscreditapproved,
	o.isdelivered,
	o.isdiscountprinted,
	o.isdropship,
	o.isinvoiced,
	o.ispayschedulevalid,
	o.isprinted,
	o.isselected,
	o.isselfservice,
	o.istransferred,
	o.link_order_id,
	o.m_freightcategory_id,
	o.ordertype,
	o.pay_bpartner_id,
	o.pay_location_id,
	o.paymentrule,
	o.posted,
	o.processed,
	o.processedon,
	o.promotioncode,
	o.ref_order_id,
	o.sendemail,
	o.user1_id,
	o.user2_id,
	wh.ad_org_id                                                                                           AS m_warehouse_ad_org_id,
	wh.description                                                                                         AS m_warehouse_description,
	wh.isactive                                                                                            AS m_warehouse_isactive,
	wh.isdisallownegativeinv,
	wh.isintransit,
	wh.m_warehousesource_id,
	wh.name                                                                                                AS m_warehouse_name,
	wh.replenishmentclass,
	wh.separator,
	wh.value                                                                                               AS m_warehouse_value,
	ptt.ad_org_id                                                                                          AS c_paymentterm_ad_org_id,
	pt.afterdelivery,
	ptt.description                                                                                        AS c_paymentterm_description,
	pt.discount,
	pt.discount2,
	pt.discountdays,
	pt.discountdays2,
	pt.fixmonthcutoff,
	pt.fixmonthday,
	pt.fixmonthoffset,
	pt.gracedays,
	ptt.isactive                                                                                           AS c_paymentterm_isactive,
	pt.isdefault,
	pt.isduefixed,
	pt.isnextbusinessday,
	pt.isvalid,
	pt.netday,
	pt.netdays,
	pt.paymenttermusage,
	pt.value                                                                                               AS m_paymentterm_value,
	bp.acqusitioncost                                                                                      AS bp_acqusitioncost,
	bp.actuallifetimevalue                                                                                 AS bp_actuallifetimevalue,
	bp.ad_language                                                                                         AS bp_ad_language,
	bp.ad_orgbp_id                                                                                         AS bp_ad_orgbp_id,
	bp.ad_org_id                                                                                           AS bp_ad_org_id,
	bp.bpartner_parent_id                                                                                  AS bp_bpartner_parent_id,
	bp.c_bp_group_id                                                                                       AS bp_c_bp_group_id,
	bp.c_dunning_id                                                                                        AS bp_c_dunning_id,
	bp.c_greeting_id                                                                                       AS bp_c_greeting_id,
	bp.c_invoiceschedule_id                                                                                AS bp_c_invoiceschedule_id,
	bp.c_paymentterm_id                                                                                    AS bp_c_paymentterm_id,
	bp.created                                                                                             AS bp_created,
	bp.createdby                                                                                           AS bp_createdby,
	bp.c_taxgroup_id                                                                                       AS bp_c_taxgroup_id,
	bp.deliveryrule                                                                                        AS bp_deliveryrule,
	bp.deliveryviarule                                                                                     AS bp_deliveryviarule,
	bp.description                                                                                         AS bp_description,
	bp.dunninggrace                                                                                        AS bp_dunninggrace,
	bp.firstsale                                                                                           AS bp_firstsale,
	bp.flatdiscount                                                                                        AS bp_flatdiscount,
	bp.freightcostrule                                                                                     AS bp_freightcostrule,
	bp.invoicerule                                                                                         AS bp_invoicerule,
	bp.isactive                                                                                            AS bp_isactive,
	bp.iscustomer                                                                                          AS bp_iscustomer,
	bp.isdiscountprinted                                                                                   AS bp_isdiscountprinted,
	bp.isemployee                                                                                          AS bp_isemployee,
	bp.ismanufacturer                                                                                      AS bp_ismanufacturer,
	bp.isonetime                                                                                           AS bp_isonetime,
	bp.ispotaxexempt                                                                                       AS bp_ispotaxexempt,
	bp.isprospect                                                                                          AS bp_isprospect,
	bp.issalesrep                                                                                          AS bp_issalesrep,
	bp.issummary                                                                                           AS bp_issummary,
	bp.istaxexempt                                                                                         AS bp_istaxexempt,
	bp.isvendor                                                                                            AS bp_isvendor,
	bp.logo_id                                                                                             AS bp_logo_id,
	bp.m_discountschema_id                                                                                 AS bp_m_discountschema_id,
	bp.m_pricelist_id                                                                                      AS bp_m_pricelist_id,
	bp.numberemployees                                                                                     AS bp_numberemployees,
	bp.paymentrule                                                                                         AS bp_paymentrule,
	bp.paymentrulepo                                                                                       AS bp_paymentrulepo,
	bp.po_discountschema_id                                                                                AS bp_po_discountschema_id,
	bp.po_paymentterm_id                                                                                   AS bp_po_paymentterm_id,
	bp.po_pricelist_id                                                                                     AS bp_po_pricelist_id,
	bp.poreference                                                                                         AS bp_poreference,
	bp.potentiallifetimevalue                                                                              AS bp_potentiallifetimevalue,
	bp.rating                                                                                              AS bp_rating,
	bp.salesrep_id                                                                                         AS bp_salesrep_id,
	bp.salesvolume                                                                                         AS bp_salesvolume,
	bp.sendemail                                                                                           AS bp_sendemail,
	bp.shareofcustomer                                                                                     AS bp_shareofcustomer,
	bp.shelflifeminpct                                                                                     AS bp_shelflifeminpct,
	bp.so_creditlimit                                                                                      AS bp_so_creditlimit,
	bp.socreditstatus                                                                                      AS bp_socreditstatus,
	bp.so_creditused                                                                                       AS bp_so_creditused,
	bp.so_description                                                                                      AS bp_so_description,
	bp.totalopenbalance                                                                                    AS bp_totalopenbalance,
	bp.updated                                                                                             AS bp_updated,
	bp.updatedby                                                                                           AS bp_updatedby,
	bp.url                                                                                                 AS bp_url,
	bpgt.ad_org_id                                                                                         AS c_greeting_ad_org_id,
	bpgt.isactive                                                                                          AS c_greeting_isactive,
	bpg.isfirstnameonly,
	bpgt.name                                                                                              AS c_greeting_name,
	bpl.ad_org_id                                                                                          AS bp_location_ad_org_id,
	bpl.c_bpartner_id                                                                                      AS bp_location_c_bpartner_id,
	bpl.created                                                                                            AS bp_location_created,
	bpl.createdby                                                                                          AS bp_location_createdby,
	bpl.c_salesregion_id                                                                                   AS bp_location_c_salesregion_id,
	bpl.fax                                                                                                AS bp_location_fax,
	bpl.isactive                                                                                           AS bp_location_isactive,
	bpl.isbillto                                                                                           AS bp_location_isbillto,
	bpl.isdn                                                                                               AS bp_location_isdn,
	bpl.ispayfrom                                                                                          AS bp_location_ispayfrom,
	bpl.isremitto                                                                                          AS bp_location_isremitto,
	bpl.isshipto                                                                                           AS bp_location_isshipto,
	bpl.name                                                                                               AS bp_location_name,
	bpl.phone                                                                                              AS bp_location_phone,
	bpl.phone2                                                                                             AS bp_location_phone2,
	bpl.updated                                                                                            AS bp_location_updated,
	bpl.updatedby                                                                                          AS bp_location_updatedby,
	l.address1,
	l.address2,
	l.address3,
	l.address4,
	l.ad_org_id                                                                                            AS c_location_ad_org_id,
	l.c_city_id,
	l.c_country_id,
	l.city,
	l.created                                                                                              AS c_location_created,
	l.createdby                                                                                            AS c_location_createdby,
	l.c_region_id,
	l.isactive                                                                                             AS c_location_isactive,
	l.regionname,
	l.updated                                                                                              AS c_location_updated,
	l.updatedby                                                                                            AS c_location_updatedby,
	bpc.ad_org_id                                                                                          AS ad_user_ad_org_id,
	bpc.ad_orgtrx_id                                                                                       AS ad_user_ad_orgtrx_id,
	bpc.birthday                                                                                           AS ad_user_ad_birthday,
	bpc.c_bpartner_id                                                                                      AS ad_user_c_bpartner_id,
	bpc.c_bpartner_location_id                                                                             AS ad_user_c_bpartner_location_id,
	bpc.c_greeting_id                                                                                      AS ad_user_c_greeting_id,
	bpc.comments                                                                                           AS ad_user_comments,
	bpc.created                                                                                            AS ad_user_created,
	bpc.createdby                                                                                          AS ad_user_createdby,
	bpc.description                                                                                        AS ad_user_description,
	bpc.email                                                                                              AS ad_user_email,
	bpc.fax                                                                                                AS ad_user_fax,
	bpc.isactive                                                                                           AS ad_user_isactive,
	bpc.lastcontact                                                                                        AS ad_user_lastcontact,
	bpc.lastresult                                                                                         AS ad_user_lastresult,
	bpc.phone2                                                                                             AS ad_user_phone2,
	bpc.supervisor_id                                                                                      AS ad_user_supervisor_id,
	bpc.updated                                                                                            AS ad_user_updated,
	bpc.updatedby                                                                                          AS ad_user_updatedby,
	bpc.value                                                                                              AS ad_user_value,
	bpcgt.ad_org_id                                                                                        AS c_user_greeting_ad_org_id,
	bpcgt.isactive                                                                                         AS c_user_greeting_isactive,
	bpcg.isfirstnameonly                                                                                   AS c_user_greeting_isfnameonly,
	bpcgt.name                                                                                             AS c_user_greeting_name,
	oi.ad_org_id                                                                                           AS ad_orginfo_ad_org_id,
	oi.ad_orgtype_id,
	oi.c_calendar_id,
	oi.created                                                                                             AS ad_orginfo_created,
	oi.createdby                                                                                           AS ad_orginfo_createdby,
	oi.dropship_warehouse_id,
	oi.duns                                                                                                AS ad_orginfo_duns,
	oi.email                                                                                               AS ad_orginfo_email,
	oi.fax                                                                                                 AS ad_orginfo_fax,
	oi.isactive                                                                                            AS ad_orginfo_isactive,
	oi.m_warehouse_id                                                                                      AS ad_orginfo_m_warehouse_id,
	oi.parent_org_id,
	oi.phone                                                                                               AS ad_orginfo_phone,
	oi.phone2                                                                                              AS ad_orginfo_phone2,
	oi.receiptfootermsg,
	oi.supervisor_id,
	oi.updated                                                                                             AS ad_orginfo_updated,
	oi.updatedby                                                                                           AS ad_orginfo_updatedby,
	u.ad_org_id                                                                                            AS salesrep_ad_org_id,
	u.ad_orgtrx_id                                                                                         AS salesrep_ad_orgtrx_id,
	u.birthday                                                                                             AS salesrep_ad_birthday,
	u.c_bpartner_id                                                                                        AS salesrep_c_bpartner_id,
	u.c_bpartner_location_id                                                                               AS salesrep_c_bp_location_id,
	u.c_greeting_id                                                                                        AS salesrep_c_greeting_id,
	u.comments                                                                                             AS salesrep_comments,
	u.created                                                                                              AS salesrep_created,
	u.createdby                                                                                            AS salesrep_createdby,
	u.description                                                                                          AS salesrep_description,
	u.email                                                                                                AS salesrep_email,
	u.fax                                                                                                  AS salesrep_fax,
	u.isactive                                                                                             AS salesrep_isactive,
	u.lastcontact                                                                                          AS salesrep_lastcontact,
	u.lastresult                                                                                           AS salesrep_lastresult,
	u.phone                                                                                                AS salesrep_phone,
	u.phone2                                                                                               AS salesrep_phone2,
	u.supervisor_id                                                                                        AS salesrep_supervisor_id,
	u.title                                                                                                AS salesrep_title,
	u.updated                                                                                              AS salesrep_updated,
	u.updatedby                                                                                            AS salesrep_updatedby,
	u.value                                                                                                AS salesrep_value,
	ubp.acqusitioncost                                                                                     AS salesrep_bp_acqusitioncost,
	ubp.actuallifetimevalue                                                                                AS salesrep_bp_actuallifetimeval,
	ubp.ad_language                                                                                        AS salesrep_bp_ad_language,
	ubp.ad_orgbp_id                                                                                        AS salesrep_bp_ad_orgbp_id,
	ubp.ad_org_id                                                                                          AS salesrep_bp_ad_org_id,
	ubp.bpartner_parent_id                                                                                 AS salesrep_bp_bpartner_parent_id,
	ubp.c_bp_group_id                                                                                      AS salesrep_bp_c_bp_group_id,
	ubp.c_dunning_id                                                                                       AS salesrep_bp_c_dunning_id,
	ubp.c_greeting_id                                                                                      AS salesrep_bp_c_greeting_id,
	ubp.c_invoiceschedule_id                                                                               AS salesrep_bp_c_invoicesched_id,
	ubp.c_paymentterm_id                                                                                   AS salesrep_bp_c_paymentterm_id,
	ubp.created                                                                                            AS salesrep_bp_created,
	ubp.createdby                                                                                          AS salesrep_bp_createdby,
	ubp.c_taxgroup_id                                                                                      AS salesrep_bp_c_taxgroup_id,
	ubp.deliveryrule                                                                                       AS salesrep_bp_deliveryrule,
	ubp.deliveryviarule                                                                                    AS salesrep_bp_deliveryviarule,
	ubp.description                                                                                        AS salesrep_bp_description,
	ubp.dunninggrace                                                                                       AS salesrep_bp_dunninggrace,
	ubp.duns                                                                                               AS salesrep_bp_duns,
	ubp.firstsale                                                                                          AS salesrep_bp_firstsale,
	ubp.flatdiscount                                                                                       AS salesrep_bp_flatdiscount,
	ubp.freightcostrule                                                                                    AS salesrep_bp_freightcostrule,
	ubp.invoicerule                                                                                        AS salesrep_bp_invoicerule,
	ubp.isactive                                                                                           AS salesrep_bp_isactive,
	ubp.iscustomer                                                                                         AS salesrep_bp_iscustomer,
	ubp.isdiscountprinted                                                                                  AS salesrep_bp_isdiscountprinted,
	ubp.isemployee                                                                                         AS salesrep_bp_isemployee,
	ubp.ismanufacturer                                                                                     AS salesrep_bp_ismanufacturer,
	ubp.isonetime                                                                                          AS salesrep_bp_isonetime,
	ubp.ispotaxexempt                                                                                      AS salesrep_bp_ispotaxexempt,
	ubp.isprospect                                                                                         AS salesrep_bp_isprospect,
	ubp.issalesrep                                                                                         AS salesrep_bp_issalesrep,
	ubp.issummary                                                                                          AS salesrep_bp_issummary,
	ubp.istaxexempt                                                                                        AS salesrep_bp_istaxexempt,
	ubp.isvendor                                                                                           AS salesrep_bp_isvendor,
	ubp.logo_id                                                                                            AS salesrep_bp_logo_id,
	ubp.m_discountschema_id                                                                                AS salesrep_bp_m_discountschm_id,
	ubp.m_pricelist_id                                                                                     AS salesrep_bp_m_pricelist_id,
	ubp.naics                                                                                              AS salesrep_bp_naics,
	ubp.name2                                                                                              AS salesrep_bp_name2,
	ubp.numberemployees                                                                                    AS salesrep_bp_numberemployees,
	ubp.paymentrule                                                                                        AS salesrep_bp_paymentrule,
	ubp.paymentrulepo                                                                                      AS salesrep_bp_paymentrulepo,
	ubp.po_discountschema_id                                                                               AS salesrep_bp_po_discountschm_id,
	ubp.po_paymentterm_id                                                                                  AS salesrep_bp_po_paymentterm_id,
	ubp.po_pricelist_id                                                                                    AS salesrep_bp_po_pricelist_id,
	ubp.poreference                                                                                        AS salesrep_bp_poreference,
	ubp.potentiallifetimevalue                                                                             AS salesrep_bp_potentiallifetime,
	ubp.rating                                                                                             AS salesrep_bp_rating,
	ubp.referenceno                                                                                        AS salesrep_bp_referenceno,
	ubp.salesrep_id                                                                                        AS salesrep_bp_salesrep_id,
	ubp.salesvolume                                                                                        AS salesrep_bp_salesvolume,
	ubp.sendemail                                                                                          AS salesrep_bp_sendemail,
	ubp.shareofcustomer                                                                                    AS salesrep_bp_shareofcustomer,
	ubp.shelflifeminpct                                                                                    AS salesrep_bp_shelflifeminpct,
	ubp.so_creditlimit                                                                                     AS salesrep_bp_so_creditlimit,
	ubp.socreditstatus                                                                                     AS salesrep_bp_socreditstatus,
	ubp.so_creditused                                                                                      AS salesrep_bp_so_creditused,
	ubp.so_description                                                                                     AS salesrep_bp_so_description,
	ubp.taxid                                                                                              AS salesrep_bp_taxid,
	ubp.totalopenbalance                                                                                   AS salesrep_bp_totalopenbalance,
	ubp.updated                                                                                            AS salesrep_bp_updated,
	ubp.updatedby                                                                                          AS salesrep_bp_updatedby,
	ubp.url                                                                                                AS salesrep_bp_url,
	ubp.value                                                                                              AS salesrep_bp_value,
	bbp.acqusitioncost                                                                                     AS bill_bp_acqusitioncost,
	bbp.actuallifetimevalue                                                                                AS bill_bp_actuallifetimevalue,
	bbp.ad_language                                                                                        AS bill_bp_ad_language,
	bbp.ad_orgbp_id                                                                                        AS bill_bp_ad_orgbp_id,
	bbp.ad_org_id                                                                                          AS bill_bp_ad_org_id,
	bbp.bpartner_parent_id                                                                                 AS bill_bp_bpartner_parent_id,
	bbp.c_bp_group_id                                                                                      AS bill_bp_c_bp_group_id,
	bbp.c_dunning_id                                                                                       AS bill_bp_c_dunning_id,
	bbp.c_greeting_id                                                                                      AS bill_bp_c_greeting_id,
	bbp.c_invoiceschedule_id                                                                               AS bill_bp_c_invoiceschedule_id,
	bbp.c_paymentterm_id                                                                                   AS bill_bp_c_paymentterm_id,
	bbp.created                                                                                            AS bill_bp_created,
	bbp.createdby                                                                                          AS bill_bp_createdby,
	bbp.c_taxgroup_id                                                                                      AS bill_bp_c_taxgroup_id,
	bbp.deliveryrule                                                                                       AS bill_bp_deliveryrule,
	bbp.deliveryviarule                                                                                    AS bill_bp_deliveryviarule,
	bbp.description                                                                                        AS bill_bp_description,
	bbp.dunninggrace                                                                                       AS bill_bp_dunninggrace,
	bbp.duns                                                                                               AS bill_bp_duns,
	bbp.firstsale                                                                                          AS bill_bp_firstsale,
	bbp.flatdiscount                                                                                       AS bill_bp_flatdiscount,
	bbp.freightcostrule                                                                                    AS bill_bp_freightcostrule,
	bbp.invoicerule                                                                                        AS bill_bp_invoicerule,
	bbp.isactive                                                                                           AS bill_bp_isactive,
	bbp.iscustomer                                                                                         AS bill_bp_iscustomer,
	bbp.isdiscountprinted                                                                                  AS bill_bp_isdiscountprinted,
	bbp.isemployee                                                                                         AS bill_bp_isemployee,
	bbp.ismanufacturer                                                                                     AS bill_bp_ismanufacturer,
	bbp.isonetime                                                                                          AS bill_bp_isonetime,
	bbp.ispotaxexempt                                                                                      AS bill_bp_ispotaxexempt,
	bbp.isprospect                                                                                         AS bill_bp_isprospect,
	bbp.issalesrep                                                                                         AS bill_bp_issalesrep,
	bbp.issummary                                                                                          AS bill_bp_issummary,
	bbp.istaxexempt                                                                                        AS bill_bp_istaxexempt,
	bbp.isvendor                                                                                           AS bill_bp_isvendor,
	bbp.logo_id                                                                                            AS bill_bp_logo_id,
	bbp.m_discountschema_id                                                                                AS bill_bp_m_discountschema_id,
	bbp.m_pricelist_id                                                                                     AS bill_bp_m_pricelist_id,
	bbp.naics                                                                                              AS bill_bp_naics,
	bbp.numberemployees                                                                                    AS bill_bp_numberemployees,
	bbp.paymentrule                                                                                        AS bill_bp_paymentrule,
	bbp.paymentrulepo                                                                                      AS bill_bp_paymentrulepo,
	bbp.po_discountschema_id                                                                               AS bill_bp_po_discountschema_id,
	bbp.po_paymentterm_id                                                                                  AS bill_bp_po_paymentterm_id,
	bbp.po_pricelist_id                                                                                    AS bill_bp_po_pricelist_id,
	bbp.poreference                                                                                        AS bill_bp_poreference,
	bbp.potentiallifetimevalue                                                                             AS bill_bp_potentiallifetimevalue,
	bbp.rating                                                                                             AS bill_bp_rating,
	bbp.referenceno                                                                                        AS bill_bp_referenceno,
	bbp.salesrep_id                                                                                        AS bill_bp_salesrep_id,
	bbp.salesvolume                                                                                        AS bill_bp_salesvolume,
	bbp.sendemail                                                                                          AS bill_bp_sendemail,
	bbp.shareofcustomer                                                                                    AS bill_bp_shareofcustomer,
	bbp.shelflifeminpct                                                                                    AS bill_bp_shelflifeminpct,
	bbp.so_creditlimit                                                                                     AS bill_bp_so_creditlimit,
	bbp.socreditstatus                                                                                     AS bill_bp_socreditstatus,
	bbp.so_creditused                                                                                      AS bill_bp_so_creditused,
	bbp.so_description                                                                                     AS bill_bp_so_description,
	bbp.totalopenbalance                                                                                   AS bill_bp_totalopenbalance,
	bbp.updated                                                                                            AS bill_bp_updated,
	bbp.updatedby                                                                                          AS bill_bp_updatedby,
	bbp.url                                                                                                AS bill_bp_url,
	bbpl.ad_org_id                                                                                         AS bill_bp_location_ad_org_id,
	bbpl.c_bpartner_id                                                                                     AS bill_bp_location_c_bpartner_id,
	bbpl.created                                                                                           AS bill_bp_location_created,
	bbpl.createdby                                                                                         AS bill_bp_location_createdby,
	bbpl.c_salesregion_id                                                                                  AS bill_bp_location_c_salesreg_id,
	bbpl.fax                                                                                               AS bill_bp_location_fax,
	bbpl.isactive                                                                                          AS bill_bp_location_isactive,
	bbpl.isbillto                                                                                          AS bill_bp_location_isbillto,
	bbpl.isdn                                                                                              AS bill_bp_location_isdn,
	bbpl.ispayfrom                                                                                         AS bill_bp_location_ispayfrom,
	bbpl.isremitto                                                                                         AS bill_bp_location_isremitto,
	bbpl.isshipto                                                                                          AS bill_bp_location_isshipto,
	bbpl.name                                                                                              AS bill_bp_location_name,
	bbpl.phone                                                                                             AS bill_bp_location_phone,
	bbpl.phone2                                                                                            AS bill_bp_location_phone2,
	bbpl.updated                                                                                           AS bill_bp_location_updated,
	bbpl.updatedby                                                                                         AS bill_bp_location_updatedby,
	bbpc.ad_org_id                                                                                         AS bill_user_ad_org_id,
	bbpc.ad_orgtrx_id                                                                                      AS bill_user_ad_orgtrx_id,
	bbpc.birthday                                                                                          AS bill_user_ad_birthday,
	bbpc.c_bpartner_id                                                                                     AS bill_user_c_bpartner_id,
	bbpc.c_bpartner_location_id                                                                            AS bill_user_c_bp_location_id,
	bbpc.c_greeting_id                                                                                     AS bill_user_c_greeting_id,
	bbpc.comments                                                                                          AS bill_user_comments,
	bbpc.created                                                                                           AS bill_user_created,
	bbpc.createdby                                                                                         AS bill_user_createdby,
	bbpc.description                                                                                       AS bill_user_description,
	bbpc.email                                                                                             AS bill_user_email,
	bbpc.fax                                                                                               AS bill_user_fax,
	bbpc.isactive                                                                                          AS bill_user_isactive,
	bbpc.lastcontact                                                                                       AS bill_user_lastcontact,
	bbpc.lastresult                                                                                        AS bill_user_lastresult,
	bbpc.phone2                                                                                            AS bill_user_phone2,
	bbpc.supervisor_id                                                                                     AS bill_user_supervisor_id,
	bbpc.updated                                                                                           AS bill_user_updated,
	bbpc.updatedby                                                                                         AS bill_user_updatedby,
	bbpc.value                                                                                             AS bill_user_value,
	cur.cursymbol,
	cur.description                                                                                        AS cur_description
FROM
	c_order o
		JOIN c_doctype_trl dt
		ON o.c_doctype_id = dt.c_doctype_id
		JOIN m_warehouse wh
		ON o.m_warehouse_id = wh.m_warehouse_id
		JOIN c_paymentterm pt
		ON o.c_paymentterm_id = pt.c_paymentterm_id
		JOIN c_paymentterm_trl ptt
		ON o.c_paymentterm_id = ptt.c_paymentterm_id AND dt.ad_language::text = ptt.ad_language::text
		JOIN c_bpartner bp
		ON o.c_bpartner_id = bp.c_bpartner_id
		LEFT JOIN c_greeting bpg
		ON bp.c_greeting_id = bpg.c_greeting_id
		LEFT JOIN c_greeting_trl bpgt
		ON bp.c_greeting_id = bpgt.c_greeting_id AND dt.ad_language::text = bpgt.ad_language::text
		JOIN c_bpartner_location bpl
		ON o.c_bpartner_location_id = bpl.c_bpartner_location_id
		JOIN c_location l
		ON bpl.c_location_id = l.c_location_id
		LEFT JOIN ad_user bpc
		ON o.ad_user_id = bpc.ad_user_id
		LEFT JOIN c_greeting bpcg
		ON bpc.c_greeting_id = bpcg.c_greeting_id
		LEFT JOIN c_greeting_trl bpcgt
		ON bpc.c_greeting_id = bpcgt.c_greeting_id AND dt.ad_language::text = bpcgt.ad_language::text
		JOIN ad_orginfo oi
		ON o.ad_org_id = oi.ad_org_id
		JOIN ad_clientinfo ci
		ON o.ad_client_id = ci.ad_client_id
		LEFT JOIN ad_user u
		ON o.salesrep_id = u.ad_user_id
		LEFT JOIN c_bpartner ubp
		ON u.c_bpartner_id = ubp.c_bpartner_id
		JOIN c_bpartner bbp
		ON o.bill_bpartner_id = bbp.c_bpartner_id
		JOIN c_bpartner_location bbpl
		ON o.bill_location_id = bbpl.c_bpartner_location_id
		LEFT JOIN ad_user bbpc
		ON o.bill_user_id = bbpc.ad_user_id
		LEFT JOIN c_currency_trl cur
		ON o.c_currency_id = cur.c_currency_id AND dt.ad_language::text = cur.ad_language::text;

create or replace view rv_commissionrundetail(ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, c_commissionrun_id, documentno, description, startdate, grandtotal, processed, c_commission_id, commission_bpartner_id, c_commissionamt_id, commissionconvertedamt, commissionqty, commissionamt, c_commissiondetail_id, reference, c_orderline_id, c_invoiceline_id, info, c_currency_id, actualamt, convertedamt, actualqty, invoicedocumentno, datedoc, m_product_id, c_bpartner_id, c_bpartner_location_id, ad_user_id, c_doctype_id, c_commisionrun_processing, c_commission_ad_org_id, c_commission_c_currency_id, c_commission_created, c_commission_createdby, createfrom, datelastrun, c_commission_description, docbasistype, frequencytype, c_commission_isactive, listdetails, c_commission_name, c_commission_updated, c_commission_updatedby, c_commissionamt_ad_org_id, c_commissionline_id, c_commmissionamt_created, c_commmissionamt_createdby, c_commmissionamt_isactive, c_commmissionamt_updated, c_commssionamt_updatedby, c_commissiondetail_ad_org_id, c_commissiondetail_created, c_commissiondetail_createdby, c_commossiondetail_isactive, c_commissiondetail_updated, c_commissiondetail_updatedby, c_orderline_ad_org_id, c_orderline_ad_orgtrx_id, c_orderline_c_activity_id, c_orderline_c_bpartner_id, c_orderline_c_bp_location_id, c_orderline_c_campaign_id, c_orderline_c_charge_id, c_orderline_c_currency_id, c_orderline_c_order_id, c_orderline_c_project_id, c_orderline_c_projectphase_id, c_orderline_c_projecttask_id, c_orderline_created, c_orderline_createdby, c_orderline_c_tax_id, c_orderline_c_uom_id, datedelivered, dateinvoiced, dateordered, datepromised, c_orderline_description, discount, freightamt, c_orderline_isactive, isdescription, c_orderline_line, c_orderline_linenetamt, link_orderline_id, c_orderline_m_asi_id, m_promotion_id, c_orderline_m_shipper_id, c_orderline_m_warehouse_id, c_orderline_priceactual, pricecost, c_orderline_priceentered, c_orderline_pricelist, c_orderline_processed, qtydelivered, qtyentered, c_orderline_qtyinvoiced, qtylostsales, qtyordered, qtyreserved, c_orderline_ref_orderline_id, c_orderline_rramt, c_orderline_rrstartsate, c_orderline_s_rassignment_id, c_orderline_updated, c_orderline_updatedby, c_orderline_user1_id, c_orderline_user2_id, c_inviceline_ad_org_id, c_invoiceline_ad_orgtrx_id, a_processed, c_invoiceline_c_activity_id, c_invoiceline_c_campaign_id, c_invoiceline_c_charge_id, c_invoice_id, c_invoiceline_c_orderline_id, c_invoiceline_c_project_id, c_invoiceline_c_projphase_id, c_invoiceline_c_projecttask_id, c_invoiceline_created, c_invoiceline_createdby, c_invoiceline_c_tax_id, c_invoiceline_c_uom_id, c_invoiceline_description, c_invoiceline_isactive, c_invoiceline_isdescription, isprinted, c_invoiceline_line, c_invoiceline_linenetamt, c_invoiceline_linetotalamt, c_invoiceline_m_asi_id, m_inoutline_id, c_invoiceline_m_rmaline_id, c_invoiceline_priceactual, c_invoiceline_priceentered, c_invoiceline_pricelimit, c_invoiceline_pricelist, c_invoiceline_processed, c_invoiceline_qtyentered, c_invoiceline_qtyinvoiced, c_invoiceline_ref_invline_id, c_invoiceline_rramt, c_invoiceline_rrstartdate, c_invoiceline_s_rassignment_id, c_invoiceline_taxamt, c_invoiceline_updated, c_invoiceline_updatedby, c_invoiceline_user1_id, c_invoiceline_user2_id, c_order_ad_org_id, c_order_ad_orgtrx_id, c_order_ad_user_id, amountrefunded, amounttendered, bill_bpartner_id, bill_location_id, bill_user_id, c_activity_id, c_order_c_campaign_id, c_cashline_id, c_cashplanline_id, c_charge_id, c_conversiontype_id, c_order_c_currency_id, c_doctypetarget_id, c_order_chargeamt, c_order_copyfrom, c_order_c_order_id, c_order_c_payment_id, c_order_paymentterm_id, c_pos_id, c_order_c_project_id, c_order_created, c_order_createdby, c_order_dateacct, c_order_dateprinted, c_order_datepromised, c_order_deliveryrule, c_order_deliveryviarule, c_order_description, c_order_docaction, c_order_docstatus, c_order_documentno, dropship_bpartner_id, dropship_location_id, dropship_user_id, c_order_freightamt, c_order_freightcostrule, c_order_grandtotal, invoicerule, c_order_isactive, isapproved, iscreditapproved, isdelivered, isdiscountprinted, isdropship, isinvoiced, ispayschedulevalid, c_order_isprinted, c_order_isselected, c_order_isselfservice, c_order_issotrx, c_order_istaxincluded, istransferred, link_order_id, m_freightcategory_id, m_pricelist_id, c_order_m_shipper_id, c_order_m_warehouse_id, ordertype, pay_bpartner_id, pay_location_id, paymentrule, poreference, c_order_posted, priorityrule, c_order_processed, c_order_processedon, promotioncode, c_order_ref_order_id, c_order_sendemail, c_order_totallines, c_order_user1_id, c_order_user2_id, c_invoice_ad_org_id, c_invoice_ad_orgtrx_id, c_invoice_c_activity_id, c_invoice_c_campaign_id, c_invoice_c_charge_id, c_invoice_c_conversiontype_id, c_invoice_c_currency_id, c_invoice_c_doctypetarget_id, c_dunninglevel_id, c_invoice_chargeamt, c_invoice_c_invoice_id, c_invoice_c_order_id, c_invoice_c_payment_id, c_invoice_c_paymentterm_id, c_invoice_c_project_id, c_invoice_created, c_invoice_createdby, c_invoice_dateacct, c_invoice_dateordered, c_invoice_dateprinted, c_invoice_description, c_invoice_docaction, c_invoice_docstatus, c_invoice_dunninggrace, generateto, c_invoice_grandtotal, invoicecollectiontype, c_invoice_isactive, c_invoice_isapproved, c_invoice_isdiscountprinted, c_invoice_isindispute, c_invoice_ispayschedulevalid, c_invoice_isprinted, c_invoice_isselfservice, c_invoice_issotrx, c_invoice_istaxincluded, c_invoice_istransferred, c_invoice_m_pricelist_id, c_invoice_m_rma_id, c_invoice_paymentrule, c_invoice_poreference, c_invoice_posted, c_invoice_processedon, c_invoice_processing, ref_invoice_id, reversal_id, c_invoice_salesrep_id, c_invoice_sendemail, c_invoice_totallines, c_invoice_updated, c_invoice_updatedby, c_invoice_user1_id, c_invoice_user2_id) as
	SELECT
	cr.ad_client_id,
	cr.ad_org_id,
	cr.isactive,
	cr.created,
	cr.createdby,
	cr.updated,
	cr.updatedby,
	cr.c_commissionrun_id,
	cr.documentno,
	cr.description,
	cr.startdate,
	cr.grandtotal,
	cr.processed,
	c.c_commission_id,
	c.c_bpartner_id                                              AS commission_bpartner_id,
	ca.c_commissionamt_id,
	ca.convertedamt                                              AS commissionconvertedamt,
	ca.actualqty                                                 AS commissionqty,
	ca.commissionamt,
	cd.c_commissiondetail_id,
	cd.reference,
	cd.c_orderline_id,
	cd.c_invoiceline_id,
	cd.info,
	cd.c_currency_id,
	cd.actualamt,
	cd.convertedamt,
	cd.actualqty,
	i.documentno                                                 AS invoicedocumentno,
	COALESCE(i.dateinvoiced, o.dateordered)                      AS datedoc,
	COALESCE(il.m_product_id, ol.m_product_id)                   AS m_product_id,
	COALESCE(i.c_bpartner_id, o.c_bpartner_id)                   AS c_bpartner_id,
	COALESCE(i.c_bpartner_location_id, o.c_bpartner_location_id) AS c_bpartner_location_id,
	COALESCE(i.ad_user_id, o.ad_user_id)                         AS ad_user_id,
	COALESCE(i.c_doctype_id, o.c_doctype_id)                     AS c_doctype_id,
	cr.processing                                                AS c_commisionrun_processing,
	c.ad_org_id                                                  AS c_commission_ad_org_id,
	c.c_currency_id                                              AS c_commission_c_currency_id,
	c.created                                                    AS c_commission_created,
	c.createdby                                                  AS c_commission_createdby,
	c.createfrom,
	c.datelastrun,
	c.description                                                AS c_commission_description,
	c.docbasistype,
	c.frequencytype,
	c.isactive                                                   AS c_commission_isactive,
	c.listdetails,
	c.name                                                       AS c_commission_name,
	c.updated                                                    AS c_commission_updated,
	c.updatedby                                                  AS c_commission_updatedby,
	ca.ad_org_id                                                 AS c_commissionamt_ad_org_id,
	ca.c_commissionline_id,
	ca.created                                                   AS c_commmissionamt_created,
	ca.createdby                                                 AS c_commmissionamt_createdby,
	ca.isactive                                                  AS c_commmissionamt_isactive,
	ca.updated                                                   AS c_commmissionamt_updated,
	ca.updatedby                                                 AS c_commssionamt_updatedby,
	cd.ad_org_id                                                 AS c_commissiondetail_ad_org_id,
	cd.created                                                   AS c_commissiondetail_created,
	cd.createdby                                                 AS c_commissiondetail_createdby,
	cd.isactive                                                  AS c_commossiondetail_isactive,
	cd.updated                                                   AS c_commissiondetail_updated,
	cd.updatedby                                                 AS c_commissiondetail_updatedby,
	ol.ad_org_id                                                 AS c_orderline_ad_org_id,
	ol.ad_orgtrx_id                                              AS c_orderline_ad_orgtrx_id,
	ol.c_activity_id                                             AS c_orderline_c_activity_id,
	ol.c_bpartner_id                                             AS c_orderline_c_bpartner_id,
	ol.c_bpartner_location_id                                    AS c_orderline_c_bp_location_id,
	ol.c_campaign_id                                             AS c_orderline_c_campaign_id,
	ol.c_charge_id                                               AS c_orderline_c_charge_id,
	ol.c_currency_id                                             AS c_orderline_c_currency_id,
	ol.c_order_id                                                AS c_orderline_c_order_id,
	ol.c_project_id                                              AS c_orderline_c_project_id,
	ol.c_projectphase_id                                         AS c_orderline_c_projectphase_id,
	ol.c_projecttask_id                                          AS c_orderline_c_projecttask_id,
	ol.created                                                   AS c_orderline_created,
	ol.createdby                                                 AS c_orderline_createdby,
	ol.c_tax_id                                                  AS c_orderline_c_tax_id,
	ol.c_uom_id                                                  AS c_orderline_c_uom_id,
	ol.datedelivered,
	ol.dateinvoiced,
	ol.dateordered,
	ol.datepromised,
	ol.description                                               AS c_orderline_description,
	ol.discount,
	ol.freightamt,
	ol.isactive                                                  AS c_orderline_isactive,
	ol.isdescription,
	ol.line                                                      AS c_orderline_line,
	ol.linenetamt                                                AS c_orderline_linenetamt,
	ol.link_orderline_id,
	ol.m_attributesetinstance_id                                 AS c_orderline_m_asi_id,
	ol.m_promotion_id,
	ol.m_shipper_id                                              AS c_orderline_m_shipper_id,
	ol.m_warehouse_id                                            AS c_orderline_m_warehouse_id,
	ol.priceactual                                               AS c_orderline_priceactual,
	ol.pricecost,
	ol.priceentered                                              AS c_orderline_priceentered,
	ol.pricelist                                                 AS c_orderline_pricelist,
	ol.processed                                                 AS c_orderline_processed,
	ol.qtydelivered,
	ol.qtyentered,
	ol.qtyinvoiced                                               AS c_orderline_qtyinvoiced,
	ol.qtylostsales,
	ol.qtyordered,
	ol.qtyreserved,
	ol.ref_orderline_id                                          AS c_orderline_ref_orderline_id,
	ol.rramt                                                     AS c_orderline_rramt,
	ol.rrstartdate                                               AS c_orderline_rrstartsate,
	ol.s_resourceassignment_id                                   AS c_orderline_s_rassignment_id,
	ol.updated                                                   AS c_orderline_updated,
	ol.updatedby                                                 AS c_orderline_updatedby,
	ol.user1_id                                                  AS c_orderline_user1_id,
	ol.user2_id                                                  AS c_orderline_user2_id,
	il.ad_org_id                                                 AS c_inviceline_ad_org_id,
	il.ad_orgtrx_id                                              AS c_invoiceline_ad_orgtrx_id,
	il.a_processed,
	il.c_activity_id                                             AS c_invoiceline_c_activity_id,
	il.c_campaign_id                                             AS c_invoiceline_c_campaign_id,
	il.c_charge_id                                               AS c_invoiceline_c_charge_id,
	il.c_invoice_id,
	il.c_orderline_id                                            AS c_invoiceline_c_orderline_id,
	il.c_project_id                                              AS c_invoiceline_c_project_id,
	il.c_projectphase_id                                         AS c_invoiceline_c_projphase_id,
	il.c_projecttask_id                                          AS c_invoiceline_c_projecttask_id,
	il.created                                                   AS c_invoiceline_created,
	il.createdby                                                 AS c_invoiceline_createdby,
	il.c_tax_id                                                  AS c_invoiceline_c_tax_id,
	il.c_uom_id                                                  AS c_invoiceline_c_uom_id,
	il.description                                               AS c_invoiceline_description,
	il.isactive                                                  AS c_invoiceline_isactive,
	il.isdescription                                             AS c_invoiceline_isdescription,
	il.isprinted,
	il.line                                                      AS c_invoiceline_line,
	il.linenetamt                                                AS c_invoiceline_linenetamt,
	il.linetotalamt                                              AS c_invoiceline_linetotalamt,
	il.m_attributesetinstance_id                                 AS c_invoiceline_m_asi_id,
	il.m_inoutline_id,
	il.m_rmaline_id                                              AS c_invoiceline_m_rmaline_id,
	il.priceactual                                               AS c_invoiceline_priceactual,
	il.priceentered                                              AS c_invoiceline_priceentered,
	il.pricelimit                                                AS c_invoiceline_pricelimit,
	il.pricelist                                                 AS c_invoiceline_pricelist,
	il.processed                                                 AS c_invoiceline_processed,
	il.qtyentered                                                AS c_invoiceline_qtyentered,
	il.qtyinvoiced                                               AS c_invoiceline_qtyinvoiced,
	il.ref_invoiceline_id                                        AS c_invoiceline_ref_invline_id,
	il.rramt                                                     AS c_invoiceline_rramt,
	il.rrstartdate                                               AS c_invoiceline_rrstartdate,
	il.s_resourceassignment_id                                   AS c_invoiceline_s_rassignment_id,
	il.taxamt                                                    AS c_invoiceline_taxamt,
	il.updated                                                   AS c_invoiceline_updated,
	il.updatedby                                                 AS c_invoiceline_updatedby,
	il.user1_id                                                  AS c_invoiceline_user1_id,
	il.user2_id                                                  AS c_invoiceline_user2_id,
	o.ad_org_id                                                  AS c_order_ad_org_id,
	o.ad_orgtrx_id                                               AS c_order_ad_orgtrx_id,
	o.ad_user_id                                                 AS c_order_ad_user_id,
	o.amountrefunded,
	o.amounttendered,
	o.bill_bpartner_id,
	o.bill_location_id,
	o.bill_user_id,
	o.c_activity_id,
	o.c_campaign_id                                              AS c_order_c_campaign_id,
	o.c_cashline_id,
	o.c_cashplanline_id,
	o.c_charge_id,
	o.c_conversiontype_id,
	o.c_currency_id                                              AS c_order_c_currency_id,
	o.c_doctypetarget_id,
	o.chargeamt                                                  AS c_order_chargeamt,
	o.copyfrom                                                   AS c_order_copyfrom,
	o.c_order_id                                                 AS c_order_c_order_id,
	o.c_payment_id                                               AS c_order_c_payment_id,
	o.c_paymentterm_id                                           AS c_order_paymentterm_id,
	o.c_pos_id,
	o.c_project_id                                               AS c_order_c_project_id,
	o.created                                                    AS c_order_created,
	o.createdby                                                  AS c_order_createdby,
	o.dateacct                                                   AS c_order_dateacct,
	o.dateprinted                                                AS c_order_dateprinted,
	o.datepromised                                               AS c_order_datepromised,
	o.deliveryrule                                               AS c_order_deliveryrule,
	o.deliveryviarule                                            AS c_order_deliveryviarule,
	o.description                                                AS c_order_description,
	o.docaction                                                  AS c_order_docaction,
	o.docstatus                                                  AS c_order_docstatus,
	o.documentno                                                 AS c_order_documentno,
	o.dropship_bpartner_id,
	o.dropship_location_id,
	o.dropship_user_id,
	o.freightamt                                                 AS c_order_freightamt,
	o.freightcostrule                                            AS c_order_freightcostrule,
	o.grandtotal                                                 AS c_order_grandtotal,
	o.invoicerule,
	o.isactive                                                   AS c_order_isactive,
	o.isapproved,
	o.iscreditapproved,
	o.isdelivered,
	o.isdiscountprinted,
	o.isdropship,
	o.isinvoiced,
	o.ispayschedulevalid,
	o.isprinted                                                  AS c_order_isprinted,
	o.isselected                                                 AS c_order_isselected,
	o.isselfservice                                              AS c_order_isselfservice,
	o.issotrx                                                    AS c_order_issotrx,
	o.istaxincluded                                              AS c_order_istaxincluded,
	o.istransferred,
	o.link_order_id,
	o.m_freightcategory_id,
	o.m_pricelist_id,
	o.m_shipper_id                                               AS c_order_m_shipper_id,
	o.m_warehouse_id                                             AS c_order_m_warehouse_id,
	o.ordertype,
	o.pay_bpartner_id,
	o.pay_location_id,
	o.paymentrule,
	o.poreference,
	o.posted                                                     AS c_order_posted,
	o.priorityrule,
	o.processed                                                  AS c_order_processed,
	o.processedon                                                AS c_order_processedon,
	o.promotioncode,
	o.ref_order_id                                               AS c_order_ref_order_id,
	o.sendemail                                                  AS c_order_sendemail,
	o.totallines                                                 AS c_order_totallines,
	o.user1_id                                                   AS c_order_user1_id,
	o.user2_id                                                   AS c_order_user2_id,
	i.ad_org_id                                                  AS c_invoice_ad_org_id,
	i.ad_orgtrx_id                                               AS c_invoice_ad_orgtrx_id,
	i.c_activity_id                                              AS c_invoice_c_activity_id,
	i.c_campaign_id                                              AS c_invoice_c_campaign_id,
	i.c_charge_id                                                AS c_invoice_c_charge_id,
	i.c_conversiontype_id                                        AS c_invoice_c_conversiontype_id,
	i.c_currency_id                                              AS c_invoice_c_currency_id,
	i.c_doctypetarget_id                                         AS c_invoice_c_doctypetarget_id,
	i.c_dunninglevel_id,
	i.chargeamt                                                  AS c_invoice_chargeamt,
	i.c_invoice_id                                               AS c_invoice_c_invoice_id,
	i.c_order_id                                                 AS c_invoice_c_order_id,
	i.c_payment_id                                               AS c_invoice_c_payment_id,
	i.c_paymentterm_id                                           AS c_invoice_c_paymentterm_id,
	i.c_project_id                                               AS c_invoice_c_project_id,
	i.created                                                    AS c_invoice_created,
	i.createdby                                                  AS c_invoice_createdby,
	i.dateacct                                                   AS c_invoice_dateacct,
	i.dateordered                                                AS c_invoice_dateordered,
	i.dateprinted                                                AS c_invoice_dateprinted,
	i.description                                                AS c_invoice_description,
	i.docaction                                                  AS c_invoice_docaction,
	i.docstatus                                                  AS c_invoice_docstatus,
	i.dunninggrace                                               AS c_invoice_dunninggrace,
	i.generateto,
	i.grandtotal                                                 AS c_invoice_grandtotal,
	i.invoicecollectiontype,
	i.isactive                                                   AS c_invoice_isactive,
	i.isapproved                                                 AS c_invoice_isapproved,
	i.isdiscountprinted                                          AS c_invoice_isdiscountprinted,
	i.isindispute                                                AS c_invoice_isindispute,
	i.ispayschedulevalid                                         AS c_invoice_ispayschedulevalid,
	i.isprinted                                                  AS c_invoice_isprinted,
	i.isselfservice                                              AS c_invoice_isselfservice,
	i.issotrx                                                    AS c_invoice_issotrx,
	i.istaxincluded                                              AS c_invoice_istaxincluded,
	i.istransferred                                              AS c_invoice_istransferred,
	i.m_pricelist_id                                             AS c_invoice_m_pricelist_id,
	i.m_rma_id                                                   AS c_invoice_m_rma_id,
	i.paymentrule                                                AS c_invoice_paymentrule,
	i.poreference                                                AS c_invoice_poreference,
	i.posted                                                     AS c_invoice_posted,
	i.processedon                                                AS c_invoice_processedon,
	i.processing                                                 AS c_invoice_processing,
	i.ref_invoice_id,
	i.reversal_id,
	i.salesrep_id                                                AS c_invoice_salesrep_id,
	i.sendemail                                                  AS c_invoice_sendemail,
	i.totallines                                                 AS c_invoice_totallines,
	i.updated                                                    AS c_invoice_updated,
	i.updatedby                                                  AS c_invoice_updatedby,
	i.user1_id                                                   AS c_invoice_user1_id,
	i.user2_id                                                   AS c_invoice_user2_id
FROM
	c_commissionrun cr
		JOIN c_commission c
		ON cr.c_commission_id = c.c_commission_id
		JOIN c_commissionamt ca
		ON cr.c_commissionrun_id = ca.c_commissionrun_id
		JOIN c_commissiondetail cd
		ON ca.c_commissionamt_id = cd.c_commissionamt_id
		LEFT JOIN c_orderline ol
		ON cd.c_orderline_id = ol.c_orderline_id
		LEFT JOIN c_invoiceline il
		ON cd.c_invoiceline_id = il.c_invoiceline_id
		LEFT JOIN c_order o
		ON ol.c_order_id = o.c_order_id
		LEFT JOIN c_invoice i
		ON il.c_invoice_id = i.c_invoice_id;

create or replace view rv_orderdetail(ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, c_order_id, docstatus, docaction, c_doctype_id, isapproved, iscreditapproved, salesrep_id, bill_bpartner_id, bill_location_id, bill_user_id, isdropship, c_bpartner_id, c_bpartner_location_id, ad_user_id, poreference, c_currency_id, issotrx, c_campaign_id, c_project_id, c_activity_id, c_projectphase_id, c_projecttask_id, c_orderline_id, dateordered, datepromised, m_product_id, m_warehouse_id, m_attributesetinstance_id, productattribute, m_attributeset_id, m_lot_id, guaranteedate, lot, serno, c_uom_id, qtyentered, qtyordered, qtyreserved, qtydelivered, qtyinvoiced, priceactual, priceentered, qtytodeliver, qtytoinvoice, netamttoinvoice, qtylostsales, amtlostsales, discount, margin, marginamt, c_order_ad_org_id, c_order_ad_orgtrx_id, amountrefunded, amounttendered, c_order_c_activity_id, c_order_c_bpartner_id, c_order_c_bpartner_loc_id, c_order_c_compaign_id, c_cashline_id, c_cashplanline_id, c_order_c_charge_id, c_conversiontype_id, c_doctypetarget_id, chargeamt, copyfrom, c_payment_id, c_paymentterm_id, c_pos_id, c_order_c_project_id, c_order_created, c_order_createdby, dateacct, c_order_dateordered, dateprinted, c_order_datepromised, deliveryrule, deliveryviarule, c_order_description, documentno, dropship_bpartner_id, dropship_location_id, dropship_user_id, c_order_freightamt, freightcostrule, grandtotal, invoicerule, c_order_isactive, isdelivered, isdiscountprinted, isinvoiced, ispayschedulevalid, isprinted, isselected, isselfservice, istaxincluded, istransferred, link_order_id, m_freightcategory_id, m_pricelist_id, c_order_m_shipper_id, c_order_m_warehouse_id, ordertype, pay_bpartner_id, pay_location_id, paymentrule, posted, priorityrule, c_order_processed, processedon, promotioncode, ref_order_id, sendemail, totallines, c_order_updated, c_order_updatedby, c_order_user1_id, c_order_user2_id, volume, weight, c_orderline_ad_orgtrx_id, c_orderline_c_charge_id, c_orderline_c_currency_id, c_tax_id, datedelivered, dateinvoiced, c_orderline_description, c_orderline_discount, c_orderline_freightamt, isdescription, line, linenetamt, link_orderline_id, m_promotion_id, c_orderline_m_shipper_id, pricecost, pricelimit, pricelist, c_orderline_processed, ref_orderline_id, rramt, rrstartdate, s_resourceassignment_id, c_orderline_user1_id, c_orderline_user2_id, m_asi_ad_org_id, m_asi_created, m_asi_createdby, m_asi_description, m_asi_isactive, m_asi_updated, m_asi_updatedby) as
	SELECT
	l.ad_client_id,
	l.ad_org_id,
	l.isactive,
	l.created,
	l.createdby,
	l.updated,
	l.updatedby,
	o.c_order_id,
	o.docstatus,
	o.docaction,
	o.c_doctype_id,
	o.isapproved,
	o.iscreditapproved,
	o.salesrep_id,
	o.bill_bpartner_id,
	o.bill_location_id,
	o.bill_user_id,
	o.isdropship,
	l.c_bpartner_id,
	l.c_bpartner_location_id,
	o.ad_user_id,
	o.poreference,
	o.c_currency_id,
	o.issotrx,
	l.c_campaign_id,
	l.c_project_id,
	l.c_activity_id,
	l.c_projectphase_id,
	l.c_projecttask_id,
	l.c_orderline_id,
	l.dateordered,
	l.datepromised,
	l.m_product_id,
	l.m_warehouse_id,
	l.m_attributesetinstance_id,
	productattribute(l.m_attributesetinstance_id)  AS productattribute,
	pasi.m_attributeset_id,
	pasi.m_lot_id,
	pasi.guaranteedate,
	pasi.lot,
	pasi.serno,
	l.c_uom_id,
	l.qtyentered,
	l.qtyordered,
	l.qtyreserved,
	l.qtydelivered,
	l.qtyinvoiced,
	l.priceactual,
	l.priceentered,
	l.qtyordered - l.qtydelivered                  AS qtytodeliver,
	l.qtyordered - l.qtyinvoiced                   AS qtytoinvoice,
	(l.qtyordered - l.qtyinvoiced) * l.priceactual AS netamttoinvoice,
	l.qtylostsales,
	l.qtylostsales * l.priceactual                 AS amtlostsales,
	CASE
		WHEN l.pricelist = 0::numeric THEN 0::numeric
		ELSE currencyround((l.pricelist - l.priceactual) / l.pricelist * 100::numeric, o.c_currency_id,
		                   'N'::character varying)
		END                                          AS discount,
	CASE
		WHEN l.pricelimit = 0::numeric THEN 0::numeric
		ELSE currencyround((l.priceactual - l.pricelimit) / l.pricelimit * 100::numeric, o.c_currency_id,
		                   'N'::character varying)
		END                                          AS margin,
	CASE
		WHEN l.pricelimit = 0::numeric THEN 0::numeric
		ELSE (l.priceactual - l.pricelimit) * l.qtydelivered
		END                                          AS marginamt,
	o.ad_org_id                                    AS c_order_ad_org_id,
	o.ad_orgtrx_id                                 AS c_order_ad_orgtrx_id,
	o.amountrefunded,
	o.amounttendered,
	o.c_activity_id                                AS c_order_c_activity_id,
	o.c_bpartner_id                                AS c_order_c_bpartner_id,
	o.c_bpartner_location_id                       AS c_order_c_bpartner_loc_id,
	o.c_campaign_id                                AS c_order_c_compaign_id,
	o.c_cashline_id,
	o.c_cashplanline_id,
	o.c_charge_id                                  AS c_order_c_charge_id,
	o.c_conversiontype_id,
	o.c_doctypetarget_id,
	o.chargeamt,
	o.copyfrom,
	o.c_payment_id,
	o.c_paymentterm_id,
	o.c_pos_id,
	o.c_project_id                                 AS c_order_c_project_id,
	o.created                                      AS c_order_created,
	o.createdby                                    AS c_order_createdby,
	o.dateacct,
	o.dateordered                                  AS c_order_dateordered,
	o.dateprinted,
	o.datepromised                                 AS c_order_datepromised,
	o.deliveryrule,
	o.deliveryviarule,
	o.description                                  AS c_order_description,
	o.documentno,
	o.dropship_bpartner_id,
	o.dropship_location_id,
	o.dropship_user_id,
	o.freightamt                                   AS c_order_freightamt,
	o.freightcostrule,
	o.grandtotal,
	o.invoicerule,
	o.isactive                                     AS c_order_isactive,
	o.isdelivered,
	o.isdiscountprinted,
	o.isinvoiced,
	o.ispayschedulevalid,
	o.isprinted,
	o.isselected,
	o.isselfservice,
	o.istaxincluded,
	o.istransferred,
	o.link_order_id,
	o.m_freightcategory_id,
	o.m_pricelist_id,
	o.m_shipper_id                                 AS c_order_m_shipper_id,
	o.m_warehouse_id                               AS c_order_m_warehouse_id,
	o.ordertype,
	o.pay_bpartner_id,
	o.pay_location_id,
	o.paymentrule,
	o.posted,
	o.priorityrule,
	o.processed                                    AS c_order_processed,
	o.processedon,
	o.promotioncode,
	o.ref_order_id,
	o.sendemail,
	o.totallines,
	o.updated                                      AS c_order_updated,
	o.updatedby                                    AS c_order_updatedby,
	o.user1_id                                     AS c_order_user1_id,
	o.user2_id                                     AS c_order_user2_id,
	o.volume,
	o.weight,
	l.ad_orgtrx_id                                 AS c_orderline_ad_orgtrx_id,
	l.c_charge_id                                  AS c_orderline_c_charge_id,
	l.c_currency_id                                AS c_orderline_c_currency_id,
	l.c_tax_id,
	l.datedelivered,
	l.dateinvoiced,
	l.description                                  AS c_orderline_description,
	l.discount                                     AS c_orderline_discount,
	l.freightamt                                   AS c_orderline_freightamt,
	l.isdescription,
	l.line,
	l.linenetamt,
	l.link_orderline_id,
	l.m_promotion_id,
	l.m_shipper_id                                 AS c_orderline_m_shipper_id,
	l.pricecost,
	l.pricelimit,
	l.pricelist,
	l.processed                                    AS c_orderline_processed,
	l.ref_orderline_id,
	l.rramt,
	l.rrstartdate,
	l.s_resourceassignment_id,
	l.user1_id                                     AS c_orderline_user1_id,
	l.user2_id                                     AS c_orderline_user2_id,
	pasi.ad_org_id                                 AS m_asi_ad_org_id,
	pasi.created                                   AS m_asi_created,
	pasi.createdby                                 AS m_asi_createdby,
	pasi.description                               AS m_asi_description,
	pasi.isactive                                  AS m_asi_isactive,
	pasi.updated                                   AS m_asi_updated,
	pasi.updatedby                                 AS m_asi_updatedby
FROM
	c_order o
		JOIN c_orderline l
		ON o.c_order_id = l.c_order_id
		LEFT JOIN m_attributesetinstance pasi
		ON l.m_attributesetinstance_id = pasi.m_attributesetinstance_id;

ALTER TABLE adempiere.ad_orginfo
	ALTER COLUMN logo_id SET DEFAULT NULL::numeric;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS m_product_bh_hasexpiration_check;

DELETE
FROM
	ad_field
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			ad_table_id IN (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					ad_table_uu IN ('7e9fefed-0d1c-42ea-b144-48fdb9b98b29', '2e0fc0b9-649d-4f9d-b6db-3e336826c757',
					                '287dcd5a-0a5b-4e02-9869-bb1dd6eb6e2d', 'e6073c1d-13b9-419e-a7c2-a8b1faee6806',
					                '21f59b2a-a08f-4ba6-9ba7-118fc9fd4a17')
			)
	);

DELETE
FROM
	ad_indexcolumn
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			ad_table_id IN (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					ad_table_uu IN ('7e9fefed-0d1c-42ea-b144-48fdb9b98b29', '2e0fc0b9-649d-4f9d-b6db-3e336826c757',
					                '287dcd5a-0a5b-4e02-9869-bb1dd6eb6e2d', 'e6073c1d-13b9-419e-a7c2-a8b1faee6806',
					                '21f59b2a-a08f-4ba6-9ba7-118fc9fd4a17')
			)
	);

DELETE
FROM
	ad_column
WHERE
	ad_table_id IN (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			ad_table_uu IN ('7e9fefed-0d1c-42ea-b144-48fdb9b98b29', '2e0fc0b9-649d-4f9d-b6db-3e336826c757',
			                '287dcd5a-0a5b-4e02-9869-bb1dd6eb6e2d', 'e6073c1d-13b9-419e-a7c2-a8b1faee6806',
			                '21f59b2a-a08f-4ba6-9ba7-118fc9fd4a17')
	);

DELETE
FROM
	ad_tab
WHERE
	ad_table_id IN (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			ad_table_uu IN ('7e9fefed-0d1c-42ea-b144-48fdb9b98b29', '2e0fc0b9-649d-4f9d-b6db-3e336826c757',
			                '287dcd5a-0a5b-4e02-9869-bb1dd6eb6e2d', 'e6073c1d-13b9-419e-a7c2-a8b1faee6806',
			                '21f59b2a-a08f-4ba6-9ba7-118fc9fd4a17')
	);

DELETE
FROM
	ad_tableindex
WHERE
	ad_table_id IN (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			ad_table_uu IN ('7e9fefed-0d1c-42ea-b144-48fdb9b98b29', '2e0fc0b9-649d-4f9d-b6db-3e336826c757',
			                '287dcd5a-0a5b-4e02-9869-bb1dd6eb6e2d', 'e6073c1d-13b9-419e-a7c2-a8b1faee6806',
			                '21f59b2a-a08f-4ba6-9ba7-118fc9fd4a17')
	);

DELETE
FROM
	ad_package_exp_detail
WHERE
	ad_table_id IN (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			ad_table_uu IN ('7e9fefed-0d1c-42ea-b144-48fdb9b98b29', '2e0fc0b9-649d-4f9d-b6db-3e336826c757',
			                '287dcd5a-0a5b-4e02-9869-bb1dd6eb6e2d', 'e6073c1d-13b9-419e-a7c2-a8b1faee6806',
			                '21f59b2a-a08f-4ba6-9ba7-118fc9fd4a17')
	);

DELETE
FROM
	ad_viewcolumn
WHERE
	ad_viewcomponent_id IN (
		SELECT
			ad_viewcomponent_id
		FROM
			ad_viewcomponent
		WHERE
			ad_table_id IN (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					ad_table_uu IN ('7e9fefed-0d1c-42ea-b144-48fdb9b98b29', '2e0fc0b9-649d-4f9d-b6db-3e336826c757',
					                '287dcd5a-0a5b-4e02-9869-bb1dd6eb6e2d', 'e6073c1d-13b9-419e-a7c2-a8b1faee6806',
					                '21f59b2a-a08f-4ba6-9ba7-118fc9fd4a17')
			)
	);

DELETE
FROM
	ad_viewcomponent
WHERE
	ad_table_id IN (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			ad_table_uu IN ('7e9fefed-0d1c-42ea-b144-48fdb9b98b29', '2e0fc0b9-649d-4f9d-b6db-3e336826c757',
			                '287dcd5a-0a5b-4e02-9869-bb1dd6eb6e2d', 'e6073c1d-13b9-419e-a7c2-a8b1faee6806',
			                '21f59b2a-a08f-4ba6-9ba7-118fc9fd4a17')
	);

DELETE
FROM
	ad_table
WHERE
	ad_table_uu IN ('7e9fefed-0d1c-42ea-b144-48fdb9b98b29', '2e0fc0b9-649d-4f9d-b6db-3e336826c757',
	                '287dcd5a-0a5b-4e02-9869-bb1dd6eb6e2d', 'e6073c1d-13b9-419e-a7c2-a8b1faee6806',
	                '287dcd5a-0a5b-4e02-9869-bb1dd6eb6e2d', 'e6073c1d-13b9-419e-a7c2-a8b1faee6806',
	                '21f59b2a-a08f-4ba6-9ba7-118fc9fd4a17');

DELETE
FROM
	ad_field
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			ad_column_uu IN ('db345723-36a6-472b-97e1-e4d61dca4717', 'a2c62150-f964-4193-bba4-c8f3093b2305',
			                 '0b471096-b82c-4657-97d9-b5401e549bfa', '6b26a8a9-c8cf-401e-912e-bda69a662021',
			                 '276b2fc7-0655-4a22-b266-682015b0705f', 'aa533e32-6ee6-411c-900b-46f11342d943',
			                 '22ebcef1-a954-4e48-83dc-d6d01c58afa2', 'd2988a56-5580-444b-9433-be0935af6533',
			                 'e81e66c7-91a8-4fb0-8d44-7ea6a5118b68', '7afa65f8-179d-47b0-a212-e9c050518cbb',
			                 '425e0fbc-e2a2-4c61-a8c1-55b89d45faee', '2809e796-6771-402b-bba0-1a0251aa8273',
			                 '5d699b4f-cb2a-4abd-8759-a9afb59a4e95')
	);

DELETE
FROM
	ad_indexcolumn
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			ad_column_uu IN ('db345723-36a6-472b-97e1-e4d61dca4717', 'a2c62150-f964-4193-bba4-c8f3093b2305',
			                 '0b471096-b82c-4657-97d9-b5401e549bfa', '6b26a8a9-c8cf-401e-912e-bda69a662021',
			                 '276b2fc7-0655-4a22-b266-682015b0705f', 'aa533e32-6ee6-411c-900b-46f11342d943',
			                 '22ebcef1-a954-4e48-83dc-d6d01c58afa2', 'd2988a56-5580-444b-9433-be0935af6533',
			                 'e81e66c7-91a8-4fb0-8d44-7ea6a5118b68', '7afa65f8-179d-47b0-a212-e9c050518cbb',
			                 '425e0fbc-e2a2-4c61-a8c1-55b89d45faee', '2809e796-6771-402b-bba0-1a0251aa8273',
			                 '5d699b4f-cb2a-4abd-8759-a9afb59a4e95')
	);

DELETE
FROM
	ad_column
WHERE
	ad_column_uu IN ('db345723-36a6-472b-97e1-e4d61dca4717', 'a2c62150-f964-4193-bba4-c8f3093b2305',
	                 '0b471096-b82c-4657-97d9-b5401e549bfa', '6b26a8a9-c8cf-401e-912e-bda69a662021',
	                 '276b2fc7-0655-4a22-b266-682015b0705f', 'aa533e32-6ee6-411c-900b-46f11342d943',
	                 '22ebcef1-a954-4e48-83dc-d6d01c58afa2', 'd2988a56-5580-444b-9433-be0935af6533',
	                 'e81e66c7-91a8-4fb0-8d44-7ea6a5118b68', '7afa65f8-179d-47b0-a212-e9c050518cbb',
	                 '425e0fbc-e2a2-4c61-a8c1-55b89d45faee', '2809e796-6771-402b-bba0-1a0251aa8273',
	                 '5d699b4f-cb2a-4abd-8759-a9afb59a4e95');

ALTER TABLE c_charge
	DROP CONSTRAINT IF EXISTS c_charge_bh_locked_check;
ALTER TABLE c_charge
	ADD CONSTRAINT c_charge_bh_locked_check
		CHECK (bh_locked = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar]));

ALTER TABLE m_relatedproduct
	DROP CONSTRAINT IF EXISTS m_relatedproduct_pkey;
ALTER TABLE m_relatedproduct
	ADD CONSTRAINT m_relatedproduct_pkey
		PRIMARY KEY (m_product_id, relatedproduct_id, relatedproducttype);

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS baytable_corder;

DROP TABLE IF EXISTS bay_table;

ALTER TABLE c_order
	DROP COLUMN IF EXISTS bay_table_id;

ALTER TABLE m_product
	ALTER COLUMN bh_reorder_level DROP DEFAULT;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS bxsposoutputdevice_mproduct;

ALTER TABLE m_product
	DROP COLUMN IF EXISTS bxs_posoutputdevice_id;

ALTER TABLE c_orderline
	ALTER COLUMN bh_instructions SET DEFAULT NULL::character varying;

ALTER TABLE bh_paymentref
	ALTER COLUMN description SET DEFAULT NULL::character varying;

ALTER TABLE bh_paymentref
	ALTER COLUMN bh_paymentref_action SET DEFAULT NULL::bpchar;

ALTER TABLE bh_paymentref
	ALTER COLUMN bh_paymentref_uu SET DEFAULT NULL::character varying;

ALTER TABLE bh_paymentref_bankacct
	DROP CONSTRAINT IF EXISTS bhpaymentref_bhpaymentrefbanka;
ALTER TABLE bh_paymentref
	DROP CONSTRAINT IF EXISTS bh_paymentref_pkey;
ALTER TABLE bh_paymentref
	DROP CONSTRAINT IF EXISTS bh_paymentref_key;
ALTER TABLE bh_paymentref
	ADD CONSTRAINT bh_paymentref_key
		PRIMARY KEY (bh_paymentref_id);
ALTER TABLE bh_paymentref_bankacct
	ADD CONSTRAINT bhpaymentref_bhpaymentrefbanka
		FOREIGN KEY (bh_paymentref_id) REFERENCES bh_paymentref
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE bh_paymentref_bankacct
	ALTER COLUMN description SET DEFAULT NULL::character varying;

ALTER TABLE bh_paymentref_bankacct
	ALTER COLUMN ad_ref_list_id SET DEFAULT NULL::numeric;

ALTER TABLE bh_paymentref_bankacct
	ALTER COLUMN bh_paymentref_bankacct_uu SET DEFAULT NULL::character varying;

ALTER TABLE bh_paymentref_bankacct
	ALTER COLUMN bh_paymentreflist_value SET DEFAULT NULL::character varying;

ALTER TABLE bh_paymentref_bankacct
	ALTER COLUMN c_bankaccount_id SET DEFAULT NULL::numeric;

ALTER TABLE bh_paymentref_bankacct
	DROP CONSTRAINT IF EXISTS bh_paymentref_bankacct_pkey;

ALTER TABLE bh_paymentref_bankacct
	DROP CONSTRAINT IF EXISTS bh_paymentref_bankacct_key;
ALTER TABLE bh_paymentref_bankacct
	ADD CONSTRAINT bh_paymentref_bankacct_key
		PRIMARY KEY (bh_paymentref_bankacct_id);

ALTER TABLE bh_product_categorydefault
	ALTER COLUMN bh_product_categorydefault_uu SET DEFAULT NULL::character varying;

ALTER TABLE bh_product_categorydefault
	ALTER COLUMN description SET DEFAULT NULL::character varying;

ALTER TABLE bh_product_categorydefault
	DROP CONSTRAINT IF EXISTS bh_product_categorydefault_pkey;

ALTER TABLE bh_product_categorydefault
	DROP CONSTRAINT IF EXISTS bh_product_categorydefault_key;
ALTER TABLE bh_product_categorydefault
	ADD CONSTRAINT bh_product_categorydefault_key
		PRIMARY KEY (bh_product_categorydefault_id);

ALTER TABLE bh_product_categorydefault
	DROP CONSTRAINT IF EXISTS adclient_bhproductcategorydefa;
ALTER TABLE bh_product_categorydefault
	ADD CONSTRAINT adclient_bhproductcategorydefa
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE bh_product_categorydefault
	DROP CONSTRAINT IF EXISTS adorg_bhproductcategorydefault;
ALTER TABLE bh_product_categorydefault
	ADD CONSTRAINT adorg_bhproductcategorydefault
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

DROP TABLE IF EXISTS bxs_deviceregistration;

DROP VIEW IF EXISTS bxs_orginfo;

DROP VIEW IF EXISTS bxs_posinfo;

DROP VIEW IF EXISTS bxs_taxinfo;

ALTER TABLE c_pos
	DROP COLUMN IF EXISTS pin;

ALTER TABLE c_pos
	DROP CONSTRAINT IF EXISTS bxsbptogocashtrx_cpos;

ALTER TABLE c_pos
	DROP COLUMN IF EXISTS bxs_bptogocashtrx_id;

ALTER TABLE c_pos
	DROP CONSTRAINT IF EXISTS bxsposdiscount_cpos;

ALTER TABLE c_pos
	DROP COLUMN IF EXISTS bxs_posdiscount_id;

ALTER TABLE c_pos
	DROP CONSTRAINT IF EXISTS bxspossurcharge_cpos;

ALTER TABLE c_pos
	DROP COLUMN IF EXISTS bxs_possurcharge_id;

ALTER TABLE c_pos
	DROP CONSTRAINT IF EXISTS c_pos_bxs_combineitems_check;

ALTER TABLE c_pos
	DROP COLUMN IF EXISTS bxs_combineitems;

ALTER TABLE c_pos
	DROP CONSTRAINT IF EXISTS c_pos_bxs_printaftersend_check;

ALTER TABLE c_pos
	DROP COLUMN IF EXISTS bxs_printaftersend;

ALTER TABLE c_pos
	DROP CONSTRAINT IF EXISTS c_pos_bxs_separateorderitems_check;

ALTER TABLE c_pos
	DROP COLUMN IF EXISTS bxs_separateorderitems;

ALTER TABLE c_pos
	DROP CONSTRAINT IF EXISTS c_pos_bxs_showguestdialog_check;

ALTER TABLE c_pos
	DROP COLUMN IF EXISTS bxs_showguestdialog;

ALTER TABLE m_product_category
	DROP CONSTRAINT IF EXISTS pos_outputdevice_kbm;

DROP TABLE IF EXISTS bxs_posoutputdevice;

ALTER TABLE m_product_category
	DROP COLUMN IF EXISTS bxs_posoutputdevice_id;

ALTER TABLE m_relatedproduct
	DROP COLUMN IF EXISTS qty;

ALTER TABLE m_relatedproduct
	DROP CONSTRAINT IF EXISTS m_relatedproduct_pkey;

ALTER TABLE m_relatedproduct
	DROP CONSTRAINT IF EXISTS cuom_mrelatedproduct;

ALTER TABLE m_relatedproduct
	DROP COLUMN IF EXISTS c_uom_id;

DROP FUNCTION IF EXISTS get_visit_info(numeric, timestamp, timestamp);

SELECT
	register_migration_script('202403121106_GO-2887.sql')
FROM
	dual;
