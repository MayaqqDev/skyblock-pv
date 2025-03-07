package tech.thatgravyboat.skyblockpv.screens

import com.mojang.authlib.GameProfile
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import tech.thatgravyboat.skyblockpv.api.data.SkyBlockProfile
import tech.thatgravyboat.skyblockpv.screens.tabs.*
import kotlin.reflect.KClass

enum class PvTabs(val screen: KClass<out BasePvScreen>, val icon: ItemStack) {
    MAIN(MainScreen::class, ItemStack.EMPTY),
    DUNGEON(DungeonScreen::class, Items.DIAMOND_SWORD.defaultInstance),
    COLLECTION(CollectionScreen::class, Items.ITEM_FRAME.defaultInstance),
    MOB(MobScreen::class, Items.ZOMBIE_HEAD.defaultInstance),
    MINING(MiningScreen::class, Items.DIAMOND_PICKAXE.defaultInstance),
    ;

    fun create(gameProfile: GameProfile): BasePvScreen {
        return screen.constructors.first().call(gameProfile, null)
    }

    fun create(gameProfile: GameProfile, profile: SkyBlockProfile?): BasePvScreen {
        return screen.constructors.first().call(gameProfile, profile)
    }
}
