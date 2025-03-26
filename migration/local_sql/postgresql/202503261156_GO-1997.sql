DROP TABLE IF EXISTS tmp_c_elementvalue;
CREATE TEMP TABLE tmp_c_elementvalue
(
    c_elementvalue_id serial                          NOT NULL,
    ad_client_id      numeric(10)                     NOT NULL,
    ad_org_id         numeric(10) DEFAULT 0           NOT NULL,
--     isactive          char        DEFAULT 'Y'::bpchar NOT NULL,
--     created           timestamp   DEFAULT NOW()       NOT NULL,
    createdby         numeric(10) DEFAULT 100         NOT NULL,
--     updated           timestamp   DEFAULT NOW()       NOT NULL,
    updatedby         numeric(10) DEFAULT 100         NOT NULL,
    value             varchar(40)                     NOT NULL,
    name              varchar(120)                    NOT NULL,
    description       varchar(255),
    accounttype       char        DEFAULT 'R'         NOT NULL,
    accountsign       char        DEFAULT 'N'         NOT NULL,
--     isdoccontrolled   char        DEFAULT 'N'::bpchar,
    c_element_id      numeric(10)                     NOT NULL,
    issummary         char        DEFAULT 'N'::bpchar NOT NULL,
--     validfrom         timestamp,
--     validto           timestamp,
--     postactual        char        DEFAULT 'Y'::bpchar NOT NULL,
--     postbudget        char        DEFAULT 'Y'::bpchar NOT NULL,
--     postencumbrance   char        DEFAULT 'Y'::bpchar NOT NULL,
--     poststatistical   char        DEFAULT 'Y'::bpchar NOT NULL,
--     isbankaccount     char        DEFAULT 'N'::bpchar,
--     c_bankaccount_id  numeric(10),
--     isforeigncurrency char        DEFAULT 'N'::bpchar,
--     c_currency_id     numeric(10),
    c_elementvalue_uu uuid        DEFAULT uuid_generate_v4()
--     isdetailbpartner  char        DEFAULT 'N'::bpchar NOT NULL,
--     isdetailproduct   char        DEFAULT 'N'::bpchar NOT NULL,
--     bpartnertype      char        DEFAULT NULL::bpchar
);
DROP TABLE IF EXISTS tmp_c_validcombination;
create TEMP table tmp_c_validcombination
(
    c_validcombination_id serial                    not null,
    ad_client_id          numeric(10)               not null,
    ad_org_id             numeric(10) default 0     not null,
    -- isactive              char        default 'Y'::bpchar not null,
   -- created               timestamp   default now() not null,
   createdby             numeric(10) default 100   not null,
   -- updated               timestamp   default now() not null,
    updatedby             numeric(10)  default 100  not null,
    -- alias                 varchar(40),
    combination           varchar(60),
    description           varchar(255),
    -- isfullyqualified      char        default 'Y'::bpchar not null,
    c_acctschema_id       numeric(10)               not null,
    account_id            numeric(10)               not null,
    --  m_product_id          numeric(10),
    -- c_bpartner_id         numeric(10),
    -- ad_orgtrx_id          numeric(10),
    -- c_locfrom_id          numeric(10),
    -- c_locto_id            numeric(10),
    -- c_salesregion_id      numeric(10),
    -- c_project_id          numeric(10),
    -- c_campaign_id         numeric(10),
    -- c_activity_id         numeric(10),
    -- user1_id              numeric(10),
    -- user2_id              numeric(10),
    -- c_subacct_id          numeric(10),
    --userelement1_id       numeric(10),
    -- userelement2_id       numeric(10),
    c_validcombination_uu varchar(36) default NULL::character varying
);
-- Alter the sequence so the correct IDs will be inserted since iDempiere tracks this manually
SELECT setval(
	'tmp_c_elementvalue_c_elementvalue_id_seq',
	(
		SELECT currentnext
		FROM ad_sequence
		WHERE name = 'C_ElementValue'
		LIMIT 1
	)::INT,
	false
);
SELECT setval(
	'tmp_c_validcombination_c_validcombination_id_seq',
	(
		SELECT currentnext
		FROM ad_sequence
		WHERE name = 'C_ValidCombination'
		LIMIT 1
	)::INT,
	false
);

INSERT INTO
    tmp_c_elementvalue (ad_client_id, value, name, issummary, c_element_id)
SELECT
    e.ad_client_id,
    ev.value,
    ev.name,
    ev.issummary,
    e.c_element_id
FROM
    c_element e
        CROSS JOIN (
        VALUES
            ('411', 'Product Revenue', 'Y'),
            ('412', 'Service Revenue', 'Y'),
            ('41201', 'Service Revenue - Consultation', 'N'),
            ('41202', 'Service Revenue - Laboratory', 'N'),
            ('41203', 'Service Revenue - Imaging', 'N'),
            ('41204', 'Service Revenue - Dental', 'N'),
            ('41205', 'Service Revenue - Orthopedic Trauma Services', 'N'),
            ('41206', 'Service Revenue - OPD procedures', 'N'),
            ('41207', 'Service Revenue - Antenatal care', 'N'),
            ('41208', 'Service Revenue - Postnatal care', 'N'),
            ('41209', 'Service Revenue - Family planning', 'N'),
            ('41210', 'Service Revenue - Maternity', 'N'),
            ('41211', 'Service Revenue - Eye Clinic', 'N'),
            ('41212', 'Service Revenue - Surgery', 'N'),
            ('41213', 'Service Revenue - Day-case Services', 'N'),
            ('41214', 'Service Revenue - Home Care Services', 'N'),
            ('41215', 'Service Revenue - Inpatient', 'N'),
            ('41216', 'Service Revenue - Follow up', 'N'),
            ('41217', 'Service Revenue - Other', 'N')
    ) ev (value, name, issummary)
WHERE
    ad_client_id > 999999;

INSERT INTO c_elementvalue (
	c_elementvalue_id      
    ad_client_id           
    ad_org_id                   
    createdby                    
    updatedby           
    value                           
    name                           
    description    
    accounttype       
    accountsign      
    c_element_id                  
    issummary         
    c_elementvalue_uu uuid
)
SELECT
	c_elementvalue_id      
    ad_client_id           
    ad_org_id                   
    createdby                    
    updatedby           
    value                           
    name                           
    description    
    accounttype       
    accountsign      
    c_element_id                  
    issummary         
    c_elementvalue_uu uuid
FROM tmp_c_elementvalue;


-- Add the new account to the Element Value tree so it shows up in the UI
INSERT INTO ad_treenode (
	ad_tree_id,
	node_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	parent_id,
	seqno,
	ad_treenode_uu
)
SELECT
	tr.ad_tree_id,
	ev.c_elementvalue_id,
	ev.ad_client_id,
	0,
	100,
	100,
	CASE
		WHEN ev.value = '127' THEN (SELECT c_elementvalue_id FROM c_elementvalue WHERE ad_client_id = ev.ad_client_id AND value = '12')
		WHEN ev.value = '12710' THEN (SELECT c_elementvalue_id FROM c_elementvalue WHERE ad_client_id = ev.ad_client_id AND value = '127')
		WHEN ev.value = '12310' THEN (SELECT c_elementvalue_id FROM c_elementvalue WHERE ad_client_id = ev.ad_client_id AND value = '123')
		ELSE 0
	END,
	999,
	uuid_generate_v4()
FROM tmp_c_elementvalue ev
	INNER JOIN ad_tree tr
		ON tr.ad_client_id = ev.ad_client_id
			AND tr.name like '%Element Value';    

