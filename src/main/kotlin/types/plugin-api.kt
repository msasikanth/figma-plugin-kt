@file:Suppress(
  "INTERFACE_WITH_SUPERCLASS",
  "OVERRIDING_FINAL_MEMBER",
  "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
  "CONFLICTING_OVERLOADS"
)

import org.khronos.webgl.Uint8Array
import org.w3c.notifications.NotificationOptions
import types.Partial
import types.Pick
import types.`T$0`
import kotlin.js.Json
import kotlin.js.Promise

external interface PluginAPI {
  var apiVersion: String /* "1.0.0" */
  var command: String
  var editorType: String /* "figma" | "figjam" */
  var pluginId: String?
    get() = definedExternally
    set(value) = definedExternally
  var widgetId: String?
    get() = definedExternally
    set(value) = definedExternally
  var fileKey: String?
  var skipInvisibleInstanceChildren: Boolean
  var timer: TimerAPI?
    get() = definedExternally
    set(value) = definedExternally
  var viewport: ViewportAPI
  var currentUser: User?
  var activeUsers: Array<ActiveUser>
  var textreview: TextReviewAPI?
    get() = definedExternally
    set(value) = definedExternally
  var payments: PaymentsAPI?
    get() = definedExternally
    set(value) = definedExternally

  fun closePlugin(message: String = definedExternally)
  fun notify(message: String, options: NotificationOptions = definedExternally): NotificationHandler
  fun commitUndo()
  fun triggerUndo()
  fun saveVersionHistoryAsync(title: String, description: String = definedExternally): Promise<VersionHistoryResult>
  fun showUI(html: String, options: ShowUIOptions = definedExternally)
  var ui: UIAPI
  var clientStorage: ClientStorageAPI
  var parameters: ParametersAPI
  fun getNodeById(id: String): dynamic /* DocumentNode? | PageNode? | SliceNode? | FrameNode? | GroupNode? | ComponentSetNode? | ComponentNode? | InstanceNode? | BooleanOperationNode? | VectorNode? | StarNode? | LineNode? | EllipseNode? | PolygonNode? | RectangleNode? | TextNode? | StickyNode? | ConnectorNode? | ShapeWithTextNode? | CodeBlockNode? | StampNode? | WidgetNode? | EmbedNode? | LinkUnfurlNode? | MediaNode? | SectionNode? | HighlightNode? | WashiTapeNode? | TableNode? */
  fun getStyleById(id: String): BaseStyle?
  var root: DocumentNode
  var currentPage: PageNode
  fun on(
    type: String /* "selectionchange" | "currentpagechange" | "close" | "timerstart" | "timerstop" | "timerpause" | "timerresume" | "timeradjust" | "timerdone" */,
    callback: () -> Unit
  )

  fun on(type: String /* "run" */, callback: (event: RunEvent__0) -> Unit)
  fun on(type: String /* "drop" */, callback: (event: DropEvent) -> Boolean)
  fun on(type: String /* "documentchange" */, callback: (event: DocumentChangeEvent) -> Unit)
  fun on(type: String /* "textreview" */, callback: (event: TextReviewEvent) -> Any)
  fun once(
    type: String /* "selectionchange" | "currentpagechange" | "close" | "timerstart" | "timerstop" | "timerpause" | "timerresume" | "timeradjust" | "timerdone" */,
    callback: () -> Unit
  )

  fun once(type: String /* "run" */, callback: (event: RunEvent__0) -> Unit)
  fun once(type: String /* "drop" */, callback: (event: DropEvent) -> Boolean)
  fun once(type: String /* "documentchange" */, callback: (event: DocumentChangeEvent) -> Unit)
  fun once(type: String /* "textreview" */, callback: (event: TextReviewEvent) -> Any)
  fun off(
    type: String /* "selectionchange" | "currentpagechange" | "close" | "timerstart" | "timerstop" | "timerpause" | "timerresume" | "timeradjust" | "timerdone" */,
    callback: () -> Unit
  )

  fun off(type: String /* "run" */, callback: (event: RunEvent__0) -> Unit)
  fun off(type: String /* "drop" */, callback: (event: DropEvent) -> Boolean)
  fun off(type: String /* "documentchange" */, callback: (event: DocumentChangeEvent) -> Unit)
  fun off(type: String /* "textreview" */, callback: (event: TextReviewEvent) -> Any)
  var mixed: Any
  fun createRectangle(): RectangleNode
  fun createLine(): LineNode
  fun createEllipse(): EllipseNode
  fun createPolygon(): PolygonNode
  fun createStar(): StarNode
  fun createVector(): VectorNode
  fun createText(): TextNode
  fun createFrame(): FrameNode
  fun createComponent(): ComponentNode
  fun createPage(): PageNode
  fun createSlice(): SliceNode
  fun createSticky(): StickyNode
  fun createConnector(): ConnectorNode
  fun createShapeWithText(): ShapeWithTextNode
  fun createCodeBlock(): CodeBlockNode
  fun createSection(): SectionNode
  fun createTable(numRows: Number = definedExternally, numColumns: Number = definedExternally): TableNode
  fun createNodeFromJSXAsync(jsx: Any): Promise<dynamic /* SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */>
  fun createBooleanOperation(): BooleanOperationNode
  fun createPaintStyle(): PaintStyle
  fun createTextStyle(): TextStyle
  fun createEffectStyle(): EffectStyle
  fun createGridStyle(): GridStyle
  fun getLocalPaintStyles(): Array<PaintStyle>
  fun getLocalTextStyles(): Array<TextStyle>
  fun getLocalEffectStyles(): Array<EffectStyle>
  fun getLocalGridStyles(): Array<GridStyle>
  fun moveLocalPaintStyleAfter(targetNode: PaintStyle, reference: PaintStyle?)
  fun moveLocalTextStyleAfter(targetNode: TextStyle, reference: TextStyle?)
  fun moveLocalEffectStyleAfter(targetNode: EffectStyle, reference: EffectStyle?)
  fun moveLocalGridStyleAfter(targetNode: GridStyle, reference: GridStyle?)
  fun moveLocalPaintFolderAfter(targetFolder: String, reference: String?)
  fun moveLocalTextFolderAfter(targetFolder: String, reference: String?)
  fun moveLocalEffectFolderAfter(targetFolder: String, reference: String?)
  fun moveLocalGridFolderAfter(targetFolder: String, reference: String?)
  fun importComponentByKeyAsync(key: String): Promise<ComponentNode>
  fun importComponentSetByKeyAsync(key: String): Promise<ComponentSetNode>
  fun importStyleByKeyAsync(key: String): Promise<BaseStyle>
  fun listAvailableFontsAsync(): Promise<Array<Font>>
  fun loadFontAsync(fontName: FontName): Promise<Unit>
  var hasMissingFont: Boolean
  fun createNodeFromSvg(svg: String): FrameNode
  fun createImage(data: Uint8Array): Image
  fun createImageAsync(src: String): Promise<Image>
  fun getImageByHash(hash: String): Image?
  fun createVideoAsync(data: Uint8Array): Promise<Video>
  fun createLinkPreviewAsync(url: String): Promise<dynamic /* EmbedNode | LinkUnfurlNode */>
  fun createGif(hash: String): MediaNode
  fun combineAsVariants(
    nodes: Array<ComponentNode>,
    parent: Any /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */,
    index: Number = definedExternally
  ): ComponentSetNode

  fun group(
    nodes: Array<Any /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */>,
    parent: Any /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */,
    index: Number = definedExternally
  ): GroupNode

  fun flatten(
    nodes: Array<Any /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */>,
    parent: Any /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */ = definedExternally,
    index: Number = definedExternally
  ): VectorNode

  fun union(
    nodes: Array<Any /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */>,
    parent: Any /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */,
    index: Number = definedExternally
  ): BooleanOperationNode

  fun subtract(
    nodes: Array<Any /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */>,
    parent: Any /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */,
    index: Number = definedExternally
  ): BooleanOperationNode

  fun intersect(
    nodes: Array<Any /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */>,
    parent: Any /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */,
    index: Number = definedExternally
  ): BooleanOperationNode

  fun exclude(
    nodes: Array<Any /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */>,
    parent: Any /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */,
    index: Number = definedExternally
  ): BooleanOperationNode

  fun ungroup(node: Any /* SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */): Array<dynamic /* SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */>
  fun base64Encode(data: Uint8Array): String
  fun base64Decode(data: String): Uint8Array
  fun getFileThumbnailNode(): dynamic /* FrameNode? | ComponentNode? | ComponentSetNode? */
  fun setFileThumbnailNodeAsync(node: FrameNode?): Promise<Unit>
  fun setFileThumbnailNodeAsync(node: ComponentNode?): Promise<Unit>
  fun setFileThumbnailNodeAsync(node: ComponentSetNode?): Promise<Unit>
}

external interface VersionHistoryResult {
  var id: String
}

