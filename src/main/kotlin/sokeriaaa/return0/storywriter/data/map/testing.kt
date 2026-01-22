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

import sokeriaaa.return0.shared.data.models.component.conditions.CommonCondition
import sokeriaaa.return0.shared.data.models.component.values.CommonValue
import sokeriaaa.return0.shared.data.models.entity.category.Category
import sokeriaaa.return0.shared.data.models.story.event.Event
import sokeriaaa.return0.shared.data.models.story.map.MapData
import sokeriaaa.return0.shared.data.models.story.map.MapEvent
import sokeriaaa.return0.storywriter.data.entities.SWEntities
import sokeriaaa.return0.storywriter.data.entities.SWEntitiesCommon
import sokeriaaa.return0.storywriter.data.plugins.SWPlugins

/**
 * This is a map solely for testing proposes and would not accessible in the normal game.
 */
@Suppress("UnusedReceiverParameter")
val SWMaps.testing: MapData
    get() = MapData(
        name = "testing",
        lines = 100,
        buggyRange = listOf(
            50 to 100,
        ),
        buggyEntries = listOf(
            MapData.BuggyEntry(
                listOf(
                    SWEntitiesCommon.getCommonEnemy(Category.VOID, 0).name,
                    SWEntitiesCommon.getCommonEnemy(Category.VOID, 0).name
                ),
                difficulty = 1,
            ),
            MapData.BuggyEntry(
                listOf(
                    SWEntitiesCommon.getCommonEnemy(Category.MEMORY, 0).name,
                    SWEntitiesCommon.getCommonEnemy(Category.MEMORY, 0).name
                ),
                difficulty = 1,
            ),
            MapData.BuggyEntry(
                listOf(
                    SWEntitiesCommon.getCommonEnemy(Category.VOID, 0).name,
                    SWEntitiesCommon.getCommonEnemy(Category.MEMORY, 0).name
                ),
                difficulty = 1,
            ),
        ),
        events = listOf(
            recoverAll,
            obtainAllEntities,
            obtainPluginSet,
        ),
    )

private val recoverAll: MapEvent = MapEvent(
    enabled = CommonCondition.True,
    trigger = MapEvent.Trigger.INTERACTED,
    lineNumber = 1,
    display = "recoverAll()",
    event = Event.RecoverAll,
)

private val obtainAllEntities: MapEvent = MapEvent(
    enabled = CommonCondition.True,
    trigger = MapEvent.Trigger.INTERACTED,
    lineNumber = 2,
    display = "obtainAllEntities()",
    event = Event.Sequence(
        Event.ObtainEntity(SWEntities.`object`.name),
        Event.ObtainEntity(SWEntities.iterator.name),
        Event.ObtainEntity(SWEntities.system.name),
        Event.ObtainEntity(SWEntities.stringBuilder.name),
        Event.ObtainEntity(SWEntities.validator.name),
    ),
)

private val obtainPluginSet: MapEvent = MapEvent(
    enabled = CommonCondition.True,
    trigger = MapEvent.Trigger.INTERACTED,
    lineNumber = 3,
    display = "obtainPluginSet()",
    event = Event.Sequence(
        Event.ObtainPlugin(SWPlugins.clockSkipper.key, CommonValue.Math.RandomInt(1, 5)),
        Event.ObtainPlugin(SWPlugins.growthFactorArray.key, CommonValue.Math.RandomInt(1, 5)),
        Event.ObtainPlugin(SWPlugins.raceCondition.key, CommonValue.Math.RandomInt(1, 5)),
    ),
)