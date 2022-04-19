/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.eggtimernotifications

import android.app.NotificationManager
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.android.eggtimernotifications.util.sendNotification
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    /**
     * Called when message is received.
     *
     * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
     */
    // [START receive_message]
    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: ${remoteMessage?.from}")

        // Step 3.5 check messages for data
        // Check if message contains a data payload.
        remoteMessage?.data?.let {
            Log.d(TAG, "Message data payload: " + remoteMessage.data)
        }

        // Step 3.6 check messages for notification and call sendNotification
        // Check if message contains a notification payload.
        remoteMessage?.notification?.let {
            Log.d(TAG, "Message Notification Body: ${it.body}")
            sendNotification(it.body as String)
        }

    }
    // [END receive_message]

    // tested with pixel 3 api 30
    // your emulator needs google play + google apis to receive notifications
    // reference: https://stackoverflow.com/questions/46464356/firebase-message-not-received-on-emulator/69045105#69045105
    override fun onNewToken(token: String?) {
        Log.d(TAG, "Refreshed token: $token")
        sendRegistrationToServer(token)
        super.onNewToken(token)
    }
    // [END on_new_token]

    /**
     * Persist token to third-party (your app) servers.
     *
     * @param token The new token.
     */
    private fun sendRegistrationToServer(token: String?) {
        // Optional: Implement this method to send token to your app server.
    }

    /**
     * Create and show a simple notification containing the received FCM message.
     *
     * @param messageBody FCM message body received.
     */
    private fun sendNotification(messageBody: String) {
        val notificationManager = ContextCompat.getSystemService(applicationContext, NotificationManager::class.java) as NotificationManager
        notificationManager.sendNotification(messageBody, applicationContext)
    }

    companion object {
        private const val TAG = "MyFirebaseMsgService"
    }
}