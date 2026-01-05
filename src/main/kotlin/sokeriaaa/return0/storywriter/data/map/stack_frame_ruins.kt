package sokeriaaa.return0.storywriter.data.map

import sokeriaaa.return0.shared.common.helpers.TimeHelper
import sokeriaaa.return0.shared.data.api.component.condition.IF
import sokeriaaa.return0.shared.data.api.component.condition.not
import sokeriaaa.return0.shared.data.api.component.value.Value
import sokeriaaa.return0.shared.data.models.component.common.Comparator
import sokeriaaa.return0.shared.data.models.component.conditions.CommonCondition
import sokeriaaa.return0.shared.data.models.component.conditions.EventCondition
import sokeriaaa.return0.shared.data.models.component.values.EventValue
import sokeriaaa.return0.shared.data.models.component.values.TimeValue
import sokeriaaa.return0.shared.data.models.entity.category.Category
import sokeriaaa.return0.shared.data.models.story.event.Event
import sokeriaaa.return0.shared.data.models.story.event.Event.TeleportUserTo
import sokeriaaa.return0.shared.data.models.story.map.MapData
import sokeriaaa.return0.shared.data.models.story.map.MapEvent
import sokeriaaa.return0.storywriter.data.entities.SWEntitiesCommon
import sokeriaaa.return0.storywriter.data.quest.SWQuests
import sokeriaaa.return0.storywriter.data.story.SWDialogueNames.`object`
import sokeriaaa.return0.storywriter.data.story.SWDialogueNames.stringbuilder
import sokeriaaa.return0.storywriter.utils.dialogueResCounter

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
            stackFrameRuins01,
            enemy01,
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

private val stackFrameRuins01: MapEvent = MapEvent(
    enabled = !EventCondition.QuestCompleted(SWQuests.c01_journey_start.key),
    trigger = MapEvent.Trigger.ENTERED,
    event = dialogueResCounter("stack_frame_ruins01") {
        Event.Sequence(
            narrator("Ahead of you, the land rises into a chaotic vertical sprawl — stack_frame_ruins."),
            narrator("Towering slabs of memory are piled on top of one another, some cracked, some frozen mid-collapse."),
            narrator("Entire structures lean at impossible angles, as if time stopped halfway through a recursive call."),
            narrator("Threads of light descend from above, but many of them loop back upward instead of terminating."),
            narrator("The air feels... heavy. Like too many functions waiting to return."),
            npc(stringbuilder, "Depth increasing."),
            npc(stringbuilder, "Unsafe recursion likely."),
            narrator("Its body subtly rearranges, compacting its structure as if bracing for pressure."),
            narrator("Object floats forward, surveying the ruins with a stillness that feels deliberate."),
            npc(`object`, "This is the stack_frame_ruins."),
            npc(`object`, "A region formed from calls that exceeded their limits."),
            npc(`object`, "Execution continued."),
            npc(`object`, "Return did not."),
            user("So... systems that never unwound."),
            npc(`object`, "Correct."),
            npc(`object`, "They were not incorrect."),
            npc(`object`, "They were simply... unfinished."),
            npc(`object`, "Be aware."),
            npc(`object`, "Some areas here are unstable."),
            user("As if on cue, something skitters deep within one of those distorted regions — a brief flash of malformed data before it disappears."),
            npc(`object`, "Corruption manifests strongest where structure weakens."),
            npc(`object`, "Entering these zones may trigger hostile processes."),
            npc(`object`, "Bugs do not patrol."),
            npc(`object`, "They emerge."),
            npc(stringbuilder, "Probability-based encounters."),
            user("...So if we walk through those areas—"),
            npc(`object`, "You may be interrupted."),
            npc(`object`, "Avoidance is possible."),
            npc(`object`, "But experience often lies within instability."),
            narrator("That feels like less advice and more like a warning."),
            npc(stringbuilder, "Recommend short engagements."),
            npc(stringbuilder, "Extended conflict will increase memory cost."),
            Event.HideMap,
            narrator("So this is it."),
            narrator("No scripts. No guarantees."),
            narrator("Just execution."),
            Event.ShowMap,
            narrator("You looks at the ruins again — at the looping towers, the unstable zones, the paths that might or might not return."),
            user("Alright."),
            user("Let's see how deep this stack goes."),

            Event.CompleteQuest(SWQuests.c01_journey_start.key),
            Event.ClaimQuest(SWQuests.c01_arrive_syntaxis.key),
            tips("Now, you are free to move, explore, and discover what happens when a system keeps calling... without ever knowing how to return."),
            tips("Some sections of the map are buggy section. When you step into it, you may encounter bugs at any time which you should combat with."),
        )
    },
)

private val enemy01: MapEvent = MapEvent(
    enabled = EventCondition.CompareTime(Comparator.GT, "stack_frame_ruins_enemy01_respawn"),
    trigger = MapEvent.Trigger.INTERACTED,
    lineNumber = 64,
    display = "catch(e: OutOfMemoryPulse)",
    event = dialogueResCounter("stack_frame_ruins_enemy01") {
        IF(EventCondition.QuestCompleted(SWQuests.c01_arrive_syntaxis.key))
            .then(
                ifTrue = Event.Choice(
                    text("Call") to Event.Combat(
                        config = Event.Combat.Config(
                            enemies = listOf(
                                SWEntitiesCommon.getCommonEnemy(Category.MEMORY, 2).name to EventValue.EnemyLevel(6)
                            ),
                        ),
                        success = Event.SaveTimeStamp(
                            key = "stack_frame_ruins_enemy01_respawn",
                            time = TimeValue.After(6 * TimeHelper.ONE_HOUR),
                        )
                    ),
                    text("Leave") to Event.Empty,
                ),
                ifFalse = npc(`object`, "This is a caught critical bug. We'd better not activate it for now..."),
            )
    }
)