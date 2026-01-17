package sokeriaaa.return0.storywriter.data.plugins

import sokeriaaa.return0.shared.data.api.component.condition.IF
import sokeriaaa.return0.shared.data.api.component.condition.and
import sokeriaaa.return0.shared.data.api.component.condition.gt
import sokeriaaa.return0.shared.data.api.component.value.coerceAtMost
import sokeriaaa.return0.shared.data.api.component.value.minus
import sokeriaaa.return0.shared.data.api.component.value.plus
import sokeriaaa.return0.shared.data.api.component.value.times
import sokeriaaa.return0.shared.data.models.component.conditions.CommonCondition
import sokeriaaa.return0.shared.data.models.component.extras.CombatExtra
import sokeriaaa.return0.shared.data.models.component.extras.Extra
import sokeriaaa.return0.shared.data.models.component.values.CombatValue
import sokeriaaa.return0.shared.data.models.component.values.EntityValue
import sokeriaaa.return0.shared.data.models.component.values.PluginValue
import sokeriaaa.return0.shared.data.models.component.values.Value
import sokeriaaa.return0.shared.data.models.entity.path.EntityPath
import sokeriaaa.return0.shared.data.models.entity.plugin.PluginData
import sokeriaaa.return0.storywriter.res.SWStrings

object SWPlugins {

    // Heap
    val growthFactorArray = plugin(
        key = "growth_factor_array",
        name = "Growth Factor Array",
        description = "Each action increases damage by 1 stack, maximum for 10.",
        path = EntityPath.HEAP,
        attackRate = ((EntityValue.ActionsTaken.coerceAtMost(10)) * PluginValue.Tier * 0.005F) + 1
    )

    // Thread
    val raceCondition = plugin(
        key = "race_condition",
        name = "Race Condition",
        description = "Each attack has chance to advance your action.",
        path = EntityPath.THREAD,
        onAttack = IF(CommonCondition.Chance(PluginValue.Tier * 0.01F + 0.08F))
            .then(CombatExtra.APChange(PluginValue.Tier + 12))
    )

    // Overclock
    val clockSkipper = plugin(
        key = "clock_skipper",
        name = "Clock Skipper",
        description = "When defeating an enemy, there is a chance to fill your Max AP immediately.",
        path = EntityPath.OVERCLOCK,
        onAttack = IF(
            CommonCondition.Chance(PluginValue.Tier * 0.03F + 0.24F)
                    and (CombatValue.DamageCoerced gt 0)
                    and (CombatValue.Damage gt CombatValue.DamageCoerced)
        ).then(CombatExtra.APChange(EntityValue.MAXAP - EntityValue.AP)),
    )

    // Sandbox

    // Protocol

    // Daemon

    // Kernel

    // Runtime

    // All plugins
    val plugins = listOf(
        growthFactorArray,
        raceCondition,
        clockSkipper,
    )

    private fun plugin(
        key: String,
        name: String,
        description: String,
        path: EntityPath,
        onAttack: Extra? = null,
        onDefend: Extra? = null,
        attackRate: Value? = null,
        defendRate: Value? = null,
    ): PluginData = PluginData(
        key = key,
        nameRes = SWStrings.create(
            "plugin.$key",
            name,
        ),
        descriptionRes = SWStrings.create(
            "plugin.$key.desc",
            description,
        ),
        path = path,
        onAttack = onAttack,
        onDefend = onDefend,
        attackRate = attackRate,
        defendRate = defendRate,
    )
}