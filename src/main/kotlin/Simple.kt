import types.figma

fun main() {
  figma.loadFontAsync(object : FontName {
    override val family: String
      get() = "Inter"
    override val style: String
      get() = "Regular"
  }).then {
    val text = figma.createText()
    text.characters = "Hello, world"
    text.fontSize = 24

    figma.closePlugin("Operation successful ✅")
  }
}

fun greet() = "world"
