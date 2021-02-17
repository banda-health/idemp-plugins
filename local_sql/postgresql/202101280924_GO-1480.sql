-- Create a missed index from before to ensure duplicate included roles can't be assigned to a usertype
create unique index if not exists bh_defaultincludedrole_unique
	on bh_defaultincludedrole (db_usertype, included_role_id);

-- Make the columnname allowance longer
ALTER TABLE ad_element ALTER COLUMN columnname TYPE varchar(100);
UPDATE ad_column SET fieldlength = 100 WHERE ad_column_uu = '7ac4622e-b6a3-4749-a104-3ffbefcda0e0';
ALTER TABLE ad_infocolumn ALTER COLUMN columnname TYPE varchar(100);
UPDATE ad_column SET fieldlength = 100 WHERE ad_column_uu = '67bb6666-3a73-4886-ac95-98d069bff819';

-- Some views depend on columnname, so those have to be dropped and recreated
DROP TABLE IF EXISTS tmp_views;
CREATE TEMP TABLE tmp_views(
	viewname varchar,
	viewscript varchar
);
INSERT INTO tmp_views SELECT 'ad_changelog_v', pg_get_viewdef('ad_changelog_v');
DROP VIEW ad_changelog_v;
INSERT INTO tmp_views SELECT 'ad_field_v', pg_get_viewdef('ad_field_v');
DROP VIEW ad_field_v;
INSERT INTO tmp_views SELECT 'ad_field_vt', pg_get_viewdef('ad_field_vt');
DROP VIEW ad_field_vt;

ALTER TABLE ad_column ALTER COLUMN columnname TYPE varchar(100);
-- Now re-create the views
DO
LANGUAGE plpgsql
$$
DECLARE
  stmt text;
BEGIN
  FOR stmt IN
    SELECT 'CREATE VIEW ' || viewname || ' AS ' || viewscript FROM tmp_views
  LOOP
    EXECUTE stmt;
  END LOOP;
END;
$$;

ALTER TABLE AD_Process_Para ALTER COLUMN columnname TYPE varchar(100);
ALTER TABLE a_registrationattribute ALTER COLUMN columnname TYPE varchar(100);
ALTER TABLE ad_viewcolumn ALTER COLUMN columnname TYPE varchar(100);
ALTER TABLE ws_webservicefieldinput ALTER COLUMN columnname TYPE varchar(100);

-- Create a new table
create table if not exists bh_default_docaction_access
(
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) not null,
	ad_ref_list_id numeric(10) not null,
	bh_default_docaction_access_id numeric(10) not null,
	bh_default_docaction_access_uu varchar(36) default NULL::character varying,
	c_doctype_id numeric(10) not null,
	created timestamp default statement_timestamp() not null,
	createdby numeric(10) not null,
	db_usertype char default NULL::bpchar,
	isactive char not null,
	updated timestamp default statement_timestamp() not null,
	updatedby numeric(10) not null,
	constraint bh_default_docaction_access_key
		primary key (bh_default_docaction_access_id),
	constraint adreflist_bhdefaultdocactionaccess
		foreign key (ad_ref_list_id) references ad_ref_list
			deferrable initially deferred,
	constraint cdoctype_bhdefaultdocactionaccess
		foreign key (c_doctype_id) references c_doctype
			deferrable initially deferred,
	constraint bh_default_docaction_access_isactive_check
		check (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]))
);

