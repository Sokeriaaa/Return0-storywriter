package sokeriaaa.return0.storywriter.data.map

import sokeriaaa.return0.shared.data.api.component.value.Value
import sokeriaaa.return0.shared.data.models.component.conditions.CommonCondition
import sokeriaaa.return0.shared.data.models.story.event.Event
import sokeriaaa.return0.shared.data.models.story.map.MapData
import sokeriaaa.return0.shared.data.models.story.map.MapEvent
import sokeriaaa.return0.storywriter.data.SWEntities
import sokeriaaa.return0.storywriter.res.SWStrings

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
                    enabled = CommonCondition.True,
                    trigger = MapEvent.Trigger.INTERACTED,
                    lineNumber = 1,
                    display = "println(\"Hello World!\")",
                    blocksUser = CommonCondition.False,
                    event = Event.Sequence(
                        Event.Text.NPC(
                            nameRes = SWStrings.create(
                                key = "name.println",
                                value = "println",
                            ),
                            messageRes = SWStrings.create(
                                key = "dialogue.hello_world",
                                value = "Hello World!",
                            ),
                        ),
                        Event.Choice(
                            SWStrings.create(
                                key = "dialogue.save",
                                value = "Save for now",
                            ) to Event.RequestSave,
                            SWStrings.create(
                                key = "dialogue.move",
                                value = "Move to line 10",
                            ) to Event.MoveUserTo(Value(10)),
                            SWStrings.create(
                                key = "dialogue.ping",
                                value = "Ping!",
                            ) to Event.Text.NPC(
                                nameRes = "name.println",
                                messageRes = SWStrings.create(
                                    key = "dialogue.pong",
                                    value = "Pong!",
                                ),
                            ),
                            SWStrings.create(
                                key = "dialogue.leave",
                                value = "Leave",
                            ) to Event.Text.NPC(
                                nameRes = "name.println",
                                messageRes = SWStrings.create(
                                    key = "dialogue.nice_day",
                                    value = "Have a nice day!",
                                ),
                            ),
                        )
                    ),
                ),
                MapEvent(
                    enabled = CommonCondition.True,
                    trigger = MapEvent.Trigger.INTERACTED,
                    lineNumber = 5,
                    display = "programmingTraining()",
                    blocksUser = CommonCondition.False,
                    event = Event.Sequence(
                        Event.Text.NPC(
                            nameRes = SWStrings.create(
                                key = "name.programming_training",
                                value = "programmingTraining",
                            ),
                            messageRes = SWStrings.create(
                                key = "dialogue.start_train",
                                value = "Starting programming training.",
                            ),
                        ),
                        Event.Choice(
                            SWStrings.create(
                                key = "dialogue.start",
                                value = "Start",
                            ) to Event.Combat(
                                config = Event.Combat.Config(
                                    enemies = listOf(
                                        SWEntities.nullptr.name to Value(1),
                                        SWEntities.memoryLeak.name to Value(1),
                                        SWEntities.indexOutOfBounds.name to Value(1),
                                    )
                                )
                            ),
                            SWStrings.create(
                                key = "dialogue.later",
                                value = "Later",
                            ) to Event.Empty,
                        )
                    ),
                ),
                MapEvent(
                    enabled = CommonCondition.True,
                    trigger = MapEvent.Trigger.INTERACTED,
                    lineNumber = 5,
                    display = "recovery(allEntities)",
                    blocksUser = CommonCondition.False,
                    event = Event.Sequence(
                        Event.RecoverAll,
                        Event.Text.Narrator(
                            messageRes = SWStrings.create(
                                key = "dialogue.recover_all",
                                value = "All the entities in the activated team have been recovered!.",
                            )
                        ),
                    ),
                ),
            ),
        )
    )
}