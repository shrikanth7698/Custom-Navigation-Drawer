![alt text](https://drive.google.com/uc?id=1frkB2g3FGLCBDN6icLGAJ9NM_k4mhCcD)
[![forthebadge](https://forthebadge.com/images/badges/built-with-love.svg)](https://forthebadge.com)

[![forthebadge](https://forthebadge.com/images/badges/built-for-android.svg)](https://forthebadge.com)

[![forthebadge](https://forthebadge.com/images/badges/built-with-swag.svg)](https://forthebadge.com)

<a href='https://ko-fi.com/O5O2BPL1' target='_blank'><img height='36' style='border:0px;height:36px;' src='https://az743702.vo.msecnd.net/cdn/kofi2.png?v=0' border='0' alt='Buy Me a Coffee at ko-fi.com' /></a>

It has smooth zoom-in, zoom-out animation when switched from one fragment to another.

## Repo no longer being maintained.

[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-Custom%20Navigation%20Drawer-green.svg?style=flat )]( https://android-arsenal.com/details/1/6876 )
  
  ### Version
[![](https://jitpack.io/v/shrikanth7698/Custom-Navigation-Drawer.svg)](https://jitpack.io/#shrikanth7698/Custom-Navigation-Drawer)

### Installation

* **Gradle**

	Add it in your root build.gradle at the end of repositories:
	```gradle
  allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	```

	Add the dependency in your app build.gradle
	```gradle
  dependencies {
	        compile 'com.github.shrikanth7698:Custom-Navigation-Drawer:v0.0.1'
	}
	```

* **Maven**

	Add the JitPack repository to your build file
	```gradle
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
	```

	Add the dependency
	```gradle
  <dependency>
	    <groupId>com.github.shrikanth7698</groupId>
	    <artifactId>Custom-Navigation-Drawer</artifactId>
	    <version>v0.0.1</version>
	</dependency>
	```
  
### Usage

Drop the Custom Navigation Drawer in your XML layout as is shown below:
```xml
    <com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/navigationDrawer">
        <FrameLayout
            android:id="@+id/frameLayout"
            android:layout_width="match_parent"
            android:layout_height="match_parent"/>

    </com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer>
```
And then in your Activity or fragment
```java
        //Global Declaration
        SNavigationDrawer sNavigationDrawer;
        Class fragmentClass;
        public static Fragment fragment;
        
        //Inside onCreate()
        
        sNavigationDrawer = findViewById(R.id.navigationDrawer);
        
        //Creating a list of menu Items
        
        List<MenuItem> menuItems = new ArrayList<>();
        
        //Use the MenuItem given by this library and not the default one.
        //First parameter is the title of the menu item and then the second parameter is the image which will be the background of the menu item.
        
        menuItems.add(new MenuItem("News",R.drawable.news_bg));
        menuItems.add(new MenuItem("Feed",R.drawable.feed_bg));
        menuItems.add(new MenuItem("Messages",R.drawable.message_bg));
        menuItems.add(new MenuItem("Music",R.drawable.music_bg));
        
        //then add them to navigation drawer
        
        sNavigationDrawer.setMenuItemList(menuItems);
        fragmentClass =  NewsFragment.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout, fragment).commit();
        }
        
        

        //Listener to handle the menu item click. It returns the position of the menu item clicked. Based on that you can switch between the fragments.
        
        sNavigationDrawer.setOnMenuItemClickListener(new SNavigationDrawer.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClicked(int position) {
                System.out.println("Position "+position);

                switch (position){
                    case 0:{
                        fragmentClass = NewsFragment.class;
                        break;
                    }
                    case 1:{
                        fragmentClass = FeedFragment.class;
                        break;
                    }
                    case 2:{
                        fragmentClass = MessagesFragment.class;
                        break;
                    }
                    case 3:{
                        fragmentClass = MusicFragment.class;
                        break;
                    }

                }
                
                //Listener for drawer events such as opening and closing.
                sNavigationDrawer.setDrawerListener(new SNavigationDrawer.DrawerListener() {

                    @Override
                    public void onDrawerOpened() {

                    }

                    @Override
                    public void onDrawerOpening(){

                    }

                    @Override
                    public void onDrawerClosing(){
                        System.out.println("Drawer closed");

                        try {
                            fragment = (Fragment) fragmentClass.newInstance();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        if (fragment != null) {
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout, fragment).commit();

                        }
                    }

                    @Override
                    public void onDrawerClosed() {

                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        System.out.println("State "+newState);
                    }
                });
            }
        });
```

### Customization


```xml
    <com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:navigationDrawerBackgroundColor="#151515"
        app:appbarTitleTextColor="@android:color/white"
        app:HamMenuIconTintColor="@android:color/white"
        app:appbarColor="@android:color/black"
        app:primaryMenuItemTextColor="@android:color/white"
        app:secondaryMenuItemTextColor="@android:color/white"
        app:appbarTitleTextSize="7sp"
        app:primaryMenuItemTextSize="7sp"
        app:secondaryMenuItemTextSize="7sp"
        android:id="@+id/navigationDrawer">
        <FrameLayout
            android:id="@+id/frameLayout"
            android:background="@android:color/black"
            android:layout_width="match_parent"
            android:layout_height="match_parent"/>

    </com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer>
      
```

### Developed by
<div class="LI-profile-badge"  data-version="v1" data-size="medium" data-locale="en_US" data-type="horizontal" data-theme="light" data-vanity="shrikanthravi"><a class="LI-simple-link" href='https://in.linkedin.com/in/shrikanthravi?trk=profile-badge'>Shrikanth Ravi</a></div>

  
### License
```
MIT License

Copyright (c) 2018 Shrikanth Ravi

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
