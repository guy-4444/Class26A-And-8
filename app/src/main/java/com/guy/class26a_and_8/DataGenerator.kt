package com.guy.class26a_and_8

import java.util.Locale

object DataGenerator {
    val games: ArrayList<Game>
        /**
         * Generates the list of games exactly as defined in MyDB.kt
         */
        get() {
            val games = java.util.ArrayList<Game>()

            // Game 1: Temple Tiles
            val avatars1 = java.util.ArrayList<Avatar?>()
            avatars1.add(Avatar().setName("Luna").setDesc("Fast thinker"))
            avatars1.add(Avatar().setName("Bruno").setDesc("Loves combos"))

            val players1 = HashMap<String?, Boolean?>()
            players1.put("Noa", true)
            players1.put("Daniel", false)

            games.add(
                Game()
                    .setId("G1")
                    .setTitle("Temple Tiles")
                    .setGenre(Game.GENRE.PUZZLE)
                    .setReleaseYear(2022)
                    .setRating(4.6)
                    .setMultiplayer(false)
                    .setAvatars(avatars1)
                    .setPlayers(players1)
            )

            // Game 2: Neon Runner
            val avatars2 = java.util.ArrayList<Avatar?>()
            avatars2.add(Avatar().setName("Byte").setDesc("Speed boost"))
            avatars2.add(Avatar().setName("Nova").setDesc("Shield master"))
            avatars2.add(Avatar().setName("Gizmo").setDesc("Trick jumps"))

            val players2 = HashMap<String?, Boolean?>()
            players2.put("Maya", true)
            players2.put("Omer", true)
            players2.put("Eitan", false)

            games.add(
                Game()
                    .setId("G2")
                    .setTitle("Neon Runner")
                    .setGenre(Game.GENRE.ARCADE)
                    .setReleaseYear(2021)
                    .setRating(4.3)
                    .setMultiplayer(true)
                    .setAvatars(avatars2)
                    .setPlayers(players2)
            )

            // Game 3: Coastline Rally
            val avatars3 = java.util.ArrayList<Avatar?>()
            avatars3.add(Avatar().setName("Viper").setDesc("Drift specialist"))
            avatars3.add(Avatar().setName("Hazel").setDesc("Nitro expert"))

            val players3 = HashMap<String?, Boolean?>()
            players3.put("Itay", true)
            players3.put("Shira", true)

            games.add(
                Game()
                    .setId("G3")
                    .setTitle("Coastline Rally")
                    .setGenre(Game.GENRE.RACING)
                    .setReleaseYear(2020)
                    .setRating(4.1)
                    .setMultiplayer(true)
                    .setAvatars(avatars3)
                    .setPlayers(players3)
            )

            // Game 4: Kingdom Tactics
            val avatars4 = java.util.ArrayList<Avatar?>()
            avatars4.add(Avatar().setName("Ares").setDesc("Frontline commander"))
            avatars4.add(Avatar().setName("Iris").setDesc("Scout & intel"))
            avatars4.add(Avatar().setName("Orion").setDesc("Siege engineer"))

            val players4 = HashMap<String?, Boolean?>()
            players4.put("Yuval", true)
            players4.put("Gal", true)
            players4.put("Tamar", false)

            games.add(
                Game()
                    .setId("G4")
                    .setTitle("Kingdom Tactics")
                    .setGenre(Game.GENRE.STRATEGY)
                    .setReleaseYear(2019)
                    .setRating(4.7)
                    .setMultiplayer(true)
                    .setAvatars(avatars4)
                    .setPlayers(players4)
            )

            // Game 5: City Builder Pro
            val avatars5 = java.util.ArrayList<Avatar?>()
            avatars5.add(Avatar().setName("Mason").setDesc("Build faster"))
            avatars5.add(Avatar().setName("Sage").setDesc("Budget planner"))

            val players5 = HashMap<String?, Boolean?>()
            players5.put("Adi", true)

            games.add(
                Game()
                    .setId("G5")
                    .setTitle("City Builder Pro")
                    .setGenre(Game.GENRE.SIMULATION)
                    .setReleaseYear(2023)
                    .setRating(4.4)
                    .setMultiplayer(false)
                    .setAvatars(avatars5)
                    .setPlayers(players5)
            )

            // Game 6: Street Football X
            val avatars6 = java.util.ArrayList<Avatar?>()
            avatars6.add(Avatar().setName("Rocco").setDesc("Power shots"))
            avatars6.add(Avatar().setName("Kira").setDesc("Perfect passes"))

            val players6 = HashMap<String?, Boolean?>()
            players6.put("Lior", true)
            players6.put("Hila", true)
            players6.put("Amit", true)

            games.add(
                Game()
                    .setId("G6")
                    .setTitle("Street Football X")
                    .setGenre(Game.GENRE.SPORTS)
                    .setReleaseYear(2018)
                    .setRating(4.0)
                    .setMultiplayer(true)
                    .setAvatars(avatars6)
                    .setPlayers(players6)
            )

            return games
        }

    val users: ArrayList<User?>
        /**
         * Generates a list of Users based on the players found in the Games list.
         * It maps each game to the correct user.
         */
        get() {
            val allGames = games


            // Map to keep track of created users by name to avoid duplicates
            val userMap = HashMap<String?, User?>()

            for (game in allGames) {
                // Iterate over the players (keys in the hashmap) of this specific game
                for (playerName in game.getPlayers().keys) {
                    // If user doesn't exist yet, create them

                    if (!userMap.containsKey(playerName)) {
                        val newUser = User()
                            .setId("id_" + playerName.lowercase(Locale.getDefault())) // generating a dummy ID
                            .setName(playerName)
                            .setEmail(playerName.lowercase(Locale.getDefault()) + "@example.com") // generating dummy email

                        userMap.put(playerName, newUser)
                    }

                    // Add the current game to this user's list
                    userMap.get(playerName)!!.gameIds.put(game.id, true)
                }
            }

            // Return the values as an ArrayList
            return java.util.ArrayList<User?>(userMap.values)
        }
}