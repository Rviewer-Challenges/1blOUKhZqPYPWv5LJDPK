package com.christian_magana.twitter_mirroring

import com.christian_magana.twitter_mirroring.model.Tweet

object TweetsProvider {

    val listTweets: ArrayList<Tweet> = arrayListOf(
        Tweet(
            R.drawable.musk,
            "Elon Musk",
            "@elonmusk",
            true,
            "Humor is one of the great joys of life!",
            "· 11 jun.",
            null,
            2,
            3,
            0
        ),
        Tweet(
            R.drawable.redbull,
            "Oracle Red Bull Racing",
            "@redbullracing",
            true,
            "Superhombre! \uD83E\uDDB8\uD83C\uDFFB\u200D♂️",
            "· 31 may.",
            arrayListOf(
                R.drawable.superhombre
            ),
            19,
            60,
            815
        ),
        Tweet(
            imageProfile = R.drawable.mouredev,
            name = "Brais Moure",
            userName = "@MoureDev",
            verified = true,
            text = "Wow! Hoy hemos revisado el directo el reto de programación mensual \uD83D\uDE0D\n" +
                    "\n" +
                    "Teníamos que crear un \"juego de memoria\"... Pues hemos creado 22!\n" +
                    "\n" +
                    "Los tienes todos en GitHub:\n" +
                    "https://github.com/mouredev/Monthly-App-Challenge-2022/blob/main/SolucionesReto05.md\n" +
                    "\n" +
                    "Mil gracias por participar! \n" +
                    "Preparad@s para el reto de Junio? YA ESTÁ DISPONIBLE!!!",
            time = "· 31 may.",
            images = arrayListOf(
                R.drawable.memory1,
                R.drawable.memory_2,
                R.drawable.memory3,
                R.drawable.memory4
            ),
            likes = 48,
            comments = 3,
            retweets = 6
        ),
        Tweet(
            R.drawable.me,
            "Christian Magaña",
            "@_chrismagaa_",
            false,
            ":) #dev #android",
            "· 10 jun.",
            arrayListOf(R.drawable.fire),
            234,
            100,
            234
        )
    )


}