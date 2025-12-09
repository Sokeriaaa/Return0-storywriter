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

import sokeriaaa.return0.shared.data.models.entity.EntityData
import sokeriaaa.return0.shared.data.models.entity.category.Category
import sokeriaaa.return0.shared.data.models.entity.path.EntityPath

object SWEntities {

    val `object` = EntityData(
        name = "Object",
        path = EntityPath.HEAP,
        category = Category.CLASS,
        baseATK = 56,
        baseDEF = 27,
        baseSPD = 28,
        baseHP = 314,
        baseSP = 288,
        baseAP = 120,
        functions = listOf(
            SWSkills.notify.functionData,
            SWSkills.wait.functionData,
            SWSkills.hashCode.functionData,
        ),
    )

    val iterator = EntityData(
        name = "Iterator",
        path = EntityPath.THREAD,
        category = Category.STREAM,
        baseATK = 73,
        baseDEF = 20,
        baseSPD = 48,
        baseHP = 227,
        baseSP = 215,
        baseAP = 110,
        functions = listOf(
            SWSkills.forEach.functionData,
            SWSkills.next.functionData,
            SWSkills.remove.functionData,
        ),
        attackModifier = EntityData.GeneralAttackModifier(
            power = 10,
            attackTimes = 3,
        )
    )

    val system = EntityData(
        name = "System",
        path = EntityPath.KERNEL,
        category = Category.MEMORY,
        baseATK = 50,
        baseDEF = 34,
        baseSPD = 24,
        baseHP = 368,
        baseSP = 225,
        baseAP = 130,
        functions = listOf(
            SWSkills.getProperty.functionData,
            SWSkills.gc.functionData,
            SWSkills.arraycopy.functionData,
        ),
    )

    val values = listOf(
        `object`,
        iterator,
        system,
    )

}