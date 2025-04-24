-- Add report groupings

-- Add financial group
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname, predefinedcontextvariables) VALUES ((SELECT MAX(AD_Menu_ID) + 1 FROM AD_Menu), 0, 0, 'Y', '2025-04-24 13:35:38.720000', 100, '2025-04-24 13:43:33.928000', 'Financial', 100, 'Understand the clinic''s financial position, revenue streams, and liabilities', 'Y', 'Y', 'N', null, null, null, null, null, null, null, 'U', 'N', '669051b6-195c-420d-9b35-b62b4fc44c32', null, null, null);

-- add reports under financial
UPDATE
    ad_treenodemm
SET
    seqno = 0,
    parent_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE ad_menu_uu = '669051b6-195c-420d-9b35-b62b4fc44c32'
    )
WHERE
    node_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE
            ad_menu_id IN (
                SELECT
                    node_id
                FROM
                    ad_treenodemm
                WHERE
                    parent_id = (
                        SELECT
                            ad_menu_id
                        FROM
                            ad_menu
                        WHERE
                            ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
                    )
                AND ad_process_id = (
                    SELECT
                        ad_process_id
                    FROM
                        ad_process
                    WHERE ad_process_uu = '4cf22d3f-1fc8-4bdd-83e1-fc5d79537269'
            )
     )
);

UPDATE
    ad_treenodemm
SET
    seqno = 1,
    parent_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE ad_menu_uu = '669051b6-195c-420d-9b35-b62b4fc44c32'
    )
WHERE
    node_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE
            ad_menu_id IN (
                SELECT
                    node_id
                FROM
                    ad_treenodemm
                WHERE
                    parent_id = (
                        SELECT
                            ad_menu_id
                        FROM
                            ad_menu
                        WHERE
                            ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
                    )
                AND ad_process_id = (
                    SELECT
                        ad_process_id
                    FROM
                        ad_process
                    WHERE ad_process_uu = 'fb90406f-1ba4-43df-9cec-6844e10c13d9'
            )
     )
);

UPDATE
    ad_treenodemm
SET
    seqno = 2,
    parent_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE ad_menu_uu = '669051b6-195c-420d-9b35-b62b4fc44c32'
    )
WHERE
    node_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE
            ad_menu_id IN (
                SELECT
                    node_id
                FROM
                    ad_treenodemm
                WHERE
                    parent_id = (
                        SELECT
                            ad_menu_id
                        FROM
                            ad_menu
                        WHERE
                            ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
                    )
                AND ad_process_id = (
                    SELECT
                        ad_process_id
                    FROM
                        ad_process
                    WHERE ad_process_uu = 'b09d9a23-ad0f-4eff-a7c6-4c1e2309c3d1'
            )
     )
);

UPDATE
    ad_treenodemm
SET
    seqno = 3,
    parent_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE ad_menu_uu = '669051b6-195c-420d-9b35-b62b4fc44c32'
    )
WHERE
    node_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE
            ad_menu_id IN (
                SELECT
                    node_id
                FROM
                    ad_treenodemm
                WHERE
                    parent_id = (
                        SELECT
                            ad_menu_id
                        FROM
                            ad_menu
                        WHERE
                            ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
                    )
                AND ad_process_id = (
                    SELECT
                        ad_process_id
                    FROM
                        ad_process
                    WHERE ad_process_uu = 'f777f042-3907-4293-94c4-49fe6eb58780'
            )
     )
);

UPDATE
    ad_treenodemm
SET
    seqno = 4,
    parent_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE ad_menu_uu = '669051b6-195c-420d-9b35-b62b4fc44c32'
    )
WHERE
    node_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE
            ad_menu_id IN (
                SELECT
                    node_id
                FROM
                    ad_treenodemm
                WHERE
                    parent_id = (
                        SELECT
                            ad_menu_id
                        FROM
                            ad_menu
                        WHERE
                            ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
                    )
                AND ad_process_id = (
                    SELECT
                        ad_process_id
                    FROM
                        ad_process
                    WHERE ad_process_uu = '9e2e2707-7b3e-4b0b-aa93-3a1a64d523b2'
            )
     )
);

