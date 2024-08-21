<script lang="ts">
    import { Root } from "$lib/components/ui/button";
    import * as Card from "$lib/components/ui/card";
    import type { Item } from "../types";

    export let item: Item;
</script>

<Card.Root>
    <Card.Header>
        <Card.Title>
            {item.title}
        </Card.Title>
    </Card.Header>
    <Card.Content>
        {#if item.thumbnail}
            <img src={item.thumbnail} alt={item.title} width="100px"/>
        {/if}
    </Card.Content>
</Card.Root>
