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
package sokeriaaa.return0.storywriter.data.skill

import sokeriaaa.return0.shared.data.api.component.condition.IF
import sokeriaaa.return0.shared.data.api.component.condition.gt
import sokeriaaa.return0.shared.data.api.component.condition.gtEq
import sokeriaaa.return0.shared.data.api.component.extra.extrasGroupOf
import sokeriaaa.return0.shared.data.api.component.value.*
import sokeriaaa.return0.shared.data.models.action.function.FunctionData
import sokeriaaa.return0.shared.data.models.action.function.FunctionTarget
import sokeriaaa.return0.shared.data.models.component.conditions.CombatCondition
import sokeriaaa.return0.shared.data.models.component.conditions.CommonCondition
import sokeriaaa.return0.shared.data.models.component.extras.CombatExtra
import sokeriaaa.return0.shared.data.models.component.extras.CommonExtra
import sokeriaaa.return0.shared.data.models.component.values.ActionValue
import sokeriaaa.return0.shared.data.models.component.values.CombatValue
import sokeriaaa.return0.shared.data.models.component.values.EntityValue
import sokeriaaa.return0.shared.data.models.component.values.Value
import sokeriaaa.return0.shared.data.models.entity.category.Category
import sokeriaaa.return0.storywriter.data.SWEffects

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
            powerBonus = 20,
            baseSPCost = 100,
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
            baseSPCost = 50,
            growth = listOf(5, 30, 80),
            extra = CommonExtra.ForUser(
                extra = extrasGroupOf(
                    CombatExtra.APChange(
                        apChange = -EntityValue.MAXAP
                    ),
                    CombatExtra.AttachEffect(
                        name = SWEffects.optimize.name,
                        turns = Value(1),
                        tier = ActionValue.Tier * 20 + 20,
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
            baseSPCost = 150,
            growth = listOf(15, 25, 40, 60, 80),
            attackModifier = FunctionData.AttackModifier(
                actualPower = (Value(2) shl Value(0, 4)) * (ActionValue.Tier * 1 + 6)
            )
        ),
    )

    //===================
    // Entity - StringBuilder
    //===================
    val append = SkillEntry(
        simpleDescription = "Append a new string, deals light damage to a single target, lightly increase ATK for 2 turns (extendable).",
        functionData = FunctionData(
            name = "append",
            category = Category.STREAM,
            target = FunctionTarget.SingleEnemy,
            bullseye = false,
            basePower = 15,
            powerBonus = 5,
            baseSPCost = 50,
            growth = listOf(1, 10, 20, 35, 50, 70),
            extra = CommonExtra.ForUser(
                extra = CombatExtra.AttachEffect(
                    name = SWEffects.optimize.name,
                    turns = EntityValue.TurnsLeftOf(SWEffects.optimize.name) + 2,
                    tier = ActionValue.Tier + 4,
                ),
            )
        ),
    )

    val toString = SkillEntry(
        simpleDescription = "Empty your current SP and the ATK increment, Deal huge damage to a single target, based on consumed SP and ATK increment.",
        functionData = FunctionData(
            name = "toString",
            category = Category.STREAM,
            target = FunctionTarget.SingleEnemy,
            bullseye = false,
            basePower = 0,
            powerBonus = 0,
            baseSPCost = 1,
            growth = listOf(),
            attackModifier = FunctionData.AttackModifier(
                actualPower = CombatValue.ForUser(
                    (EntityValue.SP * 0.2F) + (EntityValue.TurnsLeftOf(SWEffects.optimize.name) * 64)
                ).coerceAtLeast(1)
            ),
            extra = CommonExtra.ForUser(
                extra = extrasGroupOf(
                    CombatExtra.SPChange(-EntityValue.SP),
                    CombatExtra.RemoveEffect(SWEffects.optimize.name)
                ),
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
            baseSPCost = 150,
            growth = listOf(0, 10, 20, 35, 50, 70),
            attackModifier = FunctionData.AttackModifier(
                attackTimes = Value(8, 12)
            ),
        )
    )

    val next = SkillEntry(
        simpleDescription = "Seeks the next element. Bullseye; Greatly increases SPD until the next action.",
        functionData = FunctionData(
            name = "next",
            category = Category.STREAM,
            target = FunctionTarget.SingleEnemy,
            bullseye = true,
            basePower = 12,
            powerBonus = 2,
            baseSPCost = 50,
            growth = listOf(5, 15, 30, 45, 60),
            extra = CommonExtra.ForUser(
                extra = CombatExtra.AttachEffect(
                    name = SWEffects.async.name,
                    turns = Value(1),
                    tier = Value(10) + ActionValue.Tier * 4,
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
            basePower = 120,
            powerBonus = 20,
            baseSPCost = 200,
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
            basePower = 70,
            powerBonus = 10,
            baseSPCost = 100,
            growth = listOf(0, 10, 20, 35, 50, 70),
            extra = CommonExtra.ForUser(
                extra = CombatExtra.HPChange(
                    hpChange = CombatValue.DamageCoerced * 0.5F
                )
            )
        )
    )

    val gc = SkillEntry(
        simpleDescription = "Lightly heals a single allies and remove all their debuff effects. " +
                "When invoking at yourself, the healing is significantly buffed.",
        functionData = FunctionData(
            name = "gc",
            category = Category.MEMORY,
            target = FunctionTarget.SingleTeamMate,
            bullseye = false,
            basePower = -10,
            powerBonus = -1,
            baseSPCost = 100,
            growth = listOf(5, 15, 25, 40, 60, 80),
            extra = CombatExtra.RemoveAllEffect(debuff = true),
            attackModifier = FunctionData.AttackModifier(
                actualPower = IF(CombatCondition.TargetingSelf)
                    .then(
                        ifTrue = ActionValue.Skills.Power * 20,
                        ifFalse = ActionValue.Skills.Power,
                    )
            )
        )
    )

    val arraycopy = SkillEntry(
        simpleDescription = "Perform an array copy. Lightly consumes your HP, " +
                "then creates a shield based on your MAXHP for a teammate. " +
                "Has no effect when your HP is insufficient for consuming.",
        functionData = FunctionData(
            name = "arraycopy",
            category = Category.MEMORY,
            target = FunctionTarget.SingleTeamMate,
            bullseye = false,
            basePower = 0,
            powerBonus = 0,
            baseSPCost = 100,
            growth = listOf(10, 25, 45, 65, 85),
            extra = run {
                val hpConsumed = (CombatValue.ForUser(EntityValue.MAXHP) * 0.1F)
                IF(CombatValue.ForUser(EntityValue.HP) gt hpConsumed)
                    .then(
                        ifTrue = extrasGroupOf(
                            CombatExtra.AttachShield(
                                key = "arraycopy",
                                value = hpConsumed * (ActionValue.Tier * 0.3F + 1.2F),
                            ),
                            CommonExtra.ForUser(
                                extra = CombatExtra.HPChange(
                                    hpChange = -hpConsumed,
                                    ignoresShield = CommonCondition.True,
                                )
                            )
                        ),
                        ifFalse = CombatExtra.NoEffect,
                    )
            }
        )
    )

    //===================
    // Entity - Validator
    //===================
    val setResourceResolver = SkillEntry(
        simpleDescription = "Sets the resource resolver to handle schema imports " +
                "or included documents. Apply 3-round Injected effect on target, " +
                "if target has full hp, apply 12-round instead.",
        functionData = FunctionData(
            name = "setResourceResolver",
            category = Category.IO,
            target = FunctionTarget.SingleEnemy,
            bullseye = false,
            basePower = 70,
            powerBonus = 20,
            baseSPCost = 100,
            growth = listOf(1, 20, 60),
            extra = CombatExtra.AttachEffect(
                name = SWEffects.injected.name,
                turns = IF((EntityValue.HP + CombatValue.DamageCoerced) gtEq EntityValue.MAXHP)
                    .then(ifTrue = Value(12), ifFalse = Value(3)) as Value.Combat,
                tier = ActionValue.Tier + 1,
            )
        )
    )

    val setErrorHandler = SkillEntry(
        simpleDescription = "Sets the error handler for validation events. Apply cached effect " +
                "to yourself.",
        functionData = FunctionData(
            name = "setErrorHandler",
            category = Category.SECURITY,
            target = FunctionTarget.Self,
            bullseye = false,
            basePower = 0,
            powerBonus = 0,
            baseSPCost = 50,
            growth = listOf(10, 45, 75),
            extra = CommonExtra.ForUser(
                CombatExtra.AttachEffect(
                    name = SWEffects.cached.name,
                    turns = ActionValue.Tier + 2,
                    tier = ActionValue.Tier + 2,
                ),
            ),
        )
    )

    val validate = SkillEntry(
        simpleDescription = "Validates the specified XML input source. The more turns of " +
                "inject effect target have and cached effect you have, the more power " +
                "this function is, and the more chance to apply a 5-round bugInfested effect.",
        functionData = FunctionData(
            name = "validate",
            category = Category.SECURITY,
            target = FunctionTarget.SingleEnemy,
            bullseye = false,
            basePower = 80,
            powerBonus = 20,
            baseSPCost = 150,
            growth = listOf(1, 30, 70),
            attackModifier = FunctionData.AttackModifier(
                actualPower = ActionValue.Skills.Power + (EntityValue.TurnsLeftOf(SWEffects.injected.name) +
                        CombatValue.ForUser(EntityValue.TurnsLeftOf(SWEffects.cached.name))) * 5,
            ),
            extra = IF(
                condition = CommonCondition.Chance(
                    success = (EntityValue.TurnsLeftOf(SWEffects.injected.name) +
                            CombatValue.ForUser(EntityValue.TurnsLeftOf(SWEffects.cached.name))) * 0.05F,
                )
            ).then(
                ifTrue = CombatExtra.AttachEffect(
                    name = SWEffects.bugInfested.name,
                    turns = Value(5),
                    tier = ActionValue.Tier + 1,
                ),
            )
        )
    )

    //===================
    // Enemy
    //===================
    val leak = SkillEntry(
        simpleDescription = "Leak the memory. Let the target lose HP after each action in limited turns.",
        functionData = FunctionData(
            name = "leak",
            category = Category.MEMORY,
            target = FunctionTarget.SingleEnemy,
            bullseye = false,
            basePower = 20,
            powerBonus = 10,
            baseSPCost = 100,
            growth = listOf(1, 20, 40, 70),
            extra = CombatExtra.AttachEffect(
                name = SWEffects.bugInfested.name,
                turns = ActionValue.Tier + 1,
                tier = Value(1),
            )
        )
    )

    //===================
    // Shared
    //===================
    val delete = SkillEntry(
        simpleDescription = "Chance to remove a single target's all shields. The higher HP rate target has, the higher chance to remove.",
        functionData = FunctionData(
            name = "delete",
            category = Category.INTERFACE,
            target = FunctionTarget.SingleEnemy,
            bullseye = false,
            basePower = 120,
            powerBonus = 20,
            baseSPCost = 150,
            growth = listOf(25, 55, 80),
            extra = IF(CommonCondition.Chance(EntityValue.HPRate))
                .then(CombatExtra.RemoveAllShields)
        )
    )

    val values = listOf(
        notify,
        wait,
        hashCode,
        append,
        toString,
        forEach,
        next,
        remove,
        getProperty,
        gc,
        arraycopy,
        setResourceResolver,
        setErrorHandler,
        validate,
        delete,
        // All general attack skills.
        *Category.entries
            .asSequence()
            .filter { it != Category.ITEM && it != Category.NORMAL }
            .flatMap { category ->
                sequenceOf(0, 1, 2).map { SWSkillsCommon.getGeneralAttackSkill(category, it) }
            }
            .toList()
            .toTypedArray()
    )

    data class SkillEntry(
        val simpleDescription: String,
        val functionData: FunctionData,
    )
}