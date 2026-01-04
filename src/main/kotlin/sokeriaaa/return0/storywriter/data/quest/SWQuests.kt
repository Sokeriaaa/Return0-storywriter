package sokeriaaa.return0.storywriter.data.quest

import sokeriaaa.return0.shared.data.models.story.currency.CurrencyType
import sokeriaaa.return0.shared.data.models.story.quest.QuestData
import sokeriaaa.return0.storywriter.data.map.SWMaps
import sokeriaaa.return0.storywriter.data.map.null_view
import sokeriaaa.return0.storywriter.res.SWStrings

object SWQuests {

    // Chapters
    val chapter01 = quest(
        key = "chapter01",
        name = "Chapter I: Compilation Error",
        priority = 1,
        description = "",
    )

    // Main
    val c01_string_builder = quest(
        key = "c01_string_builder",
        name = "Meet StringBuilder",
        description = "Talk with StringBuilder.",
        priority = 1,
        navigation = SWMaps.null_view.name to 5,
    )
    val c01_journey_start = quest(
        key = "c01_journey_start",
        name = "Journey Start!",
        description = "Move to the edge of null_view, find the entrance of stack_frame_ruins.",
        priority = 1,
        navigation = SWMaps.null_view.name to 42,
    )

    // Branch

    // All quests
    val quests = listOf(
        chapter01,
        c01_string_builder,
        c01_journey_start,
    )

    private fun quest(
        key: String,
        name: String,
        description: String,
        priority: Int,
        navigation: Pair<String, Int>? = null,
        currencyRewards: Map<CurrencyType, Int>? = null,
        inventoryRewards: Map<String, Int>? = null,
    ): QuestData = QuestData(
        key = key,
        nameRes = SWStrings.create(
            "quest.$key",
            name,
        ),
        descriptionRes = SWStrings.create(
            "quest.$key.desc",
            description,
        ),
        priority = priority,
        navigation = navigation,
        currencyRewards = currencyRewards,
        inventoryRewards = inventoryRewards,
    )

}