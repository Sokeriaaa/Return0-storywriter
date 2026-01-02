package sokeriaaa.return0.storywriter.utils

import sokeriaaa.return0.shared.data.models.story.event.Event
import sokeriaaa.return0.storywriter.res.SWDialogues

/**
 * Automatically generate res key with specified prefix.
 * Useful for generating a sequence of dialogues.
 */
class DialogueResCounter(
    val prefix: String,
) {
    /**
     * Current ID, start from 1.
     * Auto-increased after generating an event in this scope.
     */
    private var current = 0

    /**
     * The res key that is used for the next string resource.
     */
    private val currentRes: String
        get() = "${prefix}_${current.toString().padStart(3, '0')}"

    /**
     * Generate an auto-resourced [Event.Text.Narrator] in this scope.
     *
     * @see SWDialogues.createNarrator
     */
    fun narrator(dialogue: String): Event.Text.Narrator {
        current++
        return SWDialogues.createNarrator(currentRes, dialogue)
    }

    /**
     * Generate an auto-resourced [Event.Text.User] in this scope.
     *
     * @see SWDialogues.createUser
     */
    fun user(dialogue: String): Event.Text.User {
        current++
        return SWDialogues.createUser(currentRes, dialogue)
    }

    /**
     * Generate an auto-resourced [Event.Text.NPC] in this scope.
     *
     * @see SWDialogues.createNPC
     */
    fun npc(nameRes: String, dialogue: String): Event.Text.NPC {
        current++
        return SWDialogues.createNPC(currentRes, nameRes, dialogue)
    }

    /**
     * Generate an auto-resourced [Event.Tips] in this scope.
     *
     * @see SWDialogues.createTips
     */
    fun tips(dialogue: String): Event.Tips {
        current++
        return SWDialogues.createTips(currentRes, dialogue)
    }

    /**
     * Generate an auto-resourced simple string in this scope.
     *
     * @see SWDialogues.createText
     */
    fun text(text: String): String {
        current++
        return SWDialogues.createText(currentRes, text)
    }
}

inline fun <reified T> dialogueResCounter(
    prefix: String,
    scope: DialogueResCounter.() -> T,
): T = scope(DialogueResCounter(prefix))
