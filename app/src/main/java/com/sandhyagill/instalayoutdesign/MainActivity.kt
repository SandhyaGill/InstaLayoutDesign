package com.sandhyagill.instalayoutdesign


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.core.graphics.drawable.toDrawable
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sandhyagill.instalayoutdesign.adapters.RecyclerStoriesAdapter
import com.sandhyagill.instalayoutdesign.databinding.ActivityMainBinding
import com.sandhyagill.instalayoutdesign.modules.Stories

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var controller: NavController
    lateinit var appBarConfiguration : AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        controller = findNavController(R.id.fragment)

        appBarConfiguration =
            AppBarConfiguration(setOf(R.id.homeFragment, R.id.searchFragment, R.id.addFragment, R.id.reelsFragment, R.id.accountFragment))
        setupActionBarWithNavController(controller, appBarConfiguration)

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menuHome -> {
                    controller.navigate(R.id.homeFragment)
                }
                R.id.menuSearch -> {
                    controller.navigate(R.id.searchFragment)
                }
                R.id.menuAdd -> {
                    controller.navigate(R.id.addFragment)
                }
                R.id.menuReels -> {
                    controller.navigate(R.id.reelsFragment)
                }
                R.id.menuAccount -> {
                    controller.navigate(R.id.accountFragment)
                }
            }
            return@setOnItemSelectedListener true
        }
        controller.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> binding.bottomNavigation.menu.getItem(0).isChecked = true
                R.id.searchFragment -> binding.bottomNavigation.menu.getItem(1).isChecked = true
                R.id.addFragment -> binding.bottomNavigation.menu.getItem(2).isChecked = true
                R.id.reelsFragment -> binding.bottomNavigation.menu.getItem(3).isChecked = true
                R.id.accountFragment -> binding.bottomNavigation.menu.getItem(4).isChecked = true
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {

        return super.onSupportNavigateUp()|| controller.popBackStack()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.side_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}