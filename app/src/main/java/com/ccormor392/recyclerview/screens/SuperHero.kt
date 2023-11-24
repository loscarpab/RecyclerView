package com.ccormor392.recyclerview.screens


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ccormor392.recyclerview.R
import com.ccormor392.recyclerview.Superhero


fun getSuperHeroes():MutableList<Superhero>{
    val list = mutableListOf<Superhero>()
    val spiderman = Superhero("Spiderman", "Petter Parker", "Marvel", R.drawable.spiderman)
    val wolve = Superhero("Wolverine", "James Howlett", "Marvel", R.drawable.logan)
    val batman = Superhero("Batman", "Bruce Wayne", "DC", R.drawable.batman)
    val thor = Superhero("Thor", "Thor Odinson", "Marvel", R.drawable.thor)
    val flash = Superhero("Flash", "Jay Garrick", "DC", R.drawable.flash)
    val greenLantern = Superhero("Green Lantern", "Alan Scott", "DC", R.drawable.green_lantern)
    val wonderWoman = Superhero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman)

    list.add(spiderman)
    list.add(wolve)
    list.add(batman)
    list.add(thor)
    list.add(flash)
    list.add(greenLantern)
    list.add(wonderWoman)

    return list
}
@Preview
@Composable
fun SuperHeroView(){
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHeroes()) { superhero ->
            ItemHero(superhero = superhero)
        }
    }

}
@Composable
fun ItemHero(superhero: Superhero){
    Card(border = BorderStroke(2.dp, Color.Red), modifier = Modifier.width(200.dp)) {
        Image(
            painter = painterResource(id = superhero.photo),
            contentDescription = "SuperHero Avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        TextoCard(cadenaAEscribir = superhero.superheroName)
        TextoCard(cadenaAEscribir = superhero.realName)
        TextoCard(cadenaAEscribir = superhero.publisher, TextAlign.End, 10)
    }
}
@Composable
fun TextoCard(cadenaAEscribir:String, alineacion:TextAlign = TextAlign.Center, paddingEnd:Int = 0){
    Text(text = cadenaAEscribir,
        modifier = Modifier.fillMaxWidth(),
        textAlign = alineacion)
}
