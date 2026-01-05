/**
 * Copyright (C) 2026 Sokeriaaa
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
package sokeriaaa.return0.storywriter.data.map.quiz

import sokeriaaa.return0.shared.data.api.component.condition.not
import sokeriaaa.return0.shared.data.models.component.conditions.CommonCondition
import sokeriaaa.return0.shared.data.models.component.conditions.EventCondition
import sokeriaaa.return0.shared.data.models.story.event.Event
import sokeriaaa.return0.shared.data.models.story.map.MapEvent
import sokeriaaa.return0.storywriter.res.SWStrings
import sokeriaaa.return0.storywriter.utils.dialogueResCounter

object SWQuizzes {

    fun createQuiz(
        id: Int,
        lineNumber: Int,
        q: String,
        a: List<String>,
        correctIndex: Int,
        onCorrect: Event,
        onWrong: Event,
    ): MapEvent = MapEvent(
        enabled = !EventCondition.SavedSwitch("quiz$id"),
        trigger = MapEvent.Trigger.INTERACTED,
        lineNumber = lineNumber,
        display = "quiz$id()",
        blocksUser = CommonCondition.True,
        event = dialogueResCounter("quiz$id") {
            Event.Sequence(
                narrator(q),
                Event.Choice(
                    items = a.mapIndexed { index, string ->
                        text(string) to if (index == correctIndex) onCorrect else onWrong
                    }
                ),
                Event.SaveSwitch("quiz$id", CommonCondition.True),
                Event.RefreshEvents,
                Event.Text.Narrator(
                    SWStrings.create(
                        "dialogue.text.quiz_solved",
                        "The quiz has been successfully solved.",
                    )
                )
            )
        }
    )

}