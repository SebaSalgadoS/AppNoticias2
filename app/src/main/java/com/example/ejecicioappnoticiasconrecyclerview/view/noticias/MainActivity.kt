package com.example.ejecicioappnoticiasconrecyclerview.view.noticias

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import com.example.ejecicioappnoticiasconrecyclerview.*
import com.example.ejecicioappnoticiasconrecyclerview.databinding.ActivityMainBinding
import com.example.ejecicioappnoticiasconrecyclerview.view.fragnoticias.*
import com.example.ejecicioappnoticiasconrecyclerview.view.usuario.Login
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {

    lateinit var binding: ActivityMainBinding

    private lateinit var toogle: ActionBarDrawerToggle
    lateinit var myToolbar: Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_EjecicioAppNoticiasConRecyclerView)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myNavigationView2.setNavigationItemSelectedListener(this)

        myToolbar = findViewById(R.id.myToolbar)

        supportFragmentManager.beginTransaction().add(R.id.myFrame, FragHomeNoticias()).commit()

        setSupportActionBar(myToolbar)


        toogle = setDrawerToogle()
        binding.myDrawerLayout2.addDrawerListener(toogle)


    }

    private fun setDrawerToogle(): ActionBarDrawerToggle {
        return ActionBarDrawerToggle(this, binding.myDrawerLayout2, myToolbar, R.string.drawer_open, R.string.drawer_close)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toogle.onConfigurationChanged(newConfig)
    }

    override fun onPostCreate( savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toogle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (toogle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        when (item.itemId) {
            R.id.navHome -> ft.replace(R.id.myFrame, FragHomeNoticias()).commit()
            R.id.navDeportes -> ft.replace(R.id.myFrame, FragDeportes()).commit()
            R.id.navCiencias -> ft.replace(R.id.myFrame, FragCiencia()).commit()
            R.id.navNegocios -> ft.replace(R.id.myFrame, FragNegocios()).commit()
            R.id.navTecnologia -> ft.replace(R.id.myFrame, FragTecnologia()).commit()
            R.id.navSalud -> ft.replace(R.id.myFrame, FragSalud()).commit()
            R.id.navEntretenimiento -> ft.replace(R.id.myFrame, FragEntretenimiento()).commit()
            R.id.navIdioma ->  Toast.makeText(applicationContext,"Idioma", Toast.LENGTH_SHORT).show()
            R.id.navSalir -> {
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
            }

        }


        title = item.title //para mostrar el título
        binding.myDrawerLayout2.closeDrawers() //para cerrar drawer

        return true
    }

}

