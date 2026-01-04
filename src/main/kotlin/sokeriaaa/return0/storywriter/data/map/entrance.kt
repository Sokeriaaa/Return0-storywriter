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
import sokeriaaa.return0.shared.data.models.story.map.MapData
import sokeriaaa.return0.shared.data.models.story.map.MapEvent

@Suppress("UnusedReceiverParameter")
val SWMaps.entrance: MapData
    get() = MapData(
        name = "entrance",
        lines = 0,
        buggyRange = emptyList(),
        buggyEntries = emptyList(),
        events = listOf(entranceEvent)
    )

private val entranceEvent = MapEvent(
    enabled = CommonCondition.True,
    trigger = MapEvent.Trigger.ENTERED,
    event = Event.Sequence(
        Event.TeleportUserTo(SWMaps.matrix_corp.name, Value(1))
    )
)