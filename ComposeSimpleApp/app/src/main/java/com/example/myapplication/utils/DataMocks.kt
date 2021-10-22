package com.example.myapplication.utils

import com.example.myapplication.R
import com.example.myapplication.model.Post
import com.example.myapplication.model.User

object DataMocks {

    val currentUser = User(
        1,
        "Todd Howard",
        R.drawable.profilepic,
        10,
        3,
        14,
        "Game director of Bethesda Game Studios. Creator of Skyrim and recursive functions which helped with recursive functions which helped with recursive functions which helped with recursive functions which helped with recursive functions which helped with recursive functions."
    )
    
    val textSamples = listOf("Mauris non ante id massa elementum lobortis. Morbi faucibus eros sit amet lectus convallis mollis sed sit amet nisi.Mauris et turpis a urna luctus scelerisque.",
            "Nullam quis risus ut odio laoreet dictum. Etiam pellentesque velit id ipsum placerat ornare. Quisque venenatis lacus nec sem pharetra aliquam.",
            "Curabitur facilisis nunc pellentesque augue lacinia, vitae placerat nibh dictum. Aliquam vel dolor sit amet sem eleifend pharetra vel non enim. Donec eget diam quis felis varius rutrum. Mauris viverra mauris at mauris vulputate, ac fermentum quam luctus. Phasellus vitae ante eu ex efficitur tincidunt. Morbi eget odio porta sapien ullamcorper ultrices. Etiam sit amet felis lacinia, interdum massa vel, pretium eros. Donec quis turpis sit amet nibh aliquam facilisis. Phasellus eleifend felis et urna dignissim varius. Sed sagittis sapien molestie mauris tempus fringilla. Vivamus at velit iaculis, consectetur felis in, imperdiet est. Quisque vitae sapien at magna viverra vehicula non et sem. Nam rutrum mauris quis velit sollicitudin ultrices. Vivamus vitae enim a mauris tempor egestas. Duis consectetur justo ac augue aliquam lobortis. Duis suscipit dui non dui placerat, non lacinia diam mollis.",
            "Nunc et libero dapibus, maximus diam malesuada, bibendum ligula.",
            "Nullam et nulla eu enim mollis tempus.",
            "Nulla quis dolor et nulla venenatis facilisis.",
            "Etiam id purus eget quam tempor efficitur.",
            "Nulla feugiat arcu non efficitur finibus.",
            "Nam ultrices purus vel dui tincidunt sollicitudin.",
            "Morbi tincidunt odio quis velit finibus varius.",
            "Sed ornare odio ac maximus suscipit.",
            "Proin rutrum mi molestie urna pretium venenatis.",
            "Proin quis justo tristique, ultrices sem in, imperdiet lectus.",
            "Nam at libero suscipit, auctor ex a, finibus dolor.",
            "Duis sed est nec lectus facilisis congue.",
            "Pellentesque eget elit eget velit vestibulum consequat eget id quam.",
            "Suspendisse ut nisl laoreet, pellentesque leo a, luctus sem.",
            "Curabitur ut nulla et risus lacinia pharetra.",
            "Morbi placerat nunc sed erat rutrum aliquam.",
            "Nunc vel neque interdum ligula sagittis tempor at in eros.",
            "Nam tristique neque id neque porta porttitor.",
            "Cras elementum tellus ut justo venenatis sagittis.",
            "Ut commodo nisl quis metus facilisis, vel laoreet nulla luctus.",
            "Aenean ut tortor consequat, convallis tortor in, fermentum sapien.",
            "Vivamus interdum lacus quis vestibulum posuere.",
            "Praesent ac est vitae lorem dapibus placerat ac in mauris.",
            "Vivamus convallis diam elementum urna rutrum, sed pulvinar velit bibendum.",
            "Donec eget neque id leo mattis facilisis eget sit amet sem.",
            "Morbi ut risus facilisis, tristique orci in, efficitur nisi.",
            "Quisque feugiat purus ac varius lacinia.",
            "Nullam ornare nibh eu ipsum lacinia sagittis.",
            "Sed rutrum nulla eu est pharetra, sit amet ultricies erat dignissim.")

    val postsList = List(30) {
        Post(
            it.toUInt(),
            1u,
            null,
                currentUser.name,
            "${it + 1} Dec 2020",
            textSamples[it],
            listOf()
        )
    }
}