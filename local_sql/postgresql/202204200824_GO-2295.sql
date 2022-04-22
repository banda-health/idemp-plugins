/**********************************************************************************************************/
-- Purpose of script:
-- We need to add new Attribute Sets to all clients, plus update existing ones. We'll use the bh_hasexpiration
-- field as our guide.

-- Process:
-- 1. Add the locked columns to serial number control and attribute set to hold our defaults
-- 2. Add serial controls to all clients, including the configuration one.
-- 3. Add new Attribute Sets to all clients, including the configuration one (and also add exclusions).
-- 4. Add the existing Attribute Set that should be present on all clients to any clients that don't have it.
-- 5. Rename the attribute set, plus add the serial control to it.
-- 6. Update products that don't expire to point to the new attribute set, and all products that do expire to point
--		to the correct attribute set (they should already, but just in case)
-- 7. Update all data in the system to now have a serial # (they'll all share the same less than the control's start)
/**********************************************************************************************************/

/**********************************************************************************************************/
-- 1. Add the locked columns to serial number control and attribute set to hold our defaults
/**********************************************************************************************************/
ALTER TABLE M_SerNoCtl ADD IF NOT EXISTS BH_Locked CHAR(1) DEFAULT 'N' CHECK (BH_Locked IN ('Y','N'));
ALTER TABLE M_AttributeSet ADD IF NOT EXISTS BH_Locked CHAR(1) DEFAULT 'N' CHECK (BH_Locked IN ('Y','N'));

INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder) VALUES ((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2022-04-22 05:09:15.211000', '2022-04-22 05:09:15.211000', 100, 100, 'BH_Locked', 'Determines whether a record is locked or not (must configure each field to enabled/disabled to read from this field)', null, 0, 'U', 'BH_Locked', 555, 20, null, null, 1, null, 'N', 'N', 'N', 'Y', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', 1000144, null, 'N', 'N', null, null, null, 'N', 'Y', null, '8dbe2d3c-9101-4ec0-9a72-ae080a63e67b', 'Y', 0, 'N', 'N', null, null, 'N', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder) VALUES ((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2022-04-22 05:10:12.706000', '2022-04-22 05:10:12.706000', 100, 100, 'BH_Locked', 'Determines whether a record is locked or not (must configure each field to enabled/disabled to read from this field)', null, 0, 'U', 'BH_Locked', 560, 20, null, null, 1, null, 'N', 'N', 'N', 'Y', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', 1000144, null, 'N', 'N', null, null, null, 'N', 'Y', null, '51c0f596-28f0-4f9b-847e-5ae897137e16', 'Y', 0, 'N', 'N', null, null, 'N', null, null) ON CONFLICT DO NOTHING;

/**********************************************************************************************************/
-- 2. Add serial controls to the clients
/**********************************************************************************************************/
CREATE TEMP TABLE if not exists tmp_ad_client_ids (
	ad_client_id numeric(10) not null
);
-- The columns commented here are being left so we know which ones have defaults set in the DB that don't need to overridden
create temp table if not exists tmp_m_sernoctl
(
	m_sernoctl_id serial not null,
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) default 0 not null,
	-- isactive char default 'Y'::bpchar not null,
	-- created timestamp default now() not null,
	updatedby numeric(10) default 100 not null,
	name varchar(60) default 'Default Serial Counter' not null,
	description varchar(255),
	startno numeric(10) default 100 not null,
	incrementno numeric(10) default 1 not null,
	currentnext numeric(10) default 101 not null, -- we'll add serial number 100 to all currently-existing data to the system
	prefix varchar(10),
	suffix varchar(10),
	createdby numeric(10) default 100 not null,
	-- updated timestamp default now() not null,
	m_sernoctl_uu uuid default uuid_generate_v4(),
	bh_locked varchar(1) default 'Y' not null
);

-- Update the serial sequences
SELECT setval(
	'tmp_m_sernoctl_m_sernoctl_id_seq',
	(
		SELECT currentnext
		FROM ad_sequence
		WHERE lower(name) = 'm_sernoctl'
		LIMIT 1
	)::INT,
	false
);

-- First, add the clients we'll be working with
INSERT INTO tmp_ad_client_ids (
	ad_client_id
)
SELECT
	ad_client_id
FROM ad_client
WHERE ad_client_id > 999999 OR ad_client_id = 2;

INSERT INTO tmp_m_sernoctl (
	ad_client_id
)
SELECT ad_client_id FROM tmp_ad_client_ids;

-- Now do the DB inserts
INSERT INTO m_sernoctl (
	m_sernoctl_id,
	ad_client_id,
	ad_org_id,
	updatedby,
	name,
	description,
	startno,
	incrementno,
	currentnext,
	prefix,
	suffix,
	createdby,
	m_sernoctl_uu,
	bh_locked
)
SELECT
	m_sernoctl_id,
	ad_client_id,
	ad_org_id,
	updatedby,
	name,
	description,
	startno,
	incrementno,
	currentnext,
	prefix,
	suffix,
	createdby,
	m_sernoctl_uu,
	bh_locked
FROM tmp_m_sernoctl;

/**********************************************************************************************************/
-- 3. Add new attribute sets for all clients to handle products that don't expire
/**********************************************************************************************************/
create temp table if not exists tmp_m_attributeset
(
	m_attributeset_id serial not null,
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) default 0 not null,
	-- isactive char default 'Y'::bpchar not null,
	-- created timestamp default now() not null,
	createdby numeric(10) default 100 not null,
	-- updated timestamp default now() not null,
	updatedby numeric(10) default 100 not null,
	name varchar(60) default 'Without Expiry' not null,
	description varchar(255),
	-- isserno char default 'Y'::bpchar not null,
	m_sernoctl_id numeric(10),
	islot char default 'N'::bpchar not null,
	-- m_lotctl_id numeric(10),
	isguaranteedate char default 'N'::bpchar not null,
	guaranteedays numeric(10) default 0,
	isinstanceattribute char default 'Y'::bpchar not null,
	-- mandatorytype char default 'N'::bpchar not null,
	-- isguaranteedatemandatory char default 'N'::bpchar not null,
	-- islotmandatory char default 'N'::bpchar not null,
	-- issernomandatory char default 'N'::bpchar not null,
	-- sernocharsoverwrite char,
	-- lotcharsoverwrite char,
	-- lotchareoverwrite char,
	-- sernochareoverwrite char,
	m_attributeset_uu uuid default uuid_generate_v4(),
	useguaranteedateformpolicy char default 'N'::bpchar,
	-- isautogeneratelot char default 'N'::bpchar,
	-- m_attributeset_type varchar(3) default 'MMS'::character varying
	bh_locked varchar(1) default 'Y'
);

