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

import sokeriaaa.return0.shared.data.api.component.value.times
import sokeriaaa.return0.shared.data.models.action.effect.EffectData
import sokeriaaa.return0.shared.data.models.action.effect.EffectModifier
import sokeriaaa.return0.shared.data.models.component.conditions.CommonCondition
import sokeriaaa.return0.shared.data.models.component.extras.CombatExtra
import sokeriaaa.return0.shared.data.models.component.values.ActionValue
import sokeriaaa.return0.shared.data.models.component.values.EntityValue

object SWEffects {
    //===================
    // Modifiers
    //===================
    val optimize = EffectEntry(
        simpleDescription = "Code optimization increases ATK.",
        effectData = EffectData(
            name = "optimize",
            abbr = "ATK↑",
            isDebuff = false,
            modifiers = listOf(
                EffectModifier(
                    type = EffectModifier.Types.ATK,
                    offset = 0.1F,
                    tierBonus = 0.05F,
                )
            )
        ),
    )

    val cached = EffectEntry(
        simpleDescription = "Stores repeated data, boosting DEF.",
        effectData = EffectData(
            name = "cached",
            abbr = "DEF↑",
            isDebuff = false,
            modifiers = listOf(
                EffectModifier(
                    type = EffectModifier.Types.DEF,
                    offset = 0.1F,
                    tierBonus = 0.05F,
                )
            )
        ),
    )

    val async = EffectEntry(
        simpleDescription = "Concurrent execution increases SPD.",
        effectData = EffectData(
            name = "async",
            abbr = "SPD↑",
            isDebuff = false,
            modifiers = listOf(
                EffectModifier(
                    type = EffectModifier.Types.SPD,
                    offset = 0.1F,
                    tierBonus = 0.05F,
                )
            )
        ),
    )

    val nullPointer = EffectEntry(
        simpleDescription = "Null reference error lowers ATK.",
        effectData = EffectData(
            name = "null_pointer",
            abbr = "ATK↓",
            isDebuff = true,
            modifiers = listOf(
                EffectModifier(
                    type = EffectModifier.Types.ATK,
                    offset = -0.1F,
                    tierBonus = -0.05F,
                )
            )
        ),
    )

    val overflowed = EffectEntry(
        simpleDescription = "Memory overflow reduces DEF.",
        effectData = EffectData(
            name = "overflowed",
            abbr = "DEF↓",
            isDebuff = true,
            modifiers = listOf(
                EffectModifier(
                    type = EffectModifier.Types.DEF,
                    offset = -0.1F,
                    tierBonus = -0.05F,
                )
            )
        ),
    )

    val ioFailure = EffectEntry(
        simpleDescription = "IO Failures reduces SPD.",
        effectData = EffectData(
            name = "io_failure",
            abbr = "SPD↓",
            isDebuff = true,
            modifiers = listOf(
                EffectModifier(
                    type = EffectModifier.Types.SPD,
                    offset = -0.1F,
                    tierBonus = -0.05F,
                )
            )
        ),
    )

    //===================
    // Extras
    //===================
    val bugInfested = EffectEntry(
        simpleDescription = "Bug infested, drains HP after each action. Ignores shields.",
        effectData = EffectData(
            name = "bug_infested",
            abbr = "BUG",
            isDebuff = true,
            extra = CombatExtra.HPChange(
                // The target loses tier/32 of maxhp after each action.
                hpChange = EntityValue.HP * -0.03125F * ActionValue.Tier,
                ignoresShield = CommonCondition.True,
            )
        )
    )

    val refactoring = EffectEntry(
        simpleDescription = "Refactoring the class, restores HP after each turn.",
        effectData = EffectData(
            name = "refactoring",
            abbr = "REF",
            isDebuff = false,
            extra = CombatExtra.HPChange(
                // The target restores tier/32 of maxhp after each action.
                hpChange = EntityValue.HP * 0.03125F * ActionValue.Tier,
            )
        )
    )

    //===================
    // Special
    //===================
    val deadlocked = EffectEntry(
        simpleDescription = "Deadlocked, can not take actions.",
        effectData = EffectData(
            name = "deadlocked",
            abbr = "LOCK",
            isDebuff = true,
            isFreeze = true
        )
    )

    val values = listOf(
        optimize,
        cached,
        async,
        nullPointer,
        overflowed,
        ioFailure,
        bugInfested,
        refactoring,
        deadlocked,
    )

    data class EffectEntry(
        val simpleDescription: String,
        val effectData: EffectData,
    ) {
        val name get() = effectData.name
    }

}