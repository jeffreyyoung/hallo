package com.example.jeyoung.hallo

import android.net.Uri
import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.example.jeyoung.hallo.dummy.DummyContent
import com.example.jeyoung.hallo.homefragments.*
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(),
        FeedFragment.OnListFragmentInteractionListener,
        FriendsFragment.OnFragmentInteractionListener,
        HalloFragment.OnFragmentInteractionListener,
        MessagesFragment.OnFragmentInteractionListener,
        SearchFragment.OnFragmentInteractionListener {

    private var fragments = HashMap<Int, Fragment>();

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        switchToFragment(item.itemId);

        return@OnNavigationItemSelectedListener true
    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
        //
    }

    override fun onFragmentInteraction(uri: Uri) {

    }


    fun switchToFragment(itemId: Int) {
        if (fragments.size == 0) {
            buildFragmentsList();
        }
        if (fragments.containsKey(itemId)) {
            val selectedFragment =  fragments.get(itemId)!!; //https://stackoverflow.com/questions/39349700/convert-a-nullable-type-to-its-non-nullable-type
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentHolder, selectedFragment)
                    .commit()
        }
    }

    fun buildFragmentsList() {
        fragments.put(R.id.navigation_feed, FeedFragment.newInstance((1)));
        fragments.put(R.id.navigation_messages, MessagesFragment.newInstance("asdf", "asdf"));
        fragments.put(R.id.navigation_hallo, HalloFragment.newInstance("asdf", "asdf"));
        fragments.put(R.id.navigation_friends, FriendsFragment.newInstance("asdf", "asdf"));
        fragments.put(R.id.navigation_friends, SearchFragment.newInstance("asdf", "asdf"));
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        switchToFragment(R.id.navigation_feed);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
