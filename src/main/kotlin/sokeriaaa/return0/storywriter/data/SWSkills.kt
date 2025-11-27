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

import sokeriaaa.return0.shared.data.api.component.extra.extrasGroupOf
import sokeriaaa.return0.shared.data.api.component.value.Value
import sokeriaaa.return0.shared.data.api.component.value.plus
import sokeriaaa.return0.shared.data.api.component.value.shl
import sokeriaaa.return0.shared.data.api.component.value.times
import sokeriaaa.return0.shared.data.models.action.function.FunctionData
import sokeriaaa.return0.shared.data.models.action.function.FunctionTarget
import sokeriaaa.return0.shared.data.models.component.extras.CombatExtra
import sokeriaaa.return0.shared.data.models.component.extras.CommonExtra
import sokeriaaa.return0.shared.data.models.component.values.ActionValue
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

    val wait = SkillEntry(
        simpleDescription = "Wait for a turn, greatly increase ATK on the next action.",
        functionData = FunctionData(
            name = "wait",
            category = Category.CLASS,
            target = FunctionTarget.Self,
            bullseye = true,
            basePower = 0,
            powerBonus = 0,
            baseSPCost = 30,
            spCostBonus = 10,
            growth = listOf(5, 30, 80),
            extra = CommonExtra.ForUser(
                extra = extrasGroupOf(
                    CombatExtra.AttachEffect(
                        name = SWEffects.deadlocked.name,
                        turns = Value(1),
                        tier = Value(1),
                    ),
                    CombatExtra.AttachEffect(
                        name = SWEffects.optimize.name,
                        turns = Value(2),
                        tier = ActionValue.Tier * 10 + 49,
                    ),
                )
            )
        ),
    )

    val hashCode = SkillEntry(
        simpleDescription = "Calculate the hashCode() of the arena. Deals random damage.",
        functionData = FunctionData(
            name = "hashCode",
            category = Category.CLASS,
            target = FunctionTarget.SingleEnemy,
            bullseye = false,
            basePower = 0,
            powerBonus = 0,
            baseSPCost = 60,
            spCostBonus = 10,
            growth = listOf(15, 25, 40, 60, 80),
            attackModifier = FunctionData.AttackModifier(
                actualPower = (Value(1) shl Value(0, 4)) * (ActionValue.Tier * 1 + 6)
            )
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

    val next = SkillEntry(
        simpleDescription = "Seeks the next element. Greatly increases SPD until the next action.",
        functionData = FunctionData(
            name = "next",
            category = Category.STREAM,
            target = FunctionTarget.SingleEnemy,
            bullseye = false,
            basePower = 12,
            powerBonus = 2,
            baseSPCost = 30,
            spCostBonus = 5,
            growth = listOf(5, 15, 30, 45, 60),
            extra = CommonExtra.ForUser(
                extra = CombatExtra.AttachEffect(
                    name = SWEffects.asynced.name,
                    turns = Value(1),
                    tier = Value(5) + ActionValue.Tier,
                )
            )
        )
    )

    val remove = SkillEntry(
        simpleDescription = "Remove the element. Reduces the DEF of target for few turns.",
        functionData = FunctionData(
            name = "remove",
            category = Category.INTERFACE,
            target = FunctionTarget.SingleEnemy,
            bullseye = false,
            basePower = 100,
            powerBonus = 25,
            baseSPCost = 150,
            spCostBonus = 25,
            growth = listOf(25, 55, 80),
            extra = CombatExtra.AttachEffect(
                name = SWEffects.overflowed.name,
                turns = Value(2),
                tier = ActionValue.Tier,
            )
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
            basePower = 50,
            powerBonus = 10,
            baseSPCost = 50,
            spCostBonus = 10,
            growth = listOf(0, 10, 20, 35, 50, 70),
            extra = CommonExtra.ForUser(
                extra = CombatExtra.HPChange(
                    hpChange = CombatValue.DamageCoerced * 0.25F
                )
            )
        )
    )

    val gc = SkillEntry(
        simpleDescription = "Lightly heals a single allies and remove all their debuff effects.",
        functionData = FunctionData(
            name = "gc",
            category = Category.MEMORY,
            target = FunctionTarget.SingleTeamMate,
            bullseye = false,
            basePower = -10,
            powerBonus = -1,
            baseSPCost = 100,
            spCostBonus = 20,
            growth = listOf(5, 15, 25, 40, 60, 80),
            extra = CombatExtra.RemoveAllEffect(debuff = true)
        )
    )

    val values = listOf(
        notify,
        wait,
        hashCode,
        forEach,
        next,
        remove,
        getProperty,
        gc,
    )

    data class SkillEntry(
        val simpleDescription: String,
        val functionData: FunctionData,
    )
}