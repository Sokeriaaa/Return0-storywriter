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
package sokeriaaa.return0.storywriter.data.inventory

import sokeriaaa.return0.shared.data.models.entity.category.Category
import sokeriaaa.return0.shared.data.models.entity.path.EntityPath
import sokeriaaa.return0.shared.data.models.story.inventory.ItemData
import sokeriaaa.return0.storywriter.res.SWStrings

object SWInventories {

    val routerAccessToken = ItemData(
        key = "router_access_token",
        nameRes = SWStrings.create(
            "inventory.router_access_token",
            "Router Access Token",
        ),
        descriptionRes = SWStrings.create(
            "inventory.router_access_token.desc",
            "A master key for traversing the networked world. When bound to a user, it grants permission to interface with dormant Router Hubs.",
        ),
        loreRes = SWStrings.create(
            "inventory.router_access_token.lore",
            "Distance is a lie. Only permissions matter.",
        ),
        rarity = ItemData.Rarity.LEGENDARY,
        types = listOf(ItemData.Type.QUEST),
    )

    val inventories = listOf(
        routerAccessToken,
        *GeneralMaterial.entries
            .asSequence()
            .flatMap { type ->
                (0..3).map { SWInventoriesCommonMaterials.getGeneralMaterial(type = type, tier = it) }
            }
            .toList()
            .toTypedArray(),
        *Category.entries
            .asSequence()
            .filter { it != Category.ITEM && it != Category.NORMAL }
            .flatMap { type ->
                (0..2).map { SWInventoriesCommonMaterials.getCategoryMaterial(type = type, tier = it) }
            }
            .toList()
            .toTypedArray(),
        *EntityPath.entries
            .asSequence()
            .filter { it != EntityPath.UNSPECIFIED }
            .flatMap { type ->
                (0..2).map { SWInventoriesCommonMaterials.getPathMaterial(type = type, tier = it) }
            }
            .toList()
            .toTypedArray(),
    )
}