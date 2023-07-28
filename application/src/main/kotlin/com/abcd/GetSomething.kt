package com.abcd

import com.abcd.application.graphql.types.Something
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData

@DgsComponent
class GetSomething {

    @DgsData(parentType = "Query", field = "influencerYoutubeAnalyticsSponsoredPostsCount")
    fun handle(
        accountId: Long,
        keyword: String?
    ): Something {
        println(accountId)
        println(keyword)
        val s: Long = 1L
        val js: java.lang.Long = java.lang.Long.valueOf(s)
        return Something(name=js)
    }
}