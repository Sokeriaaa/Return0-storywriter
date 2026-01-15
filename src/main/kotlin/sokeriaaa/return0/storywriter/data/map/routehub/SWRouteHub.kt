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
package sokeriaaa.return0.storywriter.data.map.routehub

import sokeriaaa.return0.shared.data.api.component.condition.gt
import sokeriaaa.return0.shared.data.models.component.conditions.CommonCondition
import sokeriaaa.return0.shared.data.models.component.values.EventValue
import sokeriaaa.return0.shared.data.models.story.event.Event
import sokeriaaa.return0.shared.data.models.story.map.MapEvent
import sokeriaaa.return0.storywriter.data.inventory.SWInventories

object SWRouteHub {

    fun commonHub(lineNumber: Int) = MapEvent(
        enabled = CommonCondition.True,
        trigger = MapEvent.Trigger.INTERACTED,
        lineNumber = lineNumber,
        display = "RouteHub.INSTANCE",
        event = Event.RouteHub(
            isAccessible = EventValue.Inventory(SWInventories.routerAccessToken.key) gt 0
        )
    )

}