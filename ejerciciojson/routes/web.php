<?php

use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return "hola";
});

Route::get('peliculas', function () {
    return App\Models\Peliculas::all();
});

Route::get('añadirPelicula', function () {
//     App\Models\Peliculas::create([
//         'nombre' => 'Star Wars: La venganza de los Sith',
//         'genero' => 'Ciencia Ficción',
//         'duracion' => 139,
//         'descripcion' => '¡Guerra! La República se desmorona bajo los ataques del despiadado Lord Sith, el conde Dooku. Hay héroes en ambos bandos, pero el mal está por doquier. Los Jedi luchan por mantener la paz y la justicia en la galaxia, pero se enfrentan a una amenaza que podría destruirlos a todos. Mientras tanto, el joven Anakin Skywalker, un talentoso piloto y guerrero Jedi, comienza a ser seducido por el lado oscuro de la Fuerza.',
//     ]);
    
//     App\Models\Peliculas::create([
//         'nombre' => 'Star Wars: El Imperio Contraataca',
//         'genero' => 'Ciencia Ficción',
//         'duracion' => 124,
//         'descripcion' => 'Después de la destrucción de la Estrella de la Muerte, las fuerzas rebeldes están en fuga. El Imperio, liderado por Darth Vader, está decidido a aplastar la rebelión de una vez por todas. Mientras tanto, Luke Skywalker continúa su entrenamiento Jedi con el maestro Yoda, enfrentándose a desafíos que pondrán a prueba su coraje y determinación.',
//     ])
// ;
//     App\Models\Peliculas::create([
//         'nombre' => 'Star Wars: Una Nueva Esperanza',
//         'genero' => 'Ciencia Ficción',
//         'duracion' => 121,
//         'descripcion' => 'En una galaxia muy, muy lejana, la Princesa Leia es capturada por el malvado Darth Vader mientras intenta entregar los planos secretos de la Estrella de la Muerte a la Alianza Rebelde. Con la ayuda del joven granjero Luke Skywalker, el contrabandista Han Solo y los droides R2-D2 y C-3PO, emprenden una misión para rescatar a la princesa y derrotar al Imperio.',
//     ]);
//     App\Models\Peliculas::create([
//         'nombre' => 'Star Wars: El Retorno del Jedi',
//         'genero' => 'Ciencia Ficción',
//         'duracion' => 131,
//         'descripcion' => 'Luke Skywalker regresa para enfrentarse a Darth Vader y al Emperador Palpatine en un intento por salvar a la galaxia. Mientras tanto, la Alianza Rebelde lanza un ataque final contra la segunda Estrella de la Muerte, con la ayuda de los valientes Ewoks del planeta Endor.',
//     ]);
//     App\Models\Peliculas::create([
//         'nombre' => 'Star Wars: El Despertar de la Fuerza',
//         'genero' => 'Ciencia Ficción',
//         'duracion' => 138,
//         'descripcion' => 'Décadas después de la caída del Imperio, una nueva amenaza emerge en la forma de la Primera Orden. Una joven chatarrera llamada Rey descubre que tiene una conexión con la Fuerza mientras busca a Luke Skywalker, el último Jedi desaparecido. Con la ayuda del ex-stormtrooper Finn y el piloto Poe Dameron, Rey se une a la Resistencia para enfrentarse a la Primera Orden y descubrir su verdadero destino.',
//     ]);
//     App\Models\Peliculas::create([
//         'nombre' => 'Star Wars: Los Últimos Jedi',
//         'genero' => 'Ciencia Ficción',
//         'duracion' => 152,
//         'descripcion' => 'Rey continúa su entrenamiento con Luke Skywalker mientras la Resistencia lucha por sobrevivir contra la Primera Orden. A medida que los secretos del pasado se revelan, Rey debe confrontar sus propios miedos y dudas para convertirse en la heroína que la galaxia necesita.',
//     ]);
//     return App\Models\Peliculas::all();
});