external interface PaymentStatus {
  var type: String /* "UNPAID" | "PAID" | "NOT_SUPPORTED" */
}

external interface `T$1` {
  var interstitial: String? /* "PAID_FEATURE" | "TRIAL_ENDED" | "SKIP" */
    get() = definedExternally
    set(value) = definedExternally
}

external interface PaymentsAPI {
  var status: PaymentStatus
  fun setPaymentStatusInDevelopment(status: PaymentStatus)
  fun getUserFirstRanSecondsAgo(): Number
  fun initiateCheckoutAsync(options: `T$1` = definedExternally): Promise<Unit>
  fun requestCheckout()
}

external interface ClientStorageAPI {
  fun getAsync(key: String): Promise<Any?>
  fun setAsync(key: String, value: Any): Promise<Unit>
  fun deleteAsync(key: String): Promise<Unit>
  fun keysAsync(): Promise<Array<String>>
}

external interface NotificationHandler {
  var cancel: () -> Unit
}

external interface `T$2` {
  var x: Number
  var y: Number
}

external interface ShowUIOptions {
  var visible: Boolean?
    get() = definedExternally
    set(value) = definedExternally
  var title: String?
    get() = definedExternally
    set(value) = definedExternally
  var width: Number?
    get() = definedExternally
    set(value) = definedExternally
  var height: Number?
    get() = definedExternally
    set(value) = definedExternally
  var position: `T$2`?
    get() = definedExternally
    set(value) = definedExternally
  var themeColors: Boolean?
    get() = definedExternally
    set(value) = definedExternally
}

external interface UIPostMessageOptions {
  var origin: String?
    get() = definedExternally
    set(value) = definedExternally
}

external interface OnMessageProperties {
  var origin: String
}

typealias MessageEventHandler = (pluginMessage: Any, props: OnMessageProperties) -> Unit

external interface UIAPI {
  fun show()
  fun hide()
  fun resize(width: Number, height: Number)
  fun reposition(x: Number, y: Number)
  fun close()
  fun postMessage(pluginMessage: Any, options: UIPostMessageOptions = definedExternally)
  var onmessage: MessageEventHandler?
  fun on(type: String /* "message" */, callback: MessageEventHandler)
  fun once(type: String /* "message" */, callback: MessageEventHandler)
  fun off(type: String /* "message" */, callback: MessageEventHandler)
}

external interface TimerAPI {
  var remaining: Number
  var total: Number
  var state: String /* "STOPPED" | "PAUSED" | "RUNNING" */
  var pause: () -> Unit
  var resume: () -> Unit
  var start: (seconds: Number) -> Unit
  var stop: () -> Unit
}

external interface ViewportAPI {
  var center: Vector
  var zoom: Number
  fun scrollAndZoomIntoView(nodes: Array<Any /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */>)
  var bounds: Rect
}

external interface TextReviewAPI {
  fun requestToBeEnabledAsync(): Promise<Unit>
  fun requestToBeDisabledAsync(): Promise<Unit>
  var isEnabled: Boolean
}

external interface ParameterValues {
  @nativeGetter
  operator fun get(key: String): Any?

  @nativeSetter
  operator fun set(key: String, value: Any)
}

external interface SuggestionResults {
  fun setSuggestions(suggestions: Array<Any /* String | `T$3` */>)
  fun setError(message: String)
  fun setLoadingMessage(message: String)
}

external interface ParameterInputEvent<ParametersType> {
  var query: String
  var key: String
  var parameters: Partial<ParametersType>
  var result: SuggestionResults
}

external interface ParameterInputEvent__0 : ParameterInputEvent<ParameterValues>

external interface ParametersAPI {
  fun on(type: String /* "input" */, callback: (event: ParameterInputEvent__0) -> Unit)
  fun once(type: String /* "input" */, callback: (event: ParameterInputEvent__0) -> Unit)
  fun off(type: String /* "input" */, callback: (event: ParameterInputEvent__0) -> Unit)
}

external interface RunEvent<ParametersType> {
  var command: String
  var parameters: ParametersType
}

external interface RunEvent__0 : RunEvent<ParameterValues?>

external interface DropEvent {
  var node: dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */
    get() = definedExternally
    set(value) = definedExternally
  var x: Number
  var y: Number
  var absoluteX: Number
  var absoluteY: Number
  var items: Array<DropItem>
  var files: Array<DropFile>
  var dropMetadata: Any?
    get() = definedExternally
    set(value) = definedExternally
}

external interface DropItem {
  var type: String
  var data: String
}

external interface DropFile {
  var name: String
  var type: String
  fun getBytesAsync(): Promise<Uint8Array>
  fun getTextAsync(): Promise<String>
}

external interface DocumentChangeEvent {
  var documentChanges: Array<dynamic /* CreateChange | DeleteChange | PropertyChange | StyleCreateChange | StyleDeleteChange | StylePropertyChange */>
}

external interface BaseDocumentChange {
  var id: String
  var origin: String /* "LOCAL" | "REMOTE" */
}

external interface BaseNodeChange : BaseDocumentChange {
  var node: dynamic /* SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode | RemovedNode */
    get() = definedExternally
    set(value) = definedExternally
}

external interface RemovedNode {
  var removed: Boolean
  var type: Any
  var id: String
}

external interface CreateChange : BaseNodeChange {
  var type: String /* "CREATE" */
}

external interface DeleteChange : BaseNodeChange {
  var type: String /* "DELETE" */
}

external interface PropertyChange : BaseNodeChange {
  var type: String /* "PROPERTY_CHANGE" */
  var properties: Array<String /* "pointCount" | "name" | "width" | "height" | "parent" | "pluginData" | "constraints" | "locked" | "visible" | "opacity" | "blendMode" | "layoutGrids" | "guides" | "characters" | "styledTextSegments" | "vectorNetwork" | "effects" | "exportSettings" | "arcData" | "autoRename" | "fontName" | "innerRadius" | "fontSize" | "lineHeight" | "paragraphIndent" | "paragraphSpacing" | "letterSpacing" | "textAlignHorizontal" | "textAlignVertical" | "textCase" | "textDecoration" | "textAutoResize" | "fills" | "topLeftRadius" | "topRightRadius" | "bottomLeftRadius" | "bottomRightRadius" | "constrainProportions" | "strokes" | "strokeWeight" | "strokeAlign" | "strokeCap" | "strokeJoin" | "strokeMiterLimit" | "booleanOperation" | "overflowDirection" | "dashPattern" | "backgrounds" | "handleMirroring" | "cornerRadius" | "cornerSmoothing" | "relativeTransform" | "x" | "y" | "rotation" | "isMask" | "clipsContent" | "type" | "overlayPositionType" | "overlayBackgroundInteraction" | "overlayBackground" | "prototypeStartNode" | "prototypeBackgrounds" | "expanded" | "fillStyleId" | "strokeStyleId" | "backgroundStyleId" | "textStyleId" | "effectStyleId" | "gridStyleId" | "description" | "layoutMode" | "paddingLeft" | "paddingTop" | "paddingRight" | "paddingBottom" | "itemSpacing" | "layoutAlign" | "counterAxisSizingMode" | "primaryAxisSizingMode" | "primaryAxisAlignItems" | "counterAxisAlignItems" | "layoutGrow" | "layoutPositioning" | "itemReverseZIndex" | "hyperlink" | "mediaData" | "stokeTopWeight" | "strokeBottomWeight" | "strokeLeftWeight" | "strokeRightWeight" | "reactions" | "flowStartingPoints" | "shapeType" | "connectorStart" | "connectorEnd" | "connectorLineType" | "connectorStartStrokeCap" | "connectorEndStrokeCap" | "codeLanguage" | "widgetSyncedState" | "componentPropertyDefinitions" | "componentPropertyReferences" | "componentProperties" | "embedData" | "linkUnfurlData" | "text" | "authorVisible" | "authorName" | "code" | "textBackground" */>
}

external interface BaseStyleChange : BaseDocumentChange {
  var style: dynamic /* PaintStyle? | TextStyle? | GridStyle? | EffectStyle? */
    get() = definedExternally
    set(value) = definedExternally
}

external interface StyleCreateChange : BaseStyleChange {
  var type: String /* "STYLE_CREATE" */
}

external interface StyleDeleteChange : BaseStyleChange {
  var type: String /* "STYLE_DELETE" */
  override var style: Any?
}

external interface StylePropertyChange : BaseStyleChange {
  var type: String /* "STYLE_PROPERTY_CHANGE" */
  var properties: Array<String /* "name" | "pluginData" | "type" | "description" | "remote" | "documentationLinks" | "fontSize" | "textDecoration" | "letterSpacing" | "lineHeight" | "paragraphIndent" | "paragraphSpacing" | "textCase" | "paint" | "effects" | "layoutGrids" */>
}

external interface TextReviewEvent {
  var text: String
}

