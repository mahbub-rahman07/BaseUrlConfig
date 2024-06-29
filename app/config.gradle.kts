val buildConfigFields = mapOf(
//  PROD Env
    "BASE_URL_MESSAGE_SERVICE" to project.property("BASE_URL_MESSAGE_SERVICE") as String,
    "BASE_URL_STREAM_SERVICE" to project.property("BASE_URL_STREAM_SERVICE") as String,

//    STAGE Env
    "STAGE_BASE_URL_MESSAGE_SERVICE" to project.property("STAGE_BASE_URL_MESSAGE_SERVICE") as String,
    "STAGE_BASE_URL_STREAM_SERVICE" to project.property("STAGE_BASE_URL_STREAM_SERVICE") as String,

//    DEV Env
    "DEV_BASE_URL_MESSAGE_SERVICE" to  project.property("DEV_BASE_URL_MESSAGE_SERVICE") as String,
    "DEV_BASE_URL_STREAM_SERVICE" to  project.property("DEV_BASE_URL_STREAM_SERVICE") as String
)

extra.set("buildConfigFields", buildConfigFields)




