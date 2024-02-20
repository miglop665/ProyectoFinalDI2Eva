package com.example.proyectofinaldi

class DatosSP {

    fun darDatos(nombreDatos: String?):Map<String, String> {
        var datos: Map<String, String>
        when (nombreDatos) {
            "harry_potter_y_la_piedra_filosofal" -> {
                datos = mapOf(
                    "foto" to "@drawable/harry_potter_y_la_piedra_filosofal",
                    "sinopsis" to "Harry Potter es un niño huérfano criado por su tío Vernon y su tía Petunia que lo odian. Desde que era pequeño, estos siempre le han contado que sus padres murieron en un accidente de coche.\n" +
                            "El día de su decimoprimer cumpleaños, Harry recibe la inesperada visita de un hombre gigantesco de nombre Rubeus Hagrid. Este le revela que es, de hecho, hijo de dos poderosos magos y que él también posee extraordinarios poderes.\n" +
                            "Lleno de alegría, el chico acepta ir a estudiar a Hogwarts, el famoso colegio de magia y hechicería. Por fin, tiene la oportunidad de hacer amigos. Odiado por Severus Snape, profesor de Pociones, y protegido por Albus Dumbledore, director del colegio, Harry intentará dilucidar el misterio de la piedra filosofal.",
                    "trailer" to "harry_potter_y_la_piedra_filosofal"
                )
            }

            "harry_potter_y_el_prisionero_de_azkaban" -> {
                datos = mapOf(
                    "foto" to "@drawable/harry_potter_y_el_prisionero_de_azkaban",
                    "sinopsis" to "Cuando Harry Potter y sus amigos vuelven a Hogwarts para cursar su tercer año de estudios," +
                            " se ven involucrados en un misterio: de la prisión para magos de Azkaban se ha fugado Sirius Black, un peligroso mago que fue cómplice de Lord Voldemort y que intentará vengarse de Harry Potter. " +
                            "El joven aprendiz de mago contribuyó en gran medida a la condena de Sirius, por lo que hay razones para temer por su vida.",
                    "trailer" to "harry_potter_y_el_prisionero_de_azkaban"
                )
            }

            "harry_potter_y_el_caliz_de_fuego" -> {
                datos = mapOf(
                    "foto" to "@drawable/harry_potter_y_el_caliz_de_fuego",
                    "sinopsis" to "Harry Potter empieza a tener sueños  donde escucha como Lord Voldemort conspira junto con Peter Pettigrew y un chico joven que también se encuentra en la casa. A todo esto, Howards se prepara para el Torneo de los Tres magos," +
                            " donde participan las tres escuelas de magia más famosas de Europa: Hogwarts, Beauxbatons y Durmstrang. Existe una ley que establece que para participar en estas pruebas se debe tener, al menos, 17 años. Sin embargo, una mano misteriosa provoca que Harry, con tan solo 14 años, sea elegido para participar. " +
                            "Aunque Dumbledore y Minerva McGonagall se oponen, dejan que el joven participe hasta que se aclare el asunto y se sepa porque no se han respetado las reglas. También asignan al nuevo profesor de artes oscuras, Alastor Moody, a que vigile a Harry hasta que finalice el torneo.\n" +
                            "Sirius Black, padrino de Harry Potter, advierte al joven de que no puede ser casualidad lo que ha ocurrido, sospechando que el director de Durmstrang, antiguo mortífago, haya preparado una trampa en cuyo trasfondo puede estar Voldemort.",
                    "trailer" to "harry_potter_y_el_caliz_de_fuego"
                )
            }

            "fast_and_furious_tokyo_drift" -> {
                datos = mapOf(
                    "foto" to "@drawable/fast_and_furious_tokyo_drift",
                    "sinopsis" to "Shaun Boswell es un chico que no acaba de encajar en ningún grupo. En el instituto es un solitario, su única conexión con el mundo de indiferencia que le rodea es a través de las carreras ilegales, lo que no le ha convertido en el chico favorito de la policía. Cuando amenazan con encarcelarle," +
                            " le mandan fuera del país a pasar una temporada con su padre, un militar destinado en Japón, que vive en un diminuto piso en un barrio barato de Tokio. En el país donde nacieron la mayoría de los coches modificados, las simples carreras en la calle principal han sido sustituidas por el último reto automovilístico que desafía la gravedad," +
                            " las carreras de \"drift\" (arrastre), una peligrosa mezcla de velocidad en pistas con curvas muy cerradas y en zigzag. En su primera incursión en el salvaje mundo de las carreras de \"drift\", Shaun acepta ingenuamente conducir un D.K, el Rey del Drift, que pertenece a los Yakuza, la mafia japonesa. Para pagar su deuda," +
                            " no tiene más remedio que codearse con el hampa de Tokio y jugarse la vida.",
                    "trailer" to "fast_and_furious_tokyo_drift"
                )
            }

            "gremlins" -> {
                datos = mapOf(
                    "foto" to "@drawable/gremlins",
                    "sinopsis" to "El joven Billy Peltzer (Zach Galligan) recibe un regalo bastante inusual por Navidad. Su padre, un despistado inventor, le compra una extraña mascota cuyo nombre es Mogwai. " +
                            "A pesar de su aspecto bondadoso y achuchable, hay que tener un especial cuidado con la mascota. Es importante que no entre en contacto con el agua y, sobre todo, que no coma después de las doce de la noche. Pero por un descuido, " +
                            "Mogwai se moja y de él salen varios compañeros iguales que él, claro que esta vez son un poco perversos. Esta pandilla de gamberras criaturas harán todo lo posible por comer pasada la media noche.",
                    "trailer" to "gremlins"
                )
            }

            "spiderman_homecoming" -> {
                datos = mapOf(
                    "foto" to "@drawable/spiderman_homecoming",
                    "sinopsis" to "Peter Parker (Tom Holland, Uncharted) es un adolescente que estudia en la escuela secundaria mientras lidia con los problemas típicos de un chico de su edad. Aunque en realidad su día a día no es del todo normal. " +
                            "Y es que Peter esconde una identidad secreta, la de Spiderman. Así que tiene que compaginar su vida en el instituto con su labor de superhéroe que se enfrenta a todos aquellos villanos que ponen en peligro la ciudad, sin ser descubierto.\n" +
                            "\n" + "Emocionado tras haber luchado con Los Vengadores, Peter regresará a su rutina junto a su tía May (Marisa Tomei), pero la adaptación no será tan fácil como parecía. Por suerte contará con la ayuda de Tony Stark (Robert Downey Jr.), su ahora amigo y mentor, que le recomendará mantenerse alejado de los problemas. " +
                            "No obstante, esto se volverá una tarea imposible cuando un nuevo enemigo, conocido como El Buitre (Michael Keaton), amenace a Peter y a sus seres queridos.",
                    "trailer" to "spiderman_homecoming"
                )
            }

            "juego_de_tronos" -> {
                datos = mapOf(
                    "foto" to "@drawable/juego_de_tronos",
                    "sinopsis" to "La historia se desarrolla en un mundo ficticio de carácter medieval donde hay Siete Reinos. Hay tres líneas argumentales principales: la crónica de la guerra civil dinástica por el control de Poniente entre varias familias nobles que aspiran al Trono de Hierro; la creciente amenaza de \"los otros\", " +
                            "seres desconocidos que viven al otro lado de un inmenso muro de hielo que protege el Norte de Poniente; y el viaje de Daenerys Targaryen, la hija exiliada del rey que fue asesinado en una guerra civil anterior, y que pretende regresar a Poniente para reclamar sus derechos dinásticos. Tras un largo verano de varios años, el temible invierno se acerca a los Siete Reinos. " +
                            "Lord Eddard 'Ned' Stark, señor de Invernalia, deja sus dominios para ir a la corte de su amigo, el rey Robert Baratheon, en Desembarco del Rey, la capital de los Siete Reinos. Stark se convierte en la Mano del Rey e intenta desentrañar una maraña de intrigas que pondrá en peligro su vida y la de todos los suyos. Mientras tanto, diversas facciones conspiran con un solo objetivo: apoderarse del trono.",
                    "trailer" to "juego_de_tronos"
                )
            }

            "house" -> {
                datos = mapOf(
                    "foto" to "@drawable/house",
                    "sinopsis" to "Gregory House, el mejor médico del hospital, es un hombre antipático que está especializado en el diagnóstico de enfermedades. " +
                            "Su carácter extravagante, su rebeldía y su honradez con los pacientes y su equipo lo convierten en una persona única. " +
                            "Trata de evitar la relación con los pacientes, porque lo que le interesa por encima de todo es la investigación de las enfermedades. " +
                            "Es además adicto a los calmantes y a las series de hospitales.",
                    "trailer" to "house"
                )
            }

            "death_note" -> {
                datos = mapOf(
                    "foto" to "@drawable/death_note",
                    "sinopsis" to "Death Note cuenta la historia sobre un joven llamado Yagami Light. Un aburrido día de clase ve caer un cuaderno negro en el patio de su escuela, titulado Death Note. " +
                            "Según las instrucciones escritas en el mismo cuaderno, aquella persona cuyo nombre sea escrito en dicho cuaderno, morirá. En un principio se cree que es una de esas estúpidas cadenas... pero “Kira”, como será reconocido por las masas, prueba el Death Note... y efectivamente, funciona. " +
                            "Light decide usar el cuaderno desde el anonimato, para limpiar el mundo de todos los criminales que merezcan morir, reinando así la paz y la tranquilidad. Todas las fuerzas de protección internacional están en alerta, pero la Interpol tiene un as en la manga: L, " +
                            "un detective de identidad oculta que ha logrado solucionar casos que se daban por irresolubles. ¿Que pasara con Light y ambicioso proyecto? ¿Podrá L desenmascararle?",
                    "trailer" to "death_note"
                )
            }

            "simpsons" -> {
                datos = mapOf(
                    "foto" to "@drawable/simpsons",
                    "sinopsis" to "Narra la historia de una peculiar familia (Homer, Marge, Bart, Maggie y Lisa Simpson) y otros divertidos personajes de la localidad norteamericana de Springfield. " +
                            "Homer, el padre, es un desastroso inspector de seguridad de una central nuclear. Marge, la madre, es un ama de casa acostumbrada a soportar a su peculiar familia. Bart, de 10 años, intenta divertirse con travesuras de todo tipo. " +
                            "Lisa es la más inteligente de la familia, y Maggie, la más pequeña, es un bebé que todavía no habla, pero que juega un importante papel.",
                    "trailer" to "simpsons"
                )
            }

            "friends" -> {
                datos = mapOf(
                    "foto" to "@drawable/friends",
                    "sinopsis" to "\"Friends\" narra las aventuras y desventuras de seis jóvenes de Nueva York. Rachel (Jennifer Aniston), Monica (Courteney Cox), Phoebe (Lisa Kudrow), Ross (David Schwimmer), Chandler (Matthew Perry) y Joey (Matt LeBlanc) " +
                            "forman una unida pandilla de amigos que viven en Manhattan y que suelen reunirse en sus apartamentos o en su bar habitual, el Central Perk. A pesar de los numerosos cambios que se producen en sus vidas, su amistad es inquebrantable en la dura batalla por salir adelante en sus periplos profesionales y personales.",
                    "trailer" to "friends"
                )
            }

            "lucifer" -> {
                datos = mapOf(
                    "foto" to "@drawable/lucifer",
                    "sinopsis" to "La historia de Lucifer es la que todos conocemos: un ángel caído del cielo. Sin embargo, este señor del infierno está aburrido de su propia existencia. Por ello, Lucifer decide abandonar su reino e ir a la ciudad de Los Ángeles a descubrir qué puede ofrecerle el mundo mortal.\n" +
                            "En su búsqueda de \"qué hacer con su tiempo\" decide abrir un distinguido club nocturno, llamado Lux, y se dedica a disfrutar de sus cosas favoritas: el vino, las mujeres y la música. Sin embargo, su apacible vida se ve alterada cuando una mujer es brutalmente asesinada cerca de su club. " +
                            "De repente, siente que debe hacerse justicia y por ello comienza a ayudar a la policía a intentar resolver diversos casos de homicidios, convirtiéndose así en una especie de colaborador.",
                    "trailer" to "lucifer"
                )
            }
            else->{
                datos = mapOf(
                    "foto" to "R.drawable.logoojotachado",
                    "sinopsis" to "Error...",
                    "trailer" to ""
                )
            }
        }
        return datos
    }
}