-- Update the serial sequences
SELECT setval(
	'tmp_m_attributeset_m_attributeset_id_seq',
	(
		SELECT currentnext
		FROM ad_sequence
		WHERE lower(name) = 'm_attributeset'
		LIMIT 1
	)::INT,
	false
);

-- Create the new attribute sets
INSERT INTO tmp_m_attributeset (
	ad_client_id,
	m_sernoctl_id
)
SELECT
	ad_client_id,
	m_sernoctl_id
FROM tmp_m_sernoctl;

-- Insert into the DB
INSERT INTO m_attributeset (
	m_attributeset_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	name,
	description,
	m_sernoctl_id,
	islot,
	isguaranteedate,
	guaranteedays,
	isinstanceattribute,
	m_attributeset_uu,
	useguaranteedateformpolicy,
	bh_locked
)
SELECT
	m_attributeset_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	name,
	description,
	m_sernoctl_id,
	islot,
	isguaranteedate,
	guaranteedays,
	isinstanceattribute,
	m_attributeset_uu,
	useguaranteedateformpolicy,
	bh_locked
FROM tmp_m_attributeset;

-- Add the correct exclusions for this Attribute Set
create temp table if not exists tmp_m_attributesetexclude
(
	m_attributesetexclude_id serial not null,
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) default 0 not null,
	-- isactive char default 'Y'::bpchar not null,
	-- created timestamp default now() not null,
	createdby numeric(10) default 100 not null,
	-- updated timestamp default now() not null,
	updatedby numeric(10) default 100 not null,
	m_attributeset_id numeric(10) not null,
	ad_table_id numeric(10) default 260 not null,
	-- issotrx char default 'Y'::bpchar not null,
	m_attributesetexclude_uu uuid default uuid_generate_v4()
);

