import { v4 } from 'uuid';
import { mutate, query } from '../api';
import {
	Ad_RoleGetDocument,
	Ad_RoleSaveDocument,
	Ad_RoleWithIncludedSaveDocument,
	Ad_Role_IncludedDeleteDocument,
	Ad_Role_IncludedSaveManyDocument,
} from '../__generated__/graphql';

export const roleUuid = { MUST_HAVES: 'baec9412-d994-4313-815c-31332357863a' } as const;

test('role can be created and adjusted', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create role';
	let role = (
		await mutate(valueObject)({
			mutation: Ad_RoleSaveDocument,
			variables: {
				entity: {
					IsMasterRole: false,
					IsManual: true,
					Name: valueObject.getDynamicStepMessage(),
					Description: valueObject.getStepMessageLong(),
					IsActive: true,
				},
			},
		})
	).data!.AD_RoleSave!;
	expect(role).toBeTruthy();
	expect(role.AD_Role_IncludedList).toBeFalsy();
	expect(role.IsMasterRole).toBe(false);

	valueObject.stepName = 'Add included roles';
	const masterRoles = (
		await query(valueObject)({
			query: Ad_RoleGetDocument,
			variables: { filter: JSON.stringify({ ismasterrole: true }) },
		})
	).data.AD_RoleGet.results;
	expect(masterRoles.length > 1).toBeTruthy();
	await mutate(valueObject)({
		mutation: Ad_Role_IncludedSaveManyDocument,
		variables: {
			entities: [
				{
					AD_Org: { UUID: valueObject.organization!.UUID },
					AD_Role: { UUID: role.UUID },
					Included_Role: { UUID: masterRoles[0].UUID },
					SeqNo: 10,
				},
				{
					AD_Org: { UUID: valueObject.organization!.UUID },
					AD_Role: { UUID: role.UUID },
					Included_Role: { UUID: masterRoles[1].UUID },
					SeqNo: 20,
				},
			],
		},
	});
	role = (
		await query(valueObject)({
			query: Ad_RoleGetDocument,
			variables: { size: 1, filter: JSON.stringify({ ad_role_uu: role.UUID }) },
		})
	).data.AD_RoleGet.results[0]!;
	expect(role).toBeTruthy();
	expect(role.AD_Role_IncludedList).toHaveLength(2);

	valueObject.stepName = 'Remove included roles';
	await mutate(valueObject)({
		mutation: Ad_Role_IncludedDeleteDocument,
		variables: { uuids: role.AD_Role_IncludedList!.map((roleIncludedRecord) => roleIncludedRecord.UUID) },
	});
	role = (
		await query(valueObject)({
			query: Ad_RoleGetDocument,
			variables: { size: 1, filter: JSON.stringify({ ad_role_uu: role.UUID }) },
		})
	).data.AD_RoleGet.results[0]!;
	expect(role).toBeTruthy();
	expect(role.AD_Role_IncludedList).toBeFalsy();
});

test('properties set correctly', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Get master roles';
	const masterRoles = (
		await query(valueObject)({
			query: Ad_RoleGetDocument,
			variables: { filter: JSON.stringify({ ismasterrole: true }) },
		})
	).data.AD_RoleGet.results;
	expect(masterRoles.every((role) => role.IsMasterRole === true)).toBeTruthy();

	valueObject.stepName = 'Create role';
	await mutate(valueObject)({
		mutation: Ad_RoleSaveDocument,
		variables: {
			entity: {
				IsMasterRole: false,
				Name: valueObject.getDynamicStepMessage(),
				Description: valueObject.getStepMessageLong(),
				IsActive: true,
			},
		},
	});

	valueObject.stepName = 'Get regular roles';
	const regularRoles = (
		await query(valueObject)({
			query: Ad_RoleGetDocument,
			variables: { filter: JSON.stringify({ ismasterrole: false }) },
		})
	).data.AD_RoleGet.results;
	expect(regularRoles.every((role) => role.IsMasterRole === false)).toBeTruthy();
});