external interface TextReviewRange {
  var start: Number
  var end: Number
  var suggestions: Array<String>
  var color: String? /* "RED" | "GREEN" | "BLUE" */
    get() = definedExternally
    set(value) = definedExternally
}

external interface Vector {
  var x: Number
  var y: Number
}

external interface Rect {
  var x: Number
  var y: Number
  var width: Number
  var height: Number
}

external interface RGB {
  var r: Number
  var g: Number
  var b: Number
}

external interface RGBA {
  var r: Number
  var g: Number
  var b: Number
  var a: Number
}

external interface FontName {
  val family: String
  val style: String
}

external interface ArcData {
  var startingAngle: Number
  var endingAngle: Number
  var innerRadius: Number
}

external interface DropShadowEffect {
  var type: String /* "DROP_SHADOW" */
  var color: RGBA
  var offset: Vector
  var radius: Number
  var spread: Number?
    get() = definedExternally
    set(value) = definedExternally
  var visible: Boolean
  var blendMode: String /* "PASS_THROUGH" | "NORMAL" | "DARKEN" | "MULTIPLY" | "LINEAR_BURN" | "COLOR_BURN" | "LIGHTEN" | "SCREEN" | "LINEAR_DODGE" | "COLOR_DODGE" | "OVERLAY" | "SOFT_LIGHT" | "HARD_LIGHT" | "DIFFERENCE" | "EXCLUSION" | "HUE" | "SATURATION" | "COLOR" | "LUMINOSITY" */
  var showShadowBehindNode: Boolean?
    get() = definedExternally
    set(value) = definedExternally
}

external interface InnerShadowEffect {
  var type: String /* "INNER_SHADOW" */
  var color: RGBA
  var offset: Vector
  var radius: Number
  var spread: Number?
    get() = definedExternally
    set(value) = definedExternally
  var visible: Boolean
  var blendMode: String /* "PASS_THROUGH" | "NORMAL" | "DARKEN" | "MULTIPLY" | "LINEAR_BURN" | "COLOR_BURN" | "LIGHTEN" | "SCREEN" | "LINEAR_DODGE" | "COLOR_DODGE" | "OVERLAY" | "SOFT_LIGHT" | "HARD_LIGHT" | "DIFFERENCE" | "EXCLUSION" | "HUE" | "SATURATION" | "COLOR" | "LUMINOSITY" */
}

external interface BlurEffect {
  var type: String /* "LAYER_BLUR" | "BACKGROUND_BLUR" */
  var radius: Number
  var visible: Boolean
}

external interface Constraints {
  var horizontal: String /* "MIN" | "CENTER" | "MAX" | "STRETCH" | "SCALE" */
  var vertical: String /* "MIN" | "CENTER" | "MAX" | "STRETCH" | "SCALE" */
}

external interface ColorStop {
  var position: Number
  var color: RGBA
}

external interface ImageFilters {
  var exposure: Number?
    get() = definedExternally
    set(value) = definedExternally
  var contrast: Number?
    get() = definedExternally
    set(value) = definedExternally
  var saturation: Number?
    get() = definedExternally
    set(value) = definedExternally
  var temperature: Number?
    get() = definedExternally
    set(value) = definedExternally
  var tint: Number?
    get() = definedExternally
    set(value) = definedExternally
  var highlights: Number?
    get() = definedExternally
    set(value) = definedExternally
  var shadows: Number?
    get() = definedExternally
    set(value) = definedExternally
}

external interface SolidPaint {
  var type: String /* "SOLID" */
  var color: RGB
  var visible: Boolean?
    get() = definedExternally
    set(value) = definedExternally
  var opacity: Number?
    get() = definedExternally
    set(value) = definedExternally
  var blendMode: String? /* "PASS_THROUGH" | "NORMAL" | "DARKEN" | "MULTIPLY" | "LINEAR_BURN" | "COLOR_BURN" | "LIGHTEN" | "SCREEN" | "LINEAR_DODGE" | "COLOR_DODGE" | "OVERLAY" | "SOFT_LIGHT" | "HARD_LIGHT" | "DIFFERENCE" | "EXCLUSION" | "HUE" | "SATURATION" | "COLOR" | "LUMINOSITY" */
    get() = definedExternally
    set(value) = definedExternally
}

external interface GradientPaint {
  var type: String /* "GRADIENT_LINEAR" | "GRADIENT_RADIAL" | "GRADIENT_ANGULAR" | "GRADIENT_DIAMOND" */
  var gradientTransform: dynamic /* JsTuple<dynamic, dynamic> */
    get() = definedExternally
    set(value) = definedExternally
  var gradientStops: Array<ColorStop>
  var visible: Boolean?
    get() = definedExternally
    set(value) = definedExternally
  var opacity: Number?
    get() = definedExternally
    set(value) = definedExternally
  var blendMode: String? /* "PASS_THROUGH" | "NORMAL" | "DARKEN" | "MULTIPLY" | "LINEAR_BURN" | "COLOR_BURN" | "LIGHTEN" | "SCREEN" | "LINEAR_DODGE" | "COLOR_DODGE" | "OVERLAY" | "SOFT_LIGHT" | "HARD_LIGHT" | "DIFFERENCE" | "EXCLUSION" | "HUE" | "SATURATION" | "COLOR" | "LUMINOSITY" */
    get() = definedExternally
    set(value) = definedExternally
}

external interface ImagePaint {
  var type: String /* "IMAGE" */
  var scaleMode: String /* "FILL" | "FIT" | "CROP" | "TILE" */
  var imageHash: String?
  var imageTransform: dynamic /* JsTuple<dynamic, dynamic> */
    get() = definedExternally
    set(value) = definedExternally
  var scalingFactor: Number?
    get() = definedExternally
    set(value) = definedExternally
  var rotation: Number?
    get() = definedExternally
    set(value) = definedExternally
  var filters: ImageFilters?
    get() = definedExternally
    set(value) = definedExternally
  var visible: Boolean?
    get() = definedExternally
    set(value) = definedExternally
  var opacity: Number?
    get() = definedExternally
    set(value) = definedExternally
  var blendMode: String? /* "PASS_THROUGH" | "NORMAL" | "DARKEN" | "MULTIPLY" | "LINEAR_BURN" | "COLOR_BURN" | "LIGHTEN" | "SCREEN" | "LINEAR_DODGE" | "COLOR_DODGE" | "OVERLAY" | "SOFT_LIGHT" | "HARD_LIGHT" | "DIFFERENCE" | "EXCLUSION" | "HUE" | "SATURATION" | "COLOR" | "LUMINOSITY" */
    get() = definedExternally
    set(value) = definedExternally
}

external interface VideoPaint {
  var type: String /* "VIDEO" */
  var scaleMode: String /* "FILL" | "FIT" | "CROP" | "TILE" */
  var videoHash: String?
  var videoTransform: dynamic /* JsTuple<dynamic, dynamic> */
    get() = definedExternally
    set(value) = definedExternally
  var scalingFactor: Number?
    get() = definedExternally
    set(value) = definedExternally
  var rotation: Number?
    get() = definedExternally
    set(value) = definedExternally
  var filters: ImageFilters?
    get() = definedExternally
    set(value) = definedExternally
  var visible: Boolean?
    get() = definedExternally
    set(value) = definedExternally
  var opacity: Number?
    get() = definedExternally
    set(value) = definedExternally
  var blendMode: String? /* "PASS_THROUGH" | "NORMAL" | "DARKEN" | "MULTIPLY" | "LINEAR_BURN" | "COLOR_BURN" | "LIGHTEN" | "SCREEN" | "LINEAR_DODGE" | "COLOR_DODGE" | "OVERLAY" | "SOFT_LIGHT" | "HARD_LIGHT" | "DIFFERENCE" | "EXCLUSION" | "HUE" | "SATURATION" | "COLOR" | "LUMINOSITY" */
    get() = definedExternally
    set(value) = definedExternally
}

external interface Guide {
  var axis: String /* "X" | "Y" */
  var offset: Number
}

external interface RowsColsLayoutGrid {
  var pattern: String /* "ROWS" | "COLUMNS" */
  var alignment: String /* "MIN" | "MAX" | "STRETCH" | "CENTER" */
  var gutterSize: Number
  var count: Number
  var sectionSize: Number?
    get() = definedExternally
    set(value) = definedExternally
  var offset: Number?
    get() = definedExternally
    set(value) = definedExternally
  var visible: Boolean?
    get() = definedExternally
    set(value) = definedExternally
  var color: RGBA?
    get() = definedExternally
    set(value) = definedExternally
}

external interface GridLayoutGrid {
  var pattern: String /* "GRID" */
  var sectionSize: Number
  var visible: Boolean?
    get() = definedExternally
    set(value) = definedExternally
  var color: RGBA?
    get() = definedExternally
    set(value) = definedExternally
}

external interface ExportSettingsConstraints {
  var type: String /* "SCALE" | "WIDTH" | "HEIGHT" */
  var value: Number
}

