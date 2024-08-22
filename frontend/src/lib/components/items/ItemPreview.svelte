<script lang="ts">
    import * as Card from "$lib/components/ui/card";
    import type { Item } from "../../../routes/items/types";

    export let item: Item;
</script>

<a href="/items/{item.id}">
    <Card.Root class="item shadow-md">
        <Card.Header>
            <Card.Title>
                {item.title}
            </Card.Title>
        </Card.Header>
        <Card.Content>
            {#if item.thumbnail}
                <img src={item.thumbnail} alt={item.title} width="100px" />
            {/if}
        </Card.Content>
    </Card.Root>
</a>

<style>
</style>
