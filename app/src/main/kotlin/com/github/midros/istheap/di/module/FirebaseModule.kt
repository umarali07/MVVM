package com.github.midros.istheap.di.module

import android.content.Context
import com.github.midros.istheap.data.rxFirebase.DevelopFirebase
import com.github.midros.istheap.data.rxFirebase.InterfaceFirebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import dagger.Module
import dagger.Provides

/**
 * Created by luis rafael on 8/03/18.
 */
@Module
class FirebaseModule {

    @Provides
    fun provideInterfaceFirebase(context: Context, auth: FirebaseAuth, dataRef: DatabaseReference, stoRef: StorageReference): InterfaceFirebase = DevelopFirebase(context,auth, dataRef, stoRef)

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideFirebaseDatabase(): FirebaseDatabase = FirebaseDatabase.getInstance()

    @Provides
    fun provideFirebaseStorage(): FirebaseStorage = FirebaseStorage.getInstance()

    @Provides
    fun provideDatabaseReference(database: FirebaseDatabase): DatabaseReference = database.reference

    @Provides
    fun provideStorageReference(storage: FirebaseStorage): StorageReference = storage.reference


}