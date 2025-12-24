package sokeriaaa.return0.storywriter.data.map

import sokeriaaa.return0.shared.data.models.story.event.Event
import sokeriaaa.return0.shared.data.models.story.event.condition.EventCondition
import sokeriaaa.return0.shared.data.models.story.event.value.EventValue
import sokeriaaa.return0.shared.data.models.story.map.MapData
import sokeriaaa.return0.shared.data.models.story.map.MapEvent
import sokeriaaa.return0.storywriter.data.SWEntities

object SWMaps {
    val maps = listOf(
        MapData(
            name = "entrance",
            lines = 420,
            buggyRange = listOf(
                20 to 80,
                200 to 300,
            ),
            buggyEntries = listOf(
                MapData.BuggyEntry(listOf(SWEntities.nullptr.name)),
                MapData.BuggyEntry(listOf(SWEntities.memoryLeak.name)),
                MapData.BuggyEntry(listOf(SWEntities.indexOutOfBounds.name)),
            ),
            difficulty = 1,
            events = listOf(
                MapEvent(
                    enabled = EventCondition.True,
                    trigger = MapEvent.Trigger.INTERACTED,
                    lineNumber = 1,
                    display = "println(\"Hello World!\")",
                    blocksUser = EventCondition.False,
                    event = Event.Sequence(
                        // TODO use res
                        Event.Text.NPC(
                            nameRes = "println",
                            messageRes = "Hello World!",
                        ),
                        Event.Choice(
                            "Save for now" to Event.RequestSave,
                            "Move to line 10" to Event.MoveUserTo(EventValue.Constant(10)),
                            "Ping!" to Event.Text.NPC(
                                nameRes = "println",
                                messageRes = "Pong!",
                            ),
                            "Leave" to Event.Text.NPC(
                                nameRes = "println",
                                messageRes = "Have a nice day!",
                            ),
                        )
                    ),
                ),
                MapEvent(
                    enabled = EventCondition.True,
                    trigger = MapEvent.Trigger.INTERACTED,
                    lineNumber = 5,
                    display = "programmingTraining()",
                    blocksUser = EventCondition.False,
                    event = Event.Sequence(
                        // TODO use res
                        Event.Text.NPC(
                            nameRes = "programmingTraining",
                            messageRes = "Starting programming training.",
                        ),
                        Event.Choice(
                            "Start" to Event.Combat(
                                config = Event.Combat.Config(
                                    enemies = listOf(
                                        SWEntities.nullptr.name to EventValue.Constant(1),
                                        SWEntities.memoryLeak.name to EventValue.Constant(1),
                                        SWEntities.indexOutOfBounds.name to EventValue.Constant(1),
                                    )
                                )
                            ),
                            "Later" to Event.Empty,
                        )
                    ),
                ),
                MapEvent(
                    enabled = EventCondition.True,
                    trigger = MapEvent.Trigger.INTERACTED,
                    lineNumber = 5,
                    display = "recovery(allEntities)",
                    blocksUser = EventCondition.False,
                    event = Event.Sequence(
                        // TODO use res
                        Event.RecoverAll,
                        Event.Text.Narrator(
                            messageRes = "All the entities in the activated team have been recovered!.",
                        ),
                    ),
                )
            ),
        )
    )
}