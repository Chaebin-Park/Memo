package com.cbpark.memo.db

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.cbpark.memo.dao.MemoDao
import com.cbpark.memo.repository.MemoRepository
import com.cbpark.memo.repository.MemoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
  @Provides
  @Singleton
  fun provideMemoDatabase(app: Application): MemoDatabase {
    return Room.databaseBuilder(
      app,
      MemoDatabase::class.java,
      "memo.db"
    ).fallbackToDestructiveMigration().build()
  }

  @Provides
  fun provideMemoRepository(db: MemoDatabase): MemoRepository = MemoRepositoryImpl(db.memoDao)
}