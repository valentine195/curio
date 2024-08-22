<script lang="ts">
    import * as Pagination from "$lib/components/ui/pagination";
    import { createEventDispatcher } from "svelte";

    const dispatch = createEventDispatcher<{
        page: number;
    }>();
    export let count: number, perPage: number;
    const test = (page: number) => {
        console.log(page);
        dispatch("page", page);
    }
</script>

<Pagination.Root {count} {perPage} let:pages let:currentPage>
    <Pagination.Content>
        <Pagination.Item>
            <Pagination.PrevButton
                on:click={() => dispatch("page", (currentPage ?? 1) - 1)}
            />
        </Pagination.Item>
        {#each pages as page (page.key)}
            {#if page.type === "ellipsis"}
                <Pagination.Item>
                    <Pagination.Ellipsis />
                </Pagination.Item>
            {:else}
                <Pagination.Item>
                    <Pagination.Link
                        {page}
                        isActive={currentPage == page.value}
                        on:click={() => test(page.value)}
                    >
                        {page.value}
                    </Pagination.Link>
                </Pagination.Item>
            {/if}
        {/each}
        <Pagination.Item>
            <Pagination.NextButton
                on:click={() => dispatch("page", (currentPage ?? 1) - 1)}
            />
        </Pagination.Item>
    </Pagination.Content>
</Pagination.Root>
