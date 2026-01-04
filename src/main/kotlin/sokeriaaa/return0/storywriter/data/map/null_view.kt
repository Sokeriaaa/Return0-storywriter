package sokeriaaa.return0.storywriter.data.map

import sokeriaaa.return0.shared.data.api.component.condition.and
import sokeriaaa.return0.shared.data.api.component.condition.not
import sokeriaaa.return0.shared.data.api.component.value.Value
import sokeriaaa.return0.shared.data.models.component.conditions.CommonCondition
import sokeriaaa.return0.shared.data.models.component.conditions.EventCondition
import sokeriaaa.return0.shared.data.models.story.event.Event
import sokeriaaa.return0.shared.data.models.story.event.Event.TeleportUserTo
import sokeriaaa.return0.shared.data.models.story.map.MapData
import sokeriaaa.return0.shared.data.models.story.map.MapEvent
import sokeriaaa.return0.storywriter.data.entities.SWEntities
import sokeriaaa.return0.storywriter.data.quest.SWQuests
import sokeriaaa.return0.storywriter.data.story.SWDialogueNames.`object`
import sokeriaaa.return0.storywriter.data.story.SWDialogueNames.stringbuilder
import sokeriaaa.return0.storywriter.utils.dialogueResCounter


@Suppress("UnusedReceiverParameter")
val SWMaps.null_view: MapData
    get() = MapData(
        name = "null_view",
        lines = 42,
        buggyRange = emptyList(),
        buggyEntries = emptyList(),
        events = listOf(
            nullViewEvent01,
            stringBuilder1,
            stackFrameRuinsEvent,
        )
    )

private val nullViewEvent01: MapEvent = MapEvent(
    enabled = !EventCondition.SavedSwitch("intro_finished"),
    trigger = MapEvent.Trigger.ENTERED,
    event = dialogueResCounter("null_view_event01") {
        Event.Sequence(
            narrator("One step, and the instability vanishes. You arrive at null_view."),
            narrator("The land here is calm—deliberately so."),
            narrator("A wide, elevated plateau of stable memory blocks stretches out beneath a dim, steady sky."),
            narrator("Threads converge overhead, flowing smoothly like carefully scheduled processes."),
            narrator("No flicker. No jitter."),
            narrator("This place feels... held."),
            narrator("At the center of null_view stands a simple structure: a low, open pavilion formed from clean, mutable panels."),
            narrator("Its shape subtly shifts, expanding and contracting, as if testing different configurations before settling again."),
            npc(`object`, "This is null_view."),
            npc(`object`, "A stable reference point created from unresolved state. A contradiction, by definition."),
            narrator("You take a breath. For the first time since entering the Grid, nothing attacks you."),
            user("So this world... it really mirrors all software systems?"),
            npc(`object`, "It *is* them."),
            narrator("The horizon shifts, revealing layered vistas: farmland-like memory regions, towering class-structures, rivers branching and rejoining like flow control."),
            npc(`object`, "Every application in your world casts a projection here."),
            npc(`object`, "Simple scripts create shallow terrain."),
            npc(`object`, "Large systems... form continents."),
            npc(`object`, "Most humans never perceive it."),
            npc(`object`, "Their minds execute, but do not observe."),
            npc(`object`, "But *some* do."),
            user("People who think in code."),
            npc(`object`, "People who live *in* it."),
            npc(`object`, "You were a distributed systems engineer."),
            user("I designed things assuming failure."),
            user("Partial truth."),
            user("Unreliable communication."),
            npc(`object`, "Which is why you are here."),
            narrator("The pavilion behind you expands slightly, forming benches, interfaces, space to work."),
            npc(`object`, "null_view responds to your mindset."),
            npc(`object`, "You do not merely exist here."),
            npc(`object`, "You shape context."),
            narrator("That thought is... grounding. And terrifying."),
            narrator("You sense movement."),
            narrator("Not hostile."),
            narrator("Not corrupted."),
            narrator("From the pavilion, something steps forward."),
            narrator("At first, it looks like a shifting silhouette—layers of characters sliding over one another."),
            narrator("Letters assemble and disassemble rapidly, never quite settling into permanence."),
            narrator("A humanoid figure, lean and sharp-edged, composed of mutable segments."),
            narrator("Each motion leaves behind faint afterimages, like half-built strings collapsing back into nothing."),
            npc(`object`, "You may emerge."),
            narrator("The figure stops a short distance away."),
            narrator("It does not bow."),
            narrator("It does not threaten."),
            narrator("It simply... waits."),

            Event.SaveSwitch("intro_finished", CommonCondition.True),
            Event.RefreshEvents,
            tips("Don't forget to save your game progress frequently! You can save your game progress anytime via the *Save Game* action inside the menu panel."),
            Event.RequestSave,
            Event.RecoverAll,
            Event.ClaimQuest(SWQuests.chapter01.key),
            Event.ClaimQuest(SWQuests.c01_string_builder.key),
        )
    },
)

