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

import sokeriaaa.return0.shared.data.models.story.map.MapData

@Suppress("UnusedReceiverParameter")
val SWMaps.main: MapData
    get() = MapData(
        name = "main",
        lines = 100,
        buggyRange = emptyList(),
        buggyEntries = emptyList(),
        difficulty = 1,
        events = listOf(

        )
    )