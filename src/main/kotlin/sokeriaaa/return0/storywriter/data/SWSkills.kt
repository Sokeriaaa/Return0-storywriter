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

import sokeriaaa.return0.shared.data.api.component.value.Value
import sokeriaaa.return0.shared.data.api.component.value.times
import sokeriaaa.return0.shared.data.models.action.function.FunctionData
import sokeriaaa.return0.shared.data.models.action.function.FunctionTarget
import sokeriaaa.return0.shared.data.models.component.extras.CombatExtra
import sokeriaaa.return0.shared.data.models.component.extras.CommonExtra
import sokeriaaa.return0.shared.data.models.component.values.CombatValue
import sokeriaaa.return0.shared.data.models.entity.category.Category

object SWSkills {

    //===================
    // Common
    //===================
    //===================
    // Entity - Object
    //===================
    val notify = SkillEntry(
        simpleDescription = "Notifies a single entity, deals small damage.",
        functionData = FunctionData(
            name = "notify",
            category = Category.CLASS,
            target = FunctionTarget.SingleEnemy,
            bullseye = false,
            basePower = 40,
            powerBonus = 10,
            baseSPCost = 25,
            spCostBonus = 5,
            growth = listOf(2, 10, 20, 35, 50, 70),
        ),
    )

    //===================
    // Entity - Iterator
    //===================
    val forEach = SkillEntry(
        simpleDescription = "Iterates a single entity multiple times, deals small damage.",
        functionData = FunctionData(
            name = "forEach",
            category = Category.STREAM,
            target = FunctionTarget.SingleEnemy,
            bullseye = false,
            basePower = 5,
            powerBonus = 2,
            baseSPCost = 50,
            spCostBonus = 10,
            growth = listOf(0, 10, 20, 35, 50, 70),
            attackModifier = FunctionData.AttackModifier(
                attackTimes = Value(8, 12)
            ),
        )
    )

    //===================
    // Entity - System
    //===================
    val getProperty = SkillEntry(
        simpleDescription = "Gets the property of a single entity, deals small damage and " +
                "recovers yourself a percentage of the damage dealt.",
        functionData = FunctionData(
            name = "getProperty",
            category = Category.MEMORY,
            target = FunctionTarget.SingleEnemy,
            bullseye = false,
            basePower = 30,
            powerBonus = 5,
            baseSPCost = 50,
            spCostBonus = 10,
            growth = listOf(0, 10, 20, 35, 50, 70),
            extra = CommonExtra.ForUser(
                extra = CombatExtra.HPChange(
                    hpChange = CombatValue.DamageCoerced * 0.2F
                )
            )
        )
    )

    val values = listOf(
        notify,
        forEach,
        getProperty,
    )

    data class SkillEntry(
        val simpleDescription: String,
        val functionData: FunctionData,
    )
}