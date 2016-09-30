#SmoothAnimateToolbar


A custom Toolbar with animation for Android.

### Usage
	
##### Edit your layout XML:
~~~ xml
<cn.refactor.smoothanimatetoolbar.SmoothAnimateToolbar
        xmlns:satb="http://schemas.android.com/apk/res-auto"
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="60dp"
        satb:animDuration="800"
        satb:scrollThreshold="10">
        ...
</cn.refactor.smoothanimatetoolbar.SmoothAnimateToolbar>
~~~

##### If you want to use with SmoothScrollView, edit your layout XML:
~~~ xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
	
	<cn.refactor.smoothanimatetoolbar.SmoothScrollView
        android:id="@+id/scrollView"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        ...
    </cn.refactor.smoothanimatetoolbar.SmoothScrollView>
    
    <cn.refactor.smoothanimatetoolbar.SmoothAnimateToolbar
        xmlns:satb="http://schemas.android.com/apk/res-auto"
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="60dp"
        satb:animDuration="800"
        satb:scrollThreshold="10">
        ...
    </cn.refactor.smoothanimatetoolbar.SmoothAnimateToolbar>
	    
</FrameLayout>
~~~

##### Java code:
```java
mToolbar.attachToScrollView(smoothScrollView);
```
```java
mToolbar.attachToRecyclerView(recyclerView);
```
```java
mToolbar.attachToListView(listView);
```
```java
mToolbar.attach(view); // SmoothScrollView or SmoothWebView or RecyclerView or ListView
```

```java
mToolbar.show();
```

```java
mToolbar.hide();
```

##### Credits
  [FloatingActionButton](https://github.com/makovkastar/FloatingActionButton)

### License

    Copyright 2016 andy

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.