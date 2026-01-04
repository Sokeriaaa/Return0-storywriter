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

import sokeriaaa.return0.shared.data.api.component.value.Value
import sokeriaaa.return0.shared.data.models.component.conditions.CommonCondition
import sokeriaaa.return0.shared.data.models.story.event.Event
import sokeriaaa.return0.shared.data.models.story.event.Event.TeleportUserTo
import sokeriaaa.return0.shared.data.models.story.map.MapData
import sokeriaaa.return0.shared.data.models.story.map.MapEvent
import sokeriaaa.return0.storywriter.data.story.SWDialogueNames.unknown
import sokeriaaa.return0.storywriter.utils.dialogueResCounter

@Suppress("UnusedReceiverParameter")
val SWMaps.silica_city: MapData
    get() = MapData(
        name = "silica_city",
        lines = 0,
        buggyRange = emptyList(),
        buggyEntries = emptyList(),
        events = listOf(
            silicaCityEvent,
        )
    )


private val silicaCityEvent = MapEvent(
    enabled = CommonCondition.True,
    trigger = MapEvent.Trigger.ENTERED,
    event = dialogueResCounter("silica_city") {
        Event.Sequence(
            Event.HideMap,
            narrator("Location: 42nd Avenue, Silica City"),
            narrator("Time: 8:15 PM — Evening"),
            narrator("Silica City, once a place of possibilities, now feels like a massive, indifferent data center — endless lines of code wrapped around steel and concrete."),
            narrator("You walk briskly, your footsteps mixing with the hum of distant machines."),
            narrator("Your mind is quiet but turbulent, a perfect storm of calm calculation and uncertainty."),
            narrator("A woman passes you by, her umbrella casting an abstract, sharp silhouette in the neon light."),
            narrator("She looks familiar — someone from the office?"),
            narrator("You can't tell. You don't recognize her anymore. You don't recognize anything anymore."),

            narrator("A figure stops in front of you, blocking your path to the railway station. You barely notice him until he speaks."),
            npc(unknown, "You look... lost. Or maybe found?"),
            npc(unknown, "Hard to tell with the rain."),
            user("Sorry, I—"),
            npc(unknown, "No need to apologize."),
            npc(
                unknown,
                "It's just, you seem like you're walking away from something important... or maybe something that's already been erased."
            ),
            narrator("He looks at you with a strange mixture of understanding and amusement."),
            user("(frowning) Who are you?"),
            npc(unknown, "(laughs lightly) I'm just another process running in the background."),
            npc(unknown, "You'll forget me soon enough. Everyone does."),
            npc(
                unknown,
                "But, here's a thought: when you get to the end of this loop, don't be afraid to change the parameters."
            ),
            npc(unknown, "You might just find the real \"exit\"."),
            narrator("The stranger turns, disappearing into the rainy night."),
            narrator("His words feel like a coded message, a hint at something deeper — something you don't understand yet, but somehow should."),

            narrator("The way back to your apartment is a blur."),
            narrator("The evening light in the city reflects off the rain, turning the streets into an iridescent maze of colors — blue for data streams, green for function calls, and red for errors."),

            // Next scene
            TeleportUserTo(SWMaps.home_sweet_home.name, Value(1))
        )
    }
)