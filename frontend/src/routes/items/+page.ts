import type { ItemResponse } from "./types.js";
import { PUBLIC_API_URL } from "$env/static/public";

export async function load({ params }) {
    const items: ItemResponse = await (
        await fetch(`${PUBLIC_API_URL ?? window.location.origin}/api/items`)
    ).json();
    console.log("🚀 ~ file: +page.ts:3 ~ items:", items);
    return {
        items
    };
}