external interface ExportSettingsImage {
  var format: String /* "JPG" | "PNG" */
  var contentsOnly: Boolean?
    get() = definedExternally
    set(value) = definedExternally
  var useAbsoluteBounds: Boolean?
    get() = definedExternally
    set(value) = definedExternally
  var suffix: String?
    get() = definedExternally
    set(value) = definedExternally
  var constraint: ExportSettingsConstraints?
    get() = definedExternally
    set(value) = definedExternally
}

external interface ExportSettingsSVG {
  var format: String /* "SVG" */
  var contentsOnly: Boolean?
    get() = definedExternally
    set(value) = definedExternally
  var useAbsoluteBounds: Boolean?
    get() = definedExternally
    set(value) = definedExternally
  var suffix: String?
    get() = definedExternally
    set(value) = definedExternally
  var svgOutlineText: Boolean?
    get() = definedExternally
    set(value) = definedExternally
  var svgIdAttribute: Boolean?
    get() = definedExternally
    set(value) = definedExternally
  var svgSimplifyStroke: Boolean?
    get() = definedExternally
    set(value) = definedExternally
}

external interface ExportSettingsPDF {
  var format: String /* "PDF" */
  var contentsOnly: Boolean?
    get() = definedExternally
    set(value) = definedExternally
  var useAbsoluteBounds: Boolean?
    get() = definedExternally
    set(value) = definedExternally
  var suffix: String?
    get() = definedExternally
    set(value) = definedExternally
}

external interface VectorVertex {
  var x: Number
  var y: Number
  var strokeCap: String? /* "NONE" | "ROUND" | "SQUARE" | "ARROW_LINES" | "ARROW_EQUILATERAL" */
    get() = definedExternally
    set(value) = definedExternally
  var strokeJoin: String? /* "MITER" | "BEVEL" | "ROUND" */
    get() = definedExternally
    set(value) = definedExternally
  var cornerRadius: Number?
    get() = definedExternally
    set(value) = definedExternally
  var handleMirroring: String? /* "NONE" | "ANGLE" | "ANGLE_AND_LENGTH" */
    get() = definedExternally
    set(value) = definedExternally
}

external interface VectorSegment {
  var start: Number
  var end: Number
  var tangentStart: Vector?
    get() = definedExternally
    set(value) = definedExternally
  var tangentEnd: Vector?
    get() = definedExternally
    set(value) = definedExternally
}

external interface VectorRegion {
  var windingRule: String /* "NONZERO" | "EVENODD" */
  var loops: Array<Array<Number>>
  var fills: Array<dynamic /* SolidPaint | GradientPaint | ImagePaint | VideoPaint */>?
    get() = definedExternally
    set(value) = definedExternally
  var fillStyleId: String?
    get() = definedExternally
    set(value) = definedExternally
}

external interface VectorNetwork {
  var vertices: Array<VectorVertex>
  var segments: Array<VectorSegment>
  var regions: Array<VectorRegion>?
    get() = definedExternally
    set(value) = definedExternally
}

external interface VectorPath {
  var windingRule: String /* "NONZERO" | "EVENODD" | "NONE" */
  var data: String
}

typealias VectorPaths = Array<VectorPath>

external interface LetterSpacing {
  var value: Number
  var unit: String /* "PIXELS" | "PERCENT" */
}

external interface `T$17` {
  var value: Number
  var unit: String /* "PIXELS" | "PERCENT" */
}

external interface `T$18` {
  var unit: String /* "AUTO" */
}

external interface HyperlinkTarget {
  var type: String /* "URL" | "NODE" */
  var value: String
}

external interface TextListOptions {
  var type: String /* "ORDERED" | "UNORDERED" | "NONE" */
}

external interface Font {
  var fontName: FontName
}

external interface StyledTextSegment {
  var characters: String
  var start: Number
  var end: Number
  var fontSize: Number
  var fontName: FontName
  var fontWeight: Number
  var textDecoration: String /* "NONE" | "UNDERLINE" | "STRIKETHROUGH" */
  var textCase: String /* "ORIGINAL" | "UPPER" | "LOWER" | "TITLE" | "SMALL_CAPS" | "SMALL_CAPS_FORCED" */
  var lineHeight: dynamic /* `T$17` | `T$18` */
    get() = definedExternally
    set(value) = definedExternally
  var letterSpacing: LetterSpacing
  var fills: Array<dynamic /* SolidPaint | GradientPaint | ImagePaint | VideoPaint */>
  var textStyleId: String
  var fillStyleId: String
  var listOptions: TextListOptions
  var indentation: Number
  var hyperlink: HyperlinkTarget?
}

external interface Reaction {
  var action: dynamic /* `T$19`? | `T$20`? | `T$21`? | `T$22`? | `T$23`? | `T$24`? */
    get() = definedExternally
    set(value) = definedExternally
  var trigger: dynamic /* `T$25`? | `T$26`? | `T$27`? | `T$28`? | `T$29`? | `T$30`? */
    get() = definedExternally
    set(value) = definedExternally
}

external interface SimpleTransition {
  var type: String /* "DISSOLVE" | "SMART_ANIMATE" | "SCROLL_ANIMATE" */
  var easing: Easing
  var duration: Number
}

external interface DirectionalTransition {
  var type: String /* "MOVE_IN" | "MOVE_OUT" | "PUSH" | "SLIDE_IN" | "SLIDE_OUT" */
  var direction: String /* "LEFT" | "RIGHT" | "TOP" | "BOTTOM" */
  var matchLayers: Boolean
  var easing: Easing
  var duration: Number
}

external interface Easing {
  var type: String /* "EASE_IN" | "EASE_OUT" | "EASE_IN_AND_OUT" | "LINEAR" | "EASE_IN_BACK" | "EASE_OUT_BACK" | "EASE_IN_AND_OUT_BACK" | "CUSTOM_CUBIC_BEZIER" */
  var easingFunctionCubicBezier: EasingFunctionBezier?
    get() = definedExternally
    set(value) = definedExternally
}

external interface EasingFunctionBezier {
  var x1: Number
  var y1: Number
  var x2: Number
  var y2: Number
}

external interface ConnectorEndpointPosition {
  var position: `T$2`
}

external interface ConnectorEndpointPositionAndEndpointNodeId {
  var position: `T$2`
  var endpointNodeId: String
}

external interface ConnectorEndpointEndpointNodeIdAndMagnet {
  var endpointNodeId: String
  var magnet: String /* "NONE" | "AUTO" | "TOP" | "LEFT" | "BOTTOM" | "RIGHT" */
}

external interface BaseNodeMixin : PluginDataMixin {
  var id: String
  var parent: dynamic /* DocumentNode | PageNode | SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */
    get() = definedExternally
    set(value) = definedExternally
  var name: String
  var removed: Boolean
  override fun toString(): String
  fun remove()
  fun setRelaunchData(data: `T$0`)
  fun getRelaunchData(): `T$0`
}

external interface PluginDataMixin {
  fun getPluginData(key: String): String
  fun setPluginData(key: String, value: String)
  fun getPluginDataKeys(): Array<String>
  fun getSharedPluginData(namespace: String, key: String): String
  fun setSharedPluginData(namespace: String, key: String, value: String)
  fun getSharedPluginDataKeys(namespace: String): Array<String>
}

external interface SceneNodeMixin {
  var visible: Boolean
  var locked: Boolean
  var stuckNodes: Array<dynamic /* SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */>
  var attachedConnectors: Array<ConnectorNode>
  var componentPropertyReferences: Any?
}

external interface StickableMixin {
  var stuckTo: dynamic /* SliceNode? | FrameNode? | GroupNode? | ComponentSetNode? | ComponentNode? | InstanceNode? | BooleanOperationNode? | VectorNode? | StarNode? | LineNode? | EllipseNode? | PolygonNode? | RectangleNode? | TextNode? | StickyNode? | ConnectorNode? | ShapeWithTextNode? | CodeBlockNode? | StampNode? | WidgetNode? | EmbedNode? | LinkUnfurlNode? | MediaNode? | SectionNode? | HighlightNode? | WashiTapeNode? | TableNode? */
    get() = definedExternally
    set(value) = definedExternally
}

external interface `T$4`<T> {
  var types: T
}

external interface `T$5` {
  var type: Any
}

