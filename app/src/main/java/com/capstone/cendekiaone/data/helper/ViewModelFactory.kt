package com.capstone.cendekiaone.data.helper

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.capstone.cendekiaone.data.pref.UserPreferences
import com.capstone.cendekiaone.data.remote.retforit.ApiConfig
import com.capstone.cendekiaone.data.remote.retforit.ApiService
import com.capstone.cendekiaone.ui.screen.login.LoginViewModel
import com.capstone.cendekiaone.ui.screen.register.RegisterViewModel
import androidx.datastore.preferences.core.Preferences
import com.capstone.cendekiaone.ui.screen.create.CreateViewModel
import com.capstone.cendekiaone.ui.screen.detailExplore.ExploreDetailViewModel
import com.capstone.cendekiaone.ui.screen.home.HomeViewModel
import com.capstone.cendekiaone.ui.screen.profile.EditProfileViewModel
import com.capstone.cendekiaone.ui.screen.profile.ProfileViewModel
import com.capstone.cendekiaone.ui.screen.explore.SearchViewModel
import com.capstone.cendekiaone.ui.screen.profile.FollowViewModel


// Create a DataStore property in your Compose application
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

@Suppress("UNCHECKED_CAST")
class LocalViewModelFactory private constructor(
    private val apiService: ApiService,
    private val pref: UserPreferences,
    private val userRepository: UserRepository,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(RegisterViewModel::class.java) -> {
                RegisterViewModel(apiService) as T
            }
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(apiService, userRepository) as T
            }
            modelClass.isAssignableFrom(UserRepository::class.java) -> {
                UserRepository(pref) as T
            }
            modelClass.isAssignableFrom(ProfileViewModel::class.java) -> {
                ProfileViewModel(apiService) as T
            }
            modelClass.isAssignableFrom(EditProfileViewModel::class.java) -> {
                EditProfileViewModel(apiService) as T
            }
            modelClass.isAssignableFrom(CreateViewModel::class.java) -> {
                CreateViewModel(apiService) as T
            }
            modelClass.isAssignableFrom(ExploreDetailViewModel::class.java) -> {
                ExploreDetailViewModel(apiService) as T
            }
            modelClass.isAssignableFrom(SearchViewModel::class.java) -> {
                SearchViewModel(apiService) as T
            }
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(apiService) as T
            }
            modelClass.isAssignableFrom(FollowViewModel::class.java) -> {
                FollowViewModel(apiService) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }

    companion object {
        @Composable
        fun provide(): LocalViewModelFactory {
            val context = LocalContext.current
            val apiService = ApiConfig.getApiService()
            val userPreferences = UserPreferences.getInstance(context.dataStore)
            val userRepository = UserRepository(userPreferences)

            return remember(context, apiService, userPreferences, userRepository) {
                LocalViewModelFactory(apiService, userPreferences, userRepository)
            }
        }
    }
}