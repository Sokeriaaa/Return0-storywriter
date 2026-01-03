package sokeriaaa.return0.storywriter.data.map

import sokeriaaa.return0.shared.data.api.component.value.Value
import sokeriaaa.return0.shared.data.models.component.conditions.CommonCondition
import sokeriaaa.return0.shared.data.models.story.event.Event.TeleportUserTo
import sokeriaaa.return0.shared.data.models.story.map.MapData
import sokeriaaa.return0.shared.data.models.story.map.MapEvent
import sokeriaaa.return0.storywriter.data.SWEntities

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
            MapData.BuggyEntry(listOf(SWEntities.nullptr.name, SWEntities.nullptr.name)),
            MapData.BuggyEntry(listOf(SWEntities.memoryLeak.name, SWEntities.memoryLeak.name)),
            MapData.BuggyEntry(listOf(SWEntities.indexOutOfBounds.name, SWEntities.indexOutOfBounds.name)),
        ),
        difficulty = 1,
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