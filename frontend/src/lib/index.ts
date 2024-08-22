// place files you want to import through the `$lib` alias in this folder.
import { dev } from "$app/environment";
import type { ItemResponse } from "../routes/items/types";
const BASE_URL = dev ? "http://localhost:8080" : window.location.origin;
export async function fetchItems(page = 0, perPage = 50) {
    return await (
        await fetch(`${BASE_URL}/api/items?page=${page}&pageSize=${perPage}`)
    ).json();
}

export async function fetchItem(item: string) {
    return await (await fetch(`${BASE_URL}/api/items/${item}`)).json();
}
