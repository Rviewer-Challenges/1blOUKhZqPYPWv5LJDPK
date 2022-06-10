package com.christian_magana.twitter_mirroring

import com.christian_magana.twitter_mirroring.model.Tweet

object TweetsProvider {

    val listTweets: ArrayList<Tweet> = arrayListOf(
        Tweet(R.drawable.ic_female_avatar,"Christian Magaña", "@_chrismg_", false, "HOLA MUNDO :)", "· 2h", null, 2, 3, 0),
        Tweet(
            R.drawable.ic_male_avatar,
            "Brais Moure",
            "@MoureDev",
            true,
            "Vamos a crear una splash screen en Android Studio utilizando Jetpack Compose y Kotlin.",
            "· 3 jun.",
            arrayListOf(
                R.drawable.ic_home_twitter
            ),
            79,
            3,
            22
        ),
        Tweet(
            R.drawable.ic_male_avatar,
            "Brais Moure",
            "@MoureDev",
            true,
            "\uD83D\uDCF2 Creado por Google en 2011, Dart ha ganado gran popularidad desde la aparición en 2017 de Flutter, el SDK de desarrollo de aplicaciones multiplataforma para iOS y Android (y también Webs, apps de escritorio y juegos).\n" +
                    "\n" +
                    "▶️ Te lo explico en vídeo:\n" +
                    "https://youtu.be/W-AwQpWM4f0",
            "· 2h",
            arrayListOf(
                R.drawable.ic_home_twitter,
                R.drawable.ic_home_twitter,
                R.drawable.ic_home_twitter,
                R.drawable.ic_home_twitter
            ),
            48,
            3,
            6
        ),

        )

}