-- Update the serial sequences
SELECT setval(
	'tmp_m_attributesetexclude_m_attributesetexclude_id_seq',
	(
		SELECT currentnext
		FROM ad_sequence
		WHERE lower(name) = 'm_attributesetexclude'
		LIMIT 1
	)::INT,
	false
);

INSERT INTO tmp_m_attributesetexclude (
	ad_client_id,
	m_attributeset_id
)
SELECT
	ad_client_id,
	m_attributeset_id
FROM tmp_m_attributeset;

INSERT INTO m_attributesetexclude (
	m_attributesetexclude_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	m_attributeset_id,
	ad_table_id,
	m_attributesetexclude_uu
)
SELECT
	m_attributesetexclude_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	m_attributeset_id,
	ad_table_id,
	m_attributesetexclude_uu
FROM tmp_m_attributesetexclude;

/**********************************************************************************************************/
-- 4. Add the existing Attribute Set that should be present on all clients to any clients that don't have it.
/**********************************************************************************************************/
TRUNCATE tmp_m_attributeset;

INSERT INTO tmp_m_attributeset (
	ad_client_id,
	name,
	m_sernoctl_id,
	isguaranteedate,
	useguaranteedateformpolicy
)
SELECT
	ad_client_id,
	'BandaHealthProductAttributeSet', --name
	m_sernoctl_id,
	'Y', --isguaranteedate
	'Y' --useguaranteedateformpolicy
FROM tmp_m_sernoctl
WHERE ad_client_id NOT IN (SELECT ad_client_id FROM m_attributeset WHERE name = 'BandaHealthProductAttributeSet');

-- Insert into the DB
INSERT INTO m_attributeset (
	m_attributeset_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	name,
	description,
	m_sernoctl_id,
	islot,
	isguaranteedate,
	guaranteedays,
	isinstanceattribute,
	m_attributeset_uu,
	useguaranteedateformpolicy
)
SELECT
	m_attributeset_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	name,
	description,
	m_sernoctl_id,
	islot,
	isguaranteedate,
	guaranteedays,
	isinstanceattribute,
	m_attributeset_uu,
	useguaranteedateformpolicy
FROM tmp_m_attributeset;

-- And add their exclusions
TRUNCATE tmp_m_attributesetexclude;

INSERT INTO tmp_m_attributesetexclude (
	ad_client_id,
	m_attributeset_id
)
SELECT
	ad_client_id,
	m_attributeset_id
FROM tmp_m_attributeset;

INSERT INTO m_attributesetexclude (
	m_attributesetexclude_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	m_attributeset_id,
	ad_table_id,
	m_attributesetexclude_uu
)
SELECT
	m_attributesetexclude_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	m_attributeset_id,
	ad_table_id,
	m_attributesetexclude_uu
FROM tmp_m_attributesetexclude;

-- Clean up some odd data in the system client
DELETE FROM m_attributesetexclude ase
USING m_attributeset attrs 
WHERE attrs.ad_client_id = 0 AND attrs.name = 'BandaHealthProductAttributeSet'
	AND ase.m_attributeset_id = attrs.m_attributeset_id;

DELETE FROM m_attributeset WHERE name = 'BandaHealthProductAttributeSet' AND ad_client_id = 0;

/**********************************************************************************************************/
-- 5. Rename the attribute set, plus add the serial control to it.
/**********************************************************************************************************/
-- Add the serial control to all existing attribute sets that were previously existing
UPDATE m_attributeset attrs
SET isserno = 'Y', m_sernoctl_id = snc.m_sernoctl_id
FROM tmp_m_sernoctl snc
WHERE snc.ad_client_id = attrs.ad_client_id
	AND attrs.m_sernoctl_id IS NULL
	AND attrs.name = 'BandaHealthProductAttributeSet';

-- Rename all the old attribute sets
UPDATE m_attributeset SET name = 'With Expiry' WHERE name = 'BandaHealthProductAttributeSet';

