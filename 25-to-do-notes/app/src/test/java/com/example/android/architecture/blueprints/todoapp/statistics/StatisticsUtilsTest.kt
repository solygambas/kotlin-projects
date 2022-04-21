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

    @Test
    fun getActiveAndCompleteStats_noActive_returnsZeroHundred() {
        // Arrange - Given: create an active task
        val tasks = listOf<Task>(
            Task("title", "description", isCompleted = true)
        )
        // Act - When: call the function
        val result = getActiveAndCompletedStats(tasks)

        // Assert - Then: check the result
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(100f))
    }

    @Test
    fun getActiveAndCompleteStats_both_returnsFortySixty() {
        // Arrange - Given: create an active task
        val tasks = listOf<Task>(
            Task("title", "description", isCompleted = true),
            Task("title", "description", isCompleted = true),
            Task("title", "description", isCompleted = false),
            Task("title", "description", isCompleted = false),
            Task("title", "description", isCompleted = false),
        )
        // Act - When: call the function
        val result = getActiveAndCompletedStats(tasks)

        // Assert - Then: check the result
        assertThat(result.activeTasksPercent, `is`(60f))
        assertThat(result.completedTasksPercent, `is`(40f))
    }

    @Test
    fun getActiveAndCompletedStats_error_returnsZeros() {
        // When there's an error loading stats
        val result = getActiveAndCompletedStats(null)

        // Both active and completed tasks are 0
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros() {
        // When there are no tasks
        val result = getActiveAndCompletedStats(emptyList())

        // Both active and completed tasks are 0
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }
}