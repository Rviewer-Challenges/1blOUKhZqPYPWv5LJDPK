package com.christian_magana.twitter_mirroring.data

import com.christian_magana.twitter_mirroring.R

object TweetsProvider {

    private val listReplies: ArrayList<Tweet> = arrayListOf<Tweet>(
        Tweet(
            id = 10,
            imageProfile = R.drawable.ic_male_avatar,
            name ="Avatar 1",
            nickName = "@avatar1",
            verified = false,
            text = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit.",
            datetime_simplified = "· 13 jun.",
            datetime = "5:24 p. m. · 13 jun. 2022",
            nLikes = 2,
            isLiked = false,
            isRetweeted = false,
            nQuoteTweets = 0,
            nRetweets = 0,
        ),
        Tweet(
            id = 20,
            imageProfile = R.drawable.ic_female_avatar,
            name = "Avatar 2",
            nickName = "@avata2",
            verified = false,
            text = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Suspendisse ut metus. Proin venenatis turpis sit amet ante consequat semper.",
            datetime_simplified = "· 20 jun.",
            datetime = "5:24 p. m. · 20 jun. 2022",
            nLikes = 1,
            isLiked = false,
            isRetweeted = false,
            nQuoteTweets = 3,
            nRetweets = 0,
        )
    )

    val listTweets: ArrayList<Tweet> = arrayListOf(
        Tweet(
            id =0,
            imageProfile = R.drawable.musk,
            name = "Elon Musk",
            nickName = "@elonmusk",
            verified = true,
            text = "Humor is one of the great joys of life! @_chrismagaa_",
            datetime_simplified = "· 11 jun.",
            datetime = "5:24 p. m. · 11 jun. 2022",
            nLikes = 200,
            isLiked = false,
            isRetweeted = false,
            nQuoteTweets = 3,
            nRetweets = 0,
            replies = listReplies
        ),
        Tweet(
            id = 1,
            imageProfile = R.drawable.redbull,
            name = "Oracle Red Bull Racing",
            nickName = "@redbullracing",
            verified = true,
            text = "Superhombre! \uD83E\uDDB8\uD83C\uDFFB\u200D♂️",
            datetime_simplified = "· 31 may.",
            datetime = "5:24 p. m. · 31 may. 2022",
            images = arrayListOf(
                R.drawable.superhombre
            ),
            nLikes = 19,
            nRetweets = 60,
            nQuoteTweets = 815,
            isLiked = true,
            isRetweeted = true,
            replies = listReplies
        ),
        Tweet(
            id = 2,
            imageProfile = R.drawable.mouredev,
            name = "Brais Moure",
            nickName = "@MoureDev",
            verified = true,
            text = "Wow! Hoy hemos revisado el directo el reto de programación mensual \uD83D\uDE0D\n" +
                    "\n" +
                    "Teníamos que crear un \"juego de memoria\"... Pues hemos creado 22!\n" +
                    "\n" +
                    "Los tienes todos en GitHub:\n" +
                    "https://github.com/mouredev/Monthly-App-Challenge-2022/blob/main/SolucionesReto05.md\n" +
                    "\n" +
                    "Mil gracias por participar!",
            datetime_simplified = "· 31 may.",
            datetime = "5:24 p. m. · 31 may. 2022",
            images = arrayListOf(
                R.drawable.memory1,
                R.drawable.memory_2,
                R.drawable.memory3,
                R.drawable.memory4
            ),
            nLikes = 48,
            isLiked = true,
            isRetweeted = false,
            nQuoteTweets = 3,
            nRetweets = 6,
            replies = listReplies
        ),
        Tweet(
            id = 3,
            imageProfile = R.drawable.me,
            name = "Christian Magaña",
            nickName = "@_chrismagaa_",
            verified = false,
            text = ":) #dev #android",
            datetime_simplified = "· 10 jun.",
            datetime = "5:24 p. m. · 10 jun. 2022",
            images = arrayListOf(R.drawable.fire),
            nLikes = 234,
            nRetweets = 100,
            nQuoteTweets = 234,
            isLiked = false,
            isRetweeted = false,
            replies = listReplies
        )
    )


}