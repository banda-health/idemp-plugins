-- Create ad_sequences for all existing clients.
CREATE TEMP TABLE tmp_client_bpartner_number
(
	ad_client_id  				numeric(10)             NOT NULL,
	bh_patientid  				numeric(100)            NOT NULL
);

INSERT INTO
	tmp_client_bpartner_number (ad_client_id, bh_patientid) 
SELECT 
	bp.ad_client_id, COALESCE(MAX(CAST(bp.bh_patientid AS NUMERIC)) + 1, 100000) as bh_patientid
FROM 
	ad_client client 
JOIN 
	c_bpartner bp ON client.ad_client_id = bp.ad_client_id
WHERE 
	client.isactive = 'Y' AND 
	client.ad_client_id > 999999 AND 
	bp.bh_ispatient = 'Y' AND
	isnumeric(bp.bh_patientid)
GROUP BY bp.ad_client_id;

CREATE TEMP TABLE tmp_ad_sequence
(
	ad_sequence_id     serial	                       not null,
    ad_client_id       numeric(10)                     not null,
    ad_org_id          numeric(10) default 0           not null,
    isactive           char        default 'Y'::bpchar,
    created            timestamp   default now()       not null,
    createdby          numeric(10) default 100         not null,
    updated            timestamp   default now()       not null,
    updatedby          numeric(10) default 100         not null,
    name               varchar(60) default 'DocumentNo_BH_PatientID_C_BPartner' not null,
    description        varchar(255) default 'PatientID for Table C_BPartner' not null,
    vformat            varchar(40),
    isautosequence     char        default 'Y'::bpchar not null,
    incrementno        numeric(10) default 1           not null,
    startno            numeric(10) default 100000      not null,
    currentnext        numeric(10)                     not null,
    currentnextsys     numeric(10) default 100000      not null,
    isaudited          char        default 'N'::bpchar,
    istableid          char        default 'N'::bpchar,
    prefix             varchar(255),
    suffix             varchar(255),
    startnewyear       char        default 'N'::bpchar,
    datecolumn         varchar(60),
    decimalpattern     varchar(40),
    ad_sequence_uu     varchar(36) default uuid_generate_v4(),
    startnewmonth      char        default 'N'::bpchar not null,
    isorglevelsequence char        default 'N'::bpchar not null,
    orgcolumn          varchar(60) default NULL
);

-- SET sequence
SELECT
	SETVAL(
			'tmp_ad_sequence_ad_sequence_id_seq',
			(
				SELECT
					currentnext
				FROM
					ad_sequence
				WHERE
					name = 'AD_Sequence'
				LIMIT 1
			)::INT,
			FALSE
		);

INSERT INTO tmp_ad_sequence (ad_client_id, currentnext) 
SELECT 
	ad_client_id, bh_patientid
FROM tmp_client_bpartner_number;

-- insert into configuration client
INSERT INTO tmp_ad_sequence(ad_client_id, currentnext) VALUES (2, 100000);

INSERT INTO ad_sequence (
	ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, 
	updatedby, name, description, vformat, isautosequence, incrementno, startno, 
	currentnext, currentnextsys, isaudited, istableid, prefix, suffix, 
	startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth, 
	isorglevelsequence, orgcolumn
)
SELECT
	ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, 
	updatedby, name, description, vformat, isautosequence, incrementno, startno, 
	currentnext, currentnextsys, isaudited, istableid, prefix, suffix, 
	startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth, 
	isorglevelsequence, orgcolumn
FROM tmp_ad_sequence;

DROP TABLE tmp_client_bpartner_number;
DROP TABLE tmp_ad_sequence;
	
SELECT
	update_sequences();

SELECT
	register_migration_script('202302091330_GO-2502.sql')
FROM
	dual;