UPDATE
    ad_treenodemm
SET
    seqno = 5,
    parent_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE ad_menu_uu = '669051b6-195c-420d-9b35-b62b4fc44c32'
    )
WHERE
    node_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE
            ad_menu_id IN (
                SELECT
                    node_id
                FROM
                    ad_treenodemm
                WHERE
                    parent_id = (
                        SELECT
                            ad_menu_id
                        FROM
                            ad_menu
                        WHERE
                            ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
                    )
                AND ad_process_id = (
                    SELECT
                        ad_process_id
                    FROM
                        ad_process
                    WHERE ad_process_uu = '226cdf47-9cde-43e8-b7ef-87b28d7ef2e2'
            )
     )
);

UPDATE
    ad_treenodemm
SET
    seqno = 6,
    parent_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE ad_menu_uu = '669051b6-195c-420d-9b35-b62b4fc44c32'
    )
WHERE
    node_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE
            ad_menu_id IN (
                SELECT
                    node_id
                FROM
                    ad_treenodemm
                WHERE
                    parent_id = (
                        SELECT
                            ad_menu_id
                        FROM
                            ad_menu
                        WHERE
                            ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
                    )
                AND ad_process_id = (
                    SELECT
                        ad_process_id
                    FROM
                        ad_process
                    WHERE ad_process_uu = 'b4f11e14-b9d8-4f6c-aa46-adfd77c4f773'
            )
     )
);

UPDATE
    ad_treenodemm
SET
    seqno = 7,
    parent_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE ad_menu_uu = '669051b6-195c-420d-9b35-b62b4fc44c32'
    )
WHERE
    node_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE
            ad_menu_id IN (
                SELECT
                    node_id
                FROM
                    ad_treenodemm
                WHERE
                    parent_id = (
                        SELECT
                            ad_menu_id
                        FROM
                            ad_menu
                        WHERE
                            ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
                    )
                AND ad_process_id = (
                    SELECT
                        ad_process_id
                    FROM
                        ad_process
                    WHERE ad_process_uu = '19464274-e2bc-4dbe-ad69-ae48b9f7778c'
            )
     )
);

UPDATE
    ad_treenodemm
SET
    seqno = 8,
    parent_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE ad_menu_uu = '669051b6-195c-420d-9b35-b62b4fc44c32'
    )
WHERE
    node_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE
            ad_menu_id IN (
                SELECT
                    node_id
                FROM
                    ad_treenodemm
                WHERE
                    parent_id = (
                        SELECT
                            ad_menu_id
                        FROM
                            ad_menu
                        WHERE
                            ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
                    )
                AND ad_process_id = (
                    SELECT
                        ad_process_id
                    FROM
                        ad_process
                    WHERE ad_process_uu = '20a623fb-e127-4c26-98d5-3604a6d100b2'
            )
     )
);

UPDATE
    ad_treenodemm
SET
    seqno = 9,
    parent_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE ad_menu_uu = '669051b6-195c-420d-9b35-b62b4fc44c32'
    )
WHERE
    node_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE
            ad_menu_id IN (
                SELECT
                    node_id
                FROM
                    ad_treenodemm
                WHERE
                    parent_id = (
                        SELECT
                            ad_menu_id
                        FROM
                            ad_menu
                        WHERE
                            ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
                    )
                AND ad_process_id = (
                    SELECT
                        ad_process_id
                    FROM
                        ad_process
                    WHERE ad_process_uu = '3478d341-c6d9-4f52-a865-5bf0ba8a7607'
            )
     )
);

UPDATE
    ad_treenodemm
SET
    seqno = 10,
    parent_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE ad_menu_uu = '669051b6-195c-420d-9b35-b62b4fc44c32'
    )
