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
package sokeriaaa.return0.storywriter.data

import sokeriaaa.return0.shared.data.models.entity.EntityGrowth
import sokeriaaa.return0.shared.data.models.entity.category.Category
import sokeriaaa.return0.shared.data.models.entity.category.CategoryEffectiveness

object SWCategories {

    private fun getEntityGrowth(category: Category): EntityGrowth? {
        return when (category) {
            Category.ITEM -> null
            Category.NORMAL -> null

            Category.CLASS -> EntityGrowth(
                atkGrowth = 0.25F,
                defGrowth = 0.25F,
                spdGrowth = 0.25F,
                hpGrowth = 0.25F,
                spGrowth = 0.25F,
            )

            Category.INTERFACE -> EntityGrowth(
                atkGrowth = 0.26F,
                defGrowth = 0.24F,
                spdGrowth = 0.26F,
                hpGrowth = 0.24F,
                spGrowth = 0.25F,
            )

            Category.REFLECT -> EntityGrowth(
                atkGrowth = 0.27F,
                defGrowth = 0.26F,
                spdGrowth = 0.21F,
                hpGrowth = 0.27F,
                spGrowth = 0.24F,
            )

            Category.CONCURRENT -> EntityGrowth(
                atkGrowth = 0.26F,
                defGrowth = 0.24F,
                spdGrowth = 0.28F,
                hpGrowth = 0.22F,
                spGrowth = 0.25F,
            )

            Category.STREAM -> EntityGrowth(
                atkGrowth = 0.27F,
                defGrowth = 0.23F,
                spdGrowth = 0.27F,
                hpGrowth = 0.24F,
                spGrowth = 0.24F,
            )

            Category.IO -> EntityGrowth(
                atkGrowth = 0.24F,
                defGrowth = 0.25F,
                spdGrowth = 0.24F,
                hpGrowth = 0.26F,
                spGrowth = 0.26F,
            )

            Category.EXCEPTION -> EntityGrowth(
                atkGrowth = 0.28F,
                defGrowth = 0.21F,
                spdGrowth = 0.28F,
                hpGrowth = 0.20F,
                spGrowth = 0.28F,
            )

            Category.SECURITY -> EntityGrowth(
                atkGrowth = 0.22F,
                defGrowth = 0.27F,
                spdGrowth = 0.26F,
                hpGrowth = 0.26F,
                spGrowth = 0.24F,
            )

            Category.DEBUG -> EntityGrowth(
                atkGrowth = 0.22F,
                defGrowth = 0.22F,
                spdGrowth = 0.26F,
                hpGrowth = 0.23F,
                spGrowth = 0.32F,
            )

            Category.GENERIC -> EntityGrowth(
                atkGrowth = 0.25F,
                defGrowth = 0.25F,
                spdGrowth = 0.24F,
                hpGrowth = 0.25F,
                spGrowth = 0.26F,
            )

            Category.MEMORY -> EntityGrowth(
                atkGrowth = 0.21F,
                defGrowth = 0.29F,
                spdGrowth = 0.20F,
                hpGrowth = 0.32F,
                spGrowth = 0.23F,
            )

            Category.VOID -> EntityGrowth(
                atkGrowth = 0.23F,
                defGrowth = 0.29F,
                spdGrowth = 0.22F,
                hpGrowth = 0.24F,
                spGrowth = 0.27F,
            )
        }
    }

    private fun getCategoryEffectivenessTo(category: Category, category2: Category): Int {
        return when (category) {
            Category.ITEM -> 0
            Category.NORMAL -> 0
            Category.CLASS -> when (category2) {
                Category.INTERFACE -> 2

                Category.EXCEPTION,
                Category.VOID -> 1

                Category.CLASS,
                Category.DEBUG -> -1

                Category.REFLECT -> -2
                else -> 0
            }

            Category.INTERFACE -> when (category2) {
                Category.REFLECT -> 2

                Category.STREAM,
                Category.MEMORY -> 1

                Category.IO -> -1

                Category.CLASS -> -2
                else -> 0
            }

            Category.REFLECT -> when (category2) {
                Category.CLASS -> 2

                Category.REFLECT,
                Category.SECURITY,
                Category.MEMORY -> 1

                Category.CONCURRENT,
                Category.DEBUG,
                Category.GENERIC -> -1

                Category.INTERFACE -> -2
                else -> 0
            }

            Category.CONCURRENT -> when (category2) {
                Category.STREAM -> 2

                Category.SECURITY -> 1

                Category.CLASS,
                Category.MEMORY -> -1

                Category.IO -> -2
                else -> 0
            }

            Category.STREAM -> when (category2) {
                Category.IO -> 2

                Category.STREAM,
                Category.GENERIC -> 1

                Category.EXCEPTION,
                Category.VOID -> -1

                Category.CONCURRENT -> -2
                else -> 0
            }

            Category.IO -> when (category2) {
                Category.CONCURRENT -> 2

                Category.CLASS,
                Category.MEMORY -> 1

                Category.REFLECT -> -1

                Category.STREAM -> -2
                else -> 0
            }

            Category.EXCEPTION -> when (category2) {
                Category.SECURITY -> 2

                Category.IO -> 1

                Category.CONCURRENT,
                Category.EXCEPTION -> -1

                Category.DEBUG -> -2
                else -> 0
            }

            Category.SECURITY -> when (category2) {
                Category.DEBUG -> 2

                Category.IO -> 1

                Category.INTERFACE -> -1

                Category.EXCEPTION -> -2
                else -> 0
            }

            Category.DEBUG -> when (category2) {
                Category.EXCEPTION -> 2

                Category.MEMORY,
                Category.CONCURRENT -> 1

                Category.VOID -> -1

                Category.SECURITY -> -2
                else -> 0
            }

            Category.GENERIC -> when (category2) {
                Category.MEMORY -> 2

                Category.INTERFACE -> 1

                Category.STREAM -> -1

                Category.VOID -> -2
                else -> 0
            }

            Category.MEMORY -> when (category2) {
                Category.VOID -> 2

                Category.INTERFACE,
                Category.CLASS -> 1

                Category.STREAM,
                Category.SECURITY -> -1

                Category.GENERIC -> -2
                else -> 0
            }

            Category.VOID -> when (category2) {
                Category.GENERIC -> 2

                Category.REFLECT,
                Category.VOID,
                Category.EXCEPTION -> 1

                Category.INTERFACE -> -1

                Category.MEMORY -> -2
                else -> 0
            }
        }
    }


    val entityGrowthValues = Category.entries
        .associateWith { getEntityGrowth(it) }
        .filterValues { it != null }

    val categoryEffectivenessTable = Category.entries
        .associateWith { category ->
            val attack = HashMap<Category, Int>()
            val defend = HashMap<Category, Int>()
            Category.entries.forEach { category2 ->
                val attackRate = getCategoryEffectivenessTo(category, category2)
                if (attackRate != 0) {
                    attack[category2] = attackRate
                }
                val defendRate = getCategoryEffectivenessTo(category2, category)
                if (defendRate != 0) {
                    defend[category2] = defendRate
                }
            }
            CategoryEffectiveness(attack, defend)
        }
        .filterValues { it.attack.isNotEmpty() && it.defend.isNotEmpty() }

}