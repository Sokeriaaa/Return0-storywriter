package sokeriaaa.return0.storywriter.data.map

import sokeriaaa.return0.shared.data.api.component.condition.not
import sokeriaaa.return0.shared.data.models.component.conditions.CommonCondition
import sokeriaaa.return0.shared.data.models.component.conditions.EventCondition
import sokeriaaa.return0.shared.data.models.story.event.Event
import sokeriaaa.return0.shared.data.models.story.map.MapData
import sokeriaaa.return0.shared.data.models.story.map.MapEvent
import sokeriaaa.return0.storywriter.res.SWDialogueNames.`object`
import sokeriaaa.return0.storywriter.utils.dialogueResCounter


@Suppress("UnusedReceiverParameter")
val SWMaps.null_view: MapData
    get() = MapData(
        name = "null_view",
        lines = 42,
        buggyRange = emptyList(),
        buggyEntries = emptyList(),
        difficulty = 1,
        events = listOf(
            nullViewEvent01,
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

            tips("Don't forget to save your game progress frequently! You can save your game progress anytime via the *Save Game* action inside the menu panel."),
            Event.RequestSave,
            Event.SaveSwitch("intro_finished", CommonCondition.True),
        )
    },
)