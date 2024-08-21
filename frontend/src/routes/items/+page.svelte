<script lang="ts">
    import Item from "./components/Item.svelte";
    import type { ItemResponse } from "./types";

    export let data: { items: ItemResponse };
    console.log("🚀 ~ file: +page.svelte:5 ~ data:", data);
</script>

<h1>Items</h1>

<div class="items grid grid-cols-4 gap-4 m-4">
    {#each data.items.content as item}
        <Item {item} />
    {/each}
</div>
