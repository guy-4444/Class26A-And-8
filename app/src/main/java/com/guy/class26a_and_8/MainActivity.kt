package com.guy.class26a_and_8

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.database.getValue
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.guy.class26a_and_8.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var userGames: MutableList<Game> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnUpdate.setOnClickListener {
            update()
        }

        binding.btnPrint.setOnClickListener {
            print()
        }

        binding.btnMail.setOnClickListener {
            btnMail()
        }

        binding.btnSignOut.setOnClickListener {
            signOut()
        }

        //updateUserUI()


        binding.btnUpdateF.setOnClickListener {
            updateUserDetails()
        }

        binding.btnLike.setOnClickListener {
//            increaseLike("KaQkpHWoF5MD9mOwjlAN")
            increaseLike(Firebase.auth.uid!!)
        }

        val db = Firebase.firestore
        val docRef = db.collection("users").document(Firebase.auth.uid!!)
        docRef.addSnapshotListener { snapshot, e ->
            if (e != null) {
                return@addSnapshotListener
            }

            binding.lblInfo.text = "likes: ${snapshot?.data?.get("likes")}"
        }
    }

    private fun updateUserUI() {
        val user = Firebase.auth.currentUser
        if (user != null) {
            binding.lblInfo.text = "${user.email} ${user.uid}"
        }
    }

    private fun signOut() {
        Firebase.auth.signOut()
    }

    private fun btnMail() {
        val myRef = Firebase.database.getReference("users").child("id_eitan").child("email")
        myRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue<String>()
                Log.d("pttt", "the email is: $value")

                emailReturned(value)
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("pttt", "Failed to read value.", error.toException())
            }
        })

    }

    private fun print() {
        val database = Firebase.database
        val myRef = database.getReference("users").child("id_eitan")

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue<User>()
                Log.d("pttt", "Value is: $value")
                printUserData(value)

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("pttt", "Failed to read value.", error.toException())
            }
        })
    }

    private fun printUserData(value: User?) {
        for (gameId in value?.gameIds!!) {
            val myRef = Firebase.database.getReference("games").child(gameId.key)
            myRef.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    val game = dataSnapshot.getValue<Game>()
                    Log.d("pttt", "Value is: $value")
                    userGames.add(game!!)
                    updateUI()
                }

                override fun onCancelled(error: DatabaseError) {
                    // Failed to read value
                    Log.w("pttt", "Failed to read value.", error.toException())
                }
            })


        }
    }

    private fun updateUI() {
        var str = ""
        for (game in userGames) {
            str += "${game.id} ${game.title} ${game.rating} \n"
        }
        binding.lblInfo.text = str
    }

    private fun emailReturned(value: String?) {
        binding.lblInfo.text = value.toString()
    }

    private fun update() {
        var games = DataGenerator.games
        var users = DataGenerator.users

        users[0]?.gameIds?.put(games[2].id, true)
        users[0]?.gameIds?.put(games[3].id, true)


        val database = Firebase.database
        val myRef = database.getReference("games")
        for (game in games) {
            myRef.child(game.id).setValue(game)
        }

        val myRef2 = database.getReference("users")
        for (user in users) {
            myRef2.child(user?.id!!).setValue(user)
        }

    }


    private fun increaseLike(userUid: String) {
        val db = Firebase.firestore
        db.collection("users")
            .document(userUid)
            .update("likes", FieldValue.increment(1))

    }

    private fun updateUserDetails() {
        val userUid: String = Firebase.auth.uid!!

        val user = hashMapOf(
            "first" to "Ada",
            "last" to "Lovelace",
            "born" to 2002,
        )

        val db = Firebase.firestore
        db.collection("users")
            .document(userUid)
            .set(user)
    }

}