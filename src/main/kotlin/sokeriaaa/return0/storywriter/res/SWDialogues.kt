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
package sokeriaaa.return0.storywriter.res

import sokeriaaa.return0.shared.data.models.story.event.Event

/**
 * Generate dialogues.
 */
object SWDialogues {

    /**
     * Create a [Event.Text.Narrator] with specified resource key and string value.
     *
     * The key value pair will be saved automatically in [SWStrings] for outputting.
     */
    fun createNarrator(res: String, dialogue: String) = Event.Text.Narrator(
        messageRes = createText(res, dialogue)
    )

    /**
     * Create a [Event.Text.User] with specified resource key and string value.
     *
     * The key value pair will be saved automatically in [SWStrings] for outputting.
     */
    fun createUser(res: String, dialogue: String) = Event.Text.User(
        messageRes = createText(res, dialogue)
    )

    /**
     * Create a [Event.Text.NPC] with specified resource key and string value.
     *
     * The key value pair of dialogue will be saved automatically in [SWStrings] for outputting.
     */
    fun createNPC(res: String, nameRes: String, dialogue: String) = Event.Text.NPC(
        nameRes = nameRes,
        messageRes = createText(res, dialogue)
    )

    /**
     * Create a [Event.Tips] with specified resource key and string value.
     *
     * The key value pair will be saved automatically in [SWStrings] for outputting.
     */
    fun createTips(res: String, dialogue: String) = Event.Tips(
        tipsRes = createText(res, dialogue)
    )

    /**
     * Create a normal string with specified resource key generated.
     */
    fun createText(
        res: String,
        value: String,
    ): String = SWStrings.create(
        res = "dialogue.text.$res",
        value = value,
    )
}