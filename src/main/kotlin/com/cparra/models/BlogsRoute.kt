package com.cparra.models


import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

val blogs = mutableListOf<Blog>()

fun Application.registerBlogsRoute(){
    routing {
        route("/blogs"){
            addBlogRoute()
            getBlogsRoute()
            //deleteBlogRoute()
        }
    }

}

fun Route.addBlogRoute() {
    post {
        val blog = call.receive<Blog>()
        blogs.add(blog)
        call.respond(HttpStatusCode.Created, "Blog Saved")
    }
}


fun Route.getBlogsRoute(){
    get {
        if (blogs.isNotEmpty()){
            call.respond(HttpStatusCode.OK, blogs)
        }else{
            call.respond(HttpStatusCode.NotFound, "No blogs found")
        }
    }
}

