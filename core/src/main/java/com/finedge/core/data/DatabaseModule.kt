import android.content.Context
import com.finedge.core.data.TransactionDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): FinEdgeDatabase {
        return FinEdgeDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideTransactionDao(db: FinEdgeDatabase): TransactionDao {
        return db.transactionDao()
    }
}