external interface ChildrenMixin {
  var children: Array<dynamic /* SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */>
  fun appendChild(child: Any /* SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */)
  fun insertChild(
    index: Number,
    child: Any /* SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */
  )

  fun findChildren(callback: (node: Any /* SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */) -> Boolean = definedExternally): Array<dynamic /* SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */>
  fun findChild(callback: (node: Any /* SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */) -> Boolean): dynamic /* SliceNode? | FrameNode? | GroupNode? | ComponentSetNode? | ComponentNode? | InstanceNode? | BooleanOperationNode? | VectorNode? | StarNode? | LineNode? | EllipseNode? | PolygonNode? | RectangleNode? | TextNode? | StickyNode? | ConnectorNode? | ShapeWithTextNode? | CodeBlockNode? | StampNode? | WidgetNode? | EmbedNode? | LinkUnfurlNode? | MediaNode? | SectionNode? | HighlightNode? | WashiTapeNode? | TableNode? */
  fun findAll(callback: (node: Any /* SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */) -> Boolean = definedExternally): Array<dynamic /* SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */>
  fun findOne(callback: (node: Any /* SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */) -> Boolean): dynamic /* SliceNode? | FrameNode? | GroupNode? | ComponentSetNode? | ComponentNode? | InstanceNode? | BooleanOperationNode? | VectorNode? | StarNode? | LineNode? | EllipseNode? | PolygonNode? | RectangleNode? | TextNode? | StickyNode? | ConnectorNode? | ShapeWithTextNode? | CodeBlockNode? | StampNode? | WidgetNode? | EmbedNode? | LinkUnfurlNode? | MediaNode? | SectionNode? | HighlightNode? | WashiTapeNode? | TableNode? */
  fun <T : Array<Any>> findAllWithCriteria(criteria: `T$4`<T>): Array<`T$5` /* `T$5` & dynamic */>
  fun findWidgetNodesByWidgetId(widgetId: String): Array<WidgetNode>
}

external interface ConstraintMixin {
  var constraints: Constraints
}

external interface DimensionAndPositionMixin {
  var x: Number
  var y: Number
  var width: Number
  var height: Number
  var relativeTransform: dynamic /* JsTuple<dynamic, dynamic> */
    get() = definedExternally
    set(value) = definedExternally
  var absoluteTransform: dynamic /* JsTuple<dynamic, dynamic> */
    get() = definedExternally
    set(value) = definedExternally
  var absoluteBoundingBox: Rect?
}

external interface LayoutMixin : DimensionAndPositionMixin {
  var absoluteRenderBounds: Rect?
  var constrainProportions: Boolean
  var rotation: Number
  var layoutAlign: String /* "MIN" | "CENTER" | "MAX" | "STRETCH" | "INHERIT" */
  var layoutGrow: Number
  var layoutPositioning: String /* "AUTO" | "ABSOLUTE" */
  fun resize(width: Number, height: Number)
  fun resizeWithoutConstraints(width: Number, height: Number)
  fun rescale(scale: Number)
}

external interface BlendMixin : MinimalBlendMixin {
  var isMask: Boolean
  var effects: Array<dynamic /* DropShadowEffect | InnerShadowEffect | BlurEffect */>
  var effectStyleId: String
}

external interface ContainerMixin {
  var expanded: Boolean
}

external interface DeprecatedBackgroundMixin {
  var backgrounds: Array<dynamic /* SolidPaint | GradientPaint | ImagePaint | VideoPaint */>
  var backgroundStyleId: String
}

external interface MinimalStrokesMixin {
  var strokes: Array<dynamic /* SolidPaint | GradientPaint | ImagePaint | VideoPaint */>
  var strokeStyleId: String
  var strokeWeight: dynamic /* Number | Any */
    get() = definedExternally
    set(value) = definedExternally
  var strokeJoin: dynamic /* "MITER" | "BEVEL" | "ROUND" | Any */
    get() = definedExternally
    set(value) = definedExternally
  var strokeAlign: String /* "CENTER" | "INSIDE" | "OUTSIDE" */
  var dashPattern: Array<Number>
  var strokeGeometry: VectorPaths
}

external interface IndividualStrokesMixin {
  var strokeTopWeight: Number
  var strokeBottomWeight: Number
  var strokeLeftWeight: Number
  var strokeRightWeight: Number
}

external interface MinimalFillsMixin {
  var fills: dynamic /* ReadonlyArray<dynamic /* SolidPaint | GradientPaint | ImagePaint | VideoPaint */> | Any */
    get() = definedExternally
    set(value) = definedExternally
  var fillStyleId: dynamic /* String | Any */
    get() = definedExternally
    set(value) = definedExternally
}

external interface GeometryMixin : MinimalStrokesMixin, MinimalFillsMixin {
  var strokeCap: dynamic /* "NONE" | "ROUND" | "SQUARE" | "ARROW_LINES" | "ARROW_EQUILATERAL" | Any */
    get() = definedExternally
    set(value) = definedExternally
  var strokeMiterLimit: Number
  fun outlineStroke(): VectorNode?
  var fillGeometry: VectorPaths
}

external interface CornerMixin {
  var cornerRadius: dynamic /* Number | Any */
    get() = definedExternally
    set(value) = definedExternally
  var cornerSmoothing: Number
}

external interface RectangleCornerMixin {
  var topLeftRadius: Number
  var topRightRadius: Number
  var bottomLeftRadius: Number
  var bottomRightRadius: Number
}

external interface ExportMixin {
  var exportSettings: Array<dynamic /* ExportSettingsImage | ExportSettingsSVG | ExportSettingsPDF */>
  fun exportAsync(settings: ExportSettingsImage = definedExternally): Promise<Uint8Array>
  fun exportAsync(): Promise<Uint8Array>
  fun exportAsync(settings: ExportSettingsSVG = definedExternally): Promise<Uint8Array>
  fun exportAsync(settings: ExportSettingsPDF = definedExternally): Promise<Uint8Array>
}

external interface FramePrototypingMixin {
  var overflowDirection: String /* "NONE" | "HORIZONTAL" | "VERTICAL" | "BOTH" */
  var numberOfFixedChildren: Number
  var overlayPositionType: String /* "CENTER" | "TOP_LEFT" | "TOP_CENTER" | "TOP_RIGHT" | "BOTTOM_LEFT" | "BOTTOM_CENTER" | "BOTTOM_RIGHT" | "MANUAL" */
  var overlayBackground: dynamic /* `T$31` | `T$32` */
    get() = definedExternally
    set(value) = definedExternally
  var overlayBackgroundInteraction: String /* "NONE" | "CLOSE_ON_CLICK_OUTSIDE" */
}

external interface VectorLikeMixin {
  var vectorNetwork: VectorNetwork
  var vectorPaths: VectorPaths
  var handleMirroring: dynamic /* "NONE" | "ANGLE" | "ANGLE_AND_LENGTH" | Any */
    get() = definedExternally
    set(value) = definedExternally
}

external interface ReactionMixin {
  var reactions: Array<Reaction>
}

external interface DocumentationLink {
  var uri: String
}

external interface PublishableMixin {
  var description: String
  var documentationLinks: Array<DocumentationLink>
  var remote: Boolean
  var key: String
  fun getPublishStatusAsync(): Promise<String /* "UNPUBLISHED" | "CURRENT" | "CHANGED" */>
}

external interface DefaultShapeMixin : BaseNodeMixin, SceneNodeMixin, ReactionMixin, BlendMixin, GeometryMixin,
  LayoutMixin, ExportMixin

external interface BaseFrameMixin : BaseNodeMixin, SceneNodeMixin, ChildrenMixin, ContainerMixin,
  DeprecatedBackgroundMixin, GeometryMixin, CornerMixin, RectangleCornerMixin, BlendMixin, ConstraintMixin, LayoutMixin,
  ExportMixin, IndividualStrokesMixin {
  var layoutMode: String /* "NONE" | "HORIZONTAL" | "VERTICAL" */
  var primaryAxisSizingMode: String /* "FIXED" | "AUTO" */
  var counterAxisSizingMode: String /* "FIXED" | "AUTO" */
  var primaryAxisAlignItems: String /* "MIN" | "MAX" | "CENTER" | "SPACE_BETWEEN" */
  var counterAxisAlignItems: String /* "MIN" | "MAX" | "CENTER" | "BASELINE" */
  var paddingLeft: Number
  var paddingRight: Number
  var paddingTop: Number
  var paddingBottom: Number
  var itemSpacing: Number
  var itemReverseZIndex: Boolean
  var strokesIncludedInLayout: Boolean
  var horizontalPadding: Number
  var verticalPadding: Number
  var layoutGrids: Array<dynamic /* RowsColsLayoutGrid | GridLayoutGrid */>
  var gridStyleId: String
  var clipsContent: Boolean
  var guides: Array<Guide>
}

external interface DefaultFrameMixin : BaseFrameMixin, FramePrototypingMixin, ReactionMixin

external interface OpaqueNodeMixin : BaseNodeMixin, SceneNodeMixin, ExportMixin, DimensionAndPositionMixin

external interface MinimalBlendMixin {
  var opacity: Number
  var blendMode: String /* "PASS_THROUGH" | "NORMAL" | "DARKEN" | "MULTIPLY" | "LINEAR_BURN" | "COLOR_BURN" | "LIGHTEN" | "SCREEN" | "LINEAR_DODGE" | "COLOR_DODGE" | "OVERLAY" | "SOFT_LIGHT" | "HARD_LIGHT" | "DIFFERENCE" | "EXCLUSION" | "HUE" | "SATURATION" | "COLOR" | "LUMINOSITY" */
}

