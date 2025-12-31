package sokeriaaa.return0.storywriter.res

import sokeriaaa.return0.storywriter.res.SWStrings.generatedValues

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
object SWStrings {

    val staticValues: Map<String, String> = mapOf()

    val generatedValues: MutableMap<String, String> = HashMap()

    /**
     * Create a new entry for [generatedValues], then return the [key].
     *
     * Mainly used in events. Resources in items, functions and quests are auto-generated.
     *
     * If a same key is registered twice, the second one will replace the first.
     */
    fun create(
        key: String,
        value: String,
    ): String {
        generatedValues[key] = value
        return key
    }

}