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
package sokeriaaa.return0.storywriter.data.inventory

import sokeriaaa.return0.shared.data.models.entity.category.Category
import sokeriaaa.return0.shared.data.models.entity.path.EntityPath
import sokeriaaa.return0.shared.data.models.story.inventory.ItemData
import sokeriaaa.return0.storywriter.res.SWStrings

object SWInventoriesCommonMaterials {

    private val generalMaterials1 = mapOf(
        GeneralMaterial.DATA_RESIDUE to listOf(
            "Data Residue" to "Scattered remnants of processed data, left behind after incomplete execution.",
            "Condensed Residue" to "Residue compressed by repeated operations, retaining partial structural patterns.",
            "Structured Residue" to "Residue stabilized into predictable formations, suitable for controlled synthesis.",
            "Pristine Data Core" to "A perfectly preserved concentration of data, free from corruption or noise."
        ),
        GeneralMaterial.EXECUTION_FRAGMENT to listOf(
            "Execution Fragment" to "A broken slice of an interrupted execution flow.",
            "Bound Fragment" to "Execution fragments fused together to restore partial continuity.",
            "Execution Lattice" to "A structured network of execution paths woven into a stable form.",
            "Execution Kernel" to "The irreducible core of execution logic, capable of initiating complex behavior."
        ),
        GeneralMaterial.LOGIC_DUST to listOf(
            "Logic Dust" to "Fine particles of discarded decision paths and unused conditions.",
            "Logic Powder" to "Dust compressed into a more reactive and coherent logical substance.",
            "Logic Crystal" to "Crystallized logic with deterministic internal structure.",
            "Logical Singularity" to "A dense convergence point of logic where outcomes become inevitable."
        ),
        GeneralMaterial.RUNTIME_ALLOY to listOf(
            "Runtime Scrap" to "Fragments of unstable runtime constructs torn from execution.",
            "Runtime Alloy" to "Scrap refined into a flexible yet resilient runtime material.",
            "Refined Runtime Alloy" to "Highly purified alloy optimized for adaptability under load.",
            "Adaptive Runtime Frame" to "A self-adjusting structural frame that responds to execution pressure."
        ),
        GeneralMaterial.MEMORY_FIBER to listOf(
            "Memory Fiber" to "Thin strands extracted from volatile memory regions.",
            "Woven Fiber" to "Memory fibers interlaced to improve retention and stability.",
            "Memory Weave" to "A dense weave capable of holding complex state information.",
            "Neural Fabric" to "An advanced memory fabric that reacts dynamically to access patterns."
        ),
        GeneralMaterial.CONTROL_CIRCUIT to listOf(
            "Control Circuit" to "A simple circuit governing basic operational flow.",
            "Integrated Circuit" to "Multiple control paths combined into a single coordinated unit.",
            "Command Circuit" to "A high-level circuit capable of issuing prioritized directives.",
            "Directive Matrix" to "An authoritative matrix that enforces execution order and intent."
        ),
        GeneralMaterial.STATE_CACHE to listOf(
            "State Cache" to "A temporary store holding transient execution states.",
            "Persistent Cache" to "A cache reinforced to survive repeated access cycles.",
            "Stabilized Cache" to "A state cache hardened against invalidation and drift.",
            "Immutable Snapshot" to "A frozen representation of state, immune to modification."
        ),
        GeneralMaterial.BYTE_CRYSTAL to listOf(
            "Raw Byte Crystal" to "Unaligned byte clusters with latent informational potential.",
            "Aligned Byte Crystal" to "Bytes realigned into a coherent crystalline structure.",
            "Encoded Crystal" to "A crystal carrying layered encoded information.",
            "Perfect Byte Prism" to "A flawless prism that refracts data with zero loss."
        ),
        GeneralMaterial.SIGNAL_FILAMENT to listOf(
            "Signal Filament" to "A fragile filament carrying intermittent signals.",
            "Signal Strand" to "A reinforced filament capable of sustained transmission.",
            "Signal Bundle" to "Multiple strands combined to amplify throughput.",
            "Signal Backbone" to "A high-capacity transmission spine supporting complex systems."
        ),
        GeneralMaterial.DEBUG_ASH to listOf(
            "Debug Ash" to "Residual ash left after excessive diagnostic operations.",
            "Compiled Ash" to "Ash compacted through compilation, retaining trace metadata.",
            "Optimized Ash" to "Refined ash stripped of redundancy and noise.",
            "Trace Remnant" to "The final imprint of execution history, preserved beyond deletion."
        ),
    )

