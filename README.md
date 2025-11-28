# Smart Copy for CLI (IntelliJ / PyCharm)

A JetBrains IDE plugin that copies your selected code along with its file path and line numbers in a CLI-friendly format. Perfect for referencing code in issues, pull requests, documentation, or chat tools.

Works with: **IntelliJ IDEA**, **PyCharm**, **WebStorm**, **GoLand**, **Rider**, and all other JetBrains IDEs.

---

## Features

This plugin provides **two copy modes**:

| Mode | Mac | Windows/Linux | Description |
|------|-----|---------------|-------------|
| **Copy Path Only** | `Cmd+Shift+C` | `Ctrl+Shift+C` | Copies file path and line range only |
| **Copy Path and Code** | `Cmd+Alt+Shift+C` | `Ctrl+Alt+Shift+C` | Copies file path, line range, and code block |

Both commands are also available via the **right-click context menu** when text is selected.

---

## Usage Examples

### Example 1: Copy Path Only

Select lines 37-42 in `src/utils/helper.py` and press `Cmd+Shift+C` (Mac) or `Ctrl+Shift+C` (Windows):

**Clipboard result:**
```
src/utils/helper.py:37-42
```

### Example 2: Copy Path and Code

Select the same lines and press `Cmd+Alt+Shift+C` (Mac) or `Ctrl+Alt+Shift+C` (Windows):

**Clipboard result:**
````
src/utils/helper.py:37-42
```python
def calculate_total(items):
    total = 0
    for item in items:
        total += item.price
    return total
```
````

### Example 3: Single Line Selection

If you select only line 15 in `src/index.ts`:

**Clipboard result:**
```
src/index.ts:15
```

---

## Installation

### From JetBrains Marketplace

1. Open your JetBrains IDE (PyCharm, IntelliJ, etc.)
2. Go to `Settings` → `Plugins` → `Marketplace`
3. Search for "Smart Copy for CLI"
4. Click `Install`

### From ZIP (Local Install)

1. Build the plugin:
   ```bash
   ./gradlew buildPlugin
   ```

2. Install the generated ZIP file:
   - Open your JetBrains IDE
   - Go to `Settings` → `Plugins`
   - Click `⚙️` → `Install Plugin from Disk...`
   - Select `build/distributions/smart-copy-for-intellij-1.0.0.zip`

### For Development

1. Clone this repository
2. Open in IntelliJ IDEA
3. Run `./gradlew runIde` to launch a sandbox IDE with the plugin installed

---

## Building

```bash
# Build the plugin
./gradlew buildPlugin

# Run in sandbox IDE
./gradlew runIde

# Verify plugin
./gradlew verifyPlugin
```

---

## Supported Languages

The plugin automatically detects the file type and applies the appropriate language tag for Markdown code blocks:

- Python
- Kotlin / Java
- TypeScript / JavaScript
- Go, Rust, Swift
- C, C++, C#
- HTML, CSS, SCSS
- JSON, YAML, XML
- Bash, PowerShell
- And many more...

---

## Why Use This Plugin?

- **Quick code references**: Easily share specific code locations with teammates
- **CLI-friendly format**: Output format works great with grep, git, and other CLI tools
- **Markdown-ready**: Code blocks are properly formatted for GitHub, Notion, Slack, etc.
- **Context preserved**: Always know exactly where the code came from

---

## License

MIT
