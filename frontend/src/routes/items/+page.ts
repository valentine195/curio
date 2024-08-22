import type { ItemResponse } from "./types.js";
import { PUBLIC_API_URL } from "$env/static/public";
import { fetchItems } from "$lib";

export async function load({ params }) {
    return await fetchItems();
}