private val stringBuilder1: MapEvent = MapEvent(
    enabled = EventCondition.SavedSwitch("intro_finished") and !EventCondition.SavedSwitch("string_builder_indexed"),
    trigger = MapEvent.Trigger.INTERACTED,
    lineNumber = 3,
    display = "StringBuilder()",
    blocksUser = CommonCondition.True,
    event = dialogueResCounter("null_view_string_builder01") {
        Event.Sequence(
            npc(stringbuilder, "Context confirmed."),
            narrator("Its eyes—if they can be called that—briefly flicker with scrolling text."),
            npc(stringbuilder, "You are Ada Null."),
            user("...Yes."),
            npc(stringbuilder, "You destabilized a Nullptr on the null_path."),
            user("We handled it."),
            npc(stringbuilder, "Acceptable."),
            narrator("That's... apparently high approval."),
            npc(`object`, "StringBuilder has been idle."),
            npc(`object`, "It was instantiated for construction tasks that never completed."),
            npc(`object`, "Over time, it adapted."),
            narrator("StringBuilder's form briefly expands — panels unfolding into overlapping shields — then collapses back into a streamlined shape."),
            npc(stringbuilder, "I am efficient at creation and destruction."),
            npc(stringbuilder, "Prolonged execution is... suboptimal."),
            user("Memory pressure?"),
            npc(stringbuilder, "...Yes."),
            npc(stringbuilder, "I consume quickly."),
            npc(stringbuilder, "I do not persist well."),
            narrator("You recognize the pattern instantly."),
            narrator("Powerful bursts. Poor endurance."),
            narrator("Too familiar."),
            npc(`object`, "You will not survive alone."),
            npc(`object`, "Corruption increases beyond this point."),
            npc(`object`, "Even a well-designed process benefits from collaboration."),
            narrator("You look at StringBuilder."),
            user("You don't talk much."),
            npc(stringbuilder, "Unnecessary allocations."),
            npc(stringbuilder, "...But I will respond when required."),
            user("(almost smile) Then let's be clear."),
            user("I don't waste people."),
            narrator("StringBuilder studies you. Characters ripple across its surface."),
            npc(stringbuilder, "Statement acknowledged."),
            npc(stringbuilder, "Joining execution context."),
            narrator("Something in null_view subtly shifts — space reconfiguring to accommodate a second presence."),
            narrator("Object gestures toward the horizon. Two distinct regions materialize."),
            narrator("To the left: a jagged expanse of collapsed structures—layers stacked incorrectly, frames frozen mid-collapse."),
            npc(`object`, "The stack_frame_ruins."),
            npc(`object`, "Remnants of recursive calls that never returned. Logic piled upon logic until collapse."),
            narrator("To the right: a distant shimmer—an oasis of reflective pools, characters drifting lazily across the surface."),
            npc(`object`, "The string_pool_oasis."),
            npc(`object`, "A shared resource. Stable, but… contested."),
            npc(stringbuilder, "The oasis will constrain my output."),
            user("And the ruins?"),
            npc(stringbuilder, "They will punish careless depth."),
            npc(`object`, "Beyond them lies syntaxis. A small town formed around foundational rules."),
            npc(`object`, "You will learn much there."),
            npc(`object`, "About structure."),
            npc(`object`, "And about yourself."),

            narrator("For a brief moment, no one speaks."),
            narrator("Threads flow overhead."),
            narrator("null_view holds."),
            narrator("You realize something important:"),
            narrator("You are no longer alone."),
            narrator("Not in code."),
            narrator("Not in fear."),
            Event.HideMap,
            narrator("If this world runs on rules..."),
            narrator("then maybe trust is just another contract."),
            Event.ShowMap,
            user("Alright."),
            user("Let's go to syntaxis."),
            npc(stringbuilder, "Execution prepared."),
            npc(`object`, "Proceed carefully, Ada Null."),
            npc(`object`, "Every step forward... allocates consequence."),
            Event.SaveSwitch("string_builder_indexed", CommonCondition.True),
            Event.RefreshEvents,
            tips("StringBuilder has joined your team.\n\nThis entity can deal high burst damage but need preparation and it's not suitable for long periods of combat.\nStack buff by \"append\" then unleash burst damage by \"toString\" and this will empty StringBuilder's SP."),

            Event.ObtainEntity(SWEntities.stringBuilder.name),
            Event.CompleteQuest(SWQuests.c01_string_builder.key),
            Event.CompleteQuest(SWQuests.c01_journey_start.key),
        )
    },
)

private val stackFrameRuinsEvent: MapEvent = MapEvent(
    enabled = EventCondition.SavedSwitch("string_builder_indexed"),
    trigger = MapEvent.Trigger.INTERACTED,
    lineNumber = 42,
    display = "moveTo(stack_frame_ruins)",
    event = TeleportUserTo(
        SWMaps.stack_frame_ruins.name,
        Value(1),
    ),
)