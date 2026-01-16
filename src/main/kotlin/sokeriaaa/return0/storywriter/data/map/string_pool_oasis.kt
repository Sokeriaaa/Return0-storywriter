package sokeriaaa.return0.storywriter.data.map

import sokeriaaa.return0.shared.data.api.component.condition.not
import sokeriaaa.return0.shared.data.api.component.value.Value
import sokeriaaa.return0.shared.data.models.component.conditions.CommonCondition
import sokeriaaa.return0.shared.data.models.component.conditions.EventCondition
import sokeriaaa.return0.shared.data.models.component.values.EventValue
import sokeriaaa.return0.shared.data.models.entity.category.Category
import sokeriaaa.return0.shared.data.models.story.currency.CurrencyType
import sokeriaaa.return0.shared.data.models.story.event.Event
import sokeriaaa.return0.shared.data.models.story.event.Event.TeleportUserTo
import sokeriaaa.return0.shared.data.models.story.map.MapData
import sokeriaaa.return0.shared.data.models.story.map.MapEvent
import sokeriaaa.return0.storywriter.data.entities.SWEntitiesCommon
import sokeriaaa.return0.storywriter.data.map.quiz.SWQuizzes
import sokeriaaa.return0.storywriter.data.map.routehub.SWRouteHub
import sokeriaaa.return0.storywriter.data.quest.SWQuests
import sokeriaaa.return0.storywriter.data.story.SWDialogueNames.`object`
import sokeriaaa.return0.storywriter.data.story.SWDialogueNames.stringbuilder
import sokeriaaa.return0.storywriter.data.story.SWDialogueNames.unknown
import sokeriaaa.return0.storywriter.utils.dialogueResCounter

val SWMaps.string_pool_oasis: MapData
    get() = MapData(
        name = "string_pool_oasis",
        lines = 155,
        buggyRange = listOf(
            28 to 50,
            71 to 102,
            122 to 137,
        ),
        buggyEntries = listOf(
            MapData.BuggyEntry(
                listOf(
                    SWEntitiesCommon.getCommonEnemy(Category.VOID, 0).name,
                    SWEntitiesCommon.getCommonEnemy(Category.VOID, 0).name
                ),
                difficulty = 2,
            ),
            MapData.BuggyEntry(
                listOf(
                    SWEntitiesCommon.getCommonEnemy(Category.MEMORY, 0).name,
                    SWEntitiesCommon.getCommonEnemy(Category.MEMORY, 0).name
                ),
                difficulty = 2,
            ),
            MapData.BuggyEntry(
                listOf(
                    SWEntitiesCommon.getCommonEnemy(Category.VOID, 0).name,
                    SWEntitiesCommon.getCommonEnemy(Category.MEMORY, 0).name
                ),
                difficulty = 2,
            ),
        ),
        failedAnchor = null_view.name to 1,
        events = listOf(
            SWRouteHub.commonHub(lineNumber = 58),
            navigateUpEvent,
            syntaxisEvent,
            stringPoolOasis01,
            stringPoolOasis02,
            nullDisplay,
            miniQuiz2,
        )
    )

private val navigateUpEvent: MapEvent = MapEvent(
    enabled = CommonCondition.True,
    trigger = MapEvent.Trigger.INTERACTED,
    lineNumber = 1,
    display = "navigateUp()",
    event = TeleportUserTo(
        SWMaps.stack_frame_ruins.name,
        Value(134),
    ),
)

private val syntaxisEvent: MapEvent = MapEvent(
    enabled = CommonCondition.True,
    trigger = MapEvent.Trigger.INTERACTED,
    lineNumber = 155,
    display = "moveTo(syntaxis)",
    event = TeleportUserTo(
        SWMaps.syntaxis.name,
        Value(1),
    ),
)

private val stringPoolOasis01: MapEvent = MapEvent(
    enabled = !EventCondition.SavedSwitch("string_pool_oasis01"),
    trigger = MapEvent.Trigger.ENTERED,
    event = dialogueResCounter("string_pool_oasis01") {
        Event.Sequence(
            Event.SaveSwitch("string_pool_oasis01", CommonCondition.True),
            Event.RefreshEvents,
            Event.HideMap,
            narrator("A wide basin opens before you."),
            Event.ShowMap,
            narrator("At its center lies a vast, mirror - like pool composed of flowing characters—glyphs, letters, fragments of strings drifting like plankton in clear water."),
            narrator("Some are immutable and crystalline, others dissolve and reform endlessly."),
            narrator("Warm light rises from the surface, and for the first time since entering the code realm, the place feels... almost peaceful."),

            user("This feels different."),
            npc(`object`, "This is the string_pool_oasis."),
            npc(`object`, "A shared reserve. Constants linger here longer than elsewhere."),
            npc(stringbuilder, "Low fragmentation."),
            npc(stringbuilder, "Efficient reuse."),
            narrator("You watch strings drift past—names, fragments of messages, half-finished identifiers."),
            user("So many words... but no meaning by themselves."),
            npc(`object`, "Meaning is assigned at use-time."),
            npc(`object`, "Until then, they wait."),
        )
    }
)

