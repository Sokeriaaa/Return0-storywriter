package sokeriaaa.return0.storywriter.data.map

import sokeriaaa.return0.shared.data.api.component.condition.not
import sokeriaaa.return0.shared.data.api.component.value.Value
import sokeriaaa.return0.shared.data.models.component.conditions.CommonCondition
import sokeriaaa.return0.shared.data.models.component.conditions.EventCondition
import sokeriaaa.return0.shared.data.models.story.event.Event
import sokeriaaa.return0.shared.data.models.story.event.Event.TeleportUserTo
import sokeriaaa.return0.shared.data.models.story.map.MapData
import sokeriaaa.return0.shared.data.models.story.map.MapEvent
import sokeriaaa.return0.storywriter.data.map.routehub.SWRouteHub
import sokeriaaa.return0.storywriter.data.quest.SWQuests
import sokeriaaa.return0.storywriter.data.story.SWDialogueNames.`object`
import sokeriaaa.return0.storywriter.data.story.SWDialogueNames.stringbuilder
import sokeriaaa.return0.storywriter.data.story.SWDialogueNames.validator
import sokeriaaa.return0.storywriter.utils.dialogueResCounter

@Suppress("UnusedReceiverParameter")
val SWMaps.syntaxis: MapData
    get() = MapData(
        name = "syntaxis",
        lines = 82,
        buggyRange = listOf(),
        buggyEntries = listOf(),
        events = listOf(
            SWRouteHub.commonHub(lineNumber = 8),
            stringPoolOasisEvent,
            syntaxis01,
            validator1,
        ),
    )

private val stringPoolOasisEvent: MapEvent = MapEvent(
    enabled = CommonCondition.True,
    trigger = MapEvent.Trigger.INTERACTED,
    lineNumber = 1,
    display = "moveTo(string_pool_oasis)",
    event = TeleportUserTo(
        SWMaps.string_pool_oasis.name,
        Value(155),
    ),
)

private val syntaxis01: MapEvent = MapEvent(
    enabled = !EventCondition.SavedSwitch("syntaxis01"),
    trigger = MapEvent.Trigger.ENTERED,
    event = dialogueResCounter("syntaxis01") {
        Event.Sequence(
            Event.SaveSwitch("syntaxis01", CommonCondition.True),
            Event.RefreshEvents,
            user("So this is syntaxis..."),
            user("Everything feels... strict."),
            npc(`object`, "syntaxis enforces form."),
            npc(`object`, "Here, intent must be expressed correctly, or not at all."),
            narrator("StringBuilder scans the surroundings. Characters detach from nearby signs, rearranging themselves smoothly before snapping back into place."),
            npc(stringbuilder, "High structural integrity."),
            npc(stringbuilder, "Low tolerance for deviation."),
            narrator("A distant clang echoes—something collapsing, then rapidly rebuilding itself in a new, correct shape."),
            user("Let me guess. One mistake..."),
            user("...and execution halts."),
            npc(`object`, "Or worse."),
            npc(stringbuilder, "Errors here propagate fast."),
            npc(stringbuilder, "Correction windows are small."),
            user("Figures."),
            narrator("You look deeper into the city—avenues branching like decision trees, guards formed from rigid constructs watching silently, logic flowing clean and unforgiving."),
            user("Then we don't rush."),
            user("We read carefully. We move carefully."),
            narrator("Object's glow stabilizes."),
            npc(`object`, "Acknowledged."),
            narrator("StringBuilder's form tightens, characters aligning into a more defensive configuration."),
            npc(stringbuilder, "Ready to construct."),
            user("Alright, syntaxis."),
            user("Let's see how much order you can handle."),
            Event.CompleteQuest(SWQuests.c01_continue_the_journey.key),
            Event.ClaimQuest(SWQuests.c01_explore_syntaxis.key),
        )
    }
)

private val validator1: MapEvent = MapEvent(
    enabled = !EventCondition.SavedSwitch("syntaxis_validator1"),
    trigger = MapEvent.Trigger.INTERACTED,
    lineNumber = 26,
    display = "Validator()",
    blocksUser = CommonCondition.True,
    event = dialogueResCounter("null_view_validator01") {
        Event.Sequence(
            npc(validator, "Execution paused."),
            npc(validator, "Your traversal violates local constraints."),
            user("We walked in through the main path."),
            npc(validator, "Correct."),
            npc(validator, "You also carry unresolved references."),
            npc(`object`, "Clarify: unresolved."),
            npc(validator, "An entity without a declared type."),
            npc(validator, "Observed at string_pool_oasis."),
            npc(stringbuilder, "Encounter confirmed."),
            user("You know about it too."),
            npc(validator, "All deviations are logged."),
            npc(validator, "syntaxis exists to prevent collapse."),
            narrator("The barrier dissolves, but the tension remains."),
            narrator("Validator gestures, and the surrounding city briefly overlays with translucent diagrams—parse trees, grammar rules, flow validations."),
            npc(validator, "This city is built on form."),
            npc(validator, "Meaning is irrelevant unless it is expressible."),
            npc(validator, "Here, even truth must compile."),
            user("So syntaxis doesn't care *what* you want to do."),
            user("Only whether you say it correctly."),
            npc(validator, "Precisely."),
            npc(stringbuilder, "Efficient."),
            npc(stringbuilder, "But brittle."),
            npc(validator, "Brittleness is the cost of certainty."),
            user("That thing we met."),
            user("The one that didn't break any rules—but didn't follow them either."),
            npc(validator, "It is not corruption."),
            npc(validator, "It is not an exception."),
            npc(validator, "It is absence... treated as presence."),
            npc(`object`, "An untyped value."),
            npc(`object`, "Accepted by the system."),
            npc(validator, "And therefore dangerous."),
            npc(validator, "syntaxis cannot stop it."),
            npc(validator, "At best, we delay it."),
            narrator("You feel a familiar chill—the same one she felt in Lawrence's office, when the decision had already been made but not yet spoken."),
            user("So this city is a checkpoint."),
            user("Not a solution."),
            npc(validator, "Correct."),
            narrator("A distant alarm pulses through syntaxis—sharp, rhythmic, wrong."),
            narrator("Validator turns toward it instantly."),
            npc(validator, "Concurrent disturbance detected."),
            npc(validator, "Rules are being violated faster than they can be enforced."),
            npc(validator, "You are... unconventional."),
            npc(validator, "But currently valid."),
            npc(validator, "I will assist."),
            user("Let's keep things compiling."),
            npc(validator, "And do not forget—"),
            npc(validator, "Even nothing must follow the rules."),

            Event.SaveSwitch("validator1", CommonCondition.True),
            Event.CompleteQuest(SWQuests.c01_explore_syntaxis.key),
            Event.ClaimQuest(SWQuests.c01_go_forward.key),
            Event.RefreshEvents,
        )
    }
)