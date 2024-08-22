<script lang="ts">
    import type { Item } from "../types";

    export let data: Item;
    console.log("🚀 ~ file: +page.svelte:5 ~ data:", data);
</script>

<h1>{data.title}</h1>
