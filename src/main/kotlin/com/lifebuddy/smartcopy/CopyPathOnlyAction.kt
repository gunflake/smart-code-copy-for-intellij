package com.lifebuddy.smartcopy

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.ide.CopyPasteManager
import java.awt.datatransfer.StringSelection

/**
 * Action to copy file path and line range only.
 * Output format: src/utils/helper.py:37-42
 */
class CopyPathOnlyAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        val editor = e.getData(CommonDataKeys.EDITOR) ?: return
        val file = e.getData(CommonDataKeys.VIRTUAL_FILE) ?: return

        if (!editor.selectionModel.hasSelection()) {
            return
        }

        val relativePath = SmartCopyUtils.getRelativePath(project, file)
        val lineRange = SmartCopyUtils.getLineRange(editor)

        val output = "$relativePath:$lineRange"

        // Copy to clipboard
        CopyPasteManager.getInstance().setContents(StringSelection(output))
    }

    override fun update(e: AnActionEvent) {
        val editor = e.getData(CommonDataKeys.EDITOR)
        e.presentation.isEnabledAndVisible = editor != null && editor.selectionModel.hasSelection()
    }
}
