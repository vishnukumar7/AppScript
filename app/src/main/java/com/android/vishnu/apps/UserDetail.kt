import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
class UserDetail {

    @PrimaryKey(autoGenerate = true)
    private lateinit var uid: String

    @ColumnInfo(name = "UserName")
    private lateinit var userName: String

    @ColumnInfo(name = "Best_Cricketer")
    private lateinit var bestCricket: String

    @ColumnInfo(name = "colors")
    private lateinit var colors: String

}