    private val categoryMaterial1: Map<Category, List<Pair<String, String>>> = mapOf(
        Category.CLASS to listOf(
            "Class Blueprint" to "A foundational plan defining structure, fields, and responsibilities.",
            "Inheritance Schema" to "A refined schema describing hierarchical relationships and reuse.",
            "Class Archetype" to "A perfected class pattern embodying stability and authority."
        ),

        Category.INTERFACE to listOf(
            "Interface Stub" to "A minimal contract outlining required behavior without implementation.",
            "Contract Schema" to "A formalized definition of expectations between components.",
            "Interface Manifest" to "An authoritative record of guarantees enforced across systems."
        ),

        Category.REFLECT to listOf(
            "Reflection Shard" to "A fragment capable of revealing hidden runtime properties.",
            "Mirror Index" to "An indexed structure mapping types to their runtime representations.",
            "Introspection Core" to "A core component enabling deep self-examination of execution."
        ),

        Category.CONCURRENT to listOf(
            "Thread Token" to "A unit representing a schedulable execution context.",
            "Scheduler Unit" to "A coordinated module managing execution order and timing.",
            "Concurrency Engine" to "A powerful engine orchestrating parallel execution safely."
        ),

        Category.STREAM to listOf(
            "Flow Segment" to "A discrete segment of continuous data flow.",
            "Pipeline Module" to "A processing module that transforms flowing data in sequence.",
            "Stream Continuum" to "A stabilized flow capable of sustaining infinite transformation."
        ),

        Category.IO to listOf(
            "Input Buffer" to "A temporary buffer holding incoming external data.",
            "Transfer Module" to "A controlled module managing data exchange across boundaries.",
            "IO Nexus" to "A centralized node coordinating all input and output operations."
        ),

        Category.EXCEPTION to listOf(
            "Throwable Trace" to "A residual trace left by a thrown but unresolved error.",
            "Stack Imprint" to "A layered imprint recording the path of failure.",
            "Failure Core" to "A concentrated core representing a fully realized exception state."
        ),

        Category.SECURITY to listOf(
            "Security Token" to "A token asserting identity and access rights.",
            "Trust Capsule" to "A sealed capsule encapsulating verified permissions.",
            "Authorization Seal" to "An immutable seal enforcing security constraints absolutely."
        ),

        Category.DEBUG to listOf(
            "Debug Marker" to "A marker inserted to observe execution behavior.",
            "Trace Anchor" to "An anchor point preserving diagnostic information over time.",
            "Diagnostic Core" to "A dense core containing complete execution diagnostics."
        ),

        Category.GENERIC to listOf(
            "Type Parameter" to "A flexible placeholder representing an unspecified type.",
            "Generic Mold" to "A reusable mold capable of shaping multiple type instantiations.",
            "Universal Template" to "A perfected template adaptable to nearly any context."
        ),

        Category.MEMORY to listOf(
            "Heap Cell" to "A basic allocation unit within managed memory.",
            "Memory Block" to "A contiguous block capable of holding structured data.",
            "Allocation Core" to "A stabilized core governing memory ownership and lifetime."
        ),

        Category.VOID to listOf(
            "Null Shard" to "A fragment representing the absence of value.",
            "Vacuum Fragment" to "A fragment where data has been completely erased.",
            "Void Singularity" to "A concentrated point of absolute emptiness."
        )
    )

    private val pathMaterial1: Map<EntityPath, List<Pair<String, String>>> = mapOf(

        EntityPath.HEAP to listOf(
            "Heap Fragment" to "A loose fragment broken off from active memory regions.",
            "Heap Reservoir" to "A dense reservoir capable of sustaining large allocations.",
            "Heap Monolith" to "A massive structure embodying raw memory capacity."
        ),

        EntityPath.THREAD to listOf(
            "Thread Fiber" to "A thin execution strand capable of carrying tasks.",
            "Thread Spool" to "A bundled spool managing multiple execution fibers.",
            "Thread Loom" to "A complex loom weaving execution paths together."
        ),

        EntityPath.OVERCLOCK to listOf(
            "Clock Pulse" to "A sharp pulse that accelerates execution cycles.",
            "Frequency Core" to "A stabilized core sustaining elevated execution speed.",
            "Overclock Reactor" to "A powerful reactor pushing execution beyond safe limits."
        ),

        EntityPath.SANDBOX to listOf(
            "Isolation Shard" to "A shard enforcing strict execution boundaries.",
            "Sandbox Capsule" to "A contained environment isolating risky operations.",
            "Containment Sphere" to "A hardened sphere preventing any form of escape."
        ),

        EntityPath.PROTOCOL to listOf(
            "Protocol Token" to "A token representing a single communication rule.",
            "Handshake Module" to "A module coordinating multi-step exchanges.",
            "Protocol Codex" to "A comprehensive codex defining interaction standards."
        ),

        EntityPath.DAEMON to listOf(
            "Daemon Trace" to "A lingering trace of background execution.",
            "Persistent Loop" to "A self-sustaining loop operating without intervention.",
            "Daemon Heart" to "A core driving continuous background processes."
        ),

        EntityPath.KERNEL to listOf(
            "Kernel Segment" to "A fundamental segment of system-level control.",
            "Kernel Layer" to "A layered construct mediating core operations.",
            "Kernel Core" to "The authoritative core governing system behavior."
        ),

        EntityPath.RUNTIME to listOf(
            "Runtime Pulse" to "A pulse indicating active execution state.",
            "Execution Node" to "A node coordinating live execution flow.",
            "Runtime Singularity" to "A convergence point where execution and state unify."
        )
    )

