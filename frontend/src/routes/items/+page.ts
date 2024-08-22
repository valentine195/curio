import { fetchItems } from "$lib";

export async function load({ params }) {
    return await fetchItems();
}