external interface VariantMixin {
  var variantProperties: `T$0`?
}

external interface `T$6` {
  var name: String?
    get() = definedExternally
    set(value) = definedExternally
  var defaultValue: dynamic /* String? | Boolean? */
    get() = definedExternally
    set(value) = definedExternally
  var preferredValues: Array<InstanceSwapPreferredValue>?
    get() = definedExternally
    set(value) = definedExternally
}

external interface ComponentPropertiesMixin {
  var componentPropertyDefinitions: ComponentPropertyDefinitions
  fun addComponentProperty(
    propertyName: String,
    type: String /* "BOOLEAN" | "TEXT" | "INSTANCE_SWAP" | "VARIANT" */,
    defaultValue: String,
    options: ComponentPropertyOptions = definedExternally
  ): String

  fun addComponentProperty(
    propertyName: String,
    type: String /* "BOOLEAN" | "TEXT" | "INSTANCE_SWAP" | "VARIANT" */,
    defaultValue: String
  ): String

  fun addComponentProperty(
    propertyName: String,
    type: String /* "BOOLEAN" | "TEXT" | "INSTANCE_SWAP" | "VARIANT" */,
    defaultValue: Boolean,
    options: ComponentPropertyOptions = definedExternally
  ): String

  fun addComponentProperty(
    propertyName: String,
    type: String /* "BOOLEAN" | "TEXT" | "INSTANCE_SWAP" | "VARIANT" */,
    defaultValue: Boolean
  ): String

  fun editComponentProperty(propertyName: String, newValue: `T$6`): String
  fun deleteComponentProperty(propertyName: String)
}

external interface TextSublayerNode : MinimalFillsMixin {
  var hasMissingFont: Boolean
  var paragraphIndent: Number
  var paragraphSpacing: Number
  var fontSize: dynamic /* Number | Any */
    get() = definedExternally
    set(value) = definedExternally
  var fontName: dynamic /* FontName | Any */
    get() = definedExternally
    set(value) = definedExternally
  var fontWeight: dynamic /* Number | Any */
    get() = definedExternally
    set(value) = definedExternally
  var textCase: dynamic /* "ORIGINAL" | "UPPER" | "LOWER" | "TITLE" | "SMALL_CAPS" | "SMALL_CAPS_FORCED" | Any */
    get() = definedExternally
    set(value) = definedExternally
  var textDecoration: dynamic /* "NONE" | "UNDERLINE" | "STRIKETHROUGH" | Any */
    get() = definedExternally
    set(value) = definedExternally
  var letterSpacing: dynamic /* LetterSpacing | Any */
    get() = definedExternally
    set(value) = definedExternally
  var lineHeight: dynamic /* `T$17` | `T$18` | Any */
    get() = definedExternally
    set(value) = definedExternally
  var hyperlink: dynamic /* HyperlinkTarget? | Any? */
    get() = definedExternally
    set(value) = definedExternally
  var characters: String
  fun insertCharacters(start: Number, characters: String, useStyle: String /* "BEFORE" | "AFTER" */ = definedExternally)
  fun deleteCharacters(start: Number, end: Number)
  fun getRangeFontSize(start: Number, end: Number): dynamic /* Number | Any */
  fun setRangeFontSize(start: Number, end: Number, value: Number)
  fun getRangeFontName(start: Number, end: Number): dynamic /* FontName | Any */
  fun setRangeFontName(start: Number, end: Number, value: FontName)
  fun getRangeFontWeight(start: Number, end: Number): dynamic /* Number | Any */
  fun getRangeAllFontNames(start: Number, end: Number): Array<FontName>
  fun getRangeTextCase(
    start: Number,
    end: Number
  ): dynamic /* "ORIGINAL" | "UPPER" | "LOWER" | "TITLE" | "SMALL_CAPS" | "SMALL_CAPS_FORCED" | Any */

  fun setRangeTextCase(
    start: Number,
    end: Number,
    value: String /* "ORIGINAL" | "UPPER" | "LOWER" | "TITLE" | "SMALL_CAPS" | "SMALL_CAPS_FORCED" */
  )

  fun getRangeTextDecoration(start: Number, end: Number): dynamic /* "NONE" | "UNDERLINE" | "STRIKETHROUGH" | Any */
  fun setRangeTextDecoration(start: Number, end: Number, value: String /* "NONE" | "UNDERLINE" | "STRIKETHROUGH" */)
  fun getRangeLetterSpacing(start: Number, end: Number): dynamic /* LetterSpacing | Any */
  fun setRangeLetterSpacing(start: Number, end: Number, value: LetterSpacing)
  fun getRangeLineHeight(start: Number, end: Number): dynamic /* `T$17` | `T$18` | Any */
  fun setRangeLineHeight(start: Number, end: Number, value: `T$17`)
  fun setRangeLineHeight(start: Number, end: Number, value: `T$18`)
  fun getRangeHyperlink(start: Number, end: Number): dynamic /* HyperlinkTarget? | Any? */
  fun setRangeHyperlink(start: Number, end: Number, value: HyperlinkTarget?)
  fun getRangeFills(
    start: Number,
    end: Number
  ): dynamic /* Array<dynamic /* SolidPaint | GradientPaint | ImagePaint | VideoPaint */> | Any */

  fun setRangeFills(
    start: Number,
    end: Number,
    value: Array<Any /* SolidPaint | GradientPaint | ImagePaint | VideoPaint */>
  )

  fun getRangeTextStyleId(start: Number, end: Number): dynamic /* String | Any */
  fun setRangeTextStyleId(start: Number, end: Number, value: String)
  fun getRangeFillStyleId(start: Number, end: Number): dynamic /* String | Any */
  fun setRangeFillStyleId(start: Number, end: Number, value: String)
  fun getRangeListOptions(start: Number, end: Number): dynamic /* TextListOptions | Any */
  fun setRangeListOptions(start: Number, end: Number, value: TextListOptions)
  fun getRangeIndentation(start: Number, end: Number): dynamic /* Number | Any */
  fun setRangeIndentation(start: Number, end: Number, value: Number)
  fun <StyledTextSegmentFields : Array<Any?>> getStyledTextSegments(
    fields: StyledTextSegmentFields,
    start: Number = definedExternally,
    end: Number = definedExternally
  ): Array<Pick<StyledTextSegment, dynamic /* Any | "characters" | "start" | "end" */>>
}

external interface DocumentNode : BaseNodeMixin {
  var type: String /* "DOCUMENT" */
  var children: Array<PageNode>
  fun appendChild(child: PageNode)
  fun insertChild(index: Number, child: PageNode)
  fun findChildren(callback: (node: PageNode) -> Boolean = definedExternally): Array<PageNode>
  fun findChild(callback: (node: PageNode) -> Boolean): PageNode?
  fun findAll(callback: (node: Any /* PageNode | SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */) -> Boolean = definedExternally): Array<dynamic /* PageNode | SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */>
  fun findOne(callback: (node: Any /* PageNode | SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */) -> Boolean): dynamic /* PageNode? | SliceNode? | FrameNode? | GroupNode? | ComponentSetNode? | ComponentNode? | InstanceNode? | BooleanOperationNode? | VectorNode? | StarNode? | LineNode? | EllipseNode? | PolygonNode? | RectangleNode? | TextNode? | StickyNode? | ConnectorNode? | ShapeWithTextNode? | CodeBlockNode? | StampNode? | WidgetNode? | EmbedNode? | LinkUnfurlNode? | MediaNode? | SectionNode? | HighlightNode? | WashiTapeNode? | TableNode? */
  fun <T : Array<Any>> findAllWithCriteria(criteria: `T$4`<T>): Array<`T$5` /* `T$5` & dynamic */>
}

external interface `T$7` {
  var node: TextNode
  var start: Number
  var end: Number
}

external interface `T$8` {
  var nodeId: String
  var name: String
}

external interface PageNode : BaseNodeMixin, ChildrenMixin, ExportMixin {
  var type: String /* "PAGE" */
  fun clone(): PageNode
  var guides: Array<Guide>
  var selection: Array<dynamic /* SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */>
  var selectedTextRange: `T$7`?
  var flowStartingPoints: Array<`T$8`>
  var backgrounds: Array<dynamic /* SolidPaint | GradientPaint | ImagePaint | VideoPaint */>
  var prototypeBackgrounds: Array<dynamic /* SolidPaint | GradientPaint | ImagePaint | VideoPaint */>
  var prototypeStartNode: dynamic /* FrameNode? | GroupNode? | ComponentNode? | InstanceNode? */
    get() = definedExternally
    set(value) = definedExternally
}

external interface FrameNode : DefaultFrameMixin {
  var type: String /* "FRAME" */
  fun clone(): FrameNode
}