    fun getGeneralMaterial(
        set: Int = 1,
        type: GeneralMaterial,
        tier: Int,
    ): ItemData {
        require(tier in 0..3) {
            "Tier must be between 0 and 3. current: $tier"
        }
        val entry = generalMaterials1[type]!![tier]
        val name = entry.first
        val desc = entry.second
        val key = "mg_" + name.lowercase().replace(" ", "_")
        return ItemData(
            key = key,
            nameRes = SWStrings.create(
                "inventory.$key",
                name,
            ),
            descriptionRes = SWStrings.create(
                "inventory.$key.desc",
                desc,
            ),
            rarity = ItemData.Rarity.entries[tier],
            types = listOf(ItemData.Type.MATERIAL),
            craftRule = generalMaterials1[type]!!.getOrNull(tier + 1)?.let {
                4 to ("mg_" + it.first.lowercase().replace(" ", "_"))
            },
        )
    }

    fun getCategoryMaterial(
        set: Int = 1,
        type: Category,
        tier: Int,
    ): ItemData {
        require(tier in 0..2) {
            "Tier must be between 0 and 2. current: $tier"
        }
        val entry = categoryMaterial1[type]!![tier]
        val name = entry.first
        val desc = entry.second
        val key = "mc_" + name.lowercase().replace(" ", "_")
        return ItemData(
            key = key,
            nameRes = SWStrings.create(
                "inventory.$key",
                name,
            ),
            descriptionRes = SWStrings.create(
                "inventory.$key.desc",
                desc,
            ),
            rarity = ItemData.Rarity.entries[tier + 1],
            types = listOf(ItemData.Type.MATERIAL),
            craftRule = categoryMaterial1[type]!!.getOrNull(tier + 1)?.let {
                4 to ("mc_" + it.first.lowercase().replace(" ", "_"))
            },
        )
    }

    fun getPathMaterial(
        set: Int = 1,
        type: EntityPath,
        tier: Int,
    ): ItemData {
        require(tier in 0..2) {
            "Tier must be between 0 and 2. current: $tier"
        }
        val entry = pathMaterial1[type]!![tier]
        val name = entry.first
        val desc = entry.second
        val key = "mp_" + name.lowercase().replace(" ", "_")
        return ItemData(
            key = key,
            nameRes = SWStrings.create(
                "inventory.$key",
                name,
            ),
            descriptionRes = SWStrings.create(
                "inventory.$key.desc",
                desc,
            ),
            rarity = ItemData.Rarity.entries[tier + 1],
            types = listOf(ItemData.Type.MATERIAL),
            craftRule = pathMaterial1[type]!!.getOrNull(tier + 1)?.let {
                4 to ("mp_" + it.first.lowercase().replace(" ", "_"))
            },
        )
    }

    fun getGeneralMaterialSetByIndex(index: Int): List<GeneralMaterial> {
        require(index in 0..49) {
            "Index must be between 0 and 49. current: $index"
        }
        return when (index) {
            in 0..24 -> {
                listOf(
                    GeneralMaterial.entries[index / 5],
                    GeneralMaterial.entries[(index % 5) + 5],
                )
            }

            in 25..49 -> {
                val i = index - 25
                listOf(
                    GeneralMaterial.entries[(i / 5) * 2],
                    GeneralMaterial.entries[(i % 5) * 2 + 1],
                )
            }

            else -> error("")
        }
    }


}