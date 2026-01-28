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

import sokeriaaa.return0.shared.common.helpers.TimeHelper
import sokeriaaa.return0.shared.data.api.component.value.Value
import sokeriaaa.return0.shared.data.api.component.value.unaryMinus
import sokeriaaa.return0.shared.data.api.story.event.interactive.buildShop
import sokeriaaa.return0.shared.data.models.component.conditions.CommonCondition
import sokeriaaa.return0.shared.data.models.component.values.CommonValue
import sokeriaaa.return0.shared.data.models.component.values.EventValue
import sokeriaaa.return0.shared.data.models.component.values.TimeValue
import sokeriaaa.return0.shared.data.models.entity.category.Category
import sokeriaaa.return0.shared.data.models.story.currency.CurrencyType
import sokeriaaa.return0.shared.data.models.story.event.Event
import sokeriaaa.return0.shared.data.models.story.event.Event.CurrencyChange
import sokeriaaa.return0.shared.data.models.story.map.MapData
import sokeriaaa.return0.shared.data.models.story.map.MapEvent
import sokeriaaa.return0.storywriter.data.entities.SWEntities
import sokeriaaa.return0.storywriter.data.entities.SWEntitiesCommon
import sokeriaaa.return0.storywriter.data.inventory.GeneralMaterial
import sokeriaaa.return0.storywriter.data.inventory.SWInventoriesCommonMaterials
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
            shop,
            obtainCurrency,
            emptyCurrency,
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

private val shop: MapEvent = MapEvent(
    enabled = CommonCondition.True,
    trigger = MapEvent.Trigger.INTERACTED,
    lineNumber = 10,
    display = "shop()",
    event = buildShop(key = "testing_shop") {
        GeneralMaterial.entries.forEach { type ->
            val item = SWInventoriesCommonMaterials.getGeneralMaterial(type = type, tier = 0)
            inventory(item.key) soldFor 100.token
        }
        GeneralMaterial.entries.forEach { type ->
            val item = SWInventoriesCommonMaterials.getGeneralMaterial(type = type, tier = 1)
            inventory(item.key) soldFor 200.token limitFor 10 refreshAfter TimeValue.After(TimeHelper.ONE_DAY)
        }
        GeneralMaterial.entries.forEach { type ->
            val item = SWInventoriesCommonMaterials.getGeneralMaterial(type = type, tier = 2)
            inventory(item.key) soldFor 500.token limitFor 5 refreshAfter TimeValue.After(TimeHelper.ONE_DAY)
        }
        GeneralMaterial.entries.forEach { type ->
            val item = SWInventoriesCommonMaterials.getGeneralMaterial(type = type, tier = 3)
            inventory(item.key) soldFor 1.crypto limitFor 1 refreshAfter TimeValue.After(TimeHelper.ONE_DAY)
        }
    }
)

private val obtainCurrency: MapEvent = MapEvent(
    enabled = CommonCondition.True,
    trigger = MapEvent.Trigger.INTERACTED,
    lineNumber = 15,
    display = "obtainCurrency()",
    event = Event.Sequence(
        CurrencyChange(CurrencyType.TOKEN, Value(999999)),
        CurrencyChange(CurrencyType.CRYPTO, Value(999999)),
    ),
)

private val emptyCurrency: MapEvent = MapEvent(
    enabled = CommonCondition.True,
    trigger = MapEvent.Trigger.INTERACTED,
    lineNumber = 16,
    display = "emptyCurrency()",
    event = Event.Sequence(
        CurrencyChange(CurrencyType.TOKEN, -EventValue.Currency(CurrencyType.TOKEN)),
        CurrencyChange(CurrencyType.CRYPTO, -EventValue.Currency(CurrencyType.CRYPTO)),
    ),
)