package com.lifebuddy.smartcopy

import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

/**
 * Utility functions for Smart Copy actions.
 */
object SmartCopyUtils {

    /**
     * Get the relative path of a file from the project root.
     *
     * @param project The current project
     * @param file The virtual file to get path for
     * @return Relative path string, or absolute path if project base is not found
     */
    fun getRelativePath(project: Project, file: VirtualFile): String {
        val basePath = project.basePath ?: return file.path
        val filePath = file.path
        
        return if (filePath.startsWith(basePath)) {
            filePath.removePrefix(basePath).removePrefix("/")
        } else {
            file.name
        }
    }

    /**
     * Get the line range string from editor selection.
     *
     * @param editor The editor with selection
     * @return Line range string (e.g., "37" or "37-42")
     */
    fun getLineRange(editor: Editor): String {
        val selectionModel = editor.selectionModel
        val document = editor.document
        
        val startOffset = selectionModel.selectionStart
        val endOffset = selectionModel.selectionEnd
        
        // Convert to 1-based line numbers
        val startLine = document.getLineNumber(startOffset) + 1
        val endLine = document.getLineNumber(endOffset) + 1
        
        return if (startLine == endLine) {
            "$startLine"
        } else {
            "$startLine-$endLine"
        }
    }

    /**
     * Get the selected text from editor.
     *
     * @param editor The editor with selection
     * @return Selected text string
     */
    fun getSelectedText(editor: Editor): String {
        return editor.selectionModel.selectedText ?: ""
    }

    /**
     * Get the language identifier for Markdown code block based on file extension.
     *
     * @param fileName The file name
     * @return Language identifier string
     */
    fun getLanguageId(fileName: String): String {
        val ext = fileName.substringAfterLast('.', "").lowercase()
        
        return when (ext) {
            "ts", "tsx" -> "typescript"
            "js", "jsx" -> "javascript"
            "py" -> "python"
            "rb" -> "ruby"
            "java" -> "java"
            "kt", "kts" -> "kotlin"
            "go" -> "go"
            "rs" -> "rust"
            "c" -> "c"
            "cpp", "cc", "cxx" -> "cpp"
            "h", "hpp" -> "cpp"
            "cs" -> "csharp"
            "swift" -> "swift"
            "php" -> "php"
            "html", "htm" -> "html"
            "css" -> "css"
            "scss" -> "scss"
            "sass" -> "sass"
            "less" -> "less"
            "json" -> "json"
            "yaml", "yml" -> "yaml"
            "xml" -> "xml"
            "md", "markdown" -> "markdown"
            "sql" -> "sql"
            "sh", "bash", "zsh" -> "bash"
            "ps1" -> "powershell"
            "dockerfile" -> "dockerfile"
            "vue" -> "vue"
            "svelte" -> "svelte"
            else -> ext
        }
    }
}
