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
import sokeriaaa.return0.storywriter.res.SWDialogueNames.lawrence
import sokeriaaa.return0.storywriter.res.SWDialogueNames.mark
import sokeriaaa.return0.storywriter.res.SWDialogueNames.natalie
import sokeriaaa.return0.storywriter.utils.dialogueResCounter

@Suppress("UnusedReceiverParameter")
val SWMaps.matrix_corp: MapData
    get() = MapData(
        name = "matrix_corp",
        lines = 11,
        buggyRange = emptyList(),
        buggyEntries = emptyList(),
        events = listOf(
            matrixCorpEvent,
            simpleEvent(1, "// Welcome to return 0;"),
            simpleEvent(2, "// A programming-styled RPG game."),
            simpleEvent(3, "//"),
            simpleEvent(4, "// This game is entirely fictional and"),
            simpleEvent(5, "// has no connection to any real-world"),
            simpleEvent(6, "// people, places, companies, or"),
            simpleEvent(7, "// organizations. Any resemblance to"),
            simpleEvent(8, "// actual persons, living or dead, or"),
            simpleEvent(9, "// actual events is purely coincidental."),
            simpleEvent(10, "//"),
            simpleEvent(11, "// Enjoy your game :D"),
        )
    )

private fun simpleEvent(row: Int, text: String) = MapEvent(
    enabled = CommonCondition.True,
    trigger = MapEvent.Trigger.INTERACTED,
    lineNumber = row,
    display = text,
    event = Event.Empty,
)