/**********************************************************************************************************/
-- 6. Update products that don't expire to point to the new attribute set, and all products that do expire to point
--		to the correct attribute set (they should already, but just in case)
/**********************************************************************************************************/
UPDATE m_product p
SET m_attributeset_id = attrs.m_attributeset_id
FROM m_attributeset attrs
	JOIN tmp_ad_client_ids ci ON attrs.ad_client_id = ci.ad_client_id
WHERE p.bh_hasexpiration = 'N'
	AND attrs.ad_client_id = p.ad_client_id
	AND attrs.name = 'Without Expiry';

UPDATE m_product p
SET m_attributeset_id = attrs.m_attributeset_id
FROM m_attributeset attrs
	JOIN tmp_ad_client_ids ci ON attrs.ad_client_id = ci.ad_client_id
WHERE p.bh_hasexpiration = 'Y'
	AND attrs.ad_client_id = p.ad_client_id
	AND attrs.name = 'With Expiry';

/**********************************************************************************************************/
-- 6. Update all data in the system to now have a serial # (they'll all share the same less than the control's start)
/**********************************************************************************************************/
-- For all products that have ASIs, just add the same serial number to them
UPDATE m_attributesetinstance asi
SET serno = 100, description = '#100_' || TO_CHAR(guaranteedate :: DATE, 'mm/dd/yyyy')
WHERE guaranteedate IS NOT NULL;

-- For all products that do not expire, we need to create an ASI with the serial number for them,
-- then update all locations using the ASI of 0 to be the one that was created
create temp table if not exists tmp_m_attributesetinstance
(
	m_attributesetinstance_id serial not null,
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) default 0 not null,
	-- isactive char default 'Y'::bpchar not null,
	-- created timestamp default now() not null,
	createdby numeric(10) default 100 not null,
	-- updated timestamp default now() not null,
	updatedby numeric(10) default 100 not null,
	m_attributeset_id numeric(10),
	serno varchar(40) default 100,
	-- lot varchar(40),
	-- guaranteedate timestamp,
	description varchar(255) default '#100',
	-- m_lot_id numeric(10),
	m_attributesetinstance_uu uuid default uuid_generate_v4(),
	-- bh_update_reason varchar(10)
	tmp_m_product_id numeric(10) not null
);

-- Update the serial sequences
SELECT setval(
	'tmp_m_attributesetinstance_m_attributesetinstance_id_seq',
	(
		SELECT currentnext
		FROM ad_sequence
		WHERE lower(name) = 'm_attributesetinstance'
		LIMIT 1
	)::INT,
	false
);

-- Create an ASI for each product to avoid collisions if things get updated for that product in the future
INSERT INTO tmp_m_attributesetinstance (
	ad_client_id,
	m_attributeset_id,
	tmp_m_product_id
)
SELECT
	attrs.ad_client_id,
	attrs.m_attributeset_id,
	p.m_product_id
FROM m_attributeset attrs
	JOIN tmp_ad_client_ids ci ON attrs.ad_client_id = ci.ad_client_id
	JOIN m_product p ON p.m_attributeset_id = attrs.m_attributeset_id
WHERE attrs.name = 'Without Expiry';

INSERT INTO m_attributesetinstance (
	m_attributesetinstance_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	m_attributeset_id,
	serno,
	description,
	m_attributesetinstance_uu
)
SELECT
	m_attributesetinstance_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	m_attributeset_id,
	serno,
	description,
	m_attributesetinstance_uu
FROM tmp_m_attributesetinstance;

-- Now go through each table linking to the products that don't expire and update the ASI to point to theseselect * from M_InventoryLine -- has product ID
-- These tables can directly join to the m_product_id
UPDATE M_MatchPO mpo
SET m_attributesetinstance_id = asi.m_attributesetinstance_id
FROM tmp_m_attributesetinstance asi
WHERE mpo.m_product_id = asi.tmp_m_product_id
	AND mpo.m_attributesetinstance_id = 0;

UPDATE C_InvoiceLine il
SET m_attributesetinstance_id = asi.m_attributesetinstance_id
FROM tmp_m_attributesetinstance asi
WHERE il.m_product_id = asi.tmp_m_product_id
	AND il.m_attributesetinstance_id = 0;