WHERE
    node_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE
            ad_menu_id IN (
                SELECT
                    node_id
                FROM
                    ad_treenodemm
                WHERE
                    parent_id = (
                        SELECT
                            ad_menu_id
                        FROM
                            ad_menu
                        WHERE
                            ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
                    )
                AND ad_process_id = (
                    SELECT
                        ad_process_id
                    FROM
                        ad_process
                    WHERE ad_process_uu = 'b8508f0a-c66f-4030-a88c-3ae383322ceb'
            )
     )
);

UPDATE
    ad_treenodemm
SET
    seqno = 11,
    parent_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE ad_menu_uu = '669051b6-195c-420d-9b35-b62b4fc44c32'
    )
WHERE
    node_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE
            ad_menu_id IN (
                SELECT
                    node_id
                FROM
                    ad_treenodemm
                WHERE
                    parent_id = (
                        SELECT
                            ad_menu_id
                        FROM
                            ad_menu
                        WHERE
                            ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
                    )
                AND ad_process_id = (
                    SELECT
                        ad_process_id
                    FROM
                        ad_process
                    WHERE ad_process_uu = 'bbffd5e1-973a-4d17-9ddf-9ca78a4e140d'
            )
     )
);

-- Add clinical group
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname, predefinedcontextvariables) VALUES ((SELECT MAX(AD_Menu_ID) + 1 FROM AD_Menu), 0, 0, 'Y', '2025-04-24 13:36:26.786000', 100, '2025-04-24 13:42:42.785000', 'Clinical', 100, 'Monitor patient trends, clinical workload, and service delivery', 'Y', 'Y', 'N', null, null, null, null, null, null, null, 'U', 'N', 'bcf31f7a-9532-42d2-9bd6-35ebc79f973e', null, null, null);

-- Add reports
UPDATE
    ad_treenodemm
SET
    seqno = 0,
    parent_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE ad_menu_uu = 'bcf31f7a-9532-42d2-9bd6-35ebc79f973e'
    )
WHERE
    node_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE
            ad_menu_id IN (
                SELECT
                    node_id
                FROM
                    ad_treenodemm
                WHERE
                    parent_id = (
                        SELECT
                            ad_menu_id
                        FROM
                            ad_menu
                        WHERE
                            ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
                    )
                AND ad_process_id = (
                    SELECT
                        ad_process_id
                    FROM
                        ad_process
                    WHERE ad_process_uu = 'c9f91d23-48ea-4990-af5d-f3e7f0db77de'
            )
     )
);

UPDATE
    ad_treenodemm
SET
    seqno = 1,
    parent_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE ad_menu_uu = 'bcf31f7a-9532-42d2-9bd6-35ebc79f973e'
    )
WHERE
    node_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE
            ad_menu_id IN (
                SELECT
                    node_id
                FROM
                    ad_treenodemm
                WHERE
                    parent_id = (
                        SELECT
                            ad_menu_id
                        FROM
                            ad_menu
                        WHERE
                            ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
                    )
                AND ad_process_id = (
                    SELECT
                        ad_process_id
                    FROM
                        ad_process
                    WHERE ad_process_uu = '432eeb61-1a87-4880-bded-91927139341c'
            )
     )
);

UPDATE
    ad_treenodemm
SET
    seqno = 2,
    parent_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE ad_menu_uu = 'bcf31f7a-9532-42d2-9bd6-35ebc79f973e'
    )
WHERE
    node_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE
            ad_menu_id IN (
                SELECT
                    node_id
                FROM
                    ad_treenodemm
                WHERE
                    parent_id = (
                        SELECT
                            ad_menu_id
                        FROM
                            ad_menu
                        WHERE
                            ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
                    )
                AND ad_process_id = (
                    SELECT
                        ad_process_id
                    FROM
                        ad_process
                    WHERE ad_process_uu = '742f515a-81c7-4690-8d35-2c6f1252ad5b'
            )
     )
);

UPDATE
    ad_treenodemm
SET
    seqno = 3,
    parent_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE ad_menu_uu = 'bcf31f7a-9532-42d2-9bd6-35ebc79f973e'
    )
