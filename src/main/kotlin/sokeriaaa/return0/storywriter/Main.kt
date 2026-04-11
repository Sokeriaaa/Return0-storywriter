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

import sokeriaaa.common.kmp.helpers.JsonHelper.toJsonString
import sokeriaaa.return0.shared.data.models.Manifest
import sokeriaaa.return0.storywriter.data.SWCategories
import sokeriaaa.return0.storywriter.data.SWEffects
import sokeriaaa.return0.storywriter.data.entities.SWEntities
import sokeriaaa.return0.storywriter.data.inventory.SWInventories
import sokeriaaa.return0.storywriter.data.map.SWMaps
import sokeriaaa.return0.storywriter.data.plugins.SWPlugins
import sokeriaaa.return0.storywriter.data.quest.SWQuests
import sokeriaaa.return0.storywriter.data.skill.SWSkills
import sokeriaaa.return0.storywriter.res.SWStrings
import java.io.File

fun main() {
    // Delete old output folder.
    File("./output").deleteRecursively()
    // Create folders.
    File("./output").mkdir()
    File("./output/data").mkdir()
    File("./output/data/entity").mkdir()
    File("./output/data/entity/category").mkdir()
    File("./output/data/entity/effect").mkdir()
    File("./output/data/entity/skill").mkdir()
    File("./output/data/inventory").mkdir()
    File("./output/data/map").mkdir()
    File("./output/data/plugin").mkdir()
    File("./output/data/quest").mkdir()
    File("./output/res").mkdir()

    // Output - Category: Entity growth
    File("./output/data/entity/category/entity_growth.json").writeText(SWCategories.entityGrowthValues.toJsonString())
    // Output - Category: Effectiveness
    File("./output/data/entity/category/effectiveness.json").writeText(SWCategories.categoryEffectivenessTable.toJsonString())
    // Output - Entity
    SWEntities.values.forEach {
        // JSON Data
        File("./output/data/entity/${it.name}.json").writeText(it.toJsonString())
    }
    // Output - Entity - Effects
    SWEffects.values.forEach {
        // String resource
        SWStrings.generatedValues["effect.${it.effectData.name}.desc"] = it.simpleDescription
        // JSON Data
        File("./output/data/entity/effect/${it.effectData.name}.json").writeText(it.effectData.toJsonString())
    }
    // Output - Entity - Skills
    SWSkills.values.forEach {
        // String resource
        SWStrings.generatedValues["skill.${it.functionData.name}.desc"] = it.simpleDescription
        // JSON Data
        File("./output/data/entity/skill/${it.functionData.name}.json").writeText(it.functionData.toJsonString())
    }
    // Output - Maps
    SWMaps.maps.forEach {
        File("./output/data/map/${it.name}.json").writeText(it.toJsonString())
    }
    // Output - Inventories
    SWInventories.inventories.forEach {
        File("./output/data/inventory/${it.key}.json").writeText(it.toJsonString())
    }
    // Output - Plugins
    SWPlugins.plugins.forEach {
        File("./output/data/plugin/${it.key}.json").writeText(it.toJsonString())
    }
    // Output - Quests
    SWQuests.quests.forEach {
        File("./output/data/quest/${it.key}.json").writeText(it.toJsonString())
    }
    // Output - strings
    File("./output/res/strings.json").writeText(
        (SWStrings.staticValues + SWStrings.generatedValues)
            .toSortedMap()
            .toMap()
            .toJsonString(),
    )

    // Create manifest
    File("./output/data/manifest.json").writeText(
        Manifest(
            entities = Manifest.Entities(
                list = SWEntities.values.map { it.name }.sorted(),
                effects = Manifest.Entities.Effects(
                    list = SWEffects.values.map { it.name }.sorted(),
                ),
                skills = Manifest.Entities.Skills(
                    list = SWSkills.values.map { it.functionData.name }.sorted(),
                ),
            ),
        ).toJsonString()
    )
}