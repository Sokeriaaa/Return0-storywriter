package sokeriaaa.return0.storywriter.data.map

import sokeriaaa.return0.shared.data.api.component.value.Value
import sokeriaaa.return0.shared.data.models.component.conditions.CommonCondition
import sokeriaaa.return0.shared.data.models.entity.category.Category
import sokeriaaa.return0.shared.data.models.story.event.Event.TeleportUserTo
import sokeriaaa.return0.shared.data.models.story.map.MapData
import sokeriaaa.return0.shared.data.models.story.map.MapEvent
import sokeriaaa.return0.storywriter.data.entities.SWEntitiesCommon

@Suppress("UnusedReceiverParameter")
val SWMaps.stack_frame_ruins: MapData
    get() = MapData(
        name = "stack_frame_ruins",
        lines = 134,
        buggyRange = listOf(
            10 to 43,
            78 to 124,
        ),
        buggyEntries = listOf(
            MapData.BuggyEntry(
                listOf(
                    SWEntitiesCommon.getCommonEnemy(Category.VOID, 0).name,
                    SWEntitiesCommon.getCommonEnemy(Category.VOID, 0).name
                ),
                difficulty = 1,
            ),
            MapData.BuggyEntry(
                listOf(
                    SWEntitiesCommon.getCommonEnemy(Category.MEMORY, 0).name,
                    SWEntitiesCommon.getCommonEnemy(Category.MEMORY, 0).name
                ),
                difficulty = 1,
            ),
            MapData.BuggyEntry(
                listOf(
                    SWEntitiesCommon.getCommonEnemy(Category.VOID, 0).name,
                    SWEntitiesCommon.getCommonEnemy(Category.MEMORY, 0).name
                ),
                difficulty = 1,
            ),
        ),
        events = listOf(
            navigateUpEvent,
        )
    )

private val navigateUpEvent: MapEvent = MapEvent(
    enabled = CommonCondition.True,
    trigger = MapEvent.Trigger.INTERACTED,
    lineNumber = 1,
    display = "navigateUp()",
    event = TeleportUserTo(
        SWMaps.null_view.name,
        Value(42),
    ),
)