private val stringPoolOasis02: MapEvent = MapEvent(
    enabled = !EventCondition.SavedSwitch("string_pool_oasis02"),
    trigger = MapEvent.Trigger.OVERLAPPED,
    lineNumber = 107,
    event = dialogueResCounter("string_pool_oasis02") {
        Event.Sequence(
            Event.SaveSwitch("string_pool_oasis02", CommonCondition.True),
            Event.RefreshEvents,
            npc(stringbuilder, "Unexpected state."),
            npc(stringbuilder, "No allocation detected... yet presence confirmed."),
            narrator("You feel it then — a familiar hollow pressure, like a variable declared but never initialized."),
            narrator("The surface of the pool darkens."),
            narrator("Not corrupted."),
            narrator("Not broken."),
            narrator("Just... empty."),
            narrator("From that emptiness, something observes."),

            Event.SaveSwitch("string_pool_oasis02_null_display", CommonCondition.True),
            Event.RefreshEvents,
            narrator("A shape forms above the pool."),
            narrator("It has no fixed outline—edges collapse inward, then stretch outward again."),
            narrator("Light bends around it, refusing to define it clearly."),
            narrator("No hostility."),
            narrator("No movement."),
            narrator("Just existence."),
            npc(unknown, "You made it further than expected."),
            user("Who are you?"),
            npc(unknown, "That depends."),
            npc(unknown, "Do you want an answer... or a value?"),
            npc(`object`, "Unidentified entity."),
            npc(`object`, "You are outside expected execution."),
            npc(unknown, "So are you."),
            npc(unknown, "You cling to structure."),
            npc(unknown, "She clings to purpose."),
            user("You know me?"),
            npc(unknown, "I know what happens when nothing is assigned."),
            npc(unknown, "When the system expects a value..."),
            npc(unknown, "And receives silence."),
            npc(stringbuilder, "Threat level: unclear."),
            npc(unknown, "I am not your enemy."),
            npc(unknown, "...Not yet."),
            narrator("The shape begins to dissolve, not fading, but withdrawing, as if stepping backward into an absence that was already there."),
            Event.SaveSwitch("string_pool_oasis02_null_display", CommonCondition.False),
            Event.RefreshEvents,
            npc(unknown, "We will speak again."),
            npc(unknown, "When you are closer to *returning*."),
            user("...That wasn’t corruption."),
            npc(`object`, "Correct."),
            npc(`object`, "That was intent."),
            narrator("StringBuilder looks down at its own form, characters momentarily destabilizing before re-locking into place."),
            npc(stringbuilder, "Encounter logged."),
            npc(stringbuilder, "Unresolved reference."),
            narrator("You look ahead. Beyond the oasis, stone paths reform into orderly lines."),
            narrator("Symbols arrange themselves into grammar. Rules become visible again."),
            narrator("A town stands in the distance."),
            npc(`object`, "Forward lies syntaxis."),
            npc(`object`, "Structure resumes there."),
            Event.HideMap,
            narrator("So even here… nothing stays undefined forever."),
            Event.CompleteQuest(SWQuests.c01_arrive_syntaxis.key),
            Event.ClaimQuest(SWQuests.c01_continue_the_journey.key),
            Event.ShowMap,
        )
    },
)

private val nullDisplay: MapEvent = MapEvent(
    enabled = EventCondition.SavedSwitch("string_pool_oasis02_null_display"),
    trigger = MapEvent.Trigger.INTERACTED,
    lineNumber = 108,
    display = "`???`()",
    event = Event.Empty,
)

private val miniQuiz2: MapEvent = SWQuizzes.createQuiz(
    id = 2,
    lineNumber = 60,
    q = "What does `val` represent in Kotlin?",
    a = listOf(
        "A mutable variable",
        "An immutable reference",
        "A compile-time constant",
    ),
    correctIndex = 1,
    onCorrect = Event.CurrencyChange(
        currency = CurrencyType.CRYPTO,
        change = Value(2),
    ),
    onWrong = Event.Combat(
        config = Event.Combat.Config(
            enemies = listOf(
                SWEntitiesCommon.getCommonEnemy(Category.DEBUG, 0).name to EventValue.EnemyLevel(2),
                SWEntitiesCommon.getCommonEnemy(Category.DEBUG, 0).name to EventValue.EnemyLevel(2),
            )
        )
    ),
)