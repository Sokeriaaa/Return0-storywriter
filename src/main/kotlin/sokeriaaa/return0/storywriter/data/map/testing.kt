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
package sokeriaaa.return0.storywriter.data.map

import sokeriaaa.return0.shared.data.models.story.map.MapData

/**
 * This is a map solely for testing proposes and would not accessible in the normal game.
 */
@Suppress("UnusedReceiverParameter")
val SWMaps.testing: MapData
    get() = MapData(
        name = "testing",
        lines = 420,
        buggyRange = listOf(),
        buggyEntries = listOf(),
        events = listOf(),
    )