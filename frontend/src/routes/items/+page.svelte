<script lang="ts">
    import Pagination from "$lib/components/items/Pagination.svelte";
    import { writable } from "svelte/store";
    import Item from "../../lib/components/items/ItemPreview.svelte";
    import type { ItemResponse } from "./types";
    import { fetchItems } from "$lib";

    export let data: ItemResponse;

    let page = writable(0);

    const go = async (page: number) => {
        console.log("🚀 ~ file: +page.svelte:13 ~ page:", page);

        data = await fetchItems(page);
    };
</script>

<h1>Items</h1>

<Pagination
    count={data.totalElements}
    perPage={data.pageable.pageSize}
    on:page={(evt) => go(evt.detail)}
></Pagination>
<div class="items grid md:grid-cols-2 lg:grid-cols-4 gap-4 m-4 grid-cols-1">
    {#each data.content as item (item.id)}
        <Item {item} />
    {/each}
</div>
