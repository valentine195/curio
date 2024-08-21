import type { Item, ItemResponse } from './types.js';

export async function load({ params }) {
    const items: ItemResponse = await (await fetch("http://localhost:8080/api/items")).json();
    console.log("🚀 ~ file: +page.ts:3 ~ items:", items);
    return {
        items
    };
}
