/*
 * FreeOTP
 *
 * Authors: Nathaniel McCallum <npmccallum@redhat.com>
 *
 * Copyright (C) 2013  Nathaniel McCallum, Red Hat
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

package org.fedorahosted.freeotp

import android.app.Activity
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.content.res.Resources
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about)
    }

    public override fun onStart() {
        super.onStart()

        val res = resources
        val aboutVersion: TextView = findViewById(R.id.about_version)

        val pm = packageManager
        val info = pm.getPackageInfo(packageName, 0)
        val version = res.getString(R.string.about_version, info.versionName, info.versionCode)
        aboutVersion.text = version

        val apache2 = res.getString(R.string.link_apache2)
        val license = res.getString(R.string.about_license, apache2)

        val aboutLicense:TextView = findViewById(R.id.about_license)
        aboutLicense.movementMethod = LinkMovementMethod.getInstance()
        aboutLicense.text = Html.fromHtml(license)
    }
}
