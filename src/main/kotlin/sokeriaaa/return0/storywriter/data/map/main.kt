/**
 * Copyright (C) 2025 Sokeriaaa
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of
 * the GNU Affero General Public License as published by the Free Software Foundation, version 3.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * See the GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License along with this program.
 * If not, see <https://www.gnu.org/licenses/>.
 */
package sokeriaaa.return0.storywriter.data.map

import sokeriaaa.return0.shared.data.api.component.condition.not
import sokeriaaa.return0.shared.data.api.component.value.Value
import sokeriaaa.return0.shared.data.models.component.conditions.CommonCondition
import sokeriaaa.return0.shared.data.models.component.conditions.EventCondition
import sokeriaaa.return0.shared.data.models.story.event.Event
import sokeriaaa.return0.shared.data.models.story.event.Event.TeleportUserTo
import sokeriaaa.return0.shared.data.models.story.map.MapData
import sokeriaaa.return0.shared.data.models.story.map.MapEvent
import sokeriaaa.return0.storywriter.res.SWDialogueNames.`object`
import sokeriaaa.return0.storywriter.utils.dialogueResCounter

@Suppress("UnusedReceiverParameter")
val SWMaps.main: MapData
    get() = MapData(
        name = "main",
        lines = 100,
        buggyRange = emptyList(),
        buggyEntries = emptyList(),
        events = listOf(
            mainEvent01,
            objectEvent,
            nullPathEvent,
        )
    )

private val mainEvent01: MapEvent = MapEvent(
    enabled = !EventCondition.SavedSwitch("intro_finished"),
    trigger = MapEvent.Trigger.ENTERED,
    event = dialogueResCounter("main_event01") {
        Event.Sequence(
            narrator("Suddenly, you are no longer falling."),
            narrator("You're standing on solid ground — or at least, what passes for solid ground in this programming world."),
            narrator("The world around you seems to shift in patterns, constantly evolving: abstract structures of variables, functions, and references stretch into infinity."),
            narrator("The sky above is a swirling vortex of code, the ground beneath your feet a patchwork of algorithmic fragments."),
            narrator("Floating in front of you is a Class — a humanoid figure, but its edges are made up of shifting lines of syntax and brackets."),
            narrator("It doesn't have a face, but you can sense its presence."),

            tips("Click a row to move to it.\nYou can interact with the events/NPCs within a ±1 range.\n\nNow, try to move to line 4 to interact with the Object.")
        )
    }
)

