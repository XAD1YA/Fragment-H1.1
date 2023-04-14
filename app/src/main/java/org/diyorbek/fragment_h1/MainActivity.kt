package org.diyorbek.fragment_h1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import org.diyorbek.fragment_h1.fragment.FragmentFirrst
import org.diyorbek.fragment_h1.fragment.FragmentSecond

class MainActivity : AppCompatActivity(), FragmentFirrst.FirstListener,
    FragmentSecond.SecondListener {
    private lateinit var fragmentFirrst: FragmentFirrst
    private lateinit var fragmentSecond: FragmentSecond
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        fragmentFirrst = FragmentFirrst()
        fragmentSecond = FragmentSecond()

        replaceFragments()
    }

    override fun sentOne(text: Editable) {
        fragmentSecond.twoText(text)
    }

    override fun sendTwo(text: Editable) {
        fragmentFirrst.oneText(text)
    }

    private fun replaceFragments() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.firstFrameLayout, fragmentFirrst)
            replace(R.id.secondFrameLayout, fragmentSecond)
            commit()
        }
    }
}