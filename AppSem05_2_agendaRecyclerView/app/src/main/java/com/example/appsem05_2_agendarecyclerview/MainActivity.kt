package com.example.appsem05_2_agendarecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var contacts = ArrayList<Contact>()

    //creando el adapter
    var contactAdapter = ContactAdapter(contacts)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadContacts()
        initView()
    }

    private fun initView() {
        val rvContact = findViewById<RecyclerView>(R.id.rdContact)

        rvContact.adapter = contactAdapter
        rvContact.layoutManager = LinearLayoutManager(this)
    }

    private fun loadContacts() {
        contacts.add(Contact("Arturo B.", "123456789"))
        contacts.add(Contact("Ronald V.", "987654321"))
        contacts.add(Contact("Arturo B.", "123456789"))
        contacts.add(Contact("Ronald V.", "987654321"))
        contacts.add(Contact("Arturo B.", "123456789"))
        contacts.add(Contact("Ronald V.", "987654321"))
        contacts.add(Contact("Arturo B.", "123456789"))
        contacts.add(Contact("Ronald V.", "987654321"))
        contacts.add(Contact("Arturo B.", "123456789"))
        contacts.add(Contact("Ronald V.", "987654321"))
        contacts.add(Contact("Arturo B.", "123456789"))
        contacts.add(Contact("Ronald V.", "987654321"))
        contacts.add(Contact("Arturo B.", "123456789"))
        contacts.add(Contact("Ronald V.", "987654321"))
        contacts.add(Contact("Arturo B.", "123456789"))
        contacts.add(Contact("Ronald V.", "987654321"))
    }
}