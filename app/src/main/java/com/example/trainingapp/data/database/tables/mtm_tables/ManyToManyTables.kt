package com.example.trainingapp.data.database.tables.mtm_tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.trainingapp.data.database.tables.exercise_table.ExerciseTable
import com.example.trainingapp.data.database.tables.movement_table.MovementTable
import com.example.trainingapp.data.database.tables.session_table.SessionTable
import com.example.trainingapp.data.database.tables.set_table.SetTable
import com.example.trainingapp.data.database.tables.tags_table.TagsTable

@Entity(
    tableName = "session_to_descdata",
    primaryKeys = ["session_id", "ex_no", "set_no"],
    foreignKeys = [
        ForeignKey(
            entity = SessionTable::class,
            parentColumns = ["id"],
            childColumns = ["session_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = SetTable::class,
            parentColumns = ["id"],
            childColumns = ["set_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class SessionToDescdata(
    @ColumnInfo(name = "session_id") var sessionId : Int,
    @ColumnInfo(name = "set_id") var setId : Int,
    @ColumnInfo(name = "ex_no") var exNo : Int,
    @ColumnInfo(name = "set_no") var setNo : Int,
    )

@Entity(
    tableName = "exercise_set_join",
    primaryKeys = ["exerciseId", "setOrderId"],
    foreignKeys = [
        ForeignKey(
            entity = ExerciseTable::class,
            parentColumns = ["id"],
            childColumns = ["exerciseId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = SetTable::class,
            parentColumns = ["id"],
            childColumns = ["setId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ExerciseSetJoin(
    val exerciseId: Int,
    val setId: Int,
    val setOrderId: Int // This will represent the order of the sets for the exercise
)

@Entity(
    tableName = "movement_to_tag",
    primaryKeys = ["movementId", "tagId"],
    foreignKeys = [
        ForeignKey(
            entity = MovementTable::class,
            parentColumns = ["id"],
            childColumns = ["movementId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = TagsTable::class,
            parentColumns = ["id"],
            childColumns = ["tagId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class MovementToTag(
    var movementId : Int,
    var tagId : Int,
    )