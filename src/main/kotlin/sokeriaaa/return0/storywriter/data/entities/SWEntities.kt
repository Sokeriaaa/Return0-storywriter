/**
 * Copyright (C) 2025 Sokeriaaa
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package sokeriaaa.return0.storywriter.data.entities

import sokeriaaa.return0.shared.data.models.entity.EntityData
import sokeriaaa.return0.shared.data.models.entity.category.Category
import sokeriaaa.return0.shared.data.models.entity.path.EntityPath
import sokeriaaa.return0.storywriter.data.skill.SWSkills

object SWEntities {

    val `object` = EntityData(
        name = "Object",
        path = EntityPath.HEAP,
        category = Category.CLASS,
        baseATK = 56,
        baseDEF = 27,
        baseSPD = 28,
        baseHP = 314,
        baseSP = 500,
        baseAP = 120,
        functions = sequenceOf(
            SWSkills.notify,
            SWSkills.wait,
            SWSkills.hashCode,
        ).map { it.functionData.name }.toList(),
    )

    val stringBuilder = EntityData(
        name = "StringBuilder",
        path = EntityPath.OVERCLOCK,
        category = Category.STREAM,
        baseATK = 64,
        baseDEF = 22,
        baseSPD = 33,
        baseHP = 275,
        baseSP = 500,
        baseAP = 110,
        functions = sequenceOf(
            SWSkills.append,
            SWSkills.toString,
            SWSkills.delete,
        ).map { it.functionData.name }.toList(),
        attackModifier = EntityData.GeneralAttackModifier(
            power = 10,
            attackTimes = 3,
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
        baseSP = 500,
        baseAP = 110,
        functions = sequenceOf(
            SWSkills.forEach,
            SWSkills.next,
            SWSkills.remove,
        ).map { it.functionData.name }.toList(),
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
        baseSP = 500,
        baseAP = 130,
        functions = sequenceOf(
            SWSkills.getProperty,
            SWSkills.gc,
            SWSkills.arraycopy,
        ).map { it.functionData.name }.toList(),
    )

    val validator = EntityData(
        name = "Validator",
        path = EntityPath.RUNTIME,
        category = Category.SECURITY,
        baseATK = 58,
        baseDEF = 29,
        baseSPD = 41,
        baseHP = 286,
        baseSP = 500,
        baseAP = 120,
        functions = sequenceOf(
            SWSkills.setResourceResolver,
            SWSkills.setErrorHandler,
            SWSkills.validate,
        ).map { it.functionData.name }.toList(),
    )

    val values = listOf(
        // Party
        `object`,
        stringBuilder,
        iterator,
        system,
        validator,
        // Enemy: Common & Elite
        *Category.entries
            .asSequence()
            .filter { it != Category.ITEM && it != Category.NORMAL }
            .flatMap { category ->
                sequenceOf(0, 1, 2).map { SWEntitiesCommon.getCommonEnemy(category, it) }
            }
            .toList()
            .toTypedArray(),
    )

}