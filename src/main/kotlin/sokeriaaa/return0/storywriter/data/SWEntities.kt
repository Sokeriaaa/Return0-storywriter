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
import sokeriaaa.return0.storywriter.data.skill.SWSkills
import sokeriaaa.return0.storywriter.data.skill.SWSkillsCommon

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

    val stringBuilder = EntityData(
        name = "StringBuilder",
        path = EntityPath.OVERCLOCK,
        category = Category.STREAM,
        baseATK = 64,
        baseDEF = 22,
        baseSPD = 33,
        baseHP = 275,
        baseSP = 303,
        baseAP = 110,
        functions = listOf(
            SWSkills.append.functionData,
            SWSkills.toString.functionData,
            SWSkills.delete.functionData,
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

    // Enemies: Easy
    val nullptr = EntityData(
        name = "Nullptr",
        path = EntityPath.UNSPECIFIED,
        category = Category.VOID,
        baseATK = 37,
        baseDEF = 16,
        baseSPD = 22,
        baseHP = 198,
        baseSP = 150,
        baseAP = 120,
        functions = listOf()
    )
    val memoryLeak = EntityData(
        name = "MemoryLeak",
        path = EntityPath.UNSPECIFIED,
        category = Category.MEMORY,
        baseATK = 32,
        baseDEF = 22,
        baseSPD = 18,
        baseHP = 257,
        baseSP = 205,
        baseAP = 120,
        functions = listOf()
    )
    val indexOutOfBounds = EntityData(
        name = "IndexOutOfBounds",
        path = EntityPath.UNSPECIFIED,
        category = Category.STREAM,
        baseATK = 47,
        baseDEF = 14,
        baseSPD = 29,
        baseHP = 175,
        baseSP = 222,
        baseAP = 100,
        functions = listOf()
    )

    // Enemies: Elite
    val leakFragment = EntityData(
        name = "LeakFragment",
        path = EntityPath.UNSPECIFIED,
        category = Category.MEMORY,
        baseATK = 35,
        baseDEF = 24,
        baseSPD = 20,
        baseHP = 283,
        baseSP = 225,
        baseAP = 120,
        functions = listOf(
            SWSkillsCommon.getGeneralAttackSkill(Category.MEMORY, 0).functionData,
            SWSkillsCommon.getGeneralAttackSkill(Category.MEMORY, 1).functionData,
            SWSkills.leak.functionData,
        )
    )

    val values = listOf(
        // Party
        `object`,
        stringBuilder,
        iterator,
        system,
        // Enemy: Easy
        nullptr,
        memoryLeak,
        indexOutOfBounds,
        // Enemies: Elite
        leakFragment,
    )

}