<script>
    import "../app.scss";
    import Search from "lucide-svelte/icons/search";
</script>

<div class="flex flex-col h-lvh">
    <header
        class="bg-background sticky top-0 flex h-16 items-center gap-4 border-b px-4 md:px-6"
    >
        <nav
            class="hidden flex-col gap-6 text-lg font-medium md:flex md:flex-row md:items-center md:gap-5 md:text-sm lg:gap-6"
        >
            <a
                href="##"
                class="flex items-center gap-2 text-lg font-semibold md:text-base"
            >
                <Search class="h-6 w-6" />
                <h3 class='text-xl text-primary-600'>Curio</h3>
            </a>
            <a
                href="##"
                class="text-foreground hover:text-foreground transition-colors"
            >
                Home
            </a>
            <a
                href="##"
                class="text-muted-foreground hover:text-foreground transition-colors"
            >
                About
            </a>
        </nav>
    </header>

    <div class="bg-light_shade-100 app h-full">
        <slot></slot>
    </div>
</div>
