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
package sokeriaaa.return0.storywriter.data.entities

import sokeriaaa.return0.shared.data.models.entity.category.Category

object SWEntitiesDropTable {

    val values = mapOf(
        *Category.entries
            .asSequence()
            .filter { it != Category.ITEM && it != Category.NORMAL }
            .flatMap { category ->
                sequenceOf(0, 1, 2).map {
                    SWEntitiesCommon.getCommonDropTableEntry(category, it)
                }
            }
            .toList()
            .toTypedArray(),
    )
}