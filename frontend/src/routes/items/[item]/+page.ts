import { fetchItem } from "$lib";

export async function load({ params }) {
    console.log("🚀 ~ file: +page.ts:4 ~ params:", params);

    return await fetchItem(params.item);
}