test('complex role filtering works', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Get role complexly';
	const masterRoles = (
		await query(valueObject)({
			query: Ad_RoleGetDocument,
			variables: { filter: JSON.stringify({ ismasterrole: true, ad_role_uu: { $neq: roleUuid.MUST_HAVES } }) },
		})
	).data.AD_RoleGet.results;
	expect(masterRoles.length > 2).toBeTruthy();
	const roleUuidsWeWillUse = [masterRoles[0].UUID, masterRoles[1].UUID, roleUuid.MUST_HAVES];
	const complexFilter = {
		$not: [
			{
				'ad_role_included.ad_role::included_role_id->ad_role_id.ad_role_uu': {
					$in: masterRoles
						.filter((masterRole) => !roleUuidsWeWillUse.includes(masterRole.UUID))
						.map((masterRole) => masterRole.UUID),
				},
			},
		],
	} as any;
	complexFilter.$and = roleUuidsWeWillUse.map((roleUuid) => ({
		'ad_role_included.ad_role::included_role_id->ad_role_id.ad_role_uu': { $eq: roleUuid },
	}));
	const initialRoleQueryResults = (
		await query(valueObject)({
			query: Ad_RoleGetDocument,
			variables: { filter: JSON.stringify(complexFilter) },
		})
	).data.AD_RoleGet.results;
	expect(
		initialRoleQueryResults.every((role) => role.AD_Role_IncludedList?.length === roleUuidsWeWillUse.length),
	).toBeTruthy();

	valueObject.stepName = 'Create role-matching, complex query';
	const generatedRoleUuid = v4();
	await mutate(valueObject)({
		mutation: Ad_RoleWithIncludedSaveDocument,
		variables: {
			AD_Role: {
				UUID: generatedRoleUuid,
				IsMasterRole: false,
				Name: valueObject.getDynamicStepMessage(),
				Description: valueObject.getStepMessageLong(),
				IsActive: true,
			},
			AD_Role_IncludedList: roleUuidsWeWillUse.map((roleUuidToInclude) => ({
				AD_Org: { UUID: valueObject.organization!.UUID },
				AD_Role: { UUID: generatedRoleUuid },
				Included_Role: { UUID: roleUuidToInclude },
				SeqNo: 10,
			})),
		},
	});
	const role = (
		await query(valueObject)({
			query: Ad_RoleGetDocument,
			variables: { filter: JSON.stringify({ ad_role_uu: generatedRoleUuid }) },
		})
	).data.AD_RoleGet.results[0];
	expect(role).toBeTruthy();
	expect(role.AD_Role_IncludedList?.length).toBe(roleUuidsWeWillUse.length);

	expect(
		(
			await query(valueObject)({
				query: Ad_RoleGetDocument,
				variables: { filter: JSON.stringify(complexFilter) },
			})
		).data.AD_RoleGet.results.length,
	).toBe(initialRoleQueryResults.length + 1);

	const secondComplexFilter = {
		$not: [
			{
				'ad_role_included.ad_role::included_role_id': {
					ad_role_uu: {
						$in: masterRoles
							.filter((masterRole) => !roleUuidsWeWillUse.includes(masterRole.UUID))
							.map((masterRole) => masterRole.UUID),
					},
				},
			},
		],
	} as any;
	secondComplexFilter.$and = roleUuidsWeWillUse.map((roleUuid) => ({
		'ad_role_included.ad_role::included_role_id': { ad_role_uu: { $eq: roleUuid } },
	}));
	const secondQueryResults = (
		await query(valueObject)({
			query: Ad_RoleGetDocument,
			variables: { filter: JSON.stringify(secondComplexFilter) },
		})
	).data.AD_RoleGet.results;
	expect(
		secondQueryResults.every((role) => role.AD_Role_IncludedList?.length === roleUuidsWeWillUse.length),
	).toBeTruthy();
	expect(secondQueryResults.length).toBe(initialRoleQueryResults.length + 1);
});
