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
package sokeriaaa.return0.storywriter

import sokeriaaa.return0.shared.common.helpers.JsonHelper.toJsonString
import sokeriaaa.return0.storywriter.data.*
import sokeriaaa.return0.storywriter.data.map.SWMaps
import java.io.File

fun main() {
    // Delete old output folder.
    File("./output").deleteRecursively()
    // Create folders.
    File("./output").mkdir()
    File("./output/data").mkdir()
    File("./output/data/inventory").mkdir()
    File("./output/data/map").mkdir()
    File("./output/data/quest").mkdir()
    File("./output/res").mkdir()

    // Output - Category: Entity growth
    File("./output/data/category_entity_growth.json").writeText(SWCategories.entityGrowthValues.toJsonString())
    // Output - Category: Effectiveness
    File("./output/data/category_effectiveness.json").writeText(SWCategories.categoryEffectivenessTable.toJsonString())
    // Output - Entity
    File("./output/data/entity.json").writeText(SWEntities.values.toJsonString())
    // Output - Effect
    File("./output/data/effect.json").writeText(SWEffects.values.map { it.effectData }.toJsonString())

    // Output - Maps
    SWMaps.maps.forEach {
        File("./output/data/map/${it.name}.json").writeText(it.toJsonString())
    }

    // Prepare all descriptions
    SWEffects.values.forEach {
        SWStrings.generatedValues["desc.effect.${it.effectData.name}"] = it.simpleDescription
    }
    SWSkills.values.forEach {
        SWStrings.generatedValues["desc.skill.${it.functionData.name}"] = it.simpleDescription
    }
    // Output - strings
    File("./output/res/strings.json").writeText(
        (SWStrings.staticValues + SWStrings.generatedValues)
            .toSortedMap()
            .toMap()
            .toJsonString(),
    )
}