WHERE
    node_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE
            ad_menu_id IN (
                SELECT
                    node_id
                FROM
                    ad_treenodemm
                WHERE
                    parent_id = (
                        SELECT
                            ad_menu_id
                        FROM
                            ad_menu
                        WHERE
                            ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
                    )
                AND ad_process_id = (
                    SELECT
                        ad_process_id
                    FROM
                        ad_process
                    WHERE ad_process_uu = '7c29028a-8dd3-4025-a5af-87701748d81f'
            )
     )
);

UPDATE
    ad_treenodemm
SET
    seqno = 4,
    parent_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE ad_menu_uu = 'bcf31f7a-9532-42d2-9bd6-35ebc79f973e'
    )
WHERE
    node_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE
            ad_menu_id IN (
                SELECT
                    node_id
                FROM
                    ad_treenodemm
                WHERE
                    parent_id = (
                        SELECT
                            ad_menu_id
                        FROM
                            ad_menu
                        WHERE
                            ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
                    )
                AND ad_process_id = (
                    SELECT
                        ad_process_id
                    FROM
                        ad_process
                    WHERE ad_process_uu = '83378587-d80f-4c79-874b-5cdc64893b77'
            )
     )
);

UPDATE
    ad_treenodemm
SET
    seqno = 5,
    parent_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE ad_menu_uu = 'bcf31f7a-9532-42d2-9bd6-35ebc79f973e'
    )
WHERE
    node_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE
            ad_menu_id IN (
                SELECT
                    node_id
                FROM
                    ad_treenodemm
                WHERE
                    parent_id = (
                        SELECT
                            ad_menu_id
                        FROM
                            ad_menu
                        WHERE
                            ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
                    )
                AND ad_process_id = (
                    SELECT
                        ad_process_id
                    FROM
                        ad_process
                    WHERE ad_process_uu = 'feaa97fb-b424-4dce-8790-035ba80ca023'
            )
     )
);

-- Add inventory group
INSERT INTO ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname, predefinedcontextvariables) VALUES ((SELECT MAX(AD_Menu_ID) + 1 FROM AD_Menu), 0, 0, 'Y', '2025-04-24 13:36:47.035000', 100, '2025-04-24 13:39:06.306000', 'Inventory', 100, 'View what''s going on with your stocks', 'Y', 'Y', 'N', null, null, null, null, null, null, null, 'U', 'N', '90d2983e-64b0-4b5f-86ee-4512c45bf893', null, null, null);

-- Add reports
UPDATE
    ad_treenodemm
SET
    seqno = 0,
    parent_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE ad_menu_uu = '90d2983e-64b0-4b5f-86ee-4512c45bf893'
    )
WHERE
    node_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE
            ad_menu_id IN (
                SELECT
                    node_id
                FROM
                    ad_treenodemm
                WHERE
                    parent_id = (
                        SELECT
                            ad_menu_id
                        FROM
                            ad_menu
                        WHERE
                            ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
                    )
                AND ad_process_id = (
                    SELECT
                        ad_process_id
                    FROM
                        ad_process
                    WHERE ad_process_uu = '1211e173-6f12-4e2f-bfcc-d43d48af51c3'
            )
     )
);

UPDATE
    ad_treenodemm
SET
    seqno = 1,
    parent_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE ad_menu_uu = '90d2983e-64b0-4b5f-86ee-4512c45bf893'
    )
WHERE
    node_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE
            ad_menu_id IN (
                SELECT
                    node_id
                FROM
                    ad_treenodemm
                WHERE
                    parent_id = (
                        SELECT
                            ad_menu_id
                        FROM
                            ad_menu
                        WHERE
                            ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
                    )
                AND ad_process_id = (
                    SELECT
                        ad_process_id
                    FROM
                        ad_process
                    WHERE ad_process_uu = '93d7c1bc-2885-43f4-985f-90f57a414e5f'
            )
     )
);

