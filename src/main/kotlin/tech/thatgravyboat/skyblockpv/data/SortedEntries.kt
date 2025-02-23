package tech.thatgravyboat.skyblockpv.data

object SortedEntries {
    private val sortedList = listOf(
        // Skills
        "SKILL_COMBAT",
        "SKILL_FARMING",
        "SKILL_FISHING",
        "SKILL_MINING",
        "SKILL_FORAGING",
        "SKILL_ENCHANTING",
        "SKILL_ALCHEMY",
        "SKILL_CARPENTRY",
        "SKILL_RUNECRAFTING",
        "SKILL_TAMING",
        "SKILL_SOCIAL",

        // Collections
        "WHEAT",
        "CARROT_ITEM",
        "POTATO_ITEM",
        "PUMPKIN",
        "MELON",
        "SEEDS",
        "MUSHROOM_COLLECTION",
        "INK_SACK:3",
        "CACTUS",
        "SUGAR_CANE",
        "FEATHER",
        "LEATHER",
        "PORK",
        "RAW_CHICKEN",
        "MUTTON",
        "RABBIT",
        "NETHER_STALK",
        "COBBLESTONE",
        "COAL",
        "IRON_INGOT",
        "GOLD_INGOT",
        "DIAMOND",
        "INK_SACK:4",
        "EMERALD",
        "REDSTONE",
        "QUARTZ",
        "OBSIDIAN",
        "GLOWSTONE_DUST",
        "GRAVEL",
        "ICE",
        "NETHERRACK",
        "SAND",
        "ENDER_STONE",
        "MITHRIL_ORE",
        "HARD_STONE",
        "GEMSTONE_COLLECTION",
        "MYCEL",
        "SAND:1",
        "SULPHUR_ORE",
        "GLACITE",
        "TUNGSTEN",
        "UMBER",
        "ROTTEN_FLESH",
        "BONE",
        "STRING",
        "SPIDER_EYE",
        "SULPHUR",
        "ENDER_PEARL",
        "GHAST_TEAR",
        "SLIME_BALL",
        "BLAZE_ROD",
        "MAGMA_CREAM",
        "CHILI_PEPPER",
        "RAW_FISH",
        "RAW_FISH:1",
        "RAW_FISH:2",
        "RAW_FISH:3",
        "PRISMARINE_SHARD",
        "PRISMARINE_CRYSTALS",
        "CLAY_BALL",
        "WATER_LILY",
        "INK_SACK",
        "SPONGE",
        "MAGMA_FISH",
        "AGARICUS_CAP",
        "CADUCOUS_STEM",
        "HALF_EATEN_CARROT",
        "HEMOVIBE",
        "METAL_HEART",
        "WILTED_BERBERIS",
        "TIMITE",

        // Slayer
        "zombie",
        "spider",
        "wolf",
        "enderman",
        "blaze",
        "vampire",
    )

    fun List<String>.sortToSkyBlockOrder() = sortedBy { sortedList.indexOf(it) }
    fun <T : Any> Map<String, T>.sortToSkyBlockOrder() = toList().sortedBy { sortedList.indexOf(it.first) }.toMap()
}
