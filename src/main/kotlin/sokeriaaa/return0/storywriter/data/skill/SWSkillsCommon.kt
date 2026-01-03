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

import sokeriaaa.return0.shared.data.models.action.function.FunctionData
import sokeriaaa.return0.shared.data.models.action.function.FunctionTarget
import sokeriaaa.return0.shared.data.models.entity.category.Category

/**
 * Common skills.
 */
object SWSkillsCommon {

    /**
     * General attacking functions with no additional effects.
     * Deals small/medium/large damage to a single target.
     *
     * Mainly used for enemies, sometimes can be used for party entities.
     */
    private val attackNames = mapOf(
        Category.CLASS to listOf("invoke", "callMethod", "executeOverride"),
        Category.INTERFACE to listOf("dispatch", "invokeInterface", "enforceContract"),
        Category.REFLECT to listOf("inspect", "reflectCall", "mirrorExecution"),
        Category.CONCURRENT to listOf("tick", "parallelRun", "threadBurst"),
        Category.STREAM to listOf("emit", "processFlow", "terminalOperation"),
        Category.IO to listOf("read", "write", "flush"),
        Category.EXCEPTION to listOf("throwException", "raiseException", "crash"),
        Category.SECURITY to listOf("block", "enforcePolicy", "accessDenied"),
        Category.DEBUG to listOf("log", "trace", "breakpointHit"),
        Category.GENERIC to listOf("applyType", "specializeType", "reifyType"),
        Category.MEMORY to listOf("allocate", "consumeHeap", "exhaustMemory"),
        Category.VOID to listOf("nullHit", "eraseValue", "voidCollapse"),
    )

    fun getGeneralAttackSkill(
        category: Category,
        type: Int,
    ): SWSkills.SkillEntry {
        require(type in 0..2) {
            "type must be between 0 and 2, current: $type"
        }
        return SWSkills.SkillEntry(
            simpleDescription = "Deal ${
                when (type) {
                    0 -> "small"
                    1 -> "medium"
                    2 -> "large"
                    else -> error("")
                }
            } damage to a single target.",
            functionData = FunctionData(
                category = category,
                name = attackNames[category]!![type],
                target = FunctionTarget.SingleEnemy,
                bullseye = false,
                basePower = type * 60 + 40,
                powerBonus = type * 30 + 20,
                baseSPCost = type * 60 + 30,
                spCostBonus = type * 30 + 15,
                growth = when (type) {
                    0 -> listOf(5, 15, 30)
                    1 -> listOf(20, 35, 50, 70)
                    2 -> listOf(30, 45, 60, 75, 90)
                    else -> error("")
                },
            )
        )
    }

}