UPDATE M_CostDetail cd
SET m_attributesetinstance_id = asi.m_attributesetinstance_id
FROM tmp_m_attributesetinstance asi
WHERE cd.m_product_id = asi.tmp_m_product_id
	AND cd.m_attributesetinstance_id = 0;

UPDATE M_Transaction t
SET m_attributesetinstance_id = asi.m_attributesetinstance_id
FROM tmp_m_attributesetinstance asi
WHERE t.m_product_id = asi.tmp_m_product_id
	AND t.m_attributesetinstance_id = 0;

UPDATE M_MovementLine ml
SET m_attributesetinstance_id = asi.m_attributesetinstance_id
FROM tmp_m_attributesetinstance asi
WHERE ml.m_product_id = asi.tmp_m_product_id
	AND ml.m_attributesetinstance_id = 0;

UPDATE M_StorageOnHand soh
SET m_attributesetinstance_id = asi.m_attributesetinstance_id
FROM tmp_m_attributesetinstance asi
WHERE soh.m_product_id = asi.tmp_m_product_id
	AND soh.m_attributesetinstance_id = 0;

UPDATE M_StorageReservation sr
SET m_attributesetinstance_id = asi.m_attributesetinstance_id
FROM tmp_m_attributesetinstance asi
WHERE sr.m_product_id = asi.tmp_m_product_id
	AND sr.m_attributesetinstance_id = 0;

UPDATE M_InOutLine iol
SET m_attributesetinstance_id = asi.m_attributesetinstance_id
FROM tmp_m_attributesetinstance asi
WHERE iol.m_product_id = asi.tmp_m_product_id
	AND iol.m_attributesetinstance_id = 0;

UPDATE C_OrderLine ol
SET m_attributesetinstance_id = asi.m_attributesetinstance_id
FROM tmp_m_attributesetinstance asi
WHERE ol.m_product_id = asi.tmp_m_product_id
	AND ol.m_attributesetinstance_id = 0;

UPDATE M_Cost c
SET m_attributesetinstance_id = asi.m_attributesetinstance_id
FROM tmp_m_attributesetinstance asi
WHERE c.m_product_id = asi.tmp_m_product_id
	AND c.m_attributesetinstance_id = 0;

-- These tables need to get to the product via an intermediate table
UPDATE M_InventoryLineMA ilma
SET m_attributesetinstance_id = asi.m_attributesetinstance_id
FROM m_inventoryline il
	JOIN tmp_m_attributesetinstance asi ON il.m_product_id = asi.tmp_m_product_id AND il.m_attributesetinstance_id = asi.m_attributesetinstance_id
WHERE ilma.m_inventoryline_id = il.m_inventoryline_id
	AND ilma.m_attributesetinstance_id = 0;

UPDATE M_MovementLineMA mlma
SET m_attributesetinstance_id = asi.m_attributesetinstance_id
FROM m_movementline ml
	JOIN tmp_m_attributesetinstance asi ON ml.m_product_id = asi.tmp_m_product_id AND ml.m_attributesetinstance_id = asi.m_attributesetinstance_id
WHERE mlma.m_movementline_id = ml.m_movementline_id
	AND mlma.m_attributesetinstance_id = 0;

UPDATE M_InOutLineMA iolma
SET m_attributesetinstance_id = asi.m_attributesetinstance_id
FROM m_inoutline iol
	JOIN tmp_m_attributesetinstance asi ON iol.m_product_id = asi.tmp_m_product_id AND iol.m_attributesetinstance_id = asi.m_attributesetinstance_id
WHERE iolma.m_inoutline_id = iol.m_inoutline_id
	AND iolma.m_attributesetinstance_id = 0;

UPDATE M_CostHistory ch
SET m_attributesetinstance_id = asi.m_attributesetinstance_id
FROM m_costdetail cd
	JOIN tmp_m_attributesetinstance asi ON cd.m_product_id = asi.tmp_m_product_id AND cd.m_attributesetinstance_id = asi.m_attributesetinstance_id
WHERE ch.m_costdetail_id = cd.m_costdetail_id
	AND ch.m_attributesetinstance_id = 0;

/**********************************************************************************************************/
-- Wrap everything up
/**********************************************************************************************************/
SELECT update_sequences();

SELECT register_migration_script('202204200824_GO-2295.sql') FROM dual;
