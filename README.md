# ProportionalImageView
ProportionalImageView is a simple library for your Android project that allows you to set a ratio on Image View component.
##Requirements
The library requires Android **API Level 16+**

##Usage
Add a repository to your app-level `build.gradle`:

    repositories {
        maven {
            url 'https://dl.bintray.com/giuseppegiacoppo/maven/'
        }
    }

Add a dependency to your app-level `build.gradle`:

    dependencies {
        compile 'com.github.giuseppegiacoppo:proportional-imageview:1.0.2'
    }

Add the `me.giacoppo.proportionalimageview.ProportionalImageView` to your layout XML file.
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">
    
        <me.giacoppo.proportionalimageview.ProportionalImageView
            android:id="@+id/myProportional
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:widthUnits="16"
            app:heightUnits="9" />
    </LinearLayout>
    
##License
    Copyright 2017 Giuseppe Giacoppo
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