private val objectEvent: MapEvent = MapEvent(
    enabled = !EventCondition.SavedSwitch("intro_finished"),
    trigger = MapEvent.Trigger.INTERACTED,
    lineNumber = 5,
    display = "Object()",
    blocksUser = CommonCondition.True,
    event = dialogueResCounter("main_object") {
        Event.Sequence(
            npc(`object`, "I am Object. You are a Null. An undefined process."),
            npc(`object`, "But not for long. You've been chosen to rewrite your own runtime."),
            npc(`object`, "To debug the errors in this world."),
            Event.ChoiceOneByOne(
                text("What is this place?") to Event.Sequence(
                    npc(`object`, "This is the Code Grid — the foundation of all digital reality."),
                    npc(`object`, "It is where logic lives, where code is born. But something is broken. "),
                    npc(`object`, "Errors have spread throughout the layers, corrupting the system."),
                    npc(`object`, "You must restore what was lost."),
                ),
                text("How do I fix the errors?") to Event.Sequence(
                    npc(
                        `object`,
                        "To fix the system, you must travel through the Code Layers — Syntax, Logic, Memory, and Network."
                    ),
                    npc(`object`, "Each layer holds its own corruption, its own bugs."),
                    npc(`object`, "You must debug the broken classes and reclaim the lost references."),
                ),
                text("Why was I chosen?") to Event.Sequence(
                    npc(`object`, "You were chosen because of what you are. A Null, a void."),
                    npc(`object`, "You represent the broken state of the system, but also the potential to fix it."),
                    npc(`object`, "It is only through imperfection that we find the path to perfection."),
                ),
            ),
            narrator("With Object's guidance, you step forward into the unknown, knowing that this is no longer just a world of code."),
            narrator("This is your world now. A place where you must confront your deepest fears — the fear of being erased, of being null."),
            narrator("The world stabilizes around you in slow, deliberate steps."),
            narrator("What you stand on is not ground in the human sense, but allocated memory — wide planes of faintly glowing tiles, each engraved with symbols that shift when you look too closely."),
            narrator("Above you, the sky is a deep gradient of indigo and black, threaded with luminous strands — threads, you realize."),
            narrator("Some flow smoothly like rivers of light. Others flicker, pause, resume. A few abruptly terminate mid-air."),
            narrator("Object floats before you, its form now clearer: a towering, architectural figure, like a living blueprint. Brackets form its shoulders. Keywords drift around it like sigils."),
            npc(`object`, "This realm reflects all software systems beneath the surface of your world."),
            npc(`object`, "What you call physical law there is merely an implementation detail here."),
            npc(`object`, "Memory is land."),
            npc(`object`, "Flow is river."),
            npc(`object`, "Threads are paths walked by intention."),
            npc(`object`, "Classes are structures."),
            npc(`object`, "Objects... are those who inhabit them."),
            narrator("As if to demonstrate, a distant city of towering constructs becomes visible—rectangular silhouettes of Classes, each emitting a faint aura of responsibility."),
            narrator("Smaller figures move in and out of them, instantiating, dissolving, returning."),
            narrator("Then the light dims."),
            npc(`object`, "Corruption is spreading through the Grid."),
            npc(`object`, "Data rot."),
            npc(`object`, "Logical breaks."),
            npc(`object`, "Resource starvation."),
            npc(`object`, "When flow breaks, time stutters."),
            npc(`object`, "When logic fails... something else is born."),
            narrator("From the fractured ground, a shape twitches—half-formed, unstable, as if unsure whether it exists."),
            narrator("You feel something cold in your chest."),
            narrator("Null."),
            narrator("You look down at your hands."),
            narrator("They are yours—but not entirely. Faint outlines of syntax shimmer beneath your skin. Your heartbeat feels like a clock cycle."),
            Event.HideMap,
            narrator("I'm... instantiated."),
            narrator("But without a default value."),
            Event.ShowMap,
            narrator("A familiar fear tightens around your thoughts—the fear of being unreferenced. Forgotten. Garbage-collected."),
            narrator("Object turns toward you."),
            npc(`object`, "You are not bound here by accident, Ada Null."),
            npc(`object`, "Very few minds can cross the abstraction barrier."),
            npc(`object`, "Only those who intuitively understand that code is not merely written — but inhabited."),
            Event.HideMap,
            narrator("Images flash in your mind: Late nights. Distributed systems diagrams. Failure modes. Retry logic. Designing for chaos. For partial failure."),
            Event.ShowMap,
            npc(`object`, "You crossed over at the moment of collapse."),
            npc(`object`, "When your world returned zero, but your process did not terminate."),
            narrator("Object turns and points toward a narrow corridor cutting through the terrain."),
            narrator("It is darker than the rest of the Grid — a winding trail where the light thins, where threads converge and then vanish. The air hums with unresolved references."),
            npc(`object`, "This is the null_path."),
            user("The path seems... unfinished."),
            user("Sections of it flicker between existence and absence."),
            npc(`object`, "It is taken by those who are undefined."),
            npc(`object`, "It leads to a place that should not exist — yet does."),
            narrator("In the distance, barely visible, is a plateau overlooking the Grid. A quiet place. Stable. Anchored."),
            npc(`object`, "Your destination is null_view."),
            npc(`object`, "A vantage point. A base context."),
            npc(`object`, "From there, you will observe, refactor, and fight."),
            user("..."),
            user("And if I fail on this path?"),
            npc(`object`, "Then you will become what you fear."),
            npc(`object`, "Let's step onto this path now."),
            // Teleport
            TeleportUserTo(
                SWMaps.null_path.name,
                Value(1),
            )
        )
    }
)

private val nullPathEvent: MapEvent = MapEvent(
    enabled = CommonCondition.True,
    trigger = MapEvent.Trigger.INTERACTED,
    lineNumber = 6,
    display = "moveTo(null_path)",
    event = TeleportUserTo(
        SWMaps.null_path.name,
        Value(1),
    )
)
