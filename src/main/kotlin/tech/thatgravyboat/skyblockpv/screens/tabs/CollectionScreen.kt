package tech.thatgravyboat.skyblockpv.screens.tabs

import com.mojang.authlib.GameProfile
import earth.terrarium.olympus.client.components.base.ListWidget
import net.minecraft.client.gui.layouts.FrameLayout
import net.minecraft.world.item.ItemStack
import tech.thatgravyboat.skyblockapi.utils.extentions.toFormattedString
import tech.thatgravyboat.skyblockapi.utils.text.Text
import tech.thatgravyboat.skyblockpv.api.CollectionAPI
import tech.thatgravyboat.skyblockpv.api.CollectionAPI.getProgressToNextLevel
import tech.thatgravyboat.skyblockpv.api.data.SkyblockProfile
import tech.thatgravyboat.skyblockpv.data.CollectionItem
import tech.thatgravyboat.skyblockpv.screens.BasePvScreen
import tech.thatgravyboat.skyblockpv.utils.Utils.round
import tech.thatgravyboat.skyblockpv.utils.displays.*

class CollectionScreen(gameProfile: GameProfile, profile: SkyblockProfile? = null) : BasePvScreen("COLLECTION", gameProfile, profile) {

    private var currentCategory = "MINING"

    override fun create(bg: DisplayWidget) {
        val columnHeight = uiHeight - 20

        val profile = profile ?: return
        val scrollable = ListWidget(uiWidth, columnHeight)
        val filteredCollections = profile.collections.filter { it.category == currentCategory }
        val table = buildList {
            filteredCollections.chunked(2).forEach { chunk ->
                val row = buildList {
                    chunk.getOrNull(0)?.let { add(getElement(it)) }
                    chunk.getOrNull(1)?.let { add(getElement(it)) }
                }
                add(row)
            }
        }.asTable(5).centerIn(uiWidth, -1).asWidget()

        scrollable.add(table)

        FrameLayout.centerInRectangle(scrollable, bg.x, bg.y, bg.width, bg.height)

        scrollable.visitWidgets(this::addRenderableWidget)
    }

    private fun getElement(col: CollectionItem): Display {
        val collectionEntry = CollectionAPI.getCollectionEntry(col.itemId) ?: return Displays.text("Unknown Item")
        val prog = collectionEntry.getProgressToNextLevel(col.amount)
        val display = Displays.row(
            Displays.item(col.itemStack ?: ItemStack.EMPTY),
            listOf(
                Displays.text(Text.join(col.itemStack?.hoverName ?: col.itemId, ": ${col.amount.toFormattedString()}")),
                listOf(Displays.progress(prog.second), Displays.text("${(prog.second * 100).round()}% to ${prog.first}")).toRow(3),
            ).toColumn(1),
            spacing = 5,
            alignment = Alignment.CENTER,
        )
        return display
    }
}
