// place files you want to import through the `$lib` alias in this folder.
import { dev } from "$app/environment";
const BASE_URL = dev ? "http://localhost:8080" : "https://curio.javalent.com";
export async function fetchItems(page = 0, perPage = 50) {
    return await (
        await fetch(`${BASE_URL}/api/items?page=${page}&pageSize=${perPage}`)
    ).json();
}

export async function fetchItem(item: string) {
    return await (await fetch(`${BASE_URL}/api/items/${item}`)).json();
}
