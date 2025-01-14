package xyz.ivaniskandar.shouko.util

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager

val Context.canReadSystemLogs
    get() = checkSelfPermission(Manifest.permission.READ_LOGS) == PackageManager.PERMISSION_GRANTED

val Context.canWriteSecureSettings: Boolean
    get() = checkSelfPermission(Manifest.permission.WRITE_SECURE_SETTINGS) == PackageManager.PERMISSION_GRANTED

fun Context.isPackageInstalled(packageName: String): Boolean {
    return try {
        packageManager.getApplicationInfo(packageName, 0).enabled
    } catch (e: PackageManager.NameNotFoundException) {
        false
    }
}
