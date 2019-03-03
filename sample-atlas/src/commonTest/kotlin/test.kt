import com.soywiz.korge.atlas.*
import com.soywiz.korge.tests.*
import com.soywiz.korge.view.*
import com.soywiz.korim.bitmap.*
import com.soywiz.korio.async.*
import com.soywiz.korio.file.std.*
import com.soywiz.korma.geom.*
import kotlin.test.*

class AtlasTest : ViewsForTesting() {
	@Test
	fun test() = viewsTest {
		atlasMain()
		assertEquals(3, stage.children.size)
		assertEquals(Size(68, 204), (stage.children.first() as Image).texture.bmp.size)
	}

	@Test
	fun testAtlas() = suspendTest {
		val atlas = resourcesVfs["logos.atlas.json"].readAtlas(views)
		assertEquals(3, atlas.textures.size)
		assertEquals(Size(66, 66), atlas.textures["korau.png"]!!.texture.size)
		assertEquals(Size(66, 66), atlas.textures["korge.png"]!!.texture.size)
		assertEquals(Size(66, 66), atlas.textures["korim.png"]!!.texture.size)
	}

	private val BmpSlice.size get() = Size(width, height)
}
