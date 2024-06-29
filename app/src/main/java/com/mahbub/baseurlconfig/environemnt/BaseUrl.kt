package com.mahbub.baseurlconfig.environemnt

import com.mahbub.baseurlconfig.BuildConfig

enum class BuildType {
    DEV, STAGE, PRODUCTION
}

object Env {
    private var currentEnv = if (BuildConfig.DEBUG) BuildType.PRODUCTION
    else BuildType.PRODUCTION

    fun changeEnv(env: BuildType): BuildType {
        currentEnv = env
        return currentEnv
    }

    fun getUrlServiceA() = when (currentEnv) {
        BuildType.PRODUCTION -> BuildConfig.BASE_URL_MESSAGE_SERVICE
        BuildType.STAGE -> BuildConfig.STAGE_BASE_URL_MESSAGE_SERVICE
        BuildType.DEV -> BuildConfig.DEV_BASE_URL_MESSAGE_SERVICE
    }
    fun getUrlServiceB() = when (currentEnv) {
        BuildType.PRODUCTION -> BuildConfig.BASE_URL_STREAM_SERVICE
        BuildType.STAGE -> BuildConfig.STAGE_BASE_URL_STREAM_SERVICE
        BuildType.DEV -> BuildConfig.DEV_BASE_URL_STREAM_SERVICE
    }

}
