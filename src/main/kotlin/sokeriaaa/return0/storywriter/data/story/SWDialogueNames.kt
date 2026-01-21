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
package sokeriaaa.return0.storywriter.data.story

import sokeriaaa.return0.storywriter.res.SWStrings

/**
 * Generate names for dialogues.
 */
object SWDialogueNames {
    // Common
    val unknown: String by lazy { create("???", "unknown") }

    // Matrix Corp.
    val natalie: String by lazy { create("Natalie") }
    val mark: String by lazy { create("Mark") }
    val lawrence: String by lazy { create("Lawrence") }

    // Parties
    val `object`: String by lazy { create("Object") }
    val stringbuilder: String by lazy { create("StringBuilder") }
    val validator: String by lazy { create("Validator") }

    // NPC
    val pluginSmith: String by lazy { create("PluginSmith") }

    private fun create(
        name: String,
        res: String = name.lowercase().replace(' ', '_').replace('-', '_'),
    ) = SWStrings.create(
        res = "dialogue.name.$res",
        value = name
    )
}