// JUnit
//import org.junit.jupiter.api.Assertions.*
//import org.junit.jupiter.api.Test

// KotlinTest
import kotlin.test.Test
import kotlin.test.assertEquals

internal class SampleTest {
    private val testSample: Sample = Sample()

    @Test
    fun `test sum`() {
        val expected = 42
        assertEquals(expected, testSample.sum(40, 2))
    }
}