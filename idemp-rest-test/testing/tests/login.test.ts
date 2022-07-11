test('can login', async () => {
	await globalThis.__VALUE_OBJECT__.login();
	expect(globalThis.__VALUE_OBJECT__.client).not.toBeNull();
	expect(globalThis.__VALUE_OBJECT__.organization).not.toBeNull();
	expect(globalThis.__VALUE_OBJECT__.role).not.toBeNull();
	expect(globalThis.__VALUE_OBJECT__.warehouse).not.toBeNull();
});

export {};