UPDATE
    ad_treenodemm
SET
    seqno = 2,
    parent_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE ad_menu_uu = '90d2983e-64b0-4b5f-86ee-4512c45bf893'
    )
WHERE
    node_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE
            ad_menu_id IN (
                SELECT
                    node_id
                FROM
                    ad_treenodemm
                WHERE
                    parent_id = (
                        SELECT
                            ad_menu_id
                        FROM
                            ad_menu
                        WHERE
                            ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
                    )
                AND ad_process_id = (
                    SELECT
                        ad_process_id
                    FROM
                        ad_process
                    WHERE ad_process_uu = '58ae2bdf-0e80-46f2-860f-2ae070fc82d2'
            )
     )
);

UPDATE
    ad_treenodemm
SET
    seqno = 3,
    parent_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE ad_menu_uu = '90d2983e-64b0-4b5f-86ee-4512c45bf893'
    )
WHERE
    node_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE
            ad_menu_id IN (
                SELECT
                    node_id
                FROM
                    ad_treenodemm
                WHERE
                    parent_id = (
                        SELECT
                            ad_menu_id
                        FROM
                            ad_menu
                        WHERE
                            ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
                    )
                AND ad_process_id = (
                    SELECT
                        ad_process_id
                    FROM
                        ad_process
                    WHERE ad_process_uu = '03ba009a-68bb-4b12-a5bc-e58a9bce1545'
            )
     )
);

UPDATE
    ad_treenodemm
SET
    seqno = 4,
    parent_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE ad_menu_uu = '90d2983e-64b0-4b5f-86ee-4512c45bf893'
    )
WHERE
    node_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE
            ad_menu_id IN (
                SELECT
                    node_id
                FROM
                    ad_treenodemm
                WHERE
                    parent_id = (
                        SELECT
                            ad_menu_id
                        FROM
                            ad_menu
                        WHERE
                            ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
                    )
                AND ad_process_id = (
                    SELECT
                        ad_process_id
                    FROM
                        ad_process
                    WHERE ad_process_uu = '3edf67b9-ee3d-4b73-a02e-deb1c1811db5'
            )
     )
);

UPDATE
    ad_treenodemm
SET
    seqno = 5,
    parent_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE ad_menu_uu = '90d2983e-64b0-4b5f-86ee-4512c45bf893'
    )
WHERE
    node_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE
            ad_menu_id IN (
                SELECT
                    node_id
                FROM
                    ad_treenodemm
                WHERE
                    parent_id = (
                        SELECT
                            ad_menu_id
                        FROM
                            ad_menu
                        WHERE
                            ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
                    )
                AND ad_process_id = (
                    SELECT
                        ad_process_id
                    FROM
                        ad_process
                    WHERE ad_process_uu = '630fc1ab-0b64-459b-b10f-68549d21f507'
            )
     )
);

UPDATE
    ad_treenodemm
SET
    seqno = 6,
    parent_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE ad_menu_uu = '90d2983e-64b0-4b5f-86ee-4512c45bf893'
    )
WHERE
    node_id = (
        SELECT
            ad_menu_id
        FROM
            ad_menu
        WHERE
            ad_menu_id IN (
                SELECT
                    node_id
                FROM
                    ad_treenodemm
                WHERE
                    parent_id = (
                        SELECT
                            ad_menu_id
                        FROM
                            ad_menu
                        WHERE
                            ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
                    )
                AND ad_process_id = (
                    SELECT
                        ad_process_id
                    FROM
                        ad_process
                    WHERE ad_process_uu = '808a1aaa-f38a-4a90-87dc-5ab2ebe2f7e6'
            )
     )
);

-- delete Patient Visits and Referrals
DELETE FROM ad_menu WHERE ad_menu_uu IN ('d7aba725-d107-4e52-b918-0e0bc4c20c27', '8c73cc35-045a-4d35-9574-224004c9683b');

SELECT
	register_migration_script('202504241330_GO-3279.sql')
FROM
	dual;
