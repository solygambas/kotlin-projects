package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.Matchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class StatisticsUtilsTest {

    // Give meaningful names: subjectUnderTest_actionOrInput_resultState
    @Test
    fun getActiveAndCompleteStats_noCompleted_returnsHundredZero() {
        // Arrange - Given: create an active task
        val tasks = listOf<Task>(
            Task("title", "description", isCompleted = false)
        )
        // Act - When: call the function
        val result = getActiveAndCompletedStats(tasks)

        // Assert - Then: check the result
        /*assertEquals(result.completedTasksPercent, 0f)
        assertEquals(result.activeTasksPercent, 100f)*/

        // use hamcrest
        assertThat(result.activeTasksPercent, `is`(100f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

}