<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Peliculas extends Model
{
    protected $fillable = [
        'nombre',
        'genero',
        'duracion',
        'descripcion',
    ];
}
