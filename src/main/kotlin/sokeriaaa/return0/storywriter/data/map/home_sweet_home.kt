package sokeriaaa.return0.storywriter.data.map

import sokeriaaa.return0.shared.data.api.component.value.Value
import sokeriaaa.return0.shared.data.models.component.conditions.CommonCondition
import sokeriaaa.return0.shared.data.models.story.event.Event
import sokeriaaa.return0.shared.data.models.story.event.Event.TeleportUserTo
import sokeriaaa.return0.shared.data.models.story.map.MapData
import sokeriaaa.return0.shared.data.models.story.map.MapEvent
import sokeriaaa.return0.storywriter.res.SWDialogueNames.unknown
import sokeriaaa.return0.storywriter.utils.dialogueResCounter


@Suppress("UnusedReceiverParameter")
val SWMaps.home_sweet_home: MapData
    get() = MapData(
        name = "home_sweet_home",
        lines = 0,
        buggyRange = emptyList(),
        buggyEntries = emptyList(),
        difficulty = 1,
        events = listOf(
            homeEvent,
        )
    )

private val homeEvent = MapEvent(
    enabled = CommonCondition.True,
    trigger = MapEvent.Trigger.ENTERED,
    event = dialogueResCounter("home") {
        Event.Sequence(
            Event.HideMap,
            narrator("The train chugged to a station near your apartment building on the outdated edge of the city."),
            narrator("The doors hissed open, and it released you as if spitting out a useless piece of code waiting to be recycled."),
            narrator("You reach your apartment complex, standing in front of the door that's never felt more isolating."),
            narrator("Your reflection in the glass door feels like an unfamiliar version of yourself, a null value in the context of the world."),
            narrator("The place where you live, eat, and sleep — yet it seems so foreign now."),
            narrator("You swipe your keycard, and the door clicks open with a soft hiss."),
            narrator("The apartment is empty, cold."),
            narrator("The hum of your computer is the only sound as you step inside, but even that feels distant."),
            narrator("You drop your jacket on the couch and sit down at your desk."),
            narrator("The screen in front of you flickers to life, offering the familiar IDE — one of the few things that hasn't changed, that hasn't been taken from you."),
            narrator("The last piece of code that was not committed before being forcibly logged out still remained on it."),
            narrator("Your fingers hover above the keys, trembling slightly. The \"exit\" code still lingers in your mind, replaying every moment of Lawrence's words."),
            narrator("But as you stare at the blinking cursor, something inside you snaps."),

            Event.TypeReturn0,
            narrator("For a moment, nothing happens, but the circular progress indicator rotates."),
            narrator("The room seems to grow stiller."),
            narrator("Then, a sudden shift."),
            Event.ShakeMap,
            narrator("The terminal begins to pulse, expanding into a cascade of symbols and code — an endless matrix unfolding before your eyes."),
            narrator("Your apartment walls seem to melt away, the very reality around you warping into fragments of syntax."),
            narrator("The code grows larger, surrounding you in a digital cocoon."),
            narrator("You feel yourself falling, but there’s no sensation of gravity."),
            narrator("No body, no space. Only the flow of pure data around you — an overwhelming rush of endless lines of code, each command a path leading to something."),
            narrator("The very fabric of your world has dissolved into a quantum stream of logic and mathematical equations."),
            npc(unknown, "Welcome to the Grid, Ada Null."),
            npc(unknown, "Your execution has begun."),

            // Next scene
            TeleportUserTo(SWMaps.main.name, Value(1))
        )
    },
)