package com.example.jeyoung.hallo

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
import android.view.Window
import kotlinx.android.synthetic.main.activity_sign_up.*
import android.support.v4.view.ViewPager.OnPageChangeListener
import com.example.jeyoung.hallo.signup_fragments.SignUp1
import com.example.jeyoung.hallo.signup_fragments.SignUp2
import com.example.jeyoung.hallo.signup_fragments.SignUpEmail


class SignUpActivity : AppCompatActivity(), SignUpEmail.OnFragmentInteractionListener, SignUp1.OnFragmentInteractionListener, SignUp2.OnFragmentInteractionListener {

    val numPages = 3
    var currentPage = 0;

    //TODO modify pager to disable swipe gestures
    private lateinit var pagerAdaper: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_sign_up)

        pagerAdaper = SignupPagerAdapter(supportFragmentManager)

        viewPager.adapter = pagerAdaper;

        backBtn.setOnClickListener {
            progressBar.setProgress(10, true);
            viewPager.setCurrentItem(0);
        }

        viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                currentPage = position;
                progressBar.setProgress(50 * position, true);
            }
        })

        fun navigateToHomeActivity() {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent);
        }

        nextBtn.setOnClickListener {
            if (currentPage == 2) {
                progressBar.setProgress(30 * currentPage, true);
                navigateToHomeActivity();
                //next activity
            } else {
                viewPager.setCurrentItem(currentPage + 1);
            }

        }
    }

    override fun onFragmentInteraction(uri: Uri) {
        //you can leave it empty
    }

    private class SignupPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getCount(): Int {
            return 3
        }

        override fun getItem(p0: Int): Fragment {
            if (p0 == 1) {
                return SignUp1.newInstance("masdf", "asdf");
            } else if (p0 == 2){
                return SignUp2.newInstance("asdjklf", "kjlasdf");
            } else {
                return SignUpEmail.newInstance("idk", "what this is for");
            }
        }
    }
}