private val matrixCorpEvent = MapEvent(
    enabled = CommonCondition.True,
    trigger = MapEvent.Trigger.ENTERED,
    event = dialogueResCounter("matrix_corp") {
        Event.Sequence(
            narrator("Location: Matrix Headquarters, Silica City"),
            narrator("Time: 7:45 PM — one week before the \"Null Sequence.\""),
            narrator("The sharp, sterile atmosphere of the office is suffocating."),
            narrator("The usual hum of servers and flicker of monitors seem quieter today — a subtle, uncomfortable stillness fills the air."),
            narrator("You've spent years here, working with some of the brightest minds in tech."),
            narrator("And today... it feels like everything is about to break."),
            narrator("You walk through the halls — not yet knowing your fate — but the weight of the gossip, the sideways glances, and the too-sweet smiles tells you everything."),
            narrator("The company is cutting back."),
            narrator("And you might be next."),

            narrator("Natalie stands by the coffee machine, her face pale, eyes darting nervously from the clock to her phone."),
            narrator("She doesn't meet your gaze as you walk in."),
            user("Hey, Natalie. You alright?"),
            npc(natalie, "(forced smile) Yeah... just..."),
            npc(natalie, "just a little under the weather today, you know."),
            npc(natalie, "The grind, and all that."),
            user("Right. Just keep your head down, it'll pass. It always does."),
            npc(natalie, "I heard they're cutting some... positions today."),
            npc(natalie, "HR's been meeting with people all morning."),
            npc(natalie, "Not sure if you're in the clear... or... well, you know."),
            user("That's... unfortunate."),
            narrator("Natalie looks down at her coffee, steeling herself."),
            user("I guess you should prepare for the worst. Always best to be pragmatic."),
            npc(natalie, "(nervously laughs) Yeah, yeah... I mean, you won't get cut, right?"),
            npc(natalie, "You're... a senior engineer. I heard the higher-ups depend on you."),
            user("(inwardly sighs, then offers a faint smile) We all depend on something, don't we? You'll be fine. Just stay focused."),

            narrator("Mark, the lead engineer, walks into the break room as you sip your coffee."),
            narrator("He stands tall, his arms crossed, the very image of confidence."),
            narrator("But his face is tight, anxious — you know something's coming."),
            narrator("He looks at you, then quickly glances away. The silence between you two feels heavier than usual."),
            user("Mark. You're looking... stressed."),
            npc(mark, "(chuckles weakly) Can't hide anything from you, huh?"),
            npc(mark, "Yeah, I'm... a bit on edge. Management's been tight-lipped about things."),
            user("It's just economic pressure. Everyone's trimming the fat."),
            user("We've seen this coming for a while."),
            npc(mark, "You're right... But that doesn't make it easier."),
            npc(mark, "The office politics are... well, let's just say they've been shifting for a while."),
            npc(mark, "Some people are making moves."),
            user("(eyes narrowing) I'm sure they are."),
            user("(voice turning quieter) You didn't get caught up in any of that, did you?"),
            npc(mark, "*sigh* It's hard not to. But no, I stayed out of the drama."),
            npc(mark, "Still, no one's safe. There's a lot of talk about restructuring... and people being... let go."),
            user("Restructuring?"),
            user("Who exactly is making the decisions?"),
            narrator("Mark glances at the door, and lowers his voice"),
            npc(mark, "It's coming from the top. Lawrence."),
            npc(mark, "He's... been pushing for more \"efficiency\" lately."),
            npc(
                mark,
                "I'm not sure who exactly is being targeted, but if you don't fall under the ‘essential' category..."
            ),
            npc(mark, "Well, you know the rest."),
            user("(clenching jaw, with mind racing) Yeah. I know."),

            narrator("You stand outside Lawrence's office, looking at the glass door with his name printed in bold, sleek letters."),
            narrator("You've been here before — countless times. Yet today, the door feels like a barrier between you and your future."),
            narrator("You take a deep breath and step inside."),
            npc(lawrence, "(smiling, almost too broadly) Ah, Ada. Good to see you. Please, have a seat."),
            npc(lawrence, "(gestures to the chair) I'm glad we could chat."),
            user("(sitting down, heart pounding) Of course. You wanted to see me?"),
            npc(lawrence, "(pauses, a shadow of discomfort in eyes) Yes, I... I won't beat around the bush, Ada."),
            npc(
                lawrence,
                "I know you've been with us for a long time, and your contributions have been... invaluable."
            ),
            npc(
                lawrence,
                "(looks down, then back up at you) “But with the current economic downturn... and the need for us to streamline operations, we're forced to make some difficult decisions."
            ),
            user("(calmly) Difficult decisions... like what?"),
            npc(lawrence, "We've had to assess team structures, project scopes, and efficiency."),
            npc(lawrence, "Unfortunately... the reality is that your position..."),
            npc(lawrence, "as it currently stands..."),
            npc(lawrence, "is no longer viable."),
            user("(voice steady but controlled) You're letting me go."),
            npc(lawrence, "Ada, I don't want to phrase it like that, but yes... we're going to have to part ways."),
            npc(lawrence, "It's not about your performance, but rather... the need for restructuring."),
            user("(smiling thinly) Efficiency. Streamlining. The familiar terms."),
            npc(lawrence, "(looking guilty) I really do wish it were different, Ada."),
            npc(lawrence, "I value what you've done here."),
            npc(lawrence, "But these decisions come from higher up. Corporate directives."),
            narrator("You lean forward slightly, your calm demeanor hiding the storm beneath."),
            user("And your directive is to discard those who don't fit the current \"model.\" The perfect exit, isn't it?"),
            npc(lawrence, "(avoids eye contact) Ada, I—"),
            user("It's fine, Lawrence. I understand."),
            user("I'm just another variable in your optimization cycle."),
            user("(leans back, voice almost a whisper) But I'll find my own way to recompile."),

            narrator("As the conversation ends, you leave Lawrence's office, the reality of the layoff sinking in."),
            narrator("It was as abrupt as a fatal runtime exception, with no chance of being caught."),
            narrator("But this isn't the end. Not for you."),

            narrator("As you walk down the sleek, white corridors of Matrix, you feel the weight of every line of code you've ever written, every system you've helped design, every distributed process you've fine-tuned... slipping away."),
            narrator("There's a feeling that maybe you've been optimized out of the equation — but that doesn't mean you're done."),
            narrator("Your greatest fear, null, looms large."),
            narrator("The idea of being discarded, of being forgotten — erased from existence like a piece of code with no reference. It gnaws at you, deep in your chest."),
            narrator("But then, another thought surfaces:"),
            narrator("Maybe this is the ultimate test. If I can't rely on the systems, I'll have to build my own."),
            narrator("And with that, a strange sense of clarity washes over you. This isn't the end. This is just the beginning."),

            narrator("The elevator hums as it descends from the 108th floor. It's excruciatingly silent."),
            narrator("Through the glass walls of the shaft, the skyline of Silica City flickers like a motherboard — towers lit by blue neon veins, data barges drifting through the fog."),
            narrator("You stand there with your badge still hanging from your neck:"),
            narrator("MATRIX // Ada Null // Software Engineer II"),
            narrator("The screen embedded in the badge flashes red."),
            narrator("SYSTEM NOTICE:\n\"Employment thread terminated. Return code: 0.\""),
            narrator("return 0;"),
            narrator("A clean exit."),
            narrator("No errors, no warnings — just silence."),
            narrator("The weight of Lawrence's words still presses down on your chest."),
            narrator("It's an odd feeling, like you've been hollowed out."),
            narrator("You're not sure if the elevator is rising or falling, the verticality of Matrix's towering building distorting your sense of space."),
            narrator("You can almost hear the hum of the server farms, the algorithmic heartbeat of Matrix, fading as the elevator moves lower, deeper."),
            narrator("The doors open to the lobby — empty now, aside from a few scattered figures typing away on their smartphones, heads bent, lost in the glow of their screens."),
            narrator("The sleek reception desk is unmanned."),
            narrator("Their slogan used to be displayed on the reception desk and echoed on every floor:"),
            narrator("\"Matrix — Connecting the Grids of the Digital Mind.\""),
            narrator("But this month, they changed it."),
            narrator("\"Matrix — Return 0. The Perfect Exit.\""),
            narrator("A joke for programmers, a curse for employees."),
            narrator("You step out, the cold of the night air hitting you as you pass through the glass doors and onto the street."),

            // Next scene
            TeleportUserTo(SWMaps.silica_city.name, Value(1))
        )
    }
)