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
package sokeriaaa.return0.storywriter.data.entities

import sokeriaaa.return0.shared.data.models.action.function.FunctionData
import sokeriaaa.return0.shared.data.models.entity.EntityData
import sokeriaaa.return0.shared.data.models.entity.EntityDropTable
import sokeriaaa.return0.shared.data.models.entity.category.Category
import sokeriaaa.return0.shared.data.models.entity.path.EntityPath
import sokeriaaa.return0.storywriter.data.SWCategories
import sokeriaaa.return0.storywriter.data.inventory.GeneralMaterial
import sokeriaaa.return0.storywriter.data.inventory.SWInventoriesCommonMaterials
import sokeriaaa.return0.storywriter.data.skill.SWSkillsCommon
import kotlin.math.roundToInt

object SWEntitiesCommon {

    /**
     * General names of enemies for common I, common II and elite.
     * These entities only have one category.
     * Entity data and functions are all auto-generated.
     */
    private val generalEnemies = mapOf(
        Category.CLASS to listOf("LegacyModel", "CircularInheritance", "PhantomClass"),
        Category.INTERFACE to listOf("LeakyAbstraction", "InterfaceMismatch", "UnimplementedStub"),
        Category.REFLECT to listOf("SelfInvocationLoop", "MetadataCorruption", "RuntimeInspector"),
        Category.CONCURRENT to listOf("DeadlockEntity", "RaceConditionError", "AtomicityViolation"),
        Category.STREAM to listOf("IndexOutOfBounds", "BrokenPipeException", "BackpressureCollapse"),
        Category.IO to listOf("FileNotFound", "DiskLatencySpike", "UnexpectedEOF"),
        Category.EXCEPTION to listOf("SuppressedThrowable", "NestedExceptionStack", "SilentCatchBlock"),
        Category.SECURITY to listOf("ExpiredToken", "EncryptionMismatch", "SandboxEscaped"),
        Category.DEBUG to listOf("BreakpointStall", "AssertionFailure", "TraceLeak"),
        Category.GENERIC to listOf("GenericCastError", "RawTypeMutation", "WildcardOverflow"),
        Category.MEMORY to listOf("MemoryLeak", "LeakFragment", "OutOfMemoryPulse"),
        Category.VOID to listOf("Nullptr", "EmptyReturnTrap", "VoidConsumption"),
    )

    private fun getCommonFunctionSet(category: Category, type: Int): List<FunctionData> = when (type) {
        0 -> listOf(
            SWSkillsCommon.getGeneralAttackSkill(category, 0).functionData,
        )

        1 -> listOf(
            SWSkillsCommon.getGeneralAttackSkill(category, 0).functionData,
            SWSkillsCommon.getGeneralAttackSkill(category, 1).functionData,
        )

        2 -> listOf(
            SWSkillsCommon.getGeneralAttackSkill(category, 1).functionData,
            SWSkillsCommon.getGeneralAttackSkill(category, 2).functionData,
            // TODO add special function for each category.
        )

        else -> error("type must be between 0 and 2, current: $type")
    }

    fun getCommonEnemy(category: Category, type: Int): EntityData {
        val growth = SWCategories.entityGrowthValues[category]!!
        return EntityData(
            name = generalEnemies[category]!![type],
            path = EntityPath.UNSPECIFIED,
            category = category,
            category2 = null,
            baseATK = ((80 + 20 * type) * (growth.atkGrowth + 0.25F)).roundToInt(),
            baseDEF = ((40 + 20 * type) * (growth.defGrowth + 0.25F)).roundToInt(),
            baseSPD = ((50 + 10 * type) * (growth.spdGrowth + 0.25F)).roundToInt(),
            baseHP = ((240 + 120 * type) * (growth.hpGrowth + 0.25F)).roundToInt(),
            baseSP = ((200 + 100 * type) * (growth.spGrowth + 0.25F)).roundToInt(),
            baseAP = 120 + type * 20,
            functions = getCommonFunctionSet(category, type),
        )
    }

    fun getCommonDropTableEntry(category: Category, type: Int): Pair<String, EntityDropTable> =
        generalEnemies[category]!![type] to getCommonDropTable(category, type)

    private fun getCommonDropTable(category: Category, type: Int): EntityDropTable {
        val index = type * Category.entries.size + category.ordinal
        val materialSets = SWInventoriesCommonMaterials.getGeneralMaterialSetByIndex(index)

        fun keyOf(material: GeneralMaterial, tier: Int): String {
            return SWInventoriesCommonMaterials.getGeneralMaterial(type = material, tier = tier).key
        }

        return EntityDropTable(
            value = materialSets.flatMap { material ->
                when (type) {
                    0 -> listOf(
                        EntityDropTable.DropEntry(
                            itemKey = keyOf(material, 1),
                            levelBonus = 0.025F,
                        ),
                        EntityDropTable.DropEntry(
                            itemKey = keyOf(material, 0),
                            base = 1.5F,
                            levelBonus = 0.05F,
                        ),
                    )

                    1 -> listOf(
                        EntityDropTable.DropEntry(
                            itemKey = keyOf(material, 2),
                            levelBonus = 0.01F,
                        ),
                        EntityDropTable.DropEntry(
                            itemKey = keyOf(material, 1),
                            levelBonus = 0.03F,
                        ),
                        EntityDropTable.DropEntry(
                            itemKey = keyOf(material, 0),
                            base = 2F,
                            levelBonus = 0.06F,
                        ),
                    )

                    2 -> listOf(
                        EntityDropTable.DropEntry(
                            itemKey = keyOf(material, 3),
                            levelBonus = 0.01F,
                        ),
                        EntityDropTable.DropEntry(
                            itemKey = keyOf(material, 2),
                            levelBonus = 0.03F,
                        ),
                        EntityDropTable.DropEntry(
                            itemKey = keyOf(material, 1),
                            base = 2F,
                            levelBonus = 0.04F,
                        ),
                        EntityDropTable.DropEntry(
                            itemKey = keyOf(material, 1),
                            base = 4F,
                            levelBonus = 0.07F,
                        ),
                    )

                    else -> error("")
                }
            }
        )
    }

}