external interface GroupNode : BaseNodeMixin, SceneNodeMixin, ReactionMixin, ChildrenMixin, ContainerMixin,
  DeprecatedBackgroundMixin, BlendMixin, LayoutMixin, ExportMixin {
  var type: String /* "GROUP" */
  fun clone(): GroupNode
}

external interface SliceNode : BaseNodeMixin, SceneNodeMixin, LayoutMixin, ExportMixin {
  var type: String /* "SLICE" */
  fun clone(): SliceNode
}

external interface RectangleNode : DefaultShapeMixin, ConstraintMixin, CornerMixin, RectangleCornerMixin,
  IndividualStrokesMixin {
  var type: String /* "RECTANGLE" */
  fun clone(): RectangleNode
}

external interface LineNode : DefaultShapeMixin, ConstraintMixin {
  var type: String /* "LINE" */
  fun clone(): LineNode
}

external interface EllipseNode : DefaultShapeMixin, ConstraintMixin, CornerMixin {
  var type: String /* "ELLIPSE" */
  fun clone(): EllipseNode
  var arcData: ArcData
}

external interface PolygonNode : DefaultShapeMixin, ConstraintMixin, CornerMixin {
  var type: String /* "POLYGON" */
  fun clone(): PolygonNode
  var pointCount: Number
}

external interface StarNode : DefaultShapeMixin, ConstraintMixin, CornerMixin {
  var type: String /* "STAR" */
  fun clone(): StarNode
  var pointCount: Number
  var innerRadius: Number
}

external interface VectorNode : DefaultShapeMixin, ConstraintMixin, CornerMixin, VectorLikeMixin {
  var type: String /* "VECTOR" */
  fun clone(): VectorNode
}

external interface TextNode : DefaultShapeMixin, ConstraintMixin, TextSublayerNode {
  var type: String /* "TEXT" */
  fun clone(): TextNode
  var textAlignHorizontal: String /* "LEFT" | "CENTER" | "RIGHT" | "JUSTIFIED" */
  var textAlignVertical: String /* "TOP" | "CENTER" | "BOTTOM" */
  var textAutoResize: String /* "NONE" | "WIDTH_AND_HEIGHT" | "HEIGHT" | "TRUNCATE" */
  var autoRename: Boolean
  var textStyleId: dynamic /* String | Any */
    get() = definedExternally
    set(value) = definedExternally
}

external interface InstanceSwapPreferredValue {
  var type: String /* "COMPONENT" | "COMPONENT_SET" */
  var key: String
}

external interface ComponentPropertyOptions {
  var preferredValues: Array<InstanceSwapPreferredValue>?
    get() = definedExternally
    set(value) = definedExternally
}

external interface `T$9` {
  var type: String /* "BOOLEAN" | "TEXT" | "INSTANCE_SWAP" | "VARIANT" */
  var defaultValue: dynamic /* String | Boolean */
    get() = definedExternally
    set(value) = definedExternally
  var preferredValues: Array<InstanceSwapPreferredValue>?
    get() = definedExternally
    set(value) = definedExternally
  var variantOptions: Array<String>?
    get() = definedExternally
    set(value) = definedExternally
}

external interface ComponentPropertyDefinitions {
  @nativeGetter
  operator fun get(propertyName: String): `T$9`?

  @nativeSetter
  operator fun set(propertyName: String, value: `T$9`)
}

external interface `T$10` {
  var values: Array<String>
}

external interface `T$11` {
  @nativeGetter
  operator fun get(property: String): `T$10`?

  @nativeSetter
  operator fun set(property: String, value: `T$10`)
}

external interface ComponentSetNode : BaseFrameMixin, PublishableMixin, ComponentPropertiesMixin {
  var type: String /* "COMPONENT_SET" */
  fun clone(): ComponentSetNode
  var defaultVariant: ComponentNode
  var variantGroupProperties: `T$11`
}

external interface ComponentNode : DefaultFrameMixin, PublishableMixin, VariantMixin, ComponentPropertiesMixin {
  var type: String /* "COMPONENT" */
  fun clone(): ComponentNode
  fun createInstance(): InstanceNode
  var instances: Array<InstanceNode>
}

external interface `T$12` {
  var type: String /* "BOOLEAN" | "TEXT" | "INSTANCE_SWAP" | "VARIANT" */
  var value: dynamic /* String | Boolean */
    get() = definedExternally
    set(value) = definedExternally
  var preferredValues: Array<InstanceSwapPreferredValue>?
    get() = definedExternally
    set(value) = definedExternally
}

external interface ComponentProperties {
  @nativeGetter
  operator fun get(propertyName: String): `T$12`?

  @nativeSetter
  operator fun set(propertyName: String, value: `T$12`)
}

external interface `T$13` {
  @nativeGetter
  operator fun get(propertyName: String): dynamic /* String? | Boolean? */

  @nativeSetter
  operator fun set(propertyName: String, value: String)

  @nativeSetter
  operator fun set(propertyName: String, value: Boolean)
}

external interface `T$14` {
  var id: String
  var overriddenFields: Array<String /* "pointCount" | "name" | "width" | "height" | "parent" | "pluginData" | "constraints" | "locked" | "visible" | "opacity" | "blendMode" | "layoutGrids" | "guides" | "characters" | "styledTextSegments" | "vectorNetwork" | "effects" | "exportSettings" | "arcData" | "autoRename" | "fontName" | "innerRadius" | "fontSize" | "lineHeight" | "paragraphIndent" | "paragraphSpacing" | "letterSpacing" | "textAlignHorizontal" | "textAlignVertical" | "textCase" | "textDecoration" | "textAutoResize" | "fills" | "topLeftRadius" | "topRightRadius" | "bottomLeftRadius" | "bottomRightRadius" | "constrainProportions" | "strokes" | "strokeWeight" | "strokeAlign" | "strokeCap" | "strokeJoin" | "strokeMiterLimit" | "booleanOperation" | "overflowDirection" | "dashPattern" | "backgrounds" | "handleMirroring" | "cornerRadius" | "cornerSmoothing" | "relativeTransform" | "x" | "y" | "rotation" | "isMask" | "clipsContent" | "type" | "overlayPositionType" | "overlayBackgroundInteraction" | "overlayBackground" | "prototypeStartNode" | "prototypeBackgrounds" | "expanded" | "fillStyleId" | "strokeStyleId" | "backgroundStyleId" | "textStyleId" | "effectStyleId" | "gridStyleId" | "description" | "layoutMode" | "paddingLeft" | "paddingTop" | "paddingRight" | "paddingBottom" | "itemSpacing" | "layoutAlign" | "counterAxisSizingMode" | "primaryAxisSizingMode" | "primaryAxisAlignItems" | "counterAxisAlignItems" | "layoutGrow" | "layoutPositioning" | "itemReverseZIndex" | "hyperlink" | "mediaData" | "stokeTopWeight" | "strokeBottomWeight" | "strokeLeftWeight" | "strokeRightWeight" | "reactions" | "flowStartingPoints" | "shapeType" | "connectorStart" | "connectorEnd" | "connectorLineType" | "connectorStartStrokeCap" | "connectorEndStrokeCap" | "codeLanguage" | "widgetSyncedState" | "componentPropertyDefinitions" | "componentPropertyReferences" | "componentProperties" | "embedData" | "linkUnfurlData" | "text" | "authorVisible" | "authorName" | "code" | "textBackground" */>
}

external interface InstanceNode : DefaultFrameMixin, VariantMixin {
  var type: String /* "INSTANCE" */
  fun clone(): InstanceNode
  var mainComponent: ComponentNode?
  fun swapComponent(componentNode: ComponentNode)
  fun setProperties(properties: `T$13`)
  var componentProperties: ComponentProperties
  fun detachInstance(): FrameNode
  var scaleFactor: Number
  var exposedInstances: Array<InstanceNode>
  var isExposedInstance: Boolean
  var overrides: Array<`T$14`>
  fun resetOverrides()
}

external interface BooleanOperationNode : DefaultShapeMixin, ChildrenMixin, CornerMixin, ContainerMixin {
  var type: String /* "BOOLEAN_OPERATION" */
  fun clone(): BooleanOperationNode
  var booleanOperation: String /* "UNION" | "INTERSECT" | "SUBTRACT" | "EXCLUDE" */
}

external interface StickyNode : OpaqueNodeMixin, MinimalFillsMixin, MinimalBlendMixin {
  var type: String /* "STICKY" */
  var text: TextSublayerNode
  var authorVisible: Boolean
  var authorName: String
  fun clone(): StickyNode
}

external interface StampNode : DefaultShapeMixin, ConstraintMixin, StickableMixin {
  var type: String /* "STAMP" */
  fun clone(): StampNode
  fun getAuthorAsync(): Promise<BaseUser?>
}

