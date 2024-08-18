<script lang="ts">
</script>

<div class="relative max-h-[600px] flex">
    <div class="heading overlay w-1/2 flex pt-12 p-4 font-playfair">
        <h1 class="scroll-m-20 text-4xl font-extrabold tracking-tight lg:text-5xl">
            Discover treasures from museums around the world, all from the
            comfort of your screen.
        </h1>
    </div>
    <img src="splash.jpg" alt="Whale" class="object-cover" />
</div>

<style lang="scss">
    @import "../styles/colors";

    .overlay {
        position: absolute;
        height: 100%;
        z-index: 1;
        color: $primary-775;
    }
    .heading:before {
        content: "";
        background: $grey-225;
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        opacity: 0.75;
        z-index: -1;
    }
</style>
