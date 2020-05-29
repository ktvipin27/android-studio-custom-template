<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <application>

        <activity android:name="${packageName}.${activityClass}"
            android:label="@string/title_${activityToLayout(activityClass)}" />

    </application>

</manifest>