external interface TableNode : OpaqueNodeMixin, MinimalFillsMixin, MinimalBlendMixin {
  var type: String /* "TABLE" */
  fun clone(): TableNode
  var numRows: Number
  var numColumns: Number
  fun cellAt(rowIndex: Number, columnIndex: Number): TableCellNode
  fun insertRow(rowIndex: Number)
  fun insertColumn(columnIndex: Number)
  fun removeRow(rowIndex: Number)
  fun removeColumn(columnIndex: Number)
  fun moveRow(fromIndex: Number, toIndex: Number)
  fun moveColumn(fromIndex: Number, toIndex: Number)
  fun resizeRow(rowIndex: Number, height: Number)
  fun resizeColumn(columnIndex: Number, width: Number)
}

external interface TableCellNode : MinimalFillsMixin {
  var type: String /* "TABLE_CELL" */
  var text: TextSublayerNode
  var rowIndex: Number
  var columnIndex: Number
  var toString: String
  var parent: TableNode
  var height: Number
  var width: Number
}

external interface HighlightNode : DefaultShapeMixin, ConstraintMixin, CornerMixin, ReactionMixin, VectorLikeMixin,
  StickableMixin {
  var type: String /* "HIGHLIGHT" */
  fun clone(): HighlightNode
}

external interface WashiTapeNode : DefaultShapeMixin, StickableMixin {
  var type: String /* "WASHI_TAPE" */
  fun clone(): WashiTapeNode
}

external interface ShapeWithTextNode : OpaqueNodeMixin, MinimalFillsMixin, MinimalBlendMixin, MinimalStrokesMixin {
  var type: String /* "SHAPE_WITH_TEXT" */
  var shapeType: String /* "SQUARE" | "ELLIPSE" | "ROUNDED_RECTANGLE" | "DIAMOND" | "TRIANGLE_UP" | "TRIANGLE_DOWN" | "PARALLELOGRAM_RIGHT" | "PARALLELOGRAM_LEFT" | "ENG_DATABASE" | "ENG_QUEUE" | "ENG_FILE" | "ENG_FOLDER" */
  var text: TextSublayerNode
  var cornerRadius: Number?
    get() = definedExternally
    set(value) = definedExternally
  var rotation: Number
  fun resize(width: Number, height: Number)
  fun rescale(scale: Number)
  fun clone(): ShapeWithTextNode
}

external interface CodeBlockNode : OpaqueNodeMixin, MinimalBlendMixin {
  var type: String /* "CODE_BLOCK" */
  var code: String
  var codeLanguage: String /* "TYPESCRIPT" | "CPP" | "RUBY" | "CSS" | "JAVASCRIPT" | "HTML" | "JSON" | "GRAPHQL" | "PYTHON" | "GO" | "SQL" | "SWIFT" | "KOTLIN" | "RUST" | "BASH" */
  fun clone(): CodeBlockNode
}

external interface LabelSublayerNode {
  var fills: dynamic /* Array<dynamic /* SolidPaint | GradientPaint | ImagePaint | VideoPaint */> | Any */
    get() = definedExternally
    set(value) = definedExternally
}

external interface ConnectorNode : OpaqueNodeMixin, MinimalBlendMixin, MinimalStrokesMixin {
  var type: String /* "CONNECTOR" */
  var text: TextSublayerNode
  var textBackground: LabelSublayerNode
  var cornerRadius: Number?
    get() = definedExternally
    set(value) = definedExternally
  var connectorLineType: String /* "ELBOWED" | "STRAIGHT" */
  var connectorStart: dynamic /* ConnectorEndpointPosition | ConnectorEndpointEndpointNodeIdAndMagnet | ConnectorEndpointPositionAndEndpointNodeId */
    get() = definedExternally
    set(value) = definedExternally
  var connectorEnd: dynamic /* ConnectorEndpointPosition | ConnectorEndpointEndpointNodeIdAndMagnet | ConnectorEndpointPositionAndEndpointNodeId */
    get() = definedExternally
    set(value) = definedExternally
  var connectorStartStrokeCap: String /* "NONE" | "ARROW_EQUILATERAL" | "ARROW_LINES" | "TRIANGLE_FILLED" | "DIAMOND_FILLED" | "CIRCLE_FILLED" */
  var connectorEndStrokeCap: String /* "NONE" | "ARROW_EQUILATERAL" | "ARROW_LINES" | "TRIANGLE_FILLED" | "DIAMOND_FILLED" | "CIRCLE_FILLED" */
  var rotation: Number
  fun clone(): ConnectorNode
}

external interface `T$15` {
  @nativeGetter
  operator fun get(mapName: String): Json?

  @nativeSetter
  operator fun set(mapName: String, value: Json)
}

external interface WidgetNode : OpaqueNodeMixin, StickableMixin {
  var type: String /* "WIDGET" */
  var widgetId: String
  var widgetSyncedState: Json
  fun clone(): WidgetNode
  fun cloneWidget(syncedStateOverrides: Json, syncedMapOverrides: `T$15` = definedExternally): WidgetNode
  fun setWidgetSyncedState(syncedState: Json, syncedMap: `T$15` = definedExternally)
}

external interface EmbedData {
  var srcUrl: String
  var canonicalUrl: String?
  var title: String?
  var description: String?
  var provider: String?
}

external interface EmbedNode : OpaqueNodeMixin, SceneNodeMixin {
  var type: String /* "EMBED" */
  var embedData: EmbedData
  fun clone(): EmbedNode
}

external interface LinkUnfurlData {
  var url: String
  var title: String?
  var description: String?
  var provider: String?
}

external interface LinkUnfurlNode : OpaqueNodeMixin, SceneNodeMixin {
  var type: String /* "LINK_UNFURL" */
  var linkUnfurlData: LinkUnfurlData
  fun clone(): LinkUnfurlNode
}

external interface MediaData {
  var hash: String
}

external interface MediaNode : OpaqueNodeMixin {
  var type: String /* "MEDIA" */
  var mediaData: MediaData
  fun resize(width: Number, height: Number)
  fun resizeWithoutConstraints(width: Number, height: Number)
  fun clone(): MediaNode
}

external interface SectionNode : ChildrenMixin, MinimalFillsMixin, OpaqueNodeMixin {
  var type: String /* "SECTION" */
  fun clone(): SectionNode
  fun resizeWithoutConstraints(width: Number, height: Number)
}

external interface StyleConsumers {
  var node: dynamic /* SliceNode | FrameNode | GroupNode | ComponentSetNode | ComponentNode | InstanceNode | BooleanOperationNode | VectorNode | StarNode | LineNode | EllipseNode | PolygonNode | RectangleNode | TextNode | StickyNode | ConnectorNode | ShapeWithTextNode | CodeBlockNode | StampNode | WidgetNode | EmbedNode | LinkUnfurlNode | MediaNode | SectionNode | HighlightNode | WashiTapeNode | TableNode */
    get() = definedExternally
    set(value) = definedExternally
  var fields: Array<String /* "fillStyleId" | "strokeStyleId" | "backgroundStyleId" | "textStyleId" | "effectStyleId" | "gridStyleId" */>
}

external interface BaseStyle : PublishableMixin, PluginDataMixin {
  var id: String
  var type: String /* "PAINT" | "TEXT" | "EFFECT" | "GRID" */
  var consumers: Array<StyleConsumers>
  var name: String
  fun remove()
}

external interface PaintStyle : BaseStyle {
  override var type: String /* "PAINT" */
  var paints: Array<dynamic /* SolidPaint | GradientPaint | ImagePaint | VideoPaint */>
}

external interface TextStyle : BaseStyle {
  override var type: String /* "TEXT" */
  var fontSize: Number
  var textDecoration: String /* "NONE" | "UNDERLINE" | "STRIKETHROUGH" */
  var fontName: FontName
  var letterSpacing: LetterSpacing
  var lineHeight: dynamic /* `T$17` | `T$18` */
    get() = definedExternally
    set(value) = definedExternally
  var paragraphIndent: Number
  var paragraphSpacing: Number
  var textCase: String /* "ORIGINAL" | "UPPER" | "LOWER" | "TITLE" | "SMALL_CAPS" | "SMALL_CAPS_FORCED" */
}

external interface EffectStyle : BaseStyle {
  override var type: String /* "EFFECT" */
  var effects: Array<dynamic /* DropShadowEffect | InnerShadowEffect | BlurEffect */>
}

external interface GridStyle : BaseStyle {
  override var type: String /* "GRID" */
  var layoutGrids: Array<dynamic /* RowsColsLayoutGrid | GridLayoutGrid */>
}

external interface `T$16` {
  var width: Number
  var height: Number
}

external interface Image {
  var hash: String
  fun getBytesAsync(): Promise<Uint8Array>
  fun getSizeAsync(): Promise<`T$16`>
}

external interface Video {
  var hash: String
}

external interface BaseUser {
  var id: String?
  var name: String
  var photoUrl: String?
}

external interface User : BaseUser {
  var color: String
  var sessionId: Number
}

external interface ActiveUser : User {
  var position: Vector?
  var viewport: Rect
  var selection: Array<String>
}