-- Insert into AD_Sequence for later updates in the script
INSERT INTO ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited, istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth, isorglevelsequence, orgcolumn) VALUES ((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2021-02-16 10:01:12.079000', 100, '2021-02-16 10:01:12.079000', 100, 'BH_Default_DocAction_Access', 'Table BH_Default_DocAction_Access', null, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', null, null, 'N', null, null, '793dbe66-9def-4cc5-b7ba-73cd54ef1344', 'N', 'N', null)
ON CONFLICT DO NOTHING;

-- Create a constraint to ensure duplicate exclusions can't be assigned to a usertype
create unique index if not exists bh_default_docaction_acces_unique
	on bh_default_docaction_access (db_usertype, c_doctype_id, ad_ref_list_id);

-- Insert doctypes for the system client so it will show up in the default docaction exclusion table
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002303, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Allocation', 'Allocation', null, 'CMA', 'N', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', 'd1e47e07-c8f9-4174-8f6a-9a6841f06ec1', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002304, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'AP CreditMemo', 'Credit Memo', null, 'APC', 'N', null, 'N', null, null, null, 'N', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '3ffade6c-ea6b-4bcb-8a25-c4b441c5f058', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002305, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'AP Invoice', 'Invoice', null, 'API', 'N', null, 'N', null, null, null, 'N', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '3c8cf562-92ed-475b-8d97-411c392006e5', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002306, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'AP Payment', 'Payment', null, 'APP', 'N', null, 'N', null, null, null, 'N', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '003066e0-7314-437f-b791-f78521190786', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002307, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'AR Credit Memo', 'Credit Memo', null, 'ARC', 'Y', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '9a33cd41-b360-46fc-b153-aa920faa9eeb', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002308, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'AR Invoice', 'Invoice', null, 'ARI', 'Y', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '4c3f07c9-6645-4398-b649-0caad134ebe5', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002309, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'AR Invoice Indirect', 'Invoice', null, 'ARI', 'Y', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '1ca773b0-fb3a-46cd-b60e-329c3e53d4e8', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002310, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'AR Pro Forma Invoice', 'AR Pro Forma Invoice', null, 'ARF', 'N', null, 'N', null, null, null, 'N', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', 'd30c7f57-e7b0-443c-bd85-600e0b9622af', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002311, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'AR Receipt', 'Payment', null, 'ARR', 'Y', null, 'N', null, null, null, 'N', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '7413af0b-38b7-4804-a8ed-66cc08a8763f', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002312, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Bank Statement', 'Bank Statement', null, 'CMB', 'N', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '0615d71b-762d-4228-8068-8501a123fa5c', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002313, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Binding offer', 'Quotation', null, 'SOO', 'Y', 'OB', 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '8c12dfd6-d373-4896-85af-fe8a4a0ca4ca', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002314, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Cash Journal', 'Cash Journal', null, 'CMC', 'N', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '5696b359-42c2-4a0e-a054-8fd03a714b59', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002315, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Cost Adjustment', 'Cost Adjustment', null, 'MMI', 'N', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '10d34320-401d-4fd6-b56b-4920438e0f4e', 'N', 'CA') ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002316, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Credit Order', 'Order Confirmation', null, 'SOO', 'Y', 'WI', 'N', null, 0, 0, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '991dc507-fbf2-427f-ad36-c1d655c24454', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002317, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Customer Return Material', 'Customer Return Material Authorization', null, 'SOO', 'Y', 'RM', 'N', null, 0, 0, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '39a30dd9-289b-4442-a072-58bde53f610e', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002318, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Distribution Order', 'Distribution Order', null, 'DOO', 'N', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '895837c7-7df8-4573-af7e-3d5e5a3ece1d', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002319, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Fixed Assets Addition', 'Fixed Assets Addition', null, 'FAA', 'N', null, 'N', null, null, null, 'N', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', 'd613576f-d599-4d02-b783-d7fbe950616d', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002320, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Fixed Assets Depreciation', 'Fixed Assets Depreciation', null, 'FDP', 'N', null, 'N', null, null, null, 'N', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '9764cde0-3403-4a98-afb3-805da788b2ce', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002321, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Fixed Assets Disposal', 'Fixed Assets Disposal', null, 'FAD', 'N', null, 'N', null, null, null, 'N', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '59977074-e81c-40af-9a51-d30c0fde1d9e', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002322, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'GL Document', 'GL Document', null, 'GLD', 'N', null, 'N', null, null, null, 'N', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '2a1d851a-2b3e-41a5-a3cb-a891cab9d58d', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002323, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'GL Journal', 'Journal', null, 'GLJ', 'N', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '39731a56-d18b-46d8-92e2-f4a668ed90c5', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002324, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'GL Journal Batch', 'Journal Batch', null, 'GLJ', 'N', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '1b9ad0ac-243f-4d80-a8bd-af9e7f03c16b', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002325, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Internal Use Inventory', 'Internal Use Inventory', null, 'MMI', 'N', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '62e920ec-34eb-47e0-94be-1167c1deff6e', 'N', 'IU') ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002326, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Maintenance Order', 'Maintenance Order', null, 'MOF', 'N', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '8b9219dc-220e-44fe-aea5-453c3dc1f92d', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002327, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Manufacturing Cost Collector', 'Cost Collector', null, 'MCC', 'N', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '5c7da23f-522a-406d-bc11-3911eb504c6e', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002328, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Manufacturing Order', 'Manufacturing Order', null, 'MOP', 'N', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '14e3363d-904d-44c9-997e-0d61585eec24', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002329, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Match Invoice', 'Match Invoice', null, 'MXI', 'N', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '6f1c999d-5405-4c22-a9be-e281e1c2a2f8', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002330, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Match PO', 'Match PO', null, 'MXP', 'N', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '9d7dcb5f-f15f-4957-93c8-42f238f51225', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002331, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Material Movement', 'Inventory Move', null, 'MMM', 'N', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', 'd0d8de61-a400-443c-8843-56659cc60658', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002332, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Material Production', 'Production', null, 'MMP', 'N', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '179295cd-deef-4b25-a914-302de6387f6e', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002333, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'MM Customer Return', 'Customer Return', null, 'MMR', 'Y', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '7315c59c-e896-435e-8725-f485d4b85d57', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002334, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'MM Receipt', 'Vendor Delivery', null, 'MMR', 'N', null, 'N', null, null, null, 'N', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', 'beda986d-0bc0-4c58-96ef-b76242046d42', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002335, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'MM Shipment', 'Delivery Note', null, 'MMS', 'Y', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', 'fdc36e2c-18d3-4ba9-80d2-9a7d3665af74', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002336, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'MM Shipment Indirect', 'Delivery Note', null, 'MMS', 'Y', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', 'ddc634e7-de79-496e-8ec9-4da1007bb752', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002337, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'MM Vendor Return', 'Vendor Return', null, 'MMS', 'N', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '0e88c32b-b18a-4cf8-9566-fc84f187c325', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002338, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Non binding offer', 'Proposal', null, 'SOO', 'Y', 'ON', 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '434565b1-2f9e-4ad2-b541-2651e624fb5b', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002339, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Payroll', 'Payroll', null, 'HRP', 'N', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '76af4986-1612-4a71-a903-0666d92913d1', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002340, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Physical Inventory', 'Phys.Inventory', null, 'MMI', 'N', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '6905a7ae-7e0a-48b7-842a-42b1acb9d79e', 'N', 'PI') ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002341, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'POS Order', 'Order Confirmation', null, 'SOO', 'Y', 'WR', 'N', null, 0, 0, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '19cee877-be27-43dd-8dfb-21c9ab3c0be4', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002342, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Prepay Order', 'Prepay Order', null, 'SOO', 'Y', 'PR', 'N', null, 0, 0, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', 'e446bcf4-f675-41f6-b67c-1536de4fcfc7', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002343, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Project Issue', 'Project Issue', null, 'PJI', 'N', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '44396b6b-2a6a-4a71-a609-ddaf0834a60e', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002344, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Purchase Order', 'Purchase Order', null, 'POO', 'N', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '9c729e33-2d30-432a-bda0-741dae05ac69', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002345, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Purchase Requisition', 'Requisition', null, 'POR', 'N', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '36c2a57d-4ea7-4684-99c9-c55c46383457', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002346, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Quality Order', 'Quality Order', null, 'MQO', 'N', null, 'N', null, null, null, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '21e474d2-68df-4b05-bec1-0e50bb59edcd', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002347, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Standard Order', 'Order Confirmation', null, 'SOO', 'Y', 'SO', 'N', null, 0, 0, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', 'e9856dd8-84ff-4974-ae95-77c0df48d86e', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002348, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Vendor Return Material', 'Vendor Return Material Authorization', null, 'POO', 'N', 'RM', 'N', null, 0, 0, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', 'b749f2bf-9c07-4ea7-b2bc-810a1d5e1e77', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO c_doctype (c_doctype_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, printname, description, docbasetype, issotrx, docsubtypeso, hasproforma, c_doctypeproforma_id, c_doctypeshipment_id, c_doctypeinvoice_id, isdocnocontrolled, docnosequence_id, gl_category_id, hascharges, documentnote, isdefault, documentcopies, ad_printformat_id, isdefaultcounterdoc, isshipconfirm, ispickqaconfirm, isintransit, issplitwhendifference, c_doctypedifference_id, iscreatecounter, isindexed, isoverwriteseqoncomplete, definitesequence_id, isoverwritedateoncomplete, ispreparesplitdocument, c_doctype_uu, ischargeorproductmandatory, docsubtypeinv) VALUES (1002349, 0, 0, 'Y', '2021-01-28 09:07:00.000000', 100, '2021-01-28 09:07:00.000000', 100, 'Warehouse Order', 'Order Confirmation', null, 'SOO', 'Y', 'WP', 'N', null, 0, 0, 'Y', null, 0, 'N', null, 'N', 0, null, 'N', 'N', 'N', 'N', 'N', null, 'Y', 'Y', 'N', null, 'N', 'Y', '8c398b42-9022-49a7-b1f5-ecca8a2baeeb', 'N', null) ON CONFLICT DO NOTHING;

-- Alter AD_Ref_List so we can run process on our default roles
ALTER TABLE AD_Ref_List ADD IF NOT EXISTS bh_update_existing CHAR(1) DEFAULT NULL;
ALTER TABLE AD_Ref_List ADD IF NOT EXISTS bh_add_all CHAR(1) DEFAULT NULL;

/**********************************************************************************************************/
-- Add a new clinic admin role
/**********************************************************************************************************/
INSERT INTO ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing, bh_add_all) VALUES ((SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), 0, 0, 'Y', '2021-02-16 14:32:38.660042', 0, '2021-02-16 14:32:38.660042', 0, 'B', 'Clinic Admin', 'The Clinic Admin user added to new clients', (SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '5b41f508-5ce5-4b42-80de-713e10580d51'), null, null, 'U', 'cce85e94-ae57-4956-aa68-e41ab1bab123', null, null)
ON CONFLICT DO NOTHING;

-- Add default roles for this new role (same as User)
INSERT INTO bh_defaultincludedrole (bh_defaultincludedrole_id, ad_client_id, ad_org_id, bh_defaultincludedrole_uu, created, createdby, description, isactive, name, updated, updatedby, included_role_id, db_usertype) VALUES ((SELECT MAX(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole), 0, 0, 'ec99283c-4b79-4890-b6fc-cd9c478b4f56', '2021-02-16 14:32:38.660042', 100, null, 'Y', null, '2021-02-16 14:32:38.660042', 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'c5e312b6-b36b-4a89-92c7-653d6238f2b4'), 'B') ON CONFLICT DO NOTHING;
INSERT INTO bh_defaultincludedrole (bh_defaultincludedrole_id, ad_client_id, ad_org_id, bh_defaultincludedrole_uu, created, createdby, description, isactive, name, updated, updatedby, included_role_id, db_usertype) VALUES ((SELECT MAX(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole), 0, 0, 'e0717c1d-379e-4140-8b17-59542589e021', '2021-02-16 14:32:38.660042', 100, null, 'Y', null, '2021-02-16 14:32:38.660042', 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '916f3c6c-840f-491d-9bd7-8f11f34f6868'), 'B') ON CONFLICT DO NOTHING;
INSERT INTO bh_defaultincludedrole (bh_defaultincludedrole_id, ad_client_id, ad_org_id, bh_defaultincludedrole_uu, created, createdby, description, isactive, name, updated, updatedby, included_role_id, db_usertype) VALUES ((SELECT MAX(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole), 0, 0, '7b022fc4-ef97-4c6b-bb92-bd01bfea9c4b', '2021-02-16 14:32:38.660042', 100, null, 'Y', null, '2021-02-16 14:32:38.660042', 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '6c608685-6874-47e1-9c55-06a62f67f340'), 'B') ON CONFLICT DO NOTHING;
INSERT INTO bh_defaultincludedrole (bh_defaultincludedrole_id, ad_client_id, ad_org_id, bh_defaultincludedrole_uu, created, createdby, description, isactive, name, updated, updatedby, included_role_id, db_usertype) VALUES ((SELECT MAX(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole), 0, 0, '8cf70f57-1988-41f3-827e-78576abe3ff8', '2021-02-16 14:32:38.660042', 100, null, 'Y', null, '2021-02-16 14:32:38.660042', 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e0a36cce-cf9f-456b-a431-71bc41285983'), 'B') ON CONFLICT DO NOTHING;
INSERT INTO bh_defaultincludedrole (bh_defaultincludedrole_id, ad_client_id, ad_org_id, bh_defaultincludedrole_uu, created, createdby, description, isactive, name, updated, updatedby, included_role_id, db_usertype) VALUES ((SELECT MAX(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole), 0, 0, '684ca0ab-c42c-4c73-a7a5-362d4b0ffad6', '2021-02-16 14:32:38.660042', 100, null, 'Y', null, '2021-02-16 14:32:38.660042', 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '2b30c5ae-d1a8-426b-bb68-e3b56e69cd56'), 'B') ON CONFLICT DO NOTHING;
INSERT INTO bh_defaultincludedrole (bh_defaultincludedrole_id, ad_client_id, ad_org_id, bh_defaultincludedrole_uu, created, createdby, description, isactive, name, updated, updatedby, included_role_id, db_usertype) VALUES ((SELECT MAX(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole), 0, 0, 'e3680153-4eb4-4020-a036-2f8bf7d16ad6', '2021-02-16 14:32:38.660042', 100, null, 'Y', null, '2021-02-16 14:32:38.660042', 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'dc551b49-c648-4a70-8385-9d25971e3891'), 'B') ON CONFLICT DO NOTHING;
INSERT INTO bh_defaultincludedrole (bh_defaultincludedrole_id, ad_client_id, ad_org_id, bh_defaultincludedrole_uu, created, createdby, description, isactive, name, updated, updatedby, included_role_id, db_usertype) VALUES ((SELECT MAX(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole), 0, 0, '37695e1c-b767-494a-a762-ad573a9bbbcc', '2021-02-16 14:32:38.660042', 100, null, 'Y', null, '2021-02-16 14:32:38.660042', 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'df33be5f-37c8-4fff-a2f7-bd7ddd6aa453'), 'B') ON CONFLICT DO NOTHING;
INSERT INTO bh_defaultincludedrole (bh_defaultincludedrole_id, ad_client_id, ad_org_id, bh_defaultincludedrole_uu, created, createdby, description, isactive, name, updated, updatedby, included_role_id, db_usertype) VALUES ((SELECT MAX(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole), 0, 0, '1d3d41e9-49a2-4b6f-93d0-b537410b64a7', '2021-02-16 14:32:38.660042', 100, null, 'Y', null, '2021-02-16 14:32:38.660042', 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'f1baf359-ee08-4865-8b66-a662d4941c02'), 'B') ON CONFLICT DO NOTHING;
INSERT INTO bh_defaultincludedrole (bh_defaultincludedrole_id, ad_client_id, ad_org_id, bh_defaultincludedrole_uu, created, createdby, description, isactive, name, updated, updatedby, included_role_id, db_usertype) VALUES ((SELECT MAX(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole), 0, 0, '1a112243-5f14-4d96-b953-7324283e11dd', '2021-02-16 14:32:38.660042', 100, null, 'Y', null, '2021-02-16 14:32:38.660042', 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '25803a32-914b-4e6d-9a69-46b369ad672a'), 'B') ON CONFLICT DO NOTHING;
INSERT INTO bh_defaultincludedrole (bh_defaultincludedrole_id, ad_client_id, ad_org_id, bh_defaultincludedrole_uu, created, createdby, description, isactive, name, updated, updatedby, included_role_id, db_usertype) VALUES ((SELECT MAX(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole), 0, 0, '088a1f5a-442c-4926-940e-eb96deaa9cca', '2021-02-16 14:32:38.660042', 100, null, 'Y', null, '2021-02-16 14:32:38.660042', 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '47fce734-fe3d-457d-8a5a-afa611c79901'), 'B') ON CONFLICT DO NOTHING;
INSERT INTO bh_defaultincludedrole (bh_defaultincludedrole_id, ad_client_id, ad_org_id, bh_defaultincludedrole_uu, created, createdby, description, isactive, name, updated, updatedby, included_role_id, db_usertype) VALUES ((SELECT MAX(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole), 0, 0, 'd08c1caf-baef-4b43-b3fc-9a64071485fd', '2021-02-16 14:32:38.660042', 100, null, 'Y', null, '2021-02-16 14:32:38.660042', 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '230f6995-5e04-40d3-b074-5c625f440dba'), 'B') ON CONFLICT DO NOTHING;
INSERT INTO bh_defaultincludedrole (bh_defaultincludedrole_id, ad_client_id, ad_org_id, bh_defaultincludedrole_uu, created, createdby, description, isactive, name, updated, updatedby, included_role_id, db_usertype) VALUES ((SELECT MAX(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole), 0, 0, 'e6d7b2cb-062b-4b1f-a31c-fbec25e13394', '2021-02-16 14:32:38.660042', 100, null, 'Y', null, '2021-02-16 14:32:38.660042', 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '4ad013e1-aba9-48e4-b173-7eb3e2e3179d'), 'B') ON CONFLICT DO NOTHING;
INSERT INTO bh_defaultincludedrole (bh_defaultincludedrole_id, ad_client_id, ad_org_id, bh_defaultincludedrole_uu, created, createdby, description, isactive, name, updated, updatedby, included_role_id, db_usertype) VALUES ((SELECT MAX(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole), 0, 0, 'db883e2e-6b60-4db9-a022-4023548e4caf', '2021-02-16 14:32:38.660042', 100, null, 'Y', null, '2021-02-16 14:32:38.660042', 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'af9724a3-0d47-4272-ba35-30b7b7f9889c'), 'B') ON CONFLICT DO NOTHING;
INSERT INTO bh_defaultincludedrole (bh_defaultincludedrole_id, ad_client_id, ad_org_id, bh_defaultincludedrole_uu, created, createdby, description, isactive, name, updated, updatedby, included_role_id, db_usertype) VALUES ((SELECT MAX(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole), 0, 0, 'e8fad0f8-9c8e-4b30-9393-36f6a1b728cd', '2021-02-16 14:32:38.660042', 100, null, 'Y', null, '2021-02-16 14:32:38.660042', 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'f8b48d40-da8d-4296-9943-1efefdf9b56e'), 'B') ON CONFLICT DO NOTHING;
INSERT INTO bh_defaultincludedrole (bh_defaultincludedrole_id, ad_client_id, ad_org_id, bh_defaultincludedrole_uu, created, createdby, description, isactive, name, updated, updatedby, included_role_id, db_usertype) VALUES ((SELECT MAX(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole), 0, 0, '71ad1373-e903-48fc-868a-3bdbb899fae7', '2021-02-16 14:32:38.660042', 100, null, 'Y', null, '2021-02-16 14:32:38.660042', 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e2689920-5ef3-4479-9b45-964344ec24c0'), 'B') ON CONFLICT DO NOTHING;
INSERT INTO bh_defaultincludedrole (bh_defaultincludedrole_id, ad_client_id, ad_org_id, bh_defaultincludedrole_uu, created, createdby, description, isactive, name, updated, updatedby, included_role_id, db_usertype) VALUES ((SELECT MAX(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole), 0, 0, '822e910b-3d34-49aa-b8c8-b60a3ed2250f', '2021-02-16 14:32:38.660042', 100, null, 'Y', null, '2021-02-16 14:32:38.660042', 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '613afe7e-8699-4e6e-80e5-c3bd8fcb1060'), 'B') ON CONFLICT DO NOTHING;
INSERT INTO bh_defaultincludedrole (bh_defaultincludedrole_id, ad_client_id, ad_org_id, bh_defaultincludedrole_uu, created, createdby, description, isactive, name, updated, updatedby, included_role_id, db_usertype) VALUES ((SELECT MAX(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole), 0, 0, 'dc1d5f8f-1b2c-48fa-9550-3528401a3920', '2021-02-16 14:32:38.660042', 100, null, 'Y', null, '2021-02-16 14:32:38.660042', 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'df670872-7a83-4a6d-9a99-c37d7c7d7e02'), 'B') ON CONFLICT DO NOTHING;
INSERT INTO bh_defaultincludedrole (bh_defaultincludedrole_id, ad_client_id, ad_org_id, bh_defaultincludedrole_uu, created, createdby, description, isactive, name, updated, updatedby, included_role_id, db_usertype) VALUES ((SELECT MAX(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole), 0, 0, 'c3ec345a-b183-4b6d-9931-7ad38af4f735', '2021-02-16 14:32:38.660042', 100, null, 'Y', null, '2021-02-16 14:32:38.660042', 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '67acc92d-8bdc-4012-bfcc-4f57f8e48e30'), 'B') ON CONFLICT DO NOTHING;
INSERT INTO bh_defaultincludedrole (bh_defaultincludedrole_id, ad_client_id, ad_org_id, bh_defaultincludedrole_uu, created, createdby, description, isactive, name, updated, updatedby, included_role_id, db_usertype) VALUES ((SELECT MAX(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole), 0, 0, '27f3aea4-c6f2-486a-9c07-4025b3b04b09', '2021-02-16 14:32:38.660042', 100, null, 'Y', null, '2021-02-16 14:32:38.660042', 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '69ee8cf1-cdcf-4880-a79b-2005b8591b0d'), 'B') ON CONFLICT DO NOTHING;
INSERT INTO bh_defaultincludedrole (bh_defaultincludedrole_id, ad_client_id, ad_org_id, bh_defaultincludedrole_uu, created, createdby, description, isactive, name, updated, updatedby, included_role_id, db_usertype) VALUES ((SELECT MAX(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole), 0, 0, '3fbe4cad-155d-451d-9c77-2e99f4b61ea5', '2021-02-16 14:32:38.660042', 100, null, 'Y', null, '2021-02-16 14:32:38.660042', 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'f24e4e10-9c58-40dd-addd-b74d545540b7'), 'B') ON CONFLICT DO NOTHING;
INSERT INTO bh_defaultincludedrole (bh_defaultincludedrole_id, ad_client_id, ad_org_id, bh_defaultincludedrole_uu, created, createdby, description, isactive, name, updated, updatedby, included_role_id, db_usertype) VALUES ((SELECT MAX(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole), 0, 0, '97a84269-e3b2-46de-a82f-6d115d9cae6c', '2021-02-16 14:32:38.660042', 100, null, 'Y', null, '2021-02-16 14:32:38.660042', 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '66121f24-3aba-4204-8388-c3ced006ad49'), 'B') ON CONFLICT DO NOTHING;
INSERT INTO bh_defaultincludedrole (bh_defaultincludedrole_id, ad_client_id, ad_org_id, bh_defaultincludedrole_uu, created, createdby, description, isactive, name, updated, updatedby, included_role_id, db_usertype) VALUES ((SELECT MAX(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole), 0, 0, 'b77a888b-5289-4b85-8e0b-f97f9c11f4aa', '2021-02-16 14:32:38.660042', 100, null, 'Y', null, '2021-02-16 14:32:38.660042', 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'f06c27e5-a4b9-4803-8b04-ebbe494d6fa1'), 'B') ON CONFLICT DO NOTHING;

-- Insert default access all roles, then remove it from those that don't need it
DROP TABLE IF EXISTS tmp_def_docaction_access;
CREATE TEMP TABLE tmp_def_docaction_access
(
	ad_client_id numeric(10) not null DEFAULT 0,
	ad_org_id numeric(10) not null DEFAULT 0,
	ad_ref_list_id numeric(10) not null,
	bh_default_docaction_access_id serial not null,
	bh_default_docaction_access_uu uuid default uuid_generate_v4(), -- we don't mind UUIDs being different for these entities
	c_doctype_id numeric(10) not null,
	created timestamp default statement_timestamp() not null,
	createdby numeric(10) not null default 100,
	db_usertype char not null,
	isactive char not null default 'Y',
	updated timestamp default statement_timestamp() not null,
	updatedby numeric(10) not null default 100
);

SELECT setval(
	'tmp_def_docaction_access_bh_default_docaction_access_id_seq',
	1000000,
	false
);

INSERT INTO tmp_def_docaction_access (
	ad_ref_list_id,
	c_doctype_id,
	db_usertype
)
SELECT
	rl.ad_ref_list_id,
	dt.c_doctype_id,
	ut.value
FROM (
	SELECT value FROM ad_ref_list WHERE ad_reference_id = (SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '5b41f508-5ce5-4b42-80de-713e10580d51')
) ut
CROSS JOIN (
	SELECT ad_ref_list_id FROM ad_ref_list WHERE ad_reference_id = 135
) rl
CROSS JOIN (
	SELECT c_doctype_id FROM c_doctype WHERE ad_client_id = 0 AND c_doctype_id > 0
) dt;

INSERT INTO bh_default_docaction_access (
	ad_client_id,
	ad_org_id,
	ad_ref_list_id,
	bh_default_docaction_access_id,
	bh_default_docaction_access_uu,
	c_doctype_id,
	created,
	createdby,
	db_usertype,
	isactive,
	updated,
	updatedby
)
SELECT
	ad_client_id,
	ad_org_id,
	ad_ref_list_id,
	bh_default_docaction_access_id,
	bh_default_docaction_access_uu,
	c_doctype_id,
	created,
	createdby,
	db_usertype,
	isactive,
	updated,
	updatedby
FROM tmp_def_docaction_access
ON CONFLICT DO NOTHING;

UPDATE ad_sequence
SET currentnext = (SELECT MAX(bh_default_docaction_access_id) + 1 FROM bh_default_docaction_access)
WHERE name = 'BH_Default_DocAction_Access';

/**********************************************************************************************************/
-- Remove document access for certain users
/**********************************************************************************************************/
-- Remove the Void, Reverse-Accrue, and Reverse-Correct actions for everyone not an admin or clinic admin
DELETE FROM bh_default_docaction_access
WHERE c_doctype_id IN (SELECT c_doctype_id FROM c_doctype WHERE ad_client_id = 0 AND docbasetype IN ('API','SOO','POO','ARR'))
	AND ad_ref_list_id IN (SELECT ad_ref_list_id FROM ad_ref_list WHERE ad_ref_list_uu IN ('930f9be7-85bc-4002-83a6-fe4e1b8cfce3','1a3904b9-86bc-4831-a4af-0281dcafa8f8','597e3e98-f1cd-4157-885a-1fae6424a3a6'))
	AND db_usertype NOT IN ('A', 'B');

/**********************************************************************************************************/
-- Update existing users to be assigned the new clinic admin role
/**********************************************************************************************************/
-- Create the new role
DROP TABLE IF EXISTS tmp_ad_role;
CREATE TEMP TABLE tmp_ad_role
(
	ad_role_id serial not null,
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) not null,
	isactive char default 'Y'::bpchar not null,
	created timestamp default now() not null,
	createdby numeric(10) not null,
	updated timestamp default now() not null,
	name varchar(60) not null,
	updatedby numeric(10) not null,
	description varchar(255),
	userlevel char(3) default '  O'::bpchar not null,
	c_currency_id numeric(10),
	amtapproval numeric default 0,
	ad_tree_menu_id numeric(10),
	ismanual char default 'Y'::bpchar not null,
	isshowacct char default 'Y'::bpchar not null,
	ispersonallock char default 'N'::bpchar not null,
	ispersonalaccess char default 'N'::bpchar not null,
	iscanexport char default 'Y'::bpchar not null,
	iscanreport char default 'Y'::bpchar not null,
	supervisor_id numeric(10),
	iscanapproveowndoc char default 'Y'::bpchar not null,
	isaccessallorgs char default 'N'::bpchar not null,
	ischangelog char default 'N'::bpchar not null,
	preferencetype char default 'C'::bpchar not null,
	overwritepricelimit char default 'N'::bpchar not null,
	isuseuserorgaccess char default 'N'::bpchar not null,
	ad_tree_org_id numeric(10),
	confirmqueryrecords numeric(10) default 0 not null,
	maxqueryrecords numeric(10) default 0 not null,
	connectionprofile char,
	allow_info_account char default 'Y'::bpchar not null,
	allow_info_asset char default 'Y'::bpchar not null,
	allow_info_bpartner char default 'Y'::bpchar not null,
	allow_info_cashjournal char default 'N'::bpchar not null,
	allow_info_inout char default 'Y'::bpchar not null,
	allow_info_invoice char default 'Y'::bpchar not null,
	allow_info_order char default 'Y'::bpchar not null,
	allow_info_payment char default 'Y'::bpchar not null,
	allow_info_product char default 'Y'::bpchar not null,
	allow_info_resource char default 'Y'::bpchar not null,
	allow_info_schedule char default 'Y'::bpchar not null,
	userdiscount numeric(22,2),
	allow_info_mrp char default 'N'::bpchar not null,
	allow_info_crp char default 'N'::bpchar not null,
	isdiscountuptolimitprice char default 'N'::bpchar not null,
	isdiscountallowedontotal char default 'N'::bpchar not null,
	amtapprovalaccum numeric,
	daysapprovalaccum numeric(10),
	ad_role_uu uuid NOT NULL DEFAULT uuid_generate_v4(),
	ismenuautoexpand char default 'N'::bpchar not null,
	ismasterrole char default 'N'::bpchar not null,
	isaccessadvanced char default 'N'::bpchar,
	roletype varchar(2) default NULL::character varying
);

SELECT setval(
	'tmp_ad_role_ad_role_id_seq',
	(
		SELECT currentnext
		FROM ad_sequence
		WHERE name = 'AD_Role'
		LIMIT 1
	)::INT,
	false
);

INSERT INTO tmp_ad_role (ad_client_id, ad_org_id, isactive, createdby, name, updatedby, description, userlevel, c_currency_id, amtapproval, ad_tree_menu_id, ismanual, isshowacct, ispersonallock, ispersonalaccess, iscanexport, iscanreport, supervisor_id, iscanapproveowndoc, isaccessallorgs, ischangelog, preferencetype, overwritepricelimit, isuseuserorgaccess, ad_tree_org_id, confirmqueryrecords, maxqueryrecords, connectionprofile, allow_info_account, allow_info_asset, allow_info_bpartner, allow_info_cashjournal, allow_info_inout, allow_info_invoice, allow_info_order, allow_info_payment, allow_info_product, allow_info_resource, allow_info_schedule, userdiscount, allow_info_mrp, allow_info_crp, isdiscountuptolimitprice, isdiscountallowedontotal, amtapprovalaccum, daysapprovalaccum, ad_role_uu, ismenuautoexpand, ismasterrole, isaccessadvanced, roletype)
SELECT ad_client_id, 0, 'Y', 100, name || ' Clinic Admin', 100, null, '  O', null, 0, null, 'N', 'N', 'N', 'N', 'Y', 'Y', null, 'Y', 'N', 'N', 'O', 'N', 'N', null, 0, 0, null, 'Y', 'Y', 'Y', 'N', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', null, 'N', 'N', 'N', 'N', null, null, uuid_generate_v4(), 'N', 'N', 'N', null
FROM ad_client
WHERE ad_client_id > 999999;

INSERT INTO ad_role (ad_role_id, ad_client_id, ad_org_id, isactive, createdby, name, updatedby, description, userlevel, c_currency_id, amtapproval, ad_tree_menu_id, ismanual, isshowacct, ispersonallock, ispersonalaccess, iscanexport, iscanreport, supervisor_id, iscanapproveowndoc, isaccessallorgs, ischangelog, preferencetype, overwritepricelimit, isuseuserorgaccess, ad_tree_org_id, confirmqueryrecords, maxqueryrecords, connectionprofile, allow_info_account, allow_info_asset, allow_info_bpartner, allow_info_cashjournal, allow_info_inout, allow_info_invoice, allow_info_order, allow_info_payment, allow_info_product, allow_info_resource, allow_info_schedule, userdiscount, allow_info_mrp, allow_info_crp, isdiscountuptolimitprice, isdiscountallowedontotal, amtapprovalaccum, daysapprovalaccum, ad_role_uu, ismenuautoexpand, ismasterrole, isaccessadvanced, roletype)
SELECT ad_role_id, ad_client_id, ad_org_id, isactive, createdby, name, updatedby, description, userlevel, c_currency_id, amtapproval, ad_tree_menu_id, ismanual, isshowacct, ispersonallock, ispersonalaccess, iscanexport, iscanreport, supervisor_id, iscanapproveowndoc, isaccessallorgs, ischangelog, preferencetype, overwritepricelimit, isuseuserorgaccess, ad_tree_org_id, confirmqueryrecords, maxqueryrecords, connectionprofile, allow_info_account, allow_info_asset, allow_info_bpartner, allow_info_cashjournal, allow_info_inout, allow_info_invoice, allow_info_order, allow_info_payment, allow_info_product, allow_info_resource, allow_info_schedule, userdiscount, allow_info_mrp, allow_info_crp, isdiscountuptolimitprice, isdiscountallowedontotal, amtapprovalaccum, daysapprovalaccum, ad_role_uu, ismenuautoexpand, ismasterrole, isaccessadvanced, roletype
FROM tmp_ad_role;

UPDATE ad_sequence
SET currentnext = nextval('tmp_ad_role_ad_role_id_seq')
WHERE name = 'AD_Role';

-- Next, update the roles to have the same access to orgs as the normal user roles do
INSERT INTO ad_role_orgaccess (ad_role_id, ad_org_id, ad_client_id, isactive, createdby, updatedby, isreadonly, ad_role_orgaccess_uu)
SELECT tar.ad_role_id, tar.ad_client_id, ao.ad_org_id, 'Y', 100, 100, 'N', uuid_generate_v4()
FROM tmp_ad_role tar
JOIN ad_org ao
	ON ao.ad_client_id = tar.ad_client_id;

/**********************************************************************************************************/
-- Configure default included roles for all roles
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_client_roles;
CREATE TEMP TABLE tmp_client_roles (
	ad_client_id numeric(10),
	ad_role_id numeric(10),
	db_usertype char(1)
);

INSERT INTO tmp_client_roles (
	ad_client_id,
	ad_role_id,
	db_usertype
)
SELECT
	c.ad_client_id,
	r.ad_role_id,
	rl.value
FROM ad_client c
JOIN ad_reference ref
	ON ref.ad_reference_uu = '5b41f508-5ce5-4b42-80de-713e10580d51'
JOIN ad_ref_list rl
	ON ref.ad_reference_id = rl.ad_reference_id
JOIN ad_role r
	ON c.ad_client_id = r.ad_client_id
		AND r.name = c.name || ' ' || rl.name
WHERE c.ad_client_id > 999999;

-- Remove included roles that shouldn't be there
DELETE FROM ad_role_included ri
USING tmp_client_roles tcr
WHERE included_role_id NOT IN (
	SELECT dir.included_role_id
	FROM bh_defaultincludedrole dir
	WHERE dir.db_usertype = tcr.db_usertype
)
	AND ri.ad_role_id = tcr.ad_role_id;

-- Add included roles that should be there
INSERT INTO ad_role_included (ad_client_id, ad_org_id, ad_role_id, created, createdby, included_role_id, isactive, seqno, updated, updatedby, ad_role_included_uu)
SELECT tcr.ad_client_id, 0, tcr.ad_role_id, '2021-02-16 10:01:12.079000', 100, dir.included_role_id, 'Y', 10, '2021-02-16 10:01:12.079000', 100, uuid_generate_v4()
FROM tmp_client_roles tcr
JOIN bh_defaultincludedrole dir
	ON dir.db_usertype = tcr.db_usertype
WHERE dir.included_role_id NOT IN (
	SELECT ri.included_role_id
	FROM ad_role_included ri
	WHERE ri.ad_role_id = tcr.ad_role_id
);

/**********************************************************************************************************/
-- Configure document access for all roles
/**********************************************************************************************************/
-- Remove access that shouldn't be there
DELETE FROM ad_document_action_access daa
USING tmp_client_roles tcr
WHERE ad_ref_list_id NOT IN (
	SELECT ddaa.ad_ref_list_id
	FROM bh_default_docaction_access ddaa
	WHERE ddaa.db_usertype = tcr.db_usertype
		AND daa.c_doctype_id = ddaa.c_doctype_id
)
	AND tcr.ad_role_id = daa.ad_role_id;

-- Add access that should be there
INSERT INTO ad_document_action_access (ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, c_doctype_id, ad_role_id, ad_ref_list_id, ad_document_action_access_uu)
SELECT tcr.ad_client_id, 0, 'Y', '2021-02-16 10:01:12.079000', 100, '2021-02-16 10:01:12.079000', 100, ddaa.c_doctype_id, tcr.ad_role_id, ddaa.ad_ref_list_id, uuid_generate_v4()
FROM tmp_client_roles tcr
JOIN bh_default_docaction_access ddaa
	ON tcr.db_usertype = ddaa.db_usertype
WHERE ddaa.ad_ref_list_id NOT IN (
	SELECT daa.ad_ref_list_id
	FROM ad_document_action_access daa
	WHERE tcr.ad_role_id = daa.ad_role_id
		AND daa.c_doctype_id = ddaa.c_doctype_id
);

/**********************************************************************************************************/
-- Update the users to have the new roles
/**********************************************************************************************************/
UPDATE ad_user_roles aur
SET ad_role_id = r.ad_role_id
FROM ad_user u
JOIN ad_client c
	ON u.ad_client_id = c.ad_client_id
JOIN tmp_ad_role r
	ON r.ad_client_id = c.ad_client_id
WHERE u.ad_user_id = aur.ad_user_id
	AND u.ad_user_uu IN ('351b225c-6157-4067-95b3-56e7372228bf','bb578702-0c0f-4dcf-a5cc-dec9886269fd','46acac88-de0c-4314-aafd-9ab166dc57db','859a00fc-42d2-4bee-b245-f7f37d8db3bf','244e7d6a-3257-466a-bb1d-52711ffe64cb','dfd02503-5aeb-41f5-870b-cd101598bff9','ae906ee6-c9d4-42f8-abd9-20a859bef8fa','d72b9b1d-db2b-4842-bc6c-221de3638dba','972a43e4-0a80-4cd0-8370-7dadabb53911','50ad516d-26d9-4417-841c-906cf1677f60','36ed5160-4515-4b3a-ae18-2155929a31ee','d10438e3-0a28-4a0e-8efb-c08af32bf173','1b0307a9-b443-42a4-9d47-6eccc4b7b381','1321641b-2103-4e18-8ae5-bbe272aaf4ab','6569a760-03da-4bf4-b8fb-315f8625751c','0d3e9c48-a177-42ce-9329-6fa840e3f218','ea24de12-9c31-4d68-a6ed-43107f96d926','120c4471-35f0-4d52-adc3-b0f8cf5c539b','8bc9169e-17d5-4dab-825b-ef70dcd6720f','23743daf-6e51-4bd0-8d89-49e9e714f701','19a2fe63-9e65-4edc-9088-08ccd0326a5e','a253f671-4ec2-4b04-8025-acdd477025c8','94345ac5-0b66-4804-ba1c-53d4cfaab32f','70c2697d-e764-4c74-8aa8-537300ed0042','f3096a75-bb12-44c9-9757-a2a70ee89704','c847c696-0922-4330-8727-9737c7a90b95','8bcd874f-78b2-4774-a653-0569c5c575b0','d333fe20-f7be-44b1-b00d-7c1108f1a386','d5359358-eabf-4edd-ab4f-e41bc2522672','d9fc3de2-d959-4f4b-ba2b-341fbaf91ef2','b34dc592-14ce-4eac-bc3d-3c6de9d6e175','21cde7fa-eede-4302-8631-55bbd6264cf6','2d6b2be1-4a04-450a-9100-ede26a7310c9','2c88a206-5cb6-4d68-842e-6e0969c2fe92');

/**********************************************************************************************************/
-- Add the new clinic admin role to all current admin users
/**********************************************************************************************************/
INSERT INTO ad_user_roles (ad_user_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ad_user_roles_uu)
SELECT aur.ad_user_id, clinicadminrole.ad_role_id, aur.ad_client_id, aur.ad_org_id, 'Y', '2021-02-16 10:01:12.079000', 100, '2021-02-16 10:01:12.079000', 100, uuid_generate_v4()
FROM ad_user_roles aur
JOIN ad_role adminrole
	ON adminrole.ad_role_id = aur.ad_role_id
JOIN ad_client c
	ON c.ad_client_id = adminrole.ad_client_id
JOIN ad_role clinicadminrole
	ON clinicadminrole.name = c.name || ' Clinic Admin'
WHERE adminrole.name = c.name || ' Admin';

-- Clean up
DROP TABLE tmp_def_docaction_access;
DROP TABLE tmp_client_roles;
DROP TABLE tmp_views;
DROP TABLE tmp_ad_role;

SELECT register_migration_script('202101280924_GO-1480.sql') FROM dual;
