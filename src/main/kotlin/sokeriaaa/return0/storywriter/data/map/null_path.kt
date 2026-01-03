package sokeriaaa.return0.storywriter.data.map

import sokeriaaa.return0.shared.data.api.component.condition.not
import sokeriaaa.return0.shared.data.api.component.value.Value
import sokeriaaa.return0.shared.data.models.component.conditions.CommonCondition
import sokeriaaa.return0.shared.data.models.component.conditions.EventCondition
import sokeriaaa.return0.shared.data.models.entity.category.Category
import sokeriaaa.return0.shared.data.models.story.event.Event
import sokeriaaa.return0.shared.data.models.story.event.Event.TeleportUserTo
import sokeriaaa.return0.shared.data.models.story.map.MapData
import sokeriaaa.return0.shared.data.models.story.map.MapEvent
import sokeriaaa.return0.storywriter.data.entities.SWEntities
import sokeriaaa.return0.storywriter.data.entities.SWEntitiesCommon
import sokeriaaa.return0.storywriter.res.SWDialogueNames.`object`
import sokeriaaa.return0.storywriter.utils.dialogueResCounter

@Suppress("UnusedReceiverParameter")
val SWMaps.null_path: MapData
    get() = MapData(
        name = "null_path",
        lines = 6,
        buggyRange = emptyList(),
        buggyEntries = emptyList(),
        difficulty = 1,
        events = listOf(
            nullPathEvent01,
            objectEvent,
            nullptrEvent,
            nullViewEvent,
        )
    )

private val nullPathEvent01: MapEvent = MapEvent(
    enabled = !EventCondition.SavedSwitch("intro_finished"),
    trigger = MapEvent.Trigger.ENTERED,
    event = dialogueResCounter("null_path_event01") {
        Event.Sequence(
            Event.HideMap,
            narrator("As you step onto the null_path, the world reacts."),
            narrator("The ambient noise of the Grid fades. The light dims. Threads above fracture into shadows."),
            narrator("Your system state appears before you — instinctively, like muscle memory."),
            narrator("Nullable... figures."),
            narrator("The ground ahead trembles."),
            Event.ShowMap,
            narrator("Something crawls out of the corrupted terrain."),
            narrator("It is small, but deeply wrong."),
            narrator("A hunched, glitching creature, its body composed of broken pointers and dangling references."),
            narrator("Its limbs snap between positions, occasionally phasing through itself."),
            narrator("Where its face should be is a void that swallows light."),
            npc(`object`, "Nullptr."),
            npc(`object`, "A dereference without a check."),
            npc(`object`, "One of the most primitive manifestations of corruption."),
            narrator("The creature screeches — not a sound, but a runtime exception, echoing directly in your thoughts."),
            Event.ShakeMap,
            narrator("Exception in thread \"main\":\njava.lang.NullPointerException"),
            Event.HideMap,
            narrator("I've seen this before."),
            narrator("Countless times."),
            Event.ShowMap,
            narrator("It lunges."),
            Event.ObtainEntity(SWEntities.`object`.name),
            Event.Combat(
                config = Event.Combat.Config(
                    enemies = listOf(
                        // Nullptr
                        SWEntitiesCommon.getCommonEnemy(Category.VOID, 0).name to Value(1),
                    ),
                    // Let the object level up to 2 after this combat.
                    difficulty = 4F,
                ),
            ),

            Event.SaveSwitch("intro_nullptr_defeated", CommonCondition.True),
            Event.RefreshEvents,
            narrator("Nullptr collapses inward, folding into a single dark point before vanishing."),
            narrator("The ground stabilizes. Silence returns."),
            user("So this is what my fear looks like."),
            npc(`object`, "You did not erase it. You handled it."),
            npc(`object`, "That distinction matters."),
            narrator("The path ahead brightens slightly. The end of the null_path is now clearly visible."),
            narrator("Null_view awaits — a quiet overlook where threads converge neatly, where memory feels... sufficient."),
            narrator("A place to stand."),
            narrator("A place to think."),
            narrator("A place to rebuild."),
            npc(`object`, "This will be your base context."),
            npc(`object`, "From here, your execution truly begins."),
            narrator("As you step forward, one thought lingers in your mind — not fear, but resolve."),
            Event.HideMap,
            narrator("If this world is built on rules..."),
            narrator("then I can learn them."),
            narrator("And if something is broken —"),
            narrator("I can fix it."),
            tips("Object had unlocked a function \"notify\". It can deal more damage than a normal attack.\nAccessible in the \"FUNCTION\" action."),
            tips("Functions are powerful but consumes SP. When the SP runs out, the entities will have to use RELAX to recover SP."),
            Event.ShowMap,
            TeleportUserTo(
                SWMaps.null_view.name,
                Value(1),
            ),
        )
    }
)

private val objectEvent: MapEvent = MapEvent(
    enabled = !EventCondition.SavedSwitch("intro_finished"),
    trigger = MapEvent.Trigger.INTERACTED,
    lineNumber = 2,
    display = "Object()",
    event = Event.Empty,
)

private val nullptrEvent: MapEvent = MapEvent(
    enabled = !EventCondition.SavedSwitch("intro_nullptr_defeated"),
    trigger = MapEvent.Trigger.INTERACTED,
    lineNumber = 3,
    display = "throw NullPointerException()",
    event = Event.Empty,
)

private val nullViewEvent: MapEvent = MapEvent(
    enabled = EventCondition.SavedSwitch("intro_nullptr_defeated"),
    trigger = MapEvent.Trigger.INTERACTED,
    lineNumber = 4,
    display = "moveTo(null_view)",
    event = TeleportUserTo(
        SWMaps.null_view.name,
        Value(1),
    ),
)