import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.finedge.core.data.TransactionDao
import com.finedge.core.data.TransactionEntity

@Database(
    entities = [TransactionEntity::class],
    version = 1,
    exportSchema = false
)
abstract class FinEdgeDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao

    companion object {
        @Volatile
        private var INSTANCE: FinEdgeDatabase? = null

        fun getInstance(context: Context): FinEdgeDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context,
                    FinEdgeDatabase::class.java,
                    "